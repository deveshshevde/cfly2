package io.realm.internal;

import io.realm.d;

public class OsCollectionChangeSet implements d, e {

    /* renamed from: a  reason: collision with root package name */
    private static long f28963a = nativeGetFinalizerPtr();

    /* renamed from: b  reason: collision with root package name */
    private final long f28964b;

    public OsCollectionChangeSet(long j2) {
        this.f28964b = j2;
        d.f29033a.a(this);
    }

    private static native long nativeGetFinalizerPtr();

    private static native int[] nativeGetIndices(long j2, int i2);

    private static native int[] nativeGetRanges(long j2, int i2);

    public long getNativeFinalizerPtr() {
        return f28963a;
    }

    public long getNativePtr() {
        return this.f28964b;
    }
}
