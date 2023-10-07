package com.bumptech.glide.load.engine;

import bl.b;
import bm.a;
import bo.n;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.e;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class f<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n.a<?>> f10278a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f10279b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private e f10280c;

    /* renamed from: d  reason: collision with root package name */
    private Object f10281d;

    /* renamed from: e  reason: collision with root package name */
    private int f10282e;

    /* renamed from: f  reason: collision with root package name */
    private int f10283f;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f10284g;

    /* renamed from: h  reason: collision with root package name */
    private DecodeJob.d f10285h;

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.load.f f10286i;

    /* renamed from: j  reason: collision with root package name */
    private Map<Class<?>, i<?>> f10287j;

    /* renamed from: k  reason: collision with root package name */
    private Class<Transcode> f10288k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10289l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10290m;

    /* renamed from: n  reason: collision with root package name */
    private c f10291n;

    /* renamed from: o  reason: collision with root package name */
    private Priority f10292o;

    /* renamed from: p  reason: collision with root package name */
    private h f10293p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f10294q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10295r;

    f() {
    }

    /* access modifiers changed from: package-private */
    public <T> com.bumptech.glide.load.data.e<T> a(T t2) {
        return this.f10280c.d().b(t2);
    }

    /* access modifiers changed from: package-private */
    public List<n<File, ?>> a(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f10280c.d().c(file);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f10280c = null;
        this.f10281d = null;
        this.f10291n = null;
        this.f10284g = null;
        this.f10288k = null;
        this.f10286i = null;
        this.f10292o = null;
        this.f10287j = null;
        this.f10293p = null;
        this.f10278a.clear();
        this.f10289l = false;
        this.f10279b.clear();
        this.f10290m = false;
    }

    /* access modifiers changed from: package-private */
    public <R> void a(e eVar, Object obj, c cVar, int i2, int i3, h hVar, Class<?> cls, Class<R> cls2, Priority priority, com.bumptech.glide.load.f fVar, Map<Class<?>, i<?>> map, boolean z2, boolean z3, DecodeJob.d dVar) {
        this.f10280c = eVar;
        this.f10281d = obj;
        this.f10291n = cVar;
        this.f10282e = i2;
        this.f10283f = i3;
        this.f10293p = hVar;
        this.f10284g = cls;
        this.f10285h = dVar;
        this.f10288k = cls2;
        this.f10292o = priority;
        this.f10286i = fVar;
        this.f10287j = map;
        this.f10294q = z2;
        this.f10295r = z3;
    }

    /* access modifiers changed from: package-private */
    public boolean a(c cVar) {
        List<n.a<?>> n2 = n();
        int size = n2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (n2.get(i2).f5901a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(s<?> sVar) {
        return this.f10280c.d().a(sVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(Class<?> cls) {
        return b(cls) != null;
    }

    /* access modifiers changed from: package-private */
    public a b() {
        return this.f10285h.a();
    }

    /* access modifiers changed from: package-private */
    public <X> com.bumptech.glide.load.a<X> b(X x2) throws Registry.NoSourceEncoderAvailableException {
        return this.f10280c.d().a(x2);
    }

    /* access modifiers changed from: package-private */
    public <Data> q<Data, ?, Transcode> b(Class<Data> cls) {
        return this.f10280c.d().a(cls, this.f10284g, this.f10288k);
    }

    /* access modifiers changed from: package-private */
    public <Z> h<Z> b(s<Z> sVar) {
        return this.f10280c.d().b(sVar);
    }

    /* access modifiers changed from: package-private */
    public h c() {
        return this.f10293p;
    }

    /* access modifiers changed from: package-private */
    public <Z> i<Z> c(Class<Z> cls) {
        i<Z> iVar = this.f10287j.get(cls);
        if (iVar == null) {
            Iterator<Map.Entry<Class<?>, i<?>>> it2 = this.f10287j.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    iVar = (i) next.getValue();
                    break;
                }
            }
        }
        if (iVar != null) {
            return iVar;
        }
        if (!this.f10287j.isEmpty() || !this.f10294q) {
            return bq.c.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* access modifiers changed from: package-private */
    public Priority d() {
        return this.f10292o;
    }

    /* access modifiers changed from: package-private */
    public com.bumptech.glide.load.f e() {
        return this.f10286i;
    }

    /* access modifiers changed from: package-private */
    public c f() {
        return this.f10291n;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f10282e;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f10283f;
    }

    /* access modifiers changed from: package-private */
    public b i() {
        return this.f10280c.f();
    }

    /* access modifiers changed from: package-private */
    public Class<?> j() {
        return this.f10288k;
    }

    /* access modifiers changed from: package-private */
    public Class<?> k() {
        return this.f10281d.getClass();
    }

    /* access modifiers changed from: package-private */
    public List<Class<?>> l() {
        return this.f10280c.d().b(this.f10281d.getClass(), this.f10284g, this.f10288k);
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f10295r;
    }

    /* access modifiers changed from: package-private */
    public List<n.a<?>> n() {
        if (!this.f10289l) {
            this.f10289l = true;
            this.f10278a.clear();
            List c2 = this.f10280c.d().c(this.f10281d);
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a a2 = ((n) c2.get(i2)).a(this.f10281d, this.f10282e, this.f10283f, this.f10286i);
                if (a2 != null) {
                    this.f10278a.add(a2);
                }
            }
        }
        return this.f10278a;
    }

    /* access modifiers changed from: package-private */
    public List<c> o() {
        if (!this.f10290m) {
            this.f10290m = true;
            this.f10279b.clear();
            List<n.a<?>> n2 = n();
            int size = n2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a aVar = n2.get(i2);
                if (!this.f10279b.contains(aVar.f5901a)) {
                    this.f10279b.add(aVar.f5901a);
                }
                for (int i3 = 0; i3 < aVar.f5902b.size(); i3++) {
                    if (!this.f10279b.contains(aVar.f5902b.get(i3))) {
                        this.f10279b.add(aVar.f5902b.get(i3));
                    }
                }
            }
        }
        return this.f10279b;
    }
}
