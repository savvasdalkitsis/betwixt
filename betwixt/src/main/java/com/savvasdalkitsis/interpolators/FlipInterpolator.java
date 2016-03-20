package com.savvasdalkitsis.interpolators;

import android.view.animation.Interpolator;

class FlipInterpolator implements Interpolator {

    private final Interpolator interpolator;

    public FlipInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }

    @Override
    public float getInterpolation(float input) {
        return 1 - interpolator.getInterpolation(input);
    }
}
