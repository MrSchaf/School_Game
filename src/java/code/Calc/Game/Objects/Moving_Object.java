package code.Calc.Game.Objects;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.World.Coordinate;
import code.Calc.Game.World.World;
import code.Calc.Math.Math_Vector;
import code.Calc.Game.World.World_Object;

public class Moving_Object extends World_Object {
    private Math_Vector vel;
    private double delta;

    public Moving_Object(Coordinate coordinate, HitBox hitBox, double rotation, boolean solid, String image, World world) {
        super(coordinate, hitBox, rotation, solid, image, world);
        vel = new Math_Vector(0, 0, true);
        delta = 9;
    }

    public void move() {
        Coordinate newCoords = new Coordinate(getCoordinate().getX(), getCoordinate().getY());
        newCoords.setX((int) (newCoords.getX() + vel.getX() * delta));
        newCoords.setY((int) (newCoords.getY() + vel.getY() * delta));

        if (!checkCollision(newCoords)) {
            coordinate.setX(newCoords.getX());
            coordinate.setY(newCoords.getY());
        } else {
            Math_Vector vbefore = new Math_Vector(vel.getX(), vel.getY(), true);
            newCoords = getCoordinate();
            boolean x = false;
            boolean y = false;
            while (!x || !y) {
                Coordinate before = new Coordinate(newCoords.getX(), newCoords.getY());
                if(vel.getDirX() != 0 && !x) {
                    newCoords.setX(newCoords.getX() + vel.getDirX());
                    if(checkCollision(newCoords)) {
                        newCoords.setX(before.getX());
                    }
                    vel.setX(vel.getX() - vel.getDirX());
                } else {
                    x = true;
                }
                if(vel.getDirY() != 0 && !y) {
                    newCoords.setY(newCoords.getY() + vel.getDirY());
                    if(checkCollision(newCoords)) {
                        newCoords.setY(before.getY());
                    }
                    vel.setY(vel.getY() - vel.getDirY());
                } else {
                    y = true;
                }
            }
            vel = vbefore;
            coordinate.setX(newCoords.getX());
            coordinate.setY(newCoords.getY());
        }
    }

    private boolean checkCollision(Coordinate newCoords) {
        HitBox newHitBox = getHitBox();
        newHitBox.setReference(newCoords);
        return world.collides(this);
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