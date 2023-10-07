package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.m;
import java.lang.ref.WeakReference;

final class af implements d.c {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<aq> f17420a;

    /* renamed from: b  reason: collision with root package name */
    private final a<?> f17421b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final boolean f17422c;

    public af(aq aqVar, a<?> aVar, boolean z2) {
        this.f17420a = new WeakReference<>(aqVar);
        this.f17421b = aVar;
        this.f17422c = z2;
    }

    public final void a(ConnectionResult connectionResult) {
        aq aqVar = (aq) this.f17420a.get();
        if (aqVar != null) {
            m.b(Looper.myLooper() == aqVar.f17435a.f11788g.a(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            aqVar.f17436b.lock();
            try {
                if (aqVar.b(0)) {
                    if (!connectionResult.e()) {
                        aqVar.b(connectionResult, this.f17421b, this.f17422c);
                    }
                    if (aqVar.h()) {
                        aqVar.g();
                    }
                }
            } finally {
                aqVar.f17436b.unlock();
            }
        }
    }
}
