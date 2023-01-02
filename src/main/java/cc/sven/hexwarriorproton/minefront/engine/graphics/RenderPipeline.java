package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.Drawable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.layer.LayerableRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.layer.NoiseLayer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.BaseRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.DefaultRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.Renderable;
import cc.sven.hexwarriorproton.minefront.engine.units.StopWatch;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;

@Component
public class RenderPipeline extends BaseRenderer implements Renderable, Rasterizable, Drawable {

    @Getter
    @NonNull
    private final LinkedList<LayerableRenderer> pipelineLayer;
    @Getter
    protected int[] pixelRaster;

    public RenderPipeline(@NonNull ResolutionProperties resolution, @NonNull ResolutionProperties resolutionProperties) {
        super(resolution);
//        this.layer = new ArrayList<>();
        this.pipelineLayer = new LinkedList<>();
        pixelRaster = new int[getResolution().getWidth() * getResolution().getHeight()];
        pipelineLayer.add(new NoiseLayer(resolutionProperties, new DefaultRenderer(resolutionProperties)));
    }

    @Override
    public void rasterize(@NonNull StopWatch stopWatch) {
        clearScreen();
        pipelineLayer.forEach(layer -> layer.render(this, 0, 0));
    }

    private void clearScreen() {
        Arrays.fill(pixelRaster, 0);
    }

    @Override
    public void setPixelAt(@NonNull Renderable renderTo, int x, int y, int width, int newPixelValue) {
        this.pixelRaster[x + y * width] = newPixelValue;
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
