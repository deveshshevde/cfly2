package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;

final class cb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zak f17535a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cd f17536b;

    cb(cd cdVar, zak zak) {
        this.f17536b = cdVar;
        this.f17535a = zak;
    }

    public final void run() {
        cd.a(this.f17536b, this.f17535a);
    }
}
