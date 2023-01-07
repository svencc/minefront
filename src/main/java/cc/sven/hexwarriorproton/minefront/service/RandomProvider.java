package cc.sven.hexwarriorproton.minefront.service;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public final class RandomProvider {

    @Nullable
    private Random instance;

    public Random provide() {
        if (instance == null) {
            instance = new Random();
        }

        return instance;
    }

}
