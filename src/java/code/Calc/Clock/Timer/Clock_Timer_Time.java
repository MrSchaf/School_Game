package code.Calc.Clock.Timer;

import code.Calc.Actions.Clock.Action_ClockTime;
import code.Calc.Clock.Clock;

public class Clock_Timer_Time extends Clock_Timer {
    private double timeDelay;
    private double timeLeft;
    private int repeat;

    /**
     * <p><strong>repeat = -1</strong><br/>infinite repeats</></p>
     * <p><strong>repeat = 0</strong><br/>no repeats</></p>
     * <p><strong>repeat = x > 0</strong><br/>repeats x times</></p>
     */

    public Clock_Timer_Time(Clock clock, String name, Action_ClockTime action, double time, double timeDelay, int repeat) {
        super(clock, name, time, -1, -1);
        setAction(action);
        this.timeDelay = timeDelay;
        this.timeLeft = (time - clock.getTime());
        this.repeat = repeat;
    }

    @Override
    public boolean check() {
        boolean check = false;

        timeLeft = (time - clock.getTime());

        if(timeLeft <= 0){
            check = true;
            time = clock.getTime();
            this.action();

            if(repeat > 0){
                time += timeDelay;
                repeat--;
            }
        }

        return check;
    }

    public double getTimeDelay() {
        return timeDelay;
    }

    public double getTimeLeft() {
        return timeLeft;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setTimeDelay(double timeDelay) {
        this.timeDelay = timeDelay;
    }

    public void setTimeLeft(double timeLeft) {
        this.timeLeft = timeLeft;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public String toString(){
        return "Clock_Timer_Time[(name=" + name + ") (time=" + time + ") (timeDelay=" + timeDelay + ") (timeLeft=" + timeLeft + ") (tick=" + tick + ") (frame=" + frame + ") (repeat=" + repeat + ")]";
    }
}