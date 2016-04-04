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

        this.width = 0; //TODO: Fix Me
        this.height = 0; //TODO: Fix Me


        singlePixelWidth = 0; //TODO: Fix Me
        singlePixelHeight = 0;//TODO: Fix Me

        U = null; //TODO: Fix Me
        V = null; //TODO: Fix Me
        upperLeftCorner = upperLeftCornerWorldPosition();
    }

    private Vector3 upperLeftCornerWorldPosition() {
        //TODO: Fix Me
        return null;
    }

    public Vector3 pixelWorldPosition(int row, int col) {
        return upperLeftCorner
                .add(V.times(singlePixelHeight * (row + 0.5)))
                .add(U.times(singlePixelWidth * (col + 0.5)));
    }
}
