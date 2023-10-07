package gj;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;

public final class ac extends zza implements h {
    ac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
    }

    public final void a() throws RemoteException {
        zzb(3, zza());
    }

    public final void a(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) bundle);
        zzb(2, zza);
    }

    public final void a(x xVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) xVar);
        zzb(9, zza);
    }

    public final void b() throws RemoteException {
        zzb(4, zza());
    }

    public final void b(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) bundle);
        Parcel zza2 = zza(7, zza);
        if (zza2.readInt() != 0) {
            bundle.readFromParcel(zza2);
        }
        zza2.recycle();
    }

    public final void c() throws RemoteException {
        zzb(5, zza());
    }

    public final void d() throws RemoteException {
        zzb(6, zza());
    }

    public final b e() throws RemoteException {
        Parcel zza = zza(8, zza());
        b a2 = b.a.a(zza.readStrongBinder());
        zza.recycle();
        return a2;
    }

    public final void f() throws RemoteException {
        zzb(10, zza());
    }

    public final void g() throws RemoteException {
        zzb(11, zza());
    }
}
