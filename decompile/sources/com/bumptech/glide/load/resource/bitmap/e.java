package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import cc.k;
import cc.l;
import com.bumptech.glide.load.engine.o;
import com.bumptech.glide.load.engine.s;

public class e implements o, s<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f10464a;

    /* renamed from: b  reason: collision with root package name */
    private final bl.e f10465b;

    public e(Bitmap bitmap, bl.e eVar) {
        this.f10464a = (Bitmap) k.a(bitmap, "Bitmap must not be null");
        this.f10465b = (bl.e) k.a(eVar, "BitmapPool must not be null");
    }

    public static e a(Bitmap bitmap, bl.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, eVar);
    }

    public void a() {
        this.f10464a.prepareToDraw();
    }

    /* renamed from: b */
    public Bitmap d() {
        return this.f10464a;
    }

    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    public int e() {
        return l.a(this.f10464a);
    }

    public void f() {
        this.f10465b.a(this.f10464a);
    }
}
