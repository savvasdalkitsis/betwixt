package com.savvasdalkitsis.interpolators;

import android.view.animation.Interpolator;

class JoinInterpolatorold implements Interpolator {

    private final Interpolator first;
    private final Interpolator second;

    public JoinInterpolatorold(Interpolator first, Interpolator second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public float getInterpolation(float input) {
        return input < 0.5f
                ? first.getInterpolation(input * 2)
                : second.getInterpolation((input-0.5f) * 2);
    }
}
