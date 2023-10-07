package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public final class GroundOverlayOptions extends BaseOptions implements Parcelable, Cloneable {
    private static final String CLASSNAME = "GroundOverlayOptions";
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;
    private final double NF_PI;
    private final double R;
    private float anchorU;
    private float anchorV;
    private float bearing;
    private BitmapDescriptor bitmapDescriptor;
    private float height;
    private boolean isVisible;
    private LatLng latLng;
    private LatLngBounds latlngBounds;
    private final int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;
    private float transparency;
    private float width;
    private float zIndex;

    public GroundOverlayOptions() {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.mVersionCode = 1;
        this.type = CLASSNAME;
    }

    GroundOverlayOptions(int i2, LatLng latLng2, float f2, float f3, LatLngBounds latLngBounds, float f4, float f5, boolean z2, float f6, float f7, float f8) {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.mVersionCode = i2;
        this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap((Bitmap) null);
        this.latLng = latLng2;
        this.width = f2;
        this.height = f3;
        this.latlngBounds = latLngBounds;
        this.bearing = f4;
        this.zIndex = f5;
        this.isVisible = z2;
        this.transparency = f6;
        this.anchorU = f7;
        this.anchorV = f8;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        this.type = CLASSNAME;
    }

    private GroundOverlayOptions a(LatLng latLng2, float f2, float f3) {
        this.latLng = latLng2;
        this.width = f2;
        this.height = f3;
        b();
        return this;
    }

    private void a() {
        if (this.southwest != null && this.northeast != null) {
            double d2 = this.southwest.latitude;
            double d3 = (double) (1.0f - this.anchorV);
            Double.isNaN(d3);
            double d4 = d2 + (d3 * (this.northeast.latitude - this.southwest.latitude));
            double d5 = this.southwest.longitude;
            double d6 = (double) this.anchorU;
            Double.isNaN(d6);
            LatLng latLng2 = new LatLng(d4, d5 + (d6 * (this.northeast.longitude - this.southwest.longitude)));
            this.latLng = latLng2;
            this.width = (float) (Math.cos(latLng2.latitude * 0.01745329251994329d) * 6371000.79d * (this.northeast.longitude - this.southwest.longitude) * 0.01745329251994329d);
            this.height = (float) ((this.northeast.latitude - this.southwest.latitude) * 6371000.79d * 0.01745329251994329d);
        }
    }

    private void b() {
        LatLng latLng2 = this.latLng;
        if (latLng2 != null) {
            double d2 = (double) this.width;
            Double.isNaN(d2);
            double cos = d2 / ((Math.cos(latLng2.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
            double d3 = (double) this.height;
            Double.isNaN(d3);
            double d4 = d3 / 111194.94043265979d;
            try {
                double d5 = this.latLng.latitude;
                double d6 = (double) (1.0f - this.anchorV);
                Double.isNaN(d6);
                double d7 = d5 - (d6 * d4);
                double d8 = this.latLng.longitude;
                double d9 = (double) this.anchorU;
                Double.isNaN(d9);
                LatLng latLng3 = new LatLng(d7, d8 - (d9 * cos));
                double d10 = this.latLng.latitude;
                double d11 = (double) this.anchorV;
                Double.isNaN(d11);
                double d12 = d10 + (d11 * d4);
                double d13 = this.latLng.longitude;
                double d14 = (double) (1.0f - this.anchorU);
                Double.isNaN(d14);
                LatLngBounds latLngBounds = new LatLngBounds(latLng3, new LatLng(d12, d13 + (d14 * cos)));
                this.latlngBounds = latLngBounds;
                this.southwest = latLngBounds.southwest;
                this.northeast = this.latlngBounds.northeast;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final GroundOverlayOptions anchor(float f2, float f3) {
        this.anchorU = f2;
        this.anchorV = f3;
        if (this.latlngBounds != null) {
            a();
        } else if (this.latLng != null) {
            b();
        }
        return this;
    }

    public final GroundOverlayOptions bearing(float f2) {
        this.bearing = f2;
        return this;
    }

    public final GroundOverlayOptions clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
        groundOverlayOptions.bitmapDescriptor = this.bitmapDescriptor;
        groundOverlayOptions.latLng = this.latLng;
        groundOverlayOptions.width = this.width;
        groundOverlayOptions.height = this.height;
        groundOverlayOptions.latlngBounds = this.latlngBounds;
        groundOverlayOptions.bearing = this.bearing;
        groundOverlayOptions.zIndex = this.zIndex;
        groundOverlayOptions.isVisible = this.isVisible;
        groundOverlayOptions.transparency = this.transparency;
        groundOverlayOptions.anchorU = this.anchorU;
        groundOverlayOptions.anchorV = this.anchorV;
        groundOverlayOptions.southwest = this.southwest;
        groundOverlayOptions.northeast = this.northeast;
        return groundOverlayOptions;
    }

    public final int describeContents() {
        return 0;
    }

    public final float getAnchorU() {
        return this.anchorU;
    }

    public final float getAnchorV() {
        return this.anchorV;
    }

    public final float getBearing() {
        return this.bearing;
    }

    public final LatLngBounds getBounds() {
        return this.latlngBounds;
    }

    public final float getHeight() {
        return this.height;
    }

    public final BitmapDescriptor getImage() {
        return this.bitmapDescriptor;
    }

    public final LatLng getLocation() {
        return this.latLng;
    }

    public final float getTransparency() {
        return this.transparency;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor2) {
        this.bitmapDescriptor = bitmapDescriptor2;
        return this;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final GroundOverlayOptions position(LatLng latLng2, float f2) {
        if (this.latlngBounds != null) {
            Log.w(CLASSNAME, "Position has already been set using positionFromBounds");
        }
        if (latLng2 == null) {
            Log.w(CLASSNAME, "Location must be specified");
        }
        if (f2 <= 0.0f) {
            Log.w(CLASSNAME, "Width must be non-negative");
        }
        return a(latLng2, f2, f2);
    }

    public final GroundOverlayOptions position(LatLng latLng2, float f2, float f3) {
        if (this.latlngBounds != null) {
            Log.w(CLASSNAME, "Position has already been set using positionFromBounds");
        }
        if (latLng2 == null) {
            Log.w(CLASSNAME, "Location must be specified");
        }
        if (f2 <= 0.0f || f3 <= 0.0f) {
            Log.w(CLASSNAME, "Width and Height must be non-negative");
        }
        return a(latLng2, f2, f3);
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        this.latlngBounds = latLngBounds;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        a();
        return this;
    }

    public final GroundOverlayOptions transparency(float f2) {
        if (f2 < 0.0f) {
            Log.w(CLASSNAME, "Transparency must be in the range [0..1]");
            f2 = 0.0f;
        }
        this.transparency = f2;
        return this;
    }

    public final GroundOverlayOptions visible(boolean z2) {
        this.isVisible = z2;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeParcelable(this.bitmapDescriptor, i2);
        parcel.writeParcelable(this.latLng, i2);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        parcel.writeParcelable(this.latlngBounds, i2);
        parcel.writeFloat(this.bearing);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : 0);
        parcel.writeFloat(this.transparency);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
    }

    public final GroundOverlayOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }
}
