package cc.sven.hexwarriorproton.minefront.engine;

import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenRasterizer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.layer.NoiseLayer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.DefaultRenderer;
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
    private final ScreenRasterizer screenRasterizer;

    public void init() {
        final NoiseLayer noiseLayer = new NoiseLayer(resolution.toRenderDimension(), new DefaultRenderer(resolution.toRenderDimension()));
        screenRasterizer.getLayerPipeline().clear();
        screenRasterizer.getLayerPipeline().add(noiseLayer);
    }

    public void startGame() {

    }


}
