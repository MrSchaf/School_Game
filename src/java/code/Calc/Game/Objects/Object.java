package code.Calc.Game.Objects;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.Objects.Object_Images.Images;
import code.Calc.Game.World.Coordinate;
import code.Calc.Game.World.World_Display_Objects;

import java.awt.*;

public abstract class Object {
    protected Coordinate coordinate;
    private final HitBox hitBox;
    protected double rotation;

    private final Images images;
    private String name;

    public Object(int x, int y,HitBox hitBox, double rotation, Images images, String name) {
        coordinate = new Coordinate(x, y);
        this.hitBox = hitBox;
        this.rotation = rotation;

        this.images = images;
        this.name = name;
    }

    public Object(Coordinate coordinate, HitBox hitBox, double rotation, Images images, String name){
        this.images = images;
        this.coordinate = coordinate;
        this.hitBox = hitBox;
        this.rotation = rotation;
        this.name = name;
    }

    public void paint(Graphics g, World_Display_Objects worldObjects){
        int x = (coordinate.getX() - worldObjects.getCoordinate().getX());
        int y = (coordinate.getY() - worldObjects.getCoordinate().getY());
        g.drawImage(images.getImage(name), x, y, null);
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