package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.f;
import com.google.android.gms.location.g;
import com.google.android.gms.location.q;
import com.google.android.gms.location.r;
import java.util.HashMap;
import java.util.Map;

public final class zzap {
    private final zzbi<zzal> zza;
    private final Context zzb;
    private boolean zzc = false;
    private final Map<j.a<g>, zzaw> zzd = new HashMap();
    private final Map<j.a<Object>, zzat> zze = new HashMap();
    private final Map<j.a<f>, zzas> zzf = new HashMap();

    public zzap(Context context, zzbi<zzal> zzbi) {
        this.zzb = context;
        this.zza = zzbi;
    }

    private final zzaw zza(j<g> jVar) {
        zzaw zzaw;
        j.a<g> a2 = jVar.a();
        if (a2 == null) {
            return null;
        }
        synchronized (this.zzd) {
            zzaw = this.zzd.get(a2);
            if (zzaw == null) {
                zzaw = new zzaw(jVar);
            }
            this.zzd.put(a2, zzaw);
        }
        return zzaw;
    }

    private final zzas zzb(j<f> jVar) {
        zzas zzas;
        j.a<f> a2 = jVar.a();
        if (a2 == null) {
            return null;
        }
        synchronized (this.zzf) {
            zzas = this.zzf.get(a2);
            if (zzas == null) {
                zzas = new zzas(jVar);
            }
            this.zzf.put(a2, zzas);
        }
        return zzas;
    }

    @Deprecated
    public final Location zza() throws RemoteException {
        this.zza.zza();
        return this.zza.zzb().zza();
    }

    public final Location zza(String str) throws RemoteException {
        this.zza.zza();
        return this.zza.zzb().zza(str);
    }

    public final void zza(PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(new zzbe(2, (zzbc) null, (IBinder) null, pendingIntent, (IBinder) null, zzai != null ? zzai.asBinder() : null));
    }

    public final void zza(Location location) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(location);
    }

    public final void zza(j.a<g> aVar, zzai zzai) throws RemoteException {
        this.zza.zza();
        m.a(aVar, (Object) "Invalid null listener key");
        synchronized (this.zzd) {
            zzaw remove = this.zzd.remove(aVar);
            if (remove != null) {
                remove.zza();
                this.zza.zzb().zza(zzbe.zza((r) remove, zzai));
            }
        }
    }

    public final void zza(zzai zzai) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(zzai);
    }

    public final void zza(zzbc zzbc, PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(zzbe.zza(zzbc, pendingIntent, zzai));
    }

    public final void zza(zzbc zzbc, j<f> jVar, zzai zzai) throws RemoteException {
        this.zza.zza();
        zzas zzb2 = zzb(jVar);
        if (zzb2 != null) {
            this.zza.zzb().zza(new zzbe(1, zzbc, (IBinder) null, (PendingIntent) null, zzb2.asBinder(), zzai != null ? zzai.asBinder() : null));
        }
    }

    public final void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(zzbe.zza(zzbc.zza((String) null, locationRequest), pendingIntent, zzai));
    }

    public final void zza(LocationRequest locationRequest, j<g> jVar, zzai zzai) throws RemoteException {
        this.zza.zza();
        zzaw zza2 = zza(jVar);
        if (zza2 != null) {
            zzal zzb2 = this.zza.zzb();
            IBinder iBinder = null;
            zzbc zza3 = zzbc.zza((String) null, locationRequest);
            IBinder asBinder = zza2.asBinder();
            if (zzai != null) {
                iBinder = zzai.asBinder();
            }
            zzb2.zza(new zzbe(1, zza3, asBinder, (PendingIntent) null, (IBinder) null, iBinder));
        }
    }

    public final void zza(boolean z2) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(z2);
        this.zzc = z2;
    }

    public final LocationAvailability zzb() throws RemoteException {
        this.zza.zza();
        return this.zza.zzb().zzb(this.zzb.getPackageName());
    }

    public final void zzb(j.a<f> aVar, zzai zzai) throws RemoteException {
        this.zza.zza();
        m.a(aVar, (Object) "Invalid null listener key");
        synchronized (this.zzf) {
            zzas remove = this.zzf.remove(aVar);
            if (remove != null) {
                remove.zza();
                this.zza.zzb().zza(zzbe.zza((q) remove, zzai));
            }
        }
    }

    public final void zzc() throws RemoteException {
        synchronized (this.zzd) {
            for (zzaw next : this.zzd.values()) {
                if (next != null) {
                    this.zza.zzb().zza(zzbe.zza((r) next, (zzai) null));
                }
            }
            this.zzd.clear();
        }
        synchronized (this.zzf) {
            for (zzas next2 : this.zzf.values()) {
                if (next2 != null) {
                    this.zza.zzb().zza(zzbe.zza((q) next2, (zzai) null));
                }
            }
            this.zzf.clear();
        }
        synchronized (this.zze) {
            for (zzat next3 : this.zze.values()) {
                if (next3 != null) {
                    this.zza.zzb().zza(new zzl(2, (zzj) null, next3.asBinder(), (IBinder) null));
                }
            }
            this.zze.clear();
        }
    }

    public final void zzd() throws RemoteException {
        if (this.zzc) {
            zza(false);
        }
    }
}
