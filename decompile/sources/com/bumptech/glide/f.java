package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, Object> f10090a;

    static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Map<Class<?>, Object> f10091a = new HashMap();

        a() {
        }

        /* access modifiers changed from: package-private */
        public f a() {
            return new f(this);
        }
    }

    f(a aVar) {
        this.f10090a = Collections.unmodifiableMap(new HashMap(aVar.f10091a));
    }

    public boolean a(Class<? extends Object> cls) {
        return this.f10090a.containsKey(cls);
    }
}
