package code.Calc.Actions.Clock;

import code.Calc.Actions.Action;
import code.Calc.Actions.Action_Listener;
import code.Calc.Clock.Clock;

public class Action_ClockTick extends Action {
    private final Clock clock;

    public Action_ClockTick(Clock clock, String name, int tick, int repeatTick, int repeat) {
        super();
        this.clock = clock;
        clock.addTimer_Tick(name, tick, this, repeatTick, repeat);
    }

    public Action_ClockTick(Action_Listener listener, Clock clock, String name, int tick, int repeatTick, int repeat) {
        super(listener);
        this.clock = clock;
        clock.addTimer_Tick(name, tick, this, repeatTick, repeat);
    }
}