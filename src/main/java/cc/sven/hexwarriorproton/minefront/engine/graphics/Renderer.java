package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;

public class Renderer {

    @NonNull
    protected final ResolutionProperties resolution;
    public int[] pixelRaster;

    public Renderer(@NonNull ResolutionProperties resolution) {
        this.resolution = resolution;
        initialize();
    }

    public void initialize() {
        pixelRaster = new int[resolution.getWidth() * resolution.getHeight()];
    }

    public void draw(@NonNull Renderer renderer, int xOffset, int yOffset) {
        for (int y = 0; y < renderer.resolution.getHeight(); y++) {
            int yPixel = y + yOffset;
            if (yPixel < 0 || yPixel >= resolution.getHeight()) continue;

            for (int x = 0; x < renderer.resolution.getWidth(); x++) {
                int xPixel = x + xOffset;
                if (xPixel < 0 || xPixel >= resolution.getWidth()) continue;

                int colorValue = renderer.getPixelAt(x, y, renderer.resolution.getWidth());
                if (colorValue > 0) {
                    setPixelAt(
                            xPixel, yPixel, resolution.getWidth(),
                            renderer.getPixelAt(x, y, renderer.resolution.getWidth())
                    );
                }
            }
        }
    }

    public int getPixelAt(int x, int y, int width) {
        return pixelRaster[x + y * width];
    }

    private void setPixelAt(int x, int y, int width, int newPixelValue) {
        this.pixelRaster[x + y * width] = newPixelValue;
    }

    public int getPixelAtIndex(int nr) {
        return pixelRaster[nr];
    }

}
