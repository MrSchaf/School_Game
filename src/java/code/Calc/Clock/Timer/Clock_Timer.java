package code.Calc.Clock.Timer;

import code.Calc.Actions.Action;
import code.Calc.Clock.Clock;

public class Clock_Timer {
    protected Clock clock;
    protected String name;
    protected Action action;
    protected double time;
    protected int tick;
    protected int frame;

    public Clock_Timer(Clock clock, String name, double time, int tick, int frame) {
        this.clock = clock;
        this.name = name;
        this.action = null;

        this.time = time;
        this.tick = tick;
        this.frame = frame;
    }

    public Clock_Timer(Clock_Timer_Time clock_timer){
        this.clock = clock_timer.getClock();
        this.name = clock_timer.getName();

        this.time = clock_timer.getTime();
        this.tick = clock_timer.getTick();
        this.frame = clock_timer.getFrame();
    }

    public Clock_Timer(Clock_Timer_Frame clock_timer){
        this.clock = clock_timer.getClock();
        this.name = clock_timer.getName();

        this.time = clock_timer.getTime();
        this.tick = clock_timer.getTick();
        this.frame = clock_timer.getFrame();
    }

    public Clock_Timer(Clock_Timer_Tick clock_timer){
        this.clock = clock_timer.getClock();
        this.name = clock_timer.getName();

        this.time = clock_timer.getTime();
        this.tick = clock_timer.getTick();
        this.frame = clock_timer.getFrame();
    }

    public boolean check(){
        return false;
    }

    public boolean repeat(){
        return false;
    }

    public void action(int code) {
        if (action != null) {
            action.action(code);
        }
    }

    public String getName(){
        return name;
    }

    public Clock getClock(){
        return clock;
    }

    public Action getAction(){
        return action;
    }

    public double getTime(){
        return time;
    }

    public int getTick(){
        return tick;
    }

    public int getFrame(){
        return frame;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setClock(Clock clock){
        this.clock = clock;
    }

    public void setAction(Action action){
        this.action = action;
    }

    public void setTime(double time){
        this.time = time;
    }

    public void setTick(int tick){
        this.tick = tick;
    }

    public void setFrame(int frame){
        this.frame = frame;
    }

    protected void setTimer(){
        time = clock.getTime();
        tick = clock.getTick();
        frame = clock.getFrame();
    }

    public String toString(){
        return "Clock_Timer[(name=" + name + ") (time=" + time + ") (tick=" + tick + ") (frame=" + frame + ")]";
    }
}