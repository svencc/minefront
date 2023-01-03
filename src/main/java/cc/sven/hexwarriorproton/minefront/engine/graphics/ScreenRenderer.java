package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.Drawable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.layer.LayerableRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.BaseRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.DefaultRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.Renderable;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import cc.sven.hexwarriorproton.minefront.engine.units.StopWatch;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;

@Component
public class ScreenRenderer implements Renderable, Rasterizable, Drawable {

    @NonNull
    private final ResolutionProperties resolution;
    @NonNull
    private final BaseRenderer renderer;
    @Getter
    @NonNull
    private final LinkedList<LayerableRenderer> layerPipeline;
    @Getter
    protected int[] pixelRaster;

    public ScreenRenderer(@NonNull ResolutionProperties resolutionProperties) {
        resolution = resolutionProperties;
        renderer = new DefaultRenderer(resolution);
        pixelRaster = new int[resolution.getWidth() * resolution.getHeight()];
        layerPipeline = new LinkedList<>();
    }

    @Override
    public void rasterize(@NonNull StopWatch stopWatch) {
        clearScreen();
        layerPipeline.forEach(layer -> layer.render(this, 0, 0));
    }

    private void clearScreen() {
        Arrays.fill(pixelRaster, 0);
    }

    @Override
    public void draw(@NonNull Drawable drawable, @NonNull Renderable renderTo, int xOffset, int yOffset) {
        renderer.draw(drawable, this, xOffset, yOffset);
    }

    @Override
    public void setPixelAt(@NonNull Renderable renderTo, int x, int y, int width, int newPixelValue) {
        this.pixelRaster[x + y * width] = newPixelValue;
    }

    @Override
    public PixelDimension getDimension() {
        return resolution.toDimension();
    }

    @Override
    public int getPixelAt(int x, int y, int width) {
        return pixelRaster[x + y * width];
    }

    @Override
    public int getPixelAtIndex(int nr) {
        return pixelRaster[nr];
    }

}
