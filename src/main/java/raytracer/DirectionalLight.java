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
        Vector3 normal = surface.normalAt(point);
        float coeff = (float) direction.opposite().dot(normal);
        return surface.getDiffuseColor().times(Math.max(0, coeff));
    }

    private Color specular(Vector3 point, Surface surface, Scene scene) {
        Vector3 pointToEye = scene.camera.eye.minus(point).normalize();
        Vector3 normal = surface.normalAt(point);
        Vector3 halfVector = this.direction.opposite().add(pointToEye).normalize();

        double coeff = Math.max(0, normal.dot(halfVector));

        return surface.getSpecularColor().times((float) Math.pow(coeff, exponent));
    }


    @Override
    public Color contribution(Vector3 point, Surface surface, Scene scene) {
        //does it contribute ?
        if(scene.castRay(point, direction.opposite()).isPresent()) {
            //there is an obstacle
            return Color.BLACK; //no contribution
        }
        return diffuse(point, surface).add(specular(point, surface, scene)).times(this.intensity);
    }
}
