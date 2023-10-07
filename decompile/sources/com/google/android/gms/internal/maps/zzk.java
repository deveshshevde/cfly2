package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface zzk extends IInterface {
    float getBearing() throws RemoteException;

    LatLngBounds getBounds() throws RemoteException;

    float getHeight() throws RemoteException;

    String getId() throws RemoteException;

    LatLng getPosition() throws RemoteException;

    float getTransparency() throws RemoteException;

    float getWidth() throws RemoteException;

    float getZIndex() throws RemoteException;

    boolean isClickable() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setBearing(float f2) throws RemoteException;

    void setClickable(boolean z2) throws RemoteException;

    void setDimensions(float f2) throws RemoteException;

    void setPosition(LatLng latLng) throws RemoteException;

    void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException;

    void setTransparency(float f2) throws RemoteException;

    void setVisible(boolean z2) throws RemoteException;

    void setZIndex(float f2) throws RemoteException;

    void zza(float f2, float f3) throws RemoteException;

    boolean zzb(zzk zzk) throws RemoteException;

    void zze(b bVar) throws RemoteException;

    void zzf(b bVar) throws RemoteException;

    int zzj() throws RemoteException;

    b zzk() throws RemoteException;
}
