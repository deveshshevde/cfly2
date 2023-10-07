package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import cc.k;
import com.bumptech.glide.load.engine.o;

public final class s implements o, com.bumptech.glide.load.engine.s<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f10509a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.s<Bitmap> f10510b;

    private s(Resources resources, com.bumptech.glide.load.engine.s<Bitmap> sVar) {
        this.f10509a = (Resources) k.a(resources);
        this.f10510b = (com.bumptech.glide.load.engine.s) k.a(sVar);
    }

    public static com.bumptech.glide.load.engine.s<BitmapDrawable> a(Resources resources, com.bumptech.glide.load.engine.s<Bitmap> sVar) {
        if (sVar == null) {
            return null;
        }
        return new s(resources, sVar);
    }

    public void a() {
        com.bumptech.glide.load.engine.s<Bitmap> sVar = this.f10510b;
        if (sVar instanceof o) {
            ((o) sVar).a();
        }
    }

    /* renamed from: b */
    public BitmapDrawable d() {
        return new BitmapDrawable(this.f10509a, this.f10510b.d());
    }

    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    public int e() {
        return this.f10510b.e();
    }

    public void f() {
        this.f10510b.f();
    }
}
