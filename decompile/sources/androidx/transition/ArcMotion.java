package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import l.g;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {

    /* renamed from: a  reason: collision with root package name */
    private static final float f4606a = ((float) Math.tan(Math.toRadians(35.0d)));

    /* renamed from: b  reason: collision with root package name */
    private float f4607b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f4608c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f4609d = 70.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f4610e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f4611f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f4612g = f4606a;

    public ArcMotion() {
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f4871j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        b(g.a(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        a(g.a(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        c(g.a(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }

    private static float d(float f2) {
        if (f2 >= 0.0f && f2 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f2 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public Path a(float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        Path path = new Path();
        path.moveTo(f2, f3);
        float f11 = f4 - f2;
        float f12 = f5 - f3;
        float f13 = (f11 * f11) + (f12 * f12);
        float f14 = (f2 + f4) / 2.0f;
        float f15 = (f3 + f5) / 2.0f;
        float f16 = 0.25f * f13;
        boolean z2 = f3 > f5;
        if (Math.abs(f11) < Math.abs(f12)) {
            float abs = Math.abs(f13 / (f12 * 2.0f));
            if (z2) {
                f8 = abs + f5;
                f7 = f4;
            } else {
                f8 = abs + f3;
                f7 = f2;
            }
            f6 = this.f4611f;
        } else {
            float f17 = f13 / (f11 * 2.0f);
            if (z2) {
                f10 = f3;
                f9 = f17 + f2;
            } else {
                f9 = f4 - f17;
                f10 = f5;
            }
            f6 = this.f4610e;
        }
        float f18 = f16 * f6 * f6;
        float f19 = f14 - f7;
        float f20 = f15 - f8;
        float f21 = (f19 * f19) + (f20 * f20);
        float f22 = this.f4612g;
        float f23 = f16 * f22 * f22;
        if (f21 >= f18) {
            f18 = f21 > f23 ? f23 : 0.0f;
        }
        if (f18 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f18 / f21));
            f7 = ((f7 - f14) * sqrt) + f14;
            f8 = f15 + (sqrt * (f8 - f15));
        }
        path.cubicTo((f2 + f7) / 2.0f, (f3 + f8) / 2.0f, (f7 + f4) / 2.0f, (f8 + f5) / 2.0f, f4, f5);
        return path;
    }

    public void a(float f2) {
        this.f4607b = f2;
        this.f4610e = d(f2);
    }

    public void b(float f2) {
        this.f4608c = f2;
        this.f4611f = d(f2);
    }

    public void c(float f2) {
        this.f4609d = f2;
        this.f4612g = d(f2);
    }
}
