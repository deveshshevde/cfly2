package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.e;
import com.google.android.gms.location.zzbe;
import java.util.List;

public final class zzae implements e {
    private final com.google.android.gms.common.api.e<Status> zza(d dVar, zzbe zzbe) {
        return dVar.b(new zzag(this, dVar, zzbe));
    }

    public final com.google.android.gms.common.api.e<Status> addGeofences(d dVar, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return dVar.b(new zzad(this, dVar, geofencingRequest, pendingIntent));
    }

    @Deprecated
    public final com.google.android.gms.common.api.e<Status> addGeofences(d dVar, List<com.google.android.gms.location.d> list, PendingIntent pendingIntent) {
        GeofencingRequest.a aVar = new GeofencingRequest.a();
        aVar.a(list);
        aVar.a(5);
        return addGeofences(dVar, aVar.a(), pendingIntent);
    }

    public final com.google.android.gms.common.api.e<Status> removeGeofences(d dVar, PendingIntent pendingIntent) {
        return zza(dVar, zzbe.a(pendingIntent));
    }

    public final com.google.android.gms.common.api.e<Status> removeGeofences(d dVar, List<String> list) {
        return zza(dVar, zzbe.a(list));
    }
}
