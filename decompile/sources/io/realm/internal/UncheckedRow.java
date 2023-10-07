package io.realm.internal;

public class UncheckedRow implements e, j {

    /* renamed from: a  reason: collision with root package name */
    private static final long f29015a = nativeGetFinalizerPtr();

    /* renamed from: b  reason: collision with root package name */
    private final d f29016b;

    /* renamed from: c  reason: collision with root package name */
    private final Table f29017c;

    /* renamed from: d  reason: collision with root package name */
    private final long f29018d;

    UncheckedRow(UncheckedRow uncheckedRow) {
        this.f29016b = uncheckedRow.f29016b;
        this.f29017c = uncheckedRow.f29017c;
        this.f29018d = uncheckedRow.f29018d;
    }

    UncheckedRow(d dVar, Table table, long j2) {
        this.f29016b = dVar;
        this.f29017c = table;
        this.f29018d = j2;
        dVar.a(this);
    }

    static UncheckedRow a(d dVar, Table table, long j2) {
        return new UncheckedRow(dVar, table, j2);
    }

    private static native long nativeGetFinalizerPtr();

    public long getNativeFinalizerPtr() {
        return f29015a;
    }

    public long getNativePtr() {
        return this.f29018d;
    }

    /* access modifiers changed from: protected */
    public native boolean nativeGetBoolean(long j2, long j3);

    /* access modifiers changed from: protected */
    public native byte[] nativeGetByteArray(long j2, long j3);

    /* access modifiers changed from: protected */
    public native long nativeGetColumnCount(long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetColumnIndex(long j2, String str);

    /* access modifiers changed from: protected */
    public native String nativeGetColumnName(long j2, long j3);

    /* access modifiers changed from: protected */
    public native int nativeGetColumnType(long j2, long j3);

    /* access modifiers changed from: protected */
    public native double nativeGetDouble(long j2, long j3);

    /* access modifiers changed from: protected */
    public native float nativeGetFloat(long j2, long j3);

    /* access modifiers changed from: protected */
    public native long nativeGetIndex(long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetLink(long j2, long j3);

    /* access modifiers changed from: protected */
    public native long nativeGetLong(long j2, long j3);

    /* access modifiers changed from: protected */
    public native String nativeGetString(long j2, long j3);

    /* access modifiers changed from: protected */
    public native long nativeGetTimestamp(long j2, long j3);

    /* access modifiers changed from: protected */
    public native boolean nativeHasColumn(long j2, String str);

    /* access modifiers changed from: protected */
    public native boolean nativeIsAttached(long j2);

    /* access modifiers changed from: protected */
    public native boolean nativeIsNull(long j2, long j3);

    /* access modifiers changed from: protected */
    public native boolean nativeIsNullLink(long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeNullifyLink(long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeSetBoolean(long j2, long j3, boolean z2);

    /* access modifiers changed from: protected */
    public native void nativeSetByteArray(long j2, long j3, byte[] bArr);

    /* access modifiers changed from: protected */
    public native void nativeSetDouble(long j2, long j3, double d2);

    /* access modifiers changed from: protected */
    public native void nativeSetFloat(long j2, long j3, float f2);

    /* access modifiers changed from: protected */
    public native void nativeSetLink(long j2, long j3, long j4);

    /* access modifiers changed from: protected */
    public native void nativeSetLong(long j2, long j3, long j4);

    /* access modifiers changed from: protected */
    public native void nativeSetNull(long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeSetString(long j2, long j3, String str);

    /* access modifiers changed from: protected */
    public native void nativeSetTimestamp(long j2, long j3, long j4);
}
