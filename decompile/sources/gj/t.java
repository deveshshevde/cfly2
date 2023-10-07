package gj;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzu;

public abstract class t extends zzb implements s {
    public t() {
        super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        boolean a2 = a(zzu.zzg(parcel.readStrongBinder()));
        parcel2.writeNoException();
        zzc.writeBoolean(parcel2, a2);
        return true;
    }
}
