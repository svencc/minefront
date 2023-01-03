package cc.sven.hexwarriorproton.minefront.engine.graphics.layer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.RenderableLayer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class RenderableLayerBase implements RenderableLayer {

    @Getter
    @NonNull
    private final PixelDimension dimension;

}
