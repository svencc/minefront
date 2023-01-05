package cc.sven.hexwarriorproton.minefront.engine.graphics.components.tile;

import cc.sven.hexwarriorproton.minefront.engine.graphics.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.components.sprite.Sprite;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Tile implements HasPixelBuffer {

    @NonNull
    private final Sprite sprite;


    @Override
    public PixelBuffer getPixelBuffer() {
        return sprite.getPixelBuffer();
    }

}
