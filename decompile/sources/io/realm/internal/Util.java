package io.realm.internal;

public class Util {
    public static String a() {
        return nativeGetTablePrefix();
    }

    static native String nativeGetTablePrefix();
}
