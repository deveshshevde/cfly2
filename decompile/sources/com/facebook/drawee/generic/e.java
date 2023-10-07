package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.c;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.h;
import com.facebook.drawee.drawable.i;
import com.facebook.drawee.drawable.j;
import com.facebook.drawee.drawable.l;
import com.facebook.drawee.drawable.m;
import com.facebook.drawee.drawable.n;
import com.facebook.drawee.generic.RoundingParams;
import dg.a;
import ds.b;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Drawable f11298a = new ColorDrawable(0);

    static Drawable a(Drawable drawable, n.b bVar) {
        return a(drawable, bVar, (PointF) null);
    }

    static Drawable a(Drawable drawable, n.b bVar, PointF pointF) {
        if (b.b()) {
            b.a("WrappingUtils#maybeWrapWithScaleType");
        }
        if (drawable == null || bVar == null) {
            if (b.b()) {
                b.a();
            }
            return drawable;
        }
        m mVar = new m(drawable, bVar);
        if (pointF != null) {
            mVar.a(pointF);
        }
        if (b.b()) {
            b.a();
        }
        return mVar;
    }

    static Drawable a(Drawable drawable, RoundingParams roundingParams) {
        try {
            if (b.b()) {
                b.a("WrappingUtils#maybeWrapWithRoundedOverlayColor");
            }
            if (!(drawable == null || roundingParams == null)) {
                if (roundingParams.c() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
                    RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
                    a((h) roundedCornersDrawable, roundingParams);
                    roundedCornersDrawable.a(roundingParams.d());
                    if (b.b()) {
                        b.a();
                    }
                    return roundedCornersDrawable;
                }
            }
            return drawable;
        } finally {
            if (b.b()) {
                b.a();
            }
        }
    }

    static Drawable a(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        try {
            if (b.b()) {
                b.a("WrappingUtils#maybeApplyLeafRounding");
            }
            if (!(drawable == null || roundingParams == null)) {
                if (roundingParams.c() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
                    if (drawable instanceof g) {
                        c a2 = a((g) drawable);
                        a2.a(b(a2.a(f11298a), roundingParams, resources));
                        if (b.b()) {
                            b.a();
                        }
                        return drawable;
                    }
                    Drawable b2 = b(drawable, roundingParams, resources);
                    if (b.b()) {
                        b.a();
                    }
                    return b2;
                }
            }
            return drawable;
        } finally {
            if (b.b()) {
                b.a();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.facebook.drawee.drawable.c a(com.facebook.drawee.drawable.c r2) {
        /*
        L_0x0000:
            android.graphics.drawable.Drawable r0 = r2.a()
            if (r0 == r2) goto L_0x000f
            boolean r1 = r0 instanceof com.facebook.drawee.drawable.c
            if (r1 != 0) goto L_0x000b
            goto L_0x000f
        L_0x000b:
            r2 = r0
            com.facebook.drawee.drawable.c r2 = (com.facebook.drawee.drawable.c) r2
            goto L_0x0000
        L_0x000f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.generic.e.a(com.facebook.drawee.drawable.c):com.facebook.drawee.drawable.c");
    }

    static void a(h hVar, RoundingParams roundingParams) {
        hVar.a(roundingParams.a());
        hVar.a(roundingParams.b());
        hVar.a(roundingParams.f(), roundingParams.e());
        hVar.a(roundingParams.g());
        hVar.b(roundingParams.h());
        hVar.c(roundingParams.i());
    }

    private static Drawable b(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            i iVar = new i(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            a((h) iVar, roundingParams);
            return iVar;
        } else if (drawable instanceof NinePatchDrawable) {
            l lVar = new l((NinePatchDrawable) drawable);
            a((h) lVar, roundingParams);
            return lVar;
        } else if (!(drawable instanceof ColorDrawable) || Build.VERSION.SDK_INT < 11) {
            a.a("WrappingUtils", "Don't know how to round that drawable: %s", drawable);
            return drawable;
        } else {
            j a2 = j.a((ColorDrawable) drawable);
            a((h) a2, roundingParams);
            return a2;
        }
    }
}
