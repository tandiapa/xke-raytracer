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
        Vector3 oc = rayOrigin.minus(center);

        double b = 2 * oc.dot(rayDirection);
        double c =  oc.length() * oc.length() - radius * radius;

        double delta = b * b - 4 * c;

        if(delta >= 0) {
            return Optional.of((- b - Math.sqrt(delta)) / 2);
        } else {
            return Optional.empty();
        }
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
        return position.minus(center).normalize();
    }
}
