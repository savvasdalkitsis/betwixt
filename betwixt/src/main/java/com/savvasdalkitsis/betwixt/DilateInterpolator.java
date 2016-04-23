package com.savvasdalkitsis.betwixt;

import android.view.animation.Interpolator;

class DilateInterpolator implements Interpolator {

    private final Interpolator interpolator;
    private final Interpolator dilation;

    public DilateInterpolator(Interpolator interpolator, Interpolator dilation) {
        this.interpolator = interpolator;
        this.dilation = dilation;
    }

    @Override
    public float getInterpolation(float input) {
        return interpolator.getInterpolation(dilation.getInterpolation(input));
    }
}
