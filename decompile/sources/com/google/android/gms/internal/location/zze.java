package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.b;

public final class zze implements b {
    public final e<Status> removeActivityUpdates(d dVar, PendingIntent pendingIntent) {
        return dVar.b(new zzf(this, dVar, pendingIntent));
    }

    public final e<Status> requestActivityUpdates(d dVar, long j2, PendingIntent pendingIntent) {
        return dVar.b(new zzg(this, dVar, j2, pendingIntent));
    }
}
