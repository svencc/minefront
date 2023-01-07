package cc.sven.hexwarriorproton.minefront.engine.graphics.renderer;

import cc.sven.hexwarriorproton.minefront.service.argb.ARGBCalculatorProvider;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
class SoftwareRenderer extends RendererTemplate {

    SoftwareRenderer(@NonNull ARGBCalculatorProvider argbCalculatorProvider) {
        super(argbCalculatorProvider);
    }

}
