package raytracer;

import raytracer.math.Vector3;
import raytracer.utils.Color;

import java.util.Optional;

public interface Surface extends Object3d {
    Optional<Double> hitBy(Vector3 rayOrigin, Vector3 rayDirection);

    public Color getAmbientColor();

    public Color getDiffuseColor();

    public Color getSpecularColor();
    
    Vector3 normalAt(Vector3 position);
}


