package cc.sven.hexwarriorproton.minefront.engine;

import cc.sven.hexwarriorproton.minefront.engine.units.TimeTick;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Ticker {

    @NonNull
    private final GameState gameState;

    public void tick(@NonNull TimeTick timeTick) {
        timeTick.tick();
    }

}
