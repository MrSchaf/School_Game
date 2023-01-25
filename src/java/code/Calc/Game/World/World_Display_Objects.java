package code.Calc.Game.World;

import code.Calc.Game.Objects.Floor_Tile;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;

import java.util.Vector;

public class World_Display_Objects {
    private Resolution resolution;
    private double scale;

    private Vector<Floor_Tile> floorTiles;
    // private

    public World_Display_Objects(Resolution resolution, double scale, World world){
        this.resolution = resolution;
        this.scale = scale;

        floorTiles = new Vector<>();
    }
}