package cc.sven.hexwarriorproton.minefront.service.profiler;

import lombok.Getter;
import lombok.NonNull;

public class Profiler {

    private final String profilerName;
    private long nanotimeStart;

    @Getter
    private long profiledNanos;
    @Getter
    private double profiledMilliseconds;

    Profiler(String profilerName) {
        this.profilerName = profilerName;
    }

    public void startNextMeasurement() {
        nanotimeStart = System.nanoTime();
    }

    public void measure() {
        profiledNanos = System.nanoTime() - nanotimeStart;
        profiledMilliseconds = profiledNanos / TimeUnit.SECOND_IN_NANOS;
    }

    public void printResult() {
        System.out.println(stringifyResult());
    }

    @NonNull
    public String stringifyResult() {
        return "Run " + profilerName + " in " + profiledNanos + " ns | " + profiledMilliseconds + " ms";
    }

}
