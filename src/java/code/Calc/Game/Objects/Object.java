package code.Calc.Game.Objects;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.World.Coordinate;

public abstract class Object {
    protected Coordinate coordinate;
    private final HitBox hitBox;
    protected double rotation;

    private String name;

    public Object(int x, int y, HitBox hitBox, double rotation, String name) {
        coordinate = new Coordinate(x, y);
        this.hitBox = hitBox;
        this.rotation = rotation;
        this.name = name;
    }

    public Object(Coordinate coordinate, HitBox hitBox, double rotation, String name){
        this.coordinate = coordinate;
        this.hitBox = hitBox;
        this.rotation = rotation;
        this.name = name;
    }

    public boolean intersects(Coordinate x, Coordinate y){
        return hitBox.intersects(x, y);
    }

    public boolean intersects(Object object){
        return hitBox.intersects(object.getHitBox());
    }

    protected HitBox getHitBox() {
        return this.hitBox;
    }

    public double getX() {
        return coordinate.getX();
    }

    public double getY() {
        return coordinate.getY();
    }

    public Coordinate getCoordinate(){
        return coordinate;
    }

    public String getImage(){
        return name;
    }

    public void setX(int x) {
        coordinate.setX(x);
    }

    public void setY(int y) {
        coordinate.setY(y);
    }

    public void setImage(String name){
        this.name = name;
    }
}