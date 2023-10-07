package com.google.android.exoplayer2.upstream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.google.android.exoplayer2.upstream.c;
import com.google.android.exoplayer2.upstream.j;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.v;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class j implements c, t {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, int[]> f17012a = d();

    /* renamed from: b  reason: collision with root package name */
    public static final long[] f17013b = {5800000, 3500000, 1900000, 1000000, 520000};

    /* renamed from: c  reason: collision with root package name */
    public static final long[] f17014c = {204000, 154000, 139000, 122000, 102000};

    /* renamed from: d  reason: collision with root package name */
    public static final long[] f17015d = {2200000, 1150000, 810000, 640000, 450000};

    /* renamed from: e  reason: collision with root package name */
    public static final long[] f17016e = {4900000, 2300000, 1500000, 970000, 540000};

    /* renamed from: f  reason: collision with root package name */
    private static j f17017f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f17018g;

    /* renamed from: h  reason: collision with root package name */
    private final SparseArray<Long> f17019h;

    /* renamed from: i  reason: collision with root package name */
    private final g<c.a> f17020i;

    /* renamed from: j  reason: collision with root package name */
    private final v f17021j;

    /* renamed from: k  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.b f17022k;

    /* renamed from: l  reason: collision with root package name */
    private int f17023l;

    /* renamed from: m  reason: collision with root package name */
    private long f17024m;

    /* renamed from: n  reason: collision with root package name */
    private long f17025n;

    /* renamed from: o  reason: collision with root package name */
    private int f17026o;

    /* renamed from: p  reason: collision with root package name */
    private long f17027p;

    /* renamed from: q  reason: collision with root package name */
    private long f17028q;

    /* renamed from: r  reason: collision with root package name */
    private long f17029r;

    /* renamed from: s  reason: collision with root package name */
    private long f17030s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f17031t;

    /* renamed from: u  reason: collision with root package name */
    private int f17032u;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f17033a;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Long> f17034b;

        /* renamed from: c  reason: collision with root package name */
        private int f17035c;

        /* renamed from: d  reason: collision with root package name */
        private com.google.android.exoplayer2.util.b f17036d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f17037e;

        public a(Context context) {
            this.f17033a = context == null ? null : context.getApplicationContext();
            this.f17034b = a(ad.b(context));
            this.f17035c = GSYVideoView.CHANGE_DELAY_TIME;
            this.f17036d = com.google.android.exoplayer2.util.b.f17099a;
            this.f17037e = true;
        }

        private static SparseArray<Long> a(String str) {
            int[] b2 = b(str);
            SparseArray<Long> sparseArray = new SparseArray<>(6);
            sparseArray.append(0, 1000000L);
            sparseArray.append(2, Long.valueOf(j.f17013b[b2[0]]));
            sparseArray.append(3, Long.valueOf(j.f17014c[b2[1]]));
            sparseArray.append(4, Long.valueOf(j.f17015d[b2[2]]));
            sparseArray.append(5, Long.valueOf(j.f17016e[b2[3]]));
            sparseArray.append(7, Long.valueOf(j.f17013b[b2[0]]));
            sparseArray.append(9, Long.valueOf(j.f17016e[b2[3]]));
            return sparseArray;
        }

        private static int[] b(String str) {
            int[] iArr = j.f17012a.get(str);
            return iArr == null ? new int[]{2, 2, 2, 2} : iArr;
        }

        public j a() {
            return new j(this.f17033a, this.f17034b, this.f17035c, this.f17036d, this.f17037e);
        }
    }

    private static class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static b f17038a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f17039b = new Handler(Looper.getMainLooper());

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<WeakReference<j>> f17040c = new ArrayList<>();

        private b() {
        }

        public static synchronized b a(Context context) {
            b bVar;
            synchronized (b.class) {
                if (f17038a == null) {
                    f17038a = new b();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    context.registerReceiver(f17038a, intentFilter);
                }
                bVar = f17038a;
            }
            return bVar;
        }

        private void a() {
            for (int size = this.f17040c.size() - 1; size >= 0; size--) {
                if (((j) this.f17040c.get(size).get()) == null) {
                    this.f17040c.remove(size);
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void c(j jVar) {
            jVar.c();
        }

        public synchronized void a(j jVar) {
            a();
            this.f17040c.add(new WeakReference(jVar));
            this.f17039b.post(new Runnable(jVar) {
                public final /* synthetic */ j f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    j.b.this.c(this.f$1);
                }
            });
        }

        public synchronized void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                a();
                for (int i2 = 0; i2 < this.f17040c.size(); i2++) {
                    j jVar = (j) this.f17040c.get(i2).get();
                    if (jVar != null) {
                        c(jVar);
                    }
                }
            }
        }
    }

    @Deprecated
    public j() {
        this((Context) null, new SparseArray(), GSYVideoView.CHANGE_DELAY_TIME, com.google.android.exoplayer2.util.b.f17099a, false);
    }

    private j(Context context, SparseArray<Long> sparseArray, int i2, com.google.android.exoplayer2.util.b bVar, boolean z2) {
        this.f17018g = context == null ? null : context.getApplicationContext();
        this.f17019h = sparseArray;
        this.f17020i = new g<>();
        this.f17021j = new v(i2);
        this.f17022k = bVar;
        int a2 = context == null ? 0 : ad.a(context);
        this.f17026o = a2;
        this.f17029r = a(a2);
        if (context != null && z2) {
            b.a(context).a(this);
        }
    }

    private long a(int i2) {
        Long l2 = this.f17019h.get(i2);
        if (l2 == null) {
            l2 = this.f17019h.get(0);
        }
        if (l2 == null) {
            l2 = 1000000L;
        }
        return l2.longValue();
    }

    public static synchronized j a(Context context) {
        j jVar;
        synchronized (j.class) {
            if (f17017f == null) {
                f17017f = new a(context).a();
            }
            jVar = f17017f;
        }
        return jVar;
    }

    private void a(int i2, long j2, long j3) {
        if (i2 != 0 || j2 != 0 || j3 != this.f17030s) {
            this.f17030s = j3;
            this.f17020i.a(new g.a(i2, j2, j3) {
                public final /* synthetic */ int f$0;
                public final /* synthetic */ long f$1;
                public final /* synthetic */ long f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r4;
                }

                public final void sendTo(Object obj) {
                    ((c.a) obj).b(this.f$0, this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c() {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r10.f17031t     // Catch:{ all -> 0x0058 }
            r1 = 0
            if (r0 == 0) goto L_0x0009
            int r0 = r10.f17032u     // Catch:{ all -> 0x0058 }
            goto L_0x0013
        L_0x0009:
            android.content.Context r0 = r10.f17018g     // Catch:{ all -> 0x0058 }
            if (r0 != 0) goto L_0x000f
            r0 = 0
            goto L_0x0013
        L_0x000f:
            int r0 = com.google.android.exoplayer2.util.ad.a((android.content.Context) r0)     // Catch:{ all -> 0x0058 }
        L_0x0013:
            int r2 = r10.f17026o     // Catch:{ all -> 0x0058 }
            if (r2 != r0) goto L_0x0019
            monitor-exit(r10)
            return
        L_0x0019:
            r10.f17026o = r0     // Catch:{ all -> 0x0058 }
            r2 = 1
            if (r0 == r2) goto L_0x0056
            if (r0 == 0) goto L_0x0056
            r2 = 8
            if (r0 != r2) goto L_0x0025
            goto L_0x0056
        L_0x0025:
            long r2 = r10.a((int) r0)     // Catch:{ all -> 0x0058 }
            r10.f17029r = r2     // Catch:{ all -> 0x0058 }
            com.google.android.exoplayer2.util.b r0 = r10.f17022k     // Catch:{ all -> 0x0058 }
            long r2 = r0.a()     // Catch:{ all -> 0x0058 }
            int r0 = r10.f17023l     // Catch:{ all -> 0x0058 }
            if (r0 <= 0) goto L_0x003c
            long r0 = r10.f17024m     // Catch:{ all -> 0x0058 }
            long r0 = r2 - r0
            int r1 = (int) r0     // Catch:{ all -> 0x0058 }
            r5 = r1
            goto L_0x003d
        L_0x003c:
            r5 = 0
        L_0x003d:
            long r6 = r10.f17025n     // Catch:{ all -> 0x0058 }
            long r8 = r10.f17029r     // Catch:{ all -> 0x0058 }
            r4 = r10
            r4.a((int) r5, (long) r6, (long) r8)     // Catch:{ all -> 0x0058 }
            r10.f17024m = r2     // Catch:{ all -> 0x0058 }
            r0 = 0
            r10.f17025n = r0     // Catch:{ all -> 0x0058 }
            r10.f17028q = r0     // Catch:{ all -> 0x0058 }
            r10.f17027p = r0     // Catch:{ all -> 0x0058 }
            com.google.android.exoplayer2.util.v r0 = r10.f17021j     // Catch:{ all -> 0x0058 }
            r0.a()     // Catch:{ all -> 0x0058 }
            monitor-exit(r10)
            return
        L_0x0056:
            monitor-exit(r10)
            return
        L_0x0058:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.j.c():void");
    }

    private static Map<String, int[]> d() {
        HashMap hashMap = new HashMap();
        hashMap.put("AD", new int[]{0, 2, 0, 0});
        hashMap.put("AE", new int[]{2, 4, 4, 4});
        hashMap.put("AF", new int[]{4, 4, 3, 3});
        hashMap.put("AG", new int[]{4, 2, 2, 3});
        hashMap.put("AI", new int[]{0, 3, 2, 4});
        hashMap.put("AL", new int[]{1, 2, 0, 1});
        hashMap.put("AM", new int[]{2, 2, 1, 2});
        hashMap.put("AO", new int[]{3, 4, 3, 1});
        hashMap.put("AQ", new int[]{4, 2, 2, 2});
        hashMap.put("AR", new int[]{2, 3, 1, 2});
        hashMap.put("AS", new int[]{2, 2, 4, 2});
        hashMap.put("AT", new int[]{0, 3, 0, 0});
        hashMap.put("AU", new int[]{0, 2, 0, 1});
        hashMap.put("AW", new int[]{1, 1, 2, 4});
        hashMap.put("AX", new int[]{0, 1, 0, 0});
        hashMap.put("AZ", new int[]{3, 3, 3, 3});
        hashMap.put("BA", new int[]{1, 1, 0, 1});
        hashMap.put("BB", new int[]{0, 3, 0, 0});
        hashMap.put("BD", new int[]{2, 0, 4, 3});
        hashMap.put("BE", new int[]{0, 1, 2, 3});
        hashMap.put("BF", new int[]{4, 4, 4, 1});
        hashMap.put("BG", new int[]{0, 1, 0, 0});
        hashMap.put("BH", new int[]{1, 0, 3, 4});
        hashMap.put("BI", new int[]{4, 4, 4, 4});
        hashMap.put("BJ", new int[]{4, 4, 3, 4});
        hashMap.put("BL", new int[]{1, 0, 4, 3});
        hashMap.put("BM", new int[]{0, 1, 0, 0});
        hashMap.put("BN", new int[]{4, 0, 2, 4});
        hashMap.put("BO", new int[]{1, 3, 3, 3});
        hashMap.put("BQ", new int[]{1, 0, 1, 0});
        hashMap.put("BR", new int[]{2, 4, 3, 1});
        hashMap.put("BS", new int[]{3, 1, 1, 3});
        hashMap.put("BT", new int[]{3, 0, 3, 1});
        hashMap.put("BW", new int[]{3, 4, 3, 3});
        hashMap.put("BY", new int[]{0, 1, 1, 1});
        hashMap.put("BZ", new int[]{1, 3, 2, 1});
        hashMap.put("CA", new int[]{0, 3, 2, 2});
        hashMap.put("CD", new int[]{3, 4, 2, 2});
        hashMap.put("CF", new int[]{4, 3, 2, 2});
        hashMap.put("CG", new int[]{3, 4, 1, 1});
        hashMap.put("CH", new int[]{0, 0, 0, 0});
        hashMap.put("CI", new int[]{3, 4, 3, 3});
        hashMap.put("CK", new int[]{2, 0, 1, 0});
        hashMap.put("CL", new int[]{1, 2, 2, 3});
        hashMap.put("CM", new int[]{3, 4, 3, 2});
        hashMap.put("CN", new int[]{1, 0, 1, 1});
        hashMap.put("CO", new int[]{2, 3, 3, 2});
        hashMap.put("CR", new int[]{2, 2, 4, 4});
        hashMap.put("CU", new int[]{4, 4, 2, 1});
        hashMap.put("CV", new int[]{2, 3, 3, 2});
        hashMap.put("CW", new int[]{1, 1, 0, 0});
        hashMap.put("CY", new int[]{1, 1, 0, 0});
        hashMap.put("CZ", new int[]{0, 1, 0, 0});
        hashMap.put("DE", new int[]{0, 1, 2, 3});
        hashMap.put("DJ", new int[]{4, 2, 4, 4});
        hashMap.put("DK", new int[]{0, 0, 1, 0});
        hashMap.put("DM", new int[]{1, 1, 0, 2});
        hashMap.put("DO", new int[]{3, 3, 4, 4});
        hashMap.put("DZ", new int[]{3, 3, 4, 4});
        hashMap.put("EC", new int[]{2, 3, 4, 2});
        hashMap.put("EE", new int[]{0, 0, 0, 0});
        hashMap.put("EG", new int[]{3, 4, 2, 1});
        hashMap.put("EH", new int[]{2, 0, 3, 1});
        hashMap.put("ER", new int[]{4, 2, 4, 4});
        hashMap.put("ES", new int[]{0, 1, 1, 1});
        hashMap.put("ET", new int[]{4, 4, 4, 1});
        hashMap.put("FI", new int[]{0, 0, 1, 0});
        hashMap.put("FJ", new int[]{3, 0, 4, 4});
        hashMap.put("FK", new int[]{2, 2, 2, 1});
        hashMap.put("FM", new int[]{3, 2, 4, 1});
        hashMap.put("FO", new int[]{1, 1, 0, 0});
        hashMap.put("FR", new int[]{1, 1, 1, 1});
        hashMap.put("GA", new int[]{3, 2, 2, 2});
        hashMap.put("GB", new int[]{0, 1, 1, 1});
        hashMap.put("GD", new int[]{1, 1, 3, 1});
        hashMap.put("GE", new int[]{1, 0, 1, 4});
        hashMap.put("GF", new int[]{2, 0, 1, 3});
        hashMap.put("GG", new int[]{1, 0, 0, 0});
        hashMap.put("GH", new int[]{3, 3, 3, 3});
        hashMap.put("GI", new int[]{4, 4, 0, 0});
        hashMap.put("GL", new int[]{2, 1, 1, 2});
        hashMap.put("GM", new int[]{4, 3, 2, 4});
        hashMap.put("GN", new int[]{3, 4, 4, 2});
        hashMap.put("GP", new int[]{2, 1, 3, 4});
        hashMap.put("GQ", new int[]{4, 4, 4, 0});
        hashMap.put("GR", new int[]{1, 1, 0, 1});
        hashMap.put("GT", new int[]{3, 2, 2, 2});
        hashMap.put("GU", new int[]{1, 0, 2, 2});
        hashMap.put("GW", new int[]{3, 4, 4, 3});
        hashMap.put("GY", new int[]{3, 2, 1, 1});
        hashMap.put("HK", new int[]{0, 2, 3, 4});
        hashMap.put("HN", new int[]{3, 1, 3, 3});
        hashMap.put("HR", new int[]{1, 1, 0, 1});
        hashMap.put("HT", new int[]{4, 4, 4, 4});
        hashMap.put("HU", new int[]{0, 1, 0, 0});
        hashMap.put("ID", new int[]{2, 2, 2, 3});
        hashMap.put("IE", new int[]{1, 0, 1, 1});
        hashMap.put("IL", new int[]{1, 0, 2, 3});
        hashMap.put("IM", new int[]{0, 0, 0, 1});
        hashMap.put("IN", new int[]{2, 2, 4, 3});
        hashMap.put("IO", new int[]{4, 4, 2, 3});
        hashMap.put("IQ", new int[]{3, 3, 4, 2});
        hashMap.put("IR", new int[]{3, 0, 2, 1});
        hashMap.put("IS", new int[]{0, 1, 0, 0});
        hashMap.put("IT", new int[]{1, 1, 1, 2});
        hashMap.put("JE", new int[]{1, 0, 0, 1});
        hashMap.put("JM", new int[]{3, 3, 3, 4});
        hashMap.put("JO", new int[]{1, 2, 1, 1});
        hashMap.put("JP", new int[]{0, 2, 0, 0});
        hashMap.put("KE", new int[]{3, 4, 3, 3});
        hashMap.put("KG", new int[]{2, 0, 2, 2});
        hashMap.put("KH", new int[]{1, 0, 4, 3});
        hashMap.put("KI", new int[]{4, 4, 4, 0});
        hashMap.put("KM", new int[]{4, 3, 2, 4});
        hashMap.put("KN", new int[]{1, 0, 2, 4});
        hashMap.put("KP", new int[]{4, 2, 0, 2});
        hashMap.put("KR", new int[]{0, 1, 0, 1});
        hashMap.put("KW", new int[]{2, 3, 1, 2});
        hashMap.put("KY", new int[]{3, 1, 2, 3});
        hashMap.put("KZ", new int[]{1, 2, 2, 2});
        hashMap.put("LA", new int[]{2, 2, 1, 1});
        hashMap.put("LB", new int[]{3, 2, 0, 0});
        hashMap.put("LC", new int[]{1, 1, 0, 0});
        hashMap.put("LI", new int[]{0, 0, 1, 1});
        hashMap.put("LK", new int[]{2, 0, 2, 3});
        hashMap.put("LR", new int[]{3, 4, 4, 2});
        hashMap.put("LS", new int[]{3, 3, 2, 2});
        hashMap.put("LT", new int[]{0, 0, 0, 0});
        hashMap.put("LU", new int[]{0, 0, 0, 0});
        hashMap.put("LV", new int[]{0, 0, 0, 0});
        hashMap.put("LY", new int[]{3, 3, 4, 3});
        hashMap.put("MA", new int[]{3, 2, 3, 2});
        hashMap.put("MC", new int[]{0, 4, 0, 0});
        hashMap.put("MD", new int[]{1, 1, 0, 0});
        hashMap.put("ME", new int[]{1, 3, 1, 2});
        hashMap.put("MF", new int[]{2, 3, 1, 1});
        hashMap.put("MG", new int[]{3, 4, 2, 3});
        hashMap.put("MH", new int[]{4, 0, 2, 4});
        hashMap.put("MK", new int[]{1, 0, 0, 0});
        hashMap.put("ML", new int[]{4, 4, 2, 0});
        hashMap.put("MM", new int[]{3, 3, 2, 2});
        hashMap.put("MN", new int[]{2, 3, 1, 1});
        hashMap.put("MO", new int[]{0, 0, 4, 4});
        hashMap.put("MP", new int[]{0, 2, 1, 2});
        hashMap.put("MQ", new int[]{2, 1, 1, 3});
        hashMap.put("MR", new int[]{4, 2, 4, 4});
        hashMap.put("MS", new int[]{1, 4, 3, 4});
        hashMap.put("MT", new int[]{0, 0, 0, 0});
        hashMap.put("MU", new int[]{2, 2, 4, 4});
        hashMap.put("MV", new int[]{4, 3, 2, 4});
        hashMap.put("MW", new int[]{3, 1, 1, 1});
        hashMap.put("MX", new int[]{2, 4, 3, 3});
        hashMap.put("MY", new int[]{2, 1, 3, 3});
        hashMap.put("MZ", new int[]{3, 3, 3, 3});
        hashMap.put("NA", new int[]{4, 3, 3, 3});
        hashMap.put("NC", new int[]{2, 0, 4, 4});
        hashMap.put("NE", new int[]{4, 4, 4, 4});
        hashMap.put("NF", new int[]{1, 2, 2, 0});
        hashMap.put("NG", new int[]{3, 3, 2, 2});
        hashMap.put("NI", new int[]{3, 2, 4, 3});
        hashMap.put("NL", new int[]{0, 2, 3, 2});
        hashMap.put("NO", new int[]{0, 2, 1, 0});
        hashMap.put("NP", new int[]{2, 2, 2, 2});
        hashMap.put("NR", new int[]{4, 0, 3, 2});
        hashMap.put("NZ", new int[]{0, 0, 1, 2});
        hashMap.put("OM", new int[]{2, 3, 0, 2});
        hashMap.put("PA", new int[]{1, 3, 3, 3});
        hashMap.put("PE", new int[]{2, 4, 4, 4});
        hashMap.put("PF", new int[]{2, 1, 1, 1});
        hashMap.put("PG", new int[]{4, 3, 3, 2});
        hashMap.put("PH", new int[]{3, 0, 3, 4});
        hashMap.put("PK", new int[]{3, 2, 3, 2});
        hashMap.put("PL", new int[]{1, 0, 1, 2});
        hashMap.put("PM", new int[]{0, 2, 2, 0});
        hashMap.put("PR", new int[]{2, 2, 2, 2});
        hashMap.put("PS", new int[]{3, 3, 1, 4});
        hashMap.put("PT", new int[]{1, 1, 0, 0});
        hashMap.put("PW", new int[]{1, 1, 3, 0});
        hashMap.put("PY", new int[]{2, 0, 3, 3});
        hashMap.put("QA", new int[]{2, 3, 1, 1});
        hashMap.put("RE", new int[]{1, 0, 2, 2});
        hashMap.put("RO", new int[]{0, 1, 1, 2});
        hashMap.put("RS", new int[]{1, 2, 0, 0});
        hashMap.put("RU", new int[]{0, 1, 0, 1});
        hashMap.put("RW", new int[]{4, 4, 4, 4});
        hashMap.put("SA", new int[]{2, 2, 2, 1});
        hashMap.put("SB", new int[]{4, 4, 4, 1});
        hashMap.put("SC", new int[]{4, 2, 0, 1});
        hashMap.put("SD", new int[]{4, 4, 4, 4});
        hashMap.put("SE", new int[]{0, 1, 0, 0});
        hashMap.put("SG", new int[]{1, 0, 3, 3});
        hashMap.put("SH", new int[]{4, 2, 2, 2});
        hashMap.put("SI", new int[]{0, 1, 0, 0});
        hashMap.put("SJ", new int[]{2, 2, 2, 4});
        hashMap.put("SK", new int[]{0, 1, 0, 0});
        hashMap.put("SL", new int[]{4, 3, 3, 1});
        hashMap.put("SM", new int[]{0, 0, 1, 2});
        hashMap.put("SN", new int[]{4, 4, 4, 3});
        hashMap.put("SO", new int[]{3, 4, 3, 4});
        hashMap.put("SR", new int[]{2, 2, 2, 1});
        hashMap.put("SS", new int[]{4, 4, 4, 4});
        hashMap.put("ST", new int[]{2, 3, 1, 2});
        hashMap.put("SV", new int[]{2, 2, 4, 4});
        hashMap.put("SX", new int[]{2, 4, 1, 0});
        hashMap.put("SY", new int[]{4, 3, 1, 1});
        hashMap.put("SZ", new int[]{4, 4, 3, 4});
        hashMap.put("TC", new int[]{1, 2, 1, 0});
        hashMap.put("TD", new int[]{4, 4, 4, 3});
        hashMap.put("TG", new int[]{3, 2, 1, 0});
        hashMap.put("TH", new int[]{1, 3, 3, 3});
        hashMap.put("TJ", new int[]{4, 4, 4, 4});
        hashMap.put("TL", new int[]{4, 2, 4, 4});
        hashMap.put("TM", new int[]{4, 2, 2, 2});
        hashMap.put("TN", new int[]{2, 1, 1, 1});
        hashMap.put("TO", new int[]{4, 3, 4, 4});
        hashMap.put("TR", new int[]{1, 2, 1, 1});
        hashMap.put("TT", new int[]{1, 3, 2, 4});
        hashMap.put("TV", new int[]{4, 2, 3, 4});
        hashMap.put("TW", new int[]{0, 0, 0, 0});
        hashMap.put("TZ", new int[]{3, 4, 3, 3});
        hashMap.put("UA", new int[]{0, 3, 1, 1});
        hashMap.put("UG", new int[]{3, 2, 2, 3});
        hashMap.put("US", new int[]{0, 1, 2, 2});
        hashMap.put("UY", new int[]{2, 1, 2, 2});
        hashMap.put("UZ", new int[]{2, 2, 3, 2});
        hashMap.put("VA", new int[]{0, 2, 2, 2});
        hashMap.put("VC", new int[]{2, 3, 0, 2});
        hashMap.put("VE", new int[]{4, 4, 4, 4});
        hashMap.put("VG", new int[]{3, 1, 2, 4});
        hashMap.put("VI", new int[]{1, 4, 4, 3});
        hashMap.put("VN", new int[]{0, 1, 3, 4});
        hashMap.put("VU", new int[]{4, 0, 3, 3});
        hashMap.put("WS", new int[]{3, 2, 4, 3});
        hashMap.put("XK", new int[]{1, 2, 1, 0});
        hashMap.put("YE", new int[]{4, 4, 4, 3});
        hashMap.put("YT", new int[]{2, 2, 2, 3});
        hashMap.put("ZA", new int[]{2, 3, 2, 2});
        hashMap.put("ZM", new int[]{3, 2, 3, 3});
        hashMap.put("ZW", new int[]{3, 3, 2, 3});
        return Collections.unmodifiableMap(hashMap);
    }

    public synchronized long a() {
        return this.f17029r;
    }

    public void a(Handler handler, c.a aVar) {
        this.f17020i.a(handler, aVar);
    }

    public void a(c.a aVar) {
        this.f17020i.a(aVar);
    }

    public void a(f fVar, h hVar, boolean z2) {
    }

    public synchronized void a(f fVar, h hVar, boolean z2, int i2) {
        if (z2) {
            this.f17025n += (long) i2;
        }
    }

    public t b() {
        return this;
    }

    public synchronized void b(f fVar, h hVar, boolean z2) {
        if (z2) {
            if (this.f17023l == 0) {
                this.f17024m = this.f17022k.a();
            }
            this.f17023l++;
        }
    }

    public synchronized void c(f fVar, h hVar, boolean z2) {
        if (z2) {
            com.google.android.exoplayer2.util.a.b(this.f17023l > 0);
            long a2 = this.f17022k.a();
            int i2 = (int) (a2 - this.f17024m);
            this.f17027p += (long) i2;
            long j2 = this.f17028q;
            long j3 = this.f17025n;
            this.f17028q = j2 + j3;
            if (i2 > 0) {
                this.f17021j.a((int) Math.sqrt((double) j3), (((float) j3) * 8000.0f) / ((float) i2));
                if (this.f17027p >= 2000 || this.f17028q >= 524288) {
                    this.f17029r = (long) this.f17021j.a(0.5f);
                }
                a(i2, this.f17025n, this.f17029r);
                this.f17024m = a2;
                this.f17025n = 0;
            }
            this.f17023l--;
        }
    }
}
