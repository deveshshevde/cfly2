package com.scwang.smartrefresh.layout.constant;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12084a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f12085b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f12086c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f12087d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f12088e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f12089f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f12090g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f12091h;

    /* renamed from: i  reason: collision with root package name */
    public static final a f12092i;

    /* renamed from: j  reason: collision with root package name */
    public static final a f12093j;

    /* renamed from: k  reason: collision with root package name */
    public static final a f12094k;

    /* renamed from: l  reason: collision with root package name */
    public static final a f12095l;

    /* renamed from: o  reason: collision with root package name */
    public static final a[] f12096o;

    /* renamed from: m  reason: collision with root package name */
    public final int f12097m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f12098n;

    static {
        a aVar = new a(0, false);
        f12084a = aVar;
        a aVar2 = new a(1, true);
        f12085b = aVar2;
        a aVar3 = new a(2, false);
        f12086c = aVar3;
        a aVar4 = new a(3, true);
        f12087d = aVar4;
        a aVar5 = new a(4, false);
        f12088e = aVar5;
        a aVar6 = new a(5, true);
        f12089f = aVar6;
        a aVar7 = new a(6, false);
        f12090g = aVar7;
        a aVar8 = new a(7, true);
        f12091h = aVar8;
        a aVar9 = new a(8, false);
        f12092i = aVar9;
        a aVar10 = new a(9, true);
        f12093j = aVar10;
        a aVar11 = new a(10, false);
        f12094k = aVar11;
        a aVar12 = new a(10, true);
        f12095l = aVar12;
        f12096o = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12};
    }

    private a(int i2, boolean z2) {
        this.f12097m = i2;
        this.f12098n = z2;
    }

    public a a() {
        if (!this.f12098n) {
            return this;
        }
        a aVar = f12096o[this.f12097m - 1];
        return !aVar.f12098n ? aVar : f12084a;
    }

    public boolean a(a aVar) {
        int i2 = this.f12097m;
        int i3 = aVar.f12097m;
        return i2 < i3 || ((!this.f12098n || f12093j == this) && i2 == i3);
    }

    public a b() {
        return !this.f12098n ? f12096o[this.f12097m + 1] : this;
    }
}
