package com.google.android.gms.auth.api.signin.internal;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static int f17347a = 31;

    /* renamed from: b  reason: collision with root package name */
    private int f17348b = 1;

    public int a() {
        return this.f17348b;
    }

    public a a(Object obj) {
        this.f17348b = (f17347a * this.f17348b) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public final a a(boolean z2) {
        this.f17348b = (f17347a * this.f17348b) + (z2 ? 1 : 0);
        return this;
    }
}
