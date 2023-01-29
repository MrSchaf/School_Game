package code.Calc.Game.Objects;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.World.Coordinate;
import code.Calc.Math.Math_Vector;
import code.Calc.Game.World.World_Object;

public class Moving_Object extends World_Object {
    private Math_Vector vel;
    private double delta;

    public Moving_Object(Coordinate coordinate, HitBox hitBox, double rotation, boolean solid, String image) {
        super(coordinate, hitBox, rotation, solid, image);
        vel = new Math_Vector(0, 0, true);
        delta = 1;
    }

    public void move() {
        Coordinate newCoords = getCoordinate();
        newCoords.setX((int) (newCoords.getX() + vel.getX() * delta));
        newCoords.setY((int) (newCoords.getY() + vel.getY() * delta));
        HitBox newHitBox = getHitBox();
        newHitBox.setReference(newCoords);


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

    public void addVel(Math_Vector vel) {
        this.vel.add(vel);
    }

    public void subVel(Math_Vector vel) {
        this.vel.subtract(vel);
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