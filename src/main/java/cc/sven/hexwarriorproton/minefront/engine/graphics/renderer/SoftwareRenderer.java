package cc.sven.hexwarriorproton.minefront.engine.graphics.renderer;

import cc.sven.hexwarriorproton.minefront.property.RendererProperties;
import cc.sven.hexwarriorproton.minefront.service.argb.ARGBCalculatorProvider;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
class SoftwareRenderer extends RendererTemplate {

    SoftwareRenderer(@NonNull final RendererProperties rendererProperties, @NonNull final ARGBCalculatorProvider argbCalculatorProvider) {
        super(rendererProperties, argbCalculatorProvider);
    }

}
