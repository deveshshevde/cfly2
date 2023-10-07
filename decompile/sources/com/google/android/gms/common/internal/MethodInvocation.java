package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new ah();

    /* renamed from: a  reason: collision with root package name */
    private final int f17759a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17760b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17761c;

    /* renamed from: d  reason: collision with root package name */
    private final long f17762d;

    /* renamed from: e  reason: collision with root package name */
    private final long f17763e;

    /* renamed from: f  reason: collision with root package name */
    private final String f17764f;

    /* renamed from: g  reason: collision with root package name */
    private final String f17765g;

    /* renamed from: h  reason: collision with root package name */
    private final int f17766h;

    /* renamed from: i  reason: collision with root package name */
    private final int f17767i;

    public MethodInvocation(int i2, int i3, int i4, long j2, long j3, String str, String str2, int i5, int i6) {
        this.f17759a = i2;
        this.f17760b = i3;
        this.f17761c = i4;
        this.f17762d = j2;
        this.f17763e = j3;
        this.f17764f = str;
        this.f17765g = str2;
        this.f17766h = i5;
        this.f17767i = i6;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17759a);
        a.a(parcel, 2, this.f17760b);
        a.a(parcel, 3, this.f17761c);
        a.a(parcel, 4, this.f17762d);
        a.a(parcel, 5, this.f17763e);
        a.a(parcel, 6, this.f17764f, false);
        a.a(parcel, 7, this.f17765g, false);
        a.a(parcel, 8, this.f17766h);
        a.a(parcel, 9, this.f17767i);
        a.a(parcel, a2);
    }
}
