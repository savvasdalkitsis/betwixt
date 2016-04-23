package com.savvasdalkitsis.betwixt;

import android.view.animation.Interpolator;

class MultiplyInterpolator implements Interpolator {

    private final Interpolator first;
    private final Interpolator second;

    public MultiplyInterpolator(Interpolator first, Interpolator second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public float getInterpolation(float input) {
        return first.getInterpolation(input) * second.getInterpolation(input);
    }
}
