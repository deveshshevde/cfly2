package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.a;
import java.io.IOException;
import java.io.InputStream;

public final class g extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final f f16989a;

    /* renamed from: b  reason: collision with root package name */
    private final h f16990b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f16991c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16992d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16993e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f16994f;

    public g(f fVar, h hVar) {
        this.f16989a = fVar;
        this.f16990b = hVar;
        this.f16991c = new byte[1];
    }

    private void b() throws IOException {
        if (!this.f16992d) {
            this.f16989a.a(this.f16990b);
            this.f16992d = true;
        }
    }

    public void a() throws IOException {
        b();
    }

    public void close() throws IOException {
        if (!this.f16993e) {
            this.f16989a.c();
            this.f16993e = true;
        }
    }

    public int read() throws IOException {
        if (read(this.f16991c) == -1) {
            return -1;
        }
        return this.f16991c[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        a.b(!this.f16993e);
        b();
        int a2 = this.f16989a.a(bArr, i2, i3);
        if (a2 == -1) {
            return -1;
        }
        this.f16994f += (long) a2;
        return a2;
    }
}
