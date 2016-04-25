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

import android.graphics.Path;
import android.support.annotation.NonNull;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

import java.util.Arrays;

public final class Interpolators {

    private Interpolators() {}

    /* Platform interpolators */

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * A linear interpolator. This returns the value passed in
     */
    @NonNull
    public static Interpolator linear() {
        return new LinearInterpolator();
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the rate of change starts out slowly and and then accelerates.
     */
    @NonNull
    public static Interpolator accelerate() {
        return new AccelerateInterpolator();
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the rate of change starts out slowly and and then accelerates.
     * @param factor Degree to which the animation should be eased. Seting factor to 1.0f 
     *               produces a y=x^2 parabola. Increasing factor above 1.0f exaggerates the 
     *               ease-in effect (i.e., it starts even slower and ends evens faster)
     */
    @NonNull
    public static Interpolator accelerate(float factor) {
        return new AccelerateInterpolator(factor);
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the rate of change starts and ends slowly but accelerates through the middle.
     */
    @NonNull
    public static Interpolator accelerateDecelerate() {
        return new AccelerateDecelerateInterpolator();
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the change starts backward then flings forward.
     */
    @NonNull
    public static Interpolator anticipate() {
        return new AnticipateInterpolator();
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the change starts backward then flings forward.
     * @param tension Amount of anticipation. When tension equals 0.0f, there is no anticipation
     *                and the interpolator becomes a simple acceleration interpolator.
     */
    @NonNull
    public static Interpolator anticipate(float tension) {
        return new AnticipateInterpolator(tension);
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the change bounces at the end.
     */
    @NonNull
    public static Interpolator bounce() {
        return new BounceInterpolator();
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * Repeats the animation for a specified number of cycles. The rate of change follows a sinusoidal pattern.
     */
    @NonNull
    public static Interpolator cycle(int cycles) {
        return new CycleInterpolator(cycles);
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the rate of change starts out quickly and and then decelerates.
     */
    @NonNull
    public static Interpolator decelerate() {
        return new DecelerateInterpolator();
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the rate of change starts out quickly and and then decelerates.
     * @param factor Degree to which the animation should be eased. Setting factor to 1.0f produces
     *               an upside-down y=x^2 parabola. Increasing factor above 1.0f makes exaggerates
     *               the ease-out effect (i.e., it starts even faster and ends evens slower)
     */
    @NonNull
    public static Interpolator decelerate(int factor) {
        return new DecelerateInterpolator(factor);
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the change flings forward and overshoots the last value then comes back.
     */
    @NonNull
    public static Interpolator overshoot() {
        return new OvershootInterpolator();
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the change flings forward and overshoots the last value then comes back.
     * @param tension Amount of overshoot. When tension equals 0.0f, there is no overshoot and the
     *                interpolator becomes a simple deceleration interpolator.
     */
    @NonNull
    public static Interpolator overshoot(int tension) {
        return new OvershootInterpolator(tension);
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the change starts backward then flings forward and overshoots the
     * target value and finally goes back to the final value.
     */
    @NonNull
    public static Interpolator anticipateOvershoot() {
        return new AnticipateOvershootInterpolator();
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the change starts backward then flings forward and overshoots the
     * target value and finally goes back to the final value.
     * @param tension Amount of anticipation/overshoot. When tension equals 0.0f, there is no
     *                anticipation/overshoot and the interpolator becomes a simple
     *                acceleration/deceleration interpolator.
     */
    @NonNull
    public static Interpolator anticipateOvershoot(int tension) {
        return new AnticipateOvershootInterpolator(tension);
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * An interpolator where the change starts backward then flings forward and overshoots the
     * target value and finally goes back to the final value.
     * @param tension Amount of anticipation/overshoot. When tension equals 0.0f, there is no
     *                anticipation/overshoot and the interpolator becomes a simple
     *                acceleration/deceleration interpolator.
     * @param extraTension Amount by which to multiply the tension. For instance, to get the same
     *                     overshoot as an OvershootInterpolator with a tension of 2.0f, you would
     *                     use an extraTension of 1.5f.
     */
    @NonNull
    public static Interpolator anticipateOvershoot(int tension, int extraTension) {
        return new AnticipateOvershootInterpolator(tension, extraTension);
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * Create an Interpolator for an arbitrary Path. The Path must begin at (0, 0) and end at
     * (1, 1). The x-coordinate along the Path is the input value and the output is the y
     * coordinate of the line at that point. This means that the Path must conform to a function y = f(x).
     * @param path the Path to use to make the line representing the Interpolator
     */
    @NonNull
    public static Interpolator path(Path path) {
        return PathInterpolatorCompat.create(path);
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * Create an Interpolator for a quadratic Bezier curve. The end points (0, 0) and (1, 1) are assumed.
     * @param controlX the x coordinate of the quadratic Bezier control point
     * @param controlY the y coordinate of the quadratic Bezier control point
     */
    @NonNull
    public static Interpolator path(int controlX, int controlY) {
        return PathInterpolatorCompat.create(controlX, controlY);
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * Create an Interpolator for a cubic Bezier curve. The end points (0, 0) and (1, 1) are assumed.
     * @param controlX1 the x coordinate of the first control point of the cubic Bezier
     * @param controlY1 the y coordinate of the first control point of the cubic Bezier
     * @param controlX2 the x coordinate of the second control point of the cubic Bezier
     * @param controlY2 the y coordinate of the second control point of the cubic Bezier
     */
    @NonNull
    public static Interpolator path(int controlX1, int controlY1, int controlX2, int controlY2) {
        return PathInterpolatorCompat.create(controlX1, controlY1, controlX2, controlY2);
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * Interpolator corresponding to fast_out_linear_in. Uses a lookup table for the Bezier curve
     * from (0,0) to (1,1) with control points: P0 (0, 0) P1 (0.4, 0) P2 (1.0, 1.0) P3 (1.0, 1.0)
     */
    @NonNull
    public static Interpolator fastOutLinearIn() {
        return new FastOutLinearInInterpolator();
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * Interpolator corresponding to fast_out_slow_in. Uses a lookup table for the Bezier curve
     * from (0,0) to (1,1) with control points: P0 (0, 0) P1 (0.4, 0) P2 (0.2, 1.0) P3 (1.0, 1.0)
     */
    @NonNull
    public static Interpolator fastOutSlowIn() {
        return new FastOutSlowInInterpolator();
    }

    /**
     * <strong>ANDROID INTERPOLATOR</strong><br/><br/>
     * Interpolator corresponding to linear_out_slow_in. Uses a lookup table for the Bezier curve
     * from (0,0) to (1,1) with control points: P0 (0, 0) P1 (0, 0) P2 (0.2, 1.0) P3 (1.0, 1.0)
     */
    @NonNull
    public static Interpolator linearOutSlowIn() {
        return new LinearOutSlowInInterpolator();
    }

    /* Library interpolators */

    /**
     * Reverses the provided interpolator. For any value of 'input', the value '1-input' will be used
     * on the provided interpolator and the result will be returned
     * @param interpolator the interpolator to reverse
     */
    @NonNull
    public static Interpolator reverse(Interpolator interpolator) {
        return new ReverseInterpolator(interpolator);
    }

    /**
     * Flips the provided interpolator. For the result value of the provided interpolator
     * using the input value, the value '1-result' will be provided
     * @param interpolator the interpolator to flip
     */
    @NonNull
    public static Interpolator flip(Interpolator interpolator) {
        return new FlipInterpolator(interpolator);
    }

    /**
     * Joins N interpolators together. They will be executed sequentially, each interpolator
     * scaled to an 1/N range
     * @param interpolators the interpolators to repeat in sequence
     */
    @NonNull
    public static Interpolator join(Interpolator... interpolators) {
        return new JoinInterpolator(interpolators);
    }

    /**
     * Repeats the provided interpolator N times. This uses {@link #join(Interpolator...)} internally
     * @param times the amount of times to repeat the interpolator
     * @param interpolator the interpolator to repeat
     */
    @NonNull
    public static Interpolator repeat(int times, Interpolator interpolator) {
        Interpolator[] interpolators = new Interpolator[times];
        Arrays.fill(interpolators, interpolator);
        return join(interpolators);
    }

    /**
     * Plays an interpolator and reverses it, each part taking half the duration of the animation
     * @param interpolator the interpolator to play and reverse
     */
    @NonNull
    public static Interpolator pingPong(Interpolator interpolator) {
        return join(interpolator, reverse(interpolator));
    }

    /**
     * A constant value interpolator. This will always return 0 by default
     */
    @NonNull
    public static Interpolator constant() {
        return constant(0);
    }

    /**
     * A constant value interpolator. This will always return the value provided
     * @param value the constant value to always return
     */
    @NonNull
    public static Interpolator constant(float value) {
        return new ConstantInterpolator(value);
    }

    /**
     * An interpolator whose value at each point is the result of multiplying the outcomes of the
     * two provided interpolators
     * @param first the first interpolator to use for the multiplication
     * @param second the second interpolator to use for the multiplication
     */
    @NonNull
    public static Interpolator multiply(Interpolator first, Interpolator second) {
        return new MultiplyInterpolator(first, second);
    }

    /**
     * An interpolator whose value at each point is multiplied by the specified value
     * @param interpolator the interpolator to multiply
     * @param multiplier the value to multiply the interpolator by
     */
    @NonNull
    public static Interpolator multiply(Interpolator interpolator, float multiplier) {
        return multiply(interpolator, constant(multiplier));
    }

    /**
     * An interpolator whose value at each point is the result of dividing the outcomes of the
     * two provided interpolators. <strong>note that this does not guard against division by 0</strong>
     * @param dividend the interpolator whose values are used as the dividend in the division
     * @param divisor the interpolator whose values are used as the divisor in the division.
     *                <strong>if this interpolator returns 0 at any point, an exception will be
     *                thrown at runtime</strong>
     */
    @NonNull
    public static Interpolator divide(Interpolator dividend, Interpolator divisor) {
        return new DivideInterpolator(dividend, divisor);
    }

    /**
     * An interpolator whose value at each point is divided by the provided value.
     * <strong>note that this does not guard against division by 0</strong>
     * @param dividend the interpolator whose values are used as the dividend in the division
     * @param divisor the value to divide the interpolator by.
     *                <strong>if this is 0, an exception will be thrown at runtime</strong>
     */
    @NonNull
    public static Interpolator divide(Interpolator dividend, float divisor) {
        return divide(dividend, constant(divisor));
    }

    /**
     * Provides a raster version of the provided interpolator. It uses 255 samples over the
     * interpolator which are kept in an array and the closest sample matching the input value
     * is returned
     * @param interpolator the interpolator to rasterize
     */
    @NonNull
    public static Interpolator rasterize(Interpolator interpolator) {
        return rasterize(255, interpolator);
    }

    /**
     * Provides a raster version of the provided interpolator. It uses the provided sample number
     * over the interpolator. The samples are kept in an array and the closest sample matching
     * the input value is returned
     * @param interpolator the interpolator to rasterize
     * @param samples the amount of samples to use from the interpolator
     */
    @NonNull
    public static Interpolator rasterize(int samples, Interpolator interpolator) {
        return new RasterizeInterpolator(samples, interpolator);
    }

    /**
     * Provides a raster interpolator which pulls values from the provided raster array.
     * @param raster the array containing the sample values to pull from
     */
    @NonNull
    public static Interpolator rasterize(float[] raster) {
        return new RasterizeInterpolator(raster);
    }

    /**
     * A step interpolator with the first half of the duration returning 0 and the second half
     * returning 1
     */
    @NonNull
    public static Interpolator step() {
        return step(0, 1);
    }

    /**
     * A step interpolator with the first and second halves of the duration returning the provided
     * values
     * @param first the value to return for the first half of the animation
     * @param second the value to return for the second half of the animation
     */
    @NonNull
    public static Interpolator step(int first, int second) {
        return join(constant(first), constant(second));
    }

    /**
     * Clips another interpolator in the specified region. If start > end, then the interpolator
     * will always return 0
     * @param interpolator the interpolator to clip
     * @param start the start of the clip (will use 0 if negative)
     * @param end the end of the clip (will use 1 if greater than)
     */
    @NonNull
    public static Interpolator clip(Interpolator interpolator, float start, float end) {
        return new ClipInterpolator(interpolator, start, end);
    }

    /**
     * Dilates the time of the provided interpolator. This will use the dilation interpolator's
     * result as the input of the interpolator to dilate
     * @param interpolator the interpolator whose time is dilated
     * @param dilation the interpolator used to determine the input of the first interpolator
     */
    @NonNull
    public static Interpolator dilate(Interpolator interpolator, Interpolator dilation) {
        return new DilateInterpolator(interpolator, dilation);
    }
}
