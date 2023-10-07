package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.view.MotionEvent;

public abstract class ac {

    /* renamed from: e  reason: collision with root package name */
    protected final Context f7723e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f7724f;

    /* renamed from: g  reason: collision with root package name */
    protected MotionEvent f7725g;

    /* renamed from: h  reason: collision with root package name */
    protected MotionEvent f7726h;

    /* renamed from: i  reason: collision with root package name */
    protected float f7727i;

    /* renamed from: j  reason: collision with root package name */
    protected float f7728j;

    /* renamed from: k  reason: collision with root package name */
    protected long f7729k;

    /* renamed from: l  reason: collision with root package name */
    protected int f7730l = 0;

    /* renamed from: m  reason: collision with root package name */
    protected int f7731m = 0;

    public ac(Context context) {
        this.f7723e = context;
    }

    public static PointF b(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            f2 += motionEvent.getX(i2);
            f3 += motionEvent.getY(i2);
        }
        float f4 = (float) pointerCount;
        return new PointF(f2 / f4, f3 / f4);
    }

    /* access modifiers changed from: protected */
    public void a() {
        MotionEvent motionEvent = this.f7725g;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f7725g = null;
        }
        MotionEvent motionEvent2 = this.f7726h;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f7726h = null;
        }
        this.f7724f = false;
    }

    public final void a(int i2, int i3) {
        this.f7730l = i2;
        this.f7731m = i3;
    }

    /* access modifiers changed from: protected */
    public abstract void a(int i2, MotionEvent motionEvent);

    /* access modifiers changed from: protected */
    public abstract void a(int i2, MotionEvent motionEvent, int i3, int i4);

    /* access modifiers changed from: protected */
    public void a(MotionEvent motionEvent) {
        float pressure;
        MotionEvent motionEvent2 = this.f7725g;
        MotionEvent motionEvent3 = this.f7726h;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
            this.f7726h = null;
        }
        this.f7726h = MotionEvent.obtain(motionEvent);
        this.f7729k = motionEvent.getEventTime() - motionEvent2.getEventTime();
        if (Build.VERSION.SDK_INT >= 8) {
            this.f7727i = motionEvent.getPressure(motionEvent.getActionIndex());
            pressure = motionEvent2.getPressure(motionEvent2.getActionIndex());
        } else {
            this.f7727i = motionEvent.getPressure(0);
            pressure = motionEvent2.getPressure(0);
        }
        this.f7728j = pressure;
    }

    public final long b() {
        return this.f7729k;
    }

    public final boolean b(MotionEvent motionEvent, int i2, int i3) {
        int action = motionEvent.getAction() & 255;
        if (!this.f7724f) {
            a(action, motionEvent, i2, i3);
            return true;
        }
        a(action, motionEvent);
        return true;
    }

    public final MotionEvent c() {
        return this.f7726h;
    }
}
