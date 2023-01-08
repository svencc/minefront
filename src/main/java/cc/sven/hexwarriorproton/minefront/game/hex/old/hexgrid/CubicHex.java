package cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Scanable;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class CubicHex implements Scanable {

    private final long layoutNumeration;
    private final long q;
    private final long r;
    private final long s;

    @NonNull
    private HexMap hexMap;
    @NonNull
    private ScreenCoordinate center;

    @Builder
    public CubicHex(long layoutNumeration, long q, long r, @NonNull HexMap hexMap) {
        this.layoutNumeration = layoutNumeration;
        this.q = q;
        this.r = r;
        this.s = -q - r;
        this.hexMap = hexMap;

        // derived values/calculations
        this.center = hexCenterToPixel();
    }

    /**
     * Calculates the center pixel coordinate of this hex
     *
     * @return The calculated PixelCoordinate
     */
    @NonNull
    public ScreenCoordinate hexCenterToPixel() {
        final double x = hexMap.getHexMapProperties().getOuterRadius() * (3.0 / 2 * q);
        final double y = hexMap.getHexMapProperties().getOuterRadius() * (Math.sqrt(3) / 2 * q + Math.sqrt(3) * r);

        return new ScreenCoordinate(x, y);
    }

    /**
     * Starts with (top) right corner
     *
     * @return All 5 corner Points
     */
    public List<ScreenCoordinate> corners() {
        final List<ScreenCoordinate> corners = new ArrayList<>();
        switch (hexMap.getHexMapProperties().getHexOrientation()) {
            case FLAT_TOP:
                for (int i = 0; i < 6; i++) {
                    corners.add(flatHexCorner(hexMap.getHexMapProperties().getOuterRadius(), i));
                }
                return corners;
            case POINTY_TOP:
                for (int i = 0; i < 6; i++) {
                    corners.add(pointyHexCorner(hexMap.getHexMapProperties().getOuterRadius(), i));
                }
                return corners;
            default:
                throw new IllegalStateException("Orientation is not set or handled!");
        }
    }

    /**
     * Calculates each x/y position of a hex´s corner
     *
     * @param size      Size of the hex (radius) in pixels
     * @param nthCorner Nr. of corner 0-5
     * @return
     */
    private ScreenCoordinate flatHexCorner(int size, int nthCorner) {
        long angleDegree = 60L * nthCorner;
        double angleRadian = Math.PI / 180 * angleDegree;

        final ScreenCoordinate build = ScreenCoordinate.builder()
                .x(center.getX() + size * Math.cos(angleRadian))
                .y((center.getY() + size * Math.sin(angleRadian)))
                .build();
        return build;
    }

    /**
     * Calculates each x/y position of a hex´s corner
     *
     * @param size      Size of the hex (radius) in pixels
     * @param nthCorner Nr. of corner 0-5
     * @return
     */
    private ScreenCoordinate pointyHexCorner(int size, int nthCorner) {
        long angleDegree = (60L * nthCorner) - 30L;
        double angleRadian = Math.PI / 180 * angleDegree;

        return ScreenCoordinate.builder()
                .x(center.getX() + size * Math.cos(angleRadian))
                .y((center.getY() + size * Math.sin(angleRadian)))
                .build();
    }

    @Override
    public PixelDimension getDimension() {
        return null;
    }

    @Override
    public int scanPixelAt(int x, int y) {
        return 0;
    }

    @Override
    public int scanPixelAtIndex(int index) {
        return 0;
    }

//    @Override
//    public int[] accessPixelBuffer() {
//        return new int[0];
//    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    public CubicHex add(CubicHex b) {
        return new CubicHex(q + b.q, r + b.r);
    }


    public CubicHex subtract(CubicHex b) {
        return new CubicHex(q - b.q, r - b.r);
    }


    public CubicHex scale(int k) {
        return new CubicHex(q * k, r * k);
    }


    public CubicHex rotateLeft() {
        return new CubicHex(-s, -q);
    }


    public CubicHex rotateRight() {
        return new CubicHex(-r, -s);
    }

    static public ArrayList<CubicHex> directions = new ArrayList<CubicHex>() {{
        add(new CubicHex(1, 0));
        add(new CubicHex(1, -1));
        add(new CubicHex(0, -1));
        add(new CubicHex(-1, 0));
        add(new CubicHex(-1, 1));
        add(new CubicHex(0, 1));
    }};

    static public CubicHex direction(int direction) {
        return CubicHex.directions.get(direction);
    }


    public CubicHex neighbor(int direction) {
        return add(CubicHex.direction(direction));
    }

    static public ArrayList<CubicHex> diagonals = new ArrayList<CubicHex>() {{
        add(new CubicHex(2, -1));
        add(new CubicHex(1, -2));
        add(new CubicHex(-1, -1));
        add(new CubicHex(-2, 1));
        add(new CubicHex(-1, 2));
        add(new CubicHex(1, 1));
    }};

    public CubicHex diagonalNeighbor(int direction) {
        return add(CubicHex.diagonals.get(direction));
    }


    public int length() {
        return (int) ((Math.abs(q) + Math.abs(r) + Math.abs(s)) / 2);
    }


    public int distance(CubicHex b) {
        return subtract(b).length();
    }
     */

}
