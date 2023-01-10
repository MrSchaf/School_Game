package code.Calc.Game.World;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.Objects.Object;

public class World_Object extends Object {
    protected boolean solid;


    public World_Object(Coordinate coordinate, HitBox hitBox, double rotation, boolean solid, int image) {
        super(coordinate, hitBox, rotation, solid, image);
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }
}