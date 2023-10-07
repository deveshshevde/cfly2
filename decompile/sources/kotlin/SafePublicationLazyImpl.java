package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.h;

final class SafePublicationLazyImpl<T> implements Serializable, d<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30174a = new a((f) null);

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> f30175e = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "c");

    /* renamed from: b  reason: collision with root package name */
    private volatile mm.a<? extends T> f30176b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Object f30177c = k.f30253a;

    /* renamed from: d  reason: collision with root package name */
    private final Object f30178d = k.f30253a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public SafePublicationLazyImpl(mm.a<? extends T> aVar) {
        h.d(aVar, "initializer");
        this.f30176b = aVar;
    }

    public T a() {
        T t2 = this.f30177c;
        if (t2 != k.f30253a) {
            return t2;
        }
        mm.a<? extends T> aVar = this.f30176b;
        if (aVar != null) {
            T e_ = aVar.e_();
            if (f30175e.compareAndSet(this, k.f30253a, e_)) {
                this.f30176b = null;
                return e_;
            }
        }
        return this.f30177c;
    }

    public boolean b() {
        return this.f30177c != k.f30253a;
    }

    public String toString() {
        return b() ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
