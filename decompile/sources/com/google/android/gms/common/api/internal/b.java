package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.l;

public final class b<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final int f17485a;

    /* renamed from: b  reason: collision with root package name */
    private final a<O> f17486b;

    /* renamed from: c  reason: collision with root package name */
    private final O f17487c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17488d;

    private b(a<O> aVar, O o2, String str) {
        this.f17486b = aVar;
        this.f17487c = o2;
        this.f17488d = str;
        this.f17485a = l.a(aVar, o2, str);
    }

    public static <O extends a.d> b<O> a(a<O> aVar, O o2, String str) {
        return new b<>(aVar, o2, str);
    }

    public final String a() {
        return this.f17486b.d();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return l.a(this.f17486b, bVar.f17486b) && l.a(this.f17487c, bVar.f17487c) && l.a(this.f17488d, bVar.f17488d);
    }

    public final int hashCode() {
        return this.f17485a;
    }
}
