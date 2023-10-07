package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

public class Province implements Parcelable {
    public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator<Province>() {
        private static Province a(Parcel parcel) {
            return new Province(parcel);
        }

        private static Province[] a(int i2) {
            return new Province[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i2) {
            return a(i2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f9828a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f9829b;

    /* renamed from: c  reason: collision with root package name */
    private String f9830c;

    /* renamed from: d  reason: collision with root package name */
    private String f9831d = "";

    public Province() {
    }

    public Province(Parcel parcel) {
        this.f9828a = parcel.readString();
        this.f9829b = parcel.readString();
        this.f9830c = parcel.readString();
        this.f9831d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getJianpin() {
        return this.f9829b;
    }

    public String getPinyin() {
        return this.f9830c;
    }

    public String getProvinceCode() {
        return this.f9831d;
    }

    public String getProvinceName() {
        return this.f9828a;
    }

    public void setJianpin(String str) {
        this.f9829b = str;
    }

    public void setPinyin(String str) {
        this.f9830c = str;
    }

    public void setProvinceCode(String str) {
        this.f9831d = str;
    }

    public void setProvinceName(String str) {
        this.f9828a = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f9828a);
        parcel.writeString(this.f9829b);
        parcel.writeString(this.f9830c);
        parcel.writeString(this.f9831d);
    }
}
