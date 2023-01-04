package cc.sven.hexwarriorproton.minefront.game.renderer.map;

import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.graphics.mergeable.BufferedMergeable;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import cc.sven.hexwarriorproton.minefront.game.hexgrid.HexMap;
import lombok.NonNull;

import java.util.Optional;

public class HexMapMergeable extends BufferedMergeable {

    @NonNull
    private final MapRenderer mapRenderer;

    @NonNull
    private Optional<HexMap> hexMap = Optional.empty();

    public HexMapMergeable(@NonNull PixelDimension dimension) {
        super(dimension);
        this.mapRenderer = new MapRenderer(dimension);
    }

    public void setHexMap(@NonNull HexMap newHexMap) {
        this.hexMap = Optional.of(newHexMap);
    }


    @Override
    public int scanPixelAt(int x, int y) {
        return 0;
    }

    @Override
    public int scanPixelAtIndex(int index) {
        return 0;
    }

    @Override
    public void mergeWith(@NonNull PixelBuffer pixelBuffer, int offsetX, int offsetY) {

    }
}
