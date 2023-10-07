package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.i;

final class z extends aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f17864a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i f17865b;

    z(Intent intent, i iVar, int i2) {
        this.f17864a = intent;
        this.f17865b = iVar;
    }

    public final void a() {
        Intent intent = this.f17864a;
        if (intent != null) {
            this.f17865b.startActivityForResult(intent, 2);
        }
    }
}
