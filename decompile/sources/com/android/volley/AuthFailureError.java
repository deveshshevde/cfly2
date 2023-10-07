package com.android.volley;

import android.content.Intent;

public class AuthFailureError extends VolleyError {

    /* renamed from: b  reason: collision with root package name */
    private Intent f9864b;

    public AuthFailureError() {
    }

    public AuthFailureError(g gVar) {
        super(gVar);
    }

    public String getMessage() {
        return this.f9864b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
