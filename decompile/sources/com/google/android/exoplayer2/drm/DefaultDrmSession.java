package com.google.android.exoplayer2.drm;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.drm.e;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.k;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

class DefaultDrmSession<T extends d> implements DrmSession<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List<DrmInitData.SchemeData> f11635a;

    /* renamed from: b  reason: collision with root package name */
    final g f11636b;

    /* renamed from: c  reason: collision with root package name */
    final UUID f11637c;

    /* renamed from: d  reason: collision with root package name */
    final DefaultDrmSession<T>.e f11638d;

    /* renamed from: e  reason: collision with root package name */
    private final e<T> f11639e;

    /* renamed from: f  reason: collision with root package name */
    private final a<T> f11640f;

    /* renamed from: g  reason: collision with root package name */
    private final b<T> f11641g;

    /* renamed from: h  reason: collision with root package name */
    private final int f11642h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f11643i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f11644j;

    /* renamed from: k  reason: collision with root package name */
    private final HashMap<String, String> f11645k;

    /* renamed from: l  reason: collision with root package name */
    private final g<a> f11646l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final p f11647m;

    /* renamed from: n  reason: collision with root package name */
    private int f11648n;

    /* renamed from: o  reason: collision with root package name */
    private int f11649o;

    /* renamed from: p  reason: collision with root package name */
    private HandlerThread f11650p;

    /* renamed from: q  reason: collision with root package name */
    private DefaultDrmSession<T>.c f11651q;

    /* renamed from: r  reason: collision with root package name */
    private T f11652r;

    /* renamed from: s  reason: collision with root package name */
    private DrmSession.DrmSessionException f11653s;

    /* renamed from: t  reason: collision with root package name */
    private byte[] f11654t;

    /* renamed from: u  reason: collision with root package name */
    private byte[] f11655u;

    /* renamed from: v  reason: collision with root package name */
    private e.a f11656v;

    /* renamed from: w  reason: collision with root package name */
    private e.d f11657w;

    public static final class UnexpectedDrmSessionException extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public UnexpectedDrmSessionException(java.lang.Throwable r5) {
            /*
                r4 = this;
                java.lang.Class r0 = r5.getClass()
                java.lang.String r0 = r0.getSimpleName()
                java.lang.String r1 = r5.getMessage()
                java.lang.String r2 = java.lang.String.valueOf(r0)
                int r2 = r2.length()
                int r2 = r2 + 13
                java.lang.String r3 = java.lang.String.valueOf(r1)
                int r3 = r3.length()
                int r2 = r2 + r3
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r2)
                java.lang.String r2 = "Unexpected "
                r3.append(r2)
                r3.append(r0)
                java.lang.String r0 = ": "
                r3.append(r0)
                r3.append(r1)
                java.lang.String r0 = r3.toString()
                r4.<init>(r0, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DefaultDrmSession.UnexpectedDrmSessionException.<init>(java.lang.Throwable):void");
        }
    }

    public interface a<T extends d> {
        void a();

        void a(DefaultDrmSession<T> defaultDrmSession);

        void a(Exception exc);
    }

    public interface b<T extends d> {
        void onSessionReleased(DefaultDrmSession<T> defaultDrmSession);
    }

    private class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, Exception exc) {
            d dVar = (d) message.obj;
            if (!dVar.f15433a) {
                return false;
            }
            dVar.f15436d++;
            if (dVar.f15436d > DefaultDrmSession.this.f11647m.a(3)) {
                return false;
            }
            long b2 = DefaultDrmSession.this.f11647m.b(3, SystemClock.elapsedRealtime() - dVar.f15434b, exc instanceof IOException ? (IOException) exc : new UnexpectedDrmSessionException(exc), dVar.f15436d);
            if (b2 == -9223372036854775807L) {
                return false;
            }
            sendMessageDelayed(Message.obtain(message), b2);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, Object obj, boolean z2) {
            obtainMessage(i2, new d(z2, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public void handleMessage(Message message) {
            byte[] bArr;
            d dVar = (d) message.obj;
            try {
                int i2 = message.what;
                if (i2 == 0) {
                    bArr = DefaultDrmSession.this.f11636b.a(DefaultDrmSession.this.f11637c, (e.d) dVar.f15435c);
                } else if (i2 == 1) {
                    bArr = DefaultDrmSession.this.f11636b.a(DefaultDrmSession.this.f11637c, (e.a) dVar.f15435c);
                } else {
                    throw new RuntimeException();
                }
            } catch (Exception e2) {
                boolean a2 = a(message, e2);
                bArr = e2;
                if (a2) {
                    return;
                }
            }
            DefaultDrmSession.this.f11638d.obtainMessage(message.what, Pair.create(dVar.f15435c, bArr)).sendToTarget();
        }
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f15433a;

        /* renamed from: b  reason: collision with root package name */
        public final long f15434b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f15435c;

        /* renamed from: d  reason: collision with root package name */
        public int f15436d;

        public d(boolean z2, long j2, Object obj) {
            this.f15433a = z2;
            this.f15434b = j2;
            this.f15435c = obj;
        }
    }

    private class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i2 = message.what;
            if (i2 == 0) {
                DefaultDrmSession.this.a(obj, obj2);
            } else if (i2 == 1) {
                DefaultDrmSession.this.b(obj, obj2);
            }
        }
    }

    public DefaultDrmSession(UUID uuid, e<T> eVar, a<T> aVar, b<T> bVar, List<DrmInitData.SchemeData> list, int i2, boolean z2, boolean z3, byte[] bArr, HashMap<String, String> hashMap, g gVar, Looper looper, g<a> gVar2, p pVar) {
        List<DrmInitData.SchemeData> list2;
        if (i2 == 1 || i2 == 3) {
            com.google.android.exoplayer2.util.a.b(bArr);
        }
        this.f11637c = uuid;
        this.f11640f = aVar;
        this.f11641g = bVar;
        this.f11639e = eVar;
        this.f11642h = i2;
        this.f11643i = z2;
        this.f11644j = z3;
        if (bArr != null) {
            this.f11655u = bArr;
            list2 = null;
        } else {
            list2 = Collections.unmodifiableList((List) com.google.android.exoplayer2.util.a.b(list));
        }
        this.f11635a = list2;
        this.f11645k = hashMap;
        this.f11636b = gVar;
        this.f11646l = gVar2;
        this.f11647m = pVar;
        this.f11648n = 2;
        this.f11638d = new e(looper);
    }

    /* access modifiers changed from: private */
    public void a(Object obj, Object obj2) {
        if (obj != this.f11657w) {
            return;
        }
        if (this.f11648n == 2 || m()) {
            this.f11657w = null;
            if (obj2 instanceof Exception) {
                this.f11640f.a((Exception) obj2);
                return;
            }
            try {
                this.f11639e.b((byte[]) obj2);
                this.f11640f.a();
            } catch (Exception e2) {
                this.f11640f.a(e2);
            }
        }
    }

    private void a(byte[] bArr, int i2, boolean z2) {
        try {
            this.f11656v = this.f11639e.a(bArr, this.f11635a, i2, this.f11645k);
            ((c) ad.a(this.f11651q)).a(1, com.google.android.exoplayer2.util.a.b(this.f11656v), z2);
        } catch (Exception e2) {
            b(e2);
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean a(boolean z2) {
        if (m()) {
            return true;
        }
        try {
            byte[] a2 = this.f11639e.a();
            this.f11654t = a2;
            this.f11652r = this.f11639e.d(a2);
            this.f11646l.a($$Lambda$OXR2NUO96KSZa0ouvrVZrZLGcIw.INSTANCE);
            this.f11648n = 3;
            com.google.android.exoplayer2.util.a.b(this.f11654t);
            return true;
        } catch (NotProvisionedException e2) {
            if (z2) {
                this.f11640f.a(this);
                return false;
            }
            c(e2);
            return false;
        } catch (Exception e3) {
            c(e3);
            return false;
        }
    }

    private void b(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.f11640f.a(this);
        } else {
            c(exc);
        }
    }

    /* access modifiers changed from: private */
    public void b(Object obj, Object obj2) {
        g<a> gVar;
        g.a aVar;
        if (obj == this.f11656v && m()) {
            this.f11656v = null;
            if (obj2 instanceof Exception) {
                b((Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f11642h == 3) {
                    this.f11639e.a((byte[]) ad.a(this.f11655u), bArr);
                    gVar = this.f11646l;
                    aVar = $$Lambda$YHzOYgOufFWREBB3uuX8495IGg.INSTANCE;
                } else {
                    byte[] a2 = this.f11639e.a(this.f11654t, bArr);
                    int i2 = this.f11642h;
                    if (!((i2 != 2 && (i2 != 0 || this.f11655u == null)) || a2 == null || a2.length == 0)) {
                        this.f11655u = a2;
                    }
                    this.f11648n = 4;
                    gVar = this.f11646l;
                    aVar = $$Lambda$STMbXyxos9Vjjn6t3Sor4SPEk50.INSTANCE;
                }
                gVar.a((g.a<a>) aVar);
            } catch (Exception e2) {
                b(e2);
            }
        }
    }

    @RequiresNonNull({"sessionId"})
    private void b(boolean z2) {
        if (!this.f11644j) {
            byte[] bArr = (byte[]) ad.a(this.f11654t);
            int i2 = this.f11642h;
            if (i2 == 0 || i2 == 1) {
                if (this.f11655u == null) {
                    a(bArr, 1, z2);
                    return;
                } else if (this.f11648n == 4 || j()) {
                    long k2 = k();
                    if (this.f11642h == 0 && k2 <= 60) {
                        StringBuilder sb = new StringBuilder(88);
                        sb.append("Offline license has expired or will expire soon. Remaining seconds: ");
                        sb.append(k2);
                        k.a("DefaultDrmSession", sb.toString());
                    } else if (k2 <= 0) {
                        c(new KeysExpiredException());
                        return;
                    } else {
                        this.f11648n = 4;
                        this.f11646l.a($$Lambda$YHzOYgOufFWREBB3uuX8495IGg.INSTANCE);
                        return;
                    }
                } else {
                    return;
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    com.google.android.exoplayer2.util.a.b(this.f11655u);
                    com.google.android.exoplayer2.util.a.b(this.f11654t);
                    if (j()) {
                        a(this.f11655u, 3, z2);
                        return;
                    }
                    return;
                }
                return;
            } else if (this.f11655u != null && !j()) {
                return;
            }
            a(bArr, 2, z2);
        }
    }

    private void c(Exception exc) {
        this.f11653s = new DrmSession.DrmSessionException(exc);
        this.f11646l.a(new g.a(exc) {
            public final /* synthetic */ Exception f$0;

            {
                this.f$0 = r1;
            }

            public final void sendTo(Object obj) {
                ((a) obj).a(this.f$0);
            }
        });
        if (this.f11648n != 4) {
            this.f11648n = 1;
        }
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean j() {
        try {
            this.f11639e.b(this.f11654t, this.f11655u);
            return true;
        } catch (Exception e2) {
            k.b("DefaultDrmSession", "Error trying to restore keys.", e2);
            c(e2);
            return false;
        }
    }

    private long k() {
        if (!com.google.android.exoplayer2.e.f15480d.equals(this.f11637c)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) com.google.android.exoplayer2.util.a.b(h.a(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private void l() {
        if (this.f11642h == 0 && this.f11648n == 4) {
            ad.a(this.f11654t);
            b(false);
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean m() {
        int i2 = this.f11648n;
        return i2 == 3 || i2 == 4;
    }

    public void a() {
        this.f11657w = this.f11639e.b();
        ((c) ad.a(this.f11651q)).a(0, com.google.android.exoplayer2.util.a.b(this.f11657w), true);
    }

    public void a(int i2) {
        if (i2 == 2) {
            l();
        }
    }

    public void a(Exception exc) {
        c(exc);
    }

    public boolean a(byte[] bArr) {
        return Arrays.equals(this.f11654t, bArr);
    }

    public void b() {
        if (a(false)) {
            b(true);
        }
    }

    public final int c() {
        return this.f11648n;
    }

    public boolean d() {
        return this.f11643i;
    }

    public final DrmSession.DrmSessionException e() {
        if (this.f11648n == 1) {
            return this.f11653s;
        }
        return null;
    }

    public final T f() {
        return this.f11652r;
    }

    public Map<String, String> g() {
        byte[] bArr = this.f11654t;
        if (bArr == null) {
            return null;
        }
        return this.f11639e.c(bArr);
    }

    public void h() {
        boolean z2 = false;
        com.google.android.exoplayer2.util.a.b(this.f11649o >= 0);
        int i2 = this.f11649o + 1;
        this.f11649o = i2;
        if (i2 == 1) {
            if (this.f11648n == 2) {
                z2 = true;
            }
            com.google.android.exoplayer2.util.a.b(z2);
            HandlerThread handlerThread = new HandlerThread("DrmRequestHandler");
            this.f11650p = handlerThread;
            handlerThread.start();
            this.f11651q = new c(this.f11650p.getLooper());
            if (a(true)) {
                b(true);
            }
        }
    }

    public void i() {
        int i2 = this.f11649o - 1;
        this.f11649o = i2;
        if (i2 == 0) {
            this.f11648n = 0;
            ((e) ad.a(this.f11638d)).removeCallbacksAndMessages((Object) null);
            ((c) ad.a(this.f11651q)).removeCallbacksAndMessages((Object) null);
            this.f11651q = null;
            ((HandlerThread) ad.a(this.f11650p)).quit();
            this.f11650p = null;
            this.f11652r = null;
            this.f11653s = null;
            this.f11656v = null;
            this.f11657w = null;
            byte[] bArr = this.f11654t;
            if (bArr != null) {
                this.f11639e.a(bArr);
                this.f11654t = null;
                this.f11646l.a($$Lambda$eJ5738DaVE_PvRhN3sQ7UUN9iAc.INSTANCE);
            }
            this.f11641g.onSessionReleased(this);
        }
    }
}
