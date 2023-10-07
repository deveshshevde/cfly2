package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.util.a;
import java.util.LinkedHashMap;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<Uri, byte[]> f16194a;

    public d(int i2) {
        this.f16194a = new FullSegmentEncryptionKeyCache$1(this, i2 + 1, 1.0f, false, i2);
    }

    public byte[] a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.f16194a.get(uri);
    }

    public byte[] a(Uri uri, byte[] bArr) {
        return (byte[]) this.f16194a.put((Uri) a.b(uri), (byte[]) a.b(bArr));
    }

    public byte[] b(Uri uri) {
        return (byte[]) this.f16194a.remove(a.b(uri));
    }
}
