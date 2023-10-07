package lk;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t.ac;
import t.ag;
import t.ah;

public abstract class a extends w {

    /* renamed from: a  reason: collision with root package name */
    protected RecyclerView f30882a;

    /* renamed from: b  reason: collision with root package name */
    protected ArrayList<RecyclerView.v> f30883b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    protected ArrayList<RecyclerView.v> f30884c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    protected ArrayList<RecyclerView.v> f30885d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    protected ArrayList<RecyclerView.v> f30886e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<RecyclerView.v> f30887f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<RecyclerView.v> f30888g = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<b> f30889i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<C0219a> f30890j = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<ArrayList<RecyclerView.v>> f30891k = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ArrayList<ArrayList<b>> f30892l = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public ArrayList<ArrayList<C0219a>> f30893m = new ArrayList<>();

    /* renamed from: lk.a$a  reason: collision with other inner class name */
    private static class C0219a {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.v f30912a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.v f30913b;

        /* renamed from: c  reason: collision with root package name */
        public int f30914c;

        /* renamed from: d  reason: collision with root package name */
        public int f30915d;

        /* renamed from: e  reason: collision with root package name */
        public int f30916e;

        /* renamed from: f  reason: collision with root package name */
        public int f30917f;

        private C0219a(RecyclerView.v vVar, RecyclerView.v vVar2) {
            this.f30912a = vVar;
            this.f30913b = vVar2;
        }

        private C0219a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
            this(vVar, vVar2);
            this.f30914c = i2;
            this.f30915d = i3;
            this.f30916e = i4;
            this.f30917f = i5;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f30912a + ", newHolder=" + this.f30913b + ", fromX=" + this.f30914c + ", fromY=" + this.f30915d + ", toX=" + this.f30916e + ", toY=" + this.f30917f + '}';
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.v f30918a;

        /* renamed from: b  reason: collision with root package name */
        public int f30919b;

        /* renamed from: c  reason: collision with root package name */
        public int f30920c;

        /* renamed from: d  reason: collision with root package name */
        public int f30921d;

        /* renamed from: e  reason: collision with root package name */
        public int f30922e;

        private b(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
            this.f30918a = vVar;
            this.f30919b = i2;
            this.f30920c = i3;
            this.f30921d = i4;
            this.f30922e = i5;
        }
    }

    protected static class c implements ah {
        protected c() {
        }

        public void a(View view) {
        }

        public void b(View view) {
        }

        public void c(View view) {
        }
    }

    public a(RecyclerView recyclerView) {
        this.f30882a = recyclerView;
    }

    private void a(List<C0219a> list, RecyclerView.v vVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0219a aVar = list.get(size);
            if (a(aVar, vVar) && aVar.f30912a == null && aVar.f30913b == null) {
                list.remove(aVar);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final C0219a aVar) {
        RecyclerView.v vVar = aVar.f30912a;
        final View view = null;
        View view2 = vVar == null ? null : vVar.itemView;
        RecyclerView.v vVar2 = aVar.f30913b;
        if (vVar2 != null) {
            view = vVar2.itemView;
        }
        if (view2 != null) {
            final ag a2 = ac.r(view2).a(h());
            this.f30886e.add(aVar.f30912a);
            a2.b((float) (aVar.f30916e - aVar.f30914c));
            a2.c((float) (aVar.f30917f - aVar.f30915d));
            a2.a(0.0f).a((ah) new c() {
                public void a(View view) {
                    a.this.b(aVar.f30912a, true);
                }

                public void b(View view) {
                    a2.a((ah) null);
                    ac.c(view, 1.0f);
                    ac.a(view, 0.0f);
                    ac.b(view, 0.0f);
                    a.this.a(aVar.f30912a, true);
                    a.this.f30886e.remove(aVar.f30912a);
                    a.this.c();
                }
            }).c();
        }
        if (view != null) {
            final ag r2 = ac.r(view);
            this.f30886e.add(aVar.f30913b);
            r2.b(0.0f).c(0.0f).a(h()).a(1.0f).a((ah) new c() {
                public void a(View view) {
                    a.this.b(aVar.f30913b, false);
                }

                public void b(View view) {
                    r2.a((ah) null);
                    ac.c(view, 1.0f);
                    ac.a(view, 0.0f);
                    ac.b(view, 0.0f);
                    a.this.a(aVar.f30913b, false);
                    a.this.f30886e.remove(aVar.f30913b);
                    a.this.c();
                }
            }).c();
        }
    }

    private boolean a(C0219a aVar, RecyclerView.v vVar) {
        boolean z2 = false;
        if (aVar.f30913b == vVar) {
            aVar.f30913b = null;
        } else if (aVar.f30912a != vVar) {
            return false;
        } else {
            aVar.f30912a = null;
            z2 = true;
        }
        ac.c(vVar.itemView, 1.0f);
        ac.a(vVar.itemView, 0.0f);
        ac.b(vVar.itemView, 0.0f);
        a(vVar, z2);
        return true;
    }

    /* access modifiers changed from: private */
    public void b(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        View view = vVar.itemView;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            ac.r(view).b(0.0f);
        }
        if (i7 != 0) {
            ac.r(view).c(0.0f);
        }
        final ag r2 = ac.r(view);
        this.f30884c.add(vVar);
        final RecyclerView.v vVar2 = vVar;
        r2.a(e()).a((ah) new c() {
            public void a(View view) {
                a.this.m(vVar2);
            }

            public void b(View view) {
                r2.a((ah) null);
                a.this.j(vVar2);
                a.this.f30884c.remove(vVar2);
                a.this.c();
            }

            public void c(View view) {
                if (i6 != 0) {
                    ac.a(view, 0.0f);
                }
                if (i7 != 0) {
                    ac.b(view, 0.0f);
                }
            }
        }).c();
    }

    private void b(C0219a aVar) {
        if (aVar.f30912a != null) {
            a(aVar, aVar.f30912a);
        }
        if (aVar.f30913b != null) {
            a(aVar, aVar.f30913b);
        }
    }

    private void w(RecyclerView.v vVar) {
        d(vVar);
    }

    public void a() {
        boolean z2 = !this.f30887f.isEmpty();
        boolean z3 = !this.f30889i.isEmpty();
        boolean z4 = !this.f30890j.isEmpty();
        boolean z5 = !this.f30888g.isEmpty();
        if (z2 || z3 || z5 || z4) {
            Iterator<RecyclerView.v> it2 = this.f30887f.iterator();
            while (it2.hasNext()) {
                v(it2.next());
            }
            this.f30887f.clear();
            if (z3) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f30889i);
                this.f30892l.add(arrayList);
                this.f30889i.clear();
                AnonymousClass1 r6 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            b bVar = (b) it2.next();
                            a.this.b(bVar.f30918a, bVar.f30919b, bVar.f30920c, bVar.f30921d, bVar.f30922e);
                        }
                        arrayList.clear();
                        a.this.f30892l.remove(arrayList);
                    }
                };
                if (z2) {
                    ac.a(((b) arrayList.get(0)).f30918a.itemView, (Runnable) r6, g());
                } else {
                    r6.run();
                }
            }
            if (z4) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f30890j);
                this.f30893m.add(arrayList2);
                this.f30890j.clear();
                AnonymousClass2 r62 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            a.this.a((C0219a) it2.next());
                        }
                        arrayList2.clear();
                        a.this.f30893m.remove(arrayList2);
                    }
                };
                if (z2) {
                    ac.a(((C0219a) arrayList2.get(0)).f30912a.itemView, (Runnable) r62, g());
                } else {
                    r62.run();
                }
            }
            if (z5) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f30888g);
                this.f30891k.add(arrayList3);
                this.f30888g.clear();
                AnonymousClass3 r5 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            a.this.u((RecyclerView.v) it2.next());
                        }
                        arrayList3.clear();
                        a.this.f30891k.remove(arrayList3);
                    }
                };
                if (z2 || z3 || z4) {
                    long j2 = 0;
                    long g2 = z2 ? g() : 0;
                    long e2 = z3 ? e() : 0;
                    if (z4) {
                        j2 = h();
                    }
                    ac.a(((RecyclerView.v) arrayList3.get(0)).itemView, (Runnable) r5, g2 + Math.max(e2, j2));
                    return;
                }
                r5.run();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<RecyclerView.v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ac.r(list.get(size).itemView).b();
        }
    }

    public boolean a(RecyclerView.v vVar) {
        w(vVar);
        this.f30887f.add(vVar);
        return true;
    }

    public boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        View view = vVar.itemView;
        int n2 = (int) (((float) i2) + ac.n(vVar.itemView));
        int o2 = (int) (((float) i3) + ac.o(vVar.itemView));
        w(vVar);
        int i6 = i4 - n2;
        int i7 = i5 - o2;
        if (i6 == 0 && i7 == 0) {
            j(vVar);
            return false;
        }
        if (i6 != 0) {
            ac.a(view, (float) (-i6));
        }
        if (i7 != 0) {
            ac.b(view, (float) (-i7));
        }
        this.f30889i.add(new b(vVar, n2, o2, i4, i5));
        return true;
    }

    public boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
        RecyclerView.v vVar3 = vVar;
        RecyclerView.v vVar4 = vVar2;
        if (vVar3 == vVar4) {
            return a(vVar, i2, i3, i4, i5);
        }
        float n2 = ac.n(vVar3.itemView);
        float o2 = ac.o(vVar3.itemView);
        float h2 = ac.h(vVar3.itemView);
        w(vVar);
        int i6 = (int) (((float) (i4 - i2)) - n2);
        int i7 = (int) (((float) (i5 - i3)) - o2);
        ac.a(vVar3.itemView, n2);
        ac.b(vVar3.itemView, o2);
        ac.c(vVar3.itemView, h2);
        if (vVar4 != null) {
            w(vVar4);
            ac.a(vVar4.itemView, (float) (-i6));
            ac.b(vVar4.itemView, (float) (-i7));
            ac.c(vVar4.itemView, 0.0f);
        }
        this.f30890j.add(new C0219a(vVar, vVar2, i2, i3, i4, i5));
        return true;
    }

    public boolean b() {
        return !this.f30888g.isEmpty() || !this.f30890j.isEmpty() || !this.f30889i.isEmpty() || !this.f30887f.isEmpty() || !this.f30884c.isEmpty() || !this.f30885d.isEmpty() || !this.f30883b.isEmpty() || !this.f30886e.isEmpty() || !this.f30892l.isEmpty() || !this.f30891k.isEmpty() || !this.f30893m.isEmpty();
    }

    public boolean b(RecyclerView.v vVar) {
        w(vVar);
        c(vVar);
        ac.c(vVar.itemView, 0.0f);
        this.f30888g.add(vVar);
        return true;
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (!b()) {
            i();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c(RecyclerView.v vVar);

    public void d() {
        int size = this.f30889i.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.f30889i.get(size);
            View view = bVar.f30918a.itemView;
            ac.b(view, 0.0f);
            ac.a(view, 0.0f);
            j(bVar.f30918a);
            this.f30889i.remove(size);
        }
        for (int size2 = this.f30887f.size() - 1; size2 >= 0; size2--) {
            i(this.f30887f.get(size2));
            this.f30887f.remove(size2);
        }
        int size3 = this.f30888g.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.v vVar = this.f30888g.get(size3);
            ac.c(vVar.itemView, 1.0f);
            k(vVar);
            this.f30888g.remove(size3);
        }
        for (int size4 = this.f30890j.size() - 1; size4 >= 0; size4--) {
            b(this.f30890j.get(size4));
        }
        this.f30890j.clear();
        if (b()) {
            for (int size5 = this.f30892l.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f30892l.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = (b) arrayList.get(size6);
                    View view2 = bVar2.f30918a.itemView;
                    ac.b(view2, 0.0f);
                    ac.a(view2, 0.0f);
                    j(bVar2.f30918a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f30892l.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f30891k.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f30891k.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.v vVar2 = (RecyclerView.v) arrayList2.get(size8);
                    ac.c(vVar2.itemView, 1.0f);
                    k(vVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f30891k.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f30893m.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f30893m.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b((C0219a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f30893m.remove(arrayList3);
                    }
                }
            }
            a((List<RecyclerView.v>) this.f30885d);
            a((List<RecyclerView.v>) this.f30884c);
            a((List<RecyclerView.v>) this.f30883b);
            a((List<RecyclerView.v>) this.f30886e);
            i();
        }
    }

    public void d(RecyclerView.v vVar) {
        View view = vVar.itemView;
        ac.r(view).b();
        int size = this.f30889i.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f30889i.get(size).f30918a == vVar) {
                ac.b(view, 0.0f);
                ac.a(view, 0.0f);
                j(vVar);
                this.f30889i.remove(size);
            }
        }
        a((List<C0219a>) this.f30890j, vVar);
        if (this.f30887f.remove(vVar)) {
            ac.c(view, 1.0f);
            i(vVar);
        }
        if (this.f30888g.remove(vVar)) {
            ac.c(view, 1.0f);
            k(vVar);
        }
        for (int size2 = this.f30893m.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f30893m.get(size2);
            a((List<C0219a>) arrayList, vVar);
            if (arrayList.isEmpty()) {
                this.f30893m.remove(size2);
            }
        }
        for (int size3 = this.f30892l.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f30892l.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((b) arrayList2.get(size4)).f30918a == vVar) {
                    ac.b(view, 0.0f);
                    ac.a(view, 0.0f);
                    j(vVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f30892l.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f30891k.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f30891k.get(size5);
            if (arrayList3.remove(vVar)) {
                ac.c(view, 1.0f);
                k(vVar);
                if (arrayList3.isEmpty()) {
                    this.f30891k.remove(size5);
                }
            }
        }
        this.f30885d.remove(vVar);
        this.f30883b.remove(vVar);
        this.f30886e.remove(vVar);
        this.f30884c.remove(vVar);
        c();
    }

    /* access modifiers changed from: protected */
    public abstract void u(RecyclerView.v vVar);

    /* access modifiers changed from: protected */
    public abstract void v(RecyclerView.v vVar);
}
