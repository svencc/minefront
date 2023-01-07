package cc.sven.hexwarriorproton.minefront.engine.graphics.renderer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Renderable;
import cc.sven.hexwarriorproton.minefront.service.argb.ARGBCalculatorProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public final class RenderProvider {

    @NonNull
    private final ARGBCalculatorProvider argbCalculatorProvider;
    @Nullable
    private Renderable instance;

    public Renderable provide() {
        if (instance == null) {
            instance = new SoftwareRenderer(argbCalculatorProvider);
        }

        return instance;
    }

}
