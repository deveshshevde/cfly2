package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

public interface zzw extends IInterface {
    int getFillColor() throws RemoteException;

    List getHoles() throws RemoteException;

    String getId() throws RemoteException;

    List<LatLng> getPoints() throws RemoteException;

    int getStrokeColor() throws RemoteException;

    int getStrokeJointType() throws RemoteException;

    List<PatternItem> getStrokePattern() throws RemoteException;

    float getStrokeWidth() throws RemoteException;

    float getZIndex() throws RemoteException;

    boolean isClickable() throws RemoteException;

    boolean isGeodesic() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setClickable(boolean z2) throws RemoteException;

    void setFillColor(int i2) throws RemoteException;

    void setGeodesic(boolean z2) throws RemoteException;

    void setHoles(List list) throws RemoteException;

    void setPoints(List<LatLng> list) throws RemoteException;

    void setStrokeColor(int i2) throws RemoteException;

    void setStrokeJointType(int i2) throws RemoteException;

    void setStrokePattern(List<PatternItem> list) throws RemoteException;

    void setStrokeWidth(float f2) throws RemoteException;

    void setVisible(boolean z2) throws RemoteException;

    void setZIndex(float f2) throws RemoteException;

    boolean zzb(zzw zzw) throws RemoteException;

    void zze(b bVar) throws RemoteException;

    int zzj() throws RemoteException;

    b zzk() throws RemoteException;
}
