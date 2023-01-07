package cc.sven.hexwarriorproton.minefront.service.argb;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public final class ARGBCalculatorProvider {

    @Nullable
    private ARGBCalculator instance;

    public ARGBCalculator provide() {
        if (instance == null) {
            instance = new ARGBCalculator();
        }

        return instance;
    }

}
