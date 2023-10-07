package io.realm.internal;

public class OsObjectStore {
    public static String a(OsSharedRealm osSharedRealm, String str) {
        return nativeGetPrimaryKeyForObject(osSharedRealm.getNativePtr(), str);
    }

    private static native boolean nativeCallWithLock(String str, Runnable runnable);

    private static native boolean nativeDeleteTableForObject(long j2, String str);

    private static native String nativeGetPrimaryKeyForObject(long j2, String str);

    private static native long nativeGetSchemaVersion(long j2);

    private static native void nativeSetPrimaryKeyForObject(long j2, String str, String str2);

    private static native void nativeSetSchemaVersion(long j2, long j3);
}
