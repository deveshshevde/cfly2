package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ac {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, aa> f3604a = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final aa a(String str) {
        return this.f3604a.get(str);
    }

    /* access modifiers changed from: package-private */
    public Set<String> a() {
        return new HashSet(this.f3604a.keySet());
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, aa aaVar) {
        aa put = this.f3604a.put(str, aaVar);
        if (put != null) {
            put.a();
        }
    }

    public final void b() {
        for (aa d2 : this.f3604a.values()) {
            d2.d();
        }
        this.f3604a.clear();
    }
}
