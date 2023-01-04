package cc.sven.hexwarriorproton.minefront.game;

import cc.sven.hexwarriorproton.minefront.engine.GameTemplate;
import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenComposer;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMap;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMapFactory;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMapProperties;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.enums.MapShape;
import cc.sven.hexwarriorproton.minefront.game.renderer.map.HexMapMergeable;
import cc.sven.hexwarriorproton.minefront.property.RendererResolutionProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@Profile("hexgame")
@RequiredArgsConstructor
public class HexGame extends GameTemplate {
    @NonNull
    private final RendererResolutionProperties rendererResolution;
    @NonNull
    private final ScreenComposer screenComposer;
    @Nullable
    private HexMapMergeable hexMapMergeable;

    public void init() {
        hexMapMergeable = new HexMapMergeable(rendererResolution.toRendererDimension());
        hexMapMergeable.setHexMap(generateAMap());
        screenComposer.getLayerPipeline().clear();
        screenComposer.getLayerPipeline().add(hexMapMergeable);
    }

    public void startGame() {

    }

    private static HexMap generateAMap() {
        final HexMapProperties mapProperties = HexMapProperties.builder()
                .gridHeight(17)
                .gridWidth(15)
                .mapShape(MapShape.ODD_Q)
                .outerRadius(4 * 10)
                .build();

        final HexMapFactory hexMapFactory = new HexMapFactory();
        final HexMap map = hexMapFactory.layout(mapProperties);
        return map;
    }

}
