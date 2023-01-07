package cc.sven.hexwarriorproton.minefront.engine.graphics.components.mergeable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.RenderProvider;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;


public abstract class BufferedMergeableTemplate implements Mergeable, HasPixelBuffer {

    @Getter
    @NonNull
    private final PixelBuffer pixelBuffer;

    @NonNull
    private final RenderProvider renderProvider;

    public BufferedMergeableTemplate(@NonNull final PixelDimension dimension, @NonNull final RenderProvider renderProvider) {
        this.pixelBuffer = new PixelBuffer(dimension);
        this.renderProvider = renderProvider;
    }

    @Override
    public void mergeBufferWith(@NonNull final PixelBuffer targetBuffer, final int offsetX, final int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetX, offsetY);
    }

    @Override
    public void mergeBufferWith(@NonNull final Bufferable targetBuffer, final int offsetX, final int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetX, offsetY);
    }

    @Override
    public void prepareBuffer() {

    }

    @Override
    public void disposeBuffer() {

    }

}
