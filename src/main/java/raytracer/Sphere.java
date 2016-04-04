package raytracer;

import raytracer.math.Vector3;
import raytracer.utils.Color;

import java.util.Optional;

public class Sphere implements Surface {
    final Vector3 center;
    final double radius;
    final Color ambientColor;
    final Color diffuseColor;
    final Color specularColor;

    public Sphere(Vector3 center, double radius, Color ambientColor, Color diffuseColor, Color specularColor) {
        this.center = center;
        this.radius = radius;
        this.ambientColor = ambientColor;
        this.diffuseColor = diffuseColor;
        this.specularColor = specularColor;
    }

    @Override
    public Optional<Double> hitBy(Vector3 rayOrigin, Vector3 rayDirection) {
        //TODO: Fix Me
        return null;
    }

    public Color getAmbientColor() {
        return ambientColor;
    }

    public Color getDiffuseColor() {
        return diffuseColor;
    }

    public Color getSpecularColor() {
        return specularColor;
    }

    @Override
    public Vector3 normalAt(Vector3 position) {
        //TODO: Fix Me
        return null;
    }
}
