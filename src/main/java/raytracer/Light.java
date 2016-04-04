package raytracer;

import raytracer.math.Vector3;
import raytracer.utils.Color;

public interface Light extends Object3d {
    Light setIntensity(float k);

    Color contribution(Vector3 point, Surface surface, Scene scene);
}
