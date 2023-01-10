package code.Calc.Clock.Timer;

import code.Calc.Actions.Clock.Action_ClockFrame;
import code.Calc.Clock.Clock;

public class Clock_Timer_Frame extends Clock_Timer {
    private double frameDelay;
    private double frameLeft;
    private int repeat;

    /**
     * <p><strong>repeat = -1</strong><br/>infinite repeats</></p>
     * <p><strong>repeat = 0</strong><br/>no repeats</></p>
     * <p><strong>repeat = x > 0</strong><br/>repeats x times</></p>
     */
    public Clock_Timer_Frame(Clock clock, String name, Action_ClockFrame action, int frame, int frameDelay, int repeat) {
        super(clock, name, -1, -1, frame);
        setAction(action);
        this.frameDelay = frameDelay;
        this.frameLeft = (frame - clock.getFrame());
        this.repeat = repeat;
    }

    @Override
    public boolean check(){
        boolean check = false;

        frameLeft = (frame - clock.getFrame());

        if(frameLeft <= 0){
            check = true;
            frame = clock.getFrame();
            this.action();

            if(repeat > 0){
                frame += frameDelay;
                repeat--;
            }
        }

        return check;
    }

    public double getFrameDelay(){
        return frameDelay;
    }

    public double getFrameLeft(){
        return frameLeft;
    }

    public int getRepeat(){
        return repeat;
    }

    public void setFrameDelay(double frameDelay){
        this.frameDelay = frameDelay;
    }

    public void setFrameLeft(double frameLeft){
        this.frameLeft = frameLeft;
    }

    public void setRepeat(int repeat){
        this.repeat = repeat;
    }

    public String toString(){
        return "Clock_Timer_Time[(name=" + name + ") (time=" + time + ") (tick=" + tick + ") (frame=" + frame + ") (frameDelay=" + frameDelay + ") (frameLeft=" + frameLeft + ") (repeat=" + repeat + ")]";
    }
}