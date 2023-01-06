package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import lombok.NonNull;

public interface Renderable {

    void render(@NonNull final Scanable sourceScanable, @NonNull final Bufferable targetBuffer, final int xOffset, final int yOffset);

    void renderMergeable(@NonNull final Mergeable source, @NonNull final PixelBuffer targetBuffer, final int xOffset, final int yOffset);

    void renderMergeable(@NonNull final Mergeable source, @NonNull final Bufferable target, final int xOffset, final int yOffset);

    void setPixelAt(@NonNull final Bufferable target, final int x, final int y, final int newPixelValue);

}
