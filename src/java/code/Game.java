package code;

import code.Calc.Actions.Action_Listener;
import code.Calc.Actions.Clock.Action_ClockFrame;
import code.Calc.Clock.Clock;
import code.Calc.Game.World.Generation.Generation;
import code.Calc.Game.World.Generation.Generation_NoGen;
import code.Calc.Game.World.World;
import code.IO.InPut.In;
import code.IO.OutPut.Graphics.Graphics_ContentPane;
import code.IO.OutPut.Graphics.Graphics_Frame;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;
import code.IO.OutPut.Out;

public class Game {
    private Clock clock;
    private Out out;
    private In in;
    private World world;

    private Graphics_Frame frame;

    private int seed;

    public Game() {
        initSeed();
        initClock(100, 60);
        int chunkSize = 16;
        int tileSize_Ratio = 1;
        initCalc(chunkSize, tileSize_Ratio, new Generation_NoGen(chunkSize * tileSize_Ratio));
        initInput();
        initOutput();

        Graphics_ContentPane g_cp = frame.getContentPane();

        Action_Listener actionListener = (int code) -> {
            frame.frame();
        };

        Action_ClockFrame action_clock = new Action_ClockFrame(actionListener, clock, "Frame", 1, -1);

        clock.start();
    }

    private void initSeed(){
        seed = (int) (Math.random() * 1000000);
//        System.out.println("Seed: " + seed);
    }

    private void initCalc(int chunckSize, int tileSize_Ratio, Generation generation){
        world = new World(seed, chunckSize, tileSize_Ratio, generation);
    }

    private void initClock(int tps, int fps){
        clock = new Clock(tps, fps);
    }

    private void initInput(){
        // in = new In();
    }

    private void initOutput(){
        out = new Out();
        frame = new Graphics_Frame(Resolution.RES_720p, "Game", world);
    }
}