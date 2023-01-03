package cc.sven.hexwarriorproton.minefront.game.renderer.map;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.layer.RenderableLayerBase;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMap;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class HexMapLayer extends RenderableLayerBase {

    @NonNull
    private final PixelBuffer pixelBuffer;
    @NonNull
    private final MapRenderer mapRenderer;

    @NonNull
    private Optional<HexMap> hexMap = Optional.empty();

    public HexMapLayer(@NonNull PixelDimension dimension, @NonNull PixelBuffer pixelBuffer, @NonNull MapRenderer mapRenderer) {
        super(dimension);
        this.pixelBuffer = pixelBuffer;
        this.mapRenderer = mapRenderer;
    }

    public void setHexMap(@NonNull HexMap newHexMap) {
        this.hexMap = Optional.of(newHexMap);
    }

    @Override
    public void renderLayer(@Nullable Bufferable renderTo, int xOffset, int yOffset) {
        hexMap.ifPresent(map -> map.getCubicHexList().forEach(cubicHex -> {
            mapRenderer.render(cubicHex, pixelBuffer, 0, 0);
        }));
    }

}
