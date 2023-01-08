package cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid.enums;

import lombok.NonNull;

public enum HexOrientation {
    FLAT_TOP, POINTY_TOP;

    public static HexOrientation orientation(@NonNull MapShape mapShape) {
        switch (mapShape) {
            case ODD_Q:
            case EQUAL_Q:
                return HexOrientation.FLAT_TOP;
//            case ODD_R:
//            case EQUAL_R:
//                return HexOrientation.POINTY_TOP;
            default:
                throw new IllegalStateException(mapShape + "not handled!");
        }
    }
}
