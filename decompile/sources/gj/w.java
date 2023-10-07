package gj;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public final class w extends zza implements a {
    w(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    }

    public final b a(CameraPosition cameraPosition) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) cameraPosition);
        Parcel zza2 = zza(7, zza);
        b a2 = b.a.a(zza2.readStrongBinder());
        zza2.recycle();
        return a2;
    }

    public final b a(LatLng latLng, float f2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) latLng);
        zza.writeFloat(f2);
        Parcel zza2 = zza(9, zza);
        b a2 = b.a.a(zza2.readStrongBinder());
        zza2.recycle();
        return a2;
    }

    public final b a(LatLngBounds latLngBounds, int i2, int i3, int i4) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) latLngBounds);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zza.writeInt(i4);
        Parcel zza2 = zza(11, zza);
        b a2 = b.a.a(zza2.readStrongBinder());
        zza2.recycle();
        return a2;
    }
}
