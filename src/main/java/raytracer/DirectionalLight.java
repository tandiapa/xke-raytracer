package raytracer;

import raytracer.math.Vector3;
import raytracer.utils.Color;

public class DirectionalLight implements Light {
    final Vector3 direction;
    final double exponent;
    float intensity = 1.0f;

    public DirectionalLight(Vector3 direction, double exponent) {
        this.direction = direction;
        this.exponent = exponent;
    }

    @Override
    public Light setIntensity(float k) {
        this.intensity = k;
        return this;
    }

    public Vector3 getDirection() {
        return this.direction;
    }

    private Color diffuse(Vector3 point, Surface surface) {
        //TODO: Fix Me
        return null;
    }

    private Color specular(Vector3 point, Surface surface, Scene scene) {
        //TODO: Fix Me
        return null;
    }


    @Override
    public Color contribution(Vector3 point, Surface surface, Scene scene) {
        return diffuse(point, surface).add(specular(point, surface, scene)).times(this.intensity);
    }
}
