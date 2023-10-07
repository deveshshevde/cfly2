package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import bz.j;
import cc.k;
import cc.l;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.b;
import com.bumptech.glide.request.d;
import com.bumptech.glide.request.e;
import com.bumptech.glide.request.f;
import com.bumptech.glide.request.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class g<TranscodeType> extends a<g<TranscodeType>> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    protected static final h f10092a = ((h) ((h) ((h) new h().a(com.bumptech.glide.load.engine.h.f10303c)).a(Priority.LOW)).b(true));

    /* renamed from: b  reason: collision with root package name */
    private final Context f10093b;

    /* renamed from: c  reason: collision with root package name */
    private final h f10094c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<TranscodeType> f10095d;

    /* renamed from: e  reason: collision with root package name */
    private final c f10096e;

    /* renamed from: f  reason: collision with root package name */
    private final e f10097f;

    /* renamed from: g  reason: collision with root package name */
    private i<?, ? super TranscodeType> f10098g;

    /* renamed from: h  reason: collision with root package name */
    private Object f10099h;

    /* renamed from: i  reason: collision with root package name */
    private List<com.bumptech.glide.request.g<TranscodeType>> f10100i;

    /* renamed from: j  reason: collision with root package name */
    private g<TranscodeType> f10101j;

    /* renamed from: k  reason: collision with root package name */
    private g<TranscodeType> f10102k;

    /* renamed from: l  reason: collision with root package name */
    private Float f10103l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10104m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10105n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10106o;

    /* renamed from: com.bumptech.glide.g$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10107a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f10108b;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        static {
            /*
                com.bumptech.glide.Priority[] r0 = com.bumptech.glide.Priority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10108b = r0
                r1 = 1
                com.bumptech.glide.Priority r2 = com.bumptech.glide.Priority.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f10108b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.Priority r3 = com.bumptech.glide.Priority.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f10108b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bumptech.glide.Priority r4 = com.bumptech.glide.Priority.HIGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f10108b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bumptech.glide.Priority r5 = com.bumptech.glide.Priority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f10107a = r4
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f10107a     // Catch:{ NoSuchFieldError -> 0x004e }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f10107a     // Catch:{ NoSuchFieldError -> 0x0058 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f10107a     // Catch:{ NoSuchFieldError -> 0x0062 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f10107a     // Catch:{ NoSuchFieldError -> 0x006d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f10107a     // Catch:{ NoSuchFieldError -> 0x0078 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f10107a     // Catch:{ NoSuchFieldError -> 0x0083 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f10107a     // Catch:{ NoSuchFieldError -> 0x008f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.g.AnonymousClass1.<clinit>():void");
        }
    }

    protected g(c cVar, h hVar, Class<TranscodeType> cls, Context context) {
        this.f10096e = cVar;
        this.f10094c = hVar;
        this.f10095d = cls;
        this.f10093b = context;
        this.f10098g = hVar.b(cls);
        this.f10097f = cVar.e();
        a(hVar.l());
        b((a<?>) hVar.m());
    }

    private <Y extends j<TranscodeType>> Y a(Y y2, com.bumptech.glide.request.g<TranscodeType> gVar, a<?> aVar, Executor executor) {
        k.a(y2);
        if (this.f10105n) {
            e b2 = b(y2, gVar, aVar, executor);
            e a2 = y2.a();
            if (!b2.a(a2) || a(aVar, a2)) {
                this.f10094c.a((j<?>) y2);
                y2.a(b2);
                this.f10094c.a(y2, b2);
                return y2;
            }
            if (!((e) k.a(a2)).d()) {
                a2.a();
            }
            return y2;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private e a(Object obj, j<TranscodeType> jVar, com.bumptech.glide.request.g<TranscodeType> gVar, RequestCoordinator requestCoordinator, i<?, ? super TranscodeType> iVar, Priority priority, int i2, int i3, a<?> aVar, Executor executor) {
        b bVar;
        b bVar2;
        if (this.f10102k != null) {
            bVar2 = new b(obj, requestCoordinator);
            bVar = bVar2;
        } else {
            Object obj2 = obj;
            bVar = null;
            bVar2 = requestCoordinator;
        }
        e b2 = b(obj, jVar, gVar, bVar2, iVar, priority, i2, i3, aVar, executor);
        if (bVar == null) {
            return b2;
        }
        int G = this.f10102k.G();
        int I = this.f10102k.I();
        if (l.a(i2, i3) && !this.f10102k.H()) {
            G = aVar.G();
            I = aVar.I();
        }
        g<TranscodeType> gVar2 = this.f10102k;
        b bVar3 = bVar;
        bVar3.a(b2, gVar2.a(obj, jVar, gVar, (RequestCoordinator) bVar3, gVar2.f10098g, gVar2.F(), G, I, (a<?>) this.f10102k, executor));
        return bVar3;
    }

    private e a(Object obj, j<TranscodeType> jVar, com.bumptech.glide.request.g<TranscodeType> gVar, a<?> aVar, RequestCoordinator requestCoordinator, i<?, ? super TranscodeType> iVar, Priority priority, int i2, int i3, Executor executor) {
        Context context = this.f10093b;
        e eVar = this.f10097f;
        return SingleRequest.a(context, eVar, obj, this.f10099h, this.f10095d, aVar, i2, i3, priority, jVar, gVar, this.f10100i, requestCoordinator, eVar.c(), iVar.b(), executor);
    }

    private void a(List<com.bumptech.glide.request.g<Object>> list) {
        for (com.bumptech.glide.request.g<Object> b2 : list) {
            b(b2);
        }
    }

    private boolean a(a<?> aVar, e eVar) {
        return !aVar.C() && eVar.e();
    }

    private Priority b(Priority priority) {
        int i2 = AnonymousClass1.f10108b[priority.ordinal()];
        if (i2 == 1) {
            return Priority.NORMAL;
        }
        if (i2 == 2) {
            return Priority.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + F());
    }

    private g<TranscodeType> b(Object obj) {
        if (p()) {
            return d().b(obj);
        }
        this.f10099h = obj;
        this.f10105n = true;
        return (g) o();
    }

    private e b(j<TranscodeType> jVar, com.bumptech.glide.request.g<TranscodeType> gVar, a<?> aVar, Executor executor) {
        return a(new Object(), jVar, gVar, (RequestCoordinator) null, this.f10098g, aVar.F(), aVar.G(), aVar.I(), aVar, executor);
    }

    /* JADX WARNING: type inference failed for: r27v0, types: [com.bumptech.glide.request.a, com.bumptech.glide.request.a<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.request.e b(java.lang.Object r19, bz.j<TranscodeType> r20, com.bumptech.glide.request.g<TranscodeType> r21, com.bumptech.glide.request.RequestCoordinator r22, com.bumptech.glide.i<?, ? super TranscodeType> r23, com.bumptech.glide.Priority r24, int r25, int r26, com.bumptech.glide.request.a<?> r27, java.util.concurrent.Executor r28) {
        /*
            r18 = this;
            r11 = r18
            r12 = r19
            r5 = r22
            r13 = r24
            com.bumptech.glide.g<TranscodeType> r0 = r11.f10101j
            if (r0 == 0) goto L_0x0094
            boolean r1 = r11.f10106o
            if (r1 != 0) goto L_0x008c
            com.bumptech.glide.i<?, ? super TranscodeType> r1 = r0.f10098g
            boolean r2 = r0.f10104m
            if (r2 == 0) goto L_0x0019
            r14 = r23
            goto L_0x001a
        L_0x0019:
            r14 = r1
        L_0x001a:
            boolean r0 = r0.E()
            if (r0 == 0) goto L_0x0027
            com.bumptech.glide.g<TranscodeType> r0 = r11.f10101j
            com.bumptech.glide.Priority r0 = r0.F()
            goto L_0x002b
        L_0x0027:
            com.bumptech.glide.Priority r0 = r11.b((com.bumptech.glide.Priority) r13)
        L_0x002b:
            r15 = r0
            com.bumptech.glide.g<TranscodeType> r0 = r11.f10101j
            int r0 = r0.G()
            com.bumptech.glide.g<TranscodeType> r1 = r11.f10101j
            int r1 = r1.I()
            boolean r2 = cc.l.a((int) r25, (int) r26)
            if (r2 == 0) goto L_0x004e
            com.bumptech.glide.g<TranscodeType> r2 = r11.f10101j
            boolean r2 = r2.H()
            if (r2 != 0) goto L_0x004e
            int r0 = r27.G()
            int r1 = r27.I()
        L_0x004e:
            r16 = r0
            r17 = r1
            com.bumptech.glide.request.j r10 = new com.bumptech.glide.request.j
            r10.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r10
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r13 = r10
            r10 = r28
            com.bumptech.glide.request.e r10 = r0.a((java.lang.Object) r1, r2, r3, (com.bumptech.glide.request.a<?>) r4, (com.bumptech.glide.request.RequestCoordinator) r5, r6, (com.bumptech.glide.Priority) r7, (int) r8, (int) r9, (java.util.concurrent.Executor) r10)
            r0 = 1
            r11.f10106o = r0
            com.bumptech.glide.g<TranscodeType> r9 = r11.f10101j
            r0 = r9
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r12 = r10
            r10 = r28
            com.bumptech.glide.request.e r0 = r0.a((java.lang.Object) r1, r2, r3, (com.bumptech.glide.request.RequestCoordinator) r4, r5, (com.bumptech.glide.Priority) r6, (int) r7, (int) r8, (com.bumptech.glide.request.a<?>) r9, (java.util.concurrent.Executor) r10)
            r1 = 0
            r11.f10106o = r1
            r13.a(r12, r0)
            return r13
        L_0x008c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()"
            r0.<init>(r1)
            throw r0
        L_0x0094:
            java.lang.Float r0 = r11.f10103l
            if (r0 == 0) goto L_0x00d4
            com.bumptech.glide.request.j r14 = new com.bumptech.glide.request.j
            r14.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r14
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            com.bumptech.glide.request.e r15 = r0.a((java.lang.Object) r1, r2, r3, (com.bumptech.glide.request.a<?>) r4, (com.bumptech.glide.request.RequestCoordinator) r5, r6, (com.bumptech.glide.Priority) r7, (int) r8, (int) r9, (java.util.concurrent.Executor) r10)
            com.bumptech.glide.request.a r0 = r27.clone()
            java.lang.Float r1 = r11.f10103l
            float r1 = r1.floatValue()
            com.bumptech.glide.request.a r4 = r0.b((float) r1)
            com.bumptech.glide.Priority r7 = r11.b((com.bumptech.glide.Priority) r13)
            r0 = r18
            r1 = r19
            com.bumptech.glide.request.e r0 = r0.a((java.lang.Object) r1, r2, r3, (com.bumptech.glide.request.a<?>) r4, (com.bumptech.glide.request.RequestCoordinator) r5, r6, (com.bumptech.glide.Priority) r7, (int) r8, (int) r9, (java.util.concurrent.Executor) r10)
            r14.a(r15, r0)
            return r14
        L_0x00d4:
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            com.bumptech.glide.request.e r0 = r0.a((java.lang.Object) r1, r2, r3, (com.bumptech.glide.request.a<?>) r4, (com.bumptech.glide.request.RequestCoordinator) r5, r6, (com.bumptech.glide.Priority) r7, (int) r8, (int) r9, (java.util.concurrent.Executor) r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.g.b(java.lang.Object, bz.j, com.bumptech.glide.request.g, com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.i, com.bumptech.glide.Priority, int, int, com.bumptech.glide.request.a, java.util.concurrent.Executor):com.bumptech.glide.request.e");
    }

    public <Y extends j<TranscodeType>> Y a(Y y2) {
        return a(y2, (com.bumptech.glide.request.g) null, cc.e.a());
    }

    /* access modifiers changed from: package-private */
    public <Y extends j<TranscodeType>> Y a(Y y2, com.bumptech.glide.request.g<TranscodeType> gVar, Executor executor) {
        return a(y2, gVar, this, executor);
    }

    public bz.k<ImageView, TranscodeType> a(ImageView imageView) {
        a aVar;
        l.a();
        k.a(imageView);
        if (!f() && e() && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f10107a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVar = clone().h();
                    break;
                case 2:
                case 6:
                    aVar = clone().k();
                    break;
                case 3:
                case 4:
                case 5:
                    aVar = clone().j();
                    break;
            }
        }
        aVar = this;
        return (bz.k) a(this.f10097f.a(imageView, this.f10095d), (com.bumptech.glide.request.g) null, aVar, cc.e.a());
    }

    /* renamed from: a */
    public g<TranscodeType> d() {
        g<TranscodeType> gVar = (g) super.clone();
        gVar.f10098g = gVar.f10098g.clone();
        if (gVar.f10100i != null) {
            gVar.f10100i = new ArrayList(gVar.f10100i);
        }
        g<TranscodeType> gVar2 = gVar.f10101j;
        if (gVar2 != null) {
            gVar.f10101j = gVar2.d();
        }
        g<TranscodeType> gVar3 = gVar.f10102k;
        if (gVar3 != null) {
            gVar.f10102k = gVar3.d();
        }
        return gVar;
    }

    @Deprecated
    public g<TranscodeType> a(float f2) {
        if (p()) {
            return d().a(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f10103l = Float.valueOf(f2);
        return (g) o();
    }

    public g<TranscodeType> a(Uri uri) {
        return b((Object) uri);
    }

    /* renamed from: a */
    public g<TranscodeType> b(a<?> aVar) {
        k.a(aVar);
        return (g) super.b(aVar);
    }

    public g<TranscodeType> a(com.bumptech.glide.request.g<TranscodeType> gVar) {
        if (p()) {
            return d().a(gVar);
        }
        this.f10100i = null;
        return b(gVar);
    }

    public g<TranscodeType> a(Object obj) {
        return b(obj);
    }

    public g<TranscodeType> a(String str) {
        return b((Object) str);
    }

    public d<TranscodeType> a(int i2, int i3) {
        f fVar = new f(i2, i3);
        return (d) a(fVar, fVar, cc.e.b());
    }

    public j<TranscodeType> b(int i2, int i3) {
        return a(bz.h.a(this.f10094c, i2, i3));
    }

    public g<TranscodeType> b(com.bumptech.glide.request.g<TranscodeType> gVar) {
        if (p()) {
            return d().b(gVar);
        }
        if (gVar != null) {
            if (this.f10100i == null) {
                this.f10100i = new ArrayList();
            }
            this.f10100i.add(gVar);
        }
        return (g) o();
    }

    public d<TranscodeType> b() {
        return a(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public j<TranscodeType> c() {
        return b(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
}
