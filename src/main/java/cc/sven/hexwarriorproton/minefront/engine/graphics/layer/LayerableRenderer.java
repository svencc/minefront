package cc.sven.hexwarriorproton.minefront.engine.graphics.layer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.render.Renderable;
import lombok.NonNull;

public interface LayerableRenderer {

    void render(@NonNull Renderable renderTo, int xOffset, int yOffset);

}
