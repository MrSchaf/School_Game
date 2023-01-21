package code.Calc.Clock;

public class Clock_Thread implements Runnable {
    private final Clock clock;

    private final Thread thread;
    private boolean running = false;
    private double tps;
    private double fps;
    private double delayTick;
    private double delayFrame;
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
        double nowTime = System.nanoTime();
        lastTick = nowTime;
        lastFrame = nowTime;
        aTime = nowTime;
        while (running) {

            if (getNTime() - lastTick >= delayTick) {
                clock.tick(getNTime() - lastTick);
                lastTick += delayTick;
            }

            if (getNTime() - lastFrame >= delayFrame) {
                clock.frame(getNTime() - lastFrame);
                lastFrame += delayFrame;
            }

            bTime = getNTime();
            time += bTime - aTime;
            aTime = bTime;
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
        return time / 1_000_000_000.0;
    }

    public void setTime(double time){
        this.time = time;
    }

    public double getTPS(){
        return tps;
    }

    public void setTps(double tps){
        this.tps = tps;
    }

    public double getFPS(){
        return fps;
    }

    public void setFps(double fps){
        this.fps = fps;
    }

    public double getDelayTick(){
        return delayTick;
    }

    public void setDelayTick(double delayTick){
        this.delayTick = delayTick;
    }

    public double getDelayFrame(){
        return delayFrame;
    }

    public void setDelayFrame(double delayFrame){
        this.delayFrame = delayFrame;
    }

    public double getLastTick(){
        return lastTick;
    }

    public void setLastTick(double lastTick){
        this.lastTick = lastTick;
    }

    public double getLastFrame(){
        return lastFrame;
    }

    public void setLastFrame(double lastFrame){
        this.lastFrame = lastFrame;
    }

    public double getATime(){
        return aTime;
    }

    public void setATime(double aTime){
        this.aTime = aTime;
    }

    public double getBTime(){
        return bTime;
    }

    public void setBTime(double bTime){
        this.bTime = bTime;
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