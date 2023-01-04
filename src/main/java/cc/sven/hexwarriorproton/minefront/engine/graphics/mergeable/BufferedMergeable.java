package cc.sven.hexwarriorproton.minefront.engine.graphics.mergeable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.*;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.NonNull;


public class BufferedMergeable extends PixelBuffer implements Bufferable, Scannable, Mergeable {

    public BufferedMergeable(@NonNull PixelDimension dimension) {
        super(dimension);
    }

    @Override
    public void mergeWith(@NonNull PixelBuffer pixelBuffer, int offsetX, int offsetY) {

    }

}
