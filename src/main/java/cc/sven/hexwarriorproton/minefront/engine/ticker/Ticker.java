package cc.sven.hexwarriorproton.minefront.engine.ticker;

import cc.sven.hexwarriorproton.minefront.engine.GameState;
import cc.sven.hexwarriorproton.minefront.engine.units.StopWatch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Ticker {

    @NonNull
    private final GameState gameState;

    public void tick(@NonNull StopWatch stopWatch) {
        stopWatch.tick();
        System.out.println("Tick " + stopWatch.getTime());
    }

}
