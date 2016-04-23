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

class ReverseInterpolator implements Interpolator {

    private final Interpolator interpolator;

    public ReverseInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }

    @Override
    public float getInterpolation(float input) {
        return interpolator.getInterpolation(1 - input);
    }
}
