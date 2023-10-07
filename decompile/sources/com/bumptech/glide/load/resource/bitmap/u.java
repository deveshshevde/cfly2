package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import bs.e;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;

public class u implements g<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final e f10512a;

    /* renamed from: b  reason: collision with root package name */
    private final bl.e f10513b;

    public u(e eVar, bl.e eVar2) {
        this.f10512a = eVar;
        this.f10513b = eVar2;
    }

    public s<Bitmap> a(Uri uri, int i2, int i3, f fVar) {
        s<Drawable> a2 = this.f10512a.a(uri, i2, i3, fVar);
        if (a2 == null) {
            return null;
        }
        return l.a(this.f10513b, a2.d(), i2, i3);
    }

    public boolean a(Uri uri, f fVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
