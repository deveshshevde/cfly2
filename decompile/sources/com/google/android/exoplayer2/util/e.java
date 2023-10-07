package com.google.android.exoplayer2.util;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final b f17107a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17108b;

    public e() {
        this(b.f17099a);
    }

    public e(b bVar) {
        this.f17107a = bVar;
    }

    public synchronized boolean a() {
        if (this.f17108b) {
            return false;
        }
        this.f17108b = true;
        notifyAll();
        return true;
    }

    public synchronized boolean b() {
        boolean z2;
        z2 = this.f17108b;
        this.f17108b = false;
        return z2;
    }

    public synchronized void c() throws InterruptedException {
        while (!this.f17108b) {
            wait();
        }
    }

    public synchronized boolean d() {
        return this.f17108b;
    }
}
