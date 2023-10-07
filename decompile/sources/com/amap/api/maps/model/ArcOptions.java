package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class ArcOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final ArcOptionsCreator CREATOR = new ArcOptionsCreator();

    /* renamed from: a  reason: collision with root package name */
    String f9729a;
    private LatLng endpoint;
    private boolean isVisible = true;
    private LatLng passedpoint;
    private LatLng startpoint;
    private int strokeColor = -16777216;
    private float strokeWidth = 10.0f;
    private float zIndex = 0.0f;

    public ArcOptions() {
        this.type = "ArcOptions";
    }

    public final ArcOptions clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
        ArcOptions arcOptions = new ArcOptions();
        arcOptions.f9729a = this.f9729a;
        arcOptions.startpoint = this.startpoint;
        arcOptions.passedpoint = this.passedpoint;
        arcOptions.endpoint = this.endpoint;
        arcOptions.strokeWidth = this.strokeWidth;
        arcOptions.strokeColor = this.strokeColor;
        arcOptions.zIndex = this.zIndex;
        arcOptions.isVisible = this.isVisible;
        return arcOptions;
    }

    public final int describeContents() {
        return 0;
    }

    public final LatLng getEnd() {
        return this.endpoint;
    }

    public final LatLng getPassed() {
        return this.passedpoint;
    }

    public final LatLng getStart() {
        return this.startpoint;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final ArcOptions point(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        this.startpoint = latLng;
        this.passedpoint = latLng2;
        this.endpoint = latLng3;
        return this;
    }

    public final ArcOptions strokeColor(int i2) {
        this.strokeColor = i2;
        return this;
    }

    public final ArcOptions strokeWidth(float f2) {
        this.strokeWidth = f2;
        return this;
    }

    public final ArcOptions visible(boolean z2) {
        this.isVisible = z2;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.startpoint;
        if (latLng != null) {
            bundle.putDouble("startlat", latLng.latitude);
            bundle.putDouble("startlng", this.startpoint.longitude);
        }
        LatLng latLng2 = this.passedpoint;
        if (latLng2 != null) {
            bundle.putDouble("passedlat", latLng2.latitude);
            bundle.putDouble("passedlng", this.passedpoint.longitude);
        }
        LatLng latLng3 = this.endpoint;
        if (latLng3 != null) {
            bundle.putDouble("endlat", latLng3.latitude);
            bundle.putDouble("endlng", this.endpoint.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : 0);
        parcel.writeString(this.f9729a);
    }

    public final ArcOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }
}
