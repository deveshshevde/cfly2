package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

public class AMapOptions implements Parcelable {
    public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
    public static final int LOGO_MARGIN_BOTTOM = 2;
    public static final int LOGO_MARGIN_LEFT = 0;
    public static final int LOGO_MARGIN_RIGHT = 1;
    public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
    public static final int ZOOM_POSITION_RIGHT_BUTTOM = 2;
    public static final int ZOOM_POSITION_RIGHT_CENTER = 1;
    private CameraPosition cameraPosition;
    private boolean isCompassEnabled = false;
    private boolean isRotateGesturesEnabled = true;
    private boolean isScaleControlsEnabled = false;
    private boolean isScrollGesturesEnabled = true;
    private boolean isTiltGesturesEnabled = true;
    private boolean isZOrderOnTop = false;
    private boolean isZoomEnabled = true;
    private boolean isZoomGesturesEnabled = true;
    private int logoPosition = 0;
    private int mapType = 1;

    public AMapOptions camera(CameraPosition cameraPosition2) {
        this.cameraPosition = cameraPosition2;
        return this;
    }

    public AMapOptions compassEnabled(boolean z2) {
        this.isCompassEnabled = z2;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.cameraPosition;
    }

    public boolean getCompassEnabled() {
        return this.isCompassEnabled;
    }

    public int getLogoPosition() {
        return this.logoPosition;
    }

    public int getMapType() {
        return this.mapType;
    }

    public boolean getRotateGesturesEnabled() {
        return this.isRotateGesturesEnabled;
    }

    public boolean getScaleControlsEnabled() {
        return this.isScaleControlsEnabled;
    }

    public boolean getScrollGesturesEnabled() {
        return this.isScrollGesturesEnabled;
    }

    public boolean getTiltGesturesEnabled() {
        return this.isTiltGesturesEnabled;
    }

    public boolean getZOrderOnTop() {
        return this.isZOrderOnTop;
    }

    public boolean getZoomControlsEnabled() {
        return this.isZoomEnabled;
    }

    public boolean getZoomGesturesEnabled() {
        return this.isZoomGesturesEnabled;
    }

    public AMapOptions logoPosition(int i2) {
        this.logoPosition = i2;
        return this;
    }

    public AMapOptions mapType(int i2) {
        this.mapType = i2;
        return this;
    }

    public AMapOptions rotateGesturesEnabled(boolean z2) {
        this.isRotateGesturesEnabled = z2;
        return this;
    }

    public AMapOptions scaleControlsEnabled(boolean z2) {
        this.isScaleControlsEnabled = z2;
        return this;
    }

    public AMapOptions scrollGesturesEnabled(boolean z2) {
        this.isScrollGesturesEnabled = z2;
        return this;
    }

    public AMapOptions tiltGesturesEnabled(boolean z2) {
        this.isTiltGesturesEnabled = z2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.cameraPosition, i2);
        parcel.writeInt(this.mapType);
        parcel.writeInt(this.logoPosition);
        parcel.writeBooleanArray(new boolean[]{this.isRotateGesturesEnabled, this.isScrollGesturesEnabled, this.isTiltGesturesEnabled, this.isZoomGesturesEnabled, this.isZoomEnabled, this.isZOrderOnTop, this.isCompassEnabled, this.isScaleControlsEnabled});
    }

    public AMapOptions zOrderOnTop(boolean z2) {
        this.isZOrderOnTop = z2;
        return this;
    }

    public AMapOptions zoomControlsEnabled(boolean z2) {
        this.isZoomEnabled = z2;
        return this;
    }

    public AMapOptions zoomGesturesEnabled(boolean z2) {
        this.isZoomGesturesEnabled = z2;
        return this;
    }
}
