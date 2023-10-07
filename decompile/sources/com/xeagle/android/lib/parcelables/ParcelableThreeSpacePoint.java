package com.xeagle.android.lib.parcelables;

import android.os.Parcel;
import android.os.Parcelable;
import lp.b;

public class ParcelableThreeSpacePoint extends b implements Parcelable {
    public static final Parcelable.Creator<ParcelableThreeSpacePoint> CREATOR = new Parcelable.Creator<ParcelableThreeSpacePoint>() {
        /* renamed from: a */
        public ParcelableThreeSpacePoint createFromParcel(Parcel parcel) {
            return new ParcelableThreeSpacePoint(parcel);
        }

        /* renamed from: a */
        public ParcelableThreeSpacePoint[] newArray(int i2) {
            return new ParcelableThreeSpacePoint[i2];
        }
    };

    public ParcelableThreeSpacePoint(double d2, double d3, double d4) {
        super(d2, d3, d4);
    }

    private ParcelableThreeSpacePoint(Parcel parcel) {
        this(parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
    }

    public ParcelableThreeSpacePoint(b bVar) {
        super(bVar.f30971a, bVar.f30972b, bVar.f30973c);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeDouble(this.f30971a);
        parcel.writeDouble(this.f30972b);
        parcel.writeDouble(this.f30973c);
    }
}
