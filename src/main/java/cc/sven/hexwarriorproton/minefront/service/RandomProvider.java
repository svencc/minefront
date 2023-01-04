package cc.sven.hexwarriorproton.minefront.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomProvider {

    private Random singletonInstance;

    public Random provide() {
        if (singletonInstance == null) {
            singletonInstance = new Random();
        }

        return singletonInstance;
    }

}
