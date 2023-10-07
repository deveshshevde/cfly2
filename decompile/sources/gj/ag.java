package gj;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.maps.zze;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public interface ag extends IInterface {
    a a() throws RemoteException;

    c a(b bVar) throws RemoteException;

    d a(b bVar, GoogleMapOptions googleMapOptions) throws RemoteException;

    h a(b bVar, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    void a(b bVar, int i2) throws RemoteException;

    zze b() throws RemoteException;

    g b(b bVar) throws RemoteException;
}
