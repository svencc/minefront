package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import lombok.NonNull;

public interface Renderable {

    void render(@NonNull PixelBuffer scannable, @NonNull PixelBuffer renderTo, int xOffset, int yOffset);

    void render(@NonNull Scannable scannable, @NonNull Bufferable renderTo, int xOffset, int yOffset);

    void setPixelAt(@NonNull Bufferable renderTo, int x, int y, int newPixelValue);


}
