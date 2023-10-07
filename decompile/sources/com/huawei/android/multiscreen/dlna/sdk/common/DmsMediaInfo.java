package com.huawei.android.multiscreen.dlna.sdk.common;

import android.os.Parcel;
import android.os.Parcelable;

public class DmsMediaInfo extends MediaInfo implements Parcelable {
    public static final Parcelable.Creator<DmsMediaInfo> CREATOR = new Parcelable.Creator<DmsMediaInfo>() {
        /* renamed from: a */
        public DmsMediaInfo createFromParcel(Parcel parcel) {
            DmsMediaInfo dmsMediaInfo = new DmsMediaInfo();
            dmsMediaInfo.o(parcel.readString());
            dmsMediaInfo.r(parcel.readString());
            dmsMediaInfo.e(parcel.readString());
            dmsMediaInfo.h(parcel.readString());
            dmsMediaInfo.c(parcel.readInt());
            dmsMediaInfo.d(parcel.readInt());
            dmsMediaInfo.b(parcel.readInt());
            dmsMediaInfo.q(parcel.readString());
            dmsMediaInfo.f(parcel.readInt());
            dmsMediaInfo.p(parcel.readString());
            dmsMediaInfo.a(parcel.readInt());
            dmsMediaInfo.i(parcel.readString());
            dmsMediaInfo.j(parcel.readString());
            dmsMediaInfo.b(parcel.readString());
            dmsMediaInfo.d(parcel.readString());
            dmsMediaInfo.a(EMediaInfoType.valueOf(parcel.readString()));
            dmsMediaInfo.a(parcel.readString());
            dmsMediaInfo.n(parcel.readString());
            dmsMediaInfo.k(parcel.readString());
            dmsMediaInfo.f(parcel.readString());
            dmsMediaInfo.g(parcel.readString());
            dmsMediaInfo.a(Boolean.valueOf(parcel.readString()));
            dmsMediaInfo.a(parcel.readLong());
            dmsMediaInfo.l(parcel.readString());
            dmsMediaInfo.c(parcel.readString());
            dmsMediaInfo.m(parcel.readString());
            dmsMediaInfo.e(parcel.readInt());
            return dmsMediaInfo;
        }

        /* renamed from: a */
        public DmsMediaInfo[] newArray(int i2) {
            return new DmsMediaInfo[i2];
        }
    };
    private String A;

    /* renamed from: a  reason: collision with root package name */
    protected int f20666a;

    /* renamed from: b  reason: collision with root package name */
    protected int f20667b;

    /* renamed from: c  reason: collision with root package name */
    protected String f20668c;

    /* renamed from: d  reason: collision with root package name */
    protected String f20669d;

    /* renamed from: e  reason: collision with root package name */
    protected String f20670e;

    /* renamed from: r  reason: collision with root package name */
    private String f20671r = null;

    /* renamed from: s  reason: collision with root package name */
    private int f20672s;

    /* renamed from: t  reason: collision with root package name */
    private String f20673t;

    /* renamed from: u  reason: collision with root package name */
    private String f20674u;

    /* renamed from: v  reason: collision with root package name */
    private Boolean f20675v = true;

    /* renamed from: w  reason: collision with root package name */
    private int f20676w;

    /* renamed from: x  reason: collision with root package name */
    private String f20677x;

    /* renamed from: y  reason: collision with root package name */
    private String f20678y;

    /* renamed from: z  reason: collision with root package name */
    private String f20679z;

    public void a(int i2) {
        this.f20666a = i2;
    }

    public void a(Boolean bool) {
        this.f20675v = bool;
    }

    public void a(String str) {
        this.f20671r = str;
    }

    public void b(int i2) {
        this.f20667b = i2;
    }

    public void b(String str) {
        this.f20668c = str;
    }

    public void c(int i2) {
        this.f20672s = i2;
    }

    public void c(String str) {
        this.f20669d = str;
    }

    public void d(int i2) {
        this.f20676w = i2;
    }

    public void d(String str) {
        this.f20670e = str;
    }

    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.f20673t = str;
    }

    public void f(String str) {
        this.f20674u = str;
    }

    public void g(String str) {
        this.f20677x = str;
    }

    public void h(String str) {
        this.f20678y = str;
    }

    public void i(String str) {
        this.A = str;
    }

    public void j(String str) {
        this.f20679z = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f20666a);
        parcel.writeInt(this.f20667b);
        parcel.writeString(this.f20668c);
        parcel.writeString(this.f20669d);
        parcel.writeString(this.f20670e);
        parcel.writeString(this.f20709f);
        parcel.writeString(this.f20710g);
        parcel.writeString(this.f20711h.toString());
        parcel.writeString(this.f20712i);
        parcel.writeString(this.f20713j);
        parcel.writeString(this.f20714k);
        parcel.writeString(this.f20717n);
        parcel.writeString(this.f20715l);
        parcel.writeString(this.f20716m);
        parcel.writeLong(this.f20718o);
        parcel.writeInt(this.f20719p);
        parcel.writeInt(this.f20720q);
        parcel.writeInt(this.f20672s);
        parcel.writeString(this.f20673t);
        parcel.writeString(this.f20674u);
        parcel.writeString(this.f20675v.toString());
        parcel.writeInt(this.f20676w);
        parcel.writeString(this.f20677x);
        parcel.writeString(this.f20678y);
        parcel.writeString(this.f20679z);
        parcel.writeString(this.A);
    }
}
