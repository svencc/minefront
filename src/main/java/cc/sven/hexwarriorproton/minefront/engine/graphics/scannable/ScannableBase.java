package cc.sven.hexwarriorproton.minefront.engine.graphics.scannable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Scannable;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;

public abstract class ScannableBase implements Scannable {

    @Getter
    @NonNull
    protected final PixelDimension dimension;
    protected int[] pixelRaster;

    public ScannableBase(PixelDimension dimension) {
        this.dimension = dimension;
        this.pixelRaster = new int[dimension.getWidthX() * dimension.getHeightY()];
    }

    @Override
    public int scanPixelAt(int x, int y) {
        return this.pixelRaster[x + y * dimension.getWidthX()];
    }

    @Override
    public int scanPixelAtIndex(int index) {
        return pixelRaster[index];
    }

    public int[] accessPixelBuffer() {
        return pixelRaster;
    }

}
