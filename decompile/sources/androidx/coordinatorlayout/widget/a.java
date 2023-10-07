package androidx.coordinatorlayout.widget;

import j.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import s.e;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e.a<ArrayList<T>> f2772a = new e.b(10);

    /* renamed from: b  reason: collision with root package name */
    private final g<T, ArrayList<T>> f2773b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f2774c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f2775d = new HashSet<>();

    private void a(T t2, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t2)) {
            if (!hashSet.contains(t2)) {
                hashSet.add(t2);
                ArrayList arrayList2 = this.f2773b.get(t2);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        a(arrayList2.get(i2), arrayList, hashSet);
                    }
                }
                hashSet.remove(t2);
                arrayList.add(t2);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f2772a.a(arrayList);
    }

    private ArrayList<T> c() {
        ArrayList<T> a2 = this.f2772a.a();
        return a2 == null ? new ArrayList<>() : a2;
    }

    public void a() {
        int size = this.f2773b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList c2 = this.f2773b.c(i2);
            if (c2 != null) {
                a(c2);
            }
        }
        this.f2773b.clear();
    }

    public void a(T t2) {
        if (!this.f2773b.containsKey(t2)) {
            this.f2773b.put(t2, null);
        }
    }

    public void a(T t2, T t3) {
        if (!this.f2773b.containsKey(t2) || !this.f2773b.containsKey(t3)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f2773b.get(t2);
        if (arrayList == null) {
            arrayList = c();
            this.f2773b.put(t2, arrayList);
        }
        arrayList.add(t3);
    }

    public ArrayList<T> b() {
        this.f2774c.clear();
        this.f2775d.clear();
        int size = this.f2773b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(this.f2773b.b(i2), this.f2774c, this.f2775d);
        }
        return this.f2774c;
    }

    public boolean b(T t2) {
        return this.f2773b.containsKey(t2);
    }

    public List c(T t2) {
        return this.f2773b.get(t2);
    }

    public List<T> d(T t2) {
        int size = this.f2773b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList c2 = this.f2773b.c(i2);
            if (c2 != null && c2.contains(t2)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f2773b.b(i2));
            }
        }
        return arrayList;
    }

    public boolean e(T t2) {
        int size = this.f2773b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList c2 = this.f2773b.c(i2);
            if (c2 != null && c2.contains(t2)) {
                return true;
            }
        }
        return false;
    }
}
