package com.bumptech.glide.load;

import cc.b;
import j.a;
import java.security.MessageDigest;

public final class f implements c {

    /* renamed from: b  reason: collision with root package name */
    private final a<e<?>, Object> f10422b = new b();

    private static <T> void a(e<T> eVar, Object obj, MessageDigest messageDigest) {
        eVar.a(obj, messageDigest);
    }

    public <T> f a(e<T> eVar, T t2) {
        this.f10422b.put(eVar, t2);
        return this;
    }

    public <T> T a(e<T> eVar) {
        return this.f10422b.containsKey(eVar) ? this.f10422b.get(eVar) : eVar.a();
    }

    public void a(f fVar) {
        this.f10422b.a(fVar.f10422b);
    }

    public void a(MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f10422b.size(); i2++) {
            a(this.f10422b.b(i2), this.f10422b.c(i2), messageDigest);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f10422b.equals(((f) obj).f10422b);
        }
        return false;
    }

    public int hashCode() {
        return this.f10422b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f10422b + '}';
    }
}
