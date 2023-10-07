package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

public final class ae extends ac {

    /* renamed from: a  reason: collision with root package name */
    private static final PointF f7739a = new PointF();

    /* renamed from: b  reason: collision with root package name */
    private final a f7740b;

    /* renamed from: c  reason: collision with root package name */
    private PointF f7741c;

    /* renamed from: d  reason: collision with root package name */
    private PointF f7742d;

    /* renamed from: n  reason: collision with root package name */
    private PointF f7743n = new PointF();

    /* renamed from: o  reason: collision with root package name */
    private PointF f7744o = new PointF();

    public interface a {
        boolean a(ae aeVar);

        boolean b(ae aeVar);

        void c(ae aeVar);
    }

    public ae(Context context, a aVar) {
        super(context);
        this.f7740b = aVar;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, MotionEvent motionEvent) {
        if (i2 != 1) {
            if (i2 == 2) {
                a(motionEvent);
                if (this.f7727i / this.f7728j > 0.67f && motionEvent.getPointerCount() <= 1 && this.f7740b.a(this)) {
                    this.f7725g.recycle();
                    this.f7725g = MotionEvent.obtain(motionEvent);
                    return;
                }
                return;
            } else if (i2 != 3) {
                return;
            }
        }
        this.f7740b.c(this);
        a();
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, MotionEvent motionEvent, int i3, int i4) {
        if (i2 == 0) {
            a();
            this.f7725g = MotionEvent.obtain(motionEvent);
            this.f7729k = 0;
        } else if (i2 == 2) {
            this.f7724f = this.f7740b.b(this);
            return;
        } else if (i2 == 5) {
            if (this.f7725g != null) {
                this.f7725g.recycle();
            }
            this.f7725g = MotionEvent.obtain(motionEvent);
        } else {
            return;
        }
        a(motionEvent);
    }

    /* access modifiers changed from: protected */
    public final void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.f7725g;
        this.f7741c = b(motionEvent);
        this.f7742d = b(motionEvent2);
        boolean z2 = this.f7725g.getPointerCount() != motionEvent.getPointerCount();
        this.f7744o = z2 ? f7739a : new PointF(this.f7741c.x - this.f7742d.x, this.f7741c.y - this.f7742d.y);
        if (z2) {
            this.f7725g.recycle();
            this.f7725g = MotionEvent.obtain(motionEvent);
        }
        this.f7743n.x += this.f7744o.x;
        this.f7743n.y += this.f7744o.y;
    }

    public final PointF d() {
        return this.f7744o;
    }
}
