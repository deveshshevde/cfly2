package as;

import android.content.res.TypedArray;
import kotlin.jvm.internal.h;

public final class a {
    public static final int a(TypedArray typedArray, int i2, mm.a<Integer> aVar) {
        h.c(typedArray, "$this$color");
        h.c(aVar, "fallback");
        int color = typedArray.getColor(i2, 0);
        return color == 0 ? aVar.e_().intValue() : color;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001d, code lost:
        r1 = l.f.a(r2, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.Typeface a(android.content.res.TypedArray r1, android.content.Context r2, int r3, mm.a<? extends android.graphics.Typeface> r4) {
        /*
            java.lang.String r0 = "$this$font"
            kotlin.jvm.internal.h.c(r1, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.h.c(r2, r0)
            java.lang.String r0 = "fallback"
            kotlin.jvm.internal.h.c(r4, r0)
            r0 = 0
            int r1 = r1.getResourceId(r3, r0)
            if (r1 != 0) goto L_0x001d
        L_0x0016:
            java.lang.Object r1 = r4.e_()
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            goto L_0x0023
        L_0x001d:
            android.graphics.Typeface r1 = l.f.a((android.content.Context) r2, (int) r1)
            if (r1 == 0) goto L_0x0016
        L_0x0023:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: as.a.a(android.content.res.TypedArray, android.content.Context, int, mm.a):android.graphics.Typeface");
    }
}
