package cc.sven.hexwarriorproton.minefront.engine;

import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenComposer;
import cc.sven.hexwarriorproton.minefront.property.MetaProperties;
import cc.sven.hexwarriorproton.minefront.property.RendererProperties;
import cc.sven.hexwarriorproton.minefront.service.profiler.FPSCounter;
import cc.sven.hexwarriorproton.minefront.service.profiler.Profiler;
import cc.sven.hexwarriorproton.minefront.service.profiler.ProfilerProvider;
import cc.sven.hexwarriorproton.minefront.service.profiler.TPSCounter;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
public class GameLoop extends Canvas implements Runnable {

    @NonNull
    public static String GAMELOOP_THREAD_NAME = "GLoop";
    @NonNull
    private final RendererProperties rendererProperties;
    @NonNull
    private final MetaProperties metaProperties;
    @NonNull
    private final ProfilerProvider profilerProvider;
    @NonNull
    private final TickCalculator tickCalculator;
    @NonNull
    private final TickerService tickerService;
    @NonNull
    private final ScreenComposer screenComposer;
    @NonNull
    private final GameTemplate game;
    @Nullable
    private BufferedImage bufferedImage;
    private int[] bufferedImagePixelRaster;
    @Nullable
    private Thread gameLoopThread;
    @Nullable
    private ExecutorService backBufferExecuter;
    @Nullable
    private SetJFrameTitleStrategy setJFrameTitleStrategy;
    private boolean running = false;

    @PostConstruct
    public void postConstruct() {
        final Dimension canvasSize = new Dimension(rendererProperties.getScaledWidth(), rendererProperties.getScaledHeight());
        setSize(canvasSize);
        setPreferredSize(canvasSize);
        setMinimumSize(canvasSize);
        setMaximumSize(canvasSize);
        setIgnoreRepaint(true);

        if (rendererProperties.getComposer().isParallelizedBackBufferHandler()) {
            backBufferExecuter = Executors.newFixedThreadPool(1);
        }

    }

    public synchronized void start(@NonNull final SetJFrameTitleStrategy setJFrameTitleStrategy) {
        this.setJFrameTitleStrategy = setJFrameTitleStrategy;

        bufferedImage = new BufferedImage(rendererProperties.getWidth(), rendererProperties.getHeight(), BufferedImage.TYPE_INT_RGB);
        bufferedImagePixelRaster = ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData();

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
        final FPSCounter fpsCounter = profilerProvider.provideFPSCounter();
        final TPSCounter tpsCounter = profilerProvider.provideTPSCounter();
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

            this.composeGraphics();
            fpsCounter.countFrame();

            loopProfiler.measure();

            if (fpsCounter.oneSecondPassed()) {
                setJFrameTitleStrategy.execute(metaProperties.getName() + " | " + tpsCounter.profileTicksPerSecond() + " | " + fpsCounter.profileFramesPerSecond() + " | " + loopProfiler.stringifyResult());
            }
        }
    }

    private void composeGraphics() {
        if (rendererProperties.getComposer().isParallelizedBackBufferHandler()) {
            // @TODO -> das sind Strategies!
            composeGraphicsMultithreaded();
        } else {
            // @TODO -> das sind Strategies!
            composeGraphicsSinglethreaded();
        }
    }

    private void composeGraphicsMultithreaded() {
        final BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) { // @TODO Null check teurer als boolean check?
            createBufferStrategy(3);
            return;
        }

        // Show LAST image in composer buffer
        final Graphics graphicsContext = bufferStrategy.getDrawGraphics();
        graphicsContext.drawImage(bufferedImage, 0, 0, rendererProperties.getScaledWidth(), rendererProperties.getScaledHeight(), null);
        graphicsContext.dispose();
        bufferStrategy.show();

        // Render NEXT frame in buffer
        final int backBufferIndex = screenComposer.compose();

        // Copy NEXT composer image to canvas buffer for showing up in NEXT iteration
        backBufferExecuter.execute(() -> {
            copyComposedBackBufferToCanvasFrontBuffer(backBufferIndex);
        });
    }

    private void composeGraphicsSinglethreaded() {
        final BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) { // @TODO Null check teurer als boolean check?
            createBufferStrategy(3);
            return;
        }

        final int backBufferIndex = screenComposer.compose();
        copyComposedBackBufferToCanvasFrontBuffer(backBufferIndex);

        final Graphics graphicsContext = bufferStrategy.getDrawGraphics();
        graphicsContext.drawImage(bufferedImage, 0, 0, rendererProperties.getScaledWidth(), rendererProperties.getScaledHeight(), null);
        graphicsContext.dispose();
        bufferStrategy.show();
    }

    private void copyComposedBackBufferToCanvasFrontBuffer(int backBufferIndex) {
        System.arraycopy(screenComposer.getBackPixelBuffer(backBufferIndex).directBufferAccess(), 0, bufferedImagePixelRaster, 0, screenComposer.getBackPixelBuffer(backBufferIndex).getBufferSize() - 1);
    }

}
