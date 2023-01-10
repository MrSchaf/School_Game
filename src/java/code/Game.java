package code;

import code.Calc.Actions.Action_Listener;
import code.Calc.Actions.Clock.Action_ClockTime;
import code.Calc.Clock.Clock;
import code.IO.InPut.In;
import code.IO.OutPut.Graphics.Graphics_Frame;
import code.IO.OutPut.Graphics.Graphics_Panel;
import code.IO.OutPut.Graphics.Image.Resolution;
import code.IO.OutPut.Out;

public class Game {
    private Clock clock;
    private Out out;
    private In in;

    private Graphics_Frame frame;

    private int seed;

    public Game() {
        initSeed();
        initClock(100, 60);
        initInput();
        // initOutput();

        Action_Listener action_listener = () -> {
            System.out.println(clock.getTime());
            System.out.println(clock.getTime("time"));
        };
        new Action_ClockTime(action_listener, clock, "time", 10.0, 4.0, 10);

        clock.start();
    }

    private void initSeed(){
        seed = (int) (Math.random() * 1000000);
        System.out.println("Seed: " + seed);
    }

    private void initGame(){

    }

    private void initClock(int tps, int fps){
        clock = new Clock(tps, fps);
    }

    private void initInput(){
        in = new In();
    }

    private void initOutput(){
        out = new Out();
        int width = 1280, height = 720;
        frame = new Graphics_Frame(width, height, "Game", new Graphics_Panel(width, height, Resolution.RES_720p));

    }
}