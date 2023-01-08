package cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid;

import cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid.enums.HexOrientation;
import cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid.enums.MapShape;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class HexMapProperties {

    @Builder.Default
    private int gridHeight = 17;

    @Builder.Default
    private int gridWidth = 15;

    @Builder.Default
    private MapShape mapShape = MapShape.ODD_Q;

    /**
     * Size of the hex (radius) in pixels.
     * Should be restless dividable by 4!
     */
    @Builder.Default
    private int outerRadius = 4 * 10;

    @Builder.Default
    private int mapOffsetFactor = 2;

    public int getMapOffsetX() {
        switch (getHexOrientation()) {
            case FLAT_TOP:
                return mapOffsetFactor * outerRadius;
            case POINTY_TOP:
                return (int) Math.ceil((outerRadius * Math.sqrt(3)) / 2 * mapOffsetFactor);
            default:
                throw new IllegalStateException("Undefined orientation!");
        }
    }

    @NonNull
    public HexOrientation getHexOrientation() {
        switch (mapShape) {
            case ODD_Q:
            case EQUAL_Q:
                return HexOrientation.FLAT_TOP;
            case ODD_R:
            case EQUAL_R:
                return HexOrientation.POINTY_TOP;
            default:
                throw new IllegalStateException("Undefined orientation!");
        }
    }

    public double getMapOffsetY() {
        switch (getHexOrientation()) {
            case FLAT_TOP:
                return (outerRadius * Math.sqrt(3)) / 2 * mapOffsetFactor;
            case POINTY_TOP:
                return mapOffsetFactor * outerRadius;
            default:
                throw new IllegalStateException("Undefined orientation!");
        }
    }

}
