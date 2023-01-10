package code.Calc.Game.Objects.Hitbox;

import code.Calc.Game.World.Coordinate;

import java.util.ArrayList;

public class HitBox {
    private ArrayList<Coordinate> pixels;
    Coordinate reference;

    public HitBox(ArrayList<Coordinate> pixels, Coordinate reference){
        this.pixels = pixels;
        this.reference = reference;
    }

    public boolean intersects(Coordinate x, Coordinate y){
        boolean intersects = false;

        for (Coordinate coordinate : pixels) {
            if(coordinate.toBottomRight(x) && coordinate.toBottomLeft(y)){
                intersects = true;
            }
        }

        return intersects;
    }

    public boolean intersects(HitBox hitBox){
        boolean intersects = false;
        ArrayList<Coordinate> thatPixels = hitBox.getPixels();

        for (Coordinate a : pixels) {
            for (Coordinate b : thatPixels) {
                if(a.equals(b)){
                    intersects = true;
                }
            }
        }

        return intersects;
    }

    public void setPixels(ArrayList<Coordinate> pixels) {
        this.pixels = pixels;
    }

    public ArrayList<Coordinate> getPixels() {
        return pixels;
    }

    public Coordinate getReference(){
        return reference;
    }

    public void setReference(Coordinate reference){
        this.reference = reference;
    }
}