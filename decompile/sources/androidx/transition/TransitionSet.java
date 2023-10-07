package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import l.g;
import org.xmlpull.v1.XmlPullParser;

public class TransitionSet extends Transition {

    /* renamed from: a  reason: collision with root package name */
    int f4743a;

    /* renamed from: i  reason: collision with root package name */
    boolean f4744i = false;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<Transition> f4745j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private boolean f4746k = true;

    /* renamed from: l  reason: collision with root package name */
    private int f4747l = 0;

    static class a extends u {

        /* renamed from: a  reason: collision with root package name */
        TransitionSet f4750a;

        a(TransitionSet transitionSet) {
            this.f4750a = transitionSet;
        }

        public void b(Transition transition) {
            TransitionSet transitionSet = this.f4750a;
            transitionSet.f4743a--;
            if (this.f4750a.f4743a == 0) {
                this.f4750a.f4744i = false;
                this.f4750a.k();
            }
            transition.b((Transition.c) this);
        }

        public void e(Transition transition) {
            if (!this.f4750a.f4744i) {
                this.f4750a.j();
                this.f4750a.f4744i = true;
            }
        }
    }

    public TransitionSet() {
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f4870i);
        a(g.a(obtainStyledAttributes, (XmlPullParser) (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    private void b(Transition transition) {
        this.f4745j.add(transition);
        transition.f4714e = this;
    }

    private void t() {
        a aVar = new a(this);
        Iterator<Transition> it2 = this.f4745j.iterator();
        while (it2.hasNext()) {
            it2.next().a((Transition.c) aVar);
        }
        this.f4743a = this.f4745j.size();
    }

    public TransitionSet a(int i2) {
        if (i2 == 0) {
            this.f4746k = true;
        } else if (i2 == 1) {
            this.f4746k = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
        }
        return this;
    }

    /* renamed from: a */
    public TransitionSet c(View view) {
        for (int i2 = 0; i2 < this.f4745j.size(); i2++) {
            this.f4745j.get(i2).c(view);
        }
        return (TransitionSet) super.c(view);
    }

    public TransitionSet a(Transition transition) {
        b(transition);
        if (this.f4711b >= 0) {
            transition.a(this.f4711b);
        }
        if ((this.f4747l & 1) != 0) {
            transition.a(d());
        }
        if ((this.f4747l & 2) != 0) {
            transition.a(p());
        }
        if ((this.f4747l & 4) != 0) {
            transition.a(m());
        }
        if ((this.f4747l & 8) != 0) {
            transition.a(n());
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        String a2 = super.a(str);
        for (int i2 = 0; i2 < this.f4745j.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            sb.append(this.f4745j.get(i2).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, z zVar, z zVar2, ArrayList<y> arrayList, ArrayList<y> arrayList2) {
        long c2 = c();
        int size = this.f4745j.size();
        for (int i2 = 0; i2 < size; i2++) {
            Transition transition = this.f4745j.get(i2);
            if (c2 > 0 && (this.f4746k || i2 == 0)) {
                long c3 = transition.c();
                if (c3 > 0) {
                    transition.b(c3 + c2);
                } else {
                    transition.b(c2);
                }
            }
            transition.a(viewGroup, zVar, zVar2, arrayList, arrayList2);
        }
    }

    public void a(PathMotion pathMotion) {
        super.a(pathMotion);
        this.f4747l |= 4;
        if (this.f4745j != null) {
            for (int i2 = 0; i2 < this.f4745j.size(); i2++) {
                this.f4745j.get(i2).a(pathMotion);
            }
        }
    }

    public void a(Transition.b bVar) {
        super.a(bVar);
        this.f4747l |= 8;
        int size = this.f4745j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4745j.get(i2).a(bVar);
        }
    }

    public void a(w wVar) {
        super.a(wVar);
        this.f4747l |= 2;
        int size = this.f4745j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4745j.get(i2).a(wVar);
        }
    }

    public void a(y yVar) {
        if (b(yVar.f4887b)) {
            Iterator<Transition> it2 = this.f4745j.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.b(yVar.f4887b)) {
                    next.a(yVar);
                    yVar.f4888c.add(next);
                }
            }
        }
    }

    public Transition b(int i2) {
        if (i2 < 0 || i2 >= this.f4745j.size()) {
            return null;
        }
        return this.f4745j.get(i2);
    }

    /* renamed from: b */
    public TransitionSet a(TimeInterpolator timeInterpolator) {
        this.f4747l |= 1;
        ArrayList<Transition> arrayList = this.f4745j;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f4745j.get(i2).a(timeInterpolator);
            }
        }
        return (TransitionSet) super.a(timeInterpolator);
    }

    public void b(y yVar) {
        if (b(yVar.f4887b)) {
            Iterator<Transition> it2 = this.f4745j.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.b(yVar.f4887b)) {
                    next.b(yVar);
                    yVar.f4888c.add(next);
                }
            }
        }
    }

    /* renamed from: c */
    public TransitionSet a(long j2) {
        ArrayList<Transition> arrayList;
        super.a(j2);
        if (this.f4711b >= 0 && (arrayList = this.f4745j) != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f4745j.get(i2).a(j2);
            }
        }
        return this;
    }

    /* renamed from: c */
    public TransitionSet a(Transition.c cVar) {
        return (TransitionSet) super.a(cVar);
    }

    /* access modifiers changed from: package-private */
    public void c(y yVar) {
        super.c(yVar);
        int size = this.f4745j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4745j.get(i2).c(yVar);
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

    /* access modifiers changed from: protected */
    public void e() {
        if (this.f4745j.isEmpty()) {
            j();
            k();
            return;
        }
        t();
        if (!this.f4746k) {
            for (int i2 = 1; i2 < this.f4745j.size(); i2++) {
                final Transition transition = this.f4745j.get(i2);
                this.f4745j.get(i2 - 1).a((Transition.c) new u() {
                    public void b(Transition transition) {
                        transition.e();
                        transition.b((Transition.c) this);
                    }
                });
            }
            Transition transition2 = this.f4745j.get(0);
            if (transition2 != null) {
                transition2.e();
                return;
            }
            return;
        }
        Iterator<Transition> it2 = this.f4745j.iterator();
        while (it2.hasNext()) {
            it2.next().e();
        }
    }

    public void e(View view) {
        super.e(view);
        int size = this.f4745j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4745j.get(i2).e(view);
        }
    }

    public void f(View view) {
        super.f(view);
        int size = this.f4745j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4745j.get(i2).f(view);
        }
    }

    /* renamed from: g */
    public TransitionSet d(View view) {
        for (int i2 = 0; i2 < this.f4745j.size(); i2++) {
            this.f4745j.get(i2).d(view);
        }
        return (TransitionSet) super.d(view);
    }

    /* access modifiers changed from: protected */
    public void l() {
        super.l();
        int size = this.f4745j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4745j.get(i2).l();
        }
    }

    /* renamed from: q */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f4745j = new ArrayList<>();
        int size = this.f4745j.size();
        for (int i2 = 0; i2 < size; i2++) {
            transitionSet.b(this.f4745j.get(i2).clone());
        }
        return transitionSet;
    }

    public int s() {
        return this.f4745j.size();
    }
}
