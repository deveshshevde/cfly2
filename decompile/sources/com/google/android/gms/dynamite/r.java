package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class r extends zza implements IInterface {
    r(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final b a(b bVar, String str, int i2, b bVar2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeString(str);
        zza.writeInt(i2);
        zzc.zze(zza, bVar2);
        Parcel zzB = zzB(2, zza);
        b a2 = b.a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a2;
    }

    public final b b(b bVar, String str, int i2, b bVar2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeString(str);
        zza.writeInt(i2);
        zzc.zze(zza, bVar2);
        Parcel zzB = zzB(3, zza);
        b a2 = b.a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a2;
    }
}
