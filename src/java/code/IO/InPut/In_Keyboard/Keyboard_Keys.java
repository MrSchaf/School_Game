package code.IO.InPut.In_Keyboard;

import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.Vector;

public class Keyboard_Keys {
        public final static Keyboard_Key Key_A = new Keyboard_Key(KeyEvent.VK_A, "A");
        public final static Keyboard_Key Key_B = new Keyboard_Key(KeyEvent.VK_B, "B");
        public final static Keyboard_Key Key_C = new Keyboard_Key(KeyEvent.VK_C, "C");
        public final static Keyboard_Key Key_D = new Keyboard_Key(KeyEvent.VK_D, "D");
        public final static Keyboard_Key Key_E = new Keyboard_Key(KeyEvent.VK_E, "E");
        public final static Keyboard_Key Key_F = new Keyboard_Key(KeyEvent.VK_F, "F");
        public final static Keyboard_Key Key_G = new Keyboard_Key(KeyEvent.VK_G, "G");
        public final static Keyboard_Key Key_H = new Keyboard_Key(KeyEvent.VK_H, "H");
        public final static Keyboard_Key Key_I = new Keyboard_Key(KeyEvent.VK_I, "I");
        public final static Keyboard_Key Key_J = new Keyboard_Key(KeyEvent.VK_J, "J");
        public final static Keyboard_Key Key_K = new Keyboard_Key(KeyEvent.VK_K, "K");
        public final static Keyboard_Key Key_L = new Keyboard_Key(KeyEvent.VK_L, "L");
        public final static Keyboard_Key Key_M = new Keyboard_Key(KeyEvent.VK_M, "M");
        public final static Keyboard_Key Key_N = new Keyboard_Key(KeyEvent.VK_N, "N");
        public final static Keyboard_Key Key_O = new Keyboard_Key(KeyEvent.VK_O, "O");
        public final static Keyboard_Key Key_P = new Keyboard_Key(KeyEvent.VK_P, "P");
        public final static Keyboard_Key Key_Q = new Keyboard_Key(KeyEvent.VK_Q, "Q");
        public final static Keyboard_Key Key_R = new Keyboard_Key(KeyEvent.VK_R, "R");
        public final static Keyboard_Key Key_S = new Keyboard_Key(KeyEvent.VK_S, "S");
        public final static Keyboard_Key Key_T = new Keyboard_Key(KeyEvent.VK_T, "T");
        public final static Keyboard_Key Key_U = new Keyboard_Key(KeyEvent.VK_U, "U");
        public final static Keyboard_Key Key_V = new Keyboard_Key(KeyEvent.VK_V, "V");
        public final static Keyboard_Key Key_W = new Keyboard_Key(KeyEvent.VK_W, "W");
        public final static Keyboard_Key Key_X = new Keyboard_Key(KeyEvent.VK_X, "X");
        public final static Keyboard_Key Key_Y = new Keyboard_Key(KeyEvent.VK_Y, "Y");
        public final static Keyboard_Key Key_Z = new Keyboard_Key(KeyEvent.VK_Z, "Z");
        public final static Keyboard_Key Key_0 = new Keyboard_Key(KeyEvent.VK_0, "0");
        public final static Keyboard_Key Key_1 = new Keyboard_Key(KeyEvent.VK_1, "1");
        public final static Keyboard_Key Key_2 = new Keyboard_Key(KeyEvent.VK_2, "2");
        public final static Keyboard_Key Key_3 = new Keyboard_Key(KeyEvent.VK_3, "3");
        public final static Keyboard_Key Key_4 = new Keyboard_Key(KeyEvent.VK_4, "4");
        public final static Keyboard_Key Key_5 = new Keyboard_Key(KeyEvent.VK_5, "5");
        public final static Keyboard_Key Key_6 = new Keyboard_Key(KeyEvent.VK_6, "6");
        public final static Keyboard_Key Key_7 = new Keyboard_Key(KeyEvent.VK_7, "7");
        public final static Keyboard_Key Key_8 = new Keyboard_Key(KeyEvent.VK_8, "8");
        public final static Keyboard_Key Key_9 = new Keyboard_Key(KeyEvent.VK_9, "9");
        public final static Keyboard_Key Key_Space = new Keyboard_Key(KeyEvent.VK_SPACE, "Space");
        public final static Keyboard_Key Key_Shift = new Keyboard_Key(KeyEvent.VK_SHIFT, "Shift");
        public final static Keyboard_Key Key_Control = new Keyboard_Key(KeyEvent.VK_CONTROL, "Control");
        public final static Keyboard_Key Key_Alt = new Keyboard_Key(KeyEvent.VK_ALT, "Alt");
        public final static Keyboard_Key Key_Up = new Keyboard_Key(KeyEvent.VK_UP, "Up");
        public final static Keyboard_Key Key_Down = new Keyboard_Key(KeyEvent.VK_DOWN, "Down");
        public final static Keyboard_Key Key_Left = new Keyboard_Key(KeyEvent.VK_LEFT, "Left");
        public final static Keyboard_Key Key_Right = new Keyboard_Key(KeyEvent.VK_RIGHT, "Right");
        public final static Keyboard_Key Key_Enter = new Keyboard_Key(KeyEvent.VK_ENTER, "Enter");
        public final static Keyboard_Key Key_Escape = new Keyboard_Key(KeyEvent.VK_ESCAPE, "Escape");
        public final static Keyboard_Key Key_Backspace = new Keyboard_Key(KeyEvent.VK_BACK_SPACE, "Backspace");
        public final static Keyboard_Key Key_Tap = new Keyboard_Key(KeyEvent.VK_TAB, "Tab");
        public final static Keyboard_Key Key_F1 = new Keyboard_Key(KeyEvent.VK_F1, "F1");
        public final static Keyboard_Key Key_F2 = new Keyboard_Key(KeyEvent.VK_F2, "F2");
        public final static Keyboard_Key Key_F3 = new Keyboard_Key(KeyEvent.VK_F3, "F3");
        public final static Keyboard_Key Key_F4 = new Keyboard_Key(KeyEvent.VK_F4, "F4");
        public final static Keyboard_Key Key_F5 = new Keyboard_Key(KeyEvent.VK_F5, "F5");
        public final static Keyboard_Key Key_F6 = new Keyboard_Key(KeyEvent.VK_F6, "F6");
        public final static Keyboard_Key Key_F7 = new Keyboard_Key(KeyEvent.VK_F7, "F7");
        public final static Keyboard_Key Key_F8 = new Keyboard_Key(KeyEvent.VK_F8, "F8");
        public final static Keyboard_Key Key_F9 = new Keyboard_Key(KeyEvent.VK_F9, "F9");
        public final static Keyboard_Key Key_F10 = new Keyboard_Key(KeyEvent.VK_F10, "F10");
        public final static Keyboard_Key Key_F11 = new Keyboard_Key(KeyEvent.VK_F11, "F11");
        public final static Keyboard_Key Key_F12 = new Keyboard_Key(KeyEvent.VK_F12, "F12");
        public final static Keyboard_Key Key_F13 = new Keyboard_Key(KeyEvent.VK_F13, "F13");
        public final static Keyboard_Key Key_F14 = new Keyboard_Key(KeyEvent.VK_F14, "F14");
        public final static Keyboard_Key Key_F15 = new Keyboard_Key(KeyEvent.VK_F15, "F15");
        public final static Keyboard_Key Key_F16 = new Keyboard_Key(KeyEvent.VK_F16, "F16");

    private final static Keyboard_Key[] keys = {
        Key_A, Key_B, Key_C, Key_D, Key_E, Key_F, Key_G, Key_H, Key_I, Key_J, Key_K, Key_L, Key_M, Key_N, Key_O, Key_P, Key_Q, Key_R, Key_S, Key_T, Key_U, Key_V, Key_W, Key_X, Key_Y, Key_Z,
        Key_0, Key_1, Key_2, Key_3, Key_4, Key_5, Key_6, Key_7, Key_8, Key_9,
        Key_Space, Key_Shift, Key_Control, Key_Alt, Key_Up, Key_Down, Key_Left, Key_Right, Key_Enter, Key_Escape, Key_Backspace, Key_Tap,
        Key_F1, Key_F2, Key_F3, Key_F4, Key_F5, Key_F6, Key_F7, Key_F8, Key_F9, Key_F10, Key_F11, Key_F12, Key_F13, Key_F14, Key_F15, Key_F16
    };

    public static Keyboard_Key getKey(int keyCode) {
        for (Keyboard_Key key : keys) {
            if (key.getCode() == keyCode) {
                return key;
            }
        }
        return null;
    }

    public static Keyboard_Key getKey(String keyName) {
        for (Keyboard_Key key : keys) {
            if (key.getName().equals(keyName)) {
                return key;
            }
        }
        return null;
    }

    public static Vector<Keyboard_Key> getPressedKeys() {
        Vector<Keyboard_Key> keyList = new Vector<Keyboard_Key>();
        for (Keyboard_Key key : keys) {
            if(key.isPressed()){
                keyList.add(key);
            }
        }
        return keyList;
    }

    public static void setPressedKey(boolean pressed, int keyCode){
        Objects.requireNonNull(getKey(keyCode)).setPressed(pressed);
    }
}
