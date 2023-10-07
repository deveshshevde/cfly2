package com.android.volley;

import com.android.volley.a;

public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f9931a;

    /* renamed from: b  reason: collision with root package name */
    public final a.C0077a f9932b;

    /* renamed from: c  reason: collision with root package name */
    public final VolleyError f9933c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9934d;

    public interface a {
        void a(VolleyError volleyError);
    }

    public interface b<T> {
        void a(T t2);
    }

    private i(VolleyError volleyError) {
        this.f9934d = false;
        this.f9931a = null;
        this.f9932b = null;
        this.f9933c = volleyError;
    }

    private i(T t2, a.C0077a aVar) {
        this.f9934d = false;
        this.f9931a = t2;
        this.f9932b = aVar;
        this.f9933c = null;
    }

    public static <T> i<T> a(VolleyError volleyError) {
        return new i<>(volleyError);
    }

    public static <T> i<T> a(T t2, a.C0077a aVar) {
        return new i<>(t2, aVar);
    }

    public boolean a() {
        return this.f9933c == null;
    }
}
