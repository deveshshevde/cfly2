package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore.util.dl;

public final class LatLngBounds implements Parcelable {
    private static final String CLASSNAME = "LatLngBounds";
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double mEast = Double.NaN;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mWest = Double.NaN;

        private boolean a(double d2) {
            double d3 = this.mWest;
            double d4 = this.mEast;
            return d3 <= d4 ? d3 <= d2 && d2 <= d4 : d3 <= d2 || d2 <= d4;
        }

        public final LatLngBounds build() {
            if (Double.isNaN(this.mWest)) {
                Log.w(LatLngBounds.CLASSNAME, "no included points");
                return null;
            }
            double d2 = this.mWest;
            double d3 = this.mEast;
            if (d2 > d3) {
                this.mWest = d3;
                this.mEast = d2;
            }
            double d4 = this.mSouth;
            double d5 = this.mNorth;
            if (d4 > d5) {
                this.mSouth = d5;
                this.mNorth = d4;
            }
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
        }

        public final Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.mSouth = Math.min(this.mSouth, latLng.latitude);
            this.mNorth = Math.max(this.mNorth, latLng.latitude);
            double d2 = latLng.longitude;
            if (Double.isNaN(this.mWest)) {
                this.mWest = d2;
            } else {
                if (!a(d2)) {
                    if (LatLngBounds.c(this.mWest, d2) < LatLngBounds.d(this.mEast, d2)) {
                        this.mWest = d2;
                    }
                }
                return this;
            }
            this.mEast = d2;
            return this;
        }
    }

    LatLngBounds(int i2, LatLng latLng, LatLng latLng2) {
        boolean z2;
        if (latLng == null) {
            throw new RuntimeRemoteException("null southwest");
        } else if (latLng2 != null) {
            try {
                if (latLng2.latitude >= latLng.latitude) {
                    z2 = true;
                    this.mVersionCode = !z2 ? 0 : i2;
                    this.southwest = !z2 ? null : latLng;
                    this.northeast = !z2 ? null : latLng2;
                    return;
                }
                throw new RuntimeRemoteException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
            } catch (Throwable th) {
                Log.e(CLASSNAME, "the structure parameters are illegal!");
                th.printStackTrace();
                z2 = false;
            }
        } else {
            throw new RuntimeRemoteException("null northeast");
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    private boolean a(double d2) {
        return this.southwest.latitude <= d2 && d2 <= this.northeast.latitude;
    }

    private boolean a(LatLngBounds latLngBounds) {
        LatLng latLng;
        if (!(latLngBounds == null || (latLng = latLngBounds.northeast) == null || latLngBounds.southwest == null)) {
            return Math.abs(((latLng.longitude + latLngBounds.southwest.longitude) - this.northeast.longitude) - this.southwest.longitude) < ((this.northeast.longitude - this.southwest.longitude) + latLngBounds.northeast.longitude) - this.southwest.longitude && Math.abs(((latLngBounds.northeast.latitude + latLngBounds.southwest.latitude) - this.northeast.latitude) - this.southwest.latitude) < ((this.northeast.latitude - this.southwest.latitude) + latLngBounds.northeast.latitude) - latLngBounds.southwest.latitude;
        }
    }

    private boolean b(double d2) {
        int i2 = (this.southwest.longitude > this.northeast.longitude ? 1 : (this.southwest.longitude == this.northeast.longitude ? 0 : -1));
        int i3 = (this.southwest.longitude > d2 ? 1 : (this.southwest.longitude == d2 ? 0 : -1));
        return i2 <= 0 ? i3 <= 0 && d2 <= this.northeast.longitude : i3 <= 0 || d2 <= this.northeast.longitude;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    public static double c(double d2, double d3) {
        return ((d2 - d3) + 360.0d) % 360.0d;
    }

    /* access modifiers changed from: private */
    public static double d(double d2, double d3) {
        return ((d3 - d2) + 360.0d) % 360.0d;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.mVersionCode;
    }

    public final boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        if (this.northeast != null && this.southwest != null) {
            return a(latLng.latitude) && b(latLng.longitude);
        }
        Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
        return false;
    }

    public final boolean contains(LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final int hashCode() {
        return dl.a(new Object[]{this.southwest, this.northeast});
    }

    public final LatLngBounds including(LatLng latLng) {
        LatLng latLng2;
        double d2;
        LatLng latLng3 = latLng;
        if (latLng3 == null) {
            return this;
        }
        if (this.northeast == null || (latLng2 = this.southwest) == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return this;
        }
        double min = Math.min(latLng2.latitude, latLng3.latitude);
        double max = Math.max(this.northeast.latitude, latLng3.latitude);
        double d3 = this.northeast.longitude;
        double d4 = this.southwest.longitude;
        double d5 = latLng3.longitude;
        if (!b(d5)) {
            if (c(d4, d5) < d(d3, d5)) {
                d4 = d5;
            } else {
                d2 = d5;
                return new LatLngBounds(new LatLng(min, d4, false), new LatLng(max, d2, false));
            }
        }
        d2 = d3;
        try {
            return new LatLngBounds(new LatLng(min, d4, false), new LatLng(max, d2, false));
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    public final boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (this.northeast != null && this.southwest != null) {
            return a(latLngBounds) || latLngBounds.a(this);
        }
        Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
        return false;
    }

    public final String toString() {
        return dl.a(dl.a("southwest", (Object) this.southwest), dl.a("northeast", (Object) this.northeast));
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        LatLngBoundsCreator.a(this, parcel, i2);
    }
}
