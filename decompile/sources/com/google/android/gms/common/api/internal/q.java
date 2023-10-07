package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.g;

public class q extends g.a {

    /* renamed from: a  reason: collision with root package name */
    private final d.b<Status> f17631a;

    public q(d.b<Status> bVar) {
        this.f17631a = bVar;
    }

    public void a(Status status) {
        this.f17631a.setResult(status);
    }
}
