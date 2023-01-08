package cc.sven.hexwarriorproton.minefront.engine.components.mergeable;

import cc.sven.hexwarriorproton.minefront.engine.components.Mergeable;
import cc.sven.hexwarriorproton.minefront.engine.graphics.Scanable;
import cc.sven.hexwarriorproton.minefront.engine.units.PixelDimension;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ScanableMergeableTemplate implements Scanable, Mergeable {

    @Getter
    @NonNull
    protected final PixelDimension Dimension;

}
