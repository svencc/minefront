package cc.sven.hexwarriorproton.minefront.game.hex.level;

import cc.sven.hexwarriorproton.minefront.engine.components.sprite.Sprite;
import cc.sven.hexwarriorproton.minefront.engine.components.tile.Tile;
import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelCoordinate;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
@Builder
public class HexTile implements Tile {

    @Getter
    @NonNull
    private final PixelCoordinate position;
    @Getter
    @NonNull
    private final Sprite sprite;
    private final int layoutNumeration;
    private final int q;
    private final int r;
    private final int s;
    @Getter
    @NonNull
    private final HexMap hexMap;

    @Override
    public PixelBuffer getPixelBuffer() {
        return sprite.getPixelBuffer();
    }

}
