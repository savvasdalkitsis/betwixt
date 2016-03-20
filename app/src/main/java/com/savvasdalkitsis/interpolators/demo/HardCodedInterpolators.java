package com.savvasdalkitsis.interpolators.demo;

import android.support.v4.util.Pair;
import android.view.animation.Interpolator;

import static com.savvasdalkitsis.interpolators.Interpolators.accelerate;
import static com.savvasdalkitsis.interpolators.Interpolators.accelerateDecelerate;
import static com.savvasdalkitsis.interpolators.Interpolators.anticipateOvershoot;
import static com.savvasdalkitsis.interpolators.Interpolators.bounce;
import static com.savvasdalkitsis.interpolators.Interpolators.clip;
import static com.savvasdalkitsis.interpolators.Interpolators.constant;
import static com.savvasdalkitsis.interpolators.Interpolators.decelerate;
import static com.savvasdalkitsis.interpolators.Interpolators.dilate;
import static com.savvasdalkitsis.interpolators.Interpolators.fastOutLinearIn;
import static com.savvasdalkitsis.interpolators.Interpolators.fastOutSlowIn;
import static com.savvasdalkitsis.interpolators.Interpolators.flip;
import static com.savvasdalkitsis.interpolators.Interpolators.join;
import static com.savvasdalkitsis.interpolators.Interpolators.linear;
import static com.savvasdalkitsis.interpolators.Interpolators.linearOutSlowIn;
import static com.savvasdalkitsis.interpolators.Interpolators.multiply;
import static com.savvasdalkitsis.interpolators.Interpolators.overshoot;
import static com.savvasdalkitsis.interpolators.Interpolators.pingPong;
import static com.savvasdalkitsis.interpolators.Interpolators.rasterize;
import static com.savvasdalkitsis.interpolators.Interpolators.reverse;
import static com.savvasdalkitsis.interpolators.Interpolators.step;

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
            new Pair(join(3, pingPong(accelerateDecelerate())),
                    "join(3, pingPong(accelerateDecelerate))"),
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
                    "rasterize(4, linear)")
    };
}
