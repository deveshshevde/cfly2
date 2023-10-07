package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.a;

public class q implements a.d.f {

    /* renamed from: a  reason: collision with root package name */
    public static final q f17852a = a().a();

    /* renamed from: b  reason: collision with root package name */
    private final String f17853b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f17854a;

        private a() {
        }

        /* synthetic */ a(t tVar) {
        }

        public q a() {
            return new q(this.f17854a, (u) null);
        }
    }

    /* synthetic */ q(String str, u uVar) {
        this.f17853b = str;
    }

    public static a a() {
        return new a((t) null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f17853b;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        return l.a(this.f17853b, ((q) obj).f17853b);
    }

    public final int hashCode() {
        return l.a(this.f17853b);
    }
}
