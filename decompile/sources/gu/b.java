package gu;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import m.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f28598a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b  reason: collision with root package name */
    static final String f28599b = b.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f28600c = {16842919};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f28601d = {16843623, 16842908};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f28602e = {16842908};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f28603f = {16843623};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f28604g = {16842913, 16842919};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f28605h = {16842913, 16843623, 16842908};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f28606i = {16842913, 16842908};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f28607j = {16842913, 16843623};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f28608k = {16842913};

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f28609l = {16842910, 16842919};

    private b() {
    }

    private static int a(int i2) {
        return a.b(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    private static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f28598a ? a(colorForState) : colorForState;
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f28598a) {
            return new ColorStateList(new int[][]{f28608k, StateSet.NOTHING}, new int[]{a(colorStateList, f28604g), a(colorStateList, f28600c)});
        }
        int[] iArr = f28604g;
        int[] iArr2 = f28605h;
        int[] iArr3 = f28606i;
        int[] iArr4 = f28607j;
        int[] iArr5 = f28600c;
        int[] iArr6 = f28601d;
        int[] iArr7 = f28602e;
        int[] iArr8 = f28603f;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f28608k, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{a(colorStateList, iArr), a(colorStateList, iArr2), a(colorStateList, iArr3), a(colorStateList, iArr4), 0, a(colorStateList, iArr5), a(colorStateList, iArr6), a(colorStateList, iArr7), a(colorStateList, iArr8), 0});
    }

    public static boolean a(int[] iArr) {
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z2 = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z3 = true;
            }
        }
        return z2 && z3;
    }

    public static ColorStateList b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f28609l, 0)) != 0) {
            Log.w(f28599b, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }
}
