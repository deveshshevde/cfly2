package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    final int f17891a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f17892b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<String> f17893c;

    public StringToIntConverter() {
        this.f17891a = 1;
        this.f17892b = new HashMap<>();
        this.f17893c = new SparseArray<>();
    }

    StringToIntConverter(int i2, ArrayList<zac> arrayList) {
        this.f17891a = i2;
        this.f17892b = new HashMap<>();
        this.f17893c = new SparseArray<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zac zac = arrayList.get(i3);
            a(zac.f17897b, zac.f17898c);
        }
    }

    public StringToIntConverter a(String str, int i2) {
        this.f17892b.put(str, Integer.valueOf(i2));
        this.f17893c.put(i2, str);
        return this;
    }

    public final /* synthetic */ Object a(Object obj) {
        String str = this.f17893c.get(((Integer) obj).intValue());
        return (str != null || !this.f17892b.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17891a);
        ArrayList arrayList = new ArrayList();
        for (String next : this.f17892b.keySet()) {
            arrayList.add(new zac(next, this.f17892b.get(next).intValue()));
        }
        a.c(parcel, 2, arrayList, false);
        a.a(parcel, a2);
    }
}
