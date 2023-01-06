package cc.sven.hexwarriorproton.minefront.service.argb;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ARGBUtilities {


    public static int blend(final int color, final int background) {
        final double alpha = getAlphaComponent(color) / 255.0;
        final double oneMinusAlpha = 1 - alpha;

        final double newRed = ((getRedComponent(color) * alpha) + (oneMinusAlpha * getRedComponent(background)));
        final double newGreen = ((getGreenComponent(color) * alpha) + (oneMinusAlpha * getRedComponent(background)));
        final double newBlue = ((getBlueComponent(color) * alpha) + (oneMinusAlpha * getRedComponent(background)));
        final int newAlpha = getAlphaComponent(background);

        return compose(newAlpha, (int) newRed, (int) newGreen, (int) newBlue);
    }

    public int getAlphaComponent(final int color) {
        return (color >> 24) & 0xff;
    }

    public int getRedComponent(final int color) {
        return (color >> 16) & 0xff;
    }

    public int getGreenComponent(final int color) {
        return (color >> 8) & 0xff;
    }

    public int getBlueComponent(final int color) {
        return color & 0xff;
    }

    public int compose(final int alpha, final int red, final int green, final int blue) {
        return ((alpha & 0xFF) << 24) |
                ((red & 0xFF) << 16) |
                ((green & 0xFF) << 8) |
                ((blue & 0xFF << 0));
    }

}
