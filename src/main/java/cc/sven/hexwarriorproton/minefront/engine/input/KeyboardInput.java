package cc.sven.hexwarriorproton.minefront.engine.input;

import lombok.NonNull;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

    public boolean up, down, left, right;
    private boolean[] keys = new boolean[120];

    public void update() {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(@NonNull final KeyEvent e) {
    }

    @Override
    public void keyPressed(@NonNull final KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(@NonNull final KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
}
