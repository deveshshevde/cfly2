package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class CircleOptionsCreator implements Parcelable.Creator<CircleOptions> {
    public CircleOptions createFromParcel(Parcel parcel) {
        CircleOptions circleOptions = new CircleOptions();
        Bundle readBundle = parcel.readBundle();
        circleOptions.center(new LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng")));
        circleOptions.radius(parcel.readDouble());
        circleOptions.strokeWidth(parcel.readFloat());
        circleOptions.strokeColor(parcel.readInt());
        circleOptions.fillColor(parcel.readInt());
        circleOptions.zIndex(parcel.readFloat());
        boolean z2 = false;
        circleOptions.visible(parcel.readByte() == 1);
        circleOptions.f9734a = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, BaseHoleOptions.class.getClassLoader());
        circleOptions.addHoles((Iterable<BaseHoleOptions>) arrayList);
        circleOptions.setStrokeDottedLineType(parcel.readInt());
        if (parcel.readByte() == 1) {
            z2 = true;
        }
        circleOptions.usePolylineStroke(z2);
        return circleOptions;
    }

    public CircleOptions[] newArray(int i2) {
        return new CircleOptions[i2];
    }
}
