package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class f {

    /* renamed from: a  reason: collision with root package name */
    static final f f20127a = new f(true);

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f20128b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f20129c = a();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Object, Object<?, ?>> f20130d;

    f() {
        this.f20130d = new HashMap();
    }

    f(boolean z2) {
        this.f20130d = Collections.emptyMap();
    }

    static Class<?> a() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static f b() {
        return e.b();
    }
}
