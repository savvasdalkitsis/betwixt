package com.savvasdalkitsis.betwixt.rebound;

import android.support.annotation.NonNull;
import android.view.animation.Interpolator;

import com.facebook.rebound.BaseSpringSystem;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SteppingLooper;
import com.savvasdalkitsis.betwixt.Interpolators;

import java.util.ArrayList;
import java.util.List;

public class SpringInterpolator {

    private Spring spring;
    private final SteppingLooper steppingLooper;

    public SpringInterpolator() {
        steppingLooper = new SteppingLooper();
        spring = new BaseSpringSystem(steppingLooper).createSpring();
    }

    /**
     * Call this method to configure the internal {@link Spring} before calling {@link #rasterize()}
     */
    @NonNull
    public Spring configure() {
        return spring;
    }

    /**
     * This method will rasterize the interpolator using the internal {@link Spring}. This method
     * creates a rather large internal array and will rasterize the {@link Spring} synchronously,
     * so calling this method will allocate memory and may take a small amount of time (so the
     * caller should take care about not calling this often and in a drawing critical place)
     * @return the rasterized {@link Interpolator} created by the {@link Spring}
     */
    @NonNull
    public Interpolator rasterize() {
        spring.setEndValue(1);
        final List<Float> times = new ArrayList<>(255);
        while (!spring.isAtRest()) {
            steppingLooper.step(1);
            times.add((float) spring.getCurrentValue());
        }
        int size = times.size();
        int multiplier = 1;
        if (size < 500) {
            multiplier = 500 / size;
        }
        final float[] values = new float[size * multiplier];
        for (int i = 0; i < size; i++) {
            float value = times.get(i);
            float next = times.get(i < size - 1 ? i + 1 : i);
            for (int j = 0; j < multiplier; j++) {
                values[i*multiplier+j] = value + j*((next - value) / multiplier);
            }
        }
        return Interpolators.rasterize(values);
    }
}
