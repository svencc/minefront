package cc.sven.hexwarriorproton.minefront.game.hex.old.hexgrid;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScreenCoordinate {

    private double x;
    private double y;

    public ScreenCoordinate(float x, float y) {
        this.x = (double) x;
        this.y = (double) y;
    }

    public ScreenCoordinate(long x, long y) {
        this.x = (double) x;
        this.y = (double) y;
    }

    public ScreenCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ScreenCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static class ScreenCoordinateBuilder {

        public ScreenCoordinateBuilder x(float floatX) {
            this.x = (double) floatX;
            return this;
        }

        public ScreenCoordinateBuilder x(double longX) {
            this.x = (double) longX;
            return this;
        }

        public ScreenCoordinateBuilder x(int intX) {
            this.x = (double) intX;
            return this;
        }

        public ScreenCoordinateBuilder x(long longX) {
            this.x = (double) longX;
            return this;
        }


        public ScreenCoordinateBuilder y(float floatY) {
            this.y = (double) floatY;
            return this;
        }

        public ScreenCoordinateBuilder y(double longY) {
            this.y = (double) longY;
            return this;
        }

        public ScreenCoordinateBuilder y(int intY) {
            this.y = (double) intY;
            return this;
        }

        public ScreenCoordinateBuilder y(long longY) {
            this.y = (double) longY;
            return this;
        }
    }

}
