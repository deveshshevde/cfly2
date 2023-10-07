package gg;

import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.tasks.c;

public final /* synthetic */ class b implements o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TelemetryData f28498a;

    public /* synthetic */ b(TelemetryData telemetryData) {
        this.f28498a = telemetryData;
    }

    public final void a(Object obj, Object obj2) {
        TelemetryData telemetryData = this.f28498a;
        int i2 = d.f28499b;
        ((a) ((e) obj).getService()).a(telemetryData);
        ((c) obj2).a(null);
    }
}
