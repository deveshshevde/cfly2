package bo;

import bo.n;
import cc.k;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import s.e;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final c f5917a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final n<Object, Object> f5918b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final List<b<?, ?>> f5919c;

    /* renamed from: d  reason: collision with root package name */
    private final c f5920d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<b<?, ?>> f5921e;

    /* renamed from: f  reason: collision with root package name */
    private final e.a<List<Throwable>> f5922f;

    private static class a implements n<Object, Object> {
        a() {
        }

        public n.a<Object> a(Object obj, int i2, int i3, f fVar) {
            return null;
        }

        public boolean a(Object obj) {
            return false;
        }
    }

    private static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        final Class<Data> f5923a;

        /* renamed from: b  reason: collision with root package name */
        final o<? extends Model, ? extends Data> f5924b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<Model> f5925c;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.f5925c = cls;
            this.f5923a = cls2;
            this.f5924b = oVar;
        }

        public boolean a(Class<?> cls) {
            return this.f5925c.isAssignableFrom(cls);
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f5923a.isAssignableFrom(cls2);
        }
    }

    static class c {
        c() {
        }

        public <Model, Data> q<Model, Data> a(List<n<Model, Data>> list, e.a<List<Throwable>> aVar) {
            return new q<>(list, aVar);
        }
    }

    public r(e.a<List<Throwable>> aVar) {
        this(aVar, f5917a);
    }

    r(e.a<List<Throwable>> aVar, c cVar) {
        this.f5919c = new ArrayList();
        this.f5921e = new HashSet();
        this.f5922f = aVar;
        this.f5920d = cVar;
    }

    private static <Model, Data> n<Model, Data> a() {
        return f5918b;
    }

    private <Model, Data> o<Model, Data> a(b<?, ?> bVar) {
        return bVar.f5924b;
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar, boolean z2) {
        b bVar = new b(cls, cls2, oVar);
        List<b<?, ?>> list = this.f5919c;
        list.add(z2 ? list.size() : 0, bVar);
    }

    private <Model, Data> n<Model, Data> b(b<?, ?> bVar) {
        return (n) k.a(bVar.f5924b.a(this));
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model> List<n<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b next : this.f5919c) {
                if (!this.f5921e.contains(next)) {
                    if (next.a(cls)) {
                        this.f5921e.add(next);
                        arrayList.add(b((b<?, ?>) next));
                        this.f5921e.remove(next);
                    }
                }
            }
        } catch (Throwable th) {
            this.f5921e.clear();
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> List<o<? extends Model, ? extends Data>> a(Class<Model> cls, Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it2 = this.f5919c.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            if (next.a(cls, cls2)) {
                it2.remove();
                arrayList.add(a((b<?, ?>) next));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    public synchronized <Model, Data> n<Model, Data> b(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z2 = false;
            for (b next : this.f5919c) {
                if (this.f5921e.contains(next)) {
                    z2 = true;
                } else if (next.a(cls, cls2)) {
                    this.f5921e.add(next);
                    arrayList.add(b((b<?, ?>) next));
                    this.f5921e.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                return this.f5920d.a(arrayList, this.f5922f);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z2) {
                return a();
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.f5921e.clear();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b next : this.f5919c) {
            if (!arrayList.contains(next.f5923a) && next.a(cls)) {
                arrayList.add(next.f5923a);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> List<o<? extends Model, ? extends Data>> b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        List<o<? extends Model, ? extends Data>> a2;
        a2 = a(cls, cls2);
        a(cls, cls2, oVar);
        return a2;
    }
}
