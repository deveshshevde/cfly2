package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.Transition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import t.ac;

public class v {

    /* renamed from: a  reason: collision with root package name */
    static ArrayList<ViewGroup> f4873a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private static Transition f4874b = new AutoTransition();

    /* renamed from: c  reason: collision with root package name */
    private static ThreadLocal<WeakReference<j.a<ViewGroup, ArrayList<Transition>>>> f4875c = new ThreadLocal<>();

    private static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        Transition f4876a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f4877b;

        a(Transition transition, ViewGroup viewGroup) {
            this.f4876a = transition;
            this.f4877b = viewGroup;
        }

        private void a() {
            this.f4877b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f4877b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!v.f4873a.remove(this.f4877b)) {
                return true;
            }
            final j.a<ViewGroup, ArrayList<Transition>> a2 = v.a();
            ArrayList arrayList = a2.get(this.f4877b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a2.put(this.f4877b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f4876a);
            this.f4876a.a((Transition.c) new u() {
                public void b(Transition transition) {
                    ((ArrayList) a2.get(a.this.f4877b)).remove(transition);
                    transition.b((Transition.c) this);
                }
            });
            this.f4876a.a(this.f4877b, false);
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).f(this.f4877b);
                }
            }
            this.f4876a.a(this.f4877b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            v.f4873a.remove(this.f4877b);
            ArrayList arrayList = v.a().get(this.f4877b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).f(this.f4877b);
                }
            }
            this.f4876a.b(true);
        }
    }

    static j.a<ViewGroup, ArrayList<Transition>> a() {
        j.a<ViewGroup, ArrayList<Transition>> aVar;
        WeakReference weakReference = f4875c.get();
        if (weakReference != null && (aVar = (j.a) weakReference.get()) != null) {
            return aVar;
        }
        j.a<ViewGroup, ArrayList<Transition>> aVar2 = new j.a<>();
        f4875c.set(new WeakReference(aVar2));
        return aVar2;
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (!f4873a.contains(viewGroup) && ac.G(viewGroup)) {
            f4873a.add(viewGroup);
            if (transition == null) {
                transition = f4874b;
            }
            Transition q2 = transition.clone();
            c(viewGroup, q2);
            q.a(viewGroup, (q) null);
            b(viewGroup, q2);
        }
    }

    private static void b(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            a aVar = new a(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void c(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Transition) it2.next()).e(viewGroup);
            }
        }
        if (transition != null) {
            transition.a(viewGroup, true);
        }
        q a2 = q.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }
}
