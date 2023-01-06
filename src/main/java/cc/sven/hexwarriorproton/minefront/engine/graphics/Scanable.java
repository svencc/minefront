package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;

public interface Scanable {

    PixelDimension getDimension();

    int scanPixelAt(final int x, final int y);

    int scanPixelAtIndex(final int index);

}
