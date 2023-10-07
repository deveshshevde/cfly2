package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;

final class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConnectionResult f17499a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ bl f17500b;

    bk(bl blVar, ConnectionResult connectionResult) {
        this.f17500b = blVar;
        this.f17499a = connectionResult;
    }

    public final void run() {
        bl blVar = this.f17500b;
        bh bhVar = (bh) blVar.f17501a.f11826p.get(blVar.f17503c);
        if (bhVar != null) {
            if (this.f17499a.e()) {
                this.f17500b.f17506f = true;
                if (this.f17500b.f17502b.requiresSignIn()) {
                    this.f17500b.a();
                    return;
                }
                try {
                    bl blVar2 = this.f17500b;
                    blVar2.f17502b.getRemoteService((h) null, blVar2.f17502b.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException e2) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
                    this.f17500b.f17502b.disconnect("Failed to get service from broker.");
                    bhVar.a(new ConnectionResult(10), (Exception) null);
                }
            } else {
                bhVar.a(this.f17499a, (Exception) null);
            }
        }
    }
}
