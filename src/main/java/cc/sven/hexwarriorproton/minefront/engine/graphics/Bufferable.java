package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;

public interface Bufferable {

    PixelDimension getDimension();

    void bufferPixelAt(int x, int y, int newPixelValue);

    void bufferPixelAtIndex(int index, int newPixelValue);

    void clearBuffer();

    void fillBuffer(int value);

    int[] accessPixelBuffer();

}
