package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.p;
import com.google.android.gms.location.q;
import com.google.android.gms.location.r;
import com.google.android.gms.location.u;

public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbd();
    private int zza;
    private zzbc zzb;
    private r zzc;
    private PendingIntent zzd;
    private q zze;
    private zzai zzf;

    zzbe(int i2, zzbc zzbc, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.zza = i2;
        this.zzb = zzbc;
        zzai zzai = null;
        this.zzc = iBinder == null ? null : u.zza(iBinder);
        this.zzd = pendingIntent;
        this.zze = iBinder2 == null ? null : p.zza(iBinder2);
        if (!(iBinder3 == null || iBinder3 == null)) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzai = queryLocalInterface instanceof zzai ? (zzai) queryLocalInterface : new zzak(iBinder3);
        }
        this.zzf = zzai;
    }

    public static zzbe zza(zzbc zzbc, PendingIntent pendingIntent, zzai zzai) {
        return new zzbe(1, zzbc, (IBinder) null, pendingIntent, (IBinder) null, zzai != null ? zzai.asBinder() : null);
    }

    public static zzbe zza(q qVar, zzai zzai) {
        return new zzbe(2, (zzbc) null, (IBinder) null, (PendingIntent) null, qVar.asBinder(), zzai != null ? zzai.asBinder() : null);
    }

    public static zzbe zza(r rVar, zzai zzai) {
        return new zzbe(2, (zzbc) null, rVar.asBinder(), (PendingIntent) null, (IBinder) null, zzai != null ? zzai.asBinder() : null);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.zza);
        a.a(parcel, 2, (Parcelable) this.zzb, i2, false);
        r rVar = this.zzc;
        IBinder iBinder = null;
        a.a(parcel, 3, rVar == null ? null : rVar.asBinder(), false);
        a.a(parcel, 4, (Parcelable) this.zzd, i2, false);
        q qVar = this.zze;
        a.a(parcel, 5, qVar == null ? null : qVar.asBinder(), false);
        zzai zzai = this.zzf;
        if (zzai != null) {
            iBinder = zzai.asBinder();
        }
        a.a(parcel, 6, iBinder, false);
        a.a(parcel, a2);
    }
}
