package cc.sven.hexwarriorproton.minefront.service.tick;

import cc.sven.hexwarriorproton.minefront.engine.units.TimeUnits;
import cc.sven.hexwarriorproton.minefront.property.TickProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TickCalculator {

    @NonNull
    private final TickProperties tickProperties;

    public double calculateTickThresholdRatio(double profiledNanos) {
        return profiledNanos / nanosPerTick();
    }

    public double nanosPerTick() {
        return TimeUnits.SECOND_IN_NANOS / tickProperties.getTicksPerSecond();
    }

}
