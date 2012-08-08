package math;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/7/12
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleColor extends Vector4D{
    public SimpleColor(double r, double g, double b)
    {
        A = r;
        B = g;
        C = b;
        D = 1.0;
    }
    public SimpleColor()
    {
        A = 0.0;
        B = 0.0;
        C = 0.0;
        D = 1.0;
    }

    public static SimpleColor red() {
        return new SimpleColor(1,0,0);
    }
    public static SimpleColor green() {
        return new SimpleColor(0,1,0);
    }
    public static SimpleColor blue() {
        return new SimpleColor(0,0,1);
    }
    public static SimpleColor white() {
        return new SimpleColor(1,1,1);
    }
    public static SimpleColor black() {
        return new SimpleColor(0,0,0);
    }

    public double getRed() {
        return (A * 255);
    }
    public double getGreen() {
        return (B * 255);
    }
    public double getBlue() {
        return (C * 255);
    }
    public double getAlpha() {
        return (D * 255);
    }
}
