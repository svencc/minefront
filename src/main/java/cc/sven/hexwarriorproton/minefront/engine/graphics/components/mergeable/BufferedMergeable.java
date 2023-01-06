package cc.sven.hexwarriorproton.minefront.engine.graphics.components.mergeable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.RenderProvider;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;


public abstract class BufferedMergeable implements Mergeable, HasPixelBuffer {

    @Getter
    @NonNull
    private final PixelBuffer pixelBuffer;

    @NonNull
    private final RenderProvider renderProvider;

    public BufferedMergeable(@NonNull PixelDimension dimension, @NonNull RenderProvider renderProvider) {
        this.pixelBuffer = new PixelBuffer(dimension);
        this.renderProvider = new RenderProvider();
    }

    @Override
    public void mergeBufferWith(@NonNull PixelBuffer targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetX, offsetY);
    }

    @Override
    public void mergeBufferWith(@NonNull Bufferable targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetX, offsetY);
    }

    @Override
    public void prepareBuffer() {

    }

    @Override
    public void disposeBuffer() {

    }

}
