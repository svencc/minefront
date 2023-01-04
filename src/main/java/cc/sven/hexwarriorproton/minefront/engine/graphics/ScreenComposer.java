package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.property.RendererResolutionProperties;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class ScreenComposer extends PixelBuffer implements Composable, Scanable, Bufferable {

    @NonNull
    private final RendererResolutionProperties rendererResolution;
    @Getter
    @NonNull
    private final LinkedList<Mergeable> layerPipeline = new LinkedList<>();

    public ScreenComposer(@NonNull RendererResolutionProperties rendererResolution) {
        super(rendererResolution.toRendererDimension());
        this.rendererResolution = rendererResolution;
    }


    @Override
    public void compose() {
        clearBuffer();
        layerPipeline.forEach(layer -> layer.mergeWith(this, 0, 0));
    }

}
