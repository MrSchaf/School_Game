package code.Calc.Game.Objects;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.World.Coordinate;

public abstract class Object {
    protected Coordinate coordinate;
    private final HitBox hitBox;
    protected double rotation;
    private boolean solid;
    private int image;

    public Object(int x, int y,HitBox hitBox, double rotation, boolean solid, int image) {
        coordinate = new Coordinate(x, y);
        this.hitBox = hitBox;
        this.rotation = rotation;
        this.solid = solid;
        this.image = image;
    }

    public Object(Coordinate coordinate,HitBox hitBox, double rotation, boolean solid, int image) {
        this.coordinate = coordinate;
        this.hitBox = hitBox;
        this.rotation = rotation;
        this.solid = solid;
        this.image = image;
    }

    public boolean intersects(Coordinate x, Coordinate y){
        return hitBox.intersects(x, y);
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

    public boolean isSolid() {
        return solid;
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

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public void setImage(int image){
        this.image = image;
    }
}