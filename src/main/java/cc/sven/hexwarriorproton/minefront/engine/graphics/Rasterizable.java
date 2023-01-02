package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.units.StopWatch;
import lombok.NonNull;

public interface Rasterizable {

    void rasterize(@NonNull StopWatch stopWatch);

}
