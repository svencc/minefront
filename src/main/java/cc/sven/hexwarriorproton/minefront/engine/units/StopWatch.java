package cc.sven.hexwarriorproton.minefront.engine.units;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class StopWatch {

    @Getter
    private int time;

    public void tick() {
        time++;
    }

}
