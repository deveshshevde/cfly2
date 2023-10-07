package com.xeagle.android.vjoystick.utils.transformation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import bw.l;
import bw.q;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import com.bumptech.glide.request.a;
import java.io.File;

public class e extends h {
    public e(c cVar, l lVar, q qVar, Context context) {
        super(cVar, lVar, qVar, context);
    }

    /* access modifiers changed from: protected */
    public void a(com.bumptech.glide.request.h hVar) {
        if (!(hVar instanceof c)) {
            hVar = new c().b((a<?>) hVar);
        }
        super.a(hVar);
    }

    /* renamed from: b */
    public d<Drawable> a(Object obj) {
        return (d) super.a(obj);
    }

    /* renamed from: b */
    public d<Drawable> a(String str) {
        return (d) super.a(str);
    }

    /* renamed from: c */
    public <ResourceType> d<ResourceType> a(Class<ResourceType> cls) {
        return new d<>(this.f10112a, this, cls, this.f10113b);
    }

    /* renamed from: c */
    public synchronized e b(com.bumptech.glide.request.h hVar) {
        return (e) super.b(hVar);
    }

    /* renamed from: n */
    public d<Bitmap> h() {
        return (d) super.h();
    }

    /* renamed from: o */
    public d<bu.c> i() {
        return (d) super.i();
    }

    /* renamed from: p */
    public d<Drawable> j() {
        return (d) super.j();
    }

    /* renamed from: q */
    public d<File> k() {
        return (d) super.k();
    }
}
