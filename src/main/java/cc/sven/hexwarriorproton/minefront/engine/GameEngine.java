package cc.sven.hexwarriorproton.minefront.engine;

import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenRasterizer;
import cc.sven.hexwarriorproton.minefront.property.MetaProperties;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import cc.sven.hexwarriorproton.minefront.service.profiler.*;
import cc.sven.hexwarriorproton.minefront.service.tick.TickCalculator;
import cc.sven.hexwarriorproton.minefront.service.tick.TickerService;
import cc.sven.hexwarriorproton.minefront.strategy.SetJFrameTitleStrategy;
import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

@Component
@RequiredArgsConstructor
public class GameEngine extends Canvas implements Runnable {

    @NonNull
    public static String GAMELOOP_THREAD_NAME = "GLoop";
    @NonNull
    private final ResolutionProperties resolutionProperties;
    @NonNull
    private final MetaProperties metaProperties;
    @NonNull
    private final ProfilerProvider profilerProvider;
    @NonNull
    private final FPSCounterProvider fpsCounterProvider;
    @NonNull
    private final TPSCounterProvider tpsCounterProvider;
    @NonNull
    private final TickCalculator tickCalculator;
    @NonNull
    private final TickerService tickerService;
    @NonNull
    private final ScreenRasterizer screenRasterizer;
    @NonNull
    private final AbstractGame game;
    @Nullable
    private BufferedImage bufferedImage;
    private int[] bufferedImagePixelRaster;
    @Nullable
    private Thread gameLoopThread;
    @Nullable
    private SetJFrameTitleStrategy setJFrameTitleStrategy;
    private boolean running = false;

    @PostConstruct
    public void init() {
        final Dimension canvasSize = new Dimension(
                resolutionProperties.getScaledWidth(),
                resolutionProperties.getScaledHeight()
        );
        setSize(canvasSize);
        setPreferredSize(canvasSize);
        setMinimumSize(canvasSize);
        setIgnoreRepaint(true);
    }

    public synchronized void start(@NonNull SetJFrameTitleStrategy setJFrameTitleStrategy) {
        this.setJFrameTitleStrategy = setJFrameTitleStrategy;

        this.bufferedImage = new BufferedImage(resolutionProperties.getWidth(), resolutionProperties.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.bufferedImagePixelRaster = ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData();

        running = true;
        gameLoopThread = new Thread(this, GAMELOOP_THREAD_NAME);
        game.run();
        gameLoopThread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            gameLoopThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }

    @Override
    public void run() {
        requestFocus();
        final Profiler loopProfiler = profilerProvider.provide("Loop");
        final FPSCounter fpsCounter = fpsCounterProvider.provide();
        final TPSCounter tpsCounter = tpsCounterProvider.provide();
        fpsCounter.startProfiling();
        double tickThresholdRatio = 0;

        while (running) {
            loopProfiler.startNextMeasurement();
            tickThresholdRatio += tickCalculator.calculateTickThresholdRatio(loopProfiler.getProfiledNanos());

            while (tickThresholdRatio >= 1.0) {
                tickerService.tick();
                tpsCounter.countTick();
                tickThresholdRatio--;
            }

            this.renderRasterToCanvas();
            fpsCounter.countFrame();

            loopProfiler.measure();

            if (fpsCounter.oneSecondPassed()) {
                setJFrameTitleStrategy.execute(metaProperties.getName() + " | " + tpsCounter.profileTicksPerSecond() + " | " + fpsCounter.profileFramesPerSecond() + " | " + loopProfiler.stringifyResult());
            }
        }
    }

    private void renderRasterToCanvas() {
        final BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }

        screenRasterizer.rasterize();
        copyBufferFromRendererToCanvas();

        final Graphics graphicsContext = bufferStrategy.getDrawGraphics();
        graphicsContext.drawImage(bufferedImage, 0, 0, resolutionProperties.getScaledWidth(), resolutionProperties.getScaledWidth(), null);
        graphicsContext.dispose();
        bufferStrategy.show();
    }

    private void copyBufferFromRendererToCanvas() {
        for (int i = 0; i < resolutionProperties.getWidth() * resolutionProperties.getHeight(); i++) {
            bufferedImagePixelRaster[i] = screenRasterizer.scanPixelAtIndex(i);
//            bufferedImagePixelRaster[i] = screenRasterizer.accessPixelBuffer()[i];
        }
    }

}
