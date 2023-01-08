package cc.sven.hexwarriorproton.minefront.game.hex.level;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class HexMapLayouter {

    @NonNull
    public HexMap layout(@NonNull HexMapConfiguration hexMapConfiguration) {
        final HexMap hexMap = HexMap.builder()
                .HexMapConfiguration(hexMapConfiguration)
                .build();

        final List<HexTile> cubicHexList = new ArrayList<>();

        int top = 0;
        int left = 0;
        int bottom = hexMapConfiguration.getGridHeight() - 1;
        int right = hexMapConfiguration.getGridWidth() - 1;

        long layoutNumeration = 1;
        for (int q = left; q <= right; q++) {
            long qOffset = offsetCalculator(q); // or q>>1
            for (long r = top - qOffset; r <= bottom - qOffset; r++) {
//                cubicHexList.add(new HexTile(layoutNumeration, q, r, hexMap));
                layoutNumeration++;
            }
        }

        hexMap.setHexTiles(cubicHexList);

        return hexMap;
    }

    private long offsetCalculator(int q) {
        return (long) Math.floor(q / 2.0);
    }

}
