package cc.sven.hexwarriorproton.minefront.engine;

import cc.sven.hexwarriorproton.minefront.engine.graphics.ScreenComposer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.mergeable.ScannableNoiseMergeable;
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

    public void init() {
        final ScannableNoiseMergeable scannableNoiseLayer = new ScannableNoiseMergeable(rendererResolution.toRendererDimension(), randomProvider);
        screenComposer.getLayerPipeline().clear();
        screenComposer.getLayerPipeline().add(scannableNoiseLayer);
    }

    public void startGame() {

    }


}
