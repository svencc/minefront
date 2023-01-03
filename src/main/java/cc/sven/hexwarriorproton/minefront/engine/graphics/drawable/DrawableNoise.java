package cc.sven.hexwarriorproton.minefront.engine.graphics.drawable;

import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.NonNull;

import java.util.Random;

public class DrawableNoise extends BaseDrawable {

    private final Random random;

    public DrawableNoise(@NonNull PixelDimension dimension) {
        super(dimension);
        random = new Random();
        initialize();
    }

    public void initialize() {
        pixelRaster = new int[getDimension().getWidth() * getDimension().getHeight()];
        for (int i = 0; i < getDimension().getWidth() * getDimension().getHeight(); i++) {
            pixelRaster[i] = random.nextInt() * (random.nextInt(5) / 4);
        }
    }

    public int getPixelAt(int x, int y, int width) {
        return random.nextInt() * (random.nextInt(5) / 4);
    }


}
