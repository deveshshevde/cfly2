package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public abstract class zzag extends zzb implements zzaf {
    public zzag() {
        super("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    public static zzaf zzk(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        return queryLocalInterface instanceof zzaf ? (zzaf) queryLocalInterface : new zzah(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        Tile tile = getTile(parcel.readInt(), parcel.readInt(), parcel.readInt());
        parcel2.writeNoException();
        zzc.zzb(parcel2, tile);
        return true;
    }
}