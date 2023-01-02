package cc.sven.hexwarriorproton.minefront.engine.units;

import lombok.Getter;

public class StopWatch {

    @Getter
    private int time;

    public void tick() {
        time++;
    }

}
