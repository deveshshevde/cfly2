package gj;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;

public final class ad extends zza implements i {
    ad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    public final void a(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(1, zza);
    }

    public final void b(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(2, zza);
    }

    public final void c(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(3, zza);
    }

    public final void d(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(5, zza);
    }

    public final void e(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(6, zza);
    }

    public final void f(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(7, zza);
    }

    public final void g(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(18, zza);
    }
}
