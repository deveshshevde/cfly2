package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

public interface zzz extends IInterface {
    int getColor() throws RemoteException;

    Cap getEndCap() throws RemoteException;

    String getId() throws RemoteException;

    int getJointType() throws RemoteException;

    List<PatternItem> getPattern() throws RemoteException;

    List<LatLng> getPoints() throws RemoteException;

    Cap getStartCap() throws RemoteException;

    float getWidth() throws RemoteException;

    float getZIndex() throws RemoteException;

    boolean isClickable() throws RemoteException;

    boolean isGeodesic() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setClickable(boolean z2) throws RemoteException;

    void setColor(int i2) throws RemoteException;

    void setEndCap(Cap cap) throws RemoteException;

    void setGeodesic(boolean z2) throws RemoteException;

    void setJointType(int i2) throws RemoteException;

    void setPattern(List<PatternItem> list) throws RemoteException;

    void setPoints(List<LatLng> list) throws RemoteException;

    void setStartCap(Cap cap) throws RemoteException;

    void setVisible(boolean z2) throws RemoteException;

    void setWidth(float f2) throws RemoteException;

    void setZIndex(float f2) throws RemoteException;

    boolean zzb(zzz zzz) throws RemoteException;

    void zze(b bVar) throws RemoteException;

    int zzj() throws RemoteException;

    b zzk() throws RemoteException;
}
