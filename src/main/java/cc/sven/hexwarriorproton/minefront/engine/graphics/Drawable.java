package cc.sven.hexwarriorproton.minefront.engine.graphics;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Drawable {

    private int width;
    private int height;
    private int[] pixelRaster;

    public Drawable(int width, int height) {
        this.pixelRaster = new int[width * height];
    }

    public int getPixelAt(int x, int y, int width) {
        return this.pixelRaster[x + y * width];
    }

}
