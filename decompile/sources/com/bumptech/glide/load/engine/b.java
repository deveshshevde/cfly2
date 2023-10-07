package com.bumptech.glide.load.engine;

import bo.n;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.e;
import java.io.File;
import java.util.List;

class b implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    private final List<c> f10264a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f10265b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a f10266c;

    /* renamed from: d  reason: collision with root package name */
    private int f10267d;

    /* renamed from: e  reason: collision with root package name */
    private c f10268e;

    /* renamed from: f  reason: collision with root package name */
    private List<n<File, ?>> f10269f;

    /* renamed from: g  reason: collision with root package name */
    private int f10270g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f10271h;

    /* renamed from: i  reason: collision with root package name */
    private File f10272i;

    b(f<?> fVar, e.a aVar) {
        this(fVar.o(), fVar, aVar);
    }

    b(List<c> list, f<?> fVar, e.a aVar) {
        this.f10267d = -1;
        this.f10264a = list;
        this.f10265b = fVar;
        this.f10266c = aVar;
    }

    private boolean c() {
        return this.f10270g < this.f10269f.size();
    }

    public void a(Exception exc) {
        this.f10266c.a(this.f10268e, exc, this.f10271h.f5903c, DataSource.DATA_DISK_CACHE);
    }

    public void a(Object obj) {
        this.f10266c.a(this.f10268e, obj, this.f10271h.f5903c, DataSource.DATA_DISK_CACHE, this.f10268e);
    }

    public boolean a() {
        cd.b.a("DataCacheGenerator.startNext");
        while (true) {
            try {
                boolean z2 = false;
                if (this.f10269f != null) {
                    if (c()) {
                        this.f10271h = null;
                        while (!z2 && c()) {
                            List<n<File, ?>> list = this.f10269f;
                            int i2 = this.f10270g;
                            this.f10270g = i2 + 1;
                            this.f10271h = list.get(i2).a(this.f10272i, this.f10265b.g(), this.f10265b.h(), this.f10265b.e());
                            if (this.f10271h != null && this.f10265b.a((Class<?>) this.f10271h.f5903c.a())) {
                                this.f10271h.f5903c.a(this.f10265b.d(), this);
                                z2 = true;
                            }
                        }
                        cd.b.a();
                        return z2;
                    }
                }
                int i3 = this.f10267d + 1;
                this.f10267d = i3;
                if (i3 >= this.f10264a.size()) {
                    return false;
                }
                c cVar = this.f10264a.get(this.f10267d);
                File a2 = this.f10265b.b().a(new c(cVar, this.f10265b.f()));
                this.f10272i = a2;
                if (a2 != null) {
                    this.f10268e = cVar;
                    this.f10269f = this.f10265b.a(a2);
                    this.f10270g = 0;
                }
            } finally {
                cd.b.a();
            }
        }
    }

    public void b() {
        n.a<?> aVar = this.f10271h;
        if (aVar != null) {
            aVar.f5903c.c();
        }
    }
}
