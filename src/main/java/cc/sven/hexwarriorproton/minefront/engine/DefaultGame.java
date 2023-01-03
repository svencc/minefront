package cc.sven.hexwarriorproton.minefront.engine;

import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.layer.NoiseLayer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.DefaultRenderer;
import cc.sven.hexwarriorproton.minefront.game.renderer.MapLayer;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
@RequiredArgsConstructor
public class DefaultGame extends AbstractGame {

    @NonNull
    private final ResolutionProperties resolution;
    @NonNull
    private final ScreenRenderer screenRenderer;
    @NonNull
    private final MapLayer mapLayer;

    public void init() {
        final NoiseLayer noiseLayer = new NoiseLayer(resolution, new DefaultRenderer(resolution));
        screenRenderer.getLayerPipeline().clear();
        screenRenderer.getLayerPipeline().add(noiseLayer);
    }

    public void startGame() {

    }


}
