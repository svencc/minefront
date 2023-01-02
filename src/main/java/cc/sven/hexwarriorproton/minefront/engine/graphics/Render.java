package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;

public class Render {

    @NonNull
    protected final ResolutionProperties resolution;
    protected int[] pixelRaster;

    public Render(@NonNull ResolutionProperties resolution) {
        this.resolution = resolution;
        initialize();
    }

    public void initialize() {
        pixelRaster = new int[resolution.getWidth() * resolution.getHeight()];
    }

    public void draw(@NonNull Render render, int xOffset, int yOffset) {
        for (int y = 0; y < render.resolution.getHeight(); y++) {
            int yPixel = y + yOffset;
            for (int x = 0; x < render.resolution.getWidth(); x++) {
                int xPixel = x + xOffset;
                setPixelAt(
                        xPixel, yPixel, resolution.getWidth(),
                        render.getPixelAt(x, y, render.resolution.getWidth())
                );
            }
        }
    }

    private void setPixelAt(int x, int y, int width, int newPixelValue) {
        this.pixelRaster[x + y * width] = newPixelValue;
    }

    public int getPixelAt(int x, int y, int width) {
        return pixelRaster[x + y * width];
    }

    public int getPixel(int nr) {
        return pixelRaster[nr];
    }
}
