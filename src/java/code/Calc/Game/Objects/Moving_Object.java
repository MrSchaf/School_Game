package code.Calc.Game.Objects;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.World.Coordinate;
import code.Calc.Math.Math_Vector;
import code.Calc.Game.World.World_Object;

public class Moving_Object extends World_Object {
    private Math_Vector vel;
    private double delta;

    public Moving_Object(Coordinate coordinate, HitBox hitBox, double rotation, boolean solid, int image) {
        super(coordinate, hitBox, rotation, solid, image);
    }

    public void move(double delta) {
        this.delta = delta;
        Coordinate newCoords = getCoordinate();

        newCoords.setX((int)(coordinate.getX() + (Math.round(vel.getX() * this.delta))));
        newCoords.setY((int)(coordinate.getY() + (Math.round(vel.getY() * this.delta))));
    }

    public Math_Vector getVel() {
        return vel;
    }

    public double getDirection() {
        return vel.getAngle();
    }

    public double getMagnitude() {
        return vel.getLength();
    }

    public double getDelta() {
        return delta;
    }

    public void setVel(Math_Vector vel) {
        this.vel = vel;
    }

    public void setDirection(double direction) {
        vel.setAngle(direction);
    }

    public void setMagnitude(double magnitude) {
        vel.setLength(magnitude);
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }
}