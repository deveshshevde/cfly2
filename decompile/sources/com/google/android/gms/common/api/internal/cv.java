package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.m;

final class cv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cw f17583a;

    /* renamed from: b  reason: collision with root package name */
    private final ct f17584b;

    cv(cw cwVar, ct ctVar) {
        this.f17583a = cwVar;
        this.f17584b = ctVar;
    }

    public final void run() {
        if (this.f17583a.f17585b) {
            ConnectionResult b2 = this.f17584b.b();
            if (b2.d()) {
                this.f17583a.f17414a.startActivityForResult(GoogleApiActivity.a(this.f17583a.a(), (PendingIntent) m.a(b2.b()), this.f17584b.a(), false), 1);
                return;
            }
            cw cwVar = this.f17583a;
            if (cwVar.f17587d.a((Context) cwVar.a(), b2.a(), (String) null) != null) {
                cw cwVar2 = this.f17583a;
                cwVar2.f17587d.a(cwVar2.a(), this.f17583a.f17414a, b2.a(), 2, this.f17583a);
            } else if (b2.a() == 18) {
                cw cwVar3 = this.f17583a;
                Dialog a2 = cwVar3.f17587d.a(cwVar3.a(), (DialogInterface.OnCancelListener) this.f17583a);
                cw cwVar4 = this.f17583a;
                cwVar4.f17587d.a(cwVar4.a().getApplicationContext(), (bn) new cu(this, a2));
            } else {
                this.f17583a.c(b2, this.f17584b.a());
            }
        }
    }
}
