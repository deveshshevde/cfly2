package bv;

import java.util.ArrayList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?, ?>> f6050a = new ArrayList();

    private static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        final Class<Z> f6051a;

        /* renamed from: b  reason: collision with root package name */
        final Class<R> f6052b;

        /* renamed from: c  reason: collision with root package name */
        final e<Z, R> f6053c;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.f6051a = cls;
            this.f6052b = cls2;
            this.f6053c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f6051a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f6052b);
        }
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.a();
        }
        for (a next : this.f6050a) {
            if (next.a(cls, cls2)) {
                return next.f6053c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.f6050a.add(new a(cls, cls2, eVar));
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a next : this.f6050a) {
            if (next.a(cls, cls2) && !arrayList.contains(next.f6052b)) {
                arrayList.add(next.f6052b);
            }
        }
        return arrayList;
    }
}
