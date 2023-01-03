package cc.sven.hexwarriorproton.minefront.engine.graphics;

import lombok.NonNull;

public interface RenderableLayer {

    void renderLayer(@NonNull Bufferable renderTo, int xOffset, int yOffset);

}
