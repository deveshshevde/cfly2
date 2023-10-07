package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.ad;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class r<T> implements Loader.d {

    /* renamed from: a  reason: collision with root package name */
    public final h f17079a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17080b;

    /* renamed from: c  reason: collision with root package name */
    private final s f17081c;

    /* renamed from: d  reason: collision with root package name */
    private final a<? extends T> f17082d;

    /* renamed from: e  reason: collision with root package name */
    private volatile T f17083e;

    public interface a<T> {
        T b(Uri uri, InputStream inputStream) throws IOException;
    }

    public r(f fVar, Uri uri, int i2, a<? extends T> aVar) {
        this(fVar, new h(uri, 1), i2, aVar);
    }

    public r(f fVar, h hVar, int i2, a<? extends T> aVar) {
        this.f17081c = new s(fVar);
        this.f17079a = hVar;
        this.f17080b = i2;
        this.f17082d = aVar;
    }

    public final void a() {
    }

    public final void b() throws IOException {
        this.f17081c.d();
        g gVar = new g(this.f17081c, this.f17079a);
        try {
            gVar.a();
            this.f17083e = this.f17082d.b((Uri) com.google.android.exoplayer2.util.a.b(this.f17081c.a()), gVar);
        } finally {
            ad.a((Closeable) gVar);
        }
    }

    public final T c() {
        return this.f17083e;
    }

    public long d() {
        return this.f17081c.e();
    }

    public Uri e() {
        return this.f17081c.f();
    }

    public Map<String, List<String>> f() {
        return this.f17081c.g();
    }
}
