package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public final class zzah extends zza implements zzaf {
    zzah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    public final Tile getTile(int i2, int i3, int i4) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zza.writeInt(i3);
        zza.writeInt(i4);
        Parcel zza2 = zza(1, zza);
        Tile tile = (Tile) zzc.zza(zza2, Tile.CREATOR);
        zza2.recycle();
        return tile;
    }
}
