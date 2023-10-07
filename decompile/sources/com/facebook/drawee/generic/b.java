package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.drawee.drawable.n;
import df.c;
import java.util.Arrays;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final n.b f11275a = n.b.f11244f;

    /* renamed from: b  reason: collision with root package name */
    public static final n.b f11276b = n.b.f11245g;

    /* renamed from: c  reason: collision with root package name */
    private Resources f11277c;

    /* renamed from: d  reason: collision with root package name */
    private int f11278d;

    /* renamed from: e  reason: collision with root package name */
    private float f11279e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f11280f;

    /* renamed from: g  reason: collision with root package name */
    private n.b f11281g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f11282h;

    /* renamed from: i  reason: collision with root package name */
    private n.b f11283i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f11284j;

    /* renamed from: k  reason: collision with root package name */
    private n.b f11285k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f11286l;

    /* renamed from: m  reason: collision with root package name */
    private n.b f11287m;

    /* renamed from: n  reason: collision with root package name */
    private n.b f11288n;

    /* renamed from: o  reason: collision with root package name */
    private Matrix f11289o;

    /* renamed from: p  reason: collision with root package name */
    private PointF f11290p;

    /* renamed from: q  reason: collision with root package name */
    private ColorFilter f11291q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f11292r;

    /* renamed from: s  reason: collision with root package name */
    private List<Drawable> f11293s;

    /* renamed from: t  reason: collision with root package name */
    private Drawable f11294t;

    /* renamed from: u  reason: collision with root package name */
    private RoundingParams f11295u;

    public b(Resources resources) {
        this.f11277c = resources;
        t();
    }

    private void t() {
        this.f11278d = 300;
        this.f11279e = 0.0f;
        this.f11280f = null;
        n.b bVar = f11275a;
        this.f11281g = bVar;
        this.f11282h = null;
        this.f11283i = bVar;
        this.f11284j = null;
        this.f11285k = bVar;
        this.f11286l = null;
        this.f11287m = bVar;
        this.f11288n = f11276b;
        this.f11289o = null;
        this.f11290p = null;
        this.f11291q = null;
        this.f11292r = null;
        this.f11293s = null;
        this.f11294t = null;
        this.f11295u = null;
    }

    private void u() {
        List<Drawable> list = this.f11293s;
        if (list != null) {
            for (Drawable a2 : list) {
                c.a(a2);
            }
        }
    }

    public Resources a() {
        return this.f11277c;
    }

    public b a(float f2) {
        this.f11279e = f2;
        return this;
    }

    public b a(int i2) {
        this.f11278d = i2;
        return this;
    }

    public b a(Drawable drawable) {
        this.f11280f = drawable;
        return this;
    }

    public b a(n.b bVar) {
        this.f11281g = bVar;
        return this;
    }

    public b a(RoundingParams roundingParams) {
        this.f11295u = roundingParams;
        return this;
    }

    public int b() {
        return this.f11278d;
    }

    public b b(Drawable drawable) {
        this.f11282h = drawable;
        return this;
    }

    public b b(n.b bVar) {
        this.f11283i = bVar;
        return this;
    }

    public float c() {
        return this.f11279e;
    }

    public b c(Drawable drawable) {
        this.f11284j = drawable;
        return this;
    }

    public b c(n.b bVar) {
        this.f11285k = bVar;
        return this;
    }

    public Drawable d() {
        return this.f11280f;
    }

    public b d(Drawable drawable) {
        this.f11286l = drawable;
        return this;
    }

    public b d(n.b bVar) {
        this.f11287m = bVar;
        return this;
    }

    public n.b e() {
        return this.f11281g;
    }

    public b e(Drawable drawable) {
        this.f11292r = drawable;
        return this;
    }

    public b e(n.b bVar) {
        this.f11288n = bVar;
        this.f11289o = null;
        return this;
    }

    public Drawable f() {
        return this.f11282h;
    }

    public b f(Drawable drawable) {
        List<Drawable> list;
        if (drawable == null) {
            list = null;
        } else {
            list = Arrays.asList(new Drawable[]{drawable});
        }
        this.f11293s = list;
        return this;
    }

    public n.b g() {
        return this.f11283i;
    }

    public b g(Drawable drawable) {
        if (drawable == null) {
            this.f11294t = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.f11294t = stateListDrawable;
        }
        return this;
    }

    public Drawable h() {
        return this.f11284j;
    }

    public n.b i() {
        return this.f11285k;
    }

    public Drawable j() {
        return this.f11286l;
    }

    public n.b k() {
        return this.f11287m;
    }

    public n.b l() {
        return this.f11288n;
    }

    public PointF m() {
        return this.f11290p;
    }

    public ColorFilter n() {
        return this.f11291q;
    }

    public Drawable o() {
        return this.f11292r;
    }

    public List<Drawable> p() {
        return this.f11293s;
    }

    public Drawable q() {
        return this.f11294t;
    }

    public RoundingParams r() {
        return this.f11295u;
    }

    public a s() {
        u();
        return new a(this);
    }
}
