package gj;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzu;

public abstract class v extends zzb implements u {
    public v() {
        super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            a(zzu.zzg(parcel.readStrongBinder()));
        } else if (i2 == 2) {
            b(zzu.zzg(parcel.readStrongBinder()));
        } else if (i2 != 3) {
            return false;
        } else {
            c(zzu.zzg(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
