package cc.sven.hexwarriorproton.minefront.game.hexgrid;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Builder
public class HexMap {

    @NonNull
    private HexMapProperties hexMapProperties;

    @NonNull
    @Builder.Default
    private List<CubicHex> cubicHexList = new ArrayList<>();

    @NonNull
    public Optional<CubicHex> pixelToHex(double x, double y) {
        final double q = (2.0 / 3 * x) / hexMapProperties.getOuterRadius();
        final double r = (-1.0 / 3 * x + Math.sqrt(3) / 3 * y) / hexMapProperties.getOuterRadius();

        final double roundedQ = Math.round(q);
        final double roundedR = Math.round(r);

        return cubicHexList.stream()
                .filter((CubicHex hex) -> {
                    return hex.getQ() == roundedQ && hex.getR() == roundedR;
                })
                .findFirst();
    }

    public void zoomOut() {
        hexMapProperties.setOuterRadius(hexMapProperties.getOuterRadius() - 10);
//        hexMapProperties.setMapOffsetFactor(hexMapProperties.getMapOffsetFactor() - 0.5);
    }

    public void zoomIn() {
        hexMapProperties.setOuterRadius(hexMapProperties.getOuterRadius() + 10);
//        hexMapProperties.setMapOffsetFactor(hexMapProperties.getMapOffsetFactor() + 0.5);
    }
}
