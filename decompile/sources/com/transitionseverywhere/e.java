package com.transitionseverywhere;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.utils.j;
import com.transitionseverywhere.utils.k;
import com.transitionseverywhere.utils.m;
import java.util.ArrayList;
import java.util.Iterator;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f21912a = "TransitionManager";

    /* renamed from: b  reason: collision with root package name */
    private static Transition f21913b = new AutoTransition();

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f21914c = new String[0];
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<ViewGroup> f21915d = new ArrayList<>();

    private static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        Transition f21916a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f21917b;

        a(Transition transition, ViewGroup viewGroup) {
            this.f21916a = transition;
            this.f21917b = viewGroup;
        }

        private void a() {
            this.f21917b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f21917b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!e.f21915d.remove(this.f21917b)) {
                return true;
            }
            ArrayList b2 = e.c(this.f21917b);
            ArrayList arrayList = null;
            if (b2.size() > 0) {
                arrayList = new ArrayList(b2);
            }
            b2.add(this.f21916a);
            this.f21916a.a((Transition.c) new Transition.d() {
                public void b(Transition transition) {
                    e.c(a.this.f21917b).remove(transition);
                    transition.b((Transition.c) this);
                }
            });
            boolean a2 = e.b((View) this.f21917b);
            this.f21916a.a(this.f21917b, false);
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).d(this.f21917b);
                }
            }
            this.f21916a.a(this.f21917b);
            return !a2;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            e.f21915d.remove(this.f21917b);
            ArrayList b2 = e.c(this.f21917b);
            if (b2.size() > 0) {
                Iterator it2 = b2.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).d(this.f21917b);
                }
            }
            this.f21916a.b(true);
        }
    }

    public static void a(ViewGroup viewGroup) {
        a(viewGroup, (Transition) null);
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (!f21915d.contains(viewGroup) && m.a((View) viewGroup, true)) {
            f21915d.add(viewGroup);
            if (transition == null) {
                transition = f21913b;
            }
            Transition l2 = transition.clone();
            c(viewGroup, l2);
            c.a(viewGroup, (c) null);
            b(viewGroup, l2);
        }
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 14;
    }

    private static void b(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null || !a()) {
            f21915d.remove(viewGroup);
            return;
        }
        j.a(viewGroup);
        a aVar = new a(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    /* access modifiers changed from: private */
    public static boolean b(View view) {
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        boolean a2 = k.a(viewGroup);
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            a2 = b(viewGroup.getChildAt(i2)) || a2;
        }
        return a2;
    }

    /* access modifiers changed from: private */
    public static ArrayList<Transition> c(ViewGroup viewGroup) {
        ArrayList<Transition> arrayList = (ArrayList) viewGroup.getTag(R.id.runningTransitions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<Transition> arrayList2 = new ArrayList<>();
        viewGroup.setTag(R.id.runningTransitions, arrayList2);
        return arrayList2;
    }

    private static void c(ViewGroup viewGroup, Transition transition) {
        if (a()) {
            ArrayList<Transition> c2 = c(viewGroup);
            if (c2.size() > 0) {
                Iterator<Transition> it2 = c2.iterator();
                while (it2.hasNext()) {
                    it2.next().c((View) viewGroup);
                }
            }
            if (transition != null) {
                transition.a(viewGroup, true);
            }
        }
        c a2 = c.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }
}
