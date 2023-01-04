package cc.sven.hexwarriorproton.minefront.engine.graphics.renderer;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Renderable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Scannable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class RendererBase implements Renderable {

    @Getter
    @NonNull
    private final PixelDimension dimension;

    public void render(@NonNull PixelBuffer scannable, @NonNull PixelBuffer renderTo, int xOffset, int yOffset) {
        PixelBuffer.copyWithOffset(scannable, renderTo, xOffset, yOffset);
    }

    public void render(@NonNull Scannable scannable, @NonNull Bufferable renderTo, int xOffset, int yOffset) {
        for (int y = 0; y < scannable.getDimension().getHeightY(); y++) {
            int yPixel = y + yOffset;
            if (yPixel < 0 || yPixel >= dimension.getHeightY()) continue;

            for (int x = 0; x < scannable.getDimension().getWidthX(); x++) {
                int xPixel = x + xOffset;
                if (xPixel < 0 || xPixel >= dimension.getHeightY()) continue;

                int colorValue = scannable.scanPixelAt(x, y);
                if (colorValue > 0) {
                    setPixelAt(
                            renderTo,
                            xPixel, yPixel,
                            colorValue
                    );
                }
            }
        }
    }

    @Override
    public void setPixelAt(@NonNull Bufferable renderTo, int x, int y, int newPixelValue) {
        renderTo.bufferPixelAt(x, y, newPixelValue);
    }

}
