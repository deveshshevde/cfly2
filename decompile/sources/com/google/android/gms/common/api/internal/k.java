package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.m;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private final Set<j<?>> f17615a = Collections.newSetFromMap(new WeakHashMap());

    public static <L> j.a<L> a(L l2, String str) {
        m.a(l2, (Object) "Listener must not be null");
        m.a(str, (Object) "Listener type must not be null");
        m.a(str, (Object) "Listener type must not be empty");
        return new j.a<>(l2, str);
    }

    public static <L> j<L> a(L l2, Looper looper, String str) {
        m.a(l2, (Object) "Listener must not be null");
        m.a(looper, (Object) "Looper must not be null");
        m.a(str, (Object) "Listener type must not be null");
        return new j<>(looper, l2, str);
    }

    public final void a() {
        for (j<?> b2 : this.f17615a) {
            b2.b();
        }
        this.f17615a.clear();
    }
}
