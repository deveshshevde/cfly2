package com.huantansheng.easyphotos.models.album.entity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        /* renamed from: a */
        public Photo createFromParcel(Parcel parcel) {
            return new Photo(parcel);
        }

        /* renamed from: a */
        public Photo[] newArray(int i2) {
            return new Photo[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Uri f20301a;

    /* renamed from: b  reason: collision with root package name */
    public String f20302b;

    /* renamed from: c  reason: collision with root package name */
    public String f20303c;

    /* renamed from: d  reason: collision with root package name */
    public String f20304d;

    /* renamed from: e  reason: collision with root package name */
    public int f20305e;

    /* renamed from: f  reason: collision with root package name */
    public int f20306f;

    /* renamed from: g  reason: collision with root package name */
    public int f20307g;

    /* renamed from: h  reason: collision with root package name */
    public long f20308h;

    /* renamed from: i  reason: collision with root package name */
    public long f20309i;

    /* renamed from: j  reason: collision with root package name */
    public long f20310j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f20311k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f20312l;

    protected Photo(Parcel parcel) {
        this.f20301a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f20302b = parcel.readString();
        this.f20303c = parcel.readString();
        this.f20304d = parcel.readString();
        this.f20305e = parcel.readInt();
        this.f20306f = parcel.readInt();
        this.f20307g = parcel.readInt();
        this.f20308h = parcel.readLong();
        this.f20309i = parcel.readLong();
        this.f20310j = parcel.readLong();
        boolean z2 = true;
        this.f20311k = parcel.readByte() != 0;
        this.f20312l = parcel.readByte() == 0 ? false : z2;
    }

    public Photo(String str, Uri uri, String str2, long j2, int i2, int i3, int i4, long j3, long j4, String str3) {
        this.f20302b = str;
        this.f20301a = uri;
        this.f20303c = str2;
        this.f20310j = j2;
        this.f20305e = i2;
        this.f20306f = i3;
        this.f20307g = i4;
        this.f20304d = str3;
        this.f20308h = j3;
        this.f20309i = j4;
        this.f20311k = false;
        this.f20312l = false;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        try {
            return this.f20303c.equalsIgnoreCase(((Photo) obj).f20303c);
        } catch (ClassCastException e2) {
            Log.e("Photo", "equals: " + Log.getStackTraceString(e2));
            return super.equals(obj);
        }
    }

    public String toString() {
        return "Photo{name='" + this.f20302b + '\'' + ", uri='" + this.f20301a.toString() + '\'' + ", path='" + this.f20303c + '\'' + ", time=" + this.f20310j + '\'' + ", minWidth=" + this.f20305e + '\'' + ", minHeight=" + this.f20306f + ", orientation=" + this.f20307g + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f20301a, i2);
        parcel.writeString(this.f20302b);
        parcel.writeString(this.f20303c);
        parcel.writeString(this.f20304d);
        parcel.writeInt(this.f20305e);
        parcel.writeInt(this.f20306f);
        parcel.writeInt(this.f20307g);
        parcel.writeLong(this.f20308h);
        parcel.writeLong(this.f20309i);
        parcel.writeLong(this.f20310j);
        parcel.writeByte(this.f20311k ? (byte) 1 : 0);
        parcel.writeByte(this.f20312l ? (byte) 1 : 0);
    }
}
