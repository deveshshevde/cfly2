package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.util.a;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.ao;
import com.google.android.gms.location.f;
import com.google.android.gms.location.zzbe;
import java.util.List;

public final class zzay extends zzh {
    private final zzap zze;

    public zzay(Context context, Looper looper, d.b bVar, d.c cVar, String str) {
        this(context, looper, bVar, cVar, str, e.a(context));
    }

    public zzay(Context context, Looper looper, d.b bVar, d.c cVar, String str, e eVar) {
        super(context, looper, bVar, cVar, str, eVar);
        this.zze = new zzap(context, this.zzd);
    }

    public final void disconnect() {
        synchronized (this.zze) {
            if (isConnected()) {
                try {
                    this.zze.zzc();
                    this.zze.zzd();
                } catch (Exception e2) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e2);
                }
            }
            super.disconnect();
        }
    }

    public final Location zza(String str) throws RemoteException {
        return a.a((T[]) getAvailableFeatures(), ao.f18091a) ? this.zze.zza(str) : this.zze.zza();
    }

    public final LocationAvailability zza() throws RemoteException {
        return this.zze.zzb();
    }

    public final void zza(long j2, PendingIntent pendingIntent) throws RemoteException {
        checkConnected();
        m.a(pendingIntent);
        m.a(j2 >= 0, (Object) "detectionIntervalMillis must be >= 0");
        ((zzal) getService()).zza(j2, true, pendingIntent);
    }

    public final void zza(PendingIntent pendingIntent) throws RemoteException {
        checkConnected();
        m.a(pendingIntent);
        ((zzal) getService()).zza(pendingIntent);
    }

    public final void zza(PendingIntent pendingIntent, d.b<Status> bVar) throws RemoteException {
        checkConnected();
        m.a(bVar, (Object) "ResultHolder not provided.");
        ((zzal) getService()).zza(pendingIntent, (g) new q(bVar));
    }

    public final void zza(PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zze.zza(pendingIntent, zzai);
    }

    public final void zza(Location location) throws RemoteException {
        this.zze.zza(location);
    }

    public final void zza(j.a<com.google.android.gms.location.g> aVar, zzai zzai) throws RemoteException {
        this.zze.zza(aVar, zzai);
    }

    public final void zza(zzai zzai) throws RemoteException {
        this.zze.zza(zzai);
    }

    public final void zza(zzbc zzbc, PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zze.zza(zzbc, pendingIntent, zzai);
    }

    public final void zza(zzbc zzbc, j<f> jVar, zzai zzai) throws RemoteException {
        synchronized (this.zze) {
            this.zze.zza(zzbc, jVar, zzai);
        }
    }

    public final void zza(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, d.b<Status> bVar) throws RemoteException {
        checkConnected();
        m.a(bVar, (Object) "ResultHolder not provided.");
        ((zzal) getService()).zza(activityTransitionRequest, pendingIntent, (g) new q(bVar));
    }

    public final void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, d.b<Status> bVar) throws RemoteException {
        checkConnected();
        m.a(geofencingRequest, (Object) "geofencingRequest can't be null.");
        m.a(pendingIntent, (Object) "PendingIntent must be specified.");
        m.a(bVar, (Object) "ResultHolder not provided.");
        ((zzal) getService()).zza(geofencingRequest, pendingIntent, (zzaj) new zzax(bVar));
    }

    public final void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zze.zza(locationRequest, pendingIntent, zzai);
    }

    public final void zza(LocationRequest locationRequest, j<com.google.android.gms.location.g> jVar, zzai zzai) throws RemoteException {
        synchronized (this.zze) {
            this.zze.zza(locationRequest, jVar, zzai);
        }
    }

    public final void zza(LocationSettingsRequest locationSettingsRequest, d.b<LocationSettingsResult> bVar, String str) throws RemoteException {
        checkConnected();
        boolean z2 = true;
        m.a(locationSettingsRequest != null, (Object) "locationSettingsRequest can't be null nor empty.");
        if (bVar == null) {
            z2 = false;
        }
        m.a(z2, (Object) "listener can't be null.");
        ((zzal) getService()).zza(locationSettingsRequest, (zzan) new zzaz(bVar), str);
    }

    public final void zza(zzbe zzbe, d.b<Status> bVar) throws RemoteException {
        checkConnected();
        m.a(zzbe, (Object) "removeGeofencingRequest can't be null.");
        m.a(bVar, (Object) "ResultHolder not provided.");
        ((zzal) getService()).zza(zzbe, (zzaj) new zzba(bVar));
    }

    public final void zza(List<String> list, d.b<Status> bVar) throws RemoteException {
        checkConnected();
        m.a(list != null && list.size() > 0, (Object) "geofenceRequestIds can't be null nor empty.");
        m.a(bVar, (Object) "ResultHolder not provided.");
        ((zzal) getService()).zza((String[]) list.toArray(new String[0]), (zzaj) new zzba(bVar), getContext().getPackageName());
    }

    public final void zza(boolean z2) throws RemoteException {
        this.zze.zza(z2);
    }

    public final void zzb(PendingIntent pendingIntent, d.b<Status> bVar) throws RemoteException {
        checkConnected();
        m.a(pendingIntent, (Object) "PendingIntent must be specified.");
        m.a(bVar, (Object) "ResultHolder not provided.");
        ((zzal) getService()).zza(pendingIntent, (zzaj) new zzba(bVar), getContext().getPackageName());
    }

    public final void zzb(j.a<f> aVar, zzai zzai) throws RemoteException {
        this.zze.zzb(aVar, zzai);
    }
}
