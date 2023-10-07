package com.google.android.material.progressindicator;

import aj.b;
import android.animation.Animator;

abstract class h<T extends Animator> {

    /* renamed from: b  reason: collision with root package name */
    protected i f19494b;

    /* renamed from: c  reason: collision with root package name */
    protected final float[] f19495c;

    /* renamed from: d  reason: collision with root package name */
    protected final int[] f19496d;

    protected h(int i2) {
        this.f19495c = new float[(i2 * 2)];
        this.f19496d = new int[i2];
    }

    /* access modifiers changed from: protected */
    public float a(int i2, int i3, int i4) {
        return ((float) (i2 - i3)) / ((float) i4);
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    public abstract void a(b.a aVar);

    /* access modifiers changed from: protected */
    public void a(i iVar) {
        this.f19494b = iVar;
    }

    /* access modifiers changed from: package-private */
    public abstract void b();

    /* access modifiers changed from: package-private */
    public abstract void c();

    public abstract void d();

    public abstract void e();
}
