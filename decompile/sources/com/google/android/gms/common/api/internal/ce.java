package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.tasks.c;

final class ce extends s {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s.a f17545a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ce(s.a aVar, Feature[] featureArr, boolean z2, int i2) {
        super(featureArr, z2, i2);
        this.f17545a = aVar;
    }

    /* access modifiers changed from: protected */
    public final void a(a.b bVar, c cVar) throws RemoteException {
        this.f17545a.f17635a.a(bVar, cVar);
    }
}
