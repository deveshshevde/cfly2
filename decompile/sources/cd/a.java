package cd;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import s.e;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final d<Object> f6198a = new d<Object>() {
        public void a(Object obj) {
        }
    };

    /* renamed from: cd.a$a  reason: collision with other inner class name */
    public interface C0067a<T> {
        T b();
    }

    private static final class b<T> implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final C0067a<T> f6199a;

        /* renamed from: b  reason: collision with root package name */
        private final d<T> f6200b;

        /* renamed from: c  reason: collision with root package name */
        private final e.a<T> f6201c;

        b(e.a<T> aVar, C0067a<T> aVar2, d<T> dVar) {
            this.f6201c = aVar;
            this.f6199a = aVar2;
            this.f6200b = dVar;
        }

        public T a() {
            T a2 = this.f6201c.a();
            if (a2 == null) {
                a2 = this.f6199a.b();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + a2.getClass());
                }
            }
            if (a2 instanceof c) {
                ((c) a2).f_().a(false);
            }
            return a2;
        }

        public boolean a(T t2) {
            if (t2 instanceof c) {
                ((c) t2).f_().a(true);
            }
            this.f6200b.a(t2);
            return this.f6201c.a(t2);
        }
    }

    public interface c {
        c f_();
    }

    public interface d<T> {
        void a(T t2);
    }

    public static <T> e.a<List<T>> a() {
        return a(20);
    }

    public static <T> e.a<List<T>> a(int i2) {
        return a(new e.c(i2), new C0067a<List<T>>() {
            /* renamed from: a */
            public List<T> b() {
                return new ArrayList();
            }
        }, new d<List<T>>() {
            public void a(List<T> list) {
                list.clear();
            }
        });
    }

    public static <T extends c> e.a<T> a(int i2, C0067a<T> aVar) {
        return a(new e.c(i2), aVar);
    }

    private static <T extends c> e.a<T> a(e.a<T> aVar, C0067a<T> aVar2) {
        return a(aVar, aVar2, b());
    }

    private static <T> e.a<T> a(e.a<T> aVar, C0067a<T> aVar2, d<T> dVar) {
        return new b(aVar, aVar2, dVar);
    }

    private static <T> d<T> b() {
        return f6198a;
    }
}
