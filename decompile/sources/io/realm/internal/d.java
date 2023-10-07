package io.realm.internal;

import java.lang.ref.ReferenceQueue;

public class d {

    /* renamed from: a  reason: collision with root package name */
    static final d f29033a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final ReferenceQueue<e> f29034b;

    /* renamed from: c  reason: collision with root package name */
    private static final Thread f29035c;

    static {
        ReferenceQueue<e> referenceQueue = new ReferenceQueue<>();
        f29034b = referenceQueue;
        Thread thread = new Thread(new c(referenceQueue));
        f29035c = thread;
        thread.setName("RealmFinalizingDaemon");
        thread.start();
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        new NativeObjectReference(this, eVar, f29034b);
    }
}
