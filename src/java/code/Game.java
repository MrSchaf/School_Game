package code;

import code.Calc.Clock.Clock;
import code.IO.InPut.In;
import code.IO.OutPut.Graphics.Graphics_Frame;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;
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
        initOutput();



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