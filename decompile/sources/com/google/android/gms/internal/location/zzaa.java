package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.g;
import com.google.android.gms.location.h;

abstract class zzaa extends h.a<Status> {
    public zzaa(d dVar) {
        super(dVar);
    }

    public /* synthetic */ g createFailedResult(Status status) {
        return status;
    }
}
