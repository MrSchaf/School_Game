package code;

import code.Calc.Actions.Action_Listener;
import code.Calc.Actions.Clock.Action_ClockFrame;
import code.Calc.Actions.Clock.Action_ClockTick;
import code.Calc.Actions.Clock.Action_ClockTime;
import code.Calc.Clock.Clock;
import code.IO.InPut.In;
import code.IO.OutPut.Graphics.Graphics_ContentPane;
import code.IO.OutPut.Graphics.Graphics_Frame;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;
import code.IO.OutPut.Out;

import java.awt.*;

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
        initOutput();

        Graphics_ContentPane g_cp = frame.getContentPane();

        Action_Listener actionListener = () -> {
            System.out.println(clock.getTime("Tick"));
        };

        Action_ClockFrame action_clock = new Action_ClockFrame(actionListener, clock, "Tick", 0, 1, -1);

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
        // in = new In();
    }

    private void initOutput(){
        out = new Out();
        frame = new Graphics_Frame(Resolution.RES_720p, "Game");

    }
}