package raytracer.math;

public class Vector3 {
    public final double x;
    public final double y;
    public final double z;

    public static Vector3 ORIGIN = new Vector3();

    public static Vector3 vector3() {
        return new Vector3();
    }

    public static Vector3 vector3(double x, double y, double z) {
        return new Vector3(x, y, z);
    }

    private Vector3() {
        this.x = this.y = this.z = 0;
    }

    private Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 add(Vector3 rhs) {
        return new Vector3(
                this.x + rhs.x,
                this.y + rhs.y,
                this.z + rhs.z);
    }

    public Vector3 times(double k) {
        return new Vector3(
                this.x * k,
                this.y * k,
                this.z * k);
    }

    public double length() {
        double x2 = this.x * this.x;
        double y2 = this.y * this.y;
        double z2 = this.z * this.z;

        return Math.sqrt(x2 + y2 + z2);
    }

    public Vector3 opposite() {
        return times(-1.0);
    }

    public Vector3 minus(Vector3 rhs) {
        return add(rhs.opposite());
    }

    public Vector3 normalize() {
        return times(1 / length());
    }

    public Vector3 cross(Vector3 rhs) {
        return new Vector3(
                this.y * rhs.z - this.z * rhs.y,
                this.z * rhs.x - this.x * rhs.z,
                this.x * rhs.y - this.y * rhs.x);
    }

    public double dot(Vector3 rhs) {
        return this.x * rhs.x + this.y * rhs.y + this.z * rhs.z;
    }

    @Override
    public String toString() {
        return "(x=" + x + ", y=" + y + ", z=" + z + ")";
    }
}
