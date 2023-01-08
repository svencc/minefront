package cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid.strategy;

import cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid.CubicHex;
import cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid.HexMap;
import cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid.HexMapProperties;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class RectangularFlatToppedEqualUpLayoutStrategy {

    @NonNull
    public HexMap layout(@NonNull HexMapProperties properties) {
        final HexMap hexMap = HexMap.builder()
                .hexMapProperties(properties)
                .build();

        final List<CubicHex> cubicHexList = new ArrayList<>();

        int top = 0;
        int left = 0;
        int bottom = properties.getGridHeight() - 1;
        int right = properties.getGridWidth() - 1;

        long layoutNumeration = 1;
        for (int q = left; q <= right; q++) {
            long qOffset = offsetCalculator(q); // or q>>1
            for (long r = top - qOffset; r <= bottom - qOffset; r++) {
                cubicHexList.add(new CubicHex(layoutNumeration, q, r, hexMap));
                layoutNumeration++;
            }
        }

        hexMap.setCubicHexList(cubicHexList);

        return hexMap;
    }

    private long offsetCalculator(int q) {
        return (long) Math.floor(q / 2.0);
    }

    private long offsetCalculator2(int q) {
        return (long) Math.floor(q + 1 / 2.0);
    }

    private long offsetCalculator3(int q) {
        return (long) Math.floor(q - 1 / 2.0);
    }

}
