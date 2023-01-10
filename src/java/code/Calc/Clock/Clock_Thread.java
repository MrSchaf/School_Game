package code.Calc.Clock;

public class Clock_Thread implements Runnable {
    private final Clock clock;

    private final Thread thread;
    private boolean running = false;
    private final double tps;
    private final double fps;
    private final double delayTick;
    private final double delayFrame;
    private double lastTick = 0.0;
    private double lastFrame = 0.0;

    private double time;
    private double aTime;
    private double bTime;

    public Clock_Thread(double tps, double fps, Clock clock) {
        super();
        this.clock = clock;
        this.tps = clock.getTPS();
        this.fps = clock.getFPS();
        this.delayTick = 1_000_000_000.0 / tps;
        this.delayFrame = 1_000_000_000.0 / fps;

        thread = new Thread(this);
    }

    @Override
    public void run() {
        lastTick = getNTime();
        lastFrame = getNTime();
        aTime = getNTime();
        while (running) {

            if (getNTime() - lastTick >= delayTick) {
                clock.tick(getNTime() - lastTick);
                lastTick = getNTime();
            }

            if (getNTime() - lastFrame >= delayFrame) {
                clock.frame(getNTime() - lastFrame);
                lastFrame = getNTime();
            }

            bTime = getNTime();
            time += bTime - aTime;
            aTime = bTime;
            clock.setTime(time / 1_000_000_000.0);
        }
    }

    public static double getNTime() {
        return (double) System.nanoTime();
    }

    public void start(){
        if(!running){
            running = true;
            run();
        }
    }

    public void stop(){
        running = false;
    }

    public double getTime(){
        return time;
    }

    public void setTime(double time){
        this.time = time;
    }

    public double getTPS(){
        return tps;
    }

    public double getFPS(){
        return fps;
    }

    public double getDelayTick(){
        return delayTick;
    }

    public double getDelayFrame(){
        return delayFrame;
    }

    public double getLastTick(){
        return lastTick;
    }

    public double getLastFrame(){
        return lastFrame;
    }

    public double getATime(){
        return aTime;
    }

    public double getBTime(){
        return bTime;
    }

    public boolean isRunning(){
        return running;
    }

    public Thread getThread(){
        return thread;
    }

    public Clock getClock(){
        return clock;
    }

    public String toString(){
        return "Clock_Thread[(tps=" + tps + ") (fps=" + fps + ") (delayTick=" + delayTick + ") (delayFrame=" + delayFrame + ") (lastTick=" + lastTick + ") (lastFrame=" + lastFrame + ") (aTime=" + aTime + ") (bTime=" + bTime + ") (time=" + time + ") (running=" + running + ")]";
    }
}