package raytracer;

import raytracer.math.Vector3;

public class Camera implements Object3d {
    final Vector3 eye;
    final double nearClipping;
    final double fov;
    final double aspectRatio;
    final Vector3 viewDirection;
    final Vector3 up;
    final int pixelsPerRow;
    final int pixelsPerColumn;

    final double width;
    final double height;
    final double singlePixelWidth;
    final double singlePixelHeight;

    final Vector3 upperLeftCorner;

    final Vector3 U;
    final Vector3 V;

    public Camera(Vector3 eye,
                  double nearClipping,
                  double fov,
                  double aspectRatio,
                  Vector3 viewDirection,
                  Vector3 up,
                  int pixelsPerRow) {
        this.eye = eye;
        this.nearClipping = nearClipping;
        this.fov = fov;
        this.aspectRatio = aspectRatio;
        this.viewDirection = viewDirection;
        this.up = up;
        this.pixelsPerRow = pixelsPerRow;
        this.pixelsPerColumn = (int) Math.floor(this.pixelsPerRow * (1 / aspectRatio));

        this.width = 2 * nearClipping * Math.tan(fov / 2);
        this.height = this.width * (1 / aspectRatio);


        singlePixelWidth = width / pixelsPerRow;
        singlePixelHeight = height / pixelsPerColumn;

        U = up.cross(viewDirection).opposite();
        V = up.opposite();
        upperLeftCorner = upperLeftCornerWorldPosition();
    }

    private Vector3 upperLeftCornerWorldPosition() {
        Vector3 rectCenter = eye.add(viewDirection.times(nearClipping));
        return rectCenter.add(U.times(-width/2)).add(V.times(-height/2));
    }

    public Vector3 pixelWorldPosition(int row, int col) {
        return upperLeftCorner
                .add(V.times(singlePixelHeight * (row + 0.5)))
                .add(U.times(singlePixelWidth * (col + 0.5)));
    }
}
