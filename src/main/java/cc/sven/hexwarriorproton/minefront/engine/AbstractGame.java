package cc.sven.hexwarriorproton.minefront.engine;

public abstract class AbstractGame {

    void run() {
        init();
        startGame();
    }

    public abstract void init();

    public abstract void startGame();

}
