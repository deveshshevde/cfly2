package com.transitionseverywhere.utils;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;

public class e extends b {

    /* renamed from: a  reason: collision with root package name */
    private PathMeasure f21956a;

    /* renamed from: b  reason: collision with root package name */
    private float f21957b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f21958c = new float[2];

    private e(Object obj, g gVar) {
        super(obj, gVar);
    }

    public static <T> e a(T t2, g<T> gVar, Path path) {
        if (t2 == null || gVar == null || path == null) {
            return null;
        }
        e eVar = new e(t2, gVar);
        PathMeasure pathMeasure = new PathMeasure(path, false);
        eVar.f21956a = pathMeasure;
        eVar.f21957b = pathMeasure.getLength();
        return eVar;
    }

    /* access modifiers changed from: protected */
    public void a(PointF pointF, float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.f21956a.getPosTan(f2 * this.f21957b, this.f21958c, (float[]) null);
        float[] fArr = this.f21958c;
        pointF.set(fArr[0], fArr[1]);
    }
}
