package code.IO.InPut.In_Keyboard;

import code.Calc.Actions.Action_Listener;
import code.Calc.Actions.In.Keyboard.Action_Key;

public class Keyboard_Key {
    private final int code;
    private final String name;
    private boolean pressed;
    private Action_Key action;

    public Keyboard_Key(int code, String name){
        this.code = code;
        this.name = name;
        pressed = false;
        action = new Action_Key(this);
    }

    public int getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public boolean isPressed(){
        return pressed;
    }

    public void setPressed(boolean pressed){
        this.pressed = pressed;
    }

    public void addActionListener(Action_Listener listener){
        action.addActionListener(listener);
    }
}
