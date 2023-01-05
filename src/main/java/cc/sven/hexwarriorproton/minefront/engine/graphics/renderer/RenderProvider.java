package cc.sven.hexwarriorproton.minefront.engine.graphics.renderer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Renderable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RenderProvider {

    @Nullable
    private Renderable rendererSingletonInstance;

    public Renderable provide() {
        if (rendererSingletonInstance == null) {
            rendererSingletonInstance = new SoftwareRenderer();
        }

        return rendererSingletonInstance;
    }

}
