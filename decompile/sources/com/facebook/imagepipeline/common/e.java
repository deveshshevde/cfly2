package com.facebook.imagepipeline.common;

import di.a;
import java.util.Locale;

public class e {

    /* renamed from: c  reason: collision with root package name */
    private static final e f11346c = new e(-1, false);

    /* renamed from: d  reason: collision with root package name */
    private static final e f11347d = new e(-2, false);

    /* renamed from: e  reason: collision with root package name */
    private static final e f11348e = new e(-1, true);

    /* renamed from: a  reason: collision with root package name */
    private final int f11349a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11350b;

    private e(int i2, boolean z2) {
        this.f11349a = i2;
        this.f11350b = z2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f11349a == eVar.f11349a && this.f11350b == eVar.f11350b;
    }

    public int hashCode() {
        return a.a((Object) Integer.valueOf(this.f11349a), (Object) Boolean.valueOf(this.f11350b));
    }

    public String toString() {
        return String.format((Locale) null, "%d defer:%b", new Object[]{Integer.valueOf(this.f11349a), Boolean.valueOf(this.f11350b)});
    }
}
