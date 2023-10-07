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
import com.google.android.gms.maps.GoogleMapOptions;

public final class aj extends zza implements c {
    aj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IMapFragmentDelegate");
    }

    public final b a(b bVar, b bVar2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) bVar);
        zzc.zza(zza, (IInterface) bVar2);
        zzc.zza(zza, (Parcelable) bundle);
        Parcel zza2 = zza(4, zza);
        b a2 = b.a.a(zza2.readStrongBinder());
        zza2.recycle();
        return a2;
    }

    public final void a() throws RemoteException {
        zzb(5, zza());
    }

    public final void a(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) bundle);
        zzb(3, zza);
    }

    public final void a(b bVar, GoogleMapOptions googleMapOptions, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) bVar);
        zzc.zza(zza, (Parcelable) googleMapOptions);
        zzc.zza(zza, (Parcelable) bundle);
        zzb(2, zza);
    }

    public final void a(q qVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) qVar);
        zzb(12, zza);
    }

    public final void b() throws RemoteException {
        zzb(6, zza());
    }

    public final void b(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) bundle);
        Parcel zza2 = zza(10, zza);
        if (zza2.readInt() != 0) {
            bundle.readFromParcel(zza2);
        }
        zza2.recycle();
    }

    public final void c() throws RemoteException {
        zzb(7, zza());
    }

    public final void d() throws RemoteException {
        zzb(8, zza());
    }

    public final void e() throws RemoteException {
        zzb(9, zza());
    }

    public final void f() throws RemoteException {
        zzb(15, zza());
    }

    public final void g() throws RemoteException {
        zzb(16, zza());
    }
}
