package com.amap.api.mapcore.util;

public final class fs extends ia {

    /* renamed from: g  reason: collision with root package name */
    private static int f8828g = 10000000;

    /* renamed from: a  reason: collision with root package name */
    protected int f8829a;

    /* renamed from: b  reason: collision with root package name */
    protected long f8830b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8831d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8832e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f8833f = f8828g;

    /* renamed from: h  reason: collision with root package name */
    private long f8834h = 0;

    public fs(boolean z2, ia iaVar, long j2, int i2) {
        super(iaVar);
        this.f8831d = z2;
        this.f8829a = 600000;
        this.f8834h = j2;
        this.f8833f = i2;
    }

    public final int a() {
        return 320000;
    }

    public final void a(int i2) {
        if (i2 > 0) {
            this.f8834h += (long) i2;
        }
    }

    public final void a(boolean z2) {
        this.f8832e = z2;
    }

    public final long b() {
        return this.f8834h;
    }

    /* access modifiers changed from: protected */
    public final boolean c() {
        if (this.f8832e && this.f8834h <= ((long) this.f8833f)) {
            return true;
        }
        if (!this.f8831d || this.f8834h >= ((long) this.f8833f)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f8830b < ((long) this.f8829a)) {
            return false;
        }
        this.f8830b = currentTimeMillis;
        return true;
    }
}
