package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.units.TimeTick;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScreenRasterizer extends Renderer {

    private Renderer testRenderer;
    private Renderer3D testRenderer3D;

    public ScreenRasterizer(@NonNull ResolutionProperties resolutionProperties) {
        super(resolutionProperties);
        final Random random = new Random();
        testRenderer = new Renderer(ResolutionProperties.builder().width(256).height(256).build());
        testRenderer3D = new Renderer3D(resolutionProperties);
        for (int i = 0; i < 256 * 256; i++) {
            testRenderer.pixelRaster[i] = random.nextInt() * (random.nextInt(5) / 4);
        }
    }


    public void rasterize(@NonNull TimeTick timeTick) {
        clearScreen();
//        for (int i = 0; i < 5; i++) {
//            int anim = (int) (Math.sin(tick.getTime() + i) * 10);
//            int anim2 = (int) (Math.cos(+i) * 100);
//        }

        testRenderer3D.renderFloor(timeTick);
        draw(testRenderer3D, 0, 0);
    }

    private void clearScreen() {
        for (int i = 0; i < pixelRaster.length; i++) {
            pixelRaster[i] = 0;
        }
    }

    public void rasterize2d(@NonNull TimeTick timeTick) {
        clearScreen();
        for (int i = 0; i < 5; i++) {
            int anim = (int) (Math.sin(timeTick.getTime() + i) * 10);
            int anim2 = (int) (Math.cos(+i) * 100);

            draw(testRenderer, (resolution.getWidth() - 256) / 2 + anim, (resolution.getHeight() - 256) / 2 + anim2);
            //        draw(test, 0, 0);
        }
    }

}
