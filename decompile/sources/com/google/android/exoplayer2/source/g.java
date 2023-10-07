package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.q;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f f16153a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16154b;

    /* renamed from: c  reason: collision with root package name */
    private final a f16155c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f16156d;

    /* renamed from: e  reason: collision with root package name */
    private int f16157e;

    public interface a {
        void a(q qVar);
    }

    public g(f fVar, int i2, a aVar) {
        com.google.android.exoplayer2.util.a.a(i2 > 0);
        this.f16153a = fVar;
        this.f16154b = i2;
        this.f16155c = aVar;
        this.f16156d = new byte[1];
        this.f16157e = i2;
    }

    private boolean d() throws IOException {
        if (this.f16153a.a(this.f16156d, 0, 1) == -1) {
            return false;
        }
        int i2 = (this.f16156d[0] & 255) << 4;
        if (i2 == 0) {
            return true;
        }
        byte[] bArr = new byte[i2];
        int i3 = i2;
        int i4 = 0;
        while (i3 > 0) {
            int a2 = this.f16153a.a(bArr, i4, i3);
            if (a2 == -1) {
                return false;
            }
            i4 += a2;
            i3 -= a2;
        }
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        if (i2 > 0) {
            this.f16155c.a(new q(bArr, i2));
        }
        return true;
    }

    public int a(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f16157e == 0) {
            if (!d()) {
                return -1;
            }
            this.f16157e = this.f16154b;
        }
        int a2 = this.f16153a.a(bArr, i2, Math.min(this.f16157e, i3));
        if (a2 != -1) {
            this.f16157e -= a2;
        }
        return a2;
    }

    public long a(h hVar) throws IOException {
        throw new UnsupportedOperationException();
    }

    public Uri a() {
        return this.f16153a.a();
    }

    public void a(t tVar) {
        this.f16153a.a(tVar);
    }

    public Map<String, List<String>> b() {
        return this.f16153a.b();
    }

    public void c() throws IOException {
        throw new UnsupportedOperationException();
    }
}
