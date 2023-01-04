package cc.sven.hexwarriorproton.minefront.engine.graphics.scannable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Scannable;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import cc.sven.hexwarriorproton.minefront.service.RandomProvider;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ScannableNoise implements Scannable {

    @NonNull
    private final RandomProvider randomProvider;
    @Getter
    @NonNull
    private final PixelDimension dimension;

    @Override
    public int scanPixelAt(int x, int y) {
        return randomProvider.provide().nextInt() * (randomProvider.provide().nextInt(5) / 4);
    }

    @Override
    public int scanPixelAtIndex(int index) {
        return randomProvider.provide().nextInt() * (randomProvider.provide().nextInt(5) / 4);
    }

}
