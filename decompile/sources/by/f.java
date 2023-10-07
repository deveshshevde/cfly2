package by;

import com.bumptech.glide.load.h;
import java.util.ArrayList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f6123a = new ArrayList();

    private static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        final h<T> f6124a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f6125b;

        a(Class<T> cls, h<T> hVar) {
            this.f6125b = cls;
            this.f6124a = hVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Class<?> cls) {
            return this.f6125b.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> h<Z> a(Class<Z> cls) {
        int size = this.f6123a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f6123a.get(i2);
            if (aVar.a(cls)) {
                return aVar.f6124a;
            }
        }
        return null;
    }

    public synchronized <Z> void a(Class<Z> cls, h<Z> hVar) {
        this.f6123a.add(new a(cls, hVar));
    }
}
