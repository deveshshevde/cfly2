package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.f;
import com.google.android.gms.common.util.n;
import com.google.android.gms.common.util.o;
import com.google.android.gms.internal.stats.zzb;
import com.google.android.gms.internal.stats.zzc;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static final long f18341b = TimeUnit.DAYS.toMillis(366);

    /* renamed from: c  reason: collision with root package name */
    private static volatile ScheduledExecutorService f18342c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f18343d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static volatile e f18344e = new c();

    /* renamed from: a  reason: collision with root package name */
    zzb f18345a;

    /* renamed from: f  reason: collision with root package name */
    private final Object f18346f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private final PowerManager.WakeLock f18347g;

    /* renamed from: h  reason: collision with root package name */
    private int f18348h = 0;

    /* renamed from: i  reason: collision with root package name */
    private Future<?> f18349i;

    /* renamed from: j  reason: collision with root package name */
    private long f18350j;

    /* renamed from: k  reason: collision with root package name */
    private final Set<f> f18351k = new HashSet();

    /* renamed from: l  reason: collision with root package name */
    private boolean f18352l = true;

    /* renamed from: m  reason: collision with root package name */
    private int f18353m;

    /* renamed from: n  reason: collision with root package name */
    private d f18354n = f.c();

    /* renamed from: o  reason: collision with root package name */
    private WorkSource f18355o;

    /* renamed from: p  reason: collision with root package name */
    private final String f18356p;

    /* renamed from: q  reason: collision with root package name */
    private final String f18357q;

    /* renamed from: r  reason: collision with root package name */
    private final Context f18358r;

    /* renamed from: s  reason: collision with root package name */
    private final Map<String, d> f18359s = new HashMap();

    /* renamed from: t  reason: collision with root package name */
    private AtomicInteger f18360t = new AtomicInteger(0);

    /* renamed from: u  reason: collision with root package name */
    private final ScheduledExecutorService f18361u;

    public a(Context context, int i2, String str) {
        String packageName = context.getPackageName();
        m.a(context, (Object) "WakeLock: context must not be null");
        m.a(str, (Object) "WakeLock: wakeLockName must not be empty");
        this.f18358r = context.getApplicationContext();
        this.f18357q = str;
        this.f18345a = null;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.f18356p = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.f18356p = str;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("expected a non-null reference", 0, 29);
            throw new zzi(sb.toString());
        }
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i2, str);
        this.f18347g = newWakeLock;
        if (o.a(context)) {
            WorkSource a2 = o.a(context, n.a(packageName) ? context.getPackageName() : packageName);
            this.f18355o = a2;
            if (a2 != null) {
                a(newWakeLock, a2);
            }
        }
        ScheduledExecutorService scheduledExecutorService = f18342c;
        if (scheduledExecutorService == null) {
            synchronized (f18343d) {
                scheduledExecutorService = f18342c;
                if (scheduledExecutorService == null) {
                    zzh.zza();
                    scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                    f18342c = scheduledExecutorService;
                }
            }
        }
        this.f18361u = scheduledExecutorService;
    }

    private final String a(String str) {
        if (!this.f18352l || !TextUtils.isEmpty((CharSequence) null)) {
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
        if (r5.f18345a != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        r5.f18345a = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0084, code lost:
        if (r5.f18345a != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a1, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(int r6) {
        /*
            r5 = this;
            java.lang.Object r6 = r5.f18346f
            monitor-enter(r6)
            boolean r0 = r5.b()     // Catch:{ all -> 0x00a2 }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r6)     // Catch:{ all -> 0x00a2 }
            return
        L_0x000b:
            boolean r0 = r5.f18352l     // Catch:{ all -> 0x00a2 }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            int r0 = r5.f18348h     // Catch:{ all -> 0x00a2 }
            int r0 = r0 + -1
            r5.f18348h = r0     // Catch:{ all -> 0x00a2 }
            if (r0 > 0) goto L_0x0019
            goto L_0x001d
        L_0x0019:
            monitor-exit(r6)     // Catch:{ all -> 0x00a2 }
            return
        L_0x001b:
            r5.f18348h = r1     // Catch:{ all -> 0x00a2 }
        L_0x001d:
            r5.c()     // Catch:{ all -> 0x00a2 }
            java.util.Map<java.lang.String, com.google.android.gms.stats.d> r0 = r5.f18359s     // Catch:{ all -> 0x00a2 }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x00a2 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a2 }
        L_0x002a:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00a2 }
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.stats.d r2 = (com.google.android.gms.stats.d) r2     // Catch:{ all -> 0x00a2 }
            r2.f18363a = r1     // Catch:{ all -> 0x00a2 }
            goto L_0x002a
        L_0x0039:
            java.util.Map<java.lang.String, com.google.android.gms.stats.d> r0 = r5.f18359s     // Catch:{ all -> 0x00a2 }
            r0.clear()     // Catch:{ all -> 0x00a2 }
            java.util.concurrent.Future<?> r0 = r5.f18349i     // Catch:{ all -> 0x00a2 }
            r2 = 0
            if (r0 == 0) goto L_0x004c
            r0.cancel(r1)     // Catch:{ all -> 0x00a2 }
            r5.f18349i = r2     // Catch:{ all -> 0x00a2 }
            r3 = 0
            r5.f18350j = r3     // Catch:{ all -> 0x00a2 }
        L_0x004c:
            r5.f18353m = r1     // Catch:{ all -> 0x00a2 }
            android.os.PowerManager$WakeLock r0 = r5.f18347g     // Catch:{ all -> 0x00a2 }
            boolean r0 = r0.isHeld()     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x008f
            android.os.PowerManager$WakeLock r0 = r5.f18347g     // Catch:{ RuntimeException -> 0x0064 }
            r0.release()     // Catch:{ RuntimeException -> 0x0064 }
            com.google.android.gms.internal.stats.zzb r0 = r5.f18345a     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x00a0
        L_0x005f:
            r5.f18345a = r2     // Catch:{ all -> 0x00a2 }
            goto L_0x00a0
        L_0x0062:
            r0 = move-exception
            goto L_0x0088
        L_0x0064:
            r0 = move-exception
            java.lang.Class r1 = r0.getClass()     // Catch:{ all -> 0x0062 }
            java.lang.Class<java.lang.RuntimeException> r3 = java.lang.RuntimeException.class
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0087
            java.lang.String r1 = "WakeLock"
            java.lang.String r3 = r5.f18356p     // Catch:{ all -> 0x0062 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = " failed to release!"
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x0062 }
            android.util.Log.e(r1, r3, r0)     // Catch:{ all -> 0x0062 }
            com.google.android.gms.internal.stats.zzb r0 = r5.f18345a     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x00a0
            goto L_0x005f
        L_0x0087:
            throw r0     // Catch:{ all -> 0x0062 }
        L_0x0088:
            com.google.android.gms.internal.stats.zzb r1 = r5.f18345a     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x008e
            r5.f18345a = r2     // Catch:{ all -> 0x00a2 }
        L_0x008e:
            throw r0     // Catch:{ all -> 0x00a2 }
        L_0x008f:
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r5.f18356p     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = " should be held!"
            java.lang.String r1 = r1.concat(r2)     // Catch:{ all -> 0x00a2 }
            android.util.Log.e(r0, r1)     // Catch:{ all -> 0x00a2 }
        L_0x00a0:
            monitor-exit(r6)     // Catch:{ all -> 0x00a2 }
            return
        L_0x00a2:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00a2 }
            goto L_0x00a6
        L_0x00a5:
            throw r0
        L_0x00a6:
            goto L_0x00a5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.a.a(int):void");
    }

    private static void a(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
            Log.wtf("WakeLock", e2.toString());
        }
    }

    public static /* synthetic */ void a(a aVar) {
        synchronized (aVar.f18346f) {
            if (aVar.b()) {
                Log.e("WakeLock", String.valueOf(aVar.f18356p).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                aVar.c();
                if (aVar.b()) {
                    aVar.f18348h = 1;
                    aVar.a(0);
                }
            }
        }
    }

    private final void c() {
        if (!this.f18351k.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.f18351k);
            this.f18351k.clear();
            if (arrayList.size() > 0) {
                f fVar = (f) arrayList.get(0);
                throw null;
            }
        }
    }

    public void a() {
        if (this.f18360t.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f18356p).concat(" release without a matched acquire!"));
        }
        synchronized (this.f18346f) {
            a((String) null);
            if (this.f18359s.containsKey((Object) null)) {
                d dVar = this.f18359s.get((Object) null);
                if (dVar != null) {
                    int i2 = dVar.f18363a - 1;
                    dVar.f18363a = i2;
                    if (i2 == 0) {
                        this.f18359s.remove((Object) null);
                    }
                }
            } else {
                Log.w("WakeLock", String.valueOf(this.f18356p).concat(" counter does not exist"));
            }
            a(0);
        }
    }

    public void a(long j2) {
        this.f18360t.incrementAndGet();
        long j3 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, f18341b), 1);
        if (j2 > 0) {
            max = Math.min(j2, max);
        }
        synchronized (this.f18346f) {
            if (!b()) {
                this.f18345a = zzb.zza(false, (zzc) null);
                this.f18347g.acquire();
                this.f18354n.b();
            }
            this.f18348h++;
            this.f18353m++;
            a((String) null);
            d dVar = this.f18359s.get((Object) null);
            if (dVar == null) {
                dVar = new d((c) null);
                this.f18359s.put((Object) null, dVar);
            }
            dVar.f18363a++;
            long b2 = this.f18354n.b();
            if (Long.MAX_VALUE - b2 > max) {
                j3 = b2 + max;
            }
            if (j3 > this.f18350j) {
                this.f18350j = j3;
                Future<?> future = this.f18349i;
                if (future != null) {
                    future.cancel(false);
                }
                this.f18349i = this.f18361u.schedule(new b(this), max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void a(boolean z2) {
        synchronized (this.f18346f) {
            this.f18352l = z2;
        }
    }

    public boolean b() {
        boolean z2;
        synchronized (this.f18346f) {
            z2 = this.f18348h > 0;
        }
        return z2;
    }
}
