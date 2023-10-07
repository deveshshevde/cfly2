package gg;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.base.zad;

public final class e extends f<a> {

    /* renamed from: a  reason: collision with root package name */
    private final q f28503a;

    public e(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, q qVar, com.google.android.gms.common.api.internal.e eVar2, m mVar) {
        super(context, looper, (int) SubsamplingScaleImageView.ORIENTATION_270, eVar, eVar2, mVar);
        this.f28503a = qVar;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return queryLocalInterface instanceof a ? (a) queryLocalInterface : new a(iBinder);
    }

    public final Feature[] getApiFeatures() {
        return zad.zab;
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.f28503a.b();
    }

    public final int getMinApkVersion() {
        return 203400000;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    /* access modifiers changed from: protected */
    public final boolean getUseDynamicLookup() {
        return true;
    }
}
