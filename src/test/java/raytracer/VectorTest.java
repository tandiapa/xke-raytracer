package raytracer;

import org.assertj.core.data.Offset;
import org.junit.Test;
import raytracer.math.Vector3;

import static org.assertj.core.api.Assertions.*;
import static raytracer.VectorAssert.*;
import static raytracer.math.Vector3.vector3;

public class VectorTest {
    final Offset<Double> OFFSET = offset(1e-7);

    @Test
    public void normalize_should_return_a_unit_vector() {
        Vector3 v = vector3(1.0, 1.0, 0.0).normalize();
        assertThat(v.length()).isCloseTo(1.0, OFFSET);
    }

    @Test
    public void dot_should_return_0_for_orthogonal_vectors() {
        Vector3 a = vector3(1.0, 0.0, 0.0);
        Vector3 orthogonalToA = vector3(0.0, 1.0, 0.0);

        assertThat(a.dot(orthogonalToA)).isCloseTo(0.0, OFFSET);
    }

    @Test
    public void dot_between_unit_vectors_should_return_the_cosine() {
        Vector3 a = vector3(1.0, 1.0, 0.0).normalize();
        Vector3 b = vector3(1.0, 0.0, 0.0);

        assertThat(a.dot(b)).isCloseTo(Math.cos(Math.PI / 4), OFFSET);
    }

    @Test
    public void cross_should_return_the_orthogonal_vector_right_hand() {
        Vector3 X = vector3(1.0, 0.0, 0.0);
        Vector3 Y = vector3(0.0, 1.0, 0.0);
        Vector3 Z = vector3(0.0, 0.0, 1.0);

        assertThat(X.cross(Y)).isCloseTo(Z, OFFSET);
        assertThat(Y.cross(Z)).isCloseTo(X, OFFSET);
        assertThat(Z.cross(X)).isCloseTo(Y, OFFSET);
    }
}
