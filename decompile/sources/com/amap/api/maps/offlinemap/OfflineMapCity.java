package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

public class OfflineMapCity extends City {
    public static final Parcelable.Creator<OfflineMapCity> CREATOR = new Parcelable.Creator<OfflineMapCity>() {
        private static OfflineMapCity a(Parcel parcel) {
            return new OfflineMapCity(parcel);
        }

        private static OfflineMapCity[] a(int i2) {
            return new OfflineMapCity[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i2) {
            return a(i2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f9798a = "";

    /* renamed from: b  reason: collision with root package name */
    private long f9799b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f9800c = 6;

    /* renamed from: d  reason: collision with root package name */
    private String f9801d = "";

    /* renamed from: e  reason: collision with root package name */
    private int f9802e = 0;

    public OfflineMapCity() {
    }

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.f9798a = parcel.readString();
        this.f9799b = parcel.readLong();
        this.f9800c = parcel.readInt();
        this.f9801d = parcel.readString();
        this.f9802e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public long getSize() {
        return this.f9799b;
    }

    public int getState() {
        return this.f9800c;
    }

    public String getUrl() {
        return this.f9798a;
    }

    public String getVersion() {
        return this.f9801d;
    }

    public int getcompleteCode() {
        return this.f9802e;
    }

    public void setCompleteCode(int i2) {
        this.f9802e = i2;
    }

    public void setSize(long j2) {
        this.f9799b = j2;
    }

    public void setState(int i2) {
        this.f9800c = i2;
    }

    public void setUrl(String str) {
        this.f9798a = str;
    }

    public void setVersion(String str) {
        this.f9801d = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.f9798a);
        parcel.writeLong(this.f9799b);
        parcel.writeInt(this.f9800c);
        parcel.writeString(this.f9801d);
        parcel.writeInt(this.f9802e);
    }
}
