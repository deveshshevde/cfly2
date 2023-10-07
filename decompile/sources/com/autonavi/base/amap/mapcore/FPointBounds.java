package com.autonavi.base.amap.mapcore;

public class FPointBounds {
    private final int mVersionCode;
    public final FPoint northeast;
    public final FPoint southwest;

    public static final class Builder {
        private float mEast = Float.NEGATIVE_INFINITY;
        private float mNorth = Float.NEGATIVE_INFINITY;
        private float mSouth = Float.POSITIVE_INFINITY;
        private float mWest = Float.POSITIVE_INFINITY;

        private boolean containsx(double d2) {
            float f2 = this.mWest;
            float f3 = this.mEast;
            return f2 <= f3 ? ((double) f2) <= d2 && d2 <= ((double) f3) : ((double) f2) <= d2 || d2 <= ((double) f3);
        }

        public final FPointBounds build() {
            return new FPointBounds(FPoint.obtain(this.mWest, this.mSouth), FPoint.obtain(this.mEast, this.mNorth));
        }

        public final Builder include(FPoint fPoint) {
            this.mSouth = Math.min(this.mSouth, fPoint.y);
            this.mNorth = Math.max(this.mNorth, fPoint.y);
            this.mWest = Math.min(this.mWest, fPoint.x);
            this.mEast = Math.max(this.mEast, fPoint.x);
            return this;
        }
    }

    FPointBounds(int i2, FPoint fPoint, FPoint fPoint2) {
        this.mVersionCode = i2;
        this.southwest = fPoint;
        this.northeast = fPoint2;
    }

    public FPointBounds(FPoint fPoint, FPoint fPoint2) {
        this(1, fPoint, fPoint2);
    }

    public static Builder builder() {
        return new Builder();
    }

    private boolean containsx(double d2) {
        return this.southwest.x <= this.northeast.x ? ((double) this.southwest.x) <= d2 && d2 <= ((double) this.northeast.x) : ((double) this.southwest.x) <= d2 || d2 <= ((double) this.northeast.x);
    }

    private boolean containsy(double d2) {
        return ((double) this.southwest.y) <= d2 && d2 <= ((double) this.northeast.y);
    }

    private boolean intersect(FPointBounds fPointBounds) {
        FPoint fPoint;
        if (!(fPointBounds == null || (fPoint = fPointBounds.northeast) == null || fPointBounds.southwest == null || this.northeast == null || this.southwest == null)) {
            return Math.abs((double) (((fPoint.x + fPointBounds.southwest.x) - this.northeast.x) - this.southwest.x)) < ((double) (((this.northeast.x - this.southwest.x) + fPointBounds.northeast.x) - this.southwest.x)) && Math.abs((double) (((fPointBounds.northeast.y + fPointBounds.southwest.y) - this.northeast.y) - this.southwest.y)) < ((double) (((this.northeast.y - this.southwest.y) + fPointBounds.northeast.y) - fPointBounds.southwest.y));
        }
    }

    public boolean contains(FPoint fPoint) {
        return containsy((double) fPoint.y) && containsx((double) fPoint.x);
    }

    public boolean contains(FPointBounds fPointBounds) {
        return fPointBounds != null && contains(fPointBounds.southwest) && contains(fPointBounds.northeast);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FPointBounds)) {
            return false;
        }
        FPointBounds fPointBounds = (FPointBounds) obj;
        return this.southwest.equals(fPointBounds.southwest) && this.northeast.equals(fPointBounds.northeast);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean intersects(FPointBounds fPointBounds) {
        if (fPointBounds == null) {
            return false;
        }
        return intersect(fPointBounds) || fPointBounds.intersect(this);
    }

    public String toString() {
        return "southwest = (" + this.southwest.x + "," + this.southwest.y + ") northeast = (" + this.northeast.x + "," + this.northeast.y + ")";
    }
}
