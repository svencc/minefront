package cc.sven.hexwarriorproton.minefront.game.renderer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.layer.LayerRendererBase;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.Renderable;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMap;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MapLayer extends LayerRendererBase {

    @NonNull
    private final ResolutionProperties resolutionProperties;
    @NonNull
    private final MapRenderer mapRenderer;
    @NonNull
    private Optional<HexMap> hexMap = Optional.empty();


    @Override
    public void render(@NonNull Renderable renderTo, int xOffset, int yOffset) {
        if (hexMap.isPresent()) {
            hexMap.get().getCubicHexList().forEach(cubicHex -> {
                mapRenderer.draw(cubicHex, renderTo, 0, 0);
            });
        }
    }

}
