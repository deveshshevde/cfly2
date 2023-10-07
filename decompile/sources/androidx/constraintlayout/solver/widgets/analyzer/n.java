package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.d;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class n {

    /* renamed from: b  reason: collision with root package name */
    static int f2380b;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ConstraintWidget> f2381a = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    int f2382c = -1;

    /* renamed from: d  reason: collision with root package name */
    boolean f2383d = false;

    /* renamed from: e  reason: collision with root package name */
    int f2384e = 0;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<a> f2385f = null;

    /* renamed from: g  reason: collision with root package name */
    private int f2386g = -1;

    class a {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<ConstraintWidget> f2387a;

        /* renamed from: b  reason: collision with root package name */
        int f2388b;

        /* renamed from: c  reason: collision with root package name */
        int f2389c;

        /* renamed from: d  reason: collision with root package name */
        int f2390d;

        /* renamed from: e  reason: collision with root package name */
        int f2391e;

        /* renamed from: f  reason: collision with root package name */
        int f2392f;

        /* renamed from: g  reason: collision with root package name */
        int f2393g;

        public a(ConstraintWidget constraintWidget, d dVar, int i2) {
            this.f2387a = new WeakReference<>(constraintWidget);
            this.f2388b = dVar.b((Object) constraintWidget.f2289y);
            this.f2389c = dVar.b((Object) constraintWidget.f2290z);
            this.f2390d = dVar.b((Object) constraintWidget.A);
            this.f2391e = dVar.b((Object) constraintWidget.B);
            this.f2392f = dVar.b((Object) constraintWidget.C);
            this.f2393g = i2;
        }
    }

    public n(int i2) {
        int i3 = f2380b;
        f2380b = i3 + 1;
        this.f2382c = i3;
        this.f2384e = i2;
    }

    private int a(d dVar, ArrayList<ConstraintWidget> arrayList, int i2) {
        int b2;
        ConstraintAnchor constraintAnchor;
        androidx.constraintlayout.solver.widgets.d dVar2 = (androidx.constraintlayout.solver.widgets.d) arrayList.get(0).v();
        dVar.b();
        dVar2.a(dVar, false);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList.get(i3).a(dVar, false);
        }
        if (i2 == 0 && dVar2.aE > 0) {
            b.a(dVar2, dVar, arrayList, 0);
        }
        if (i2 == 1 && dVar2.aF > 0) {
            b.a(dVar2, dVar, arrayList, 1);
        }
        try {
            dVar.f();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f2385f = new ArrayList<>();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            this.f2385f.add(new a(arrayList.get(i4), dVar, i2));
        }
        if (i2 == 0) {
            b2 = dVar.b((Object) dVar2.f2289y);
            constraintAnchor = dVar2.A;
        } else {
            b2 = dVar.b((Object) dVar2.f2290z);
            constraintAnchor = dVar2.B;
        }
        int b3 = dVar.b((Object) constraintAnchor);
        dVar.b();
        return b3 - b2;
    }

    private String c() {
        int i2 = this.f2384e;
        return i2 == 0 ? "Horizontal" : i2 == 1 ? "Vertical" : i2 == 2 ? "Both" : "Unknown";
    }

    public int a() {
        return this.f2384e;
    }

    public int a(d dVar, int i2) {
        if (this.f2381a.size() == 0) {
            return 0;
        }
        return a(dVar, this.f2381a, i2);
    }

    public void a(int i2) {
        this.f2384e = i2;
    }

    public void a(int i2, n nVar) {
        Iterator<ConstraintWidget> it2 = this.f2381a.iterator();
        while (it2.hasNext()) {
            ConstraintWidget next = it2.next();
            nVar.a(next);
            int b2 = nVar.b();
            if (i2 == 0) {
                next.f2260au = b2;
            } else {
                next.f2261av = b2;
            }
        }
        this.f2386g = nVar.f2382c;
    }

    public void a(ArrayList<n> arrayList) {
        int size = this.f2381a.size();
        if (this.f2386g != -1 && size > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                n nVar = arrayList.get(i2);
                if (this.f2386g == nVar.f2382c) {
                    a(this.f2384e, nVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void a(boolean z2) {
        this.f2383d = z2;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f2381a.contains(constraintWidget)) {
            return false;
        }
        this.f2381a.add(constraintWidget);
        return true;
    }

    public int b() {
        return this.f2382c;
    }

    public String toString() {
        String str = c() + " [" + this.f2382c + "] <";
        Iterator<ConstraintWidget> it2 = this.f2381a.iterator();
        while (it2.hasNext()) {
            str = str + " " + it2.next().x();
        }
        return str + " >";
    }
}
