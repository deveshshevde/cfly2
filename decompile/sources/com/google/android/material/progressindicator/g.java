package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.material.progressindicator.b;

abstract class g<S extends b> {

    /* renamed from: a  reason: collision with root package name */
    S f19492a;

    /* renamed from: b  reason: collision with root package name */
    protected f f19493b;

    public g(S s2) {
        this.f19492a = s2;
    }

    /* access modifiers changed from: package-private */
    public abstract int a();

    /* access modifiers changed from: package-private */
    public abstract void a(Canvas canvas, float f2);

    /* access modifiers changed from: package-private */
    public abstract void a(Canvas canvas, Paint paint);

    /* access modifiers changed from: package-private */
    public abstract void a(Canvas canvas, Paint paint, float f2, float f3, int i2);

    /* access modifiers changed from: protected */
    public void a(f fVar) {
        this.f19493b = fVar;
    }

    /* access modifiers changed from: package-private */
    public abstract int b();

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, float f2) {
        this.f19492a.c();
        a(canvas, f2);
    }
}
