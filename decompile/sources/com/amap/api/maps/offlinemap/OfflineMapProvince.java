package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineMapProvince extends Province {
    public static final Parcelable.Creator<OfflineMapProvince> CREATOR = new Parcelable.Creator<OfflineMapProvince>() {
        private static OfflineMapProvince a(Parcel parcel) {
            return new OfflineMapProvince(parcel);
        }

        private static OfflineMapProvince[] a(int i2) {
            return new OfflineMapProvince[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i2) {
            return a(i2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f9822a;

    /* renamed from: b  reason: collision with root package name */
    private int f9823b = 6;

    /* renamed from: c  reason: collision with root package name */
    private long f9824c;

    /* renamed from: d  reason: collision with root package name */
    private String f9825d;

    /* renamed from: e  reason: collision with root package name */
    private int f9826e = 0;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<OfflineMapCity> f9827f;

    public OfflineMapProvince() {
    }

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.f9822a = parcel.readString();
        this.f9823b = parcel.readInt();
        this.f9824c = parcel.readLong();
        this.f9825d = parcel.readString();
        this.f9826e = parcel.readInt();
        this.f9827f = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<OfflineMapCity> getCityList() {
        ArrayList<OfflineMapCity> arrayList = this.f9827f;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public ArrayList<OfflineMapCity> getDownloadedCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = this.f9827f;
        if (arrayList2 == null) {
            return arrayList;
        }
        Iterator<OfflineMapCity> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            OfflineMapCity next = it2.next();
            if (next.getState() != 6) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public long getSize() {
        return this.f9824c;
    }

    public int getState() {
        return this.f9823b;
    }

    public String getUrl() {
        return this.f9822a;
    }

    public String getVersion() {
        return this.f9825d;
    }

    public int getcompleteCode() {
        return this.f9826e;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.f9827f = arrayList;
    }

    public void setCompleteCode(int i2) {
        this.f9826e = i2;
    }

    public void setSize(long j2) {
        this.f9824c = j2;
    }

    public void setState(int i2) {
        this.f9823b = i2;
    }

    public void setUrl(String str) {
        this.f9822a = str;
    }

    public void setVersion(String str) {
        this.f9825d = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.f9822a);
        parcel.writeInt(this.f9823b);
        parcel.writeLong(this.f9824c);
        parcel.writeString(this.f9825d);
        parcel.writeInt(this.f9826e);
        parcel.writeTypedList(this.f9827f);
    }
}
