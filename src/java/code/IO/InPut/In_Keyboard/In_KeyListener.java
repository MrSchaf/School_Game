package code.IO.InPut.In_Keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class In_KeyListener implements KeyListener {
    private final Keyboard_Keys keyboardKeys;

    public In_KeyListener(Keyboard_Keys keyboardKeys) {
        this.keyboardKeys = keyboardKeys;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        keyboardKeys.setPressedKey(true, code);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        keyboardKeys.setPressedKey(false, code);
    }
}