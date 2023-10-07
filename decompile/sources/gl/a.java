package gl;

import aa.b;
import aa.c;
import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f28535a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f28536b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f28537c = new aa.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f28538d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f28539e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static float a(float f2, float f3, float f4, float f5, float f6) {
        return f6 < f4 ? f2 : f6 > f5 ? f3 : a(f2, f3, (f6 - f4) / (f5 - f4));
    }

    public static int a(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * ((float) (i3 - i2)));
    }
}
