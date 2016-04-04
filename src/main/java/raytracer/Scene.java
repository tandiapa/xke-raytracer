package raytracer;

import raytracer.math.Vector3;
import raytracer.utils.Color;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Scene {
    List<Surface> surfaces = new LinkedList<>();
    List<Light> lights = new LinkedList<>();
    Camera camera;
    Color backgroundColor;
    float ambientLightIntensity;

    public Scene() {}

    public Scene setCamera(Camera camera) {
        this.camera = camera;
        return this;
    }

    public Scene setBackgroundColor(Color c) {
        this.backgroundColor = c;
        return this;
    }

    public Scene setAmbientLightIntensity(float k) {
        this.ambientLightIntensity = k;
        return this;
    }

    public Scene add(Light light) {
        lights.add(light);
        return this;
    }

    public Scene add(Surface surf) {
        surfaces.add(surf);
        return this;
    }

    public List<Surface> getSurfaces() {
        return this.surfaces;
    }

    public List<Light> getLights() {
        return this.lights;
    }

    /**
     * Util class used in order to represent the result of ray casting within a Scene
     */
    private static class Hit {
        double t;
        Surface surface;
        Hit(double t, Surface surface) {
            this.t = t;
            this.surface = surface;
        }
    }

    /**
     * Casts a ray in the scene in order to find the closest Surface it might hit
     * @param origin world position used as the starting point of the ray
     * @param direction must be an unit vector
     * @return a populated optional if a Surface has been found, empty otherwise
     */
    public Optional<Hit> castRay(Vector3 origin, Vector3 direction) {
        //TODO: Fix Me
        return null;
    }

    /**
     * Casts a ray within a scene, then returns the color of the closest surface it has found.
     * If none, returns the background color.
     * @param origin world position used as the starting point of the ray
     * @param direction must be an unit vector
     * @return a Color (thanks Captain)
     */
    public Color castRayColor(Vector3 origin, Vector3 direction) {
        Optional<Hit> hit = castRay(origin, direction);
        //TODO: Fix Me
        return null;
    }

}
