package cc.sven.hexwarriorproton.minefront.engine.graphics.renderer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Renderable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Scanable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
abstract class RendererTemplate implements Renderable {

    public void render(@NonNull PixelBuffer sourceBuffer, @NonNull PixelBuffer targetBuffer, int xOffset, int yOffset) {
        PixelBuffer.copyWithOffset(sourceBuffer, targetBuffer, xOffset, yOffset);
    }

    public void render(@NonNull Scanable source, @NonNull Bufferable target, int xOffset, int yOffset) {
        for (int y = 0; y < source.getDimension().getHeightY(); y++) {
            int copyToY = y + yOffset;
            if (copyToY < 0 || copyToY >= target.getDimension().getHeightY()) continue;

            for (int x = 0; x < source.getDimension().getWidthX(); x++) {
                int copyToX = x + xOffset;
                if (copyToX < 0 || copyToX >= target.getDimension().getHeightY()) continue;

                int colorValue = source.scanPixelAt(x, y);
                if (colorValue > 0) {
                    target.bufferPixelAt(copyToX, copyToY, colorValue);
                }
            }
        }
    }

    @Override
    public void renderMergeable(@NonNull Mergeable source, @NonNull PixelBuffer targetBuffer, int xOffset, int yOffset) {
        source.mergeWith(targetBuffer, xOffset, yOffset);
    }

    @Override
    public void renderMergeable(@NonNull Mergeable source, @NonNull Bufferable target, int xOffset, int yOffset) {
        source.mergeWith(target, xOffset, yOffset);
    }

    @Override
    public void setPixelAt(@NonNull Bufferable target, int x, int y, int newPixelValue) {
        if (x < 0 || y < 0) return;
        if (x > target.getDimension().getWidthX() || y > target.getDimension().getHeightY()) return;

        target.bufferPixelAt(x, y, newPixelValue);
    }

}
