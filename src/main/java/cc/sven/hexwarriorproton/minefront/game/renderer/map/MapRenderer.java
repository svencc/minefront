package cc.sven.hexwarriorproton.minefront.game.renderer.map;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Scannable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.RendererBase;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.NonNull;

public class MapRenderer extends RendererBase {

    public MapRenderer(@NonNull PixelDimension dimension) {
        super(dimension);
    }

    @Override
    public void render(@NonNull Scannable scannable, @NonNull Bufferable renderTo, int xOffset, int yOffset) {
        super.render(scannable, renderTo, xOffset, yOffset);
    }

}
