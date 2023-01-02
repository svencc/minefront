package cc.sven.hexwarriorproton.minefront.service.profiler;

import lombok.Getter;
import lombok.Setter;

public class TPSTimer {

    @Getter
    @Setter
    private static double targetTps = 60.0;

    public static double getMinNanosBeforeNewTick() {
        return TimeUnit.SECOND_IN_NANOS / targetTps;
    }

}
