package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.a;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class s implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f f17084a;

    /* renamed from: b  reason: collision with root package name */
    private long f17085b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f17086c = Uri.EMPTY;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, List<String>> f17087d = Collections.emptyMap();

    public s(f fVar) {
        this.f17084a = (f) a.b(fVar);
    }

    public int a(byte[] bArr, int i2, int i3) throws IOException {
        int a2 = this.f17084a.a(bArr, i2, i3);
        if (a2 != -1) {
            this.f17085b += (long) a2;
        }
        return a2;
    }

    public long a(h hVar) throws IOException {
        this.f17086c = hVar.f16995a;
        this.f17087d = Collections.emptyMap();
        long a2 = this.f17084a.a(hVar);
        this.f17086c = (Uri) a.b(a());
        this.f17087d = b();
        return a2;
    }

    public Uri a() {
        return this.f17084a.a();
    }

    public void a(t tVar) {
        this.f17084a.a(tVar);
    }

    public Map<String, List<String>> b() {
        return this.f17084a.b();
    }

    public void c() throws IOException {
        this.f17084a.c();
    }

    public void d() {
        this.f17085b = 0;
    }

    public long e() {
        return this.f17085b;
    }

    public Uri f() {
        return this.f17086c;
    }

    public Map<String, List<String>> g() {
        return this.f17087d;
    }
}
