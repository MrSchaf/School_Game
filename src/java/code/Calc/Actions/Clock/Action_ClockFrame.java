package code.Calc.Actions.Clock;

import code.Calc.Actions.Action;
import code.Calc.Actions.Action_Listener;
import code.Calc.Clock.Clock;

public class Action_ClockFrame extends Action {
    private final Clock clock;

    public Action_ClockFrame(Clock clock, String name, int frame, int repeatFrame, int repeat) {
        super();
        this.clock = clock;
        clock.addTimer_Frame(name, frame, this, repeatFrame, repeat);
    }

    public Action_ClockFrame(Action_Listener listener, Clock clock, String name, int frame, int repeatFrame, int repeat) {
        super(listener);
        this.clock = clock;
        clock.addTimer_Frame(name, frame, this, repeatFrame, repeat);
    }
}