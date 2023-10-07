package gj;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzh;
import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.internal.maps.zzw;
import com.google.android.gms.internal.maps.zzz;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

public interface b extends IInterface {
    zzac a(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    zzh a(CircleOptions circleOptions) throws RemoteException;

    zzt a(MarkerOptions markerOptions) throws RemoteException;

    zzw a(PolygonOptions polygonOptions) throws RemoteException;

    zzz a(PolylineOptions polylineOptions) throws RemoteException;

    CameraPosition a() throws RemoteException;

    void a(int i2) throws RemoteException;

    void a(int i2, int i3, int i4, int i5) throws RemoteException;

    void a(com.google.android.gms.dynamic.b bVar) throws RemoteException;

    void a(m mVar) throws RemoteException;

    void a(o oVar) throws RemoteException;

    void a(s sVar) throws RemoteException;

    void a(u uVar) throws RemoteException;

    void a(boolean z2) throws RemoteException;

    i b() throws RemoteException;

    void b(com.google.android.gms.dynamic.b bVar) throws RemoteException;

    e c() throws RemoteException;
}
