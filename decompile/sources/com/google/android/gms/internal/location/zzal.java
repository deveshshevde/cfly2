package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzbe;

public interface zzal extends IInterface {
    @Deprecated
    Location zza() throws RemoteException;

    Location zza(String str) throws RemoteException;

    void zza(long j2, boolean z2, PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent, g gVar) throws RemoteException;

    void zza(PendingIntent pendingIntent, zzaj zzaj, String str) throws RemoteException;

    void zza(Location location) throws RemoteException;

    void zza(zzai zzai) throws RemoteException;

    void zza(zzbe zzbe) throws RemoteException;

    void zza(zzl zzl) throws RemoteException;

    void zza(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, g gVar) throws RemoteException;

    void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzaj zzaj) throws RemoteException;

    void zza(LocationSettingsRequest locationSettingsRequest, zzan zzan, String str) throws RemoteException;

    void zza(zzbe zzbe, zzaj zzaj) throws RemoteException;

    void zza(boolean z2) throws RemoteException;

    void zza(String[] strArr, zzaj zzaj, String str) throws RemoteException;

    LocationAvailability zzb(String str) throws RemoteException;
}
