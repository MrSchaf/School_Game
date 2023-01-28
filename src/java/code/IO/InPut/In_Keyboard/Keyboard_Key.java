package code.IO.InPut.In_Keyboard;

import code.Calc.Actions.Action_Listener;
import code.Calc.Actions.In.Keyboard.Action_Key;

public class Keyboard_Key {
    private final int code;
    private final String name;
    private final Action_Key action;
    private boolean pressed;

    public Keyboard_Key(int code, String name){
        this.code = code;
        this.name = name;
        pressed = false;
        action = new Action_Key();
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

    public Action_Key getActionKey(){
        return action;
    }

    public void setPressed(boolean pressed){
        this.pressed = pressed;
    }

    public void addActionListener(Action_Listener listener){
        action.addActionListener(listener);
    }

    public void removeActionListener(Action_Listener listener){
        action.removeActionListener(listener);
    }

    public void keyPressed(){
        action.keyPressed();
    }

    public void keyReleased(){
        action.keyReleased();
    }
}