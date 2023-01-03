package cc.sven.hexwarriorproton.minefront.engine.graphics.drawable;

import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;

public abstract class BaseDrawable implements Drawable {

    @Getter
    @NonNull
    private final PixelDimension dimension;
    protected int[] pixelRaster;

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
