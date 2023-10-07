package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;
import java.util.List;

public class TelemetryData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TelemetryData> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    private final int f17773a;

    /* renamed from: b  reason: collision with root package name */
    private List<MethodInvocation> f17774b;

    public TelemetryData(int i2, List<MethodInvocation> list) {
        this.f17773a = i2;
        this.f17774b = list;
    }

    public final int a() {
        return this.f17773a;
    }

    public final void a(MethodInvocation methodInvocation) {
        if (this.f17774b == null) {
            this.f17774b = new ArrayList();
        }
        this.f17774b.add(methodInvocation);
    }

    public final List<MethodInvocation> b() {
        return this.f17774b;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17773a);
        a.c(parcel, 2, this.f17774b, false);
        a.a(parcel, a2);
    }
}
