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
