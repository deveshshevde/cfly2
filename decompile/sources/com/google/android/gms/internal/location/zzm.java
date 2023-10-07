package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.zzo;
import java.util.List;

public final class zzm implements Parcelable.Creator<zzj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzo zzo = zzj.zzb;
        List<ClientIdentity> list = zzj.zza;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                zzo = (zzo) SafeParcelReader.a(parcel, a2, zzo.CREATOR);
            } else if (a3 == 2) {
                list = SafeParcelReader.b(parcel, a2, ClientIdentity.CREATOR);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                str = SafeParcelReader.l(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zzj(zzo, list, str);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzj[i2];
    }
}
