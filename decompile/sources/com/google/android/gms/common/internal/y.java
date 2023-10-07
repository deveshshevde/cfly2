package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

final class y extends aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f17861a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Fragment f17862b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f17863c;

    y(Intent intent, Fragment fragment, int i2) {
        this.f17861a = intent;
        this.f17862b = fragment;
        this.f17863c = i2;
    }

    public final void a() {
        Intent intent = this.f17861a;
        if (intent != null) {
            this.f17862b.startActivityForResult(intent, this.f17863c);
        }
    }
}
