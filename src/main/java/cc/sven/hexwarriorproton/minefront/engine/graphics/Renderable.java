package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import lombok.NonNull;

public interface Renderable {

    void render(@NonNull PixelBuffer sourceBuffer, @NonNull PixelBuffer targetBuffer, int xOffset, int yOffset);

    void render(@NonNull Scanable sourceScanable, @NonNull Bufferable targetBuffer, int xOffset, int yOffset);

    void renderMergeable(@NonNull Mergeable source, @NonNull PixelBuffer targetBuffer, int xOffset, int yOffset);

    void renderMergeable(@NonNull Mergeable source, @NonNull Bufferable target, int xOffset, int yOffset);

    void setPixelAt(@NonNull Bufferable target, int x, int y, int newPixelValue);


}
