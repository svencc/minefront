package cc.sven.hexwarriorproton.minefront.service.tick;

import cc.sven.hexwarriorproton.minefront.engine.units.StopWatch;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TickerService {

    @Getter
    @NonNull
    private final StopWatch stopWatch;

    public void tick() {
        stopWatch.tick();
    }

}
