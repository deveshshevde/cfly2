package com.bumptech.glide;

import android.content.Context;
import bl.e;
import bl.j;
import bl.k;
import bm.a;
import bm.h;
import bm.i;
import bw.p;
import com.bumptech.glide.c;
import com.bumptech.glide.f;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.request.g;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, i<?, ?>> f10061a = new j.a();

    /* renamed from: b  reason: collision with root package name */
    private final f.a f10062b = new f.a();

    /* renamed from: c  reason: collision with root package name */
    private i f10063c;

    /* renamed from: d  reason: collision with root package name */
    private e f10064d;

    /* renamed from: e  reason: collision with root package name */
    private bl.b f10065e;

    /* renamed from: f  reason: collision with root package name */
    private h f10066f;

    /* renamed from: g  reason: collision with root package name */
    private bn.a f10067g;

    /* renamed from: h  reason: collision with root package name */
    private bn.a f10068h;

    /* renamed from: i  reason: collision with root package name */
    private a.C0051a f10069i;

    /* renamed from: j  reason: collision with root package name */
    private bm.i f10070j;

    /* renamed from: k  reason: collision with root package name */
    private bw.d f10071k;

    /* renamed from: l  reason: collision with root package name */
    private int f10072l = 4;

    /* renamed from: m  reason: collision with root package name */
    private c.a f10073m = new c.a() {
        public com.bumptech.glide.request.h a() {
            return new com.bumptech.glide.request.h();
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private p.a f10074n;

    /* renamed from: o  reason: collision with root package name */
    private bn.a f10075o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f10076p;

    /* renamed from: q  reason: collision with root package name */
    private List<g<Object>> f10077q;

    static final class a {
        a() {
        }
    }

    static final class b {
        b() {
        }
    }

    public static final class c {
    }

    /* renamed from: com.bumptech.glide.d$d  reason: collision with other inner class name */
    public static final class C0079d {
        private C0079d() {
        }
    }

    /* access modifiers changed from: package-private */
    public c a(Context context) {
        if (this.f10067g == null) {
            this.f10067g = bn.a.d();
        }
        if (this.f10068h == null) {
            this.f10068h = bn.a.b();
        }
        if (this.f10075o == null) {
            this.f10075o = bn.a.g();
        }
        if (this.f10070j == null) {
            this.f10070j = new i.a(context).a();
        }
        if (this.f10071k == null) {
            this.f10071k = new bw.f();
        }
        if (this.f10064d == null) {
            int b2 = this.f10070j.b();
            if (b2 > 0) {
                this.f10064d = new k((long) b2);
            } else {
                this.f10064d = new bl.f();
            }
        }
        if (this.f10065e == null) {
            this.f10065e = new j(this.f10070j.c());
        }
        if (this.f10066f == null) {
            this.f10066f = new bm.g((long) this.f10070j.a());
        }
        if (this.f10069i == null) {
            this.f10069i = new bm.f(context);
        }
        if (this.f10063c == null) {
            this.f10063c = new com.bumptech.glide.load.engine.i(this.f10066f, this.f10069i, this.f10068h, this.f10067g, bn.a.e(), this.f10075o, this.f10076p);
        }
        List<g<Object>> list = this.f10077q;
        this.f10077q = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        f a2 = this.f10062b.a();
        return new c(context, this.f10063c, this.f10066f, this.f10064d, this.f10065e, new p(this.f10074n, a2), this.f10071k, this.f10072l, this.f10073m, this.f10061a, this.f10077q, a2);
    }

    public d a(a.C0051a aVar) {
        this.f10069i = aVar;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(p.a aVar) {
        this.f10074n = aVar;
    }
}
