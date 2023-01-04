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
public abstract class RendererTemplate implements Renderable {

    // @TODO der Renderer braucht keine eigene dimension!
    // @TODO Der Renderer kann dann eine Component sein!
    // @TODO Die Dimension kann vom sourceScannable abgefragt werden? -> test!
    @Getter
    @NonNull
    private final PixelDimension dimension;


    public void render(@NonNull PixelBuffer scannable, @NonNull PixelBuffer renderTo, int xOffset, int yOffset) {
        PixelBuffer.copyWithOffset(scannable, renderTo, xOffset, yOffset);
    }

    //@TODO
    public void render(@NonNull Scannable sourceScannable, @NonNull Bufferable targetBuffer, int xOffset, int yOffset) {
        for (int y = 0; y < sourceScannable.getDimension().getHeightY(); y++) {
            int yPixel = y + yOffset;
            if (yPixel < 0 || yPixel >= dimension.getHeightY()) continue;

            for (int x = 0; x < sourceScannable.getDimension().getWidthX(); x++) {
                int xPixel = x + xOffset;
                if (xPixel < 0 || xPixel >= dimension.getHeightY()) continue;

                int colorValue = sourceScannable.scanPixelAt(x, y);
                if (colorValue > 0) {
                    setPixelAt(
                            targetBuffer,
                            xPixel, yPixel,
                            colorValue
                    );
                }
            }
        }
    }

    @Override
    public void setPixelAt(@NonNull Bufferable target, int x, int y, int newPixelValue) {
        target.bufferPixelAt(x, y, newPixelValue);
    }

}
