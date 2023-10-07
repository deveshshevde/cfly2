package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class x extends aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f17858a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f17859b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f17860c;

    x(Intent intent, Activity activity, int i2) {
        this.f17858a = intent;
        this.f17859b = activity;
        this.f17860c = i2;
    }

    public final void a() {
        Intent intent = this.f17858a;
        if (intent != null) {
            this.f17859b.startActivityForResult(intent, this.f17860c);
        }
    }
}
