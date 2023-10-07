package io.realm;

import io.realm.internal.OsSharedRealm;
import io.realm.log.RealmLog;
import java.io.Closeable;

abstract class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final io.realm.internal.async.a f28926a = io.realm.internal.async.a.a();

    /* renamed from: e  reason: collision with root package name */
    public static final b f28927e = new b();

    /* renamed from: b  reason: collision with root package name */
    final long f28928b;

    /* renamed from: c  reason: collision with root package name */
    protected final h f28929c;

    /* renamed from: d  reason: collision with root package name */
    public OsSharedRealm f28930d;

    /* renamed from: f  reason: collision with root package name */
    private RealmCache f28931f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f28932g;

    /* renamed from: io.realm.a$a  reason: collision with other inner class name */
    public static final class C0195a {
    }

    static final class b extends ThreadLocal<C0195a> {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C0195a initialValue() {
            return new C0195a();
        }
    }

    public String a() {
        return this.f28929c.f();
    }

    public h b() {
        return this.f28929c;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f28931f = null;
        OsSharedRealm osSharedRealm = this.f28930d;
        if (osSharedRealm != null && this.f28932g) {
            osSharedRealm.close();
            this.f28930d = null;
        }
    }

    public void close() {
        if (this.f28928b == Thread.currentThread().getId()) {
            RealmCache realmCache = this.f28931f;
            if (realmCache != null) {
                realmCache.a(this);
            } else {
                c();
            }
        } else {
            throw new IllegalStateException("Realm access from incorrect thread. Realm instance can only be closed on the thread it was created.");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        OsSharedRealm osSharedRealm;
        if (this.f28932g && (osSharedRealm = this.f28930d) != null && !osSharedRealm.isClosed()) {
            RealmLog.a("Remember to call close() on all Realm instances. Realm %s is being finalized without being closed, this can lead to running out of native memory.", this.f28929c.f());
            RealmCache realmCache = this.f28931f;
            if (realmCache != null) {
                realmCache.a();
            }
        }
        super.finalize();
    }
}
