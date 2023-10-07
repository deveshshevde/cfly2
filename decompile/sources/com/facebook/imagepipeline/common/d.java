package com.facebook.imagepipeline.common;

import di.a;
import java.util.Locale;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f11344a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11345b;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f11344a == dVar.f11344a && this.f11345b == dVar.f11345b;
    }

    public int hashCode() {
        return a.a(this.f11344a, this.f11345b);
    }

    public String toString() {
        return String.format((Locale) null, "%dx%d", new Object[]{Integer.valueOf(this.f11344a), Integer.valueOf(this.f11345b)});
    }
}
