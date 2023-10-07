package gn;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import gt.b;

public class a {
    public static int a(int i2, int i3) {
        return m.a.a(i3, i2);
    }

    public static int a(int i2, int i3, float f2) {
        return a(i2, m.a.b(i3, Math.round(((float) Color.alpha(i3)) * f2)));
    }

    public static int a(Context context, int i2, int i3) {
        TypedValue a2 = b.a(context, i2);
        return a2 != null ? a2.data : i3;
    }

    public static int a(Context context, int i2, String str) {
        return b.a(context, i2, str);
    }

    public static int a(View view, int i2) {
        return b.a(view, i2);
    }

    public static int a(View view, int i2, int i3) {
        return a(view.getContext(), i2, i3);
    }

    public static int a(View view, int i2, int i3, float f2) {
        return a(a(view, i2), a(view, i3), f2);
    }

    public static boolean a(int i2) {
        return i2 != 0 && m.a.a(i2) > 0.5d;
    }

    public static int b(int i2, int i3) {
        return m.a.b(i2, (Color.alpha(i2) * i3) / 255);
    }
}
