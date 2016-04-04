package raytracer.math;

public class Utils {
    final static double EPSILON = 1e-5;

    public static boolean almostEquals(double a, double b) {
        return almostEquals(a, b, EPSILON);
    }

    public static boolean almostEquals(double a, double b, double epsilon) {
        return Math.abs(a - b) < epsilon;
    }
}
