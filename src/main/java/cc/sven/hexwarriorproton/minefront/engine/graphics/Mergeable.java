package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import lombok.NonNull;

public interface Mergeable {

    void mergeBufferWith(@NonNull PixelBuffer targetBuffer, int offsetX, int offsetY);

    void mergeBufferWith(@NonNull Bufferable targetBuffer, int offsetX, int offsetY);

    void prepareBuffer();

    void disposeBuffer();
    
}
