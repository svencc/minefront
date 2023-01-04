package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import lombok.NonNull;

public interface Mergeable {

    void mergeWith(@NonNull PixelBuffer target, int offsetX, int offsetY);
    void mergeWith(@NonNull Bufferable target, int offsetX, int offsetY);

}
