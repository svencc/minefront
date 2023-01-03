package cc.sven.hexwarriorproton.minefront.engine.graphics.layer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.DefaultRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.scannable.ScannableNoise;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.NonNull;

public class NoiseLayer extends RenderableLayerBase {

    @NonNull
    private final DefaultRenderer defaultRenderer;
    @NonNull
    private final ScannableNoise scannableNoise;

    public NoiseLayer(@NonNull PixelDimension dimension, @NonNull DefaultRenderer defaultRenderer) {
        super(dimension);
        this.defaultRenderer = defaultRenderer;
        this.scannableNoise = new ScannableNoise(dimension);
    }

    @Override
    public void renderLayer(@NonNull Bufferable renderTo, int xOffset, int yOffset) {
        defaultRenderer.render(scannableNoise, renderTo, xOffset, yOffset);
    }

}
