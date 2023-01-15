package code.Calc.Math;

public class Math {

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
}