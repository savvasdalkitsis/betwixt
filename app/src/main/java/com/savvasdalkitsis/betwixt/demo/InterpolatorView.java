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

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.graphics.ColorUtils;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;

import static com.savvasdalkitsis.betwixt.Interpolators.*;

public class InterpolatorView extends View {

    private static final int STEPS = 128;
    private final Paint dim = new Paint();
    private final Paint linePaint = new Paint();
    private final TextPaint textPaint = new TextPaint();
    private Interpolator interpolator = linear();
    private Paint paint;
    private Paint rectPaint;
    private final Paint circlePaint = new Paint();
    private float progress;
    private float radius;
    private int animationInset;
    private boolean animating;
    private final Path linePath = new Path();
    private final ValueAnimator playAnimator = ValueAnimator.ofFloat(0, 1);
    private String description;
    private int textHeight;
    private int textPaddingLeft;

    public InterpolatorView(Context context) {
        super(context);
        init();
    }

    public InterpolatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InterpolatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(getResources().getDimensionPixelSize(R.dimen.interpolation_width));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        linePaint.setColor(Color.WHITE);
        linePaint.setStrokeWidth(getResources().getDimensionPixelSize(R.dimen.interpolation_width));
        float dashSize = getResources().getDimensionPixelSize(R.dimen.dash_size);
        linePaint.setPathEffect(new DashPathEffect(new float[]{dashSize, dashSize}, 0));
        linePaint.setStyle(Paint.Style.STROKE);
        rectPaint = new Paint();
        rectPaint.setARGB(255, 255, 200, 200);
        radius = getResources().getDimensionPixelSize(R.dimen.circle_radius);
        animationInset = getResources().getDimensionPixelSize(R.dimen.play_inset);
        circlePaint.setColor(Color.RED);
        circlePaint.setAntiAlias(true);
        textPaint.setColor(Color.BLACK);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(getResources().getDimensionPixelSize(R.dimen.interpolator_description_size));
        textPaddingLeft = getResources().getDimensionPixelSize(R.dimen.text_padding_left);
        dim.setColor(ColorUtils.setAlphaComponent(Color.BLACK, 200));
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
        playAnimator.setStartDelay(500);
        playAnimator.setDuration(1000);
        playAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progress = animation.getAnimatedFraction();
                postInvalidate();
            }
        });
        playAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                endAnimation();
            }

            @Override
            public void onAnimationEnd(final Animator animation) {
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        endAnimation();
                    }
                }, 500);
            }
        });
    }

    private void endAnimation() {
        animating = false;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        int inset = (getHeight() - rectHeight()) / 2;
        canvas.drawRect(getPaddingLeft(), getPaddingTop() + inset,
                getWidth() - getPaddingRight(),
                getHeight() - inset - getPaddingBottom(), rectPaint);
        float x = 0;
        float y = 0;
        for (int i = 0; i < STEPS; i++) {
            float newX = i / (float) STEPS;
            float newY = interpolator.getInterpolation(newX);
            if (i == 0) {
                x = newX;
                y = newY;
            }
            canvas.drawLine(x(x), y(y), x(newX), y(newY), paint);
            x = newX;
            y = newY;
        }
        canvas.drawText(description, getPaddingLeft() + textPaddingLeft, getHeight() - textHeight, textPaint);
        if (animating) {
            canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(),
                    getHeight() - getPaddingBottom(), dim);
            int areaWidth = getWidth() - getPaddingLeft() - getPaddingRight() - animationInset * 2;
            float circleX = getPaddingLeft() + animationInset + areaWidth * progress;
            linePath.reset();
            linePath.moveTo(getPaddingLeft() + animationInset , getPaddingTop());
            linePath.lineTo(getPaddingLeft() + animationInset , getHeight() - getPaddingBottom());
            linePath.moveTo(getWidth() - getPaddingRight() - animationInset , getPaddingTop());
            linePath.lineTo(getWidth() - getPaddingRight() - animationInset , getHeight() - getPaddingBottom());
            canvas.drawPath(linePath, linePaint);
            canvas.drawCircle(circleX, getHeight() / 2, radius, circlePaint);
        }
    }

    private float y(float y) {
        return getPaddingTop() + rectHeight() - (y * rectHeight()) + ((getHeight() - rectHeight()) / 2);
    }

    private int rectHeight() {
        return (int) (getHeight() * 0.75);
    }

    private float x(float x) {
        return getPaddingLeft() + x * (getWidth() - getPaddingLeft() - getPaddingRight());
    }

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        playAnimator.cancel();
    }

    public void setDescription(String description) {
        this.description = description;
        StaticLayout textLayout = new StaticLayout(description, textPaint, Integer.MAX_VALUE, Layout.Alignment.ALIGN_CENTER, 0, 0, false);
        textHeight = textLayout.getHeight();
    }

    public void play() {
        if (animating) {
            return;
        }
        progress = 0;
        animating = true;
        invalidate();
        playAnimator.setInterpolator(interpolator);
        playAnimator.cancel();
        playAnimator.start();
    }
}
