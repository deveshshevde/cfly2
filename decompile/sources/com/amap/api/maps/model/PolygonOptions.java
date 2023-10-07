package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.AMapPara;
import com.amap.api.maps.model.BaseOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();

    /* renamed from: a  reason: collision with root package name */
    String f9751a;
    private int fillColor = -16777216;
    private List<BaseHoleOptions> holeOptions = new ArrayList();
    private boolean isUsePolylineStroke = true;
    private boolean isVisible = true;
    private AMapPara.LineJoinType lineJoinType = AMapPara.LineJoinType.LineJoinBevel;
    private int nLineCapType = 3;
    private int nLineJoinType = 0;
    private final List<LatLng> points = new ArrayList();
    private int strokeColor = -16777216;
    private float strokeWidth = 10.0f;
    private PolygonUpdateFlags updateFlags = new PolygonUpdateFlags();
    private float zIndex = 0.0f;

    protected static class PolygonUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean isHoleOptionsUpdated = false;
        protected boolean isPointsUpdated = false;

        protected PolygonUpdateFlags() {
        }

        public void reset() {
            super.reset();
            this.isPointsUpdated = false;
            this.isHoleOptionsUpdated = false;
        }
    }

    public PolygonOptions() {
        this.type = "PolygonOptions";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amap.api.maps.model.CircleHoleOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amap.api.maps.model.PolygonHoleOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.amap.api.maps.model.CircleHoleOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.amap.api.maps.model.CircleHoleOptions} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r5 = this;
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r0 = r5.holeOptions
            if (r0 == 0) goto L_0x005a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r1 = r5.holeOptions
            r2 = 0
        L_0x000c:
            int r3 = r1.size()
            if (r2 >= r3) goto L_0x004b
            java.lang.Object r3 = r1.get(r2)
            com.amap.api.maps.model.BaseHoleOptions r3 = (com.amap.api.maps.model.BaseHoleOptions) r3
            boolean r4 = r3 instanceof com.amap.api.maps.model.PolygonHoleOptions
            if (r4 == 0) goto L_0x002f
            com.amap.api.maps.model.PolygonHoleOptions r3 = (com.amap.api.maps.model.PolygonHoleOptions) r3
            java.util.List r4 = r5.getPoints()
            boolean r4 = com.amap.api.mapcore.util.dl.b((java.util.List<com.amap.api.maps.model.LatLng>) r4, (com.amap.api.maps.model.PolygonHoleOptions) r3)
            if (r4 == 0) goto L_0x0048
            boolean r4 = com.amap.api.mapcore.util.dl.a((java.util.List<com.amap.api.maps.model.BaseHoleOptions>) r0, (com.amap.api.maps.model.PolygonHoleOptions) r3)
            if (r4 != 0) goto L_0x0048
            goto L_0x0045
        L_0x002f:
            boolean r4 = r3 instanceof com.amap.api.maps.model.CircleHoleOptions
            if (r4 == 0) goto L_0x0048
            com.amap.api.maps.model.CircleHoleOptions r3 = (com.amap.api.maps.model.CircleHoleOptions) r3
            java.util.List r4 = r5.getPoints()
            boolean r4 = com.amap.api.mapcore.util.dl.a((java.util.List<com.amap.api.maps.model.LatLng>) r4, (java.util.List<com.amap.api.maps.model.BaseHoleOptions>) r0, (com.amap.api.maps.model.CircleHoleOptions) r3)
            if (r4 == 0) goto L_0x0048
            boolean r4 = com.amap.api.mapcore.util.dl.a((java.util.List<com.amap.api.maps.model.BaseHoleOptions>) r0, (com.amap.api.maps.model.CircleHoleOptions) r3)
            if (r4 != 0) goto L_0x0048
        L_0x0045:
            r0.add(r3)
        L_0x0048:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x004b:
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r1 = r5.holeOptions
            r1.clear()
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r1 = r5.holeOptions
            r1.addAll(r0)
            com.amap.api.maps.model.PolygonOptions$PolygonUpdateFlags r0 = r5.updateFlags
            r1 = 1
            r0.isHoleOptionsUpdated = r1
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.PolygonOptions.a():void");
    }

    public final PolygonOptions add(LatLng latLng) {
        try {
            this.points.add(latLng);
            this.updateFlags.isPointsUpdated = true;
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            try {
                this.points.addAll(Arrays.asList(latLngArr));
                this.updateFlags.isPointsUpdated = true;
                a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                for (LatLng add : iterable) {
                    this.points.add(add);
                }
                a();
                this.updateFlags.isPointsUpdated = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final PolygonOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        if (iterable == null) {
            return this;
        }
        try {
            for (BaseHoleOptions add : iterable) {
                this.holeOptions.add(add);
            }
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final PolygonOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        if (baseHoleOptionsArr == null) {
            return this;
        }
        try {
            this.holeOptions.addAll(Arrays.asList(baseHoleOptionsArr));
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final PolygonOptions clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.points.addAll(this.points);
        polygonOptions.strokeWidth = this.strokeWidth;
        polygonOptions.strokeColor = this.strokeColor;
        polygonOptions.fillColor = this.fillColor;
        polygonOptions.zIndex = this.zIndex;
        polygonOptions.isVisible = this.isVisible;
        polygonOptions.holeOptions = this.holeOptions;
        polygonOptions.f9751a = this.f9751a;
        polygonOptions.isUsePolylineStroke = this.isUsePolylineStroke;
        polygonOptions.lineJoinType = this.lineJoinType;
        polygonOptions.nLineCapType = this.nLineCapType;
        polygonOptions.nLineJoinType = this.nLineJoinType;
        polygonOptions.updateFlags = this.updateFlags;
        return polygonOptions;
    }

    public final int describeContents() {
        return 0;
    }

    public final PolygonOptions fillColor(int i2) {
        this.fillColor = i2;
        return this;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public final AMapPara.LineJoinType getLineJoinType() {
        return this.lineJoinType;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final PolygonUpdateFlags getUpdateFlags() {
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

    public final PolygonOptions lineJoinType(AMapPara.LineJoinType lineJoinType2) {
        if (lineJoinType2 != null) {
            this.lineJoinType = lineJoinType2;
            this.nLineJoinType = lineJoinType2.getTypeValue();
        }
        return this;
    }

    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.holeOptions.clear();
            if (list != null) {
                this.holeOptions.addAll(list);
            }
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPoints(List<LatLng> list) {
        try {
            this.points.clear();
            if (list != null) {
                this.points.addAll(list);
                a();
                this.updateFlags.isPointsUpdated = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final PolygonOptions strokeColor(int i2) {
        this.strokeColor = i2;
        return this;
    }

    public final PolygonOptions strokeWidth(float f2) {
        this.strokeWidth = f2;
        return this;
    }

    public final PolygonOptions usePolylineStroke(boolean z2) {
        this.isUsePolylineStroke = z2;
        return this;
    }

    public final PolygonOptions visible(boolean z2) {
        this.isVisible = z2;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : 0);
        parcel.writeString(this.f9751a);
        parcel.writeList(this.holeOptions);
        parcel.writeInt(this.lineJoinType.getTypeValue());
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : 0);
    }

    public final PolygonOptions zIndex(float f2) {
        float f3 = this.zIndex;
        if (f3 != f3) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f2;
        return this;
    }
}
