package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class aa {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f3597a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f3598b = false;

    private static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public <T> T a(String str, T t2) {
        T t3;
        synchronized (this.f3597a) {
            t3 = this.f3597a.get(str);
            if (t3 == null) {
                this.f3597a.put(str, t2);
            }
        }
        if (t3 != null) {
            t2 = t3;
        }
        if (this.f3598b) {
            a(t2);
        }
        return t2;
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: package-private */
    public <T> T b(String str) {
        T t2;
        Map<String, Object> map = this.f3597a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t2 = this.f3597a.get(str);
        }
        return t2;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        this.f3598b = true;
        Map<String, Object> map = this.f3597a;
        if (map != null) {
            synchronized (map) {
                for (Object a2 : this.f3597a.values()) {
                    a(a2);
                }
            }
        }
        a();
    }
}
