package cc.sven.hexwarriorproton.minefront.engine.graphics.scannable;

import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.NonNull;

import java.util.Random;

public class ScannableNoise extends ScannableBase {

    private final Random random;

    public ScannableNoise(@NonNull PixelDimension dimension) {
        super(dimension);
        random = new Random();
    }

    @Override
    public int scanPixelAt(int x, int y) {
        return random.nextInt() * (random.nextInt(5) / 4);
    }

    @Override
    public int scanPixelAtIndex(int index) {
        return random.nextInt() * (random.nextInt(5) / 4);
    }

}
