package cc.sven.hexwarriorproton.minefront.engine.graphics.render;

import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.BaseDrawable;
import lombok.NonNull;

public interface Renderable {

    void draw(@NonNull BaseDrawable drawable, int xOffset, int yOffset);

}
