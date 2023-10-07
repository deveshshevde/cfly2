package kotlinx.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.internal.h;

public final class ae extends kotlin.coroutines.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30295a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private final String f30296b;

    public static final class a implements f.c<ae> {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final String a() {
        return this.f30296b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ae) && h.a((Object) this.f30296b, (Object) ((ae) obj).f30296b);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f30296b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CoroutineName(" + this.f30296b + ')';
    }
}
