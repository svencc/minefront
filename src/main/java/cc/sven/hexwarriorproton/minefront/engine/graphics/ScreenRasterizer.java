package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.scannable.ScannableNoise;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;

@Component
public class ScreenRasterizer extends PixelBuffer implements Rasterizable, Scannable, Bufferable {

    @Getter
    @NonNull
    private final LinkedList<RenderableLayer> layerPipeline;
//    ScannableNoise scannableNoise;
    public ScreenRasterizer(@NonNull ResolutionProperties resolutionProperties) {
        super(resolutionProperties.toRenderDimension());
        layerPipeline = new LinkedList<>();
//        scannableNoise = new ScannableNoise(resolutionProperties.toRenderDimension());
    }

    @Override
    public void rasterize() {
        clearScreen();
        layerPipeline.forEach(layer -> layer.renderLayer(this, 0, 0));
    }

    private void clearScreen() {
        Arrays.fill(pixelBuffer, 0);
    }

//    @Override
//    public int scanPixelAtIndex(int index) {
//        return scannableNoise.scanPixelAtIndex(0);
//    }

}
