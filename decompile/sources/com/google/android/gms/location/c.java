package com.google.android.gms.location;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;

@Deprecated
public interface c {
    Location getLastLocation(d dVar);

    e<Status> removeLocationUpdates(d dVar, f fVar);

    e<Status> removeLocationUpdates(d dVar, g gVar);

    e<Status> requestLocationUpdates(d dVar, LocationRequest locationRequest, f fVar, Looper looper);

    e<Status> requestLocationUpdates(d dVar, LocationRequest locationRequest, g gVar);
}
