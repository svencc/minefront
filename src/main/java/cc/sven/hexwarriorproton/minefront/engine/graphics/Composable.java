package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import lombok.NonNull;

public interface Composable {

    int compose();
    @NonNull
    PixelBuffer getBackPixelBuffer(int index);

}