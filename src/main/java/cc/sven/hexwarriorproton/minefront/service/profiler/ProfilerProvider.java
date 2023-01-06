package cc.sven.hexwarriorproton.minefront.service.profiler;

import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ProfilerProvider {

    @NonNull
    public Profiler provide(@NonNull final String profilerName) {
        return new Profiler(profilerName);
    }

}
