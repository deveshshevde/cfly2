package com.facebook.imagepipeline.common;

import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f11323a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11324b;

    private static String a(int i2) {
        return i2 == Integer.MAX_VALUE ? "" : Integer.toString(i2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11323a == aVar.f11323a && this.f11324b == aVar.f11324b;
    }

    public int hashCode() {
        return di.a.a(this.f11323a, this.f11324b);
    }

    public String toString() {
        return String.format((Locale) null, "%s-%s", new Object[]{a(this.f11323a), a(this.f11324b)});
    }
}
