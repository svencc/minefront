package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.components.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.components.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.property.RendererProperties;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class ScreenComposer implements Composable, HasPixelBuffer {

    @Getter
    @NonNull
    private final PixelBuffer pixelBuffer;
    @Getter
    @NonNull
    private final LinkedList<Mergeable> layerPipeline = new LinkedList<>();

    public ScreenComposer(@NonNull final RendererProperties rendererProperties) {
        pixelBuffer = new PixelBuffer(rendererProperties.toRendererDimension());
    }

    @Override
    public void compose() {
        pixelBuffer.clearBuffer();
        // Todo parallelize rendering of layers.
        // merge Buffers from top layer to last layer!
        layerPipeline.forEach(layer -> {
            layer.prepareBuffer();
            layer.mergeBufferWith(pixelBuffer, 0, 0);
            layer.disposeBuffer();
        });
    }

}
