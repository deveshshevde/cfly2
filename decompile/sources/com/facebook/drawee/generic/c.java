package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.n;
import ds.b;

public class c {
    private static Drawable a(Context context, TypedArray typedArray, int i2) {
        int resourceId = typedArray.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    private static n.b a(TypedArray typedArray, int i2) {
        switch (typedArray.getInt(i2, -2)) {
            case -1:
                return null;
            case 0:
                return n.b.f11239a;
            case 1:
                return n.b.f11240b;
            case 2:
                return n.b.f11241c;
            case 3:
                return n.b.f11242d;
            case 4:
                return n.b.f11243e;
            case 5:
                return n.b.f11244f;
            case 6:
                return n.b.f11245g;
            case 7:
                return n.b.f11246h;
            case 8:
                return n.b.f11247i;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    private static RoundingParams a(b bVar) {
        if (bVar.r() == null) {
            bVar.a(new RoundingParams());
        }
        return bVar.r();
    }

    public static b a(Context context, AttributeSet attributeSet) {
        if (b.b()) {
            b.a("GenericDraweeHierarchyBuilder#inflateBuilder");
        }
        b a2 = a(new b(context.getResources()), context, attributeSet);
        if (b.b()) {
            b.a();
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01c9, code lost:
        if (r14 != false) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01e3, code lost:
        if (r5 != false) goto L_0x01e5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0201  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.drawee.generic.b a(com.facebook.drawee.generic.b r18, android.content.Context r19, android.util.AttributeSet r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            if (r2 == 0) goto L_0x020f
            int[] r6 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r2, r6)
            int r7 = r2.getIndexCount()     // Catch:{ all -> 0x01ef }
            r5 = 1
            r6 = 0
            r8 = 0
            r9 = 1
            r10 = 1
            r11 = 1
            r12 = 1
            r13 = 1
            r14 = 1
            r15 = 1
            r16 = 0
        L_0x001e:
            if (r8 >= r7) goto L_0x0199
            int r3 = r2.getIndex(r8)     // Catch:{ all -> 0x0196 }
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_actualImageScaleType     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x0031
            com.facebook.drawee.drawable.n$b r3 = a((android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.e((com.facebook.drawee.drawable.n.b) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x0031:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_placeholderImage     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x003e
            android.graphics.drawable.Drawable r3 = a((android.content.Context) r1, (android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.a((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x003e:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x004b
            android.graphics.drawable.Drawable r3 = a((android.content.Context) r1, (android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.g(r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x004b:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarImage     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x0058
            android.graphics.drawable.Drawable r3 = a((android.content.Context) r1, (android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.d((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x0058:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_fadeDuration     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x0065
            r4 = 0
            int r3 = r2.getInt(r3, r4)     // Catch:{ all -> 0x0196 }
            r0.a((int) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x0065:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_viewAspectRatio     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x0072
            r4 = 0
            float r3 = r2.getFloat(r3, r4)     // Catch:{ all -> 0x0196 }
            r0.a((float) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x0072:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_placeholderImageScaleType     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x007e
            com.facebook.drawee.drawable.n$b r3 = a((android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.a((com.facebook.drawee.drawable.n.b) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x007e:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_retryImage     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x008a
            android.graphics.drawable.Drawable r3 = a((android.content.Context) r1, (android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.b((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x008a:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_retryImageScaleType     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x0096
            com.facebook.drawee.drawable.n$b r3 = a((android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.b((com.facebook.drawee.drawable.n.b) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x0096:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_failureImage     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x00a2
            android.graphics.drawable.Drawable r3 = a((android.content.Context) r1, (android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.c((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x00a2:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_failureImageScaleType     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x00ae
            com.facebook.drawee.drawable.n$b r3 = a((android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.c((com.facebook.drawee.drawable.n.b) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x00ae:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarImageScaleType     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x00ba
            com.facebook.drawee.drawable.n$b r3 = a((android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.d((com.facebook.drawee.drawable.n.b) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x00ba:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x00c5
            int r6 = r2.getInteger(r3, r6)     // Catch:{ all -> 0x0196 }
        L_0x00c2:
            r4 = 0
            goto L_0x0190
        L_0x00c5:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_backgroundImage     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x00d1
            android.graphics.drawable.Drawable r3 = a((android.content.Context) r1, (android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.e((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x00d1:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_overlayImage     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x00dd
            android.graphics.drawable.Drawable r3 = a((android.content.Context) r1, (android.content.res.TypedArray) r2, (int) r3)     // Catch:{ all -> 0x0196 }
            r0.f(r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x00dd:
            int r4 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundAsCircle     // Catch:{ all -> 0x0196 }
            if (r3 != r4) goto L_0x00ee
            com.facebook.drawee.generic.RoundingParams r4 = a(r18)     // Catch:{ all -> 0x0196 }
            r1 = 0
            boolean r3 = r2.getBoolean(r3, r1)     // Catch:{ all -> 0x0196 }
            r4.a((boolean) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x00ee:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundedCornerRadius     // Catch:{ all -> 0x0196 }
            r4 = r16
            if (r3 != r1) goto L_0x00f9
            int r16 = r2.getDimensionPixelSize(r3, r4)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x00f9:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopLeft     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x0104
            boolean r9 = r2.getBoolean(r3, r9)     // Catch:{ all -> 0x0196 }
        L_0x0101:
            r16 = r4
            goto L_0x00c2
        L_0x0104:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopRight     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x010d
            boolean r11 = r2.getBoolean(r3, r11)     // Catch:{ all -> 0x0196 }
            goto L_0x0101
        L_0x010d:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomLeft     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x0116
            boolean r15 = r2.getBoolean(r3, r15)     // Catch:{ all -> 0x0196 }
            goto L_0x0101
        L_0x0116:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomRight     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x011f
            boolean r13 = r2.getBoolean(r3, r13)     // Catch:{ all -> 0x0196 }
            goto L_0x0101
        L_0x011f:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopStart     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x0128
            boolean r10 = r2.getBoolean(r3, r10)     // Catch:{ all -> 0x0196 }
            goto L_0x0101
        L_0x0128:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopEnd     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x0131
            boolean r12 = r2.getBoolean(r3, r12)     // Catch:{ all -> 0x0196 }
            goto L_0x0101
        L_0x0131:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomStart     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x013b
            boolean r1 = r2.getBoolean(r3, r5)     // Catch:{ all -> 0x0196 }
            r5 = r1
            goto L_0x0101
        L_0x013b:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomEnd     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x0144
            boolean r14 = r2.getBoolean(r3, r14)     // Catch:{ all -> 0x0196 }
            goto L_0x0101
        L_0x0144:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundWithOverlayColor     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x0158
            com.facebook.drawee.generic.RoundingParams r1 = a(r18)     // Catch:{ all -> 0x0196 }
            r16 = r4
            r4 = 0
            int r3 = r2.getColor(r3, r4)     // Catch:{ all -> 0x0196 }
            r1.a((int) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x0158:
            r16 = r4
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderWidth     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x016d
            com.facebook.drawee.generic.RoundingParams r1 = a(r18)     // Catch:{ all -> 0x0196 }
            r4 = 0
            int r3 = r2.getDimensionPixelSize(r3, r4)     // Catch:{ all -> 0x0196 }
            float r3 = (float) r3     // Catch:{ all -> 0x0196 }
            r1.a((float) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x016d:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderColor     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x017f
            com.facebook.drawee.generic.RoundingParams r1 = a(r18)     // Catch:{ all -> 0x0196 }
            r4 = 0
            int r3 = r2.getColor(r3, r4)     // Catch:{ all -> 0x0196 }
            r1.b((int) r3)     // Catch:{ all -> 0x0196 }
            goto L_0x00c2
        L_0x017f:
            int r1 = com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderPadding     // Catch:{ all -> 0x0196 }
            if (r3 != r1) goto L_0x00c2
            com.facebook.drawee.generic.RoundingParams r1 = a(r18)     // Catch:{ all -> 0x0196 }
            r4 = 0
            int r3 = r2.getDimensionPixelSize(r3, r4)     // Catch:{ all -> 0x0196 }
            float r3 = (float) r3     // Catch:{ all -> 0x0196 }
            r1.b((float) r3)     // Catch:{ all -> 0x0196 }
        L_0x0190:
            int r8 = r8 + 1
            r1 = r19
            goto L_0x001e
        L_0x0196:
            r0 = move-exception
            goto L_0x01f8
        L_0x0199:
            r4 = 0
            r2.recycle()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x01cc
            android.content.res.Resources r1 = r19.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.getLayoutDirection()
            r2 = 1
            if (r1 != r2) goto L_0x01cc
            if (r9 == 0) goto L_0x01b8
            if (r12 == 0) goto L_0x01b8
            r1 = 1
            goto L_0x01b9
        L_0x01b8:
            r1 = 0
        L_0x01b9:
            if (r11 == 0) goto L_0x01bf
            if (r10 == 0) goto L_0x01bf
            r2 = 1
            goto L_0x01c0
        L_0x01bf:
            r2 = 0
        L_0x01c0:
            if (r13 == 0) goto L_0x01c6
            if (r5 == 0) goto L_0x01c6
            r3 = 1
            goto L_0x01c7
        L_0x01c6:
            r3 = 0
        L_0x01c7:
            if (r15 == 0) goto L_0x01e6
            if (r14 == 0) goto L_0x01e6
            goto L_0x01e5
        L_0x01cc:
            if (r9 == 0) goto L_0x01d2
            if (r10 == 0) goto L_0x01d2
            r1 = 1
            goto L_0x01d3
        L_0x01d2:
            r1 = 0
        L_0x01d3:
            if (r11 == 0) goto L_0x01d9
            if (r12 == 0) goto L_0x01d9
            r2 = 1
            goto L_0x01da
        L_0x01d9:
            r2 = 0
        L_0x01da:
            if (r13 == 0) goto L_0x01e0
            if (r14 == 0) goto L_0x01e0
            r3 = 1
            goto L_0x01e1
        L_0x01e0:
            r3 = 0
        L_0x01e1:
            if (r15 == 0) goto L_0x01e6
            if (r5 == 0) goto L_0x01e6
        L_0x01e5:
            r4 = 1
        L_0x01e6:
            r5 = r1
            r1 = r16
            r17 = r6
            r6 = r4
            r4 = r17
            goto L_0x0215
        L_0x01ef:
            r0 = move-exception
            r5 = 1
            r9 = 1
            r10 = 1
            r11 = 1
            r12 = 1
            r13 = 1
            r14 = 1
            r15 = 1
        L_0x01f8:
            r2.recycle()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x020e
            android.content.res.Resources r1 = r19.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.getLayoutDirection()
            r2 = 1
        L_0x020e:
            throw r0
        L_0x020f:
            r2 = 1
            r4 = 0
            r1 = 0
            r3 = 1
            r5 = 1
            r6 = 1
        L_0x0215:
            android.graphics.drawable.Drawable r7 = r18.j()
            if (r7 == 0) goto L_0x0229
            if (r4 <= 0) goto L_0x0229
            com.facebook.drawee.drawable.b r7 = new com.facebook.drawee.drawable.b
            android.graphics.drawable.Drawable r8 = r18.j()
            r7.<init>(r8, r4)
            r0.d((android.graphics.drawable.Drawable) r7)
        L_0x0229:
            if (r1 <= 0) goto L_0x0246
            com.facebook.drawee.generic.RoundingParams r4 = a(r18)
            if (r5 == 0) goto L_0x0233
            float r5 = (float) r1
            goto L_0x0234
        L_0x0233:
            r5 = 0
        L_0x0234:
            if (r2 == 0) goto L_0x0238
            float r2 = (float) r1
            goto L_0x0239
        L_0x0238:
            r2 = 0
        L_0x0239:
            if (r3 == 0) goto L_0x023d
            float r3 = (float) r1
            goto L_0x023e
        L_0x023d:
            r3 = 0
        L_0x023e:
            if (r6 == 0) goto L_0x0242
            float r1 = (float) r1
            goto L_0x0243
        L_0x0242:
            r1 = 0
        L_0x0243:
            r4.a(r5, r2, r3, r1)
        L_0x0246:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.generic.c.a(com.facebook.drawee.generic.b, android.content.Context, android.util.AttributeSet):com.facebook.drawee.generic.b");
    }
}
