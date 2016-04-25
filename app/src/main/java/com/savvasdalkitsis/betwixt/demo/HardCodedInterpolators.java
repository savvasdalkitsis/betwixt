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
package com.savvasdalkitsis.betwixt.demo;

import android.support.v4.util.Pair;
import android.view.animation.Interpolator;

import static com.savvasdalkitsis.betwixt.Interpolators.accelerate;
import static com.savvasdalkitsis.betwixt.Interpolators.accelerateDecelerate;
import static com.savvasdalkitsis.betwixt.Interpolators.anticipateOvershoot;
import static com.savvasdalkitsis.betwixt.Interpolators.bounce;
import static com.savvasdalkitsis.betwixt.Interpolators.clip;
import static com.savvasdalkitsis.betwixt.Interpolators.constant;
import static com.savvasdalkitsis.betwixt.Interpolators.decelerate;
import static com.savvasdalkitsis.betwixt.Interpolators.dilate;
import static com.savvasdalkitsis.betwixt.Interpolators.fastOutLinearIn;
import static com.savvasdalkitsis.betwixt.Interpolators.fastOutSlowIn;
import static com.savvasdalkitsis.betwixt.Interpolators.flip;
import static com.savvasdalkitsis.betwixt.Interpolators.join;
import static com.savvasdalkitsis.betwixt.Interpolators.linear;
import static com.savvasdalkitsis.betwixt.Interpolators.linearOutSlowIn;
import static com.savvasdalkitsis.betwixt.Interpolators.multiply;
import static com.savvasdalkitsis.betwixt.Interpolators.overshoot;
import static com.savvasdalkitsis.betwixt.Interpolators.pingPong;
import static com.savvasdalkitsis.betwixt.Interpolators.rasterize;
import static com.savvasdalkitsis.betwixt.Interpolators.repeat;
import static com.savvasdalkitsis.betwixt.Interpolators.reverse;
import static com.savvasdalkitsis.betwixt.Interpolators.step;
import static com.savvasdalkitsis.betwixt.rebound.SpringInterpolators.spring;

public class HardCodedInterpolators {
    @SuppressWarnings("unchecked")
    public static final Pair<Interpolator, String>[] INTERPOLATORS = new Pair[] {
            new Pair<>(linear(),
                    "linear"),
            new Pair(accelerateDecelerate(),
                    "accelerateDecelerate"),
            new Pair(accelerate(),
                    "accelerate"),
            new Pair(multiply(linear(), linear()),
                    "multiply(linear, linear)"),
            new Pair(bounce(),
                    "bounce"),
            new Pair(flip(bounce()),
                    "flip(bounce)"),
            new Pair(reverse(bounce()),
                    "reverse(bounce)"),
            new Pair(step(),
                    "step"),
            new Pair(overshoot(),
                    "overshoot"),
            new Pair(anticipateOvershoot(),
                    "anticipateOvershoot"),
            new Pair(fastOutSlowIn(),
                    "fastOutSlowIn"),
            new Pair(fastOutLinearIn(),
                    "fastOutLinearIn"),
            new Pair(pingPong(accelerateDecelerate()),
                    "pingPong(accelerateDecelerate)"),
            new Pair(repeat(3, pingPong(accelerateDecelerate())),
                    "repeat(3, pingPong(accelerateDecelerate))"),
            new Pair(pingPong(multiply(accelerateDecelerate(), anticipateOvershoot())),
                    "pingPong(multiply(accelerateDecelerate, anticipateOvershoot))"),
            new Pair(pingPong(linear()),
                    "pingPong(linear)"),
            new Pair(clip(multiply(bounce(), linearOutSlowIn()), 0.25f, 0.75f),
                    "clip(multiply(bounce, linearOutSlowIn), 0.25, 0.75)"),
            new Pair(join(accelerateDecelerate(), flip(bounce())),
                    "join(accelerateDecelerate, flip(bounce))"),
            new Pair(dilate(join(accelerateDecelerate(), flip(bounce())), decelerate()),
                    "dilate(join(accelerateDecelerate, flip(bounce)), decelerate)"),
            new Pair(dilate(join(accelerateDecelerate(), flip(bounce())), fastOutSlowIn()),
                    "dilate(join(accelerateDecelerate, flip(bounce)), fastOutSlowIn)"),
            new Pair(join(constant(0), constant(0.25f), constant(0.5f), constant(0.75f)),
                    "join(constant(0), constant(0.25), constant(0.5), constant(0.75))"),
            new Pair(rasterize(4, linear()),
                    "rasterize(4, linear)"),
            new Pair(spring().rasterize(),
                    "spring()"),
            new Pair(spring(40, 3).rasterize(),
                    "spring(40, 3)")
    };
}
