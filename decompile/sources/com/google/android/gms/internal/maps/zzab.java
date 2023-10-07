package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

public final class zzab extends zza implements zzz {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
    }

    public final int getColor() throws RemoteException {
        Parcel zza = zza(8, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final Cap getEndCap() throws RemoteException {
        Parcel zza = zza(22, zza());
        Cap cap = (Cap) zzc.zza(zza, Cap.CREATOR);
        zza.recycle();
        return cap;
    }

    public final String getId() throws RemoteException {
        Parcel zza = zza(2, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final int getJointType() throws RemoteException {
        Parcel zza = zza(24, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final List<PatternItem> getPattern() throws RemoteException {
        Parcel zza = zza(26, zza());
        ArrayList<PatternItem> createTypedArrayList = zza.createTypedArrayList(PatternItem.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<LatLng> getPoints() throws RemoteException {
        Parcel zza = zza(4, zza());
        ArrayList<LatLng> createTypedArrayList = zza.createTypedArrayList(LatLng.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final Cap getStartCap() throws RemoteException {
        Parcel zza = zza(20, zza());
        Cap cap = (Cap) zzc.zza(zza, Cap.CREATOR);
        zza.recycle();
        return cap;
    }

    public final float getWidth() throws RemoteException {
        Parcel zza = zza(6, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getZIndex() throws RemoteException {
        Parcel zza = zza(10, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final boolean isClickable() throws RemoteException {
        Parcel zza = zza(18, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isGeodesic() throws RemoteException {
        Parcel zza = zza(14, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isVisible() throws RemoteException {
        Parcel zza = zza(12, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void remove() throws RemoteException {
        zzb(1, zza());
    }

    public final void setClickable(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(17, zza);
    }

    public final void setColor(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzb(7, zza);
    }

    public final void setEndCap(Cap cap) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) cap);
        zzb(21, zza);
    }

    public final void setGeodesic(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(13, zza);
    }

    public final void setJointType(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zzb(23, zza);
    }

    public final void setPattern(List<PatternItem> list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzb(25, zza);
    }

    public final void setPoints(List<LatLng> list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzb(3, zza);
    }

    public final void setStartCap(Cap cap) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) cap);
        zzb(19, zza);
    }

    public final void setVisible(boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z2);
        zzb(11, zza);
    }

    public final void setWidth(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(5, zza);
    }

    public final void setZIndex(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(9, zza);
    }

    public final boolean zzb(zzz zzz) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzz);
        Parcel zza2 = zza(15, zza);
        boolean zza3 = zzc.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    public final void zze(b bVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) bVar);
        zzb(27, zza);
    }

    public final int zzj() throws RemoteException {
        Parcel zza = zza(16, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final b zzk() throws RemoteException {
        Parcel zza = zza(28, zza());
        b a2 = b.a.a(zza.readStrongBinder());
        zza.recycle();
        return a2;
    }
}
