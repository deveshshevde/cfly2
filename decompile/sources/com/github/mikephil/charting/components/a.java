package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import ez.d;
import fg.i;
import java.util.ArrayList;
import java.util.List;

public abstract class a extends b {
    private int C = -7829368;
    private float D = 1.0f;
    private int E = -7829368;
    private float F = 1.0f;
    private int G = 6;
    private DashPathEffect H = null;
    private DashPathEffect I = null;

    /* renamed from: a  reason: collision with root package name */
    protected d f14923a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f14924b = new float[0];

    /* renamed from: c  reason: collision with root package name */
    public float[] f14925c = new float[0];

    /* renamed from: d  reason: collision with root package name */
    public int f14926d;

    /* renamed from: e  reason: collision with root package name */
    public int f14927e;

    /* renamed from: f  reason: collision with root package name */
    protected float f14928f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f14929g = false;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f14930h = false;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f14931i = true;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f14932j = true;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f14933k = true;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f14934l = false;

    /* renamed from: m  reason: collision with root package name */
    protected List<LimitLine> f14935m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f14936n = false;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f14937o = true;

    /* renamed from: p  reason: collision with root package name */
    protected float f14938p = 0.0f;

    /* renamed from: q  reason: collision with root package name */
    protected float f14939q = 0.0f;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f14940r = false;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f14941s = false;

    /* renamed from: t  reason: collision with root package name */
    public float f14942t = 0.0f;

    /* renamed from: u  reason: collision with root package name */
    public float f14943u = 0.0f;

    /* renamed from: v  reason: collision with root package name */
    public float f14944v = 0.0f;

    public a() {
        this.A = i.a(10.0f);
        this.f14946x = i.a(5.0f);
        this.f14947y = i.a(5.0f);
        this.f14935m = new ArrayList();
    }

    public String a(int i2) {
        return (i2 < 0 || i2 >= this.f14924b.length) ? "" : q().a(this.f14924b[i2], this);
    }

    public void a(float f2) {
        this.f14938p = f2;
    }

    public void a(float f2, float f3) {
        float f4 = this.f14940r ? this.f14943u : f2 - this.f14938p;
        float f5 = this.f14941s ? this.f14942t : f3 + this.f14939q;
        if (Math.abs(f5 - f4) == 0.0f) {
            f5 += 1.0f;
            f4 -= 1.0f;
        }
        this.f14943u = f4;
        this.f14942t = f5;
        this.f14944v = Math.abs(f5 - f4);
    }

    public boolean a() {
        return this.f14931i;
    }

    public void b(float f2) {
        this.f14939q = f2;
    }

    public boolean b() {
        return this.f14932j;
    }

    public boolean c() {
        return this.f14934l && this.f14926d > 0;
    }

    public int d() {
        return this.C;
    }

    public float e() {
        return this.F;
    }

    public float f() {
        return this.D;
    }

    public int g() {
        return this.E;
    }

    public boolean h() {
        return this.f14933k;
    }

    public boolean i() {
        return this.f14930h;
    }

    public int j() {
        return this.G;
    }

    public boolean k() {
        return this.f14929g;
    }

    public float l() {
        return this.f14928f;
    }

    public List<LimitLine> m() {
        return this.f14935m;
    }

    public boolean n() {
        return this.f14936n;
    }

    public boolean o() {
        return this.f14937o;
    }

    public String p() {
        String str = "";
        for (int i2 = 0; i2 < this.f14924b.length; i2++) {
            String a2 = a(i2);
            if (a2 != null && str.length() < a2.length()) {
                str = a2;
            }
        }
        return str;
    }

    public d q() {
        d dVar = this.f14923a;
        if (dVar == null || ((dVar instanceof ez.a) && ((ez.a) dVar).a() != this.f14927e)) {
            this.f14923a = new ez.a(this.f14927e);
        }
        return this.f14923a;
    }

    public DashPathEffect r() {
        return this.I;
    }

    public DashPathEffect s() {
        return this.H;
    }
}
