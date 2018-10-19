package com.example.ohimarc.marc.view.flashcardView;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;


/**
 * @author Mathias Forsman (Sorchar on github)
 * <p>
 * rotates something, in our case a button around the Y axis
 */
class Rotation extends Animation {
    private final float startAngle;
    private final float finalAngle;
    private final float centerOfXCoordinate;
    private final float centerOfYCoordinate;
    private final float mDepthZ;
    private final boolean mReverse;
    private Camera mCamera;

    /**
     * @param startAngle          is the angle of which the 3D rotation starts of
     * @param finalAngle          is the angle of which the 3D rotation ends at
     * @param centerOfXCoordinate the X center of the 3D rotation
     * @param centerOfYCoordinate the Y center of the 3D rotation
     * @param reverse             true if the translation should be reversed, false otherwise
     * @param depthZ              the depth of the Z coordinate
     */
    public Rotation(float startAngle, float finalAngle,
                    float centerOfXCoordinate, float centerOfYCoordinate, float depthZ, boolean reverse) {
        this.startAngle = startAngle;
        this.finalAngle = finalAngle;
        this.centerOfXCoordinate = centerOfXCoordinate;
        this.centerOfYCoordinate = centerOfYCoordinate;
        mDepthZ = depthZ;
        mReverse = reverse;
    }

    /**
     * Handles the values needed to start the rotation
     *
     * @param width        width of the object that will be rotating
     * @param height       height of the object that will be rotating
     * @param parentWidth  width of the objects parent
     * @param parentHeight height of the objects parent
     */
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    /**
     * applies the rotation to the object and makes it spin
     *
     * @param interpolatedTime The value of the normalized time (0.0 to 1.0) after it has been run through the interpolation function.
     * @param t                is the object that gets filled with current transforms
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final float fromDegrees = startAngle;
        float degrees = fromDegrees + ((finalAngle - fromDegrees) * interpolatedTime);

        final float centerX = centerOfXCoordinate;
        final float centerY = centerOfYCoordinate;
        final Camera camera = mCamera;

        final Matrix matrix = t.getMatrix();

        camera.save();
        if (mReverse) {
            camera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime);

        } else {
            camera.translate(0.0f, 0.0f, mDepthZ * (1.0f - interpolatedTime));
        }
        camera.rotateY(degrees);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
    }
}