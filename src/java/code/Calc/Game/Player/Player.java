package code.Calc.Game.Player;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.World.Coordinate;

public class Player {
    private String name;

    public Player(String name, String path, Coordinate coordinate, HitBox hitBox) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}