package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.q;
import fj.h;
import java.io.IOException;

final class l {

    /* renamed from: a  reason: collision with root package name */
    public c f15641a;

    /* renamed from: b  reason: collision with root package name */
    public long f15642b;

    /* renamed from: c  reason: collision with root package name */
    public long f15643c;

    /* renamed from: d  reason: collision with root package name */
    public long f15644d;

    /* renamed from: e  reason: collision with root package name */
    public int f15645e;

    /* renamed from: f  reason: collision with root package name */
    public int f15646f;

    /* renamed from: g  reason: collision with root package name */
    public long[] f15647g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f15648h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f15649i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f15650j;

    /* renamed from: k  reason: collision with root package name */
    public long[] f15651k;

    /* renamed from: l  reason: collision with root package name */
    public boolean[] f15652l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f15653m;

    /* renamed from: n  reason: collision with root package name */
    public boolean[] f15654n;

    /* renamed from: o  reason: collision with root package name */
    public k f15655o;

    /* renamed from: p  reason: collision with root package name */
    public int f15656p;

    /* renamed from: q  reason: collision with root package name */
    public q f15657q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f15658r;

    /* renamed from: s  reason: collision with root package name */
    public long f15659s;

    l() {
    }

    public void a() {
        this.f15645e = 0;
        this.f15659s = 0;
        this.f15653m = false;
        this.f15658r = false;
        this.f15655o = null;
    }

    public void a(int i2) {
        q qVar = this.f15657q;
        if (qVar == null || qVar.c() < i2) {
            this.f15657q = new q(i2);
        }
        this.f15656p = i2;
        this.f15653m = true;
        this.f15658r = true;
    }

    public void a(int i2, int i3) {
        this.f15645e = i2;
        this.f15646f = i3;
        int[] iArr = this.f15648h;
        if (iArr == null || iArr.length < i2) {
            this.f15647g = new long[i2];
            this.f15648h = new int[i2];
        }
        int[] iArr2 = this.f15649i;
        if (iArr2 == null || iArr2.length < i3) {
            int i4 = (i3 * 125) / 100;
            this.f15649i = new int[i4];
            this.f15650j = new int[i4];
            this.f15651k = new long[i4];
            this.f15652l = new boolean[i4];
            this.f15654n = new boolean[i4];
        }
    }

    public void a(q qVar) {
        qVar.a(this.f15657q.f17159a, 0, this.f15656p);
        this.f15657q.c(0);
        this.f15658r = false;
    }

    public void a(h hVar) throws IOException, InterruptedException {
        hVar.b(this.f15657q.f17159a, 0, this.f15656p);
        this.f15657q.c(0);
        this.f15658r = false;
    }

    public long b(int i2) {
        return this.f15651k[i2] + ((long) this.f15650j[i2]);
    }

    public boolean c(int i2) {
        return this.f15653m && this.f15654n[i2];
    }
}
