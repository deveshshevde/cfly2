package kn;

import android.content.Context;
import com.flypro.core.mission.b;
import ej.c;
import em.d;
import em.e;
import em.g;
import fg.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kh.a;

public class a implements a.e {

    /* renamed from: a  reason: collision with root package name */
    public b f13910a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final com.flypro.core.mission.a f13911b;

    /* renamed from: c  reason: collision with root package name */
    private final List<ko.a> f13912c = new ArrayList();

    public a(com.flypro.core.mission.a aVar) {
        this.f13911b = aVar;
        d();
    }

    private void a(b bVar) {
        this.f13912c.add(new ko.a(this, bVar));
        this.f13911b.b(bVar);
    }

    public static List<ef.a> f(List<ko.a> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (ko.a next : list) {
                if (next.b() instanceof d) {
                    ef.b e2 = ((d) next.b()).e();
                    if (!e2.e()) {
                        arrayList.add(e2);
                    }
                }
            }
        }
        return arrayList;
    }

    private void g(List<b> list) {
        for (b aVar : list) {
            this.f13912c.add(new ko.a(this, aVar));
        }
        this.f13911b.b(list);
    }

    private List<ko.a> j() {
        int indexOf = this.f13912c.indexOf(this.f13910a.f30159a.get(0));
        int i2 = indexOf;
        while (this.f13912c.size() >= i2 + 2) {
            i2++;
            if (!this.f13910a.f30159a.contains(this.f13912c.get(i2))) {
                return this.f13912c.subList(indexOf, i2 + 1);
            }
        }
        return this.f13912c.subList(0, 0);
    }

    private List<ko.a> k() {
        int indexOf = this.f13912c.indexOf(this.f13910a.f30159a.get(this.f13910a.f30159a.size() - 1));
        int i2 = indexOf;
        while (i2 >= 1) {
            i2--;
            if (!this.f13910a.f30159a.contains(this.f13912c.get(i2))) {
                return this.f13912c.subList(i2, indexOf + 1);
            }
        }
        return this.f13912c.subList(0, 0);
    }

    public com.flypro.core.mission.a a() {
        return this.f13911b;
    }

    public void a(Context context) {
        this.f13911b.a(context);
    }

    public void a(Context context, boolean z2) {
        this.f13911b.a(context, z2);
    }

    public void a(ef.a aVar) {
        a((b) new g(this.f13911b, new ef.b(aVar, this.f13911b.c())));
    }

    public void a(el.a aVar, int i2, ef.a aVar2) {
        aVar.f26909b.a(aVar2, i2);
        try {
            aVar.c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f13911b.b();
    }

    public void a(List<ko.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (ko.a b2 : list) {
            arrayList.add(b2.b());
        }
        this.f13912c.removeAll(list);
        this.f13910a.f30159a.removeAll(list);
        this.f13911b.a((List<b>) arrayList);
        this.f13910a.c();
    }

    public void a(b bVar) {
        a(bVar.f30159a);
    }

    public void a(ko.a aVar) {
        this.f13912c.remove(aVar);
        this.f13910a.f30159a.remove(aVar);
        this.f13911b.a(aVar.b());
        this.f13910a.c();
    }

    public void a(ko.a aVar, ef.a aVar2) {
        ((d) aVar.b()).a(aVar2);
        this.f13911b.b();
    }

    public void a(boolean z2) {
        List<ko.a> list;
        int i2;
        if (this.f13910a.f30159a.size() > 0 || this.f13910a.f30159a.size() < this.f13912c.size()) {
            Collections.sort(this.f13910a.f30159a);
            if (z2) {
                list = j();
                i2 = 1;
            } else {
                list = k();
                i2 = -1;
            }
            Collections.rotate(list, i2);
            this.f13910a.c();
            this.f13911b.b();
        }
    }

    public float b(Context context) {
        double c2 = this.f13911b.c(context);
        d();
        return (float) c2;
    }

    public int b(ko.a aVar) {
        return this.f13911b.c(aVar.b());
    }

    public List<ko.a> b() {
        return this.f13912c;
    }

    public void b(List<ef.a> list) {
        el.a aVar = new el.a(this.f13911b, list);
        this.f13912c.add(new ko.a(this, aVar));
        this.f13911b.b((b) aVar);
        try {
            aVar.c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public c c(ko.a aVar) throws IllegalArgumentException {
        b b2 = aVar.b();
        if (b2 instanceof d) {
            return this.f13911b.a((d) b2);
        }
        throw new IllegalArgumentException("Invalid mission item type.");
    }

    public List<kh.b> c() {
        ArrayList arrayList = new ArrayList();
        for (ko.a c2 : this.f13912c) {
            List<kh.b> c3 = c2.c();
            if (c3 != null && !c3.isEmpty()) {
                arrayList.addAll(c3);
            }
        }
        return arrayList;
    }

    public void c(List<ef.a> list) {
        ej.a c2 = this.f13911b.c();
        ArrayList arrayList = new ArrayList(list.size());
        for (ef.a bVar : list) {
            arrayList.add(new g(this.f13911b, new ef.b(bVar, c2)));
        }
        g(arrayList);
    }

    public c d(ko.a aVar) throws IllegalArgumentException {
        b b2 = aVar.b();
        if (b2 instanceof d) {
            return this.f13911b.b((d) b2);
        }
        throw new IllegalArgumentException("Invalid mission item type.");
    }

    public void d() {
        this.f13910a.f30159a.clear();
        this.f13912c.clear();
        for (b aVar : this.f13911b.e()) {
            this.f13912c.add(new ko.a(this, aVar));
        }
        this.f13910a.c();
    }

    public void d(List<ef.a> list) {
        ej.a c2 = this.f13911b.c();
        ArrayList arrayList = new ArrayList(list.size());
        for (ef.a bVar : list) {
            e eVar = new e(this.f13911b, new ef.b(bVar, c2));
            eVar.a(10.0d);
            arrayList.add(eVar);
        }
        g(arrayList);
    }

    public void e() {
        Collections.reverse(this.f13912c);
        this.f13911b.d();
    }

    public void e(List<com.flypro.core.util.b<ko.a, ko.a>> list) {
        int size;
        if (list != null && (size = list.size()) != 0) {
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            ArrayList arrayList3 = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                ko.a aVar = (ko.a) list.get(i2).f14468a;
                int indexOf = this.f13912c.indexOf(aVar);
                if (indexOf != -1) {
                    ko.a aVar2 = (ko.a) list.get(i2).f14469b;
                    this.f13912c.remove(indexOf);
                    this.f13912c.add(indexOf, aVar2);
                    arrayList.add(com.flypro.core.util.b.a(aVar.b(), aVar2.b()));
                    if (this.f13910a.d(aVar)) {
                        arrayList2.add(aVar);
                        arrayList3.add(aVar2);
                    }
                }
            }
            this.f13911b.c((List<com.flypro.core.util.b<b, b>>) arrayList);
            this.f13910a.a((List<ko.a>) arrayList2);
            this.f13910a.c((List<ko.a>) arrayList3);
        }
    }

    public void f() {
        this.f13910a.b();
        this.f13912c.clear();
        this.f13910a.c();
    }

    public List<ef.a> g() {
        ArrayList arrayList = new ArrayList();
        for (b next : this.f13911b.e()) {
            if (next instanceof d) {
                ef.b e2 = ((d) next).e();
                if (!e2.e()) {
                    arrayList.add(e2);
                }
            }
        }
        return arrayList;
    }

    public List<ef.a> getPathPoints() {
        if (this.f13912c.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<com.flypro.core.util.b> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
        for (ko.a next : this.f13912c) {
            if (next.b() instanceof e) {
                if (!z2) {
                    if (!arrayList2.isEmpty()) {
                        arrayList.add(new com.flypro.core.util.b(Boolean.FALSE, arrayList2));
                        arrayList2 = new ArrayList();
                        arrayList2.add((ko.a) arrayList2.get(arrayList2.size() - 1));
                    }
                    z2 = true;
                }
            } else if (z2) {
                if (!arrayList2.isEmpty()) {
                    arrayList2.add(next);
                    arrayList.add(new com.flypro.core.util.b(Boolean.TRUE, arrayList2));
                    arrayList2 = new ArrayList();
                }
                z2 = false;
            }
            arrayList2.add(next);
        }
        arrayList.add(new com.flypro.core.util.b(Boolean.valueOf(z2), arrayList2));
        ArrayList arrayList3 = new ArrayList();
        ef.a aVar = null;
        for (com.flypro.core.util.b bVar : arrayList) {
            List<ko.a> list = (List) bVar.f14469b;
            if (((Boolean) bVar.f14468a).booleanValue()) {
                ArrayList arrayList4 = new ArrayList();
                for (ko.a a2 : list) {
                    arrayList4.addAll(a2.a(aVar));
                    if (!arrayList4.isEmpty()) {
                        aVar = (ef.a) arrayList4.get(arrayList4.size() - 1);
                    }
                }
                arrayList3.addAll(eh.b.a(arrayList4));
            } else {
                for (ko.a a3 : list) {
                    arrayList3.addAll(a3.a(aVar));
                    if (!arrayList3.isEmpty()) {
                        aVar = (ef.a) arrayList3.get(arrayList3.size() - 1);
                    }
                }
            }
        }
        return arrayList3;
    }

    public c h() {
        List<ef.a> pathPoints = getPathPoints();
        int size = pathPoints.size();
        double d2 = i.f27244a;
        if (size <= 1) {
            return new c(i.f27244a);
        }
        for (int i2 = 1; i2 < pathPoints.size(); i2++) {
            d2 += eg.a.c(pathPoints.get(i2 - 1), pathPoints.get(i2)).a();
        }
        return new c(d2);
    }

    public List<List<ef.a>> i() {
        ArrayList arrayList = new ArrayList();
        for (b next : this.f13911b.e()) {
            if (next instanceof el.a) {
                arrayList.add(((el.a) next).f26909b.a());
            }
        }
        return arrayList;
    }
}
