package gj;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzaa;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzh;
import com.google.android.gms.internal.maps.zzi;
import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.internal.maps.zzu;
import com.google.android.gms.internal.maps.zzw;
import com.google.android.gms.internal.maps.zzx;
import com.google.android.gms.internal.maps.zzz;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

public final class ai extends zza implements b {
    ai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    public final zzac a(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) tileOverlayOptions);
        Parcel zza2 = zza(13, zza);
        zzac zzj = zzad.zzj(zza2.readStrongBinder());
        zza2.recycle();
        return zzj;
    }

    public final zzh a(CircleOptions circleOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) circleOptions);
        Parcel zza2 = zza(35, zza);
        zzh zzc = zzi.zzc(zza2.readStrongBinder());
        zza2.recycle();
        return zzc;
    }

    public final zzt a(MarkerOptions markerOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) markerOptions);
        Parcel zza2 = zza(11, zza);
        zzt zzg = zzu.zzg(zza2.readStrongBinder());
        zza2.recycle();
        return zzg;
    }

    public final zzw a(PolygonOptions polygonOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) polygonOptions);
        Parcel zza2 = zza(10, zza);
        zzw zzh = zzx.zzh(zza2.readStrongBinder());
        zza2.recycle();
        return zzh;
    }

    public final zzz a(PolylineOptions polylineOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) polylineOptions);
        Parcel zza2 = zza(9, zza);
        zzz zzi = zzaa.zzi(zza2.readStrongBinder());
        zza2.recycle();
        return zzi;
    }

    public final CameraPosition a() throws RemoteException {
        Parcel zza = zza(1, zza());
        CameraPosition cameraPosition = (CameraPosition) zzc.zza(zza, CameraPosition.CREATOR);
        zza.recycle();
        return cameraPosition;
    }

    public final void a(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzb(16, zza);
    }

    public final void a(int i2, int i3, int i4, int i5) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zza.writeInt(i3);
        zza.writeInt(i4);
        zza.writeInt(i5);
        zzb(39, zza);
    }

    public final void a(b bVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) bVar);
        zzb(4, zza);
    }

    public final void a(m mVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) mVar);
        zzb(28, zza);
    }

    public final void a(o oVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) oVar);
        zzb(29, zza);
    }

    public final void a(s sVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) sVar);
        zzb(30, zza);
    }

    public final void a(u uVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) uVar);
        zzb(31, zza);
    }

    public final void a(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(41, zza);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final gj.i b() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 25
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.maps.internal.IUiSettingsDelegate"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof gj.i
            if (r3 == 0) goto L_0x0020
            r1 = r2
            gj.i r1 = (gj.i) r1
            goto L_0x0026
        L_0x0020:
            gj.ad r2 = new gj.ad
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: gj.ai.b():gj.i");
    }

    public final void b(b bVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) bVar);
        zzb(5, zza);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final gj.e c() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 26
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.maps.internal.IProjectionDelegate"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof gj.e
            if (r3 == 0) goto L_0x0020
            r1 = r2
            gj.e r1 = (gj.e) r1
            goto L_0x0026
        L_0x0020:
            gj.z r2 = new gj.z
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: gj.ai.c():gj.e");
    }
}
