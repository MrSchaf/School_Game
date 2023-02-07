package code.Calc.Game.Objects;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.World.Coordinate;
import code.Calc.Game.World.World;

public abstract class Object {
    protected final World world;
    protected Coordinate coordinate;
    private HitBox hitBox;
    protected double rotation;

    private String name;

    public Object(int x, int y, HitBox hitBox, double rotation, String name, World world) {
        this.world = world;
        coordinate = new Coordinate(x, y);
        this.hitBox = hitBox;
        this.rotation = rotation;
        this.name = name;
    }
    //moritz is gay

    public Object(Coordinate coordinate, HitBox hitBox, double rotation, String name, World world) {
        this.world = world;
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

    public boolean collides(){
        return world.collides(this);
    }

    public boolean collides(Object object){
        return this.hitBox.collides(object.getHitBox());
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

    public double getRotation(){
        return rotation;
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

    public void setCoordinate(Coordinate coordinate){
        this.coordinate = coordinate;
        hitBox.setReference(coordinate);
    }

    public void setHitBox(HitBox hitBox) {
        this.hitBox = hitBox;
    }

    public void setRotation(double rotation){
        this.rotation = rotation;
    }

}