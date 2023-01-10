package code.Calc.Actions;

import java.util.ArrayList;
import java.util.List;

public abstract class Action {
    private final List<Action_Listener> listeners = new ArrayList<>();

    public Action() {}

    public Action(Action_Listener listener) {
        listeners.add(listener);
    }

    public Action(List<Action_Listener> listeners) {
        this.listeners.addAll(listeners);
    }

    public void addActionListener(Action_Listener listener){
        listeners.add(listener);
    }

    public void removeActionListener(Action_Listener listener){
        listeners.remove(listener);
    }

    public void action(){
        for (Action_Listener listener : listeners) {
            listener.actionPerformed();
        }
    }
}