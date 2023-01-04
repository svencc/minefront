package cc.sven.hexwarriorproton.minefront.game.defaultexample;

import cc.sven.hexwarriorproton.minefront.engine.GameTemplate;
import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenComposer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.mergeable.ScanableNoiseMergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.SoftwareRenderer;
import cc.sven.hexwarriorproton.minefront.property.RendererResolutionProperties;
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
    private final RendererResolutionProperties rendererResolution;
    @NonNull
    private final ScreenComposer screenComposer;
    @NonNull
    private final RandomProvider randomProvider;
    @NonNull
    private final SoftwareRenderer softwareRenderer;

    public void init() {
        final ScanableNoiseMergeable scanableNoiseLayer = new ScanableNoiseMergeable(rendererResolution.toRendererDimension(), randomProvider, softwareRenderer);
        screenComposer.getLayerPipeline().clear();
        screenComposer.getLayerPipeline().add(scanableNoiseLayer);
    }

    public void startGame() {

    }


}
