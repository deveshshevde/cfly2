package by;

import com.bumptech.glide.load.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f6118a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f6119b = new HashMap();

    private static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final Class<R> f6120a;

        /* renamed from: b  reason: collision with root package name */
        final g<T, R> f6121b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<T> f6122c;

        public a(Class<T> cls, Class<R> cls2, g<T, R> gVar) {
            this.f6122c = cls;
            this.f6120a = cls2;
            this.f6121b = gVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f6122c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f6120a);
        }
    }

    private synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> list;
        if (!this.f6118a.contains(str)) {
            this.f6118a.add(str);
        }
        list = this.f6119b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f6119b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> List<g<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f6118a) {
            List<a> list = this.f6119b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f6121b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void a(String str, g<T, R> gVar, Class<T> cls, Class<R> cls2) {
        a(str).add(new a(cls, cls2, gVar));
    }

    public synchronized void a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f6118a);
        this.f6118a.clear();
        for (String add : list) {
            this.f6118a.add(add);
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f6118a.add(str);
            }
        }
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f6118a) {
            List<a> list = this.f6119b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f6120a)) {
                        arrayList.add(aVar.f6120a);
                    }
                }
            }
        }
        return arrayList;
    }
}
