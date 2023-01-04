package cc.sven.hexwarriorproton.minefront.engine.graphics.mergeable;

import cc.sven.hexwarriorproton.minefront.engine.graphics.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Scannable;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ScannableMergeable implements Scannable, Mergeable {

    @Getter
    @NonNull
    protected final PixelDimension Dimension;

}
