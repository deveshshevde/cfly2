package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class q extends zza implements IInterface {
    q(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int a() throws RemoteException {
        Parcel zzB = zzB(6, zza());
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final int a(b bVar, String str, boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeString(str);
        zzc.zzb(zza, z2);
        Parcel zzB = zzB(3, zza);
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final b a(b bVar, String str, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeString(str);
        zza.writeInt(i2);
        Parcel zzB = zzB(2, zza);
        b a2 = b.a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a2;
    }

    public final b a(b bVar, String str, int i2, b bVar2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeString(str);
        zza.writeInt(i2);
        zzc.zze(zza, bVar2);
        Parcel zzB = zzB(8, zza);
        b a2 = b.a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a2;
    }

    public final b a(b bVar, String str, boolean z2, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeString(str);
        zzc.zzb(zza, z2);
        zza.writeLong(j2);
        Parcel zzB = zzB(7, zza);
        b a2 = b.a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a2;
    }

    public final int b(b bVar, String str, boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeString(str);
        zzc.zzb(zza, z2);
        Parcel zzB = zzB(5, zza);
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final b b(b bVar, String str, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeString(str);
        zza.writeInt(i2);
        Parcel zzB = zzB(4, zza);
        b a2 = b.a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a2;
    }
}
