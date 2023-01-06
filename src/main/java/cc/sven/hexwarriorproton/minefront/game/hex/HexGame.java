package cc.sven.hexwarriorproton.minefront.game.hex;

import cc.sven.hexwarriorproton.minefront.engine.GameTemplate;
import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenComposer;
import cc.sven.hexwarriorproton.minefront.game.hex.graphics.map.SimpleMergeable;
import cc.sven.hexwarriorproton.minefront.property.RendererResolutionProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("hexgame")
@RequiredArgsConstructor
public class HexGame extends GameTemplate {

    @NonNull
    private final RendererResolutionProperties rendererResolution;
    @NonNull
    private final ScreenComposer screenComposer;
    @NonNull
    private final SimpleMergeable simpleMergeable;

    @Override
    public void init() {
        screenComposer.getLayerPipeline().clear();
        screenComposer.getLayerPipeline().add(simpleMergeable);
    }

    @Override
    public void startGame() {

    }

}
