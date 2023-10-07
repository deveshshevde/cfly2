package com.scwang.smartrefresh.layout.internal;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import com.blankj.utilcode.constant.CacheConstants;

public class c extends b implements ValueAnimator.AnimatorUpdateListener, Animatable {

    /* renamed from: b  reason: collision with root package name */
    protected int f12195b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int f12196c = 0;

    /* renamed from: d  reason: collision with root package name */
    protected int f12197d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected ValueAnimator f12198e;

    /* renamed from: f  reason: collision with root package name */
    protected Path f12199f = new Path();

    public c() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{30, CacheConstants.HOUR});
        this.f12198e = ofInt;
        ofInt.setDuration(10000);
        this.f12198e.setInterpolator((TimeInterpolator) null);
        this.f12198e.setRepeatCount(-1);
        this.f12198e.setRepeatMode(1);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        float f2 = (float) width;
        float max = Math.max(1.0f, f2 / 22.0f);
        if (!(this.f12195b == width && this.f12196c == height)) {
            this.f12199f.reset();
            float f3 = f2 - max;
            float f4 = ((float) height) / 2.0f;
            this.f12199f.addCircle(f3, f4, max, Path.Direction.CW);
            float f5 = f2 - (5.0f * max);
            this.f12199f.addRect(f5, f4 - max, f3, f4 + max, Path.Direction.CW);
            this.f12199f.addCircle(f5, f4, max, Path.Direction.CW);
            this.f12195b = width;
            this.f12196c = height;
        }
        canvas.save();
        float f6 = f2 / 2.0f;
        float f7 = ((float) height) / 2.0f;
        canvas.rotate((float) this.f12197d, f6, f7);
        for (int i2 = 0; i2 < 12; i2++) {
            this.f12194a.setAlpha((i2 + 5) * 17);
            canvas.rotate(30.0f, f6, f7);
            canvas.drawPath(this.f12199f, this.f12194a);
        }
        canvas.restore();
    }

    public boolean isRunning() {
        return this.f12198e.isRunning();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f12197d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    public void start() {
        if (!this.f12198e.isRunning()) {
            this.f12198e.addUpdateListener(this);
            this.f12198e.start();
        }
    }

    public void stop() {
        if (this.f12198e.isRunning()) {
            this.f12198e.removeAllListeners();
            this.f12198e.removeAllUpdateListeners();
            this.f12198e.cancel();
        }
    }
}
