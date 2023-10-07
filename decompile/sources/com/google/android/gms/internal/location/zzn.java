package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.c;
import com.google.android.gms.location.f;
import com.google.android.gms.location.g;
import com.google.android.gms.location.h;

public final class zzn implements c {
    public final e<Status> flushLocations(d dVar) {
        return dVar.b(new zzu(this, dVar));
    }

    public final Location getLastLocation(d dVar) {
        try {
            return h.a(dVar).zza((String) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public final LocationAvailability getLocationAvailability(d dVar) {
        try {
            return h.a(dVar).zza();
        } catch (Exception unused) {
            return null;
        }
    }

    public final e<Status> removeLocationUpdates(d dVar, PendingIntent pendingIntent) {
        return dVar.b(new zzx(this, dVar, pendingIntent));
    }

    public final e<Status> removeLocationUpdates(d dVar, f fVar) {
        return dVar.b(new zzp(this, dVar, fVar));
    }

    public final e<Status> removeLocationUpdates(d dVar, g gVar) {
        return dVar.b(new zzy(this, dVar, gVar));
    }

    public final e<Status> requestLocationUpdates(d dVar, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return dVar.b(new zzv(this, dVar, locationRequest, pendingIntent));
    }

    public final e<Status> requestLocationUpdates(d dVar, LocationRequest locationRequest, f fVar, Looper looper) {
        return dVar.b(new zzw(this, dVar, locationRequest, fVar, looper));
    }

    public final e<Status> requestLocationUpdates(d dVar, LocationRequest locationRequest, g gVar) {
        m.a(Looper.myLooper(), (Object) "Calling thread must be a prepared Looper thread.");
        return dVar.b(new zzq(this, dVar, locationRequest, gVar));
    }

    public final e<Status> requestLocationUpdates(d dVar, LocationRequest locationRequest, g gVar, Looper looper) {
        return dVar.b(new zzt(this, dVar, locationRequest, gVar, looper));
    }

    public final e<Status> setMockLocation(d dVar, Location location) {
        return dVar.b(new zzr(this, dVar, location));
    }

    public final e<Status> setMockMode(d dVar, boolean z2) {
        return dVar.b(new zzs(this, dVar, z2));
    }
}
