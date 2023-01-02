package cc.sven.hexwarriorproton.minefront.engine.graphics.drawable;

import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;

public abstract class BaseDrawable {

    @Getter
    @NonNull
    protected final PixelDimension dimension;
    protected int[] pixelRaster;

    public BaseDrawable(int width, int height) {
        this.dimension = PixelDimension.builder().width(width).height(height).build();
        this.pixelRaster = new int[width * height];
    }

    public BaseDrawable(PixelDimension dimension) {
        this.dimension = dimension;
        this.pixelRaster = new int[dimension.getWidth() * dimension.getHeight()];
    }

    public int getPixelAt(int x, int y, int width) {
        return this.pixelRaster[x + y * width];
    }

    public int getPixelAtIndex(int nr) {
        return pixelRaster[nr];
    }

}
