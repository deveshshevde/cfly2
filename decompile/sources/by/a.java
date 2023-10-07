package by;

import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C0061a<?>> f6109a = new ArrayList();

    /* renamed from: by.a$a  reason: collision with other inner class name */
    private static final class C0061a<T> {

        /* renamed from: a  reason: collision with root package name */
        final com.bumptech.glide.load.a<T> f6110a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f6111b;

        C0061a(Class<T> cls, com.bumptech.glide.load.a<T> aVar) {
            this.f6111b = cls;
            this.f6110a = aVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Class<?> cls) {
            return this.f6111b.isAssignableFrom(cls);
        }
    }

    public synchronized <T> com.bumptech.glide.load.a<T> a(Class<T> cls) {
        for (C0061a next : this.f6109a) {
            if (next.a(cls)) {
                return next.f6110a;
            }
        }
        return null;
    }

    public synchronized <T> void a(Class<T> cls, com.bumptech.glide.load.a<T> aVar) {
        this.f6109a.add(new C0061a(cls, aVar));
    }
}
