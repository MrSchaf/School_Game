package code.Calc.Actions.In.Keyboard;

import code.Calc.Actions.Action;
import code.Calc.Actions.Action_Listener;
import code.IO.InPut.In_Keyboard.Keyboard_Key;

import java.util.List;

public class Action_Key extends Action {
    private final int code;
    private final String name;

    public Action_Key(int code, String name){
        this.code = code;
        this.name = name;
    }

    public Action_Key(int code, String name, Action_Listener listener){
        super(listener);
        this.code = code;
        this.name = name;
    }

    public Action_Key(int code, String name, List<Action_Listener> listeners){
        super(listeners);
        this.code = code;
        this.name = name;
    }

    public Action_Key(Keyboard_Key key){
        this(key.getCode(), key.getName());
    }

    public int getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public void keyPressed(){
        action(0);
    }

    public void keyReleased(){
        action(1);
    }
}