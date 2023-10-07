package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.g;
import com.google.android.gms.location.a;

abstract class zzi extends a.C0124a<Status> {
    public zzi(d dVar) {
        super(dVar);
    }

    public /* synthetic */ g createFailedResult(Status status) {
        return status;
    }
}
