package cc.sven.hexwarriorproton.minefront.service.profiler;

import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class TPSCounterProvider {

    @NonNull
    public TPSCounter provide() {
        return new TPSCounter();
    }

}
