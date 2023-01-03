package cc.sven.hexwarriorproton.minefront.engine.graphics;

import lombok.NonNull;

public interface Renderable {

    void render(@NonNull Scannable scannable, @NonNull Bufferable renderTo, int xOffset, int yOffset);

    void setPixelAt(@NonNull Bufferable renderTo, int x, int y, int newPixelValue);


}
