package bw;

import bz.j;
import cc.l;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class u implements m {

    /* renamed from: a  reason: collision with root package name */
    private final Set<j<?>> f6107a = Collections.newSetFromMap(new WeakHashMap());

    public List<j<?>> a() {
        return l.a(this.f6107a);
    }

    public void a(j<?> jVar) {
        this.f6107a.add(jVar);
    }

    public void b() {
        this.f6107a.clear();
    }

    public void b(j<?> jVar) {
        this.f6107a.remove(jVar);
    }

    public void e() {
        for (T e2 : l.a(this.f6107a)) {
            e2.e();
        }
    }

    public void f() {
        for (T f2 : l.a(this.f6107a)) {
            f2.f();
        }
    }

    public void g() {
        for (T g2 : l.a(this.f6107a)) {
            g2.g();
        }
    }
}
