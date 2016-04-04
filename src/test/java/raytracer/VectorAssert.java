package raytracer;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import raytracer.math.Vector3;

public class VectorAssert extends AbstractAssert<VectorAssert, Vector3> {
    public VectorAssert(Vector3 actual) {
        super(actual, VectorAssert.class);
    }

    public static VectorAssert assertThat(Vector3 actual) {
        return new VectorAssert(actual);
    }

    public VectorAssert isCloseTo(Vector3 v, Offset<Double> offset) {
        Assertions.assertThat(actual.x).isCloseTo(v.x, offset);
        Assertions.assertThat(actual.y).isCloseTo(v.y, offset);
        Assertions.assertThat(actual.z).isCloseTo(v.z, offset);

        return this;
    }


}
