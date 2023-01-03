package cc.sven.hexwarriorproton.minefront.engine.graphics.render;

import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.Drawable;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.Getter;
import lombok.NonNull;

public abstract class BaseRenderer implements Renderable {

    @Getter
    @NonNull
    private final ResolutionProperties resolution;

    public BaseRenderer(@NonNull ResolutionProperties resolution) {
        this.resolution = resolution;
    }

    public void draw(@NonNull Drawable drawable, @NonNull Renderable renderTo, int xOffset, int yOffset) {
        for (int y = 0; y < drawable.getDimension().getHeight(); y++) {
            int yPixel = y + yOffset;
            if (yPixel < 0 || yPixel >= resolution.getHeight()) continue;

            for (int x = 0; x < drawable.getDimension().getWidth(); x++) {
                int xPixel = x + xOffset;
                if (xPixel < 0 || xPixel >= resolution.getWidth()) continue;

                int colorValue = drawable.getPixelAt(x, y, drawable.getDimension().getWidth());
                if (colorValue > 0) {
                    setPixelAt(
                            renderTo,
                            xPixel, yPixel, resolution.getWidth(),
                            drawable.getPixelAt(x, y, drawable.getDimension().getWidth())
                    );
                }
            }
        }
    }

    public void setPixelAt(@NonNull Renderable renderTo, int x, int y, int width, int newPixelValue) {
        renderTo.setPixelAt(renderTo, x, y, width, newPixelValue);
    }

}
