package com.huawei.android.multiscreen.dlna.sdk.common;

import android.os.Parcel;
import android.os.Parcelable;

public class MediaInfo implements Parcelable {
    public static final Parcelable.Creator<MediaInfo> CREATOR = new Parcelable.Creator<MediaInfo>() {
        /* renamed from: a */
        public MediaInfo createFromParcel(Parcel parcel) {
            MediaInfo mediaInfo = new MediaInfo();
            mediaInfo.k(parcel.readString());
            mediaInfo.l(parcel.readString());
            mediaInfo.a(EMediaInfoType.valueOf(parcel.readString()));
            mediaInfo.m(parcel.readString());
            mediaInfo.n(parcel.readString());
            mediaInfo.o(parcel.readString());
            mediaInfo.p(parcel.readString());
            mediaInfo.q(parcel.readString());
            mediaInfo.a(parcel.readLong());
            mediaInfo.e(parcel.readInt());
            mediaInfo.f(parcel.readInt());
            return mediaInfo;
        }

        /* renamed from: a */
        public MediaInfo[] newArray(int i2) {
            return new MediaInfo[i2];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    protected String f20709f;

    /* renamed from: g  reason: collision with root package name */
    protected String f20710g;

    /* renamed from: h  reason: collision with root package name */
    protected EMediaInfoType f20711h;

    /* renamed from: i  reason: collision with root package name */
    protected String f20712i;

    /* renamed from: j  reason: collision with root package name */
    protected String f20713j;

    /* renamed from: k  reason: collision with root package name */
    protected String f20714k;

    /* renamed from: l  reason: collision with root package name */
    protected String f20715l;

    /* renamed from: m  reason: collision with root package name */
    protected String f20716m;

    /* renamed from: n  reason: collision with root package name */
    protected String f20717n;

    /* renamed from: o  reason: collision with root package name */
    protected long f20718o;

    /* renamed from: p  reason: collision with root package name */
    protected int f20719p;

    /* renamed from: q  reason: collision with root package name */
    protected int f20720q;

    public void a(long j2) {
        this.f20718o = j2;
    }

    public void a(EMediaInfoType eMediaInfoType) {
        this.f20711h = eMediaInfoType;
    }

    public int describeContents() {
        return 0;
    }

    public void e(int i2) {
        this.f20719p = i2;
    }

    public void f(int i2) {
        this.f20720q = i2;
    }

    public void k(String str) {
        this.f20709f = str;
    }

    public void l(String str) {
        this.f20710g = str;
    }

    public void m(String str) {
        this.f20712i = str;
    }

    public void n(String str) {
        this.f20713j = str;
    }

    public void o(String str) {
        this.f20714k = str;
    }

    public void p(String str) {
        this.f20715l = str;
    }

    public void q(String str) {
        this.f20716m = str;
    }

    public void r(String str) {
        this.f20717n = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f20709f);
        parcel.writeString(this.f20710g);
        parcel.writeString(this.f20711h.toString());
        parcel.writeString(this.f20712i);
        parcel.writeString(this.f20713j);
        parcel.writeString(this.f20714k);
        parcel.writeString(this.f20715l);
        parcel.writeString(this.f20716m);
        parcel.writeLong(this.f20718o);
        parcel.writeInt(this.f20719p);
        parcel.writeInt(this.f20720q);
    }
}
