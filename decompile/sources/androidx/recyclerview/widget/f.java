package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t.ac;

public class f extends w {

    /* renamed from: i  reason: collision with root package name */
    private static TimeInterpolator f4111i;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.v>> f4112a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<ArrayList<b>> f4113b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<ArrayList<a>> f4114c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<RecyclerView.v> f4115d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<RecyclerView.v> f4116e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    ArrayList<RecyclerView.v> f4117f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<RecyclerView.v> f4118g = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<RecyclerView.v> f4119j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<RecyclerView.v> f4120k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<b> f4121l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<a> f4122m = new ArrayList<>();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.v f4151a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.v f4152b;

        /* renamed from: c  reason: collision with root package name */
        public int f4153c;

        /* renamed from: d  reason: collision with root package name */
        public int f4154d;

        /* renamed from: e  reason: collision with root package name */
        public int f4155e;

        /* renamed from: f  reason: collision with root package name */
        public int f4156f;

        private a(RecyclerView.v vVar, RecyclerView.v vVar2) {
            this.f4151a = vVar;
            this.f4152b = vVar2;
        }

        a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
            this(vVar, vVar2);
            this.f4153c = i2;
            this.f4154d = i3;
            this.f4155e = i4;
            this.f4156f = i5;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f4151a + ", newHolder=" + this.f4152b + ", fromX=" + this.f4153c + ", fromY=" + this.f4154d + ", toX=" + this.f4155e + ", toY=" + this.f4156f + '}';
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.v f4157a;

        /* renamed from: b  reason: collision with root package name */
        public int f4158b;

        /* renamed from: c  reason: collision with root package name */
        public int f4159c;

        /* renamed from: d  reason: collision with root package name */
        public int f4160d;

        /* renamed from: e  reason: collision with root package name */
        public int f4161e;

        b(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
            this.f4157a = vVar;
            this.f4158b = i2;
            this.f4159c = i3;
            this.f4160d = i4;
            this.f4161e = i5;
        }
    }

    private void a(List<a> list, RecyclerView.v vVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, vVar) && aVar.f4151a == null && aVar.f4152b == null) {
                list.remove(aVar);
            }
        }
    }

    private boolean a(a aVar, RecyclerView.v vVar) {
        boolean z2 = false;
        if (aVar.f4152b == vVar) {
            aVar.f4152b = null;
        } else if (aVar.f4151a != vVar) {
            return false;
        } else {
            aVar.f4151a = null;
            z2 = true;
        }
        vVar.itemView.setAlpha(1.0f);
        vVar.itemView.setTranslationX(0.0f);
        vVar.itemView.setTranslationY(0.0f);
        a(vVar, z2);
        return true;
    }

    private void b(a aVar) {
        if (aVar.f4151a != null) {
            a(aVar, aVar.f4151a);
        }
        if (aVar.f4152b != null) {
            a(aVar, aVar.f4152b);
        }
    }

    private void u(final RecyclerView.v vVar) {
        final View view = vVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f4117f.add(vVar);
        animate.setDuration(g()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                view.setAlpha(1.0f);
                f.this.i(vVar);
                f.this.f4117f.remove(vVar);
                f.this.c();
            }

            public void onAnimationStart(Animator animator) {
                f.this.l(vVar);
            }
        }).start();
    }

    private void v(RecyclerView.v vVar) {
        if (f4111i == null) {
            f4111i = new ValueAnimator().getInterpolator();
        }
        vVar.itemView.animate().setInterpolator(f4111i);
        d(vVar);
    }

    public void a() {
        boolean z2 = !this.f4119j.isEmpty();
        boolean z3 = !this.f4121l.isEmpty();
        boolean z4 = !this.f4122m.isEmpty();
        boolean z5 = !this.f4120k.isEmpty();
        if (z2 || z3 || z5 || z4) {
            Iterator<RecyclerView.v> it2 = this.f4119j.iterator();
            while (it2.hasNext()) {
                u(it2.next());
            }
            this.f4119j.clear();
            if (z3) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f4121l);
                this.f4113b.add(arrayList);
                this.f4121l.clear();
                AnonymousClass1 r6 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            b bVar = (b) it2.next();
                            f.this.b(bVar.f4157a, bVar.f4158b, bVar.f4159c, bVar.f4160d, bVar.f4161e);
                        }
                        arrayList.clear();
                        f.this.f4113b.remove(arrayList);
                    }
                };
                if (z2) {
                    ac.a(((b) arrayList.get(0)).f4157a.itemView, (Runnable) r6, g());
                } else {
                    r6.run();
                }
            }
            if (z4) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f4122m);
                this.f4114c.add(arrayList2);
                this.f4122m.clear();
                AnonymousClass2 r62 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            f.this.a((a) it2.next());
                        }
                        arrayList2.clear();
                        f.this.f4114c.remove(arrayList2);
                    }
                };
                if (z2) {
                    ac.a(((a) arrayList2.get(0)).f4151a.itemView, (Runnable) r62, g());
                } else {
                    r62.run();
                }
            }
            if (z5) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f4120k);
                this.f4112a.add(arrayList3);
                this.f4120k.clear();
                AnonymousClass3 r5 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            f.this.c((RecyclerView.v) it2.next());
                        }
                        arrayList3.clear();
                        f.this.f4112a.remove(arrayList3);
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
    public void a(final a aVar) {
        RecyclerView.v vVar = aVar.f4151a;
        final View view = null;
        final View view2 = vVar == null ? null : vVar.itemView;
        RecyclerView.v vVar2 = aVar.f4152b;
        if (vVar2 != null) {
            view = vVar2.itemView;
        }
        if (view2 != null) {
            final ViewPropertyAnimator duration = view2.animate().setDuration(h());
            this.f4118g.add(aVar.f4151a);
            duration.translationX((float) (aVar.f4155e - aVar.f4153c));
            duration.translationY((float) (aVar.f4156f - aVar.f4154d));
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    duration.setListener((Animator.AnimatorListener) null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    f.this.a(aVar.f4151a, true);
                    f.this.f4118g.remove(aVar.f4151a);
                    f.this.c();
                }

                public void onAnimationStart(Animator animator) {
                    f.this.b(aVar.f4151a, true);
                }
            }).start();
        }
        if (view != null) {
            final ViewPropertyAnimator animate = view.animate();
            this.f4118g.add(aVar.f4152b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    animate.setListener((Animator.AnimatorListener) null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    f.this.a(aVar.f4152b, false);
                    f.this.f4118g.remove(aVar.f4152b);
                    f.this.c();
                }

                public void onAnimationStart(Animator animator) {
                    f.this.b(aVar.f4152b, false);
                }
            }).start();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<RecyclerView.v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public boolean a(RecyclerView.v vVar) {
        v(vVar);
        this.f4119j.add(vVar);
        return true;
    }

    public boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        View view = vVar.itemView;
        int translationX = i2 + ((int) vVar.itemView.getTranslationX());
        int translationY = i3 + ((int) vVar.itemView.getTranslationY());
        v(vVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            j(vVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.f4121l.add(new b(vVar, translationX, translationY, i4, i5));
        return true;
    }

    public boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
        if (vVar == vVar2) {
            return a(vVar, i2, i3, i4, i5);
        }
        float translationX = vVar.itemView.getTranslationX();
        float translationY = vVar.itemView.getTranslationY();
        float alpha = vVar.itemView.getAlpha();
        v(vVar);
        int i6 = (int) (((float) (i4 - i2)) - translationX);
        int i7 = (int) (((float) (i5 - i3)) - translationY);
        vVar.itemView.setTranslationX(translationX);
        vVar.itemView.setTranslationY(translationY);
        vVar.itemView.setAlpha(alpha);
        if (vVar2 != null) {
            v(vVar2);
            vVar2.itemView.setTranslationX((float) (-i6));
            vVar2.itemView.setTranslationY((float) (-i7));
            vVar2.itemView.setAlpha(0.0f);
        }
        this.f4122m.add(new a(vVar, vVar2, i2, i3, i4, i5));
        return true;
    }

    public boolean a(RecyclerView.v vVar, List<Object> list) {
        return !list.isEmpty() || super.a(vVar, list);
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        final View view = vVar.itemView;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.f4116e.add(vVar);
        final RecyclerView.v vVar2 = vVar;
        animate.setDuration(e()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                f.this.j(vVar2);
                f.this.f4116e.remove(vVar2);
                f.this.c();
            }

            public void onAnimationStart(Animator animator) {
                f.this.m(vVar2);
            }
        }).start();
    }

    public boolean b() {
        return !this.f4120k.isEmpty() || !this.f4122m.isEmpty() || !this.f4121l.isEmpty() || !this.f4119j.isEmpty() || !this.f4116e.isEmpty() || !this.f4117f.isEmpty() || !this.f4115d.isEmpty() || !this.f4118g.isEmpty() || !this.f4113b.isEmpty() || !this.f4112a.isEmpty() || !this.f4114c.isEmpty();
    }

    public boolean b(RecyclerView.v vVar) {
        v(vVar);
        vVar.itemView.setAlpha(0.0f);
        this.f4120k.add(vVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (!b()) {
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(final RecyclerView.v vVar) {
        final View view = vVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f4115d.add(vVar);
        animate.alpha(1.0f).setDuration(f()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                f.this.k(vVar);
                f.this.f4115d.remove(vVar);
                f.this.c();
            }

            public void onAnimationStart(Animator animator) {
                f.this.n(vVar);
            }
        }).start();
    }

    public void d() {
        int size = this.f4121l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.f4121l.get(size);
            View view = bVar.f4157a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(bVar.f4157a);
            this.f4121l.remove(size);
        }
        for (int size2 = this.f4119j.size() - 1; size2 >= 0; size2--) {
            i(this.f4119j.get(size2));
            this.f4119j.remove(size2);
        }
        int size3 = this.f4120k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.v vVar = this.f4120k.get(size3);
            vVar.itemView.setAlpha(1.0f);
            k(vVar);
            this.f4120k.remove(size3);
        }
        for (int size4 = this.f4122m.size() - 1; size4 >= 0; size4--) {
            b(this.f4122m.get(size4));
        }
        this.f4122m.clear();
        if (b()) {
            for (int size5 = this.f4113b.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f4113b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = (b) arrayList.get(size6);
                    View view2 = bVar2.f4157a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(bVar2.f4157a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f4113b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f4112a.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f4112a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.v vVar2 = (RecyclerView.v) arrayList2.get(size8);
                    vVar2.itemView.setAlpha(1.0f);
                    k(vVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f4112a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f4114c.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f4114c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b((a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f4114c.remove(arrayList3);
                    }
                }
            }
            a((List<RecyclerView.v>) this.f4117f);
            a((List<RecyclerView.v>) this.f4116e);
            a((List<RecyclerView.v>) this.f4115d);
            a((List<RecyclerView.v>) this.f4118g);
            i();
        }
    }

    public void d(RecyclerView.v vVar) {
        View view = vVar.itemView;
        view.animate().cancel();
        int size = this.f4121l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f4121l.get(size).f4157a == vVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(vVar);
                this.f4121l.remove(size);
            }
        }
        a((List<a>) this.f4122m, vVar);
        if (this.f4119j.remove(vVar)) {
            view.setAlpha(1.0f);
            i(vVar);
        }
        if (this.f4120k.remove(vVar)) {
            view.setAlpha(1.0f);
            k(vVar);
        }
        for (int size2 = this.f4114c.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f4114c.get(size2);
            a((List<a>) arrayList, vVar);
            if (arrayList.isEmpty()) {
                this.f4114c.remove(size2);
            }
        }
        for (int size3 = this.f4113b.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f4113b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((b) arrayList2.get(size4)).f4157a == vVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(vVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f4113b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f4112a.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f4112a.get(size5);
            if (arrayList3.remove(vVar)) {
                view.setAlpha(1.0f);
                k(vVar);
                if (arrayList3.isEmpty()) {
                    this.f4112a.remove(size5);
                }
            }
        }
        this.f4117f.remove(vVar);
        this.f4115d.remove(vVar);
        this.f4118g.remove(vVar);
        this.f4116e.remove(vVar);
        c();
    }
}
