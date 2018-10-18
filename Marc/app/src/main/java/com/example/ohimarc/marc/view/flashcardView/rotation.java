package com.example.ohimarc.marc.view.flashcardView;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * rotates something, in our case a button around the Y axis
 */
    class rotation extends Animation {
    private final float startAngle;
    private final float finalAngle;
    private final float centerOfXCoord;
    private final float centerOfYCoord;
    private final float mDepthZ;
    private final boolean mReverse;
    private Camera mCamera;

    /**
     * @param startAngle     is the angle of which the 3D rotation starts of
     * @param finalAngle     is the angle of which the 3D rotation ends at
     * @param centerOfXCoord the X center of the 3D rotation
     * @param centerOfYCoord the Y center of the 3D rotation
     * @param reverse        true if the translation should be reversed, false otherwise
     * @param depthZ         the depth of the Z coordinate
     */
    public rotation(float startAngle, float finalAngle,
                    float centerOfXCoord, float centerOfYCoord, float depthZ, boolean reverse) {
        this.startAngle = startAngle;
        this.finalAngle = finalAngle;
        this.centerOfXCoord = centerOfXCoord;
        this.centerOfYCoord = centerOfYCoord;
        mDepthZ = depthZ;
        mReverse = reverse;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final float fromDegrees = startAngle;
        float degrees = fromDegrees + ((finalAngle - fromDegrees) * interpolatedTime);

        final float centerX = centerOfXCoord;
        final float centerY = centerOfYCoord;
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