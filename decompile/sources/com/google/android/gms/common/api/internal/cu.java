package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class cu extends bn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Dialog f17581a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cv f17582b;

    cu(cv cvVar, Dialog dialog) {
        this.f17582b = cvVar;
        this.f17581a = dialog;
    }

    public final void a() {
        this.f17582b.f17583a.f();
        if (this.f17581a.isShowing()) {
            this.f17581a.dismiss();
        }
    }
}
