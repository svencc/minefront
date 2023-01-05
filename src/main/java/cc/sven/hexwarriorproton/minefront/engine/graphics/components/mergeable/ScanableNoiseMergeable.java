package cc.sven.hexwarriorproton.minefront.engine.graphics.components.mergeable;

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

    public ScanableNoiseMergeable(@NonNull RenderProvider renderProvider, @NonNull PixelDimension dimension, @NonNull RandomProvider randomProvider) {
        super(dimension);
        this.renderProvider = renderProvider;
        this.scanableNoiseDelegate = new ScanableNoise(randomProvider, dimension);
    }

    @Override
    public void mergeWith(@NonNull PixelBuffer targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(scanableNoiseDelegate, targetBuffer, offsetX, offsetY);
    }

    @Override
    public void mergeWith(@NonNull Bufferable targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(scanableNoiseDelegate, targetBuffer, offsetX, offsetY);
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
