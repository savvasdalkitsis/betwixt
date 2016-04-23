package com.savvasdalkitsis.betwixt;

import android.graphics.Path;
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

    public static Interpolator linear() {
        return new LinearInterpolator();
    }

    public static Interpolator accelerate() {
        return new AccelerateInterpolator();
    }

    public static Interpolator accelerate(float factor) {
        return new AccelerateInterpolator(factor);
    }

    public static Interpolator accelerateDecelerate() {
        return new AccelerateDecelerateInterpolator();
    }

    public static Interpolator anticipate() {
        return new AnticipateInterpolator();
    }

    public static Interpolator anticipate(float tension) {
        return new AnticipateInterpolator(tension);
    }

    public static Interpolator bounce() {
        return new BounceInterpolator();
    }

    public static Interpolator cycle(int cycles) {
        return new CycleInterpolator(cycles);
    }

    public static Interpolator decelerate() {
        return new DecelerateInterpolator();
    }

    public static Interpolator decelerate(int factor) {
        return new DecelerateInterpolator(factor);
    }

    public static Interpolator overshoot() {
        return new OvershootInterpolator();
    }

    public static Interpolator overshoot(int tension) {
        return new OvershootInterpolator(tension);
    }

    public static Interpolator anticipateOvershoot() {
        return new AnticipateOvershootInterpolator();
    }

    public static Interpolator anticipateOvershoot(int tension) {
        return new AnticipateOvershootInterpolator(tension);
    }

    public static Interpolator anticipateOvershoot(int tension, int extraTension) {
        return new AnticipateOvershootInterpolator(tension, extraTension);
    }

    public static Interpolator path(Path path) {
        return PathInterpolatorCompat.create(path);
    }

    public static Interpolator path(int controlX, int controlY) {
        return PathInterpolatorCompat.create(controlX, controlY);
    }

    public static Interpolator path(int controlX1, int controlY1, int controlX2, int controlY2) {
        return PathInterpolatorCompat.create(controlX1, controlY1, controlX2, controlY2);
    }

    public static Interpolator fastOutLinearIn() {
        return new FastOutLinearInInterpolator();
    }

    public static Interpolator fastOutSlowIn() {
        return new FastOutSlowInInterpolator();
    }

    public static Interpolator linearOutSlowIn() {
        return new LinearOutSlowInInterpolator();
    }

    /* Library interpolators */

    public static Interpolator reverse(Interpolator interpolator) {
        return new ReverseInterpolator(interpolator);
    }

    public static Interpolator flip(Interpolator interpolator) {
        return new FlipInterpolator(interpolator);
    }

    public static Interpolator join(Interpolator... interpolators) {
        return new JoinInterpolator(interpolators);
    }

    public static Interpolator join(int times, Interpolator interpolator) {
        Interpolator[] interpolators = new Interpolator[times];
        Arrays.fill(interpolators, interpolator);
        return  join(interpolators);
    }

    public static Interpolator pingPong(Interpolator interpolator) {
        return join(interpolator, reverse(interpolator));
    }

    public static Interpolator constant() {
        return constant(0);
    }

    public static Interpolator constant(float value) {
        return new ConstantInterpolator(value);
    }

    public static Interpolator multiply(Interpolator first, Interpolator second) {
        return new MultiplyInterpolator(first, second);
    }

    public static Interpolator multiply(Interpolator interpolator, float multiplier) {
        return multiply(interpolator, constant(multiplier));
    }

    public static Interpolator divide(Interpolator dividend, Interpolator divisor) {
        return new DivideInterpolator(dividend, divisor);
    }

    public static Interpolator divide(Interpolator dividend, float divisor) {
        return divide(dividend, constant(divisor));
    }

    public static Interpolator rasterize(Interpolator interpolator) {
        return rasterize(255, interpolator);
    }

    public static Interpolator rasterize(int rasterSize, Interpolator interpolator) {
        return new RasterizeInterpolator(rasterSize, interpolator);
    }

    public static Interpolator step() {
        return step(0, 1);
    }

    public static Interpolator step(int first, int second) {
        return join(constant(first), constant(second));
    }

    public static Interpolator clip(Interpolator interpolator, float start, float end) {
        return new ClipInterpolator(interpolator, start, end);
    }

    public static Interpolator dilate(Interpolator interpolator, Interpolator dilation) {
        return new DilateInterpolator(interpolator, dilation);
    }
}
