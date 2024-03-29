package cc.sven.hexwarriorproton.minefront.engine.components;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import lombok.NonNull;

public interface Mergeable {

    void mergeBufferWith(@NonNull final PixelBuffer targetBuffer, final int offsetX, final int offsetY);

    void mergeBufferWith(@NonNull final Bufferable targetBuffer, final int offsetX, final int offsetY);

    void prepareBuffer();

    void disposeBuffer();
    
}
