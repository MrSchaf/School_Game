package code.IO.InPut.In_Keyboard;

import code.Calc.Actions.Action_Listener;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Keyboard_Keys {
    private final In_KeyListener keyListener;
    public static final Keyboard_Key Key_A = new Keyboard_Key(KeyEvent.VK_A, "A");
    public static final Keyboard_Key Key_B = new Keyboard_Key(KeyEvent.VK_B, "B");
    public static final Keyboard_Key Key_C = new Keyboard_Key(KeyEvent.VK_C, "C");
    public static final Keyboard_Key Key_D = new Keyboard_Key(KeyEvent.VK_D, "D");
    public static final Keyboard_Key Key_E = new Keyboard_Key(KeyEvent.VK_E, "E");
    public static final Keyboard_Key Key_F = new Keyboard_Key(KeyEvent.VK_F, "F");
    public static final Keyboard_Key Key_G = new Keyboard_Key(KeyEvent.VK_G, "G");
    public static final Keyboard_Key Key_H = new Keyboard_Key(KeyEvent.VK_H, "H");
    public static final Keyboard_Key Key_I = new Keyboard_Key(KeyEvent.VK_I, "I");
    public static final Keyboard_Key Key_J = new Keyboard_Key(KeyEvent.VK_J, "J");
    public static final Keyboard_Key Key_K = new Keyboard_Key(KeyEvent.VK_K, "K");
    public static final Keyboard_Key Key_L = new Keyboard_Key(KeyEvent.VK_L, "L");
    public static final Keyboard_Key Key_M = new Keyboard_Key(KeyEvent.VK_M, "M");
    public static final Keyboard_Key Key_N = new Keyboard_Key(KeyEvent.VK_N, "N");
    public static final Keyboard_Key Key_O = new Keyboard_Key(KeyEvent.VK_O, "O");
    public static final Keyboard_Key Key_P = new Keyboard_Key(KeyEvent.VK_P, "P");
    public static final Keyboard_Key Key_Q = new Keyboard_Key(KeyEvent.VK_Q, "Q");
    public static final Keyboard_Key Key_R = new Keyboard_Key(KeyEvent.VK_R, "R");
    public static final Keyboard_Key Key_S = new Keyboard_Key(KeyEvent.VK_S, "S");
    public static final Keyboard_Key Key_T = new Keyboard_Key(KeyEvent.VK_T, "T");
    public static final Keyboard_Key Key_U = new Keyboard_Key(KeyEvent.VK_U, "U");
    public static final Keyboard_Key Key_V = new Keyboard_Key(KeyEvent.VK_V, "V");
    public static final Keyboard_Key Key_W = new Keyboard_Key(KeyEvent.VK_W, "W");
    public static final Keyboard_Key Key_X = new Keyboard_Key(KeyEvent.VK_X, "X");
    public static final Keyboard_Key Key_Y = new Keyboard_Key(KeyEvent.VK_Y, "Y");
    public static final Keyboard_Key Key_Z = new Keyboard_Key(KeyEvent.VK_Z, "Z");
    public static final Keyboard_Key Key_0 = new Keyboard_Key(KeyEvent.VK_0, "0");
    public static final Keyboard_Key Key_1 = new Keyboard_Key(KeyEvent.VK_1, "1");
    public static final Keyboard_Key Key_2 = new Keyboard_Key(KeyEvent.VK_2, "2");
    public static final Keyboard_Key Key_3 = new Keyboard_Key(KeyEvent.VK_3, "3");
    public static final Keyboard_Key Key_4 = new Keyboard_Key(KeyEvent.VK_4, "4");
    public static final Keyboard_Key Key_5 = new Keyboard_Key(KeyEvent.VK_5, "5");
    public static final Keyboard_Key Key_6 = new Keyboard_Key(KeyEvent.VK_6, "6");
    public static final Keyboard_Key Key_7 = new Keyboard_Key(KeyEvent.VK_7, "7");
    public static final Keyboard_Key Key_8 = new Keyboard_Key(KeyEvent.VK_8, "8");
    public static final Keyboard_Key Key_9 = new Keyboard_Key(KeyEvent.VK_9, "9");
    public static final Keyboard_Key Key_Space = new Keyboard_Key(KeyEvent.VK_SPACE, "Space");
    public static final Keyboard_Key Key_Shift = new Keyboard_Key(KeyEvent.VK_SHIFT, "Shift");
    public static final Keyboard_Key Key_Control = new Keyboard_Key(KeyEvent.VK_CONTROL, "Control");
    public static final Keyboard_Key Key_Alt = new Keyboard_Key(KeyEvent.VK_ALT, "Alt");
    public static final Keyboard_Key Key_Up = new Keyboard_Key(KeyEvent.VK_UP, "Up");
    public static final Keyboard_Key Key_Down = new Keyboard_Key(KeyEvent.VK_DOWN, "Down");
    public static final Keyboard_Key Key_Left = new Keyboard_Key(KeyEvent.VK_LEFT, "Left");
    public static final Keyboard_Key Key_Right = new Keyboard_Key(KeyEvent.VK_RIGHT, "Right");
    public static final Keyboard_Key Key_Enter = new Keyboard_Key(KeyEvent.VK_ENTER, "Enter");
    public static final Keyboard_Key Key_Escape = new Keyboard_Key(KeyEvent.VK_ESCAPE, "Escape");
    public static final Keyboard_Key Key_Backspace = new Keyboard_Key(KeyEvent.VK_BACK_SPACE, "Backspace");
    public static final Keyboard_Key Key_Tab = new Keyboard_Key(KeyEvent.VK_TAB, "Tab");
    public static final Keyboard_Key Key_F1 = new Keyboard_Key(KeyEvent.VK_F1, "F1");
    public static final Keyboard_Key Key_F2 = new Keyboard_Key(KeyEvent.VK_F2, "F2");
    public static final Keyboard_Key Key_F3 = new Keyboard_Key(KeyEvent.VK_F3, "F3");
    public static final Keyboard_Key Key_F4 = new Keyboard_Key(KeyEvent.VK_F4, "F4");
    public static final Keyboard_Key Key_F5 = new Keyboard_Key(KeyEvent.VK_F5, "F5");
    public static final Keyboard_Key Key_F6 = new Keyboard_Key(KeyEvent.VK_F6, "F6");
    public static final Keyboard_Key Key_F7 = new Keyboard_Key(KeyEvent.VK_F7, "F7");
    public static final Keyboard_Key Key_F8 = new Keyboard_Key(KeyEvent.VK_F8, "F8");
    public static final Keyboard_Key Key_F9 = new Keyboard_Key(KeyEvent.VK_F9, "F9");
    public static final Keyboard_Key Key_F10 = new Keyboard_Key(KeyEvent.VK_F10, "F10");
    public static final Keyboard_Key Key_F11 = new Keyboard_Key(KeyEvent.VK_F11, "F11");
    public static final Keyboard_Key Key_F12 = new Keyboard_Key(KeyEvent.VK_F12, "F12");
    public static final Keyboard_Key Key_F13 = new Keyboard_Key(KeyEvent.VK_F13, "F13");
    public static final Keyboard_Key Key_F14 = new Keyboard_Key(KeyEvent.VK_F14, "F14");
    public static final Keyboard_Key Key_F15 = new Keyboard_Key(KeyEvent.VK_F15, "F15");
    public static final Keyboard_Key Key_F16 = new Keyboard_Key(KeyEvent.VK_F16, "F16");

    private static final ArrayList<Keyboard_Key>  keys = new ArrayList<>(Arrays.asList(
    Key_A, Key_B, Key_C, Key_D, Key_E, Key_F, Key_G, Key_H, Key_I, Key_J, Key_K, Key_L, Key_M, Key_N, Key_O, Key_P, Key_Q, Key_R, Key_S, Key_T, Key_U, Key_V, Key_W, Key_X, Key_Y, Key_Z,
    Key_0, Key_1, Key_2, Key_3, Key_4, Key_5, Key_6, Key_7, Key_8, Key_9,
    Key_Space, Key_Shift, Key_Control, Key_Alt, Key_Up, Key_Down, Key_Left, Key_Right, Key_Enter, Key_Escape, Key_Backspace, Key_Tab,
    Key_F1, Key_F2, Key_F3, Key_F4, Key_F5, Key_F6, Key_F7, Key_F8, Key_F9, Key_F10, Key_F11, Key_F12, Key_F13, Key_F14, Key_F15, Key_F16));

    private final Vector<Keyboard_Key> pressedKeys = new Vector<>();

    public Keyboard_Keys() {
        keyListener = new In_KeyListener(this);
    }

    private Keyboard_Key getKey(int keyCode) {
        for (Keyboard_Key key : keys) {
            if (key.getCode() == keyCode) {
                return key;
            }
        }
        return null;
    }

    private Keyboard_Key getKey(String keyName) {
        for (Keyboard_Key key : keys) {
            if (key.getName().equals(keyName)) {
                return key;
            }
        }
        return null;
    }

    private Keyboard_Key getKey(Keyboard_Key key) {
        for (Keyboard_Key k : keys) {
            if (k.equals(key)) {
                return k;
            }
        }
        return null;
    }

    public void tick(){
        Vector<Keyboard_Key> releasedKeys = new Vector<>();

        for(Keyboard_Key key : pressedKeys){
            key.keyPressed();
            if(!key.isPressed()){
                key.keyReleased();
                releasedKeys.add(key);
            }
        }

        for (Keyboard_Key key : releasedKeys) {
            removePressedKey(key);
        }
    }

    public void setPressedKey(boolean pressed, int keyCode){
        if(containsKey(keyCode)){
            if(pressed) {
                addPressedKey(getKey(keyCode));
            }
        }
    }

    public boolean containsKey(int keyCode){
        return getKey(keyCode) != null;
    }

    private void addPressedKey(Keyboard_Key key){
        if(!pressedKeys.contains(key)){
            pressedKeys.add(key);
        }
    }

    private void removePressedKey(Keyboard_Key key){
        pressedKeys.remove(key);
    }

    public void addKeyListener(Action_Listener listener, Keyboard_Key key){
        getKey(key).addActionListener(listener);
    }

    public void removeKeyListener(Action_Listener listener, Keyboard_Key key){
        getKey(key).removeActionListener(listener);
    }

    public void addKeyListener(Action_Listener listener, String keyName){
        getKey(keyName).addActionListener(listener);
    }

    public void removeKeyListener(Action_Listener listener, String keyName){
        getKey(keyName).removeActionListener(listener);
    }

    public void addKeyListener(Action_Listener listener, int keyCode){
        getKey(keyCode).addActionListener(listener);
    }

    public void removeKeyListener(Action_Listener listener, int keyCode){
        getKey(keyCode).removeActionListener(listener);
    }
    public In_KeyListener getKeyListener() {
        return keyListener;
    }
}