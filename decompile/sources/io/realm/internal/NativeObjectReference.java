package io.realm.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

final class NativeObjectReference extends PhantomReference<e> {

    /* renamed from: f  reason: collision with root package name */
    private static a f28954f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final long f28955a;

    /* renamed from: b  reason: collision with root package name */
    private final long f28956b;

    /* renamed from: c  reason: collision with root package name */
    private final d f28957c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public NativeObjectReference f28958d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public NativeObjectReference f28959e;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        NativeObjectReference f28960a;

        private a() {
        }

        /* access modifiers changed from: package-private */
        public synchronized void a(NativeObjectReference nativeObjectReference) {
            NativeObjectReference unused = nativeObjectReference.f28958d = null;
            NativeObjectReference unused2 = nativeObjectReference.f28959e = this.f28960a;
            NativeObjectReference nativeObjectReference2 = this.f28960a;
            if (nativeObjectReference2 != null) {
                NativeObjectReference unused3 = nativeObjectReference2.f28958d = nativeObjectReference;
            }
            this.f28960a = nativeObjectReference;
        }

        /* access modifiers changed from: package-private */
        public synchronized void b(NativeObjectReference nativeObjectReference) {
            NativeObjectReference a2 = nativeObjectReference.f28959e;
            NativeObjectReference b2 = nativeObjectReference.f28958d;
            NativeObjectReference unused = nativeObjectReference.f28959e = null;
            NativeObjectReference unused2 = nativeObjectReference.f28958d = null;
            if (b2 != null) {
                NativeObjectReference unused3 = b2.f28959e = a2;
            } else {
                this.f28960a = a2;
            }
            if (a2 != null) {
                NativeObjectReference unused4 = a2.f28958d = b2;
            }
        }
    }

    NativeObjectReference(d dVar, e eVar, ReferenceQueue<? super e> referenceQueue) {
        super(eVar, referenceQueue);
        this.f28955a = eVar.getNativePtr();
        this.f28956b = eVar.getNativeFinalizerPtr();
        this.f28957c = dVar;
        f28954f.a(this);
    }

    private static native void nativeCleanUp(long j2, long j3);

    /* access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f28957c) {
            nativeCleanUp(this.f28956b, this.f28955a);
        }
        f28954f.b(this);
    }
}
