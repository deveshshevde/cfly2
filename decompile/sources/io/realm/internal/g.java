package io.realm.internal;

import io.realm.internal.g.b;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class g<T extends b> {

    /* renamed from: a  reason: collision with root package name */
    private List<T> f29038a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    private boolean f29039b = false;

    public interface a<T extends b> {
        void a(T t2, Object obj);
    }

    public static abstract class b<T, S> {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<T> f29040a;

        /* renamed from: b  reason: collision with root package name */
        protected final S f29041b;

        /* renamed from: c  reason: collision with root package name */
        boolean f29042c = false;

        b(T t2, S s2) {
            this.f29041b = s2;
            this.f29040a = new WeakReference<>(t2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f29041b.equals(bVar.f29041b) && this.f29040a.get() == bVar.f29040a.get();
        }

        public int hashCode() {
            Object obj = this.f29040a.get();
            int i2 = 0;
            int hashCode = (527 + (obj != null ? obj.hashCode() : 0)) * 31;
            S s2 = this.f29041b;
            if (s2 != null) {
                i2 = s2.hashCode();
            }
            return hashCode + i2;
        }
    }

    public void a(a<T> aVar) {
        for (T t2 : this.f29038a) {
            if (!this.f29039b) {
                Object obj = t2.f29040a.get();
                if (obj == null) {
                    this.f29038a.remove(t2);
                } else if (!t2.f29042c) {
                    aVar.a(t2, obj);
                }
            } else {
                return;
            }
        }
    }

    public void a(T t2) {
        if (!this.f29038a.contains(t2)) {
            this.f29038a.add(t2);
            t2.f29042c = false;
        }
        if (this.f29039b) {
            this.f29039b = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        for (T t2 : this.f29038a) {
            Object obj2 = t2.f29040a.get();
            if (obj2 == null || obj2 == obj) {
                t2.f29042c = true;
                this.f29038a.remove(t2);
            }
        }
    }

    public <S, U> void a(S s2, U u2) {
        for (T t2 : this.f29038a) {
            if (s2 == t2.f29040a.get() && u2.equals(t2.f29041b)) {
                t2.f29042c = true;
                this.f29038a.remove(t2);
                return;
            }
        }
    }

    public boolean a() {
        return this.f29038a.isEmpty();
    }

    public void b() {
        this.f29039b = true;
        this.f29038a.clear();
    }

    public int c() {
        return this.f29038a.size();
    }
}
