package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import bl.e;
import java.security.MessageDigest;

public class o extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f10487b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(f10157a);

    /* access modifiers changed from: protected */
    public Bitmap a(e eVar, Bitmap bitmap, int i2, int i3) {
        return x.b(eVar, bitmap, i2, i3);
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(f10487b);
    }

    public boolean equals(Object obj) {
        return obj instanceof o;
    }

    public int hashCode() {
        return 1572326941;
    }
}
