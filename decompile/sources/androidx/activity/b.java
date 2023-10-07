package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f452a;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f453b = new CopyOnWriteArrayList<>();

    public b(boolean z2) {
        this.f452a = z2;
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f453b.add(aVar);
    }

    public final void a(boolean z2) {
        this.f452a = z2;
    }

    public final boolean a() {
        return this.f452a;
    }

    public final void b() {
        Iterator<a> it2 = this.f453b.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        this.f453b.remove(aVar);
    }

    public abstract void c();
}
