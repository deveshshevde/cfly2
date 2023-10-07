package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.l;

final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f17730a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return l.a(((c) obj).f17730a, this.f17730a);
    }

    public final int hashCode() {
        return l.a(this.f17730a);
    }
}
