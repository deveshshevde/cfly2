package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;

public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    final int f17917a;

    /* renamed from: b  reason: collision with root package name */
    final String f17918b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<zam> f17919c;

    zal(int i2, String str, ArrayList<zam> arrayList) {
        this.f17917a = i2;
        this.f17918b = str;
        this.f17919c = arrayList;
    }

    zal(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zam> arrayList;
        this.f17917a = 1;
        this.f17918b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String next : map.keySet()) {
                arrayList.add(new zam(next, map.get(next)));
            }
        }
        this.f17919c = arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17917a);
        a.a(parcel, 2, this.f17918b, false);
        a.c(parcel, 3, this.f17919c, false);
        a.a(parcel, a2);
    }
}
