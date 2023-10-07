package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class d implements Parcelable.Creator<GoogleSignInOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ArrayList<Scope> arrayList = null;
        Account account = null;
        String str = null;
        String str2 = null;
        ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2 = null;
        String str3 = null;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i2 = SafeParcelReader.d(parcel, a2);
                    break;
                case 2:
                    arrayList = SafeParcelReader.b(parcel, a2, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.a(parcel, a2, Account.CREATOR);
                    break;
                case 4:
                    z2 = SafeParcelReader.s(parcel, a2);
                    break;
                case 5:
                    z3 = SafeParcelReader.s(parcel, a2);
                    break;
                case 6:
                    z4 = SafeParcelReader.s(parcel, a2);
                    break;
                case 7:
                    str = SafeParcelReader.l(parcel, a2);
                    break;
                case 8:
                    str2 = SafeParcelReader.l(parcel, a2);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.b(parcel, a2, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    str3 = SafeParcelReader.l(parcel, a2);
                    break;
                default:
                    SafeParcelReader.r(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new GoogleSignInOptions(i2, arrayList, account, z2, z3, z4, str, str2, arrayList2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new GoogleSignInOptions[i2];
    }
}
