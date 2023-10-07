package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.common.zza;

public final class bn extends zza implements bp {
    bn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final int a() throws RemoteException {
        Parcel zzB = zzB(2, zza());
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final b b() throws RemoteException {
        Parcel zzB = zzB(1, zza());
        b a2 = b.a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a2;
    }
}
