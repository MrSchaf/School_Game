package code.Calc.Math;

public class Math_Vector {
    private double x, y;
    private double length;
    private double angle;

    /**<p><strong>form = true</strong><br />Components<br />a = x<br />b = y</p>
     * <br />
     * <p><strong>form = false</strong><br />Magnitude and direction<br />a = length<br />b = angle</p>
     * **/
    public Math_Vector(double a, double b, boolean form) {
        if(form) {
            x = a;
            y = b;

            length = Math.sqrt(x * x + y * y);
            angle = Math.atan2(y, x);
        } else {
            length = a;
            angle = b;

            x = length * Math.cos(angle);
            y = length * Math.sin(angle);
        }
    }

    private void calc(boolean form) {
        if(form) {
            calcMagnitudeAndDirection();
        } else {
            calcComponents();
        }
    }

    private void calcComponents() {
        x = length * Math.cos(angle);
        y = length * Math.sin(angle);
    }

    private void calcMagnitudeAndDirection() {
        length = Math.sqrt(x * x + y * y);
        angle = Math.atan2(y, x);
    }

    public void add(Math_Vector v) {
        x += v.getX();
        y += v.getY();

        calcMagnitudeAndDirection();
    }

    public Math_Vector getAdded(Math_Vector v) {
        return new Math_Vector(x + v.getX(), y + v.getY(), true);
    }

    public void subtract(Math_Vector v) {
        x -= v.getX();
        y -= v.getY();

        calcMagnitudeAndDirection();
    }

    public Math_Vector getSubtracted(Math_Vector v) {
        return new Math_Vector(x - v.getX(), y - v.getY(), true);
    }

    public void multiply(double scalar) {
        x *= scalar;
        y *= scalar;

        calcMagnitudeAndDirection();
    }

    public Math_Vector getMultiplied(double scalar) {
        return new Math_Vector(x * scalar, y * scalar, true);
    }

    public void divide(double scalar) {
        x /= scalar;
        y /= scalar;

        calcMagnitudeAndDirection();
    }

    public Math_Vector getDivided(double scalar) {
        return new Math_Vector(x / scalar, y / scalar, true);
    }

    public void normalize() {
        x /= length;
        y /= length;

        calcMagnitudeAndDirection();
    }

    public Math_Vector getNormalize() {
        return new Math_Vector(x / length, y / length, true);
    }

    public double dotProduct(Math_Vector v) {
        return x * v.getX() + y * v.getY();
    }

    public double crossProduct(Math_Vector v) {
        return x * v.getY() - y * v.getX();
    }

    public int getDirX() {
        if(x > 0) {
            return 1;
        } else if(x < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getDirY() {
        if(y > 0) {
            return 1;
        } else if(y < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double getLength() {
        return length;
    }

    public double getAngle() {
        return angle;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public String toString() {
        return "Vector: (" + x + ", " + y + ")";
    }
}