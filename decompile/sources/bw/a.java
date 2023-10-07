package bw;

import cc.l;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class a implements l {

    /* renamed from: a  reason: collision with root package name */
    private final Set<m> f6055a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f6056b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6057c;

    a() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f6056b = true;
        for (T e2 : l.a(this.f6055a)) {
            e2.e();
        }
    }

    public void a(m mVar) {
        this.f6055a.add(mVar);
        if (this.f6057c) {
            mVar.g();
        } else if (this.f6056b) {
            mVar.e();
        } else {
            mVar.f();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f6056b = false;
        for (T f2 : l.a(this.f6055a)) {
            f2.f();
        }
    }

    public void b(m mVar) {
        this.f6055a.remove(mVar);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f6057c = true;
        for (T g2 : l.a(this.f6055a)) {
            g2.g();
        }
    }
}
