package code.Calc.Game.World;

import code.Calc.Game.Objects.Floor_Tile;
import code.Calc.Game.Objects.Hitbox.HitBox;

import java.util.ArrayList;

public class World_Tile extends World_Object {
    private int height;

    private final ArrayList<World_Object> objects;

    public World_Tile(Coordinate coordinate, HitBox hitBox, double rotation, boolean solid, int tileSize, String image, int height, World world) {
        super(coordinate, hitBox, rotation, solid, image, world);
        this.height = height;
        objects = new ArrayList<>();
        if(height > 0){
            setSolid(true);
        }
        objects.add(new Floor_Tile(coordinate, tileSize, height, world));
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void addObject(World_Object object){
        objects.add(object);
    }

    public void removeObject(World_Object object){
        objects.remove(object);
    }
}