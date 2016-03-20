package com.savvasdalkitsis.interpolators;

import android.view.animation.Interpolator;

import static java.lang.Math.max;
import static java.lang.Math.min;

class RasterizeInterpolator implements Interpolator {

    private final float[] raster;

    public RasterizeInterpolator(int rasterSize, Interpolator interpolator) {
        raster = new float[rasterSize];
        for (int i = 0; i < rasterSize; i++) {
            raster[i] = interpolator.getInterpolation(i / (float) rasterSize);
        }
    }

    @Override
    public float getInterpolation(float input) {
        int index = (int) (input * raster.length);
        return raster[min(index, max(0, raster.length - 1))];
    }
}
