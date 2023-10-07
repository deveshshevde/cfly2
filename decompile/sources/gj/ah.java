package gj;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zze;
import com.google.android.gms.internal.maps.zzf;

public final class ah extends zza implements ag {
    ah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final gj.a a() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 4
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof gj.a
            if (r3 == 0) goto L_0x001f
            r1 = r2
            gj.a r1 = (gj.a) r1
            goto L_0x0025
        L_0x001f:
            gj.w r2 = new gj.w
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: gj.ah.a():gj.a");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final gj.c a(com.google.android.gms.dynamic.b r4) throws android.os.RemoteException {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.zza()
            com.google.android.gms.internal.maps.zzc.zza((android.os.Parcel) r0, (android.os.IInterface) r4)
            r4 = 2
            android.os.Parcel r4 = r3.zza(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.maps.internal.IMapFragmentDelegate"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof gj.c
            if (r2 == 0) goto L_0x0022
            r0 = r1
            gj.c r0 = (gj.c) r0
            goto L_0x0028
        L_0x0022:
            gj.aj r1 = new gj.aj
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: gj.ah.a(com.google.android.gms.dynamic.b):gj.c");
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final gj.d a(com.google.android.gms.dynamic.b r3, com.google.android.gms.maps.GoogleMapOptions r4) throws android.os.RemoteException {
        /*
            r2 = this;
            android.os.Parcel r0 = r2.zza()
            com.google.android.gms.internal.maps.zzc.zza((android.os.Parcel) r0, (android.os.IInterface) r3)
            com.google.android.gms.internal.maps.zzc.zza((android.os.Parcel) r0, (android.os.Parcelable) r4)
            r3 = 3
            android.os.Parcel r3 = r2.zza(r3, r0)
            android.os.IBinder r4 = r3.readStrongBinder()
            if (r4 != 0) goto L_0x0017
            r4 = 0
            goto L_0x002b
        L_0x0017:
            java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)
            boolean r1 = r0 instanceof gj.d
            if (r1 == 0) goto L_0x0025
            r4 = r0
            gj.d r4 = (gj.d) r4
            goto L_0x002b
        L_0x0025:
            gj.ak r0 = new gj.ak
            r0.<init>(r4)
            r4 = r0
        L_0x002b:
            r3.recycle()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: gj.ah.a(com.google.android.gms.dynamic.b, com.google.android.gms.maps.GoogleMapOptions):gj.d");
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final gj.h a(com.google.android.gms.dynamic.b r3, com.google.android.gms.maps.StreetViewPanoramaOptions r4) throws android.os.RemoteException {
        /*
            r2 = this;
            android.os.Parcel r0 = r2.zza()
            com.google.android.gms.internal.maps.zzc.zza((android.os.Parcel) r0, (android.os.IInterface) r3)
            com.google.android.gms.internal.maps.zzc.zza((android.os.Parcel) r0, (android.os.Parcelable) r4)
            r3 = 7
            android.os.Parcel r3 = r2.zza(r3, r0)
            android.os.IBinder r4 = r3.readStrongBinder()
            if (r4 != 0) goto L_0x0017
            r4 = 0
            goto L_0x002b
        L_0x0017:
            java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)
            boolean r1 = r0 instanceof gj.h
            if (r1 == 0) goto L_0x0025
            r4 = r0
            gj.h r4 = (gj.h) r4
            goto L_0x002b
        L_0x0025:
            gj.ac r0 = new gj.ac
            r0.<init>(r4)
            r4 = r0
        L_0x002b:
            r3.recycle()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: gj.ah.a(com.google.android.gms.dynamic.b, com.google.android.gms.maps.StreetViewPanoramaOptions):gj.h");
    }

    public final void a(b bVar, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) bVar);
        zza.writeInt(i2);
        zzb(6, zza);
    }

    public final zze b() throws RemoteException {
        Parcel zza = zza(5, zza());
        zze zzb = zzf.zzb(zza.readStrongBinder());
        zza.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final gj.g b(com.google.android.gms.dynamic.b r4) throws android.os.RemoteException {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.zza()
            com.google.android.gms.internal.maps.zzc.zza((android.os.Parcel) r0, (android.os.IInterface) r4)
            r4 = 8
            android.os.Parcel r4 = r3.zza(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0015
            r0 = 0
            goto L_0x0029
        L_0x0015:
            java.lang.String r1 = "com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof gj.g
            if (r2 == 0) goto L_0x0023
            r0 = r1
            gj.g r0 = (gj.g) r0
            goto L_0x0029
        L_0x0023:
            gj.ab r1 = new gj.ab
            r1.<init>(r0)
            r0 = r1
        L_0x0029:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: gj.ah.b(com.google.android.gms.dynamic.b):gj.g");
    }
}
