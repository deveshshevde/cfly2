package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import dy.bc;
import en.a;
import org.greenrobot.eventbus.c;

public class u extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f14386a;

    /* renamed from: c  reason: collision with root package name */
    private int f14387c;

    /* renamed from: d  reason: collision with root package name */
    private int f14388d;

    /* renamed from: e  reason: collision with root package name */
    private int f14389e;

    /* renamed from: f  reason: collision with root package name */
    private int f14390f;

    /* renamed from: g  reason: collision with root package name */
    private int f14391g;

    /* renamed from: h  reason: collision with root package name */
    private int f14392h;

    /* renamed from: i  reason: collision with root package name */
    private int f14393i;

    /* renamed from: j  reason: collision with root package name */
    private int f14394j;

    public u(a aVar) {
        super(aVar);
    }

    public int a() {
        return this.f14386a;
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        boolean z2 = true;
        boolean z3 = (this.f14386a != i2) | (this.f14387c != i3) | (this.f14388d != i4) | (this.f14389e != i5) | (this.f14390f != i6) | (this.f14391g != i7) | (this.f14392h != i8) | (this.f14393i != i9);
        if (this.f14394j == i10) {
            z2 = false;
        }
        if (z3 || z2) {
            this.f14386a = i2;
            this.f14387c = i3;
            this.f14388d = i4;
            this.f14389e = i5;
            this.f14390f = i6;
            this.f14391g = i7;
            this.f14392h = i8;
            this.f14393i = i9;
            this.f14394j = i10;
            this.f11557b.Q().l((double) i2);
            this.f11557b.Q().m((double) i3);
            this.f11557b.Q().n((double) i4);
            this.f11557b.Q().o((double) i5);
            this.f11557b.Q().p((double) i6);
            this.f11557b.Q().q((double) i7);
            this.f11557b.Q().r((double) i8);
            this.f11557b.Q().s((double) i9);
            this.f11557b.Q().t((double) i10);
            c.a().d(new bc(60));
        }
    }

    public int b() {
        return this.f14387c;
    }

    public int c() {
        return this.f14388d;
    }

    public int d() {
        return this.f14389e;
    }

    public int e() {
        return this.f14390f;
    }

    public int f() {
        return this.f14391g;
    }

    public int g() {
        return this.f14392h;
    }

    public int h() {
        return this.f14393i;
    }

    public int i() {
        return this.f14394j;
    }
}
