package code.Calc.Game.Objects.Hitbox;

import code.Calc.Game.World.Coordinate;

import java.awt.*;

public class HitBox {
    private boolean[][] hitBox;
    Coordinate reference;
    int height;

    public HitBox(boolean[][] hitBox, Coordinate reference, int height){
        this.hitBox = hitBox;
        this.reference = reference;
    }

    public HitBox(Rectangle rectangle, Coordinate reference, int height){
        this.hitBox = new boolean[rectangle.width][rectangle.height];
        this.reference = reference;
    }

    public boolean intersects(Coordinate a, Coordinate b){
        boolean intersects = false;
        Coordinate c = reference;
        Coordinate d = new Coordinate(reference, hitBox.length, hitBox[0].length);

        int xL = Math.max(a.getX(), c.getX());
        int xR = Math.min(b.getX(), d.getX());
        if (!(xR <= xL)){
            int yT = Math.max(a.getY(), c.getY());
            int yB = Math.min(b.getY(), d.getY());
            if (!(yB <= yT)) {
                for (int x = xL; x < xR; x++){
                    for (int y = yT; y < yB; y++){
                        if (hitBox[x - reference.getX()][y - reference.getY()]){
                            intersects = true;
                            break;
                        }
                    }
                }
            }
        }

        return intersects;
    }

    public boolean intersects(HitBox hitBox){
        boolean intersects = false;

        Coordinate a = hitBox.getReference();
        Coordinate b = new Coordinate(hitBox.getReference(), hitBox.getHitBox().length, hitBox.getHitBox()[0].length);
        Coordinate c = reference;
        Coordinate d = new Coordinate(reference, this.hitBox.length, this.hitBox[0].length);

        int xL = Math.max(a.getX(), c.getX());
        int xR = Math.min(b.getX(), d.getX());
        if (!(xR <= xL)){
            int yT = Math.max(a.getY(), c.getY());
            int yB = Math.min(b.getY(), d.getY());
            if (!(yB <= yT)){
                for (int x = xL; x < xR; x++){
                    for (int y = yT; y < yB; y++){
                        if (this.hitBox[x - reference.getX()][y - reference.getY()] && hitBox.getHitBox()[x - hitBox.getReference().getX()][y - hitBox.getReference().getY()]){
                            intersects = true;
                            break;
                        }
                    }
                }
            }
        }

        return intersects;
    }

    public boolean[][] getHitBox() {
        return hitBox;
    }

    public boolean getPixel(int x, int y){
        return hitBox[x][y];
    }

    public Coordinate getReference(){
        return reference;
    }

    public void setHitBox(boolean[][] hitBox) {
        this.hitBox = hitBox;
    }

    public void setPixel(int x, int y, boolean value){
        hitBox[x][y] = value;
    }

    public void setReference(Coordinate reference){
        this.reference = reference;
    }
}