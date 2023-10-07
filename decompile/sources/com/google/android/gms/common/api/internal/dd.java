package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class dd implements bo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f17593a;

    /* synthetic */ dd(u uVar, dc dcVar) {
        this.f17593a = uVar;
    }

    public final void a(int i2, boolean z2) {
        this.f17593a.f17651m.lock();
        try {
            u uVar = this.f17593a;
            if (!uVar.f17650l && uVar.f17649k != null) {
                if (uVar.f17649k.e()) {
                    this.f17593a.f17650l = true;
                    this.f17593a.f17643e.a(i2);
                }
            }
            this.f17593a.f17650l = false;
            u.a(this.f17593a, i2, z2);
        } finally {
            this.f17593a.f17651m.unlock();
        }
    }

    public final void a(Bundle bundle) {
        this.f17593a.f17651m.lock();
        try {
            u.a(this.f17593a, bundle);
            this.f17593a.f17648j = ConnectionResult.f17353a;
            u.e(this.f17593a);
        } finally {
            this.f17593a.f17651m.unlock();
        }
    }

    public final void a(ConnectionResult connectionResult) {
        this.f17593a.f17651m.lock();
        try {
            this.f17593a.f17648j = connectionResult;
            u.e(this.f17593a);
        } finally {
            this.f17593a.f17651m.unlock();
        }
    }
}
