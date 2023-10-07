package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Comparator;

public class DetectedActivity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new al();

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<DetectedActivity> f18049a = new am();

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f18050b = {9, 10};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f18051c = {0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21, 22};

    /* renamed from: d  reason: collision with root package name */
    private int f18052d;

    /* renamed from: e  reason: collision with root package name */
    private int f18053e;

    public DetectedActivity(int i2, int i3) {
        this.f18052d = i2;
        this.f18053e = i3;
    }

    public int a() {
        int i2 = this.f18052d;
        if (i2 > 22 || i2 < 0) {
            return 4;
        }
        return i2;
    }

    public int b() {
        return this.f18053e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DetectedActivity) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            return this.f18052d == detectedActivity.f18052d && this.f18053e == detectedActivity.f18053e;
        }
    }

    public int hashCode() {
        return l.a(Integer.valueOf(this.f18052d), Integer.valueOf(this.f18053e));
    }

    public String toString() {
        int a2 = a();
        String num = a2 != 0 ? a2 != 1 ? a2 != 2 ? a2 != 3 ? a2 != 4 ? a2 != 5 ? a2 != 7 ? a2 != 8 ? a2 != 16 ? a2 != 17 ? Integer.toString(a2) : "IN_RAIL_VEHICLE" : "IN_ROAD_VEHICLE" : "RUNNING" : "WALKING" : "TILTING" : "UNKNOWN" : "STILL" : "ON_FOOT" : "ON_BICYCLE" : "IN_VEHICLE";
        int i2 = this.f18053e;
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 48);
        sb.append("DetectedActivity [type=");
        sb.append(num);
        sb.append(", confidence=");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f18052d);
        a.a(parcel, 2, this.f18053e);
        a.a(parcel, a2);
    }
}
