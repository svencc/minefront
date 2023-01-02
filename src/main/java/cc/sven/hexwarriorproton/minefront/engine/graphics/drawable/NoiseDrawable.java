package cc.sven.hexwarriorproton.minefront.engine.graphics.drawable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.drawable.BaseDrawable;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;

import java.util.Random;

public class NoiseDrawable extends BaseDrawable {

    private final Random random = new Random();

    public NoiseDrawable(int width, int height) {
        super(width, height);
        initialize();
    }

    public void initialize() {
        pixelRaster = new int[dimension.getWidth() * dimension.getHeight()];
        for (int i = 0; i < dimension.getWidth() * dimension.getHeight(); i++) {
            pixelRaster[i] = random.nextInt() * (random.nextInt(5) / 4);
        }
    }

    public NoiseDrawable(PixelDimension dimension) {
        super(dimension);
        initialize();
    }

    public int getPixelAt(int x, int y, int width) {
        return random.nextInt() * (random.nextInt(5) / 4);
    }


}
