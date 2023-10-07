package mp;

import java.util.Random;
import kotlin.jvm.internal.h;

public final class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private final a f31273b = new a();

    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    public Random a() {
        Object obj = this.f31273b.get();
        h.b(obj, "implStorage.get()");
        return (Random) obj;
    }
}
