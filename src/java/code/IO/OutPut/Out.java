package code.IO.OutPut;

import code.Game;
import code.IO.InPut.In;
import code.IO.OutPut.Graphics.Graphics_Frame;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;

import java.awt.*;

public class Out {
    public final Game game;

    private final In in;
    private Resolution resolution;
    private String title;
    private final Graphics_Frame graphics;

    private static final GraphicsEnvironment devices = GraphicsEnvironment.getLocalGraphicsEnvironment();

    public Out(Game game, In in, Resolution resolution, String title){
        this.game = game;
        this.in = in;
        this.resolution = resolution;
        this.title = title;
        graphics = new Graphics_Frame(resolution, title, game.getWorld(), devices, game);
    }

    public void frame(){
        graphics.frame();
    }

    public void changeFullscreen() {
        graphics.changeFullscreen();
    }
}