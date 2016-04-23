/*
 * Copyright (C) 2016 Savvas Dalkitsis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.savvasdalkitsis.betwixt;

import android.view.animation.Interpolator;

import static java.lang.Math.max;
import static java.lang.Math.min;

class RasterizeInterpolator implements Interpolator {

    private final float[] raster;

    public RasterizeInterpolator(int rasterSize, Interpolator interpolator) {
        raster = new float[rasterSize];
        for (int i = 0; i < rasterSize; i++) {
            raster[i] = interpolator.getInterpolation(i / (float) rasterSize);
        }
    }

    @Override
    public float getInterpolation(float input) {
        int index = (int) (input * raster.length);
        return raster[min(index, max(0, raster.length - 1))];
    }
}
