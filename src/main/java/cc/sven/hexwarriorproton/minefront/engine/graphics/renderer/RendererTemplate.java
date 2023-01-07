package cc.sven.hexwarriorproton.minefront.engine.graphics.renderer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Renderable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Scanable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.service.argb.ARGBCalculatorProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
abstract class RendererTemplate implements Renderable {

    @NonNull
    private final ARGBCalculatorProvider argbCalculatorProvider;

    public void render(@NonNull final Scanable source, @NonNull final Bufferable target, final int xOffset, final int yOffset) {
        for (int y = 0; y < source.getDimension().getHeightY(); y++) {
            final int copyToY = y + yOffset;
            if (copyToY < 0 || copyToY >= target.getDimension().getHeightY()) continue;

            for (int x = 0; x < source.getDimension().getWidthX(); x++) {
                final int copyToX = x + xOffset;
                if (copyToX < 0 || copyToX >= target.getDimension().getWidthX()) continue;

                final int colorValue = source.scanPixelAt(x, y);
                if (colorValue == 0xFFff00ff) continue;
                int alphaComponent = argbCalculatorProvider.provide().getAlphaComponent(colorValue);
                if (alphaComponent < 0xFF) {
                    // set color blending (alpha channel)
                    target.bufferPixelAt(copyToX, copyToY, argbCalculatorProvider.provide().blend(colorValue, target.scanPixelAt(copyToX, copyToY)));
                } else {
                    // set color without blending
                    target.bufferPixelAt(copyToX, copyToY, colorValue);
                }
            }
        }
    }

    @Override
    public void renderMergeable(@NonNull final Mergeable source, @NonNull final PixelBuffer targetBuffer, final int xOffset, final int yOffset) {
        source.mergeBufferWith(targetBuffer, xOffset, yOffset);
    }

    @Override
    public void renderMergeable(@NonNull final Mergeable source, @NonNull final Bufferable target, final int xOffset, final int yOffset) {
        source.mergeBufferWith(target, xOffset, yOffset);
    }

    @Override
    public void setPixelAt(@NonNull final Bufferable target, final int x, final int y, final int newPixelValue) {
        if (x < 0 || y < 0) return;
        if (x > target.getDimension().getWidthX() || y > target.getDimension().getHeightY()) return;

        target.bufferPixelAt(x, y, newPixelValue);
    }

}
