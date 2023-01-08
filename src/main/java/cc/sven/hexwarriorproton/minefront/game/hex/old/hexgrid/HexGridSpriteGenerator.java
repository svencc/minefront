package cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid;

import cc.sven.hexwarriorproton.minefront.engine.graphics.buffer.PixelBuffer;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid.HexMap;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class HexGridSpriteGenerator {

    public void renderHexGridToBuffer(HexMap hexMap, PixelBuffer pixelBuffer) {

    }

    @NonNull
    public PixelDimension calculateDimensions(@NonNull HexMap hexMap) {
        final AtomicReference<Double> maxHeight = new AtomicReference<>(0.0);
        final AtomicReference<Double> maxWidth = new AtomicReference<>(0.0);

        hexMap.getCubicHexList().forEach(hex -> {
            maxHeight.set(Math.max(maxHeight.get(), hex.getCenter().getY()));
            maxWidth.set(Math.max(maxWidth.get(), hex.getCenter().getX()));
        });

        double width = maxWidth.get() + (hexMap.getHexMapProperties().getMapOffsetX() * 2);
        double height = maxHeight.get() + (hexMap.getHexMapProperties().getMapOffsetY() * 2);

        final PixelDimension dimensions = PixelDimension.builder()
                .widthX((int) Math.ceil(width))
                .heightY((int) Math.ceil(height))
                .build();

        return scaleDimensionWithMapOffset(dimensions, hexMap);
    }

    @NonNull
    private PixelDimension scaleDimensionWithMapOffset(@NonNull PixelDimension dimension, @NonNull HexMap hexMap) {
        return dimension;
//        return PixelDimension.builder()
//                .widthX(dimension.getWidthX() + hexMap.getHexMapProperties().getMapOffsetX())
//                .heightY(dimension.getHeightY() + hexMap.getHexMapProperties().getMapOffsetY())
//                .build();
    }

}
