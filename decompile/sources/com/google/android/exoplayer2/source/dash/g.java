package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import fi.e;
import fj.h;
import fj.u;
import ft.d;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public final class g implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f16136a;

    /* renamed from: b  reason: collision with root package name */
    private final b f16137b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.google.android.exoplayer2.metadata.emsg.a f16138c = new com.google.android.exoplayer2.metadata.emsg.a();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Handler f16139d = ad.a((Handler.Callback) this);

    /* renamed from: e  reason: collision with root package name */
    private final TreeMap<Long, Long> f16140e = new TreeMap<>();

    /* renamed from: f  reason: collision with root package name */
    private fu.b f16141f;

    /* renamed from: g  reason: collision with root package name */
    private long f16142g;

    /* renamed from: h  reason: collision with root package name */
    private long f16143h = -9223372036854775807L;

    /* renamed from: i  reason: collision with root package name */
    private long f16144i = -9223372036854775807L;

    /* renamed from: j  reason: collision with root package name */
    private boolean f16145j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f16146k;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f16147a;

        /* renamed from: b  reason: collision with root package name */
        public final long f16148b;

        public a(long j2, long j3) {
            this.f16147a = j2;
            this.f16148b = j3;
        }
    }

    public interface b {
        void a();

        void a(long j2);
    }

    public final class c implements u {

        /* renamed from: b  reason: collision with root package name */
        private final n f16150b;

        /* renamed from: c  reason: collision with root package name */
        private final o f16151c = new o();

        /* renamed from: d  reason: collision with root package name */
        private final com.google.android.exoplayer2.metadata.c f16152d = new com.google.android.exoplayer2.metadata.c();

        c(com.google.android.exoplayer2.upstream.b bVar) {
            this.f16150b = new n(bVar, g.this.f16139d.getLooper(), b.CC.c());
        }

        private void a(long j2, long j3) {
            g.this.f16139d.sendMessage(g.this.f16139d.obtainMessage(1, new a(j2, j3)));
        }

        private void a(long j2, EventMessage eventMessage) {
            long a2 = g.b(eventMessage);
            if (a2 != -9223372036854775807L) {
                a(j2, a2);
            }
        }

        private void b() {
            while (this.f16150b.b(false)) {
                com.google.android.exoplayer2.metadata.c c2 = c();
                if (c2 != null) {
                    long j2 = c2.f13101d;
                    EventMessage eventMessage = (EventMessage) g.this.f16138c.a(c2).a(0);
                    if (g.a(eventMessage.f15857a, eventMessage.f15858b)) {
                        a(j2, eventMessage);
                    }
                }
            }
            this.f16150b.o();
        }

        private com.google.android.exoplayer2.metadata.c c() {
            this.f16152d.clear();
            if (this.f16150b.a(this.f16151c, (e) this.f16152d, false, false, 0) != -4) {
                return null;
            }
            this.f16152d.d();
            return this.f16152d;
        }

        public int a(h hVar, int i2, boolean z2) throws IOException, InterruptedException {
            return this.f16150b.a(hVar, i2, z2);
        }

        public void a() {
            this.f16150b.a();
        }

        public void a(long j2, int i2, int i3, int i4, u.a aVar) {
            this.f16150b.a(j2, i2, i3, i4, aVar);
            b();
        }

        public void a(Format format) {
            this.f16150b.a(format);
        }

        public void a(q qVar, int i2) {
            this.f16150b.a(qVar, i2);
        }

        public void a(d dVar) {
            g.this.b(dVar);
        }

        public boolean a(long j2) {
            return g.this.a(j2);
        }

        public boolean b(d dVar) {
            return g.this.a(dVar);
        }
    }

    public g(fu.b bVar, b bVar2, com.google.android.exoplayer2.upstream.b bVar3) {
        this.f16141f = bVar;
        this.f16137b = bVar2;
        this.f16136a = bVar3;
    }

    private void a(long j2, long j3) {
        Long l2 = this.f16140e.get(Long.valueOf(j3));
        if (l2 == null || l2.longValue() > j2) {
            this.f16140e.put(Long.valueOf(j3), Long.valueOf(j2));
        }
    }

    public static boolean a(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    /* access modifiers changed from: private */
    public static long b(EventMessage eventMessage) {
        try {
            return ad.f(ad.a(eventMessage.f15861e));
        } catch (ParserException unused) {
            return -9223372036854775807L;
        }
    }

    private Map.Entry<Long, Long> b(long j2) {
        return this.f16140e.ceilingEntry(Long.valueOf(j2));
    }

    private void c() {
        Iterator<Map.Entry<Long, Long>> it2 = this.f16140e.entrySet().iterator();
        while (it2.hasNext()) {
            if (((Long) it2.next().getKey()).longValue() < this.f16141f.f28126g) {
                it2.remove();
            }
        }
    }

    private void d() {
        this.f16137b.a(this.f16142g);
    }

    private void e() {
        long j2 = this.f16144i;
        if (j2 == -9223372036854775807L || j2 != this.f16143h) {
            this.f16145j = true;
            this.f16144i = this.f16143h;
            this.f16137b.a();
        }
    }

    public c a() {
        return new c(this.f16136a);
    }

    public void a(fu.b bVar) {
        this.f16145j = false;
        this.f16142g = -9223372036854775807L;
        this.f16141f = bVar;
        c();
    }

    /* access modifiers changed from: package-private */
    public boolean a(long j2) {
        boolean z2 = false;
        if (!this.f16141f.f28122c) {
            return false;
        }
        if (this.f16145j) {
            return true;
        }
        Map.Entry<Long, Long> b2 = b(this.f16141f.f28126g);
        if (b2 != null && b2.getValue().longValue() < j2) {
            this.f16142g = b2.getKey().longValue();
            d();
            z2 = true;
        }
        if (z2) {
            e();
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public boolean a(d dVar) {
        if (!this.f16141f.f28122c) {
            return false;
        }
        if (this.f16145j) {
            return true;
        }
        long j2 = this.f16143h;
        if (!(j2 != -9223372036854775807L && j2 < dVar.f13115h)) {
            return false;
        }
        e();
        return true;
    }

    public void b() {
        this.f16146k = true;
        this.f16139d.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void b(d dVar) {
        if (this.f16143h != -9223372036854775807L || dVar.f13116i > this.f16143h) {
            this.f16143h = dVar.f13116i;
        }
    }

    public boolean handleMessage(Message message) {
        if (this.f16146k) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        a(aVar.f16147a, aVar.f16148b);
        return true;
    }
}
