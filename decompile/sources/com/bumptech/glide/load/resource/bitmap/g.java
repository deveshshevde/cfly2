package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import java.io.IOException;
import java.nio.ByteBuffer;

public class g implements com.bumptech.glide.load.g<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final k f10466a;

    public g(k kVar) {
        this.f10466a = kVar;
    }

    public s<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, f fVar) throws IOException {
        return this.f10466a.a(byteBuffer, i2, i3, fVar);
    }

    public boolean a(ByteBuffer byteBuffer, f fVar) {
        return this.f10466a.a(byteBuffer);
    }
}
