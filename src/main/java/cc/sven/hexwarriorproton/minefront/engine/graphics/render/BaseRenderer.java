package cc.sven.hexwarriorproton.minefront.engine.graphics.render;

import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.BaseDrawable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.Drawable;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;

public class BaseRenderer implements Drawable, Renderable {

    @NonNull
    protected final ResolutionProperties resolution;
    public int[] pixelRaster;

    public BaseRenderer(@NonNull ResolutionProperties resolution) {
        this.resolution = resolution;
        initialize();
    }

    public void initialize() {
        pixelRaster = new int[resolution.getWidth() * resolution.getHeight()];
    }

    public void draw(@NonNull BaseDrawable drawable, int xOffset, int yOffset) {
        for (int y = 0; y < drawable.getDimension().getHeight(); y++) {
            int yPixel = y + yOffset;
            if (yPixel < 0 || yPixel >= resolution.getHeight()) continue;

            for (int x = 0; x < drawable.getDimension().getWidth(); x++) {
                int xPixel = x + xOffset;
                if (xPixel < 0 || xPixel >= resolution.getWidth()) continue;

                int colorValue = drawable.getPixelAt(x, y, drawable.getDimension().getWidth());
                if (colorValue > 0) {
                    setPixelAt(
                            xPixel, yPixel, resolution.getWidth(),
                            drawable.getPixelAt(x, y, drawable.getDimension().getWidth())
                    );
                }
            }
        }
    }

    private void setPixelAt(int x, int y, int width, int newPixelValue) {
        this.pixelRaster[x + y * width] = newPixelValue;
    }

    public int getPixelAt(int x, int y, int width) {
        return pixelRaster[x + y * width];
    }

    public int getPixelAtIndex(int nr) {
        return pixelRaster[nr];
    }

}
