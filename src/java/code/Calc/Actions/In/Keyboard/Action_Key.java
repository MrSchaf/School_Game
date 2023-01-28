package code.Calc.Actions.In.Keyboard;

import code.Calc.Actions.Action;

public class Action_Key extends Action {
    boolean pressed = false;

    public void keyPressed(){
        if (!pressed){
            action(1);
            pressed = true;
        } else {
            action(2);
        }
    }

    public void keyReleased(){
        action(0);
        pressed = false;
    }
}