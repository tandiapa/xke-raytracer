package raytracer;

import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;
import raytracer.math.Vector3;

import static raytracer.math.Vector3.vector3;
import static org.assertj.core.api.Assertions.*;
import static raytracer.VectorAssert.*;

public class CameraTest {
    final Offset<Double> OFFSET = offset(1e-7);
    final Vector3 eye = vector3(0, 0, -10);
    final double focalLength = 0.5;
    final double fov = Math.PI / 2;
    final double aspectRatio = 16.0 / 9;
    final Vector3 viewDirection = vector3(0, 0, 1);
    final Vector3 up = vector3(0, 1, 0);

    Camera camera;

    @Before
    public void setUp() {
        camera = new Camera(eye, focalLength, fov, aspectRatio, viewDirection, up, 1024);
    }

    @Test
    public void should_have_the_correct_rectangle_projection_width() {
        assertThat(camera.width).isCloseTo(1.0, OFFSET);
    }

    @Test
    public void should_have_the_correct_rectangle_projection_height() {
        assertThat(camera.height).isCloseTo(0.5625, OFFSET);
    }

    @Test
    public void should_have_the_correct_upper_left_corner_position() {
        Vector3 expectedPosition = vector3(
                camera.width / 2,
                camera.height / 2,
                eye.add(viewDirection.times(focalLength)).z);
        assertThat(camera.upperLeftCorner).isCloseTo(expectedPosition, OFFSET);
    }

    @Test
    public void should_have_the_first_pixel_in_the_correct_position() {
        Vector3 expectedPosition = camera.upperLeftCorner
                .add(camera.U.times(camera.singlePixelWidth * 0.5))
                .add(camera.V.times(camera.singlePixelHeight * 0.5));
        assertThat(camera.pixelWorldPosition(0, 0)).isCloseTo(expectedPosition, OFFSET);
    }

    @Test
    public void should_have_the_row_20_col_30_pixel_in_the_correct_position() {
        Vector3 expectedPosition = camera.upperLeftCorner
                .add(camera.U.times(camera.singlePixelWidth * 30.5))
                .add(camera.V.times(camera.singlePixelHeight * 20.5));
        assertThat(camera.pixelWorldPosition(20, 30)).isCloseTo(expectedPosition, OFFSET);
    }

}
