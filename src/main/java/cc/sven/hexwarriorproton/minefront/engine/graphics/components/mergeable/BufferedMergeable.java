package cc.sven.hexwarriorproton.minefront.engine.graphics.components.mergeable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Renderable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;


public class BufferedMergeable implements Mergeable, HasPixelBuffer {

    @Getter
    @NonNull
    private final PixelBuffer pixelBuffer;

    @NonNull
    private final Renderable renderer;

    public BufferedMergeable(@NonNull PixelDimension dimension, @NonNull Renderable renderer) {
        this.pixelBuffer = new PixelBuffer(dimension);
        this.renderer = renderer;
    }

    @Override
    public void mergeWith(@NonNull PixelBuffer targetBuffer, int offsetX, int offsetY) {
        renderer.render(pixelBuffer, targetBuffer, offsetX, offsetY);
    }

    @Override
    public void mergeWith(@NonNull Bufferable targetBuffer, int offsetX, int offsetY) {
        renderer.render(pixelBuffer, targetBuffer, offsetX, offsetY);
    }

//    @Override
//    public void mergeWith(@NonNull HasPixelBuffer targetBuffer, int offsetX, int offsetY) {
//        renderer.render(pixelBuffer, targetBuffer, offsetX, offsetY);
//    }

}
