package code.Calc.Game.World;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.Objects.Object;
import code.Calc.Game.Objects.Object_Images.Images;

public class World_Object extends Object {
    protected boolean solid;

    public World_Object(Images images, Coordinate coordinate, HitBox hitBox, double rotation, boolean solid, String image) {
        super(coordinate, hitBox, rotation,images,  image);
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }
}