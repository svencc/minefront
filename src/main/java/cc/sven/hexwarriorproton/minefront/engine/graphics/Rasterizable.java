package cc.sven.hexwarriorproton.minefront.engine.graphics;

import cc.sven.hexwarriorproton.minefront.engine.graphics.render.Renderable;
import cc.sven.hexwarriorproton.minefront.engine.units.StopWatch;
import lombok.NonNull;

public interface Rasterizable {

    void rasterize(@NonNull StopWatch stopWatch);

    void setPixelAt(@NonNull Renderable renderTo, int x, int y, int width, int newPixelValue);

}
