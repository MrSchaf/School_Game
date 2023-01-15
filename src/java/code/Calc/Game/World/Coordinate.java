package code.Calc.Game.World;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(Coordinate coordinate){
        this.x = coordinate.getX();
        this.y = coordinate.getY();
    }

    public Coordinate(Coordinate coordinate, int x, int y) {
        this.x = coordinate.getX() + x;
        this.y = coordinate.getY() + y;
    }

    public boolean equals(Coordinate x){
        boolean same = this.getX() == x.getX();

        if(this.getY() != x.getY()){
            same = false;
        }

        return same;
    }

    public boolean toTopLeft(Coordinate that){
        boolean same = false;

        if(this.getX() <= that.getX()){
            if(this.getY() >= that.getY()){
                same = true;
            }
        }

        return same;
    }

    public boolean toTopRight(Coordinate that){
        boolean same = false;

        if(this.getX() >= that.getX()){
            if(this.getY() >= that.getY()){
                same = true;
            }
        }

        return same;
    }

    public boolean toBottomRight(Coordinate that){
        boolean same = false;

        if(this.getX() >= that.getX()){
            if(this.getY() <= that.getY()){
                same = true;
            }
        }

        return same;
    }

    public boolean toBottomLeft(Coordinate that){
        boolean same = false;

        if(this.getX() <= that.getX()){
            if(this.getY() <= that.getY()){
                same = true;
            }
        }

        return same;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}