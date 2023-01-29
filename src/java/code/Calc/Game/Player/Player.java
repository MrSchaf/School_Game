package code.Calc.Game.Player;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.Objects.Moving_Object;
import code.Calc.Game.World.Coordinate;
import code.Calc.Game.World.World;

public class Player extends Moving_Object {
    private String name;
    private final World world;

    public Player(String name, Coordinate coordinate, HitBox hitBox, String image, World world) {
        super(coordinate, hitBox, 0, false, image);
        this.name = name;
        this.world = world;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void generateChunks(){
        world.generateChunks(coordinate);
    }
}