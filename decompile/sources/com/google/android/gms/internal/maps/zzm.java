package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public final class zzm extends zza implements zzk {
    zzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
    }

    public final float getBearing() throws RemoteException {
        Parcel zza = zza(12, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final LatLngBounds getBounds() throws RemoteException {
        Parcel zza = zza(10, zza());
        LatLngBounds latLngBounds = (LatLngBounds) zzc.zza(zza, LatLngBounds.CREATOR);
        zza.recycle();
        return latLngBounds;
    }

    public final float getHeight() throws RemoteException {
        Parcel zza = zza(8, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final String getId() throws RemoteException {
        Parcel zza = zza(2, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final LatLng getPosition() throws RemoteException {
        Parcel zza = zza(4, zza());
        LatLng latLng = (LatLng) zzc.zza(zza, LatLng.CREATOR);
        zza.recycle();
        return latLng;
    }

    public final float getTransparency() throws RemoteException {
        Parcel zza = zza(18, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getWidth() throws RemoteException {
        Parcel zza = zza(7, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getZIndex() throws RemoteException {
        Parcel zza = zza(14, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final boolean isClickable() throws RemoteException {
        Parcel zza = zza(23, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isVisible() throws RemoteException {
        Parcel zza = zza(16, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void remove() throws RemoteException {
        zzb(1, zza());
    }

    public final void setBearing(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(11, zza);
    }

    public final void setClickable(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(22, zza);
    }

    public final void setDimensions(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(5, zza);
    }

    public final void setPosition(LatLng latLng) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) latLng);
        zzb(3, zza);
    }

    public final void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) latLngBounds);
        zzb(9, zza);
    }

    public final void setTransparency(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(17, zza);
    }

    public final void setVisible(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(15, zza);
    }

    public final void setZIndex(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(13, zza);
    }

    public final void zza(float f2, float f3) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zza.writeFloat(f3);
        zzb(6, zza);
    }

    public final boolean zzb(zzk zzk) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzk);
        Parcel zza2 = zza(19, zza);
        boolean zza3 = zzc.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    public final void zze(b bVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) bVar);
        zzb(24, zza);
    }

    public final void zzf(b bVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) bVar);
        zzb(21, zza);
    }

    public final int zzj() throws RemoteException {
        Parcel zza = zza(20, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final b zzk() throws RemoteException {
        Parcel zza = zza(25, zza());
        b a2 = b.a.a(zza.readStrongBinder());
        zza.recycle();
        return a2;
    }
}
