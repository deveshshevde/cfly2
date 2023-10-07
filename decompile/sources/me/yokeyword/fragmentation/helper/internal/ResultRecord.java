package me.yokeyword.fragmentation.helper.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class ResultRecord implements Parcelable {
    public static final Parcelable.Creator<ResultRecord> CREATOR = new Parcelable.Creator<ResultRecord>() {
        /* renamed from: a */
        public ResultRecord createFromParcel(Parcel parcel) {
            return new ResultRecord(parcel);
        }

        /* renamed from: a */
        public ResultRecord[] newArray(int i2) {
            return new ResultRecord[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f31177a;

    /* renamed from: b  reason: collision with root package name */
    public int f31178b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f31179c;

    public ResultRecord() {
    }

    protected ResultRecord(Parcel parcel) {
        this.f31177a = parcel.readInt();
        this.f31178b = parcel.readInt();
        this.f31179c = parcel.readBundle(getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f31177a);
        parcel.writeInt(this.f31178b);
        parcel.writeBundle(this.f31179c);
    }
}
