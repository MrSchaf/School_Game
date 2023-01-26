package code.Calc.Game.Objects;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.World.Coordinate;

public abstract class Object {
    protected Coordinate coordinate;
    private final HitBox hitBox;
    protected double rotation;
    private int image;

    public Object(int x, int y,HitBox hitBox, double rotation, int image) {
        coordinate = new Coordinate(x, y);
        this.hitBox = hitBox;
        this.rotation = rotation;
        this.image = image;
    }

    public Object(Coordinate coordinate,HitBox hitBox, double rotation, int image) {
        this.coordinate = coordinate;
        this.hitBox = hitBox;
        this.rotation = rotation;
        this.image = image;
    }

    public boolean intersects(Coordinate x, Coordinate y){
        return hitBox.intersects(x, y);
    }

    public boolean intersects(Object object){
        return hitBox.intersects(object.getHitBox());
    }

    private HitBox getHitBox() {
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

    public int getImage(){
        return image;
    }

    public void setX(int x) {
        coordinate.setX(x);
    }

    public void setY(int y) {
        coordinate.setY(y);
    }

    public void setImage(int image){
        this.image = image;
    }
}