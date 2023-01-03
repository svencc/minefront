package cc.sven.hexwarriorproton.minefront.engine.graphics.layer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.DrawableNoise;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.DefaultRenderer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.render.Renderable;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import lombok.NonNull;

public class NoiseLayer extends LayerRendererBase {

    @NonNull
    private final ResolutionProperties resolutionProperties;
    @NonNull
    private final DefaultRenderer defaultRenderer;
    @NonNull
    private final DrawableNoise drawableNoise;

    public NoiseLayer(@NonNull ResolutionProperties resolutionProperties, @NonNull DefaultRenderer defaultRenderer) {
        this.resolutionProperties = resolutionProperties;
        this.defaultRenderer = defaultRenderer;
        this.drawableNoise = new DrawableNoise(resolutionProperties.toDimension());
    }

    @Override
    public void render(@NonNull Renderable renderTo, int xOffset, int yOffset) {
        defaultRenderer.draw(drawableNoise, renderTo, xOffset, yOffset);
    }

}
