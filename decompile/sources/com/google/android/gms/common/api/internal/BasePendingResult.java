package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.base.zaq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasePendingResult<R extends g> extends e<R> {
    static final ThreadLocal<Boolean> zaa = new cx();
    public static final /* synthetic */ int zad = 0;
    private cz mResultGuardian;
    protected final a<R> zab;
    protected final WeakReference<d> zac;
    private final Object zae;
    private final CountDownLatch zaf;
    private final ArrayList<e.a> zag;
    private h<? super R> zah;
    private final AtomicReference<ck> zai;
    /* access modifiers changed from: private */
    public R zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private i zao;
    private volatile cj<R> zap;
    private boolean zaq;

    public static class a<R extends g> extends zaq {
        public a() {
            super(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        public final void a(h<? super R> hVar, R r2) {
            int i2 = BasePendingResult.zad;
            sendMessage(obtainMessage(1, new Pair((h) m.a(hVar), r2)));
        }

        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                Pair pair = (Pair) message.obj;
                h hVar = (h) pair.first;
                g gVar = (g) pair.second;
                try {
                    hVar.a(gVar);
                } catch (RuntimeException e2) {
                    BasePendingResult.zal(gVar);
                    throw e2;
                }
            } else if (i2 != 2) {
                int i3 = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i3);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.f17377d);
            }
        }
    }

    @Deprecated
    BasePendingResult() {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = new a<>(Looper.getMainLooper());
        this.zac = new WeakReference<>((Object) null);
    }

    @Deprecated
    protected BasePendingResult(Looper looper) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = new a<>(looper);
        this.zac = new WeakReference<>((Object) null);
    }

    protected BasePendingResult(d dVar) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = new a<>(dVar != null ? dVar.a() : Looper.getMainLooper());
        this.zac = new WeakReference<>(dVar);
    }

    protected BasePendingResult(a<R> aVar) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = (a) m.a(aVar, (Object) "CallbackHandler must not be null");
        this.zac = new WeakReference<>((Object) null);
    }

    private final R zaa() {
        R r2;
        synchronized (this.zae) {
            m.b(!this.zal, "Result has already been consumed.");
            m.b(isReady(), "Result is not ready.");
            r2 = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        ck andSet = this.zai.getAndSet((Object) null);
        if (andSet != null) {
            andSet.f17559a.f17561b.remove(this);
        }
        return (g) m.a(r2);
    }

    private final void zab(R r2) {
        this.zaj = r2;
        this.zak = r2.getStatus();
        this.zao = null;
        this.zaf.countDown();
        if (this.zam) {
            this.zah = null;
        } else {
            h<? super R> hVar = this.zah;
            if (hVar != null) {
                this.zab.removeMessages(2);
                this.zab.a(hVar, zaa());
            } else if (this.zaj instanceof f) {
                this.mResultGuardian = new cz(this, (cy) null);
            }
        }
        ArrayList<e.a> arrayList = this.zag;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).a(this.zak);
        }
        this.zag.clear();
    }

    public static void zal(g gVar) {
        if (gVar instanceof f) {
            try {
                ((f) gVar).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(gVar);
                String.valueOf(valueOf).length();
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(valueOf)), e2);
            }
        }
    }

    public final void addStatusListener(e.a aVar) {
        m.a(aVar != null, (Object) "Callback cannot be null.");
        synchronized (this.zae) {
            if (isReady()) {
                aVar.a(this.zak);
            } else {
                this.zag.add(aVar);
            }
        }
    }

    public final R await() {
        m.c("await must not be called on the UI thread");
        boolean z2 = true;
        m.b(!this.zal, "Result has already been consumed");
        if (this.zap != null) {
            z2 = false;
        }
        m.b(z2, "Cannot await if then() has been called.");
        try {
            this.zaf.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f17375b);
        }
        m.b(isReady(), "Result is not ready.");
        return zaa();
    }

    public final R await(long j2, TimeUnit timeUnit) {
        if (j2 > 0) {
            m.c("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z2 = true;
        m.b(!this.zal, "Result has already been consumed.");
        if (this.zap != null) {
            z2 = false;
        }
        m.b(z2, "Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(j2, timeUnit)) {
                forceFailureUnlessReady(Status.f17377d);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f17375b);
        }
        m.b(isReady(), "Result is not ready.");
        return zaa();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|(2:10|11)|12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.zae
            monitor-enter(r0)
            boolean r1 = r2.zam     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0026
            boolean r1 = r2.zal     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0026
        L_0x000c:
            com.google.android.gms.common.internal.i r1 = r2.zao     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0013
            r1.a()     // Catch:{ RemoteException -> 0x0013 }
        L_0x0013:
            R r1 = r2.zaj     // Catch:{ all -> 0x0028 }
            zal(r1)     // Catch:{ all -> 0x0028 }
            r1 = 1
            r2.zam = r1     // Catch:{ all -> 0x0028 }
            com.google.android.gms.common.api.Status r1 = com.google.android.gms.common.api.Status.f17378e     // Catch:{ all -> 0x0028 }
            com.google.android.gms.common.api.g r1 = r2.createFailedResult(r1)     // Catch:{ all -> 0x0028 }
            r2.zab(r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0026:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0028:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.cancel():void");
    }

    /* access modifiers changed from: protected */
    public abstract R createFailedResult(Status status);

    @Deprecated
    public final void forceFailureUnlessReady(Status status) {
        synchronized (this.zae) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zan = true;
            }
        }
    }

    public final boolean isCanceled() {
        boolean z2;
        synchronized (this.zae) {
            z2 = this.zam;
        }
        return z2;
    }

    public final boolean isReady() {
        return this.zaf.getCount() == 0;
    }

    /* access modifiers changed from: protected */
    public final void setCancelToken(i iVar) {
        synchronized (this.zae) {
            this.zao = iVar;
        }
    }

    public final void setResult(R r2) {
        synchronized (this.zae) {
            if (this.zan || this.zam) {
                zal(r2);
                return;
            }
            isReady();
            m.b(!isReady(), "Results have already been set");
            m.b(!this.zal, "Result has already been consumed");
            zab(r2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.h<? super R> r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zae
            monitor-enter(r0)
            if (r5 != 0) goto L_0x000a
            r5 = 0
            r4.zah = r5     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x000a:
            boolean r1 = r4.zal     // Catch:{ all -> 0x003a }
            r2 = 1
            r1 = r1 ^ r2
            java.lang.String r3 = "Result has already been consumed."
            com.google.android.gms.common.internal.m.b(r1, r3)     // Catch:{ all -> 0x003a }
            com.google.android.gms.common.api.internal.cj<R> r1 = r4.zap     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.m.b(r2, r1)     // Catch:{ all -> 0x003a }
            boolean r1 = r4.isCanceled()     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0026
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x0026:
            boolean r1 = r4.isReady()     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0036
            com.google.android.gms.common.api.internal.BasePendingResult$a<R> r1 = r4.zab     // Catch:{ all -> 0x003a }
            com.google.android.gms.common.api.g r2 = r4.zaa()     // Catch:{ all -> 0x003a }
            r1.a(r5, r2)     // Catch:{ all -> 0x003a }
            goto L_0x0038
        L_0x0036:
            r4.zah = r5     // Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.h):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.h<? super R> r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zae
            monitor-enter(r0)
            if (r5 != 0) goto L_0x000a
            r5 = 0
            r4.zah = r5     // Catch:{ all -> 0x0048 }
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000a:
            boolean r1 = r4.zal     // Catch:{ all -> 0x0048 }
            r2 = 1
            r1 = r1 ^ r2
            java.lang.String r3 = "Result has already been consumed."
            com.google.android.gms.common.internal.m.b(r1, r3)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.common.api.internal.cj<R> r1 = r4.zap     // Catch:{ all -> 0x0048 }
            if (r1 != 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.m.b(r2, r1)     // Catch:{ all -> 0x0048 }
            boolean r1 = r4.isCanceled()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0026
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0026:
            boolean r1 = r4.isReady()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0036
            com.google.android.gms.common.api.internal.BasePendingResult$a<R> r6 = r4.zab     // Catch:{ all -> 0x0048 }
            com.google.android.gms.common.api.g r7 = r4.zaa()     // Catch:{ all -> 0x0048 }
            r6.a(r5, r7)     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0036:
            r4.zah = r5     // Catch:{ all -> 0x0048 }
            com.google.android.gms.common.api.internal.BasePendingResult$a<R> r5 = r4.zab     // Catch:{ all -> 0x0048 }
            long r6 = r8.toMillis(r6)     // Catch:{ all -> 0x0048 }
            r8 = 2
            android.os.Message r8 = r5.obtainMessage(r8, r4)     // Catch:{ all -> 0x0048 }
            r5.sendMessageDelayed(r8, r6)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.h, long, java.util.concurrent.TimeUnit):void");
    }

    public final <S extends g> k<S> then(j<? super R, ? extends S> jVar) {
        k<S> a2;
        m.b(!this.zal, "Result has already been consumed.");
        synchronized (this.zae) {
            boolean z2 = false;
            m.b(this.zap == null, "Cannot call then() twice.");
            if (this.zah == null) {
                z2 = true;
            }
            m.b(z2, "Cannot call then() if callbacks are set.");
            m.b(!this.zam, "Cannot call then() if result was canceled.");
            this.zaq = true;
            this.zap = new cj<>(this.zac);
            a2 = this.zap.a(jVar);
            if (isReady()) {
                this.zab.a(this.zap, zaa());
            } else {
                this.zah = this.zap;
            }
        }
        return a2;
    }

    public final void zak() {
        boolean z2 = true;
        if (!this.zaq && !zaa.get().booleanValue()) {
            z2 = false;
        }
        this.zaq = z2;
    }

    public final boolean zam() {
        boolean isCanceled;
        synchronized (this.zae) {
            if (((d) this.zac.get()) == null || !this.zaq) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zan(ck ckVar) {
        this.zai.set(ckVar);
    }
}
