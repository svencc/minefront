package cc.sven.hexwarriorproton.minefront.service.tick;

import cc.sven.hexwarriorproton.minefront.engine.units.StopWatch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TickerService {

    public void tick(@NonNull StopWatch stopWatch) {
        stopWatch.tick();
    }

}
