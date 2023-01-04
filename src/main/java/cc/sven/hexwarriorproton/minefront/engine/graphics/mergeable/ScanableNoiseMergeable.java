package cc.sven.hexwarriorproton.minefront.engine.graphics.mergeable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.SoftwareRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.scanable.ScanableNoise;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import cc.sven.hexwarriorproton.minefront.service.RandomProvider;
import lombok.NonNull;

public class ScanableNoiseMergeable extends ScanableMergeableTemplate {

    @NonNull
    private final SoftwareRenderer renderer;
    @NonNull
    private final ScanableNoise scanableNoiseDelegate;

    public ScanableNoiseMergeable(@NonNull PixelDimension dimension, @NonNull RandomProvider randomProvider, @NonNull SoftwareRenderer softwareRenderer) {
        super(dimension);
        this.renderer = softwareRenderer;
        this.scanableNoiseDelegate = new ScanableNoise(randomProvider, dimension);
    }

    @Override
    public void mergeWith(@NonNull PixelBuffer target, int offsetX, int offsetY) {
        renderer.render(scanableNoiseDelegate, target, offsetX, offsetY);
    }

    @Override
    public void mergeWith(@NonNull Bufferable target, int offsetX, int offsetY) {
        renderer.render(scanableNoiseDelegate, target, offsetX, offsetY);
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
