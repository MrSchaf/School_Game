package code;

import code.Calc.Actions.Action_Listener;
import code.Calc.Calc;
import code.IO.InPut.In_Keyboard.In_KeyListener;
import code.IO.InPut.In_Keyboard.Keyboard_Keys;
import code.IO.OutPut.Out;
import code.IO.InPut.In;
import code.Calc.Clock.Clock;
import code.Calc.Game.World.Generation.Generation;
import code.Calc.Game.World.Generation.Generation_NoGen;
import code.Calc.Game.World.World;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;

public class Game {
    private Calc calc;
    private In in;
    private Out out;
    private int seed;

    public Game() {
        init();

        Action_Listener action_listener = new Action_Listener() {
            @Override
            protected void actionPerformed(int code) {
                if (code == 1) {
                    out.changeFullscreen();
                }
            }
        };
        in.getKeyboard().addKeyListener(action_listener, Keyboard_Keys.Key_E);

        start();
    }

    // Initializations
    public void init(){
        int tps = 100;
        int fps = 60;
        int chunkSize = 16;
        int tileSize = 1;
        initCalc(tps, fps, chunkSize, tileSize, new Generation_NoGen(chunkSize * tileSize));
        initInput();
        initOutput();
    }

    private void initCalc(int tps, int fps, int chunkSize, int tileSize_Ratio, Generation generation){
        calc = new Calc(this, tps, fps, chunkSize, tileSize_Ratio);
    }

    private void initInput(){
        in = new In();
    }

    private void initOutput(){
        out = new Out(this, in, Resolution.RES_720p, "Game");
    }

    // Public Methods
    public void start(){
        calc.start();
    }

    public void stop(){
        calc.stop();
    }

    public void tick(){
        in.tick();
        calc.getWorld().tick();
    }

    public void frame(){
        out.frame();
    }

    // Getters
    public World getWorld(){
        return calc.getWorld();
    }

    public Clock getClock(){
        return calc.getClock();
    }

    public In_KeyListener getKeyListener(){
        return in.getKeyListener();
    }
}