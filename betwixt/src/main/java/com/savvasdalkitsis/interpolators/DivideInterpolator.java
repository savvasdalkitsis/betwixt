package com.savvasdalkitsis.interpolators;

import android.view.animation.Interpolator;

class DivideInterpolator implements Interpolator {

    private final Interpolator dividend;
    private final Interpolator divisor;

    public DivideInterpolator(Interpolator dividend, Interpolator divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    @Override
    public float getInterpolation(float input) {
        return dividend.getInterpolation(input) / divisor.getInterpolation(input);
    }
}
