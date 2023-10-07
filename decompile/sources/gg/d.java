package gg;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.base.zad;
import com.google.android.gms.tasks.b;

public final class d extends c<q> implements p {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f28499b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final a.g<e> f28500c;

    /* renamed from: d  reason: collision with root package name */
    private static final a.C0118a<e, q> f28501d;

    /* renamed from: e  reason: collision with root package name */
    private static final a<q> f28502e;

    static {
        a.g<e> gVar = new a.g<>();
        f28500c = gVar;
        c cVar = new c();
        f28501d = cVar;
        f28502e = new a<>("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, q qVar) {
        super(context, f28502e, qVar, c.a.f17391a);
    }

    public final b<Void> a(TelemetryData telemetryData) {
        s.a a2 = s.a();
        a2.a(zad.zaa);
        a2.a(false);
        a2.a(new b(telemetryData));
        return a(a2.a());
    }
}
