package cc.sven.hexwarriorproton.minefront.engine.components.mergeable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.RenderProvider;
import cc.sven.hexwarriorproton.minefront.engine.graphics.scanable.ScanableNoise;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import cc.sven.hexwarriorproton.minefront.service.RandomProvider;
import lombok.NonNull;

public class ScanableNoiseMergeable extends ScanableMergeableTemplate {

    @NonNull
    private final RenderProvider renderProvider;
    @NonNull
    private final ScanableNoise scanableNoiseDelegate;

    public ScanableNoiseMergeable(@NonNull final RenderProvider renderProvider, @NonNull final PixelDimension dimension, @NonNull final RandomProvider randomProvider) {
        super(dimension);
        this.renderProvider = renderProvider;
        this.scanableNoiseDelegate = new ScanableNoise(randomProvider, dimension);
    }

    @Override
    public void mergeBufferWith(@NonNull final PixelBuffer targetBuffer, final int offsetX, final int offsetY) {
        renderProvider.provide().render(scanableNoiseDelegate, targetBuffer, offsetX, offsetY);
    }

    @Override
    public void mergeBufferWith(@NonNull final Bufferable targetBuffer, final int offsetX, final int offsetY) {
        renderProvider.provide().render(scanableNoiseDelegate, targetBuffer, offsetX, offsetY);
    }

    @Override
    public void prepareBuffer() {
        // nothing to render here, as wie have no buffer and the scanned pixel is generated randomly while scanning it.
    }

    @Override
    public void disposeBuffer() {
        // nothing to dispose here, as we have no buffer and the scanned pixel is generated randomly while scanning it.
    }

    @Override
    public int scanPixelAt(int x, int y) {
        return scanableNoiseDelegate.scanPixelAt(x, y);
    }

    @Override
    public int scanPixelAtIndex(int index) {
        return scanableNoiseDelegate.scanPixelAtIndex(index);
    }

}
