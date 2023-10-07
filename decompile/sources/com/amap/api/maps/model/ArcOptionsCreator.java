package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class ArcOptionsCreator implements Parcelable.Creator<ArcOptions> {
    public ArcOptions createFromParcel(Parcel parcel) {
        ArcOptions arcOptions = new ArcOptions();
        Bundle readBundle = parcel.readBundle();
        arcOptions.point(new LatLng(readBundle.getDouble("startlat"), readBundle.getDouble("startlng")), new LatLng(readBundle.getDouble("passedlat"), readBundle.getDouble("passedlng")), new LatLng(readBundle.getDouble("endlat"), readBundle.getDouble("endlng")));
        arcOptions.strokeWidth(parcel.readFloat());
        arcOptions.strokeColor(parcel.readInt());
        arcOptions.zIndex(parcel.readFloat());
        boolean z2 = true;
        if (parcel.readByte() != 1) {
            z2 = false;
        }
        arcOptions.visible(z2);
        arcOptions.f9729a = parcel.readString();
        return arcOptions;
    }

    public ArcOptions[] newArray(int i2) {
        return new ArcOptions[i2];
    }
}
