package code.Calc.Game.World;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.Objects.Object_Images.Images;

public class World_Tile extends World_Object {
    private int height;

    private World_Object object;

    public World_Tile(Images images, Coordinate coordinate, HitBox hitBox, double rotation, boolean solid, int image, int height) {
        super(images, coordinate, hitBox, rotation, solid, image);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}