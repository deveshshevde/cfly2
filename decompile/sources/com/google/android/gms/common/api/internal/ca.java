package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class ca implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cd f17534a;

    ca(cd cdVar) {
        this.f17534a = cdVar;
    }

    public final void run() {
        this.f17534a.f17544h.b(new ConnectionResult(4));
    }
}
