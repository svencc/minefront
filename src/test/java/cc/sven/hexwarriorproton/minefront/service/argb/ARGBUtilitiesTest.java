package cc.sven.hexwarriorproton.minefront.service.argb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ARGBUtilitiesTest {

    @Test
    void getAlpha() {
        // PREPARE
        int argb = 0xffaaaaaa;
        // EXECUTE
        int alphaComponent = ARGBUtilities.getAlphaComponent(argb);
        // ASSERT
        assertEquals(0xff, alphaComponent);
    }

    @Test
    void getAlpha1() {
        // PREPARE
        int argb = 0x00aaaaaa;
        // EXECUTE
        int alphaComponent = ARGBUtilities.getAlphaComponent(argb);
        // ASSERT
        assertEquals(0x00, alphaComponent);
    }

    @Test
    void getAlpha2() {
        // PREPARE
        int argb = 0x99aaaaaa;
        // EXECUTE
        int alphaComponent = ARGBUtilities.getAlphaComponent(argb);
        // ASSERT
        assertEquals(0x99, alphaComponent);
    }

    @Test
    void getRed() {
        // PREPARE
        int argb = 0xffaa9999;
        // EXECUTE
        int alphaComponent = ARGBUtilities.getRedComponent(argb);
        // ASSERT
        assertEquals(0xaa, alphaComponent);
    }

    @Test
    void getRed1() {
        // PREPARE
        int argb = 0x00ffaaaa;
        // EXECUTE
        int alphaComponent = ARGBUtilities.getRedComponent(argb);
        // ASSERT
        assertEquals(0xff, alphaComponent);
    }

    @Test
    void getGreen() {
        // PREPARE
        int argb = 0xff99aa99;
        // EXECUTE
        int alphaComponent = ARGBUtilities.getGreenComponent(argb);
        // ASSERT
        assertEquals(0xaa, alphaComponent);
    }

    @Test
    void getGreen1() {
        // PREPARE
        int argb = 0x00aaffaa;
        // EXECUTE
        int alphaComponent = ARGBUtilities.getGreenComponent(argb);
        // ASSERT
        assertEquals(0xff, alphaComponent);
    }

    @Test
    void getBlue() {
        // PREPARE
        int argb = 0xff9999aa;
        // EXECUTE
        int alphaComponent = ARGBUtilities.getBlueComponent(argb);
        // ASSERT
        assertEquals(0xaa, alphaComponent);
    }

    @Test
    void getBlue1() {
        // PREPARE
        int argb = 0x00aaaaff;
        // EXECUTE
        int alphaComponent = ARGBUtilities.getBlueComponent(argb);
        // ASSERT
        assertEquals(0xff, alphaComponent);
    }

    @Test
    void blendWhiteWithRed() {
        // PREPARE
        int solidWhite = 0xffffffff;
        int solidRed = 0xffff0000;
        // EXECUTE
        int mixedColor1 = ARGBUtilities.blend(solidWhite, solidRed);
        // ASSERT
        assertEquals(0xffffffff, mixedColor1);
    }

    @Test
    void blendSolids_WhiteWithBlack() {
        // PREPARE
        int solidWhiteForeground = 0xffffffff;
        int solidBlackBackground = 0xff000000;
        // EXECUTE
        int mixedColor = ARGBUtilities.blend(solidWhiteForeground, solidBlackBackground);
        // ASSERT
        assertEquals(solidWhiteForeground, mixedColor);
    }

    @Test
    void blendSolidWhiteWithAlphaRed() {
        // PREPARE
        int solidWhiteBackground = 0xffFFFFFF;
        int alphaRedForeground = 0x7dFF0000;
        // EXECUTE
        int mixedColor1 = ARGBUtilities.blend(alphaRedForeground, solidWhiteBackground);
        // ASSERT
        assertEquals(0xffFF8282, mixedColor1);
    }

}