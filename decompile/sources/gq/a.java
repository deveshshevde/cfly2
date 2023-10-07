package gq;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.R;
import gt.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f28562a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28563b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28564c;

    /* renamed from: d  reason: collision with root package name */
    private final float f28565d;

    public a(Context context) {
        this.f28562a = b.a(context, R.attr.elevationOverlayEnabled, false);
        this.f28563b = gn.a.a(context, R.attr.elevationOverlayColor, 0);
        this.f28564c = gn.a.a(context, R.attr.colorSurface, 0);
        this.f28565d = context.getResources().getDisplayMetrics().density;
    }

    private boolean a(int i2) {
        return m.a.b(i2, 255) == this.f28564c;
    }

    public int a(float f2) {
        return a(this.f28564c, f2);
    }

    public int a(int i2, float f2) {
        return (!this.f28562a || !a(i2)) ? i2 : b(i2, f2);
    }

    public boolean a() {
        return this.f28562a;
    }

    public float b(float f2) {
        float f3 = this.f28565d;
        if (f3 <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p((double) (f2 / f3))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i2, float f2) {
        float b2 = b(f2);
        return m.a.b(gn.a.a(m.a.b(i2, 255), this.f28563b, b2), Color.alpha(i2));
    }
}
