package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import bl.e;
import cc.k;
import cc.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class v extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f10514b = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(f10157a);

    /* renamed from: c  reason: collision with root package name */
    private final int f10515c;

    public v(int i2) {
        k.a(i2 > 0, "roundingRadius must be greater than 0.");
        this.f10515c = i2;
    }

    /* access modifiers changed from: protected */
    public Bitmap a(e eVar, Bitmap bitmap, int i2, int i3) {
        return x.b(eVar, bitmap, this.f10515c);
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(f10514b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f10515c).array());
    }

    public boolean equals(Object obj) {
        return (obj instanceof v) && this.f10515c == ((v) obj).f10515c;
    }

    public int hashCode() {
        return l.b(-569625254, l.b(this.f10515c));
    }
}
