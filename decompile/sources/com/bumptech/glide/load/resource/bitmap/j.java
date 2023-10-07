package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import bl.e;
import java.security.MessageDigest;

public class j extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f10469b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(f10157a);

    /* access modifiers changed from: protected */
    public Bitmap a(e eVar, Bitmap bitmap, int i2, int i3) {
        return x.c(eVar, bitmap, i2, i3);
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(f10469b);
    }

    public boolean equals(Object obj) {
        return obj instanceof j;
    }

    public int hashCode() {
        return -670243078;
    }
}
