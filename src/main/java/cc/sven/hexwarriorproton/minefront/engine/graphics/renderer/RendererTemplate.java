package cc.sven.hexwarriorproton.minefront.engine.graphics.renderer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Renderable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Scanable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class RendererTemplate implements Renderable {

    public void render(@NonNull PixelBuffer scanable, @NonNull PixelBuffer renderTo, int xOffset, int yOffset) {
        PixelBuffer.copyWithOffset(scanable, renderTo, xOffset, yOffset);
    }

    public void render(@NonNull Scanable sourceScanable, @NonNull Bufferable targetBuffer, int xOffset, int yOffset) {
        for (int y = 0; y < sourceScanable.getDimension().getHeightY(); y++) {
            int yPixel = y + yOffset;
            if (yPixel < 0 || yPixel >= targetBuffer.getDimension().getHeightY()) continue;

            for (int x = 0; x < sourceScanable.getDimension().getWidthX(); x++) {
                int xPixel = x + xOffset;
                if (xPixel < 0 || xPixel >= targetBuffer.getDimension().getHeightY()) continue;

                int colorValue = sourceScanable.scanPixelAt(x, y);
                if (colorValue > 0) {
                    targetBuffer.bufferPixelAt(xPixel, yPixel, colorValue);
                }
            }
        }
    }

    @Override
    public void setPixelAt(@NonNull Bufferable target, int x, int y, int newPixelValue) {
        if (x < 0 || y < 0) return;
        if (x > target.getDimension().getWidthX() || y > target.getDimension().getHeightY()) return;

        target.bufferPixelAt(x, y, newPixelValue);
    }

}
