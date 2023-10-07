package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class h implements g<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f10467a = new d();

    public s<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, f fVar) throws IOException {
        return this.f10467a.a(ImageDecoder.createSource(byteBuffer), i2, i3, fVar);
    }

    public boolean a(ByteBuffer byteBuffer, f fVar) throws IOException {
        return true;
    }
}
