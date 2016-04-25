package com.savvasdalkitsis.betwixt.rebound;

import android.support.annotation.NonNull;

import com.facebook.rebound.SpringConfig;

public class SpringInterpolators {

    /**
     * A spring interpolator backed by a {@link com.facebook.rebound.Spring}. This creates a
     * {@link SpringInterpolator} that allows the caller to {@link SpringInterpolator#configure()}
     * the spring before rasterizing it. See {@link SpringInterpolator#rasterize()}
     */
    @NonNull
    public static SpringInterpolator spring() {
        return new SpringInterpolator();
    }

    /**
     * A spring interpolator backed by a {@link com.facebook.rebound.Spring}. This creates a
     * {@link SpringInterpolator} with the provided tension and friction. The caller can still
     * {@link SpringInterpolator#configure()} the spring before rasterizing it.
     * See {@link SpringInterpolator#rasterize()}
     */
    @NonNull
    public static SpringInterpolator spring(double tension, double friction) {
        SpringInterpolator interpolator = new SpringInterpolator();
        interpolator.configure().setSpringConfig(new SpringConfig(tension, friction));
        return interpolator;
    }
}
