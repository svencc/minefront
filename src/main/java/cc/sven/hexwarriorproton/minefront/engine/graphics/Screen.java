package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.BaseDrawable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.NoiseDrawable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.BaseRenderer;
import cc.sven.hexwarriorproton.minefront.engine.units.StopWatch;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class Screen extends BaseRenderer implements Rasterizable {

    private BaseDrawable testDrawable;

    public Screen(@NonNull ResolutionProperties resolutionProperties) {
        super(resolutionProperties);
        testDrawable = new NoiseDrawable(resolutionProperties.getWidth(), resolutionProperties.getHeight());
    }

    @Override
    public void rasterize(@NonNull StopWatch stopWatch) {
        clearScreen();
        draw(testDrawable, 0, 0);
    }

    private void clearScreen() {
        for (int i = 0; i < pixelRaster.length; i++) {
            pixelRaster[i] = 0;
        }
    }

}
