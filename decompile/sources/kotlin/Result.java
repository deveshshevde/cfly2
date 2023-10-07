package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.h;

public final class Result<T> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30171a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private final Object f30172b;

    public static final class Failure implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f30173a;

        public Failure(Throwable th) {
            h.d(th, "exception");
            this.f30173a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && h.a((Object) this.f30173a, (Object) ((Failure) obj).f30173a);
        }

        public int hashCode() {
            return this.f30173a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f30173a + ')';
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final boolean a(Object obj) {
        return !(obj instanceof Failure);
    }

    public static boolean a(Object obj, Object obj2) {
        return (obj2 instanceof Result) && h.a(obj, ((Result) obj2).a());
    }

    public static final boolean b(Object obj) {
        return obj instanceof Failure;
    }

    public static final Throwable c(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).f30173a;
        }
        return null;
    }

    public static String d(Object obj) {
        if (obj instanceof Failure) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public static Object e(Object obj) {
        return obj;
    }

    public static int f(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final /* synthetic */ Object a() {
        return this.f30172b;
    }

    public boolean equals(Object obj) {
        return a(this.f30172b, obj);
    }

    public int hashCode() {
        return f(this.f30172b);
    }

    public String toString() {
        return d(this.f30172b);
    }
}
