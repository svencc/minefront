package cc.sven.hexwarriorproton.minefront.engine.input;

import lombok.Getter;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static java.awt.event.MouseEvent.BUTTON1;
import static java.awt.event.MouseEvent.BUTTON3;

public class MouseInput implements MouseListener, MouseMotionListener {

    @Getter
    private int mouseX = -1;
    @Getter
    private int mouseY = -1;
    @Getter
    private boolean mousePrimaryButton = false;
    @Getter
    private boolean mouseSecondaryButton = false;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == BUTTON1) mousePrimaryButton = true;
        if (e.getButton() == BUTTON3) mouseSecondaryButton = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == BUTTON1) mousePrimaryButton = false;
        if (e.getButton() == BUTTON3) mouseSecondaryButton = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

}
