package cc.sven.hexwarriorproton.minefront.engine.units;

import lombok.Getter;

public class TimeTick {

    @Getter
    private int time;

    public void tick() {
        time++;
    }

}
