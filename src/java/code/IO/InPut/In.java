package code.IO.InPut;

import code.IO.InPut.In_Keyboard.Keyboard_Keys;

public class In {
    private final Keyboard_Keys keyboard;

    public In(){
        keyboard = new Keyboard_Keys();
    }

    public Keyboard_Keys getKeyboard(){
        return keyboard;
    }
}