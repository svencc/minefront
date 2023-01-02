package cc.sven.hexwarriorproton.minefront.engine.graphics.render;

import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.BaseDrawable;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;

public class DefaultRenderer extends BaseRenderer {

    public DefaultRenderer(@NonNull ResolutionProperties resolution) {
        super(resolution);
    }

    @Override
    public void draw(@NonNull BaseDrawable drawable, @NonNull Renderable renderTo, int xOffset, int yOffset) {
        super.draw(drawable, renderTo, xOffset, yOffset);
    }

}
