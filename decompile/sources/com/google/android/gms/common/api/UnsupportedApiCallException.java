package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

public final class UnsupportedApiCallException extends UnsupportedOperationException {

    /* renamed from: a  reason: collision with root package name */
    private final Feature f17386a;

    public UnsupportedApiCallException(Feature feature) {
        this.f17386a = feature;
    }

    public String getMessage() {
        String valueOf = String.valueOf(this.f17386a);
        String.valueOf(valueOf).length();
        return "Missing ".concat(String.valueOf(valueOf));
    }
}
