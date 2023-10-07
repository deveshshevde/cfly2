package gj;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface a extends IInterface {
    b a(CameraPosition cameraPosition) throws RemoteException;

    b a(LatLng latLng, float f2) throws RemoteException;

    b a(LatLngBounds latLngBounds, int i2, int i3, int i4) throws RemoteException;
}
