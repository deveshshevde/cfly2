package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class NavigateArrowOptionsCreator implements Parcelable.Creator<NavigateArrowOptions> {
    public NavigateArrowOptions createFromParcel(Parcel parcel) {
        NavigateArrowOptions navigateArrowOptions = new NavigateArrowOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z2 = false;
        boolean z3 = parcel.readByte() == 1;
        if (parcel.readByte() == 1) {
            z2 = true;
        }
        navigateArrowOptions.addAll(arrayList);
        navigateArrowOptions.width(readFloat);
        navigateArrowOptions.topColor(readInt);
        navigateArrowOptions.sideColor(readInt2);
        navigateArrowOptions.zIndex(readFloat2);
        navigateArrowOptions.visible(z3);
        navigateArrowOptions.f9750a = parcel.readString();
        navigateArrowOptions.set3DModel(z2);
        return navigateArrowOptions;
    }

    public NavigateArrowOptions[] newArray(int i2) {
        return new NavigateArrowOptions[i2];
    }
}
