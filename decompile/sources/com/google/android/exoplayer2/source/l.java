package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.upstream.t;
import fj.e;
import java.io.IOException;

public final class l extends a implements k.c {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f16442a;

    /* renamed from: b  reason: collision with root package name */
    private final f.a f16443b;

    /* renamed from: c  reason: collision with root package name */
    private final fj.k f16444c;

    /* renamed from: d  reason: collision with root package name */
    private final b<?> f16445d;

    /* renamed from: e  reason: collision with root package name */
    private final p f16446e;

    /* renamed from: f  reason: collision with root package name */
    private final String f16447f;

    /* renamed from: g  reason: collision with root package name */
    private final int f16448g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f16449h;

    /* renamed from: i  reason: collision with root package name */
    private long f16450i = -9223372036854775807L;

    /* renamed from: j  reason: collision with root package name */
    private boolean f16451j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f16452k;

    /* renamed from: l  reason: collision with root package name */
    private t f16453l;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final f.a f16454a;

        /* renamed from: b  reason: collision with root package name */
        private fj.k f16455b;

        /* renamed from: c  reason: collision with root package name */
        private String f16456c;

        /* renamed from: d  reason: collision with root package name */
        private Object f16457d;

        /* renamed from: e  reason: collision with root package name */
        private b<?> f16458e;

        /* renamed from: f  reason: collision with root package name */
        private p f16459f;

        /* renamed from: g  reason: collision with root package name */
        private int f16460g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f16461h;

        public a(f.a aVar) {
            this(aVar, new e());
        }

        public a(f.a aVar, fj.k kVar) {
            this.f16454a = aVar;
            this.f16455b = kVar;
            this.f16458e = b.CC.c();
            this.f16459f = new o();
            this.f16460g = MemoryConstants.MB;
        }

        public l a(Uri uri) {
            this.f16461h = true;
            return new l(uri, this.f16454a, this.f16455b, this.f16458e, this.f16459f, this.f16456c, this.f16460g, this.f16457d);
        }
    }

    l(Uri uri, f.a aVar, fj.k kVar, b<?> bVar, p pVar, String str, int i2, Object obj) {
        this.f16442a = uri;
        this.f16443b = aVar;
        this.f16444c = kVar;
        this.f16445d = bVar;
        this.f16446e = pVar;
        this.f16447f = str;
        this.f16448g = i2;
        this.f16449h = obj;
    }

    private void b(long j2, boolean z2, boolean z3) {
        this.f16450i = j2;
        this.f16451j = z2;
        this.f16452k = z3;
        a((af) new q(this.f16450i, this.f16451j, false, this.f16452k, (Object) null, this.f16449h));
    }

    public h a(i.a aVar, com.google.android.exoplayer2.upstream.b bVar, long j2) {
        f a2 = this.f16443b.a();
        t tVar = this.f16453l;
        if (tVar != null) {
            a2.a(tVar);
        }
        return new k(this.f16442a, a2, this.f16444c.createExtractors(), this.f16445d, this.f16446e, a(aVar), this, bVar, this.f16447f, this.f16448g);
    }

    public void a(long j2, boolean z2, boolean z3) {
        if (j2 == -9223372036854775807L) {
            j2 = this.f16450i;
        }
        if (this.f16450i != j2 || this.f16451j != z2 || this.f16452k != z3) {
            b(j2, z2, z3);
        }
    }

    public void a(h hVar) {
        ((k) hVar).g();
    }

    /* access modifiers changed from: protected */
    public void a(t tVar) {
        this.f16453l = tVar;
        this.f16445d.a();
        b(this.f16450i, this.f16451j, this.f16452k);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f16445d.b();
    }

    public void d() throws IOException {
    }
}
