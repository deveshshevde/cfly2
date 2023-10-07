package com.facebook.drawee.components;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11131a;

    /* renamed from: b  reason: collision with root package name */
    private int f11132b;

    /* renamed from: c  reason: collision with root package name */
    private int f11133c;

    public b() {
        a();
    }

    public void a() {
        this.f11131a = false;
        this.f11132b = 4;
        b();
    }

    public void a(boolean z2) {
        this.f11131a = z2;
    }

    public void b() {
        this.f11133c = 0;
    }

    public boolean c() {
        return this.f11131a && this.f11133c < this.f11132b;
    }

    public void d() {
        this.f11133c++;
    }
}
