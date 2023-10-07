package io.realm.internal;

public class OsSchemaInfo implements e {

    /* renamed from: b  reason: collision with root package name */
    private static final long f29003b = nativeGetFinalizerPtr();

    /* renamed from: a  reason: collision with root package name */
    private long f29004a;

    /* renamed from: c  reason: collision with root package name */
    private final OsSharedRealm f29005c;

    OsSchemaInfo(long j2, OsSharedRealm osSharedRealm) {
        this.f29004a = j2;
        this.f29005c = osSharedRealm;
    }

    private static native long nativeCreateFromList(long[] jArr);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetObjectSchemaInfo(long j2, String str);

    public long getNativeFinalizerPtr() {
        return f29003b;
    }

    public long getNativePtr() {
        return this.f29004a;
    }
}
