package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

public final class zzj extends zza implements zzh {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ICircleDelegate");
    }

    public final LatLng getCenter() throws RemoteException {
        Parcel zza = zza(4, zza());
        LatLng latLng = (LatLng) zzc.zza(zza, LatLng.CREATOR);
        zza.recycle();
        return latLng;
    }

    public final int getFillColor() throws RemoteException {
        Parcel zza = zza(12, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final String getId() throws RemoteException {
        Parcel zza = zza(2, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final double getRadius() throws RemoteException {
        Parcel zza = zza(6, zza());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    public final int getStrokeColor() throws RemoteException {
        Parcel zza = zza(10, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final List<PatternItem> getStrokePattern() throws RemoteException {
        Parcel zza = zza(22, zza());
        ArrayList<PatternItem> createTypedArrayList = zza.createTypedArrayList(PatternItem.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final float getStrokeWidth() throws RemoteException {
        Parcel zza = zza(8, zza());
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
        Parcel zza = zza(20, zza());
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

    public final void setCenter(LatLng latLng) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) latLng);
        zzb(3, zza);
    }

    public final void setClickable(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(19, zza);
    }

    public final void setFillColor(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzb(11, zza);
    }

    public final void setRadius(double d2) throws RemoteException {
        Parcel zza = zza();
        zza.writeDouble(d2);
        zzb(5, zza);
    }

    public final void setStrokeColor(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzb(9, zza);
    }

    public final void setStrokePattern(List<PatternItem> list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzb(21, zza);
    }

    public final void setStrokeWidth(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(7, zza);
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

    public final boolean zzb(zzh zzh) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzh);
        Parcel zza2 = zza(17, zza);
        boolean zza3 = zzc.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    public final void zze(b bVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) bVar);
        zzb(23, zza);
    }

    public final int zzj() throws RemoteException {
        Parcel zza = zza(18, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final b zzk() throws RemoteException {
        Parcel zza = zza(24, zza());
        b a2 = b.a.a(zza.readStrongBinder());
        zza.recycle();
        return a2;
    }
}
