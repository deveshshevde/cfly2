package com.google.protobuf;

final class e {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?> f20126a = a();

    private static final f a(String str) throws Exception {
        return (f) f20126a.getMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }

    static Class<?> a() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static f b() {
        if (f20126a != null) {
            try {
                return a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return f.f20127a;
    }
}
