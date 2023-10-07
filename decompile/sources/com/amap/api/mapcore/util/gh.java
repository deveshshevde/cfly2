package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class gh {

    /* renamed from: a  reason: collision with root package name */
    private ff f8920a;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f8921b = -1;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, gh> f8922a = new HashMap();
    }

    private gh(ff ffVar) {
        this.f8920a = ffVar;
    }

    public static gh a(ff ffVar) {
        if (a.f8922a.get(ffVar.a()) == null) {
            a.f8922a.put(ffVar.a(), new gh(ffVar));
        }
        return a.f8922a.get(ffVar.a());
    }

    public final void a(Context context, boolean z2, boolean z3) {
        gl.a(context, this.f8920a, "sckey", String.valueOf(z2));
        if (z2) {
            gl.a(context, this.f8920a, "scisf", String.valueOf(z3));
        }
    }

    public final boolean a(Context context) {
        try {
            return Boolean.parseBoolean(gl.a(context, this.f8920a, "sckey"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean b(Context context) {
        try {
            return Boolean.parseBoolean(gl.a(context, this.f8920a, "scisf"));
        } catch (Throwable unused) {
            return true;
        }
    }
}
