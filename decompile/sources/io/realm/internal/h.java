package io.realm.internal;

import io.realm.g;
import java.lang.ref.WeakReference;

public class h implements j {

    /* renamed from: a  reason: collision with root package name */
    private OsSharedRealm f29043a;

    /* renamed from: b  reason: collision with root package name */
    private OsResults f29044b;

    /* renamed from: c  reason: collision with root package name */
    private g<h> f29045c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<a> f29046d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29047e;

    public interface a {
        void a(j jVar);
    }

    private void b() {
        this.f29044b.a(this, this.f29045c);
        this.f29044b = null;
        this.f29045c = null;
        this.f29043a.removePendingRow(this);
    }

    private void c() {
        j jVar;
        WeakReference<a> weakReference = this.f29046d;
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar == null) {
                b();
            } else if (this.f29044b.d()) {
                UncheckedRow b2 = this.f29044b.b();
                b();
                if (b2 != null) {
                    jVar = b2;
                    if (this.f29047e) {
                        jVar = CheckedRow.a(b2);
                    }
                } else {
                    jVar = InvalidRow.INSTANCE;
                }
                aVar.a(jVar);
            } else {
                b();
            }
        } else {
            throw new IllegalStateException("The 'frontEnd' has not been set.");
        }
    }

    public void a() {
        if (this.f29044b != null) {
            c();
            return;
        }
        throw new IllegalStateException("The query has been executed. This 'PendingRow' is not valid anymore.");
    }
}
