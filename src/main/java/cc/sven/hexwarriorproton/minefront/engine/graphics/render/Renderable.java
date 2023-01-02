package cc.sven.hexwarriorproton.minefront.engine.graphics.render;

import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.BaseDrawable;
import lombok.NonNull;

public interface Renderable {

    void draw(@NonNull BaseDrawable drawable, @NonNull Renderable renderTo, int xOffset, int yOffset);

    void setPixelAt(@NonNull Renderable renderTo, int x, int y, int width, int newPixelValue);

}
