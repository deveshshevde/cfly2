package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import bu.c;
import bw.c;
import bw.l;
import bw.m;
import bw.q;
import bw.r;
import bw.u;
import bz.d;
import bz.j;
import com.bumptech.glide.request.e;
import com.bumptech.glide.request.g;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h implements ComponentCallbacks2, m {

    /* renamed from: d  reason: collision with root package name */
    private static final com.bumptech.glide.request.h f10109d = ((com.bumptech.glide.request.h) com.bumptech.glide.request.h.b((Class<?>) Bitmap.class).m());

    /* renamed from: e  reason: collision with root package name */
    private static final com.bumptech.glide.request.h f10110e = ((com.bumptech.glide.request.h) com.bumptech.glide.request.h.b((Class<?>) c.class).m());

    /* renamed from: f  reason: collision with root package name */
    private static final com.bumptech.glide.request.h f10111f = ((com.bumptech.glide.request.h) ((com.bumptech.glide.request.h) com.bumptech.glide.request.h.b(com.bumptech.glide.load.engine.h.f10303c).a(Priority.LOW)).b(true));

    /* renamed from: a  reason: collision with root package name */
    protected final c f10112a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f10113b;

    /* renamed from: c  reason: collision with root package name */
    final l f10114c;

    /* renamed from: g  reason: collision with root package name */
    private final r f10115g;

    /* renamed from: h  reason: collision with root package name */
    private final q f10116h;

    /* renamed from: i  reason: collision with root package name */
    private final u f10117i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f10118j;

    /* renamed from: k  reason: collision with root package name */
    private final bw.c f10119k;

    /* renamed from: l  reason: collision with root package name */
    private final CopyOnWriteArrayList<g<Object>> f10120l;

    /* renamed from: m  reason: collision with root package name */
    private com.bumptech.glide.request.h f10121m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10122n;

    private static class a extends d<View, Object> {
        a(View view) {
            super(view);
        }

        public void a(Object obj, ca.b<? super Object> bVar) {
        }

        /* access modifiers changed from: protected */
        public void a_(Drawable drawable) {
        }

        public void b(Drawable drawable) {
        }
    }

    private class b implements c.a {

        /* renamed from: b  reason: collision with root package name */
        private final r f10125b;

        b(r rVar) {
            this.f10125b = rVar;
        }

        public void a(boolean z2) {
            if (z2) {
                synchronized (h.this) {
                    this.f10125b.e();
                }
            }
        }
    }

    public h(c cVar, l lVar, q qVar, Context context) {
        this(cVar, lVar, qVar, new r(), cVar.d(), context);
    }

    h(c cVar, l lVar, q qVar, r rVar, bw.d dVar, Context context) {
        this.f10117i = new u();
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                h.this.f10114c.a(h.this);
            }
        };
        this.f10118j = r0;
        this.f10112a = cVar;
        this.f10114c = lVar;
        this.f10116h = qVar;
        this.f10115g = rVar;
        this.f10113b = context;
        bw.c a2 = dVar.a(context.getApplicationContext(), new b(rVar));
        this.f10119k = a2;
        if (cc.l.d()) {
            cc.l.a((Runnable) r0);
        } else {
            lVar.a(this);
        }
        lVar.a(a2);
        this.f10120l = new CopyOnWriteArrayList<>(cVar.e().a());
        a(cVar.e().b());
        cVar.a(this);
    }

    private void c(j<?> jVar) {
        boolean b2 = b(jVar);
        e a2 = jVar.a();
        if (!b2 && !this.f10112a.a(jVar) && a2 != null) {
            jVar.a((e) null);
            a2.b();
        }
    }

    public <ResourceType> g<ResourceType> a(Class<ResourceType> cls) {
        return new g<>(this.f10112a, this, cls, this.f10113b);
    }

    public g<Drawable> a(Object obj) {
        return j().a(obj);
    }

    public g<Drawable> a(String str) {
        return j().a(str);
    }

    public synchronized void a() {
        this.f10115g.a();
    }

    public void a(View view) {
        a((j<?>) new a(view));
    }

    public void a(j<?> jVar) {
        if (jVar != null) {
            c(jVar);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(j<?> jVar, e eVar) {
        this.f10117i.a(jVar);
        this.f10115g.a(eVar);
    }

    /* access modifiers changed from: protected */
    public synchronized void a(com.bumptech.glide.request.h hVar) {
        this.f10121m = (com.bumptech.glide.request.h) ((com.bumptech.glide.request.h) hVar.clone()).n();
    }

    public synchronized h b(com.bumptech.glide.request.h hVar) {
        a(hVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public <T> i<?, T> b(Class<T> cls) {
        return this.f10112a.e().a(cls);
    }

    public synchronized void b() {
        this.f10115g.b();
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean b(j<?> jVar) {
        e a2 = jVar.a();
        if (a2 == null) {
            return true;
        }
        if (!this.f10115g.b(a2)) {
            return false;
        }
        this.f10117i.b(jVar);
        jVar.a((e) null);
        return true;
    }

    public synchronized void c() {
        b();
        for (h b2 : this.f10116h.a()) {
            b2.b();
        }
    }

    public synchronized void d() {
        this.f10115g.c();
    }

    public synchronized void e() {
        d();
        this.f10117i.e();
    }

    public synchronized void f() {
        a();
        this.f10117i.f();
    }

    public synchronized void g() {
        this.f10117i.g();
        for (j<?> a2 : this.f10117i.a()) {
            a(a2);
        }
        this.f10117i.b();
        this.f10115g.d();
        this.f10114c.b(this);
        this.f10114c.b(this.f10119k);
        cc.l.b(this.f10118j);
        this.f10112a.b(this);
    }

    public g<Bitmap> h() {
        return a(Bitmap.class).b((com.bumptech.glide.request.a<?>) f10109d);
    }

    public g<bu.c> i() {
        return a(bu.c.class).b((com.bumptech.glide.request.a<?>) f10110e);
    }

    public g<Drawable> j() {
        return a(Drawable.class);
    }

    public g<File> k() {
        return a(File.class).b((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.c(true));
    }

    /* access modifiers changed from: package-private */
    public List<g<Object>> l() {
        return this.f10120l;
    }

    /* access modifiers changed from: package-private */
    public synchronized com.bumptech.glide.request.h m() {
        return this.f10121m;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.f10122n) {
            c();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f10115g + ", treeNode=" + this.f10116h + "}";
    }
}
