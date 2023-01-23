package code.Calc.Actions.Clock;

import code.Calc.Actions.Action;
import code.Calc.Actions.Action_Listener;
import code.Calc.Clock.Clock;

public class Action_ClockTime extends Action {
    private final Clock clock;

    public Action_ClockTime(Clock clock, String name, double repeatTime, int repeat) {
        super();
        this.clock = clock;
        clock.addTimer_Time(name, this, repeatTime, repeat);
    }

    public Action_ClockTime(Action_Listener listener, Clock clock, String name, double repeatTime, int repeat) {
        super(listener);
        this.clock = clock;
        clock.addTimer_Time(name, this, repeatTime, repeat);
    }
}