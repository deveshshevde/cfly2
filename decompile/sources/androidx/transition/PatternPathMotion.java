package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import l.g;
import m.c;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {

    /* renamed from: a  reason: collision with root package name */
    private Path f4695a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f4696b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f4697c;

    public PatternPathMotion() {
        Path path = new Path();
        this.f4696b = path;
        this.f4697c = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.f4695a = path;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.f4696b = new Path();
        this.f4697c = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f4872k);
        try {
            String a2 = g.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (a2 != null) {
                a(c.a(a2));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static float a(float f2, float f3) {
        return (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
    }

    public Path a(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float a2 = a(f6, f7);
        double atan2 = Math.atan2((double) f7, (double) f6);
        this.f4697c.setScale(a2, a2);
        this.f4697c.postRotate((float) Math.toDegrees(atan2));
        this.f4697c.postTranslate(f2, f3);
        Path path = new Path();
        this.f4696b.transform(this.f4697c, path);
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
        this.f4697c.setTranslate(-f4, -f5);
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        float a2 = 1.0f / a(f6, f7);
        this.f4697c.postScale(a2, a2);
        this.f4697c.postRotate((float) Math.toDegrees(-Math.atan2((double) f7, (double) f6)));
        path.transform(this.f4697c, this.f4696b);
        this.f4695a = path;
    }
}
