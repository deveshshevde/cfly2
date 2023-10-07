package com.google.android.gms.location;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.location.zzae;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zzbh;
import com.google.android.gms.internal.location.zzn;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<a.d.C0120d> f18096a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final c f18097b = new zzn();
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final e f18098c = new zzae();
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final j f18099d = new zzbh();

    /* renamed from: e  reason: collision with root package name */
    private static final a.g<zzay> f18100e;

    /* renamed from: f  reason: collision with root package name */
    private static final a.C0118a<zzay, a.d.C0120d> f18101f;

    public static abstract class a<R extends g> extends d.a<R, zzay> {
        public a(com.google.android.gms.common.api.d dVar) {
            super((com.google.android.gms.common.api.a<?>) h.f18096a, dVar);
        }

        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((g) obj);
        }
    }

    static {
        a.g<zzay> gVar = new a.g<>();
        f18100e = gVar;
        y yVar = new y();
        f18101f = yVar;
        f18096a = new com.google.android.gms.common.api.a<>("LocationServices.API", yVar, gVar);
    }

    public static zzay a(com.google.android.gms.common.api.d dVar) {
        boolean z2 = true;
        m.a(dVar != null, (Object) "GoogleApiClient parameter is required.");
        zzay zzay = (zzay) dVar.a(f18100e);
        if (zzay == null) {
            z2 = false;
        }
        m.b(z2, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzay;
    }
}
