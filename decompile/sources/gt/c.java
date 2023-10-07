package gt;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;

public class c {
    public static int a(Context context, TypedArray typedArray, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i2, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i2, i3);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i3);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    static int a(TypedArray typedArray, int i2, int i3) {
        return typedArray.hasValue(i2) ? i2 : i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r0 = r2.getColor(r3, -1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList a(android.content.Context r1, android.content.res.TypedArray r2, int r3) {
        /*
            boolean r0 = r2.hasValue(r3)
            if (r0 == 0) goto L_0x0014
            r0 = 0
            int r0 = r2.getResourceId(r3, r0)
            if (r0 == 0) goto L_0x0014
            android.content.res.ColorStateList r1 = c.a.a(r1, r0)
            if (r1 == 0) goto L_0x0014
            return r1
        L_0x0014:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 15
            if (r1 > r0) goto L_0x0026
            r1 = -1
            int r0 = r2.getColor(r3, r1)
            if (r0 == r1) goto L_0x0026
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r0)
            return r1
        L_0x0026:
            android.content.res.ColorStateList r1 = r2.getColorStateList(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: gt.c.a(android.content.Context, android.content.res.TypedArray, int):android.content.res.ColorStateList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r0 = r2.b(r3, -1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList a(android.content.Context r1, androidx.appcompat.widget.af r2, int r3) {
        /*
            boolean r0 = r2.g(r3)
            if (r0 == 0) goto L_0x0014
            r0 = 0
            int r0 = r2.g(r3, r0)
            if (r0 == 0) goto L_0x0014
            android.content.res.ColorStateList r1 = c.a.a(r1, r0)
            if (r1 == 0) goto L_0x0014
            return r1
        L_0x0014:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 15
            if (r1 > r0) goto L_0x0026
            r1 = -1
            int r0 = r2.b((int) r3, (int) r1)
            if (r0 == r1) goto L_0x0026
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r0)
            return r1
        L_0x0026:
            android.content.res.ColorStateList r1 = r2.e(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: gt.c.a(android.content.Context, androidx.appcompat.widget.af, int):android.content.res.ColorStateList");
    }

    public static boolean a(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = c.a.b(r1, (r0 = r2.getResourceId(r3, 0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable b(android.content.Context r1, android.content.res.TypedArray r2, int r3) {
        /*
            boolean r0 = r2.hasValue(r3)
            if (r0 == 0) goto L_0x0014
            r0 = 0
            int r0 = r2.getResourceId(r3, r0)
            if (r0 == 0) goto L_0x0014
            android.graphics.drawable.Drawable r1 = c.a.b(r1, r0)
            if (r1 == 0) goto L_0x0014
            return r1
        L_0x0014:
            android.graphics.drawable.Drawable r1 = r2.getDrawable(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: gt.c.b(android.content.Context, android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    public static boolean b(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    public static d c(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }
}
