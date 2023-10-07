package com.android.volley;

import java.util.Collections;
import java.util.Map;

public interface a {

    /* renamed from: com.android.volley.a$a  reason: collision with other inner class name */
    public static class C0077a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f9887a;

        /* renamed from: b  reason: collision with root package name */
        public String f9888b;

        /* renamed from: c  reason: collision with root package name */
        public long f9889c;

        /* renamed from: d  reason: collision with root package name */
        public long f9890d;

        /* renamed from: e  reason: collision with root package name */
        public long f9891e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f9892f = Collections.emptyMap();

        public boolean a() {
            return this.f9890d < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f9891e < System.currentTimeMillis();
        }
    }

    C0077a a(String str);

    void a();

    void a(String str, C0077a aVar);
}
