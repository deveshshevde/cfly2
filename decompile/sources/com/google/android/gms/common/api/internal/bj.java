package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.l;

final class bj {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b<?> f17497a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Feature f17498b;

    /* synthetic */ bj(b bVar, Feature feature, bi biVar) {
        this.f17497a = bVar;
        this.f17498b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof bj)) {
            bj bjVar = (bj) obj;
            return l.a(this.f17497a, bjVar.f17497a) && l.a(this.f17498b, bjVar.f17498b);
        }
    }

    public final int hashCode() {
        return l.a(this.f17497a, this.f17498b);
    }

    public final String toString() {
        return l.a((Object) this).a("key", this.f17497a).a("feature", this.f17498b).toString();
    }
}
