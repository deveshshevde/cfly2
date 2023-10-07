package bo;

import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s.e;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f5904a;

    /* renamed from: b  reason: collision with root package name */
    private final a f5905b;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, C0055a<?>> f5906a = new HashMap();

        /* renamed from: bo.p$a$a  reason: collision with other inner class name */
        private static class C0055a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f5907a;

            public C0055a(List<n<Model, ?>> list) {
                this.f5907a = list;
            }
        }

        a() {
        }

        public <Model> List<n<Model, ?>> a(Class<Model> cls) {
            C0055a aVar = this.f5906a.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.f5907a;
        }

        public void a() {
            this.f5906a.clear();
        }

        public <Model> void a(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f5906a.put(cls, new C0055a(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    private p(r rVar) {
        this.f5905b = new a();
        this.f5904a = rVar;
    }

    public p(e.a<List<Throwable>> aVar) {
        this(new r(aVar));
    }

    private <Model, Data> void a(List<o<? extends Model, ? extends Data>> list) {
        for (o<? extends Model, ? extends Data> a2 : list) {
            a2.a();
        }
    }

    private static <A> Class<A> b(A a2) {
        return a2.getClass();
    }

    private synchronized <A> List<n<A, ?>> b(Class<A> cls) {
        List<n<A, ?>> a2;
        a2 = this.f5905b.a(cls);
        if (a2 == null) {
            a2 = Collections.unmodifiableList(this.f5904a.a(cls));
            this.f5905b.a(cls, a2);
        }
        return a2;
    }

    public synchronized List<Class<?>> a(Class<?> cls) {
        return this.f5904a.b(cls);
    }

    public <A> List<n<A, ?>> a(A a2) {
        List b2 = b(b(a2));
        if (!b2.isEmpty()) {
            int size = b2.size();
            List<n<A, ?>> emptyList = Collections.emptyList();
            boolean z2 = true;
            for (int i2 = 0; i2 < size; i2++) {
                n nVar = (n) b2.get(i2);
                if (nVar.a(a2)) {
                    if (z2) {
                        emptyList = new ArrayList<>(size - i2);
                        z2 = false;
                    }
                    emptyList.add(nVar);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a2, b2);
        }
        throw new Registry.NoModelLoaderAvailableException(a2);
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f5904a.a(cls, cls2, oVar);
        this.f5905b.a();
    }

    public synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        a(this.f5904a.b(cls, cls2, oVar));
        this.f5905b.a();
    }
}
