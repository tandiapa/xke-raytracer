package raytracer;

import static raytracer.math.Vector3.vector3;
import static raytracer.utils.Color.color;

import raytracer.math.Vector3;
import raytracer.utils.Color;
import raytracer.utils.ImageBuffer;

import java.io.IOException;

public class Renderer {

    public void render(Scene scene, ImageBuffer imgBuffer) {
        // the number of pixels per column gives us the number of rows
        // while the number of pixels per row gives us the number of columns
        for(int row = 0; row < scene.camera.pixelsPerColumn; row++)
        for(int column = 0; column < scene.camera.pixelsPerRow; column++) {
            //TODO: Fix Me

            imgBuffer.putPixel(row, column, color(0.0f, 1.0f, 0.0f));
        }
    }

    public Scene defaultScene() {
        Camera camera = new Camera(
                vector3(0, 0, -15),
                0.5,
                Math.PI / 2,
                16 / 9.0,
                vector3(0, 0, 1),
                vector3(0, 1, 0),
                1024
        );
        DirectionalLight light = new DirectionalLight(vector3(1, -1, 0).normalize(), 32);
        Sphere sphere = new Sphere(
                Vector3.ORIGIN,
                5,
                color(0.7f, 0.2f, 0.0f),
                color(0.7f, 0.2f, 0.0f),
                Color.GREY);
        return new Scene()
                .setBackgroundColor(Color.BLACK)
                .setAmbientLightIntensity(0.2f)
                .setCamera(camera)
                .add(light)
                .add(sphere);
    }

    public Scene shadowScene() {
        Camera camera = new Camera(
                vector3(0, 0, -15),
                0.5,
                Math.PI / 2,
                16 / 9.0,
                vector3(0, 0, 1),
                vector3(0, 1, 0),
                1024
        );
        DirectionalLight light = new DirectionalLight(vector3(1, -1, 0).normalize(), 32);
        Sphere sphere = new Sphere(
                vector3(2.0, 0, 0),
                3,
                color(0.7f, 0.2f, 0.0f),
                color(0.7f, 0.2f, 0.0f),
                Color.GREY);

        Sphere smallerSphere = new Sphere(
                vector3(-3.0, 2.0, 0),
                2,
                color(0.0f, 0.2f, 0.7f),
                color(0.0f, 0.2f, 0.7f),
                Color.GREY);

        return new Scene()
                .setBackgroundColor(Color.BLACK)
                .setAmbientLightIntensity(0.2f)
                .setCamera(camera)
                .add(light)
                .add(sphere)
                .add(smallerSphere);
    }

    public static void main(String args[]) {
        Renderer renderer = new Renderer();
        Scene scene = renderer.defaultScene();
        ImageBuffer buffer = new ImageBuffer(scene.camera.pixelsPerRow, scene.camera.pixelsPerColumn);
        renderer.render(scene, buffer);
        try {
            buffer.saveAsPng("scene.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
