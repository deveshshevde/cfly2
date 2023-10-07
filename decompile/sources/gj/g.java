package gj;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public interface g extends IInterface {
    b a(b bVar, b bVar2, Bundle bundle) throws RemoteException;

    void a() throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void a(b bVar, StreetViewPanoramaOptions streetViewPanoramaOptions, Bundle bundle) throws RemoteException;

    void a(x xVar) throws RemoteException;

    void b() throws RemoteException;

    void b(Bundle bundle) throws RemoteException;

    void c() throws RemoteException;

    void d() throws RemoteException;

    void e() throws RemoteException;

    void f() throws RemoteException;

    void g() throws RemoteException;
}
