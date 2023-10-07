package com.bumptech.glide.load.data;

import cc.k;
import com.bumptech.glide.load.data.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final e.a<?> f10168b = new e.a<Object>() {
        public e<Object> a(Object obj) {
            return new a(obj);
        }

        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f10169a = new HashMap();

    private static final class a implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f10170a;

        a(Object obj) {
            this.f10170a = obj;
        }

        public Object a() {
            return this.f10170a;
        }

        public void b() {
        }
    }

    public synchronized <T> e<T> a(T t2) {
        e.a<?> aVar;
        k.a(t2);
        aVar = this.f10169a.get(t2.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it2 = this.f10169a.values().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                e.a<?> next = it2.next();
                if (next.a().isAssignableFrom(t2.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f10168b;
        }
        return aVar.a(t2);
    }

    public synchronized void a(e.a<?> aVar) {
        this.f10169a.put(aVar.a(), aVar);
    }
}
