package com.transitionseverywhere;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.transitionseverywhere.Transition;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet extends Transition {
    private boolean F = true;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<Transition> f21875a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    int f21876b;

    /* renamed from: c  reason: collision with root package name */
    boolean f21877c = false;

    static class a extends Transition.d {

        /* renamed from: a  reason: collision with root package name */
        TransitionSet f21880a;

        a(TransitionSet transitionSet) {
            this.f21880a = transitionSet;
        }

        public void b(Transition transition) {
            TransitionSet transitionSet = this.f21880a;
            transitionSet.f21876b--;
            if (this.f21880a.f21876b == 0) {
                this.f21880a.f21877c = false;
                this.f21880a.h();
            }
            transition.b((Transition.c) this);
        }

        public void e(Transition transition) {
            if (!this.f21880a.f21877c) {
                this.f21880a.g();
                this.f21880a.f21877c = true;
            }
        }
    }

    public TransitionSet() {
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TransitionSet);
        a(obtainStyledAttributes.getInt(R.styleable.TransitionSet_transitionOrdering, 0));
        obtainStyledAttributes.recycle();
    }

    private void c(Transition transition) {
        this.f21875a.add(transition);
        transition.f21858r = this;
    }

    private void n() {
        a aVar = new a(this);
        Iterator<Transition> it2 = this.f21875a.iterator();
        while (it2.hasNext()) {
            it2.next().a((Transition.c) aVar);
        }
        this.f21876b = this.f21875a.size();
    }

    public TransitionSet a(int i2) {
        if (i2 == 0) {
            this.F = true;
        } else if (i2 == 1) {
            this.F = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        String a2 = super.a(str);
        for (int i2 = 0; i2 < this.f21875a.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            sb.append(this.f21875a.get(i2).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, i iVar, i iVar2, ArrayList<h> arrayList, ArrayList<h> arrayList2) {
        long d2 = d();
        int size = this.f21875a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Transition transition = this.f21875a.get(i2);
            if (d2 > 0 && (this.F || i2 == 0)) {
                long d3 = transition.d();
                if (d3 > 0) {
                    transition.b(d3 + d2);
                } else {
                    transition.b(d2);
                }
            }
            transition.a(viewGroup, iVar, iVar2, arrayList, arrayList2);
        }
    }

    public void a(h hVar) {
        if (b(hVar.f21926a)) {
            Iterator<Transition> it2 = this.f21875a.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.b(hVar.f21926a)) {
                    next.a(hVar);
                    hVar.f21928c.add(next);
                }
            }
        }
    }

    /* renamed from: b */
    public TransitionSet l() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f21875a = new ArrayList<>();
        int size = this.f21875a.size();
        for (int i2 = 0; i2 < size; i2++) {
            transitionSet.c(this.f21875a.get(i2).clone());
        }
        return transitionSet;
    }

    /* renamed from: b */
    public TransitionSet a(TimeInterpolator timeInterpolator) {
        ArrayList<Transition> arrayList;
        super.a(timeInterpolator);
        if (!(this.f21846f == null || (arrayList = this.f21875a) == null)) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f21875a.get(i2).a(this.f21846f);
            }
        }
        return this;
    }

    /* renamed from: b */
    public TransitionSet a(PathMotion pathMotion) {
        super.a(pathMotion);
        for (int i2 = 0; i2 < this.f21875a.size(); i2++) {
            this.f21875a.get(i2).a(pathMotion);
        }
        return this;
    }

    public TransitionSet b(Transition transition) {
        if (transition != null) {
            c(transition);
            if (this.f21845e >= 0) {
                transition.a(this.f21845e);
            }
            if (this.f21846f != null) {
                transition.a(this.f21846f);
            }
        }
        return this;
    }

    /* renamed from: b */
    public TransitionSet a(f fVar) {
        super.a(fVar);
        int size = this.f21875a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f21875a.get(i2).a(fVar);
        }
        return this;
    }

    public void b(h hVar) {
        if (b(hVar.f21926a)) {
            Iterator<Transition> it2 = this.f21875a.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.b(hVar.f21926a)) {
                    next.b(hVar);
                    hVar.f21928c.add(next);
                }
            }
        }
    }

    /* renamed from: c */
    public TransitionSet a(long j2) {
        ArrayList<Transition> arrayList;
        super.a(j2);
        if (this.f21845e >= 0 && (arrayList = this.f21875a) != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f21875a.get(i2).a(j2);
            }
        }
        return this;
    }

    /* renamed from: c */
    public TransitionSet a(Transition.c cVar) {
        return (TransitionSet) super.a(cVar);
    }

    public void c(View view) {
        super.c(view);
        int size = this.f21875a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f21875a.get(i2).c(view);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(h hVar) {
        super.c(hVar);
        int size = this.f21875a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f21875a.get(i2).c(hVar);
        }
    }

    /* renamed from: d */
    public TransitionSet b(long j2) {
        return (TransitionSet) super.b(j2);
    }

    /* renamed from: d */
    public TransitionSet b(Transition.c cVar) {
        return (TransitionSet) super.b(cVar);
    }

    public void d(View view) {
        super.d(view);
        int size = this.f21875a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f21875a.get(i2).d(view);
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
        if (this.f21875a.isEmpty()) {
            g();
            h();
            return;
        }
        n();
        int size = this.f21875a.size();
        if (!this.F) {
            for (int i2 = 1; i2 < size; i2++) {
                final Transition transition = this.f21875a.get(i2);
                this.f21875a.get(i2 - 1).a((Transition.c) new Transition.d() {
                    public void b(Transition transition) {
                        transition.f();
                        transition.b((Transition.c) this);
                    }
                });
            }
            Transition transition2 = this.f21875a.get(0);
            if (transition2 != null) {
                transition2.f();
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            this.f21875a.get(i3).f();
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        super.i();
        int size = this.f21875a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f21875a.get(i2).i();
        }
    }
}
