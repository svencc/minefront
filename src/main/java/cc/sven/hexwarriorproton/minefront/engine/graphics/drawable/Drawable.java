package cc.sven.hexwarriorproton.minefront.engine.graphics.drawable;

import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;

public interface Drawable {

    PixelDimension getDimension();

    int getPixelAt(int x, int y, int width);

    int getPixelAtIndex(int nr);

}
