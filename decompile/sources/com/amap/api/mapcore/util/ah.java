package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

public final class ah extends ab {

    /* renamed from: p  reason: collision with root package name */
    private static final PointF f7771p = new PointF();

    /* renamed from: n  reason: collision with root package name */
    private final a f7772n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f7773o;

    /* renamed from: q  reason: collision with root package name */
    private PointF f7774q;

    /* renamed from: r  reason: collision with root package name */
    private PointF f7775r;

    /* renamed from: s  reason: collision with root package name */
    private PointF f7776s = new PointF();

    /* renamed from: t  reason: collision with root package name */
    private PointF f7777t = new PointF();

    public interface a {
        void a(ah ahVar);
    }

    public static class b implements a {
        public void a(ah ahVar) {
        }
    }

    public ah(Context context, a aVar) {
        super(context);
        this.f7772n = aVar;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        super.a();
        this.f7773o = false;
        this.f7776s.x = 0.0f;
        this.f7777t.x = 0.0f;
        this.f7776s.y = 0.0f;
        this.f7777t.y = 0.0f;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, MotionEvent motionEvent) {
        if (i2 == 3) {
            a();
        } else if (i2 == 6) {
            a(motionEvent);
            if (!this.f7773o) {
                this.f7772n.a(this);
            }
            a();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, MotionEvent motionEvent, int i3, int i4) {
        if (i2 == 5) {
            a();
            this.f7725g = MotionEvent.obtain(motionEvent);
            this.f7729k = 0;
            a(motionEvent);
            boolean a2 = a(motionEvent, i3, i4);
            this.f7773o = a2;
            if (!a2) {
                this.f7724f = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.f7725g;
        this.f7774q = b(motionEvent);
        this.f7775r = b(motionEvent2);
        this.f7777t = this.f7725g.getPointerCount() != motionEvent.getPointerCount() ? f7771p : new PointF(this.f7774q.x - this.f7775r.x, this.f7774q.y - this.f7775r.y);
        this.f7776s.x += this.f7777t.x;
        this.f7776s.y += this.f7777t.y;
    }

    public final float d() {
        return this.f7776s.x;
    }

    public final float e() {
        return this.f7776s.y;
    }
}
