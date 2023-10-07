package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.m;
import gk.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public final class av extends d implements bo {

    /* renamed from: a  reason: collision with root package name */
    final Queue<d.a<?, ?>> f17459a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    zabx f17460b;

    /* renamed from: c  reason: collision with root package name */
    final Map<a.c<?>, a.f> f17461c;

    /* renamed from: d  reason: collision with root package name */
    Set<Scope> f17462d;

    /* renamed from: e  reason: collision with root package name */
    final e f17463e;

    /* renamed from: f  reason: collision with root package name */
    final Map<a<?>, Boolean> f17464f;

    /* renamed from: g  reason: collision with root package name */
    final a.C0118a<? extends f, gk.a> f17465g;

    /* renamed from: h  reason: collision with root package name */
    Set<cj> f17466h;

    /* renamed from: i  reason: collision with root package name */
    final cl f17467i;

    /* renamed from: j  reason: collision with root package name */
    private final Lock f17468j;

    /* renamed from: k  reason: collision with root package name */
    private final ae f17469k;

    /* renamed from: l  reason: collision with root package name */
    private bq f17470l = null;

    /* renamed from: m  reason: collision with root package name */
    private final int f17471m;

    /* renamed from: n  reason: collision with root package name */
    private final Context f17472n;

    /* renamed from: o  reason: collision with root package name */
    private final Looper f17473o;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f17474p;

    /* renamed from: q  reason: collision with root package name */
    private long f17475q;

    /* renamed from: r  reason: collision with root package name */
    private long f17476r;

    /* renamed from: s  reason: collision with root package name */
    private final at f17477s;

    /* renamed from: t  reason: collision with root package name */
    private final c f17478t;

    /* renamed from: u  reason: collision with root package name */
    private final k f17479u;

    /* renamed from: v  reason: collision with root package name */
    private final ArrayList<da> f17480v;

    /* renamed from: w  reason: collision with root package name */
    private Integer f17481w;

    /* renamed from: x  reason: collision with root package name */
    private final ad f17482x;

    public av(Context context, Lock lock, Looper looper, e eVar, c cVar, a.C0118a<? extends f, gk.a> aVar, Map<a<?>, Boolean> map, List<d.b> list, List<d.c> list2, Map<a.c<?>, a.f> map2, int i2, int i3, ArrayList<da> arrayList) {
        Looper looper2 = looper;
        int i4 = i2;
        this.f17475q = true != com.google.android.gms.common.util.c.a() ? 120000 : 10000;
        this.f17476r = 5000;
        this.f17462d = new HashSet();
        this.f17479u = new k();
        this.f17481w = null;
        this.f17466h = null;
        as asVar = new as(this);
        this.f17482x = asVar;
        this.f17472n = context;
        this.f17468j = lock;
        this.f17469k = new ae(looper, asVar);
        this.f17473o = looper2;
        this.f17477s = new at(this, looper);
        this.f17478t = cVar;
        this.f17471m = i4;
        if (i4 >= 0) {
            this.f17481w = Integer.valueOf(i3);
        }
        this.f17464f = map;
        this.f17461c = map2;
        this.f17480v = arrayList;
        this.f17467i = new cl();
        for (d.b a2 : list) {
            this.f17469k.a(a2);
        }
        for (d.c a3 : list2) {
            this.f17469k.a(a3);
        }
        this.f17463e = eVar;
        this.f17465g = aVar;
    }

    public static int a(Iterable<a.f> iterable, boolean z2) {
        boolean z3 = false;
        boolean z4 = false;
        for (a.f next : iterable) {
            z3 |= next.requiresSignIn();
            z4 |= next.providesSignIn();
        }
        if (z3) {
            return (!z4 || !z2) ? 1 : 2;
        }
        return 3;
    }

    static String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    static /* synthetic */ void a(av avVar) {
        avVar.f17468j.lock();
        try {
            if (avVar.f17474p) {
                avVar.i();
            }
        } finally {
            avVar.f17468j.unlock();
        }
    }

    /* JADX WARNING: type inference failed for: r13v11, types: [com.google.android.gms.common.api.internal.u] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(int r13) {
        /*
            r12 = this;
            java.lang.Integer r0 = r12.f17481w
            if (r0 != 0) goto L_0x000b
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12.f17481w = r13
            goto L_0x0011
        L_0x000b:
            int r0 = r0.intValue()
            if (r0 != r13) goto L_0x0091
        L_0x0011:
            com.google.android.gms.common.api.internal.bq r13 = r12.f17470l
            if (r13 == 0) goto L_0x0016
            return
        L_0x0016:
            java.util.Map<com.google.android.gms.common.api.a$c<?>, com.google.android.gms.common.api.a$f> r13 = r12.f17461c
            java.util.Collection r13 = r13.values()
            java.util.Iterator r13 = r13.iterator()
            r0 = 0
            r1 = 0
        L_0x0022:
            boolean r2 = r13.hasNext()
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r13.next()
            com.google.android.gms.common.api.a$f r2 = (com.google.android.gms.common.api.a.f) r2
            boolean r3 = r2.requiresSignIn()
            r0 = r0 | r3
            boolean r2 = r2.providesSignIn()
            r1 = r1 | r2
            goto L_0x0022
        L_0x0039:
            java.lang.Integer r13 = r12.f17481w
            int r13 = r13.intValue()
            r2 = 1
            if (r13 == r2) goto L_0x0062
            r1 = 2
            if (r13 == r1) goto L_0x0046
            goto L_0x0066
        L_0x0046:
            if (r0 == 0) goto L_0x0066
            android.content.Context r2 = r12.f17472n
            java.util.concurrent.locks.Lock r4 = r12.f17468j
            android.os.Looper r5 = r12.f17473o
            com.google.android.gms.common.c r6 = r12.f17478t
            java.util.Map<com.google.android.gms.common.api.a$c<?>, com.google.android.gms.common.api.a$f> r7 = r12.f17461c
            com.google.android.gms.common.internal.e r8 = r12.f17463e
            java.util.Map<com.google.android.gms.common.api.a<?>, java.lang.Boolean> r9 = r12.f17464f
            com.google.android.gms.common.api.a$a<? extends gk.f, gk.a> r10 = r12.f17465g
            java.util.ArrayList<com.google.android.gms.common.api.internal.da> r11 = r12.f17480v
            r3 = r12
            com.google.android.gms.common.api.internal.u r13 = com.google.android.gms.common.api.internal.u.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x005f:
            r12.f17470l = r13
            return
        L_0x0062:
            if (r0 == 0) goto L_0x0089
            if (r1 != 0) goto L_0x0081
        L_0x0066:
            com.google.android.gms.common.api.internal.az r13 = new com.google.android.gms.common.api.internal.az
            android.content.Context r1 = r12.f17472n
            java.util.concurrent.locks.Lock r3 = r12.f17468j
            android.os.Looper r4 = r12.f17473o
            com.google.android.gms.common.c r5 = r12.f17478t
            java.util.Map<com.google.android.gms.common.api.a$c<?>, com.google.android.gms.common.api.a$f> r6 = r12.f17461c
            com.google.android.gms.common.internal.e r7 = r12.f17463e
            java.util.Map<com.google.android.gms.common.api.a<?>, java.lang.Boolean> r8 = r12.f17464f
            com.google.android.gms.common.api.a$a<? extends gk.f, gk.a> r9 = r12.f17465g
            java.util.ArrayList<com.google.android.gms.common.api.internal.da> r10 = r12.f17480v
            r0 = r13
            r2 = r12
            r11 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x005f
        L_0x0081:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead."
            r13.<init>(r0)
            throw r13
        L_0x0089:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead."
            r13.<init>(r0)
            throw r13
        L_0x0091:
            java.lang.String r13 = a((int) r13)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.Integer r1 = r12.f17481w
            int r1 = r1.intValue()
            java.lang.String r1 = a((int) r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r3 = r13.length()
            int r3 = r3 + 51
            int r4 = r1.length()
            int r3 = r3 + r4
            r2.<init>(r3)
            java.lang.String r3 = "Cannot use sign-in mode: "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r13 = ". Mode was already set to "
            r2.append(r13)
            r2.append(r1)
            java.lang.String r13 = r2.toString()
            r0.<init>(r13)
            goto L_0x00ca
        L_0x00c9:
            throw r0
        L_0x00ca:
            goto L_0x00c9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.av.b(int):void");
    }

    static /* synthetic */ void b(av avVar) {
        avVar.f17468j.lock();
        try {
            if (avVar.h()) {
                avVar.i();
            }
        } finally {
            avVar.f17468j.unlock();
        }
    }

    private final void i() {
        this.f17469k.b();
        ((bq) m.a(this.f17470l)).a();
    }

    public final Looper a() {
        return this.f17473o;
    }

    public final <C extends a.f> C a(a.c<C> cVar) {
        C c2 = (a.f) this.f17461c.get(cVar);
        m.a(c2, (Object) "Appropriate Api was not requested.");
        return c2;
    }

    public final <A extends a.b, R extends g, T extends d.a<R, A>> T a(T t2) {
        a<?> api = t2.getApi();
        boolean containsKey = this.f17461c.containsKey(t2.getClientKey());
        String d2 = api != null ? api.d() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(d2);
        sb.append(" required for this call.");
        m.a(containsKey, (Object) sb.toString());
        this.f17468j.lock();
        try {
            bq bqVar = this.f17470l;
            if (bqVar == null) {
                this.f17459a.add(t2);
            } else {
                t2 = bqVar.a(t2);
            }
            return t2;
        } finally {
            this.f17468j.unlock();
        }
    }

    public final void a(int i2, boolean z2) {
        if (i2 == 1) {
            if (!z2 && !this.f17474p) {
                this.f17474p = true;
                if (this.f17460b == null && !com.google.android.gms.common.util.c.a()) {
                    try {
                        this.f17460b = this.f17478t.a(this.f17472n.getApplicationContext(), (bn) new au(this));
                    } catch (SecurityException unused) {
                    }
                }
                at atVar = this.f17477s;
                atVar.sendMessageDelayed(atVar.obtainMessage(1), this.f17475q);
                at atVar2 = this.f17477s;
                atVar2.sendMessageDelayed(atVar2.obtainMessage(2), this.f17476r);
            }
            i2 = 1;
        }
        for (BasePendingResult forceFailureUnlessReady : (BasePendingResult[]) this.f17467i.f17561b.toArray(new BasePendingResult[0])) {
            forceFailureUnlessReady.forceFailureUnlessReady(cl.f17560a);
        }
        this.f17469k.a(i2);
        this.f17469k.a();
        if (i2 == 2) {
            i();
        }
    }

    public final void a(Bundle bundle) {
        while (!this.f17459a.isEmpty()) {
            b(this.f17459a.remove());
        }
        this.f17469k.a(bundle);
    }

    public final void a(ConnectionResult connectionResult) {
        if (!this.f17478t.c(this.f17472n, connectionResult.a())) {
            h();
        }
        if (!this.f17474p) {
            this.f17469k.a(connectionResult);
            this.f17469k.a();
        }
    }

    public final void a(d.c cVar) {
        this.f17469k.a(cVar);
    }

    public final void a(cj cjVar) {
        this.f17468j.lock();
        try {
            if (this.f17466h == null) {
                this.f17466h = new HashSet();
            }
            this.f17466h.add(cjVar);
        } finally {
            this.f17468j.unlock();
        }
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f17472n);
        printWriter.append(str).append("mResuming=").print(this.f17474p);
        printWriter.append(" mWorkQueue.size()=").print(this.f17459a.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f17467i.f17561b.size());
        bq bqVar = this.f17470l;
        if (bqVar != null) {
            bqVar.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends a.b, T extends d.a<? extends g, A>> T b(T t2) {
        a<?> api = t2.getApi();
        boolean containsKey = this.f17461c.containsKey(t2.getClientKey());
        String d2 = api != null ? api.d() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(d2);
        sb.append(" required for this call.");
        m.a(containsKey, (Object) sb.toString());
        this.f17468j.lock();
        try {
            bq bqVar = this.f17470l;
            if (bqVar != null) {
                if (this.f17474p) {
                    this.f17459a.add(t2);
                    while (!this.f17459a.isEmpty()) {
                        d.a remove = this.f17459a.remove();
                        this.f17467i.a(remove);
                        remove.setFailedResult(Status.f17376c);
                    }
                } else {
                    t2 = bqVar.b(t2);
                }
                return t2;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } finally {
            this.f17468j.unlock();
        }
    }

    public final void b() {
        this.f17468j.lock();
        try {
            int i2 = 2;
            boolean z2 = false;
            if (this.f17471m >= 0) {
                m.b(this.f17481w != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f17481w;
                if (num == null) {
                    this.f17481w = Integer.valueOf(a((Iterable<a.f>) this.f17461c.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = ((Integer) m.a(this.f17481w)).intValue();
            this.f17468j.lock();
            if (intValue == 3 || intValue == 1) {
                i2 = intValue;
            } else if (intValue != 2) {
                i2 = intValue;
                StringBuilder sb = new StringBuilder(33);
                sb.append("Illegal sign-in mode: ");
                sb.append(i2);
                m.a(z2, (Object) sb.toString());
                b(i2);
                i();
            }
            z2 = true;
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("Illegal sign-in mode: ");
            sb2.append(i2);
            m.a(z2, (Object) sb2.toString());
            b(i2);
            i();
        } catch (Throwable th) {
            throw th;
        } finally {
            this.f17468j.unlock();
        }
    }

    public final void b(d.c cVar) {
        this.f17469k.b(cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        if (r3 == false) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.gms.common.api.internal.cj r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.f17468j
            r0.lock()
            java.util.Set<com.google.android.gms.common.api.internal.cj> r0 = r2.f17466h     // Catch:{ all -> 0x0054 }
            java.lang.String r1 = "GoogleApiClientImpl"
            if (r0 != 0) goto L_0x0016
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0054 }
            r3.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = "Attempted to remove pending transform when no transforms are registered."
        L_0x0012:
            android.util.Log.wtf(r1, r0, r3)     // Catch:{ all -> 0x0054 }
            goto L_0x0047
        L_0x0016:
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0024
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0054 }
            r3.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = "Failed to remove pending transform - this may lead to memory leaks!"
            goto L_0x0012
        L_0x0024:
            java.util.concurrent.locks.Lock r3 = r2.f17468j     // Catch:{ all -> 0x0054 }
            r3.lock()     // Catch:{ all -> 0x0054 }
            java.util.Set<com.google.android.gms.common.api.internal.cj> r3 = r2.f17466h     // Catch:{ all -> 0x004d }
            if (r3 != 0) goto L_0x0033
            java.util.concurrent.locks.Lock r3 = r2.f17468j     // Catch:{ all -> 0x0054 }
            r3.unlock()     // Catch:{ all -> 0x0054 }
            goto L_0x0040
        L_0x0033:
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x004d }
            r3 = r3 ^ 1
            java.util.concurrent.locks.Lock r0 = r2.f17468j     // Catch:{ all -> 0x0054 }
            r0.unlock()     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0047
        L_0x0040:
            com.google.android.gms.common.api.internal.bq r3 = r2.f17470l     // Catch:{ all -> 0x0054 }
            if (r3 == 0) goto L_0x0047
            r3.c()     // Catch:{ all -> 0x0054 }
        L_0x0047:
            java.util.concurrent.locks.Lock r3 = r2.f17468j
            r3.unlock()
            return
        L_0x004d:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.f17468j     // Catch:{ all -> 0x0054 }
            r0.unlock()     // Catch:{ all -> 0x0054 }
            throw r3     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.f17468j
            r0.unlock()
            goto L_0x005c
        L_0x005b:
            throw r3
        L_0x005c:
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.av.b(com.google.android.gms.common.api.internal.cj):void");
    }

    public final void c() {
        this.f17468j.lock();
        try {
            this.f17467i.a();
            bq bqVar = this.f17470l;
            if (bqVar != null) {
                bqVar.b();
            }
            this.f17479u.a();
            for (d.a aVar : this.f17459a) {
                aVar.zan((ck) null);
                aVar.cancel();
            }
            this.f17459a.clear();
            if (this.f17470l != null) {
                h();
                this.f17469k.a();
            }
        } finally {
            this.f17468j.unlock();
        }
    }

    public final boolean d() {
        bq bqVar = this.f17470l;
        return bqVar != null && bqVar.d();
    }

    public final boolean e() {
        bq bqVar = this.f17470l;
        return bqVar != null && bqVar.e();
    }

    /* access modifiers changed from: package-private */
    public final String g() {
        StringWriter stringWriter = new StringWriter();
        a("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    /* access modifiers changed from: package-private */
    public final boolean h() {
        if (!this.f17474p) {
            return false;
        }
        this.f17474p = false;
        this.f17477s.removeMessages(2);
        this.f17477s.removeMessages(1);
        zabx zabx = this.f17460b;
        if (zabx != null) {
            zabx.a();
            this.f17460b = null;
        }
        return true;
    }
}
