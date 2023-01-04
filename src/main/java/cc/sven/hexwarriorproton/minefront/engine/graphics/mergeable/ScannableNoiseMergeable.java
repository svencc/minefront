package cc.sven.hexwarriorproton.minefront.engine.graphics.mergeable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.DefaultRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.scannable.ScannableNoise;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import cc.sven.hexwarriorproton.minefront.service.RandomProvider;
import lombok.NonNull;

public class ScannableNoiseMergeable extends ScannableMergeable {

    @NonNull
    private final DefaultRenderer renderer;
    @NonNull
    private final ScannableNoise scannableNoiseDelegate;

    public ScannableNoiseMergeable(@NonNull PixelDimension dimension, @NonNull RandomProvider randomProvider) {
        super(dimension);
        this.renderer = new DefaultRenderer(dimension);
        this.scannableNoiseDelegate = new ScannableNoise(randomProvider, dimension);
    }

    @Override
    public void mergeWith(@NonNull PixelBuffer target, int offsetX, int offsetY) {
        renderer.render(scannableNoiseDelegate, target, offsetX, offsetY);
    }

    @Override
    public void mergeWith(@NonNull Bufferable target, int offsetX, int offsetY) {
        renderer.render(scannableNoiseDelegate, target, offsetX, offsetY);
    }

    @Override
    public int scanPixelAt(int x, int y) {
        return scannableNoiseDelegate.scanPixelAt(x, y);
    }

    @Override
    public int scanPixelAtIndex(int index) {
        return scanPixelAtIndex(index);
    }
}
