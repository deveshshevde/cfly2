package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;

final class v implements e.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BasePendingResult f17653a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ x f17654b;

    v(x xVar, BasePendingResult basePendingResult) {
        this.f17654b = xVar;
        this.f17653a = basePendingResult;
    }

    public final void a(Status status) {
        this.f17654b.f17657a.remove(this.f17653a);
    }
}
