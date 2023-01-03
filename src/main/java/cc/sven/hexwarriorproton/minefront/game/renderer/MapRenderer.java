package cc.sven.hexwarriorproton.minefront.game.renderer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.Drawable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.BaseRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.Renderable;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MapRenderer extends BaseRenderer {

    public MapRenderer(@NonNull ResolutionProperties resolution) {
        super(resolution);
    }

    @Override
    public void draw(@NonNull Drawable drawable, @NonNull Renderable renderTo, int xOffset, int yOffset) {
        super.draw(drawable, renderTo, xOffset, yOffset);
    }

}
