package code.Calc.Game.World;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.Objects.Object_Images.Images;

import java.util.ArrayList;

public class World_Tile extends World_Object {
    private int height;

    private final ArrayList<World_Object> objects;

    public World_Tile(Images images, Coordinate coordinate, HitBox hitBox, double rotation, boolean solid, String image, int height) {
        super(images, coordinate, hitBox, rotation, solid, image);
        this.height = height;
        objects = new ArrayList<>();
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