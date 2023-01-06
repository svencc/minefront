package cc.sven.hexwarriorproton.minefront.engine.graphics.scanable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Scanable;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import cc.sven.hexwarriorproton.minefront.service.RandomProvider;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ScanableNoise implements Scanable {

    @NonNull
    private final RandomProvider randomProvider;
    @Getter
    @NonNull
    private final PixelDimension dimension;

    @Override
    public int scanPixelAt(final int x, final int y) {
        return randomProvider.provide().nextInt() * (randomProvider.provide().nextInt(5) / 4);
    }

    @Override
    public int scanPixelAtIndex(final int index) {
        return randomProvider.provide().nextInt() * (randomProvider.provide().nextInt(5) / 4);
    }

}
