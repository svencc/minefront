package cc.sven.hexwarriorproton.minefront.engine.graphics.mergeable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Renderable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Scanable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.NonNull;


public class BufferedMergeable extends PixelBuffer implements Bufferable, Scanable, Mergeable {

    @NonNull
    private final Renderable renderer;

    public BufferedMergeable(@NonNull PixelDimension dimension, @NonNull Renderable renderer) {
        super(dimension);
        this.renderer = renderer;
    }

    @Override
    public void mergeWith(@NonNull PixelBuffer target, int offsetX, int offsetY) {
        renderer.render(this, target, offsetX, offsetY);
    }

    @Override
    public void mergeWith(@NonNull Bufferable target, int offsetX, int offsetY) {
        renderer.render(this, target, offsetX, offsetY);
    }

}
