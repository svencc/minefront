package cc.sven.hexwarriorproton.minefront.engine.components.tile;

import cc.sven.hexwarriorproton.minefront.engine.components.HasPixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.components.Positionable;
import cc.sven.hexwarriorproton.minefront.engine.components.sprite.Sprite;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelCoordinate;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Tile implements HasPixelBuffer, Positionable {

    @Getter
    @NonNull
    private final PixelCoordinate position;
    @NonNull
    private final Sprite sprite;


    @Override
    public PixelBuffer getPixelBuffer() {
        return sprite.getPixelBuffer();
    }

}
