package code.IO.OutPut;

import code.Calc.Game.World.Coordinate;
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

    private final GraphicsEnvironment devices;

    public Out(Game game, In in, Resolution resolution, String title){
        this.game = game;
        this.in = in;
        this.resolution = resolution;
        this.title = title;
        devices = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphics = new Graphics_Frame(resolution, title, game.getWorld(), devices, game);
    }

    public void frame(){
        graphics.frame();
    }

    public void changeFullscreen() {
        graphics.changeFullscreen();
    }

    public void changePanel(){
        graphics.changePanel();
    }

    public void setCamera(Coordinate camera){
        graphics.setCamera(camera);
    }
}