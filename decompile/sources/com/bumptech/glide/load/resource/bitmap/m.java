package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import bl.e;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.i;
import java.security.MessageDigest;

public class m implements i<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private final i<Bitmap> f10485b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10486c;

    public m(i<Bitmap> iVar, boolean z2) {
        this.f10485b = iVar;
        this.f10486c = z2;
    }

    private s<Drawable> a(Context context, s<Bitmap> sVar) {
        return s.a(context.getResources(), sVar);
    }

    public s<Drawable> a(Context context, s<Drawable> sVar, int i2, int i3) {
        e a2 = c.a(context).a();
        Drawable d2 = sVar.d();
        s<Bitmap> a3 = l.a(a2, d2, i2, i3);
        if (a3 != null) {
            s<Bitmap> a4 = this.f10485b.a(context, a3, i2, i3);
            if (!a4.equals(a3)) {
                return a(context, a4);
            }
            a4.f();
            return sVar;
        } else if (!this.f10486c) {
            return sVar;
        } else {
            throw new IllegalArgumentException("Unable to convert " + d2 + " to a Bitmap");
        }
    }

    public i<BitmapDrawable> a() {
        return this;
    }

    public void a(MessageDigest messageDigest) {
        this.f10485b.a(messageDigest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f10485b.equals(((m) obj).f10485b);
        }
        return false;
    }

    public int hashCode() {
        return this.f10485b.hashCode();
    }
}
