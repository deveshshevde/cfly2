package am;

import an.d;
import ao.p;
import java.util.ArrayList;
import java.util.List;

public abstract class c<T> implements al.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f246a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private T f247b;

    /* renamed from: c  reason: collision with root package name */
    private d<T> f248c;

    /* renamed from: d  reason: collision with root package name */
    private a f249d;

    public interface a {
        void a(List<String> list);

        void b(List<String> list);
    }

    c(d<T> dVar) {
        this.f248c = dVar;
    }

    private void a(a aVar, T t2) {
        if (!this.f246a.isEmpty() && aVar != null) {
            if (t2 == null || b(t2)) {
                aVar.b(this.f246a);
            } else {
                aVar.a(this.f246a);
            }
        }
    }

    public void a() {
        if (!this.f246a.isEmpty()) {
            this.f246a.clear();
            this.f248c.b(this);
        }
    }

    public void a(a aVar) {
        if (this.f249d != aVar) {
            this.f249d = aVar;
            a(aVar, this.f247b);
        }
    }

    public void a(Iterable<p> iterable) {
        this.f246a.clear();
        for (p next : iterable) {
            if (a(next)) {
                this.f246a.add(next.f5495a);
            }
        }
        if (this.f246a.isEmpty()) {
            this.f248c.b(this);
        } else {
            this.f248c.a(this);
        }
        a(this.f249d, this.f247b);
    }

    public void a(T t2) {
        this.f247b = t2;
        a(this.f249d, t2);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a(p pVar);

    public boolean a(String str) {
        T t2 = this.f247b;
        return t2 != null && b(t2) && this.f246a.contains(str);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean b(T t2);
}
