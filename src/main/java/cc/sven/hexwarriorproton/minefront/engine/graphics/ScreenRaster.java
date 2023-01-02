package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScreenRaster extends Render {

    private Render test;

    public ScreenRaster(@NonNull ResolutionProperties resolutionProperties) {
        super(resolutionProperties);
        final Random random = new Random();
        test = new Render(ResolutionProperties.builder().width(256).height(256).build());
        for (int i = 0; i < 256 * 256; i++) {
            test.pixelRaster[i] = random.nextInt();
        }
    }

    public void rasterize() {
        draw(test, 0, 0);
    }

    public void clear() {
        for (int i = 0; i < pixelRaster.length; i++) {
            pixelRaster[i] = 0;
        }
    }

}
