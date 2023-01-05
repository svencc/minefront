package cc.sven.hexwarriorproton.minefront.service.argb;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ARGBUtilities {


    public static int blend(int color, int background) {
        double alpha = getAlphaComponent(color) / 255.0;
        double oneMinusAlpha = 1 - alpha;

        double newRed = ((getRedComponent(color) * alpha) + (oneMinusAlpha * getRedComponent(background)));
        double newGreen = ((getGreenComponent(color) * alpha) + (oneMinusAlpha * getRedComponent(background)));
        double newBlue = ((getBlueComponent(color) * alpha) + (oneMinusAlpha * getRedComponent(background)));
        int newAlpha = getAlphaComponent(background);

        return compose(newAlpha, (int) newRed, (int) newGreen, (int) newBlue);
    }

    public int getAlphaComponent(int color) {
        return (color >> 24) & 0xff;
    }

    public int getRedComponent(int color) {
        return (color >> 16) & 0xff;
    }

    public int getGreenComponent(int color) {
        return (color >> 8) & 0xff;
    }

    public int getBlueComponent(int color) {
        return color & 0xff;
    }

    public int compose(int alpha, int red, int green, int blue) {
        return ((alpha & 0xFF) << 24) |
                ((red & 0xFF) << 16) |
                ((green & 0xFF) << 8) |
                ((blue & 0xFF << 0));
    }

}
