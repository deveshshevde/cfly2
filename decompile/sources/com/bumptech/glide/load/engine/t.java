package com.bumptech.glide.load.engine;

import bo.n;
import cd.b;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.e;
import java.io.File;
import java.util.List;

class t implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    private final e.a f10392a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f10393b;

    /* renamed from: c  reason: collision with root package name */
    private int f10394c;

    /* renamed from: d  reason: collision with root package name */
    private int f10395d = -1;

    /* renamed from: e  reason: collision with root package name */
    private c f10396e;

    /* renamed from: f  reason: collision with root package name */
    private List<n<File, ?>> f10397f;

    /* renamed from: g  reason: collision with root package name */
    private int f10398g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f10399h;

    /* renamed from: i  reason: collision with root package name */
    private File f10400i;

    /* renamed from: j  reason: collision with root package name */
    private u f10401j;

    t(f<?> fVar, e.a aVar) {
        this.f10393b = fVar;
        this.f10392a = aVar;
    }

    private boolean c() {
        return this.f10398g < this.f10397f.size();
    }

    public void a(Exception exc) {
        this.f10392a.a(this.f10401j, exc, this.f10399h.f5903c, DataSource.RESOURCE_DISK_CACHE);
    }

    public void a(Object obj) {
        this.f10392a.a(this.f10396e, obj, this.f10399h.f5903c, DataSource.RESOURCE_DISK_CACHE, this.f10401j);
    }

    public boolean a() {
        b.a("ResourceCacheGenerator.startNext");
        try {
            List<c> o2 = this.f10393b.o();
            boolean z2 = false;
            if (o2.isEmpty()) {
                return false;
            }
            List<Class<?>> l2 = this.f10393b.l();
            if (!l2.isEmpty()) {
                while (true) {
                    if (this.f10397f != null) {
                        if (c()) {
                            this.f10399h = null;
                            while (!z2 && c()) {
                                List<n<File, ?>> list = this.f10397f;
                                int i2 = this.f10398g;
                                this.f10398g = i2 + 1;
                                this.f10399h = list.get(i2).a(this.f10400i, this.f10393b.g(), this.f10393b.h(), this.f10393b.e());
                                if (this.f10399h != null && this.f10393b.a((Class<?>) this.f10399h.f5903c.a())) {
                                    this.f10399h.f5903c.a(this.f10393b.d(), this);
                                    z2 = true;
                                }
                            }
                            b.a();
                            return z2;
                        }
                    }
                    int i3 = this.f10395d + 1;
                    this.f10395d = i3;
                    if (i3 >= l2.size()) {
                        int i4 = this.f10394c + 1;
                        this.f10394c = i4;
                        if (i4 >= o2.size()) {
                            b.a();
                            return false;
                        }
                        this.f10395d = 0;
                    }
                    c cVar = o2.get(this.f10394c);
                    Class cls = l2.get(this.f10395d);
                    c cVar2 = cVar;
                    this.f10401j = new u(this.f10393b.i(), cVar2, this.f10393b.f(), this.f10393b.g(), this.f10393b.h(), this.f10393b.c(cls), cls, this.f10393b.e());
                    File a2 = this.f10393b.b().a(this.f10401j);
                    this.f10400i = a2;
                    if (a2 != null) {
                        this.f10396e = cVar;
                        this.f10397f = this.f10393b.a(a2);
                        this.f10398g = 0;
                    }
                }
            } else if (File.class.equals(this.f10393b.j())) {
                b.a();
                return false;
            } else {
                throw new IllegalStateException("Failed to find any load path from " + this.f10393b.k() + " to " + this.f10393b.j());
            }
        } finally {
            b.a();
        }
    }

    public void b() {
        n.a<?> aVar = this.f10399h;
        if (aVar != null) {
            aVar.f5903c.c();
        }
    }
}
