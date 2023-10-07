package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import bl.e;
import cc.l;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.i;

public abstract class f implements i<Bitmap> {
    /* access modifiers changed from: protected */
    public abstract Bitmap a(e eVar, Bitmap bitmap, int i2, int i3);

    public final s<Bitmap> a(Context context, s<Bitmap> sVar, int i2, int i3) {
        if (l.a(i2, i3)) {
            e a2 = c.a(context).a();
            Bitmap d2 = sVar.d();
            if (i2 == Integer.MIN_VALUE) {
                i2 = d2.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = d2.getHeight();
            }
            Bitmap a3 = a(a2, d2, i2, i3);
            return d2.equals(a3) ? sVar : e.a(a3, a2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
