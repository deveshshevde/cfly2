package com.xeagle.android.widgets.menu;

import android.content.Context;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.cfly.uav_pro.R;
import ir.a;
import ir.c;
import ir.i;
import java.util.ArrayList;
import java.util.List;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public e f25943a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public f f25944b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public e f25945c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public f f25946d;

    /* renamed from: e  reason: collision with root package name */
    private Context f25947e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f25948f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f25949g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public View f25950h;

    /* renamed from: i  reason: collision with root package name */
    private List<MenuObject> f25951i;

    /* renamed from: j  reason: collision with root package name */
    private c f25952j;

    /* renamed from: k  reason: collision with root package name */
    private c f25953k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f25954l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f25955m = false;

    /* renamed from: n  reason: collision with root package name */
    private int f25956n;

    /* renamed from: o  reason: collision with root package name */
    private int f25957o = 100;

    /* renamed from: p  reason: collision with root package name */
    private View.OnClickListener f25958p = new View.OnClickListener() {
        public void onClick(View view) {
            d dVar = d.this;
            e unused = dVar.f25945c = dVar.f25943a;
            d.this.c(view);
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private View.OnLongClickListener f25959q = new View.OnLongClickListener() {
        public boolean onLongClick(View view) {
            d dVar = d.this;
            f unused = dVar.f25946d = dVar.f25944b;
            d.this.c(view);
            return true;
        }
    };

    /* renamed from: r  reason: collision with root package name */
    private a.C0197a f25960r = new a.C0197a() {
        public void a(a aVar) {
        }

        public void b(a aVar) {
            d.this.e();
        }

        public void c(a aVar) {
        }
    };

    /* renamed from: s  reason: collision with root package name */
    private a.C0197a f25961s = new a.C0197a() {
        public void a(a aVar) {
        }

        public void b(a aVar) {
            d.this.e();
            if (d.this.f25946d != null) {
                d.this.f25946d.b(d.this.f25950h);
            } else if (d.this.f25945c != null) {
                d.this.f25945c.a(d.this.f25950h);
            }
        }

        public void c(a aVar) {
        }
    };

    public d(Context context, LinearLayout linearLayout, LinearLayout linearLayout2, List<MenuObject> list, int i2) {
        this.f25947e = context;
        this.f25948f = linearLayout;
        this.f25949g = linearLayout2;
        this.f25951i = list;
        this.f25956n = i2;
        c();
        d();
        this.f25953k = a(false);
        this.f25952j = a(true);
    }

    private c a(boolean z2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z2) {
            for (int a2 = a() - 1; a2 >= 0; a2--) {
                a(true, arrayList, arrayList2, a2);
            }
        } else {
            for (int i2 = 0; i2 < a(); i2++) {
                a(false, arrayList, arrayList2, i2);
            }
        }
        c cVar = new c();
        cVar.a((List<a>) arrayList);
        c cVar2 = new c();
        cVar2.a((List<a>) arrayList2);
        c cVar3 = new c();
        cVar3.a(cVar2, cVar);
        cVar3.a((long) this.f25957o);
        cVar3.a(this.f25960r);
        cVar3.b(0);
        cVar3.a((Interpolator) new c());
        return cVar3;
    }

    private void a(View view) {
        if (!this.f25954l) {
            it.a.d(view, 0.0f);
            it.a.f(view, -90.0f);
            it.a.e(view, 0.0f);
        }
        it.a.b(view, (float) this.f25956n);
        it.a.c(view, (float) (this.f25956n / 2));
    }

    private void a(View view, boolean z2) {
        float f2 = 0.0f;
        if (!this.f25954l) {
            it.a.d(view, 0.0f);
            it.a.f(view, 0.0f);
            it.a.e(view, -90.0f);
        }
        it.a.b(view, (float) (this.f25956n / 2));
        if (z2) {
            f2 = (float) this.f25956n;
        }
        it.a.c(view, f2);
    }

    private void a(boolean z2, List<a> list, List<a> list2, int i2) {
        i iVar;
        c cVar = new c();
        View childAt = this.f25949g.getChildAt(i2);
        i e2 = z2 ? a.e(childAt) : a.f(childAt);
        View childAt2 = this.f25949g.getChildAt(i2);
        float dimension = this.f25947e.getResources().getDimension(R.dimen.text_right_translation);
        cVar.a(e2, z2 ? a.a(childAt2, dimension) : a.b(childAt2, dimension));
        list.add(cVar);
        if (z2) {
            View childAt3 = this.f25948f.getChildAt(i2);
            iVar = i2 == 0 ? a.a(childAt3) : a.c(childAt3);
        } else {
            View childAt4 = this.f25948f.getChildAt(i2);
            iVar = i2 == 0 ? a.b(childAt4) : a.d(childAt4);
        }
        list2.add(iVar);
    }

    private void b(int i2) {
        c.b bVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            View childAt = this.f25948f.getChildAt(i3);
            a(childAt, true);
            arrayList2.add(a.c(childAt));
            arrayList.add(a.c(this.f25949g.getChildAt(i3), this.f25947e.getResources().getDimension(R.dimen.text_right_translation)));
        }
        c cVar = new c();
        cVar.a((List<a>) arrayList2);
        c cVar2 = new c();
        cVar2.a((List<a>) arrayList);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (int a2 = a() - 1; a2 > i2; a2--) {
            View childAt2 = this.f25948f.getChildAt(a2);
            a(childAt2, false);
            arrayList4.add(a.c(childAt2));
            arrayList3.add(a.c(this.f25949g.getChildAt(a2), this.f25947e.getResources().getDimension(R.dimen.text_right_translation)));
        }
        c cVar3 = new c();
        cVar3.a((List<a>) arrayList4);
        c cVar4 = new c();
        cVar4.a((List<a>) arrayList3);
        a(this.f25948f.getChildAt(i2));
        i a3 = a.a(this.f25948f.getChildAt(i2));
        a3.a(this.f25961s);
        c c2 = a.c(this.f25949g.getChildAt(i2), this.f25947e.getResources().getDimension(R.dimen.text_right_translation));
        c cVar5 = new c();
        cVar5.a((a) cVar).a(cVar3);
        c cVar6 = new c();
        cVar6.a((a) cVar2).a(cVar4);
        if (arrayList2.size() >= arrayList4.size()) {
            cVar5.a((a) cVar).b(a3);
            bVar = cVar6.a((a) cVar2);
        } else {
            cVar5.a((a) cVar3).b(a3);
            bVar = cVar6.a((a) cVar4);
        }
        bVar.b(c2);
        c cVar7 = new c();
        cVar7.a(cVar5, cVar6);
        cVar7.a((long) this.f25957o);
        cVar7.a((Interpolator) new c());
        cVar7.a();
    }

    private void b(View view) {
        float f2 = 0.0f;
        it.a.a(view, !this.f25954l ? 0.0f : 1.0f);
        if (!this.f25954l) {
            f2 = (float) this.f25956n;
        }
        it.a.i(view, f2);
    }

    private void c() {
        for (MenuObject next : this.f25951i) {
            this.f25949g.addView(i.a(this.f25947e, next.a(), this.f25956n));
            this.f25948f.addView(i.a(this.f25947e, this.f25956n, next.b(), this.f25958p, this.f25959q));
        }
    }

    /* access modifiers changed from: private */
    public void c(View view) {
        if (this.f25954l && !this.f25955m) {
            this.f25950h = view;
            int indexOfChild = this.f25948f.indexOfChild(view);
            if (indexOfChild != -1) {
                e();
                b(indexOfChild);
                f();
            }
        }
    }

    private void d() {
        for (int i2 = 0; i2 < a(); i2++) {
            b(this.f25949g.getChildAt(i2));
            View childAt = this.f25948f.getChildAt(i2);
            if (i2 == 0) {
                a(childAt);
            } else {
                a(childAt, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f25955m = !this.f25955m;
    }

    private void f() {
        this.f25954l = !this.f25954l;
    }

    public int a() {
        return this.f25951i.size();
    }

    public void a(int i2) {
        this.f25957o = i2;
    }

    public void a(e eVar) {
        this.f25943a = eVar;
    }

    public void a(f fVar) {
        this.f25944b = fVar;
    }

    public void b() {
        if (!this.f25955m) {
            d();
            this.f25955m = true;
            (this.f25954l ? this.f25952j : this.f25953k).a();
            f();
        }
    }
}
