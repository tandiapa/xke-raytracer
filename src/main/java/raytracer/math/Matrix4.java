package raytracer.math;

public class Matrix4 {
    private double[] v;

    public Matrix4() {
        this.v = new double[]{
                1.0, 0.0, 0.0, 0.0,
                0.0, 1.0, 0.0, 0.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0
        };
    }

    public Matrix4(double[] values) {
        if(v.length != 16) throw new RuntimeException("Invalid 4x4 matrix values (16 required)");
        this.v = values;
    }

    public Matrix4 add(Matrix4 rhs) {
        for(int i = 0; i < 16; i++) this.v[i] += rhs.v[i];

        return this;
    }

    public Matrix4 mult(Matrix4 rhs) {
        double a00 = v[0], a01 = v[1], a02 = v[2], a03 = v[3];
        double a10 = v[4], a11 = v[5], a12 = v[6], a13 = v[7];
        double a20 = v[8], a21 = v[9], a22 = v[10], a23 = v[11];
        double a30 = v[12], a31 = v[13], a32 = v[14], a33 = v[15];

        double b00 = rhs.v[0], b01 = rhs.v[1], b02 = rhs.v[2], b03 = rhs.v[3];
        double b10 = rhs.v[4], b11 = rhs.v[5], b12 = rhs.v[6], b13 = rhs.v[7];
        double b20 = rhs.v[8], b21 = rhs.v[9], b22 = rhs.v[10], b23 = rhs.v[11];
        double b30 = rhs.v[12], b31 = rhs.v[13], b32 = rhs.v[14], b33 = rhs.v[15];

        v[0] = a00 * b00 + a01 * b10 + a02 * b20 + a03 * b30;
        v[1] = a00 * b01 + a01 * b11 + a02 * b21 + a03 * b31;
        v[2] = a00 * b02 + a01 * b12 + a02 * b22 + a03 * b32;
        v[3] = a00 * b03 + a01 * b13 + a02 * b23 + a03 * b33;

        v[4] = a10 * b00 + a11 * b10 + a12 * b20 + a13 * b30;
        v[5] = a10 * b01 + a11 * b11 + a12 * b21 + a13 * b31;
        v[6] = a10 * b02 + a11 * b12 + a12 * b22 + a13 * b32;
        v[7] = a10 * b03 + a11 * b13 + a12 * b23 + a13 * b33;

        v[8]  = a20 * b00 + a21 * b10 + a22 * b20 + a23 * b30;
        v[9]  = a20 * b01 + a21 * b11 + a22 * b21 + a23 * b31;
        v[10] = a20 * b02 + a21 * b12 + a22 * b22 + a23 * b32;
        v[11] = a20 * b03 + a21 * b13 + a22 * b23 + a23 * b33;

        v[12] = a30 * b00 + a31 * b10 + a32 * b20 + a33 * b30;
        v[13] = a30 * b01 + a31 * b11 + a32 * b21 + a33 * b31;
        v[14] = a30 * b02 + a31 * b12 + a32 * b22 + a33 * b32;
        v[15] = a30 * b03 + a31 * b13 + a32 * b23 + a33 * b33;

        return this;
    }

    public Matrix4 transpose() {
        double swapTmp;
        //values on the diagonal don't move

        swapTmp = v[1]; v[1] = v[4]; v[4] = swapTmp;
        swapTmp = v[2]; v[2] = v[8]; v[8] = swapTmp;
        swapTmp = v[3]; v[3] = v[12]; v[12] = swapTmp;

        swapTmp = v[9]; v[9] = v[6]; v[6] = swapTmp;
        swapTmp = v[13]; v[13] = v[7]; v[7] = swapTmp;

        swapTmp = v[14]; v[14] = v[12]; v[12] = swapTmp;

        return this;
    }

    public Matrix4 mult(double k) {
        for(int i=0; i < 16; i ++) this.v[i] *= k;

        return this;
    }
}
