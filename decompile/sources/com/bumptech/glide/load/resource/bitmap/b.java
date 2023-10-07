package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import bl.e;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import java.io.File;

public class b implements h<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final e f10458a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Bitmap> f10459b;

    public b(e eVar, h<Bitmap> hVar) {
        this.f10458a = eVar;
        this.f10459b = hVar;
    }

    public EncodeStrategy a(f fVar) {
        return this.f10459b.a(fVar);
    }

    public boolean a(s<BitmapDrawable> sVar, File file, f fVar) {
        return this.f10459b.a(new e(sVar.d().getBitmap(), this.f10458a), file, fVar);
    }
}
