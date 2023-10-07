package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import bl.e;
import java.security.MessageDigest;

public class i extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f10468b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(f10157a);

    /* access modifiers changed from: protected */
    public Bitmap a(e eVar, Bitmap bitmap, int i2, int i3) {
        return x.a(eVar, bitmap, i2, i3);
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(f10468b);
    }

    public boolean equals(Object obj) {
        return obj instanceof i;
    }

    public int hashCode() {
        return -599754482;
    }
}
