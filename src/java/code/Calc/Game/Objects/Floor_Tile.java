package code.Calc.Game.Objects;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.World.Coordinate;
import code.Calc.Game.World.World_Object;

import java.awt.*;

public class Floor_Tile extends World_Object{
    private static final String name = "tile";
    private int height;

    public Floor_Tile(Coordinate coordinate, int tileSize, int height) {
        super(coordinate, new HitBox(new Rectangle(tileSize, tileSize), coordinate, height), 0.0, false, name);
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }
}