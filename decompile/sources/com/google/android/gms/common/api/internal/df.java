package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class df implements bo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f17594a;

    /* synthetic */ df(u uVar, de deVar) {
        this.f17594a = uVar;
    }

    public final void a(int i2, boolean z2) {
        this.f17594a.f17651m.lock();
        try {
            u uVar = this.f17594a;
            if (uVar.f17650l) {
                uVar.f17650l = false;
                u.a(this.f17594a, i2, z2);
            } else {
                uVar.f17650l = true;
                this.f17594a.f17642d.a(i2);
            }
        } finally {
            this.f17594a.f17651m.unlock();
        }
    }

    public final void a(Bundle bundle) {
        this.f17594a.f17651m.lock();
        try {
            this.f17594a.f17649k = ConnectionResult.f17353a;
            u.e(this.f17594a);
        } finally {
            this.f17594a.f17651m.unlock();
        }
    }

    public final void a(ConnectionResult connectionResult) {
        this.f17594a.f17651m.lock();
        try {
            this.f17594a.f17649k = connectionResult;
            u.e(this.f17594a);
        } finally {
            this.f17594a.f17651m.unlock();
        }
    }
}
