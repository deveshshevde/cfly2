package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.location.i;

final class zzba extends zzam {
    private d.b<Status> zza;

    public zzba(d.b<Status> bVar) {
        this.zza = bVar;
    }

    private final void zza(int i2) {
        if (this.zza == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times", new Exception());
            return;
        }
        this.zza.setResult(i.b(i.a(i2)));
        this.zza = null;
    }

    public final void zza(int i2, PendingIntent pendingIntent) {
        zza(i2);
    }

    public final void zza(int i2, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult", new Exception());
    }

    public final void zzb(int i2, String[] strArr) {
        zza(i2);
    }
}
