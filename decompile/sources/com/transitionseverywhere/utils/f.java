package com.transitionseverywhere.utils;

import android.graphics.PointF;

public class f extends b {

    /* renamed from: a  reason: collision with root package name */
    private float f21959a;

    /* renamed from: b  reason: collision with root package name */
    private float f21960b;

    /* renamed from: c  reason: collision with root package name */
    private float f21961c;

    /* renamed from: d  reason: collision with root package name */
    private float f21962d;

    protected f(Object obj, g gVar) {
        super(obj, gVar);
    }

    protected static float a(float f2, float f3, float f4) {
        return f3 + ((f4 - f3) * f2);
    }

    public static <T> f a(T t2, g<T> gVar, float f2, float f3, float f4, float f5) {
        if (t2 == null || gVar == null) {
            return null;
        }
        f fVar = new f(t2, gVar);
        fVar.f21960b = f2;
        fVar.f21959a = f3;
        fVar.f21962d = f4;
        fVar.f21961c = f5;
        return fVar;
    }

    /* access modifiers changed from: protected */
    public void a(PointF pointF, float f2) {
        pointF.x = a(f2, this.f21960b, this.f21962d);
        pointF.y = a(f2, this.f21959a, this.f21961c);
    }
}
