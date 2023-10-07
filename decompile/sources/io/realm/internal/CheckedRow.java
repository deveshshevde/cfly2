package io.realm.internal;

public class CheckedRow extends UncheckedRow {

    /* renamed from: a  reason: collision with root package name */
    private UncheckedRow f28951a;

    private CheckedRow(UncheckedRow uncheckedRow) {
        super(uncheckedRow);
        this.f28951a = uncheckedRow;
    }

    public static CheckedRow a(UncheckedRow uncheckedRow) {
        return new CheckedRow(uncheckedRow);
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
    public native long nativeGetLink(long j2, long j3);

    /* access modifiers changed from: protected */
    public native long nativeGetLong(long j2, long j3);

    /* access modifiers changed from: protected */
    public native String nativeGetString(long j2, long j3);

    /* access modifiers changed from: protected */
    public native long nativeGetTimestamp(long j2, long j3);

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
    public native void nativeSetString(long j2, long j3, String str);

    /* access modifiers changed from: protected */
    public native void nativeSetTimestamp(long j2, long j3, long j4);
}
