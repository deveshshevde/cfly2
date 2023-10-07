package a;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f2a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private volatile Context f3b;

    public Context a() {
        return this.f3b;
    }

    public void a(b bVar) {
        if (this.f3b != null) {
            bVar.a(this.f3b);
        }
        this.f2a.add(bVar);
    }

    public void a(Context context) {
        this.f3b = context;
        for (b a2 : this.f2a) {
            a2.a(context);
        }
    }

    public void b() {
        this.f3b = null;
    }

    public void b(b bVar) {
        this.f2a.remove(bVar);
    }
}
