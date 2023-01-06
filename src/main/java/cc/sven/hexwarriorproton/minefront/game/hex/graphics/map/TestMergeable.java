package cc.sven.hexwarriorproton.minefront.game.hex.graphics.map;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Bufferable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.components.sprite.Sprite;
import cc.sven.hexwarriorproton.minefront.engine.graphics.renderer.RenderProvider;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestMergeable implements Mergeable, HasPixelBuffer {

    @NonNull
    private final RenderProvider renderProvider;
    @Getter
    @NonNull
    private final PixelBuffer pixelBuffer;

    @Getter
    @Setter
    @Nullable
    private Sprite hexSprite;

    private boolean isBufferPreloaded = false;

    @Override
    public void mergeBufferWith(@NonNull PixelBuffer targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetY, offsetY);
    }

    @Override
    public void mergeBufferWith(@NonNull Bufferable targetBuffer, int offsetX, int offsetY) {
        renderProvider.provide().render(pixelBuffer, targetBuffer, offsetY, offsetY);
    }

    @Override
    public void prepareBuffer() {
        if (!isBufferPreloaded) {
            preloadBuffer();
        }
    }

    private void preloadBuffer() {
        pixelBuffer.fillBuffer(0xFF04A804);

        for (int y = 0; y <= Math.ceil(pixelBuffer.getDimension().getHeightY() / hexSprite.getPixelBuffer().getDimension().getHeightY()); y++) {
            for (int x = 0; x <= Math.ceil(pixelBuffer.getDimension().getWidthX() / hexSprite.getPixelBuffer().getDimension().getWidthX()); x++) {
                int offsetX;
                int offsetY;
                if (!isOdd(x)) {
                    offsetX = x * hexSprite.getPixelBuffer().getDimension().getWidthX() - (15 * x);
                    offsetY = y * hexSprite.getPixelBuffer().getDimension().getHeightY();
                } else {
                    offsetX = x * hexSprite.getPixelBuffer().getDimension().getWidthX() - (15 * x);
                    offsetY = y * hexSprite.getPixelBuffer().getDimension().getHeightY() - 16;
                }
                renderProvider.provide().render(hexSprite.getPixelBuffer(), pixelBuffer, offsetX, offsetY);
            }
        }
    }

    private boolean isOdd(int number) {
        return ((number & 0x1) == 1);
    }

    @Override
    public void disposeBuffer() {

    }

}
