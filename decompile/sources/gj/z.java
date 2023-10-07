package gj;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.LatLng;

public final class z extends zza implements e {
    z(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IProjectionDelegate");
    }

    public final LatLng a(b bVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) bVar);
        Parcel zza2 = zza(1, zza);
        LatLng latLng = (LatLng) zzc.zza(zza2, LatLng.CREATOR);
        zza2.recycle();
        return latLng;
    }
}
