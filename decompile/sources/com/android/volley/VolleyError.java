package com.android.volley;

public class VolleyError extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final g f9886a;

    public VolleyError() {
        this.f9886a = null;
    }

    public VolleyError(g gVar) {
        this.f9886a = gVar;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.f9886a = null;
    }
}
