package cc.sven.hexwarriorproton.minefront.game;

import cc.sven.hexwarriorproton.minefront.engine.AbstractGame;
import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenRenderer;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexCanvasFactory;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMap;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMapFactory;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMapProperties;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.enums.MapShape;
import cc.sven.hexwarriorproton.minefront.game.renderer.MapLayer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
@Profile("hexgame")
@RequiredArgsConstructor
public class HexGame extends AbstractGame {

    @NonNull
    private final ScreenRenderer screenRenderer;
    @NonNull
    private final MapLayer mapLayer;

    public void init() {
        screenRenderer.getLayerPipeline().clear();
        screenRenderer.getLayerPipeline().add(mapLayer);
    }

    public void startGame() {
        final HexMapProperties mapProperties = HexMapProperties.builder()
                .gridHeight(17)
                .gridWidth(15)
                .mapShape(MapShape.ODD_Q)
                .outerRadius(4 * 10)
                .build();

        final HexMapFactory hexMapFactory = new HexMapFactory();
        final HexMap map = hexMapFactory.layout(mapProperties);

        // CANVAS & HEX-RENDERING
        final HexCanvasFactory hexCanvasFactory = new HexCanvasFactory();
        final Canvas canvas = hexCanvasFactory.create(map);


    }


}
