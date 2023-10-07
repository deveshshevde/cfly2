package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.l;
import com.google.android.gms.location.o;

public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzo();
    private int zza;
    private zzj zzb;
    private l zzc;
    private zzai zzd;

    zzl(int i2, zzj zzj, IBinder iBinder, IBinder iBinder2) {
        this.zza = i2;
        this.zzb = zzj;
        zzai zzai = null;
        this.zzc = iBinder == null ? null : o.zza(iBinder);
        if (!(iBinder2 == null || iBinder2 == null)) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzai = queryLocalInterface instanceof zzai ? (zzai) queryLocalInterface : new zzak(iBinder2);
        }
        this.zzd = zzai;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.zza);
        a.a(parcel, 2, (Parcelable) this.zzb, i2, false);
        l lVar = this.zzc;
        IBinder iBinder = null;
        a.a(parcel, 3, lVar == null ? null : lVar.asBinder(), false);
        zzai zzai = this.zzd;
        if (zzai != null) {
            iBinder = zzai.asBinder();
        }
        a.a(parcel, 4, iBinder, false);
        a.a(parcel, a2);
    }
}
