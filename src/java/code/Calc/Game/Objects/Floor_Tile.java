package code.Calc.Game.Objects;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.World.Coordinate;

import java.awt.*;

public class Floor_Tile extends Object{
    private int height;

    public Floor_Tile(Coordinate coordinate, int tileSize_Ratio, int height) {
        super(images, coordinate, new HitBox(new Rectangle(tileSize_Ratio, tileSize_Ratio), coordinate, height), 0,  0);
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }
}