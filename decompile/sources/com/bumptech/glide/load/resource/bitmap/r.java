package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import cc.a;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.io.InputStream;

public final class r implements g<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f10508a = new d();

    public s<Bitmap> a(InputStream inputStream, int i2, int i3, f fVar) throws IOException {
        return this.f10508a.a(ImageDecoder.createSource(a.a(inputStream)), i2, i3, fVar);
    }

    public boolean a(InputStream inputStream, f fVar) throws IOException {
        return true;
    }
}
