package com.transitionseverywhere;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;

public class PatternPathMotion extends PathMotion {

    /* renamed from: b  reason: collision with root package name */
    private Path f21833b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f21834c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f21835d;

    public PatternPathMotion() {
        Path path = new Path();
        this.f21834c = path;
        this.f21835d = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.f21833b = path;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.f21834c = new Path();
        this.f21835d = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PatternPathMotion);
        try {
            String string = obtainStyledAttributes.getString(R.styleable.PatternPathMotion_patternPathData);
            if (string != null) {
                a(b.a(string));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public Path a(float f2, float f3, float f4, float f5) {
        double d2 = (double) (f4 - f2);
        double d3 = (double) (f5 - f3);
        float hypot = (float) Math.hypot(d2, d3);
        double atan2 = Math.atan2(d3, d2);
        this.f21835d.setScale(hypot, hypot);
        this.f21835d.postRotate((float) Math.toDegrees(atan2));
        this.f21835d.postTranslate(f2, f3);
        Path path = new Path();
        this.f21834c.transform(this.f21835d, path);
        return path;
    }

    public void a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, (float[]) null);
        float f2 = fArr[0];
        float f3 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, (float[]) null);
        float f4 = fArr[0];
        float f5 = fArr[1];
        if (f4 == f2 && f5 == f3) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f21835d.setTranslate(-f4, -f5);
        double d2 = (double) (f2 - f4);
        double d3 = (double) (f3 - f5);
        float hypot = 1.0f / ((float) Math.hypot(d2, d3));
        this.f21835d.postScale(hypot, hypot);
        this.f21835d.postRotate((float) Math.toDegrees(-Math.atan2(d3, d2)));
        if (path != null) {
            path.transform(this.f21835d, this.f21834c);
        }
        this.f21833b = path;
    }
}
