package code.Calc.Actions.In.Keyboard;

import code.Calc.Actions.Action;

public class Action_Key extends Action {
    public void keyPressed(){
        action(0);
    }

    public void keyReleased(){
        action(1);
    }
}