package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class BitmapDescriptorCreator implements Parcelable.Creator<BitmapDescriptor> {
    public BitmapDescriptor createFromParcel(Parcel parcel) {
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor((Bitmap) null, parcel.readString());
        bitmapDescriptor.mBitmap = parcel.readParcelable(Bitmap.class.getClassLoader());
        bitmapDescriptor.f9730a = parcel.readInt();
        bitmapDescriptor.f9731b = parcel.readInt();
        return bitmapDescriptor;
    }

    public BitmapDescriptor[] newArray(int i2) {
        return new BitmapDescriptor[i2];
    }
}
