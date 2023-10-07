package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import fg.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CircleOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();

    /* renamed from: a  reason: collision with root package name */
    String f9734a;
    private int dottedLineType = -1;
    private int fillColor = 0;
    private List<BaseHoleOptions> holeOptions = new ArrayList();
    private boolean isUsePolylineStroke = true;
    private boolean isVisible = true;
    private LatLng point = null;
    private double radius = i.f27244a;
    private int strokeColor = -16777216;
    private float strokeWidth = 10.0f;
    private CircleUpdateFlags updateFlags = new CircleUpdateFlags();
    private float zIndex = 0.0f;

    protected static class CircleUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean isCenterUpdated = false;
        protected boolean isHoleOptionsUpdated = false;
        protected boolean isRadiusUpdated = false;

        protected CircleUpdateFlags() {
        }

        public void reset() {
            super.reset();
            this.isCenterUpdated = false;
            this.isRadiusUpdated = false;
            this.isHoleOptionsUpdated = false;
        }
    }

    public CircleOptions() {
        this.type = "CircleOptions";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amap.api.maps.model.CircleHoleOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amap.api.maps.model.PolygonHoleOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.amap.api.maps.model.CircleHoleOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.amap.api.maps.model.CircleHoleOptions} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r7 = this;
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r0 = r7.holeOptions
            if (r0 == 0) goto L_0x0062
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r1 = r7.holeOptions
            r2 = 0
        L_0x000c:
            int r3 = r1.size()
            if (r2 >= r3) goto L_0x0053
            java.lang.Object r3 = r1.get(r2)
            com.amap.api.maps.model.BaseHoleOptions r3 = (com.amap.api.maps.model.BaseHoleOptions) r3
            boolean r4 = r3 instanceof com.amap.api.maps.model.PolygonHoleOptions
            if (r4 == 0) goto L_0x0033
            com.amap.api.maps.model.PolygonHoleOptions r3 = (com.amap.api.maps.model.PolygonHoleOptions) r3
            double r4 = r7.getRadius()
            com.amap.api.maps.model.LatLng r6 = r7.getCenter()
            boolean r4 = com.amap.api.mapcore.util.dl.a((double) r4, (com.amap.api.maps.model.LatLng) r6, (java.util.List<com.amap.api.maps.model.BaseHoleOptions>) r0, (com.amap.api.maps.model.PolygonHoleOptions) r3)
            if (r4 == 0) goto L_0x0050
            boolean r4 = com.amap.api.mapcore.util.dl.a((java.util.List<com.amap.api.maps.model.BaseHoleOptions>) r0, (com.amap.api.maps.model.PolygonHoleOptions) r3)
            if (r4 != 0) goto L_0x0050
            goto L_0x004d
        L_0x0033:
            boolean r4 = r3 instanceof com.amap.api.maps.model.CircleHoleOptions
            if (r4 == 0) goto L_0x0050
            com.amap.api.maps.model.CircleHoleOptions r3 = (com.amap.api.maps.model.CircleHoleOptions) r3
            double r4 = r7.getRadius()
            com.amap.api.maps.model.LatLng r6 = r7.getCenter()
            boolean r4 = com.amap.api.mapcore.util.dl.a((double) r4, (com.amap.api.maps.model.LatLng) r6, (com.amap.api.maps.model.CircleHoleOptions) r3)
            if (r4 == 0) goto L_0x0050
            boolean r4 = com.amap.api.mapcore.util.dl.a((java.util.List<com.amap.api.maps.model.BaseHoleOptions>) r0, (com.amap.api.maps.model.CircleHoleOptions) r3)
            if (r4 != 0) goto L_0x0050
        L_0x004d:
            r0.add(r3)
        L_0x0050:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0053:
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r1 = r7.holeOptions
            r1.clear()
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r1 = r7.holeOptions
            r1.addAll(r0)
            com.amap.api.maps.model.CircleOptions$CircleUpdateFlags r0 = r7.updateFlags
            r1 = 1
            r0.isHoleOptionsUpdated = r1
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.CircleOptions.a():void");
    }

    public final CircleOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        if (iterable != null) {
            try {
                for (BaseHoleOptions add : iterable) {
                    this.holeOptions.add(add);
                }
                a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final CircleOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        if (baseHoleOptionsArr != null) {
            try {
                this.holeOptions.addAll(Arrays.asList(baseHoleOptionsArr));
                a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final CircleOptions center(LatLng latLng) {
        this.point = latLng;
        this.updateFlags.isCenterUpdated = true;
        a();
        return this;
    }

    public final CircleOptions clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.f9734a = this.f9734a;
        circleOptions.point = this.point;
        circleOptions.radius = this.radius;
        circleOptions.strokeWidth = this.strokeWidth;
        circleOptions.strokeColor = this.strokeColor;
        circleOptions.fillColor = this.fillColor;
        circleOptions.zIndex = this.zIndex;
        circleOptions.isVisible = this.isVisible;
        circleOptions.holeOptions = this.holeOptions;
        circleOptions.dottedLineType = this.dottedLineType;
        circleOptions.isUsePolylineStroke = this.isUsePolylineStroke;
        circleOptions.updateFlags = this.updateFlags;
        return circleOptions;
    }

    public final int describeContents() {
        return 0;
    }

    public final CircleOptions fillColor(int i2) {
        this.fillColor = i2;
        return this;
    }

    public final LatLng getCenter() {
        return this.point;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public final double getRadius() {
        return this.radius;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeDottedLineType() {
        return this.dottedLineType;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    /* access modifiers changed from: protected */
    public final CircleUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isUsePolylineStroke() {
        return this.isUsePolylineStroke;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final CircleOptions radius(double d2) {
        this.radius = d2;
        this.updateFlags.isRadiusUpdated = true;
        a();
        return this;
    }

    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final CircleOptions setStrokeDottedLineType(int i2) {
        this.dottedLineType = i2;
        return this;
    }

    public final CircleOptions strokeColor(int i2) {
        this.strokeColor = i2;
        return this;
    }

    public final CircleOptions strokeWidth(float f2) {
        this.strokeWidth = f2;
        return this;
    }

    public final CircleOptions usePolylineStroke(boolean z2) {
        this.isUsePolylineStroke = z2;
        return this;
    }

    public final CircleOptions visible(boolean z2) {
        this.isVisible = z2;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : 0);
        parcel.writeString(this.f9734a);
        parcel.writeList(this.holeOptions);
        parcel.writeInt(this.dottedLineType);
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : 0);
    }

    public final CircleOptions zIndex(float f2) {
        if (this.zIndex != f2) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f2;
        return this;
    }
}
