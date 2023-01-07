package cc.sven.hexwarriorproton.minefront.service.profiler;

import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public final class FPSCounterProvider {

    @NonNull
    public FPSCounter provide() {
        return new FPSCounter();
    }

}
