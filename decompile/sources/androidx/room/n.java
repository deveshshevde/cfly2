package androidx.room;

import ag.f;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f4472a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase f4473b;

    /* renamed from: c  reason: collision with root package name */
    private volatile f f4474c;

    public n(RoomDatabase roomDatabase) {
        this.f4473b = roomDatabase;
    }

    private f a(boolean z2) {
        if (!z2) {
            return d();
        }
        if (this.f4474c == null) {
            this.f4474c = d();
        }
        return this.f4474c;
    }

    private f d() {
        return this.f4473b.a(a());
    }

    /* access modifiers changed from: protected */
    public abstract String a();

    public void a(f fVar) {
        if (fVar == this.f4474c) {
            this.f4472a.set(false);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f4473b.e();
    }

    public f c() {
        b();
        return a(this.f4472a.compareAndSet(false, true));
    }
}
