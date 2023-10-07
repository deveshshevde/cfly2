package io.realm.internal;

import io.realm.RealmFieldType;

public class Table implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f29009a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f29010b;

    /* renamed from: c  reason: collision with root package name */
    private static final long f29011c = nativeGetFinalizerPtr();

    /* renamed from: d  reason: collision with root package name */
    private final long f29012d;

    /* renamed from: e  reason: collision with root package name */
    private final d f29013e;

    /* renamed from: f  reason: collision with root package name */
    private final OsSharedRealm f29014f;

    static {
        String a2 = Util.a();
        f29010b = a2;
        f29009a = 63 - a2.length();
    }

    Table(OsSharedRealm osSharedRealm, long j2) {
        d dVar = osSharedRealm.context;
        this.f29013e = dVar;
        this.f29014f = osSharedRealm;
        this.f29012d = j2;
        dVar.a(this);
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String str2 = f29010b;
        return !str.startsWith(str2) ? str : str.substring(str2.length());
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        return f29010b + str;
    }

    private native long nativeAddColumn(long j2, int i2, String str, boolean z2);

    private native long nativeAddColumnLink(long j2, int i2, String str, long j3);

    private native long nativeAddPrimitiveListColumn(long j2, int i2, String str, boolean z2);

    private native void nativeAddSearchIndex(long j2, long j3);

    private native void nativeClear(long j2);

    private native void nativeConvertColumnToNotNullable(long j2, long j3, boolean z2);

    private native void nativeConvertColumnToNullable(long j2, long j3, boolean z2);

    private native long nativeCountDouble(long j2, long j3, double d2);

    private native long nativeCountFloat(long j2, long j3, float f2);

    private native long nativeCountLong(long j2, long j3, long j4);

    private native long nativeCountString(long j2, long j3, String str);

    private native long nativeFindFirstBool(long j2, long j3, boolean z2);

    private native long nativeFindFirstDouble(long j2, long j3, double d2);

    private native long nativeFindFirstFloat(long j2, long j3, float f2);

    public static native long nativeFindFirstInt(long j2, long j3, long j4);

    public static native long nativeFindFirstNull(long j2, long j3);

    public static native long nativeFindFirstString(long j2, long j3, String str);

    private native long nativeFindFirstTimestamp(long j2, long j3, long j4);

    private native boolean nativeGetBoolean(long j2, long j3, long j4);

    private native byte[] nativeGetByteArray(long j2, long j3, long j4);

    private native long nativeGetColumnCount(long j2);

    private native long nativeGetColumnIndex(long j2, String str);

    private native String nativeGetColumnName(long j2, long j3);

    private native int nativeGetColumnType(long j2, long j3);

    private native double nativeGetDouble(long j2, long j3, long j4);

    private static native long nativeGetFinalizerPtr();

    private native float nativeGetFloat(long j2, long j3, long j4);

    private native long nativeGetLink(long j2, long j3, long j4);

    private native long nativeGetLinkTarget(long j2, long j3);

    private native long nativeGetLong(long j2, long j3, long j4);

    private native String nativeGetName(long j2);

    private native String nativeGetString(long j2, long j3, long j4);

    private native long nativeGetTimestamp(long j2, long j3, long j4);

    private native boolean nativeHasSameSchema(long j2, long j3);

    private native boolean nativeHasSearchIndex(long j2, long j3);

    public static native void nativeIncrementLong(long j2, long j3, long j4, long j5);

    private static native void nativeInsertColumn(long j2, long j3, int i2, String str);

    private native boolean nativeIsColumnNullable(long j2, long j3);

    private native boolean nativeIsNull(long j2, long j3, long j4);

    private native boolean nativeIsNullLink(long j2, long j3, long j4);

    private native boolean nativeIsValid(long j2);

    private static native void nativeMigratePrimaryKeyTableIfNeeded(long j2);

    private native void nativeMoveLastOver(long j2, long j3);

    public static native void nativeNullifyLink(long j2, long j3, long j4);

    private native void nativeRemoveColumn(long j2, long j3);

    private native void nativeRemoveSearchIndex(long j2, long j3);

    private native void nativeRenameColumn(long j2, long j3, String str);

    public static native void nativeSetBoolean(long j2, long j3, long j4, boolean z2, boolean z3);

    public static native void nativeSetByteArray(long j2, long j3, long j4, byte[] bArr, boolean z2);

    public static native void nativeSetDouble(long j2, long j3, long j4, double d2, boolean z2);

    public static native void nativeSetFloat(long j2, long j3, long j4, float f2, boolean z2);

    public static native void nativeSetLink(long j2, long j3, long j4, long j5, boolean z2);

    public static native void nativeSetLong(long j2, long j3, long j4, long j5, boolean z2);

    public static native void nativeSetNull(long j2, long j3, long j4, boolean z2);

    public static native void nativeSetString(long j2, long j3, long j4, String str, boolean z2);

    public static native void nativeSetTimestamp(long j2, long j3, long j4, long j5, boolean z2);

    private native long nativeSize(long j2);

    private native long nativeWhere(long j2);

    public long a() {
        return nativeSize(this.f29012d);
    }

    public long a(String str) {
        if (str != null) {
            return nativeGetColumnIndex(this.f29012d, str);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    public String a(long j2) {
        return nativeGetColumnName(this.f29012d, j2);
    }

    public long b() {
        return nativeGetColumnCount(this.f29012d);
    }

    public RealmFieldType b(long j2) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.f29012d, j2));
    }

    /* access modifiers changed from: package-private */
    public OsSharedRealm c() {
        return this.f29014f;
    }

    public Table c(long j2) {
        return new Table(this.f29014f, nativeGetLinkTarget(this.f29012d, j2));
    }

    public UncheckedRow d(long j2) {
        return UncheckedRow.a(this.f29013e, this, j2);
    }

    public String d() {
        return nativeGetName(this.f29012d);
    }

    public String e() {
        return b(d());
    }

    public long getNativeFinalizerPtr() {
        return f29011c;
    }

    public long getNativePtr() {
        return this.f29012d;
    }

    /* access modifiers changed from: package-private */
    public native long nativeGetRowPtr(long j2, long j3);

    public String toString() {
        long b2 = b();
        String d2 = d();
        StringBuilder sb = new StringBuilder("The Table ");
        if (d2 != null && !d2.isEmpty()) {
            sb.append(d());
            sb.append(" ");
        }
        sb.append("contains ");
        sb.append(b2);
        sb.append(" columns: ");
        int i2 = 0;
        while (true) {
            long j2 = (long) i2;
            if (j2 < b2) {
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(a(j2));
                i2++;
            } else {
                sb.append(".");
                sb.append(" And ");
                sb.append(a());
                sb.append(" rows.");
                return sb.toString();
            }
        }
    }
}
