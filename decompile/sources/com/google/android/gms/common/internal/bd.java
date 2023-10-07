package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;

public final class bd implements Parcelable.Creator<GetServiceRequest> {
    static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, getServiceRequest.f17745a);
        a.a(parcel, 2, getServiceRequest.f17746b);
        a.a(parcel, 3, getServiceRequest.f17747c);
        a.a(parcel, 4, getServiceRequest.f17748d, false);
        a.a(parcel, 5, getServiceRequest.f17749e, false);
        a.a(parcel, 6, (T[]) getServiceRequest.f17750f, i2, false);
        a.a(parcel, 7, getServiceRequest.f17751g, false);
        a.a(parcel, 8, (Parcelable) getServiceRequest.f17752h, i2, false);
        a.a(parcel, 10, (T[]) getServiceRequest.f17753i, i2, false);
        a.a(parcel, 11, (T[]) getServiceRequest.f17754j, i2, false);
        a.a(parcel, 12, getServiceRequest.f17755k);
        a.a(parcel, 13, getServiceRequest.f17756l);
        a.a(parcel, 14, getServiceRequest.f17757m);
        a.a(parcel, 15, getServiceRequest.a(), false);
        a.a(parcel, a2);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        boolean z3 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i2 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 2:
                    i3 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 3:
                    i4 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 4:
                    str = SafeParcelReader.l(parcel2, a2);
                    break;
                case 5:
                    iBinder = SafeParcelReader.h(parcel2, a2);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.c(parcel2, a2, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.g(parcel2, a2);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.a(parcel2, a2, Account.CREATOR);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.c(parcel2, a2, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.c(parcel2, a2, Feature.CREATOR);
                    break;
                case 12:
                    z2 = SafeParcelReader.s(parcel2, a2);
                    break;
                case 13:
                    i5 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 14:
                    z3 = SafeParcelReader.s(parcel2, a2);
                    break;
                case 15:
                    str2 = SafeParcelReader.l(parcel2, a2);
                    break;
                default:
                    SafeParcelReader.r(parcel2, a2);
                    break;
            }
        }
        SafeParcelReader.q(parcel2, b2);
        return new GetServiceRequest(i2, i3, i4, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z2, i5, z3, str2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new GetServiceRequest[i2];
    }
}
