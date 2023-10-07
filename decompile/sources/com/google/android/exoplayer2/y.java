package com.google.android.exoplayer2;

import android.os.Handler;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    private final b f17289a;

    /* renamed from: b  reason: collision with root package name */
    private final a f17290b;

    /* renamed from: c  reason: collision with root package name */
    private final af f17291c;

    /* renamed from: d  reason: collision with root package name */
    private int f17292d;

    /* renamed from: e  reason: collision with root package name */
    private Object f17293e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f17294f;

    /* renamed from: g  reason: collision with root package name */
    private int f17295g;

    /* renamed from: h  reason: collision with root package name */
    private long f17296h = -9223372036854775807L;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17297i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f17298j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f17299k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f17300l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17301m;

    public interface a {
        void a(y yVar);
    }

    public interface b {
        void a(int i2, Object obj) throws ExoPlaybackException;
    }

    public y(a aVar, b bVar, af afVar, int i2, Handler handler) {
        this.f17290b = aVar;
        this.f17289a = bVar;
        this.f17291c = afVar;
        this.f17294f = handler;
        this.f17295g = i2;
    }

    public af a() {
        return this.f17291c;
    }

    public y a(int i2) {
        com.google.android.exoplayer2.util.a.b(!this.f17298j);
        this.f17292d = i2;
        return this;
    }

    public y a(Object obj) {
        com.google.android.exoplayer2.util.a.b(!this.f17298j);
        this.f17293e = obj;
        return this;
    }

    public synchronized void a(boolean z2) {
        this.f17299k = z2 | this.f17299k;
        this.f17300l = true;
        notifyAll();
    }

    public b b() {
        return this.f17289a;
    }

    public int c() {
        return this.f17292d;
    }

    public Object d() {
        return this.f17293e;
    }

    public Handler e() {
        return this.f17294f;
    }

    public long f() {
        return this.f17296h;
    }

    public int g() {
        return this.f17295g;
    }

    public boolean h() {
        return this.f17297i;
    }

    public y i() {
        com.google.android.exoplayer2.util.a.b(!this.f17298j);
        if (this.f17296h == -9223372036854775807L) {
            com.google.android.exoplayer2.util.a.a(this.f17297i);
        }
        this.f17298j = true;
        this.f17290b.a(this);
        return this;
    }

    public synchronized boolean j() {
        return this.f17301m;
    }

    public synchronized boolean k() throws InterruptedException {
        com.google.android.exoplayer2.util.a.b(this.f17298j);
        com.google.android.exoplayer2.util.a.b(this.f17294f.getLooper().getThread() != Thread.currentThread());
        while (!this.f17300l) {
            wait();
        }
        return this.f17299k;
    }
}
