package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {
    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        private static City a(Parcel parcel) {
            return new City(parcel);
        }

        private static City[] a(int i2) {
            return new City[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i2) {
            return a(i2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f9778a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f9779b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f9780c;

    /* renamed from: d  reason: collision with root package name */
    private String f9781d;

    /* renamed from: e  reason: collision with root package name */
    private String f9782e = "";

    public City() {
    }

    public City(Parcel parcel) {
        this.f9778a = parcel.readString();
        this.f9779b = parcel.readString();
        this.f9780c = parcel.readString();
        this.f9781d = parcel.readString();
        this.f9782e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f9782e;
    }

    public String getCity() {
        return this.f9778a;
    }

    public String getCode() {
        return this.f9779b;
    }

    public String getJianpin() {
        return this.f9780c;
    }

    public String getPinyin() {
        return this.f9781d;
    }

    public void setAdcode(String str) {
        this.f9782e = str;
    }

    public void setCity(String str) {
        this.f9778a = str;
    }

    public void setCode(String str) {
        if (str != null && !"[]".equals(str)) {
            this.f9779b = str;
        }
    }

    public void setJianpin(String str) {
        this.f9780c = str;
    }

    public void setPinyin(String str) {
        this.f9781d = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f9778a);
        parcel.writeString(this.f9779b);
        parcel.writeString(this.f9780c);
        parcel.writeString(this.f9781d);
        parcel.writeString(this.f9782e);
    }
}
