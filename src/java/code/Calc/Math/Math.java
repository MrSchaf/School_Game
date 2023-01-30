package code.Calc.Math;

import code.Calc.Game.World.Coordinate;

public class Math {
    public static final Math_Vector UP = new Math_Vector(0, -1, true);
    public static final Math_Vector DOWN = new Math_Vector(0, 1, true);
    public static final Math_Vector LEFT = new Math_Vector(-1, 0, true);
    public static final Math_Vector RIGHT = new Math_Vector(1, 0, true);

    public static double sqrt(double v) {
        return java.lang.Math.sqrt(v);
    }

    public static double atan2(double y, double x) {
        return java.lang.Math.atan2(y, x);
    }

    public static double cos(double angle) {
        return java.lang.Math.cos(angle);
    }

    public static double sin(double angle) {
        return java.lang.Math.sin(angle);
    }

    public static int max(int a, int b){
        int x = a;

        if(b > a){
            x = b;
        }

        return x;
    }

    public static int min(int a, int b){
        int x = a;

        if(b < a){
            x = b;
        }

        return x;
    }

    public static boolean intersects(Coordinate a, Coordinate b, Coordinate c, Coordinate d){
        boolean intersects = false;

        int xL = Math.max(a.getX(), c.getX());
        int xR = Math.min(b.getX(), d.getX());
        if (!(xR <= xL)){
            int yT = Math.max(a.getY(), c.getY());
            int yB = Math.min(b.getY(), d.getY());
            if (!(yB <= yT)) {
                intersects = true;
            }
        }

        return intersects;
    }
}