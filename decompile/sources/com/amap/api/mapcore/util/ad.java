package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

public final class ad extends ab {

    /* renamed from: n  reason: collision with root package name */
    private static final PointF f7732n = new PointF();

    /* renamed from: o  reason: collision with root package name */
    private final a f7733o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f7734p;

    /* renamed from: q  reason: collision with root package name */
    private PointF f7735q;

    /* renamed from: r  reason: collision with root package name */
    private PointF f7736r;

    /* renamed from: s  reason: collision with root package name */
    private PointF f7737s = new PointF();

    /* renamed from: t  reason: collision with root package name */
    private PointF f7738t = new PointF();

    public interface a {
        boolean a(ad adVar);

        boolean b(ad adVar);

        void c(ad adVar);
    }

    public ad(Context context, a aVar) {
        super(context);
        this.f7733o = aVar;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        super.a();
        this.f7734p = false;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, MotionEvent motionEvent) {
        if (i2 == 2) {
            a(motionEvent);
            if (this.f7727i / this.f7728j > 0.67f && this.f7733o.a(this)) {
                this.f7725g.recycle();
                this.f7725g = MotionEvent.obtain(motionEvent);
            }
        } else if (i2 == 3) {
            if (!this.f7734p) {
                this.f7733o.c(this);
            }
            a();
        } else if (i2 == 6) {
            a(motionEvent);
            if (!this.f7734p) {
                this.f7733o.c(this);
            }
            a();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, MotionEvent motionEvent, int i3, int i4) {
        if (i2 != 2) {
            if (i2 == 5) {
                a();
                this.f7725g = MotionEvent.obtain(motionEvent);
                this.f7729k = 0;
                a(motionEvent);
                boolean a2 = a(motionEvent, i3, i4);
                this.f7734p = a2;
                if (!a2) {
                    this.f7724f = this.f7733o.b(this);
                }
            }
        } else if (this.f7734p) {
            boolean a3 = a(motionEvent, i3, i4);
            this.f7734p = a3;
            if (!a3) {
                this.f7724f = this.f7733o.b(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.f7725g;
        this.f7735q = b(motionEvent);
        this.f7736r = b(motionEvent2);
        this.f7738t = this.f7725g.getPointerCount() != motionEvent.getPointerCount() ? f7732n : new PointF(this.f7735q.x - this.f7736r.x, this.f7735q.y - this.f7736r.y);
        this.f7737s.x += this.f7738t.x;
        this.f7737s.y += this.f7738t.y;
    }

    public final PointF d() {
        return this.f7738t;
    }
}
