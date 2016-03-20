package com.savvasdalkitsis.interpolators;

import android.view.animation.Interpolator;

import static java.lang.Math.max;
import static java.lang.Math.min;

class ClipInterpolator implements Interpolator {

    private Interpolator interpolator;
    private final float start;
    private final float end;

    public ClipInterpolator(Interpolator interpolator, float start, float end) {
        this.interpolator = interpolator;
        this.start = inBounds(start);
        this.end = inBounds(end);
    }

    @Override
    public float getInterpolation(float input) {
        return input < start ? 0 :
                input > end ? 0 :
                interpolator.getInterpolation(input);
    }

    private float inBounds(float point) {
        return max(0, min(point, 1));
    }
}
