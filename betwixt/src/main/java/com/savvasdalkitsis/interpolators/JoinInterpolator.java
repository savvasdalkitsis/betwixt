package com.savvasdalkitsis.interpolators;

import android.view.animation.Interpolator;

class JoinInterpolator implements Interpolator {

    private Interpolator[] interpolators;

    public JoinInterpolator(Interpolator... interpolators) {
        this.interpolators = interpolators;
    }

    @Override
    public float getInterpolation(float input) {
        float stretchedInput = input * interpolators.length;
        int interpolatorIndex = (int) stretchedInput;
        float fragmentInput = stretchedInput - interpolatorIndex;
        if (interpolatorIndex == interpolators.length && fragmentInput == 0) {
            interpolatorIndex = interpolators.length - 1;
            fragmentInput = 1;
        }
        return interpolators[interpolatorIndex].getInterpolation(fragmentInput);
    }
}
