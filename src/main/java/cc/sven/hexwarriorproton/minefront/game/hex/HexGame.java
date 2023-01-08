package cc.sven.hexwarriorproton.minefront.game.hex;

import cc.sven.hexwarriorproton.minefront.engine.GameTemplate;
import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenComposer;
import cc.sven.hexwarriorproton.minefront.game.hex.graphics.HexMapMergeable;
import cc.sven.hexwarriorproton.minefront.game.hex.level.HexMap;
import cc.sven.hexwarriorproton.minefront.game.hex.level.HexMapConfiguration;
import cc.sven.hexwarriorproton.minefront.game.hex.level.HexMapLayouter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("hexgame")
@RequiredArgsConstructor
public class HexGame extends GameTemplate {

    @NonNull
    private final HexMapLayouter hexMapLayouter;
    @NonNull
    private final ScreenComposer screenComposer;
    @NonNull
    private final HexMapMergeable hexMapMergeable;

    @Override
    public void init() {
        hexMapMergeable.setHexMap(generateExampleMap());
        screenComposer.getLayerPipeline().clear();
        screenComposer.getLayerPipeline().add(hexMapMergeable);
    }

    private HexMap generateExampleMap() {
        final HexMapConfiguration mapProperties = HexMapConfiguration.builder()
                .gridHeight(17)
                .gridWidth(15)
                .build();

        return hexMapLayouter.layout(mapProperties);
    }

    @Override
    public void startGame() {

    }

}
