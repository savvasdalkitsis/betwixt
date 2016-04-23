package com.savvasdalkitsis.betwixt;

import android.view.animation.Interpolator;

class ConstantInterpolator implements Interpolator {

    private float value;

    ConstantInterpolator(float value) {
        this.value = value;
    }

    @Override
    public float getInterpolation(float input) {
        return value;
    }
}
