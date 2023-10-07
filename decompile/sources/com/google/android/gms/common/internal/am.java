package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class am extends au<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public final int f17780a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f17781b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ d f17782c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected am(d dVar, int i2, Bundle bundle) {
        super(dVar, true);
        this.f17782c = dVar;
        this.f17780a = i2;
        this.f17781b = bundle;
    }

    /* access modifiers changed from: protected */
    public final void a() {
    }

    /* access modifiers changed from: protected */
    public abstract void a(ConnectionResult connectionResult);

    /* JADX WARNING: type inference failed for: r3v5, types: [android.os.Parcelable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(java.lang.Object r3) {
        /*
            r2 = this;
            int r3 = r2.f17780a
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L_0x001c
            boolean r3 = r2.b()
            if (r3 != 0) goto L_0x001b
            com.google.android.gms.common.internal.d r3 = r2.f17782c
            r3.zzp(r0, null)
            com.google.android.gms.common.ConnectionResult r3 = new com.google.android.gms.common.ConnectionResult
            r0 = 8
            r3.<init>(r0, r1)
        L_0x0018:
            r2.a((com.google.android.gms.common.ConnectionResult) r3)
        L_0x001b:
            return
        L_0x001c:
            com.google.android.gms.common.internal.d r3 = r2.f17782c
            r3.zzp(r0, null)
            android.os.Bundle r3 = r2.f17781b
            if (r3 == 0) goto L_0x002e
            java.lang.String r0 = "pendingIntent"
            android.os.Parcelable r3 = r3.getParcelable(r0)
            r1 = r3
            android.app.PendingIntent r1 = (android.app.PendingIntent) r1
        L_0x002e:
            com.google.android.gms.common.ConnectionResult r3 = new com.google.android.gms.common.ConnectionResult
            int r0 = r2.f17780a
            r3.<init>(r0, r1)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.am.a(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public abstract boolean b();
}
