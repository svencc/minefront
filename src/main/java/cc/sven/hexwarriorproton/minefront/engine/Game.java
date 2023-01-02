package cc.sven.hexwarriorproton.minefront.engine;

import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenRaster;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import cc.sven.hexwarriorproton.minefront.service.profiler.Profiler;
import cc.sven.hexwarriorproton.minefront.service.profiler.ProfilerProvider;
import cc.sven.hexwarriorproton.minefront.strategy.SetJFrameTitleStrategy;
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
public class Game extends Canvas implements Runnable {

    @NonNull
    public static String GAMELOOP_THREAD_NAME = "GLoop";


    @NonNull
    private final ResolutionProperties resolutionProperties;
    @NonNull
    private final ProfilerProvider profilerProvider;
    @NonNull
    private final Ticker ticker;
    @NonNull
    private final ScreenRaster screenRaster;


    @Nullable
    private BufferedImage bufferedImage;
    private int[] bufferedImagePixelRaster;
    @Nullable
    private Thread gameLoopThread;
    @Nullable
    private SetJFrameTitleStrategy setJFrameTitleStrategy;
    private boolean running = false;


    public synchronized void start(@NonNull SetJFrameTitleStrategy setJFrameTitleStrategy) {
        this.setJFrameTitleStrategy = setJFrameTitleStrategy;

        this.bufferedImage = new BufferedImage(resolutionProperties.getWidth(), resolutionProperties.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.bufferedImagePixelRaster = ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData();

        running = true;
        gameLoopThread = new Thread(this, GAMELOOP_THREAD_NAME);
        gameLoopThread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            gameLoopThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void run() {
        requestFocus();
        final Profiler profiler = profilerProvider.provide("Loop");
        while (running) {
            profiler.startNextMeasurement();

            ticker.tick();
            this.RenderRasterToCanvas();

            profiler.measure();

//            setJFrameTitleStrategy.execute(metaProperties.getName() + " " + profiler.stringifyResult());
        }
    }

    private void RenderRasterToCanvas() {
        final BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }

//        ScreenRaster.clear();
        screenRaster.rasterize();
        copyBufferFromRendererToCanvas();

        final Graphics graphicsContext = bufferStrategy.getDrawGraphics();
        graphicsContext.drawImage(bufferedImage, 0, 0, resolutionProperties.getWidth(), resolutionProperties.getHeight(), null);
        graphicsContext.dispose();
        bufferStrategy.show();
    }

    private void copyBufferFromRendererToCanvas() {
        for (int i = 0; i < resolutionProperties.getWidth() * resolutionProperties.getHeight(); i++) {
            bufferedImagePixelRaster[i] = screenRaster.getPixel(i);
        }
    }

}
