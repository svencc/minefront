package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;

public interface Bufferable {

    PixelDimension getDimension();

    void bufferPixelAt(final int x, final int y, final int newPixelValue);

    void bufferPixelAtIndex(final int index, final int newPixelValue);

    void clearBuffer();

    void fillBuffer(final int value);

}
