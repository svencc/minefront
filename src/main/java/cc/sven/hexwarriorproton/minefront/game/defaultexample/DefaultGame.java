package cc.sven.hexwarriorproton.minefront.game.defaultexample;

import cc.sven.hexwarriorproton.minefront.engine.GameTemplate;
import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenComposer;
import cc.sven.hexwarriorproton.minefront.engine.components.mergeable.ScanableNoiseMergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.RenderProvider;
import cc.sven.hexwarriorproton.minefront.property.RendererProperties;
import cc.sven.hexwarriorproton.minefront.service.RandomProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
@RequiredArgsConstructor
public class DefaultGame extends GameTemplate {

    @NonNull
    private final RendererProperties rendererResolution;
    @NonNull
    private final ScreenComposer screenComposer;
    @NonNull
    private final RandomProvider randomProvider;
    @NonNull
    private final RenderProvider renderProvider;

    public void init() {
        final ScanableNoiseMergeable scanableNoiseLayer = new ScanableNoiseMergeable(renderProvider, rendererResolution.toRendererDimension(), randomProvider);
        screenComposer.getLayerPipeline().clear();
        screenComposer.getLayerPipeline().add(scanableNoiseLayer);
    }

    public void startGame() {

    }


}
