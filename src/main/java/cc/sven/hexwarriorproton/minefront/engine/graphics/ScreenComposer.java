package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.property.RendererProperties;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class ScreenComposer extends PixelBuffer implements Composable, Bufferable {

    @NonNull
    private final RendererProperties rendererResolution;
    @Getter
    @NonNull
    private final LinkedList<Mergeable> layerPipeline = new LinkedList<>();

    public ScreenComposer(@NonNull final RendererProperties rendererProperties) {
        super(rendererProperties.toRendererDimension());
        rendererResolution = rendererProperties;
    }

    @Override
    public void compose() {
        layerPipeline.forEach(layer -> {
            layer.prepareBuffer();
            layer.mergeBufferWith(this, 0, 0);
            layer.disposeBuffer();
        });
    }

}
