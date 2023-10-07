package gj;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public interface o extends IInterface {
    void a(LatLng latLng) throws RemoteException;
}
