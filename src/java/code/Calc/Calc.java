package code.Calc;

import code.Calc.Game.Objects.Object_Images.Images;
import code.Game;
import code.Calc.Clock.Clock;
import code.Calc.Game.World.World;

public class Calc {
    private final Game game;

    private final Clock clock;
    private final World world;
    private final Images images;

    public Calc(Game game, int tps, int fps, int chunkSize, int tileSize){
        this.game = game;
        clock = new Clock(game, tps, fps);
        images = new Images("src/resources/files/images/Objects/");
        world = new World(chunkSize, tileSize, null, images);
    }

    public World getWorld() {
        return world;
    }

    public void start(){
        clock.start();
    }

    public void stop(){
        clock.stop();
    }

    public Clock getClock() {
        return clock;
    }

    public Images getImages(){
        return images;
    }
}