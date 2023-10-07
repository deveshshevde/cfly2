package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R;
import m.a;

public class aa {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f1386a = {-16842910};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f1387b = {16842908};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f1388c = {16843518};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f1389d = {16842919};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f1390e = {16842912};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f1391f = {16842913};

    /* renamed from: g  reason: collision with root package name */
    static final int[] f1392g = {-16842919, -16842908};

    /* renamed from: h  reason: collision with root package name */
    static final int[] f1393h = new int[0];

    /* renamed from: i  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f1394i = new ThreadLocal<>();

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f1395j = new int[1];

    public static int a(Context context, int i2) {
        int[] iArr = f1395j;
        iArr[0] = i2;
        af a2 = af.a(context, (AttributeSet) null, iArr);
        try {
            return a2.b(0, 0);
        } finally {
            a2.b();
        }
    }

    static int a(Context context, int i2, float f2) {
        int a2 = a(context, i2);
        return a.b(a2, Math.round(((float) Color.alpha(a2)) * f2));
    }

    private static TypedValue a() {
        ThreadLocal<TypedValue> threadLocal = f1394i;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList b(Context context, int i2) {
        int[] iArr = f1395j;
        iArr[0] = i2;
        af a2 = af.a(context, (AttributeSet) null, iArr);
        try {
            return a2.e(0);
        } finally {
            a2.b();
        }
    }

    public static int c(Context context, int i2) {
        ColorStateList b2 = b(context, i2);
        if (b2 != null && b2.isStateful()) {
            return b2.getColorForState(f1386a, b2.getDefaultColor());
        }
        TypedValue a2 = a();
        context.getTheme().resolveAttribute(16842803, a2, true);
        return a(context, i2, a2.getFloat());
    }
}
