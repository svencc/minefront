package cc.sven.hexwarriorproton.minefront.engine.graphics.xthreeD;

import cc.sven.hexwarriorproton.minefront.engine.units.StopWatch;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component
public class ScreenRasterizer3D extends Renderer3DBase {

    private Renderer3DBase testRenderer3DBase;
    private Renderer3D testRenderer3D;

    public ScreenRasterizer3D(@NonNull ResolutionProperties resolutionProperties) {
        super(resolutionProperties);
        final Random random = new Random();
        testRenderer3DBase = new Renderer3DBase(ResolutionProperties.builder().width(256).height(256).build());
        testRenderer3D = new Renderer3D(resolutionProperties);
        for (int i = 0; i < 128 * 128; i++) {
            testRenderer3DBase.pixelRaster[i] = random.nextInt() * (random.nextInt(5) / 4);
        }
    }


    public void rasterize(@NonNull StopWatch stopWatch) {
        clearScreen();
//        for (int i = 0; i < 5; i++) {
//            int anim = (int) (Math.sin(tick.getTime() + i) * 10);
//            int anim2 = (int) (Math.cos(+i) * 100);
//        }

        testRenderer3D.renderFloor(stopWatch);
        draw(testRenderer3D, 0, 0);
    }

    private void clearScreen() {
        for (int i = 0; i < pixelRaster.length; i++) {
            pixelRaster[i] = 0;
        }
    }

    public void rasterize2d(@NonNull StopWatch stopWatch) {
        clearScreen();
        for (int i = 0; i < 5; i++) {
            int anim = (int) (Math.sin(stopWatch.getTime() + i) * 10);
            int anim2 = (int) (Math.cos(+i) * 100);

            draw(testRenderer3DBase, (resolution.getWidth() - 256) / 2 + anim, (resolution.getHeight() - 256) / 2 + anim2);
            //        draw(test, 0, 0);
        }
    }

}
