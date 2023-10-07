package gg;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class a extends zaa implements IInterface {
    a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void a(TelemetryData telemetryData) throws RemoteException {
        Parcel zaa = zaa();
        zac.zac(zaa, telemetryData);
        zad(1, zaa);
    }
}
