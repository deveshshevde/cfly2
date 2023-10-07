package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import j.d;
import j.g;
import s.e;

class z {

    /* renamed from: a  reason: collision with root package name */
    final g<RecyclerView.v, a> f4337a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    final d<RecyclerView.v> f4338b = new d<>();

    static class a {

        /* renamed from: d  reason: collision with root package name */
        static e.a<a> f4339d = new e.b(20);

        /* renamed from: a  reason: collision with root package name */
        int f4340a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.e.c f4341b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.e.c f4342c;

        private a() {
        }

        static a a() {
            a a2 = f4339d.a();
            return a2 == null ? new a() : a2;
        }

        static void a(a aVar) {
            aVar.f4340a = 0;
            aVar.f4341b = null;
            aVar.f4342c = null;
            f4339d.a(aVar);
        }

        static void b() {
            do {
            } while (f4339d.a() != null);
        }
    }

    interface b {
        void a(RecyclerView.v vVar);

        void a(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);

        void b(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);

        void c(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2);
    }

    z() {
    }

    private RecyclerView.e.c a(RecyclerView.v vVar, int i2) {
        a c2;
        RecyclerView.e.c cVar;
        int a2 = this.f4337a.a((Object) vVar);
        if (a2 < 0 || (c2 = this.f4337a.c(a2)) == null || (c2.f4340a & i2) == 0) {
            return null;
        }
        c2.f4340a &= i2 ^ -1;
        if (i2 == 4) {
            cVar = c2.f4341b;
        } else if (i2 == 8) {
            cVar = c2.f4342c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((c2.f4340a & 12) == 0) {
            this.f4337a.d(a2);
            a.a(c2);
        }
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.v a(long j2) {
        return this.f4338b.a(j2);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f4337a.clear();
        this.f4338b.d();
    }

    /* access modifiers changed from: package-private */
    public void a(long j2, RecyclerView.v vVar) {
        this.f4338b.b(j2, vVar);
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.v vVar, RecyclerView.e.c cVar) {
        a aVar = this.f4337a.get(vVar);
        if (aVar == null) {
            aVar = a.a();
            this.f4337a.put(vVar, aVar);
        }
        aVar.f4341b = cVar;
        aVar.f4340a |= 4;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        RecyclerView.e.c cVar;
        RecyclerView.e.c cVar2;
        for (int size = this.f4337a.size() - 1; size >= 0; size--) {
            RecyclerView.v b2 = this.f4337a.b(size);
            a d2 = this.f4337a.d(size);
            if ((d2.f4340a & 3) != 3) {
                if ((d2.f4340a & 1) == 0) {
                    if ((d2.f4340a & 14) != 14) {
                        if ((d2.f4340a & 12) == 12) {
                            bVar.c(b2, d2.f4341b, d2.f4342c);
                        } else if ((d2.f4340a & 4) != 0) {
                            cVar = d2.f4341b;
                            cVar2 = null;
                        } else if ((d2.f4340a & 8) == 0) {
                            int i2 = d2.f4340a;
                        }
                        a.a(d2);
                    }
                    bVar.b(b2, d2.f4341b, d2.f4342c);
                    a.a(d2);
                } else if (d2.f4341b != null) {
                    cVar = d2.f4341b;
                    cVar2 = d2.f4342c;
                }
                bVar.a(b2, cVar, cVar2);
                a.a(d2);
            }
            bVar.a(b2);
            a.a(d2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.v vVar) {
        a aVar = this.f4337a.get(vVar);
        return (aVar == null || (aVar.f4340a & 1) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.e.c b(RecyclerView.v vVar) {
        return a(vVar, 4);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a.b();
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.v vVar, RecyclerView.e.c cVar) {
        a aVar = this.f4337a.get(vVar);
        if (aVar == null) {
            aVar = a.a();
            this.f4337a.put(vVar, aVar);
        }
        aVar.f4340a |= 2;
        aVar.f4341b = cVar;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.e.c c(RecyclerView.v vVar) {
        return a(vVar, 8);
    }

    /* access modifiers changed from: package-private */
    public void c(RecyclerView.v vVar, RecyclerView.e.c cVar) {
        a aVar = this.f4337a.get(vVar);
        if (aVar == null) {
            aVar = a.a();
            this.f4337a.put(vVar, aVar);
        }
        aVar.f4342c = cVar;
        aVar.f4340a |= 8;
    }

    /* access modifiers changed from: package-private */
    public boolean d(RecyclerView.v vVar) {
        a aVar = this.f4337a.get(vVar);
        return (aVar == null || (aVar.f4340a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.v vVar) {
        a aVar = this.f4337a.get(vVar);
        if (aVar == null) {
            aVar = a.a();
            this.f4337a.put(vVar, aVar);
        }
        aVar.f4340a |= 1;
    }

    /* access modifiers changed from: package-private */
    public void f(RecyclerView.v vVar) {
        a aVar = this.f4337a.get(vVar);
        if (aVar != null) {
            aVar.f4340a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void g(RecyclerView.v vVar) {
        int b2 = this.f4338b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            } else if (vVar == this.f4338b.c(b2)) {
                this.f4338b.a(b2);
                break;
            } else {
                b2--;
            }
        }
        a remove = this.f4337a.remove(vVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    public void h(RecyclerView.v vVar) {
        f(vVar);
    }
}
