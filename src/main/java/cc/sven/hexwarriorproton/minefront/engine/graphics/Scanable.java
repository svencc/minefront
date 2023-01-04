package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;

public interface Scanable {

    PixelDimension getDimension();

    int scanPixelAt(int x, int y);

    int scanPixelAtIndex(int index);

}
