package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

public class b {
    public static ApiException a(Status status) {
        return status.d() ? new ResolvableApiException(status) : new ApiException(status);
    }
}
