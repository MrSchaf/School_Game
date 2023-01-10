package code.Calc.Clock;

import code.Calc.Actions.Clock.Action_ClockFrame;
import code.Calc.Actions.Clock.Action_ClockTick;
import code.Calc.Actions.Clock.Action_ClockTime;
import code.Calc.Clock.Timer.Clock_Timer;
import code.Calc.Clock.Timer.Clock_Timer_Frame;
import code.Calc.Clock.Timer.Clock_Timer_Tick;
import code.Calc.Clock.Timer.Clock_Timer_Time;

import java.util.HashMap;
import java.util.Vector;

public class Clock {
    private double tps;
    private double fps;

    private int tick;
    private int frame;
    private double time;
    private double delay;

    private int started;
    private int stopped;

    private final Clock_Thread clockThread;

    private final HashMap<String, Clock_Timer> times;
    private final HashMap<String, Vector<Clock_Timer>> waiting;

    public Clock(double tps, double fps) {
        this.tps = tps;
        this.fps = fps;
        tick = 0;
        frame = 0;
        time = 0.0;

        started = 0;
        stopped = 0;

        times = new HashMap<>();

        waiting = new HashMap<>();

        Vector<Clock_Timer> waitingTimes = new Vector<>();
        waiting.put("Times", waitingTimes);

        Vector<Clock_Timer> waitingTicks = new Vector<>();
        waiting.put("Ticks",waitingTicks);

        Vector<Clock_Timer> waitingFrames = new Vector<>();
        waiting.put("Frames",waitingFrames);

        clockThread = new Clock_Thread(tps, fps, this);
    }

    protected void time(){
        time = clockThread.getTime();
    }

    protected void tick(double delta) {
        tick++;
        time();

        Vector<Clock_Timer> times = new Vector<>(waiting.get("Times"));
        if(times.size() > 0){
            for (Clock_Timer time : times) {
                if(time.check()){
                    time.action();
                    if(time.repeat()){
                        waiting.get("Times").remove(time);
                    }
                }
            }
        }

        times = new Vector<>(waiting.get("Ticks"));
        if(times.size() > 0){
            for (Clock_Timer time : times) {
                if(time.check()){
                    time.action();
                    if(time.repeat()){
                        waiting.get("Ticks").remove(time);
                    }
                }
            }
        }
    }

    protected void frame(double delta) {
        frame++;

        Vector<Clock_Timer> times = new Vector<>(waiting.get("Frames"));
        if(times.size() > 0){
            for (Clock_Timer time : times) {
                if(time instanceof Clock_Timer_Frame){
                    if(time.check()){
                        time.action();
                        if(time.repeat()){
                            waiting.get("Frames").remove(time);
                        }
                    }
                }
            }
        }
    }

    public void start(){
        clockThread.start();
        addNow("start[" + started + "]");
        started++;
    }

    public void stop(){
        clockThread.stop();
        addNow("stop[" + stopped + "]");
        stopped++;
    }

    public double getTime(){
        return time;
    }

    public void setTime(double time){
        this.time = time;
    }

    public double getFPS(){
        return fps;
    }

    public double getTPS(){
        return tps;
    }

    public void setFPS(double fps){
        this.fps = fps;
    }

    public void setTPS(double tps){
        this.tps = tps;
    }

    public int getTick(){
        return this.tick;
    }

    public int getFrame() {
        return this.frame;
    }

    private void put(Clock_Timer time){
        times.put(time.getName(), time);

        if(time instanceof Clock_Timer_Time) {
            waiting.get("Times").add(time);
        } else if(time instanceof Clock_Timer_Tick){
            waiting.get("Ticks").add(time);
        } else if(time instanceof Clock_Timer_Frame){
            waiting.get("Frames").add(time);
        }
    }

    public void addTimer(String name, double time, int tick, int frame){
        put(new Clock_Timer(this, name, time, tick, frame));
    }

    public void addTimer_Time(String name, double time, Action_ClockTime action, double repeatTime, int repeat){
        put(new Clock_Timer_Time(this, name, action, time, repeatTime, repeat));
    }

    public void addTimer_Tick(String name, int tick, Action_ClockTick action, int repeat, int repeatTick){
        put(new Clock_Timer_Tick(this, name, action, tick, repeat, repeatTick));
    }

    public void addTimer_Frame(String name, int tick, Action_ClockFrame action, int repeat, int repeatFrame){
        put(new Clock_Timer_Frame(this, name, action, tick, repeat, repeatFrame));
    }

    public void addTimer(Clock_Timer clockTime){
        put(clockTime);
    }

    public void removeTime(Clock_Timer time){
        times.remove(time.getName());
        removeWaitingTime(time);
    }

    public void removeTime(String name){
        times.remove(name);
        removeWaitingTime(name);
    }

    public void removeWaitingTime(String name){
        waiting.forEach((key, value) -> {
            for (Clock_Timer time : value) {
                if(time.getName().equals(name)){
                    value.remove(time);
                }
            }
        });
    }

    public void removeWaitingTime(Clock_Timer time){
        waiting.forEach((key, value) -> {
            for (Clock_Timer clockTime : value) {
                if(clockTime.equals(time)){
                    value.remove(clockTime);
                }
            }
        });
    }

    public Clock_Timer getTime(String name){
        return times.get(name);
    }

    public void addNow(String name){
        addTimer(name, getTime(), getTick(), getFrame());
    }

    public String toString(){
        String str = "Clock[(tps:" + tps + ") (tick:" + tick + ") (fps:" + fps + ") (frame:" + frame + ")]{\n";

        for (Clock_Timer time: times.values()) {
            str += time + "\n";
        }

        str += "}";

        return str;
    }
}