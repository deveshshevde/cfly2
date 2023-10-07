package com.bumptech.glide.load;

import cc.k;
import java.security.MessageDigest;

public final class e<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final a<Object> f10189a = new a<Object>() {
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final T f10190b;

    /* renamed from: c  reason: collision with root package name */
    private final a<T> f10191c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10192d;

    /* renamed from: e  reason: collision with root package name */
    private volatile byte[] f10193e;

    public interface a<T> {
        void a(byte[] bArr, T t2, MessageDigest messageDigest);
    }

    private e(String str, T t2, a<T> aVar) {
        this.f10192d = k.a(str);
        this.f10190b = t2;
        this.f10191c = (a) k.a(aVar);
    }

    public static <T> e<T> a(String str) {
        return new e<>(str, (Object) null, c());
    }

    public static <T> e<T> a(String str, T t2) {
        return new e<>(str, t2, c());
    }

    public static <T> e<T> a(String str, T t2, a<T> aVar) {
        return new e<>(str, t2, aVar);
    }

    private byte[] b() {
        if (this.f10193e == null) {
            this.f10193e = this.f10192d.getBytes(c.f10157a);
        }
        return this.f10193e;
    }

    private static <T> a<T> c() {
        return f10189a;
    }

    public T a() {
        return this.f10190b;
    }

    public void a(T t2, MessageDigest messageDigest) {
        this.f10191c.a(b(), t2, messageDigest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f10192d.equals(((e) obj).f10192d);
        }
        return false;
    }

    public int hashCode() {
        return this.f10192d.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f10192d + '\'' + '}';
    }
}
