package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import cc.b;
import cc.k;
import cc.l;
import com.blankj.utilcode.constant.MemoryConstants;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bitmap.j;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.request.a;
import java.util.Map;

public abstract class a<T extends a<T>> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f10567a;

    /* renamed from: b  reason: collision with root package name */
    private float f10568b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private h f10569c = h.f10305e;

    /* renamed from: d  reason: collision with root package name */
    private Priority f10570d = Priority.NORMAL;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f10571e;

    /* renamed from: f  reason: collision with root package name */
    private int f10572f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f10573g;

    /* renamed from: h  reason: collision with root package name */
    private int f10574h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10575i = true;

    /* renamed from: j  reason: collision with root package name */
    private int f10576j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f10577k = -1;

    /* renamed from: l  reason: collision with root package name */
    private c f10578l = cb.a.a();

    /* renamed from: m  reason: collision with root package name */
    private boolean f10579m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10580n = true;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f10581o;

    /* renamed from: p  reason: collision with root package name */
    private int f10582p;

    /* renamed from: q  reason: collision with root package name */
    private f f10583q = new f();

    /* renamed from: r  reason: collision with root package name */
    private Map<Class<?>, i<?>> f10584r = new b();

    /* renamed from: s  reason: collision with root package name */
    private Class<?> f10585s = Object.class;

    /* renamed from: t  reason: collision with root package name */
    private boolean f10586t;

    /* renamed from: u  reason: collision with root package name */
    private Resources.Theme f10587u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f10588v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f10589w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f10590x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f10591y = true;

    /* renamed from: z  reason: collision with root package name */
    private boolean f10592z;

    private T a() {
        return this;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.i<android.graphics.Bitmap>, com.bumptech.glide.load.i] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T a(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r1, com.bumptech.glide.load.i<android.graphics.Bitmap> r2, boolean r3) {
        /*
            r0 = this;
            if (r3 == 0) goto L_0x0007
            com.bumptech.glide.request.a r1 = r0.b(r1, r2)
            goto L_0x000b
        L_0x0007:
            com.bumptech.glide.request.a r1 = r0.a((com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) r1, (com.bumptech.glide.load.i<android.graphics.Bitmap>) r2)
        L_0x000b:
            r2 = 1
            r1.f10591y = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.a(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.i, boolean):com.bumptech.glide.request.a");
    }

    private static boolean a(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.i<android.graphics.Bitmap>, com.bumptech.glide.load.i] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T c(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, com.bumptech.glide.load.i<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            r0 = 0
            com.bumptech.glide.request.a r2 = r1.a((com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) r2, (com.bumptech.glide.load.i<android.graphics.Bitmap>) r3, (boolean) r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.c(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.i):com.bumptech.glide.request.a");
    }

    private boolean c(int i2) {
        return a(this.f10567a, i2);
    }

    public final Drawable A() {
        return this.f10581o;
    }

    public final Resources.Theme B() {
        return this.f10587u;
    }

    public final boolean C() {
        return this.f10575i;
    }

    public final c D() {
        return this.f10578l;
    }

    public final boolean E() {
        return c(8);
    }

    public final Priority F() {
        return this.f10570d;
    }

    public final int G() {
        return this.f10577k;
    }

    public final boolean H() {
        return l.a(this.f10577k, this.f10576j);
    }

    public final int I() {
        return this.f10576j;
    }

    public final float J() {
        return this.f10568b;
    }

    /* access modifiers changed from: package-private */
    public boolean K() {
        return this.f10591y;
    }

    public final boolean L() {
        return this.f10589w;
    }

    public final boolean M() {
        return this.f10592z;
    }

    public final boolean N() {
        return this.f10590x;
    }

    public T a(int i2) {
        if (this.f10588v) {
            return clone().a(i2);
        }
        this.f10574h = i2;
        int i3 = this.f10567a | 128;
        this.f10567a = i3;
        this.f10573g = null;
        this.f10567a = i3 & -65;
        return o();
    }

    public T a(long j2) {
        return a(VideoDecoder.f10446a, Long.valueOf(j2));
    }

    public T a(Priority priority) {
        if (this.f10588v) {
            return clone().a(priority);
        }
        this.f10570d = (Priority) k.a(priority);
        this.f10567a |= 8;
        return o();
    }

    public T a(c cVar) {
        if (this.f10588v) {
            return clone().a(cVar);
        }
        this.f10578l = (c) k.a(cVar);
        this.f10567a |= 1024;
        return o();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.e<Y>, com.bumptech.glide.load.e, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T a(com.bumptech.glide.load.e<Y> r2, Y r3) {
        /*
            r1 = this;
            boolean r0 = r1.f10588v
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.a r0 = r1.clone()
            com.bumptech.glide.request.a r2 = r0.a(r2, r3)
            return r2
        L_0x000d:
            cc.k.a(r2)
            cc.k.a(r3)
            com.bumptech.glide.load.f r0 = r1.f10583q
            r0.a(r2, r3)
            com.bumptech.glide.request.a r2 = r1.o()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.a(com.bumptech.glide.load.e, java.lang.Object):com.bumptech.glide.request.a");
    }

    public T a(h hVar) {
        if (this.f10588v) {
            return clone().a(hVar);
        }
        this.f10569c = (h) k.a(hVar);
        this.f10567a |= 4;
        return o();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.i<android.graphics.Bitmap>, com.bumptech.glide.load.i] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T a(com.bumptech.glide.load.i<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.request.a r2 = r1.a((com.bumptech.glide.load.i<android.graphics.Bitmap>) r2, (boolean) r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.a(com.bumptech.glide.load.i):com.bumptech.glide.request.a");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.i<android.graphics.Bitmap>, com.bumptech.glide.load.i] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T a(com.bumptech.glide.load.i<android.graphics.Bitmap> r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = r2.f10588v
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.a r0 = r2.clone()
            com.bumptech.glide.request.a r3 = r0.a((com.bumptech.glide.load.i<android.graphics.Bitmap>) r3, (boolean) r4)
            return r3
        L_0x000d:
            com.bumptech.glide.load.resource.bitmap.m r0 = new com.bumptech.glide.load.resource.bitmap.m
            r0.<init>(r3, r4)
            java.lang.Class<android.graphics.Bitmap> r1 = android.graphics.Bitmap.class
            r2.a(r1, r3, (boolean) r4)
            java.lang.Class<android.graphics.drawable.Drawable> r1 = android.graphics.drawable.Drawable.class
            r2.a(r1, r0, (boolean) r4)
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r1 = android.graphics.drawable.BitmapDrawable.class
            com.bumptech.glide.load.i r0 = r0.a()
            r2.a(r1, r0, (boolean) r4)
            java.lang.Class<bu.c> r0 = bu.c.class
            bu.f r1 = new bu.f
            r1.<init>(r3)
            r2.a(r0, r1, (boolean) r4)
            com.bumptech.glide.request.a r3 = r2.o()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.a(com.bumptech.glide.load.i, boolean):com.bumptech.glide.request.a");
    }

    public T a(DownsampleStrategy downsampleStrategy) {
        return a(DownsampleStrategy.f10435h, k.a(downsampleStrategy));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.i<android.graphics.Bitmap>, com.bumptech.glide.load.i] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T a(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, com.bumptech.glide.load.i<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.f10588v
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.a r0 = r1.clone()
            com.bumptech.glide.request.a r2 = r0.a((com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) r2, (com.bumptech.glide.load.i<android.graphics.Bitmap>) r3)
            return r2
        L_0x000d:
            r1.a((com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) r2)
            r2 = 0
            com.bumptech.glide.request.a r2 = r1.a((com.bumptech.glide.load.i<android.graphics.Bitmap>) r3, (boolean) r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.a(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.i):com.bumptech.glide.request.a");
    }

    public T a(Class<?> cls) {
        if (this.f10588v) {
            return clone().a(cls);
        }
        this.f10585s = (Class) k.a(cls);
        this.f10567a |= 4096;
        return o();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<Y>, java.lang.Object, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.i<Y>, java.lang.Object, com.bumptech.glide.load.i] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T a(java.lang.Class<Y> r2, com.bumptech.glide.load.i<Y> r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = r1.f10588v
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.a r0 = r1.clone()
            com.bumptech.glide.request.a r2 = r0.a(r2, r3, (boolean) r4)
            return r2
        L_0x000d:
            cc.k.a(r2)
            cc.k.a(r3)
            java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.i<?>> r0 = r1.f10584r
            r0.put(r2, r3)
            int r2 = r1.f10567a
            r2 = r2 | 2048(0x800, float:2.87E-42)
            r1.f10567a = r2
            r3 = 1
            r1.f10580n = r3
            r0 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 | r0
            r1.f10567a = r2
            r0 = 0
            r1.f10591y = r0
            if (r4 == 0) goto L_0x0032
            r4 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 | r4
            r1.f10567a = r2
            r1.f10579m = r3
        L_0x0032:
            com.bumptech.glide.request.a r2 = r1.o()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.a(java.lang.Class, com.bumptech.glide.load.i, boolean):com.bumptech.glide.request.a");
    }

    public T a(boolean z2) {
        if (this.f10588v) {
            return clone().a(z2);
        }
        this.f10592z = z2;
        this.f10567a |= MemoryConstants.MB;
        return o();
    }

    @Deprecated
    public T a(i<Bitmap>... iVarArr) {
        return a((i<Bitmap>) new d(iVarArr), true);
    }

    public T b(float f2) {
        if (this.f10588v) {
            return clone().b(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f10568b = f2;
        this.f10567a |= 2;
        return o();
    }

    public T b(int i2) {
        if (this.f10588v) {
            return clone().b(i2);
        }
        this.f10572f = i2;
        int i3 = this.f10567a | 32;
        this.f10567a = i3;
        this.f10571e = null;
        this.f10567a = i3 & -17;
        return o();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.i<android.graphics.Bitmap>, com.bumptech.glide.load.i] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T b(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, com.bumptech.glide.load.i<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.f10588v
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.a r0 = r1.clone()
            com.bumptech.glide.request.a r2 = r0.b(r2, r3)
            return r2
        L_0x000d:
            r1.a((com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) r2)
            com.bumptech.glide.request.a r2 = r1.a((com.bumptech.glide.load.i<android.graphics.Bitmap>) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.b(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.i):com.bumptech.glide.request.a");
    }

    public T b(a<?> aVar) {
        if (this.f10588v) {
            return clone().b(aVar);
        }
        if (a(aVar.f10567a, 2)) {
            this.f10568b = aVar.f10568b;
        }
        if (a(aVar.f10567a, 262144)) {
            this.f10589w = aVar.f10589w;
        }
        if (a(aVar.f10567a, (int) MemoryConstants.MB)) {
            this.f10592z = aVar.f10592z;
        }
        if (a(aVar.f10567a, 4)) {
            this.f10569c = aVar.f10569c;
        }
        if (a(aVar.f10567a, 8)) {
            this.f10570d = aVar.f10570d;
        }
        if (a(aVar.f10567a, 16)) {
            this.f10571e = aVar.f10571e;
            this.f10572f = 0;
            this.f10567a &= -33;
        }
        if (a(aVar.f10567a, 32)) {
            this.f10572f = aVar.f10572f;
            this.f10571e = null;
            this.f10567a &= -17;
        }
        if (a(aVar.f10567a, 64)) {
            this.f10573g = aVar.f10573g;
            this.f10574h = 0;
            this.f10567a &= -129;
        }
        if (a(aVar.f10567a, 128)) {
            this.f10574h = aVar.f10574h;
            this.f10573g = null;
            this.f10567a &= -65;
        }
        if (a(aVar.f10567a, 256)) {
            this.f10575i = aVar.f10575i;
        }
        if (a(aVar.f10567a, 512)) {
            this.f10577k = aVar.f10577k;
            this.f10576j = aVar.f10576j;
        }
        if (a(aVar.f10567a, 1024)) {
            this.f10578l = aVar.f10578l;
        }
        if (a(aVar.f10567a, 4096)) {
            this.f10585s = aVar.f10585s;
        }
        if (a(aVar.f10567a, 8192)) {
            this.f10581o = aVar.f10581o;
            this.f10582p = 0;
            this.f10567a &= -16385;
        }
        if (a(aVar.f10567a, 16384)) {
            this.f10582p = aVar.f10582p;
            this.f10581o = null;
            this.f10567a &= -8193;
        }
        if (a(aVar.f10567a, 32768)) {
            this.f10587u = aVar.f10587u;
        }
        if (a(aVar.f10567a, 65536)) {
            this.f10580n = aVar.f10580n;
        }
        if (a(aVar.f10567a, 131072)) {
            this.f10579m = aVar.f10579m;
        }
        if (a(aVar.f10567a, 2048)) {
            this.f10584r.putAll(aVar.f10584r);
            this.f10591y = aVar.f10591y;
        }
        if (a(aVar.f10567a, 524288)) {
            this.f10590x = aVar.f10590x;
        }
        if (!this.f10580n) {
            this.f10584r.clear();
            int i2 = this.f10567a & -2049;
            this.f10567a = i2;
            this.f10579m = false;
            this.f10567a = i2 & -131073;
            this.f10591y = true;
        }
        this.f10567a |= aVar.f10567a;
        this.f10583q.a(aVar.f10583q);
        return o();
    }

    public T b(boolean z2) {
        if (this.f10588v) {
            return clone().b(true);
        }
        this.f10575i = !z2;
        this.f10567a |= 256;
        return o();
    }

    public T c(int i2, int i3) {
        if (this.f10588v) {
            return clone().c(i2, i3);
        }
        this.f10577k = i2;
        this.f10576j = i3;
        this.f10567a |= 512;
        return o();
    }

    /* renamed from: d */
    public T clone() {
        try {
            T t2 = (a) super.clone();
            f fVar = new f();
            t2.f10583q = fVar;
            fVar.a(this.f10583q);
            b bVar = new b();
            t2.f10584r = bVar;
            bVar.putAll(this.f10584r);
            t2.f10586t = false;
            t2.f10588v = false;
            return t2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final boolean e() {
        return this.f10580n;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.f10568b, this.f10568b) == 0 && this.f10572f == aVar.f10572f && l.a((Object) this.f10571e, (Object) aVar.f10571e) && this.f10574h == aVar.f10574h && l.a((Object) this.f10573g, (Object) aVar.f10573g) && this.f10582p == aVar.f10582p && l.a((Object) this.f10581o, (Object) aVar.f10581o) && this.f10575i == aVar.f10575i && this.f10576j == aVar.f10576j && this.f10577k == aVar.f10577k && this.f10579m == aVar.f10579m && this.f10580n == aVar.f10580n && this.f10589w == aVar.f10589w && this.f10590x == aVar.f10590x && this.f10569c.equals(aVar.f10569c) && this.f10570d == aVar.f10570d && this.f10583q.equals(aVar.f10583q) && this.f10584r.equals(aVar.f10584r) && this.f10585s.equals(aVar.f10585s) && l.a((Object) this.f10578l, (Object) aVar.f10578l) && l.a((Object) this.f10587u, (Object) aVar.f10587u);
    }

    public final boolean f() {
        return c(2048);
    }

    public T g() {
        return a(com.bumptech.glide.load.resource.bitmap.k.f10474e, false);
    }

    public T h() {
        return a(DownsampleStrategy.f10432e, (i<Bitmap>) new com.bumptech.glide.load.resource.bitmap.i());
    }

    public int hashCode() {
        return l.a((Object) this.f10587u, l.a((Object) this.f10578l, l.a((Object) this.f10585s, l.a((Object) this.f10584r, l.a((Object) this.f10583q, l.a((Object) this.f10570d, l.a((Object) this.f10569c, l.a(this.f10590x, l.a(this.f10589w, l.a(this.f10580n, l.a(this.f10579m, l.b(this.f10577k, l.b(this.f10576j, l.a(this.f10575i, l.a((Object) this.f10581o, l.b(this.f10582p, l.a((Object) this.f10573g, l.b(this.f10574h, l.a((Object) this.f10571e, l.b(this.f10572f, l.a(this.f10568b)))))))))))))))))))));
    }

    public T i() {
        return b(DownsampleStrategy.f10432e, new com.bumptech.glide.load.resource.bitmap.i());
    }

    public T j() {
        return c(DownsampleStrategy.f10430c, (i<Bitmap>) new o());
    }

    public T k() {
        return c(DownsampleStrategy.f10431d, (i<Bitmap>) new j());
    }

    public T l() {
        return a(bu.i.f6038b, true);
    }

    public T m() {
        this.f10586t = true;
        return a();
    }

    public T n() {
        if (!this.f10586t || this.f10588v) {
            this.f10588v = true;
            return m();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    /* access modifiers changed from: protected */
    public final T o() {
        if (!this.f10586t) {
            return a();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    /* access modifiers changed from: protected */
    public final boolean p() {
        return this.f10588v;
    }

    public final Map<Class<?>, i<?>> q() {
        return this.f10584r;
    }

    public final boolean r() {
        return this.f10579m;
    }

    public final f s() {
        return this.f10583q;
    }

    public final Class<?> t() {
        return this.f10585s;
    }

    public final h u() {
        return this.f10569c;
    }

    public final Drawable v() {
        return this.f10571e;
    }

    public final int w() {
        return this.f10572f;
    }

    public final int x() {
        return this.f10574h;
    }

    public final Drawable y() {
        return this.f10573g;
    }

    public final int z() {
        return this.f10582p;
    }
}
