package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;

@Deprecated
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    final int f17926a;

    /* renamed from: b  reason: collision with root package name */
    private final long f17927b;

    /* renamed from: c  reason: collision with root package name */
    private int f17928c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17929d;

    /* renamed from: e  reason: collision with root package name */
    private final String f17930e;

    /* renamed from: f  reason: collision with root package name */
    private final String f17931f;

    /* renamed from: g  reason: collision with root package name */
    private final int f17932g;

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f17933h;

    /* renamed from: i  reason: collision with root package name */
    private final String f17934i;

    /* renamed from: j  reason: collision with root package name */
    private final long f17935j;

    /* renamed from: k  reason: collision with root package name */
    private int f17936k;

    /* renamed from: l  reason: collision with root package name */
    private final String f17937l;

    /* renamed from: m  reason: collision with root package name */
    private final float f17938m;

    /* renamed from: n  reason: collision with root package name */
    private final long f17939n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f17940o;

    /* renamed from: p  reason: collision with root package name */
    private long f17941p = -1;

    WakeLockEvent(int i2, long j2, int i3, String str, int i4, List<String> list, String str2, long j3, int i5, String str3, String str4, float f2, long j4, String str5, boolean z2) {
        this.f17926a = i2;
        this.f17927b = j2;
        this.f17928c = i3;
        this.f17929d = str;
        this.f17930e = str3;
        this.f17931f = str5;
        this.f17932g = i4;
        this.f17933h = list;
        this.f17934i = str2;
        this.f17935j = j3;
        this.f17936k = i5;
        this.f17937l = str4;
        this.f17938m = f2;
        this.f17939n = j4;
        this.f17940o = z2;
    }

    public final int a() {
        return this.f17928c;
    }

    public final long b() {
        return this.f17941p;
    }

    public final long c() {
        return this.f17927b;
    }

    public final String d() {
        List<String> list = this.f17933h;
        String str = this.f17929d;
        int i2 = this.f17932g;
        String str2 = "";
        String join = list == null ? str2 : TextUtils.join(",", list);
        int i3 = this.f17936k;
        String str3 = this.f17930e;
        if (str3 == null) {
            str3 = str2;
        }
        String str4 = this.f17937l;
        if (str4 == null) {
            str4 = str2;
        }
        float f2 = this.f17938m;
        String str5 = this.f17931f;
        if (str5 != null) {
            str2 = str5;
        }
        boolean z2 = this.f17940o;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + str3.length() + str4.length() + str2.length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(f2);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(z2);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17926a);
        a.a(parcel, 2, this.f17927b);
        a.a(parcel, 4, this.f17929d, false);
        a.a(parcel, 5, this.f17932g);
        a.b(parcel, 6, this.f17933h, false);
        a.a(parcel, 8, this.f17935j);
        a.a(parcel, 10, this.f17930e, false);
        a.a(parcel, 11, this.f17928c);
        a.a(parcel, 12, this.f17934i, false);
        a.a(parcel, 13, this.f17937l, false);
        a.a(parcel, 14, this.f17936k);
        a.a(parcel, 15, this.f17938m);
        a.a(parcel, 16, this.f17939n);
        a.a(parcel, 17, this.f17931f, false);
        a.a(parcel, 18, this.f17940o);
        a.a(parcel, a2);
    }
}
