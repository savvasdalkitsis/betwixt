package com.savvasdalkitsis.betwixt;

import android.view.animation.Interpolator;

class ReverseInterpolator implements Interpolator {

    private final Interpolator interpolator;

    public ReverseInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }

    @Override
    public float getInterpolation(float input) {
        return interpolator.getInterpolation(1 - input);
    }
}
