package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public abstract class ab extends ac {

    /* renamed from: a  reason: collision with root package name */
    protected float f7710a;

    /* renamed from: b  reason: collision with root package name */
    protected float f7711b;

    /* renamed from: c  reason: collision with root package name */
    protected float f7712c;

    /* renamed from: d  reason: collision with root package name */
    protected float f7713d;

    /* renamed from: n  reason: collision with root package name */
    private final float f7714n;

    /* renamed from: o  reason: collision with root package name */
    private float f7715o;

    /* renamed from: p  reason: collision with root package name */
    private float f7716p;

    /* renamed from: q  reason: collision with root package name */
    private float f7717q;

    /* renamed from: r  reason: collision with root package name */
    private float f7718r;

    /* renamed from: s  reason: collision with root package name */
    private float f7719s = 0.0f;

    /* renamed from: t  reason: collision with root package name */
    private float f7720t = 0.0f;

    /* renamed from: u  reason: collision with root package name */
    private float f7721u = 0.0f;

    /* renamed from: v  reason: collision with root package name */
    private float f7722v = 0.0f;

    public ab(Context context) {
        super(context);
        this.f7714n = (float) ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    private static float a(MotionEvent motionEvent, int i2) {
        float x2 = (((float) i2) + motionEvent.getX()) - motionEvent.getRawX();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getX(1) + x2;
        }
        return 0.0f;
    }

    private static float b(MotionEvent motionEvent, int i2) {
        float y2 = (((float) i2) + motionEvent.getY()) - motionEvent.getRawY();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getY(1) + y2;
        }
        return 0.0f;
    }

    public final PointF a(int i2) {
        return i2 == 0 ? new PointF(this.f7719s, this.f7720t) : new PointF(this.f7721u, this.f7722v);
    }

    /* access modifiers changed from: protected */
    public void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.f7725g;
        int pointerCount = this.f7725g.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.f7717q = -1.0f;
            this.f7718r = -1.0f;
            float x2 = motionEvent2.getX(0);
            float y2 = motionEvent2.getY(0);
            float x3 = motionEvent2.getX(1);
            float y3 = motionEvent2.getY(1);
            this.f7710a = x3 - x2;
            this.f7711b = y3 - y2;
            float x4 = motionEvent.getX(0);
            float y4 = motionEvent.getY(0);
            float x5 = motionEvent.getX(1);
            float y5 = motionEvent.getY(1);
            this.f7712c = x5 - x4;
            this.f7713d = y5 - y4;
            this.f7719s = x4 - x2;
            this.f7720t = y4 - y2;
            this.f7721u = x5 - x3;
            this.f7722v = y5 - y3;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean a(MotionEvent motionEvent, int i2, int i3) {
        int i4;
        if (this.f7730l == 0 || this.f7731m == 0) {
            DisplayMetrics displayMetrics = this.f7723e.getResources().getDisplayMetrics();
            this.f7715o = ((float) displayMetrics.widthPixels) - this.f7714n;
            i4 = displayMetrics.heightPixels;
        } else {
            this.f7715o = ((float) this.f7730l) - this.f7714n;
            i4 = this.f7731m;
        }
        this.f7716p = ((float) i4) - this.f7714n;
        float f2 = this.f7714n;
        float f3 = this.f7715o;
        float f4 = this.f7716p;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float a2 = a(motionEvent, i2);
        float b2 = b(motionEvent, i3);
        boolean z2 = rawX < f2 || rawY < f2 || rawX > f3 || rawY > f4;
        boolean z3 = a2 < f2 || b2 < f2 || a2 > f3 || b2 > f4;
        return (z2 && z3) || z2 || z3;
    }
}
