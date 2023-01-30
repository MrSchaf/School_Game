package code.Calc.Game.Objects;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.World.Coordinate;
import code.Calc.Game.World.World;
import code.Calc.Game.World.World_Object;

import java.awt.*;

public class Floor_Tile extends World_Object{
    private static String name = "tile";
    private int height;

    public Floor_Tile(Coordinate coordinate, int tileSize, int height, World world) {
        super(coordinate, new HitBox(new Rectangle(tileSize, tileSize), coordinate, height), 0.0, false, name, world);
        this.height = height;
        if(height > 0){
            setSolid(true);
            name = "tile1";
        }

    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }
}