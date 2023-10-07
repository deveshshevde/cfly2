package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore.util.de;
import com.amap.api.mapcore.util.dl;
import com.amap.api.mapcore.util.fz;
import fg.i;

public final class CameraPosition implements Parcelable {
    private static final String CLASSNAME = "CameraPosition";
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    public final boolean isAbroad;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private float bearing;
        private LatLng target;
        private float tilt;
        private float zoom;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }

        public final Builder bearing(float f2) {
            this.bearing = f2;
            return this;
        }

        public final CameraPosition build() {
            try {
                if (this.target != null) {
                    return new CameraPosition(this.target, this.zoom, this.tilt, this.bearing);
                }
                Log.w(CameraPosition.CLASSNAME, "target is null");
                return null;
            } catch (Throwable th) {
                fz.c(th, CameraPosition.CLASSNAME, "build");
                return null;
            }
        }

        public final Builder target(LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public final Builder tilt(float f2) {
            this.tilt = f2;
            return this;
        }

        public final Builder zoom(float f2) {
            this.zoom = f2;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f2, float f3, float f4) {
        if (latLng == null) {
            Log.w(CLASSNAME, "构建CameraPosition时,位置(target)不能为null");
        }
        this.target = latLng;
        this.zoom = f2;
        this.tilt = f3;
        this.bearing = (((double) f4) <= i.f27244a ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
        this.isAbroad = latLng != null ? !de.a(latLng.latitude, latLng.longitude) : false;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f2) {
        return new CameraPosition(latLng, f2, 0.0f, 0.0f);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return dl.a(dl.a("target", (Object) this.target), dl.a("zoom", (Object) Float.valueOf(this.zoom)), dl.a("tilt", (Object) Float.valueOf(this.tilt)), dl.a("bearing", (Object) Float.valueOf(this.bearing)));
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.bearing);
        parcel.writeFloat((float) this.target.latitude);
        parcel.writeFloat((float) this.target.longitude);
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }
}
