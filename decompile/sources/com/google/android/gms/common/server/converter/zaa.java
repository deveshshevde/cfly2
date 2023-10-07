package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse;

public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f17894a;

    /* renamed from: b  reason: collision with root package name */
    private final StringToIntConverter f17895b;

    zaa(int i2, StringToIntConverter stringToIntConverter) {
        this.f17894a = i2;
        this.f17895b = stringToIntConverter;
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.f17894a = 1;
        this.f17895b = stringToIntConverter;
    }

    public static zaa a(FastJsonResponse.a<?, ?> aVar) {
        if (aVar instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) aVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final FastJsonResponse.a<?, ?> a() {
        StringToIntConverter stringToIntConverter = this.f17895b;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17894a);
        a.a(parcel, 2, (Parcelable) this.f17895b, i2, false);
        a.a(parcel, a2);
    }
}
