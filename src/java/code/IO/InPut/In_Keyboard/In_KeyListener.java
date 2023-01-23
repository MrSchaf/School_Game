package code.IO.InPut.In_Keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class In_KeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        Keyboard_Keys.setPressedKey(true, code);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        Keyboard_Keys.setPressedKey(false, code);
    }
}