package raytracer.utils;

import raytracer.math.Vector3;

public class Color {
    public float r;
    public float g;
    public float b;

    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color GREY = new Color(0.6f, 0.6f, 0.6f);

    public static Color color(float r, float g, float b) {
        return new Color(r, g, b);
    }

    public Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color blend(Color other, float alpha) {
        return new Color(
                this.r * alpha + (1 - alpha) * other.r,
                this.g * alpha + (1 - alpha) * other.g,
                this.b * alpha + (1 - alpha) * other.b);
    }

    public Color times(float k) {
        return new Color(
                this.r * k,
                this.g * k,
                this.b * k
        );
    }

    public Color add(Color other) {
        return new Color(
                this.r + other.r,
                this.g + other.g,
                this.b + other.b
        ).clamp();
    }

    private Color clamp() {
        return new Color(
                Math.min(Math.max(this.r, 0.0f), 1.0f),
                Math.min(Math.max(this.g, 0.0f), 1.0f),
                Math.min(Math.max(this.b, 0.0f), 1.0f)
        );
    }

    public int toRGB() {
        int ir = (int) Math.floor(r * 255);
        int ig = (int) Math.floor(g * 255);
        int ib = (int) Math.floor(b * 255);

        return ((0xFF & ir) << 16) | ((0xFF & ig) << 8) | (0xFF & ib);
    }
}
