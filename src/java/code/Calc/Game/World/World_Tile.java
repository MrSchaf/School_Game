package code.Calc.Game.World;

import code.Calc.Game.Objects.Hitbox.HitBox;

public class World_Tile extends World_Object {
    private int height;

    private World_Object object;

    public World_Tile(Coordinate coordinate, HitBox hitBox, double rotation, boolean solid, int image, int height) {
        super(coordinate, hitBox, rotation, solid, image);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}