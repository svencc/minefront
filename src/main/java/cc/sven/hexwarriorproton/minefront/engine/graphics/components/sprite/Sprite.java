package cc.sven.hexwarriorproton.minefront.engine.graphics.components.sprite;

import cc.sven.hexwarriorproton.minefront.engine.graphics.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

@RequiredArgsConstructor
public class Sprite implements HasPixelBuffer {

    @Getter
    @NonNull
    private final PixelBuffer pixelBuffer;
    @Nullable
    private final SpriteAtlas spriteAtlas;

    /*
    private void fromSpriteAtlas(boolean invertX, boolean invertY) {
        for (int y = 0; y < SIZE; y++) {
            int pickY = y;
            if (invertY) pickY = SIZE - y;
            for (int x = 0; x < SIZE; x++) {
                int pickX = x;
                if (invertX) pickX = SIZE - x;
                pixels[x + y * SIZE] = sheet.pixels[(pickX + this.x) + (pickY + this.y) * sheet.SIZE_SPRITESHEET];
            }
        }
    }

     */


}
