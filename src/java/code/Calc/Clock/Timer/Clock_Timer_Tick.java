package code.Calc.Clock.Timer;

import code.Calc.Actions.Clock.Action_ClockTick;
import code.Calc.Clock.Clock;

public class Clock_Timer_Tick extends Clock_Timer{
    private double tickDelay;
    private double tickLeft;
    private int repeat;

    /**
     * <p><strong>repeat = -1</strong><br/>infinite repeats</></p>
     * <p><strong>repeat = 0</strong><br/>no repeats</></p>
     * <p><strong>repeat = x > 0</strong><br/>repeats x times</></p>
     */
    public Clock_Timer_Tick(Clock clock, String name, Action_ClockTick action, int tick, int TickDelay, int repeat) {
        super(clock, name, -1, tick, -1);
        setAction(action);
        this.tickDelay = TickDelay;
        this.tickLeft = (tick - clock.getTick());
        this.repeat = repeat;
    }

    @Override
    public boolean check() {
        boolean check = false;

        tickLeft = (tick - clock.getTick());

        if(tickLeft <= 0){
            check = true;
            tick = clock.getTick();
            this.action();

            if(repeat > 0){
                tick += tickDelay;
                repeat--;
            }
        }

        return check;
    }

    public double getTickDelay() {
        return tickDelay;
    }

    public double getTickLeft() {
        return tickLeft;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setTickDelay(double tickDelay) {
        this.tickDelay = tickDelay;
    }

    public void setTickLeft(double tickLeft) {
        this.tickLeft = tickLeft;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public String toString(){
        return "Clock_Timer_Time[(name=" + name + ") (time=" + time + ") (tick=" + tick + ") (tickDelay=" + tickDelay + ") (tickLeft=" + tickLeft + ") (frame=" + frame + ") (repeat=" + repeat + ")]";
    }
}