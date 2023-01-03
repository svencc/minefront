package cc.sven.hexwarriorproton.minefront.game;

import cc.sven.hexwarriorproton.minefront.engine.AbstractGame;
import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenRasterizer;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMap;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMapFactory;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMapProperties;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.enums.MapShape;
import cc.sven.hexwarriorproton.minefront.game.renderer.map.HexMapLayer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("hexgame")
@RequiredArgsConstructor
public class HexGame extends AbstractGame {

    @NonNull
    private final ScreenRasterizer screenRasterizer;
    @NonNull
    private final HexMapLayer layeredMapRenderer;

    public void init() {
        layeredMapRenderer.setHexMap(generateAMap());
        screenRasterizer.getLayerPipeline().clear();
        screenRasterizer.getLayerPipeline().add(layeredMapRenderer);
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
