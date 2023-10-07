package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions extends BaseOptions implements Parcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    /* renamed from: a  reason: collision with root package name */
    String f9752a;
    private int color = -16777216;
    private List<Integer> colorValues;
    private List<Integer> customIndexs;
    private BitmapDescriptor customTexture;
    private List<BitmapDescriptor> customTextureList;
    private int dottedLineType = 0;
    private int eraseColor = -7829368;
    private BitmapDescriptor eraseTexture;
    private boolean eraseVisible = false;
    private float footPrintGap = 0.0f;
    private BitmapDescriptor footPrintTexture;
    private boolean isAboveMaskLayer = false;
    private boolean isDottedLine = false;
    private boolean isGeodesic = false;
    private boolean isGradient = false;
    private boolean isUseTexture = true;
    private boolean isVisible = true;
    private int[] jniColorValues;
    private int[] jniCustomIndexes;
    private LineCapType lineCapType = LineCapType.LineCapRound;
    private LineJoinType lineJoinType = LineJoinType.LineJoinBevel;
    private int nLineCapType = 3;
    private int nLineJoinType = 0;
    private final List<LatLng> points = new ArrayList();
    private boolean showPolylineRangeEnable = false;
    private float shownPolylineRangeBegin = 0.0f;
    private float shownPolylineRangeEnd = 0.0f;
    private float shownRangeBegin = -1.0f;
    private float shownRangeEnd = -1.0f;
    private float shownRatio = -1.0f;
    private float transparency = 1.0f;
    private PolylineUpdateFlags updateFlags = new PolylineUpdateFlags();
    private float width = 10.0f;
    private float zIndex = 0.0f;

    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);
        
        private int type;

        private LineCapType(int i2) {
            this.type = i2;
        }

        public static LineCapType valueOf(int i2) {
            LineCapType[] values = values();
            return values[Math.max(0, Math.min(i2, values.length))];
        }

        public final int getTypeValue() {
            return this.type;
        }
    }

    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);
        
        private int type;

        private LineJoinType(int i2) {
            this.type = i2;
        }

        public static LineJoinType valueOf(int i2) {
            LineJoinType[] values = values();
            return values[Math.max(0, Math.min(i2, values.length))];
        }

        public final int getTypeValue() {
            return this.type;
        }
    }

    protected static class PolylineUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean eraseUpdate = false;
        protected boolean footPrintBDUpdate = false;
        protected boolean isColorValuesUpdated = false;
        protected boolean isCustomIndexesUpdated = false;
        protected boolean isCustomTextureListUpdated = false;
        protected boolean isPointsUpdated = false;

        protected PolylineUpdateFlags() {
        }

        public void reset() {
            super.reset();
            this.isPointsUpdated = false;
            this.isCustomIndexesUpdated = false;
            this.isCustomTextureListUpdated = false;
            this.isColorValuesUpdated = false;
            this.footPrintBDUpdate = false;
            this.eraseUpdate = false;
        }
    }

    public PolylineOptions() {
        this.type = "PolylineOptions";
    }

    public final PolylineOptions aboveMaskLayer(boolean z2) {
        this.isAboveMaskLayer = z2;
        return this;
    }

    public final PolylineOptions add(LatLng latLng) {
        if (latLng != null) {
            try {
                this.points.add(latLng);
                this.updateFlags.isPointsUpdated = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final PolylineOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            try {
                this.points.addAll(Arrays.asList(latLngArr));
                this.updateFlags.isPointsUpdated = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final PolylineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                for (LatLng add : iterable) {
                    this.points.add(add);
                }
                this.updateFlags.isPointsUpdated = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final PolylineOptions color(int i2) {
        this.color = i2;
        return this;
    }

    public final PolylineOptions colorValues(List<Integer> list) {
        try {
            this.colorValues = list;
            this.jniColorValues = new int[list.size()];
            int i2 = 0;
            while (true) {
                int[] iArr = this.jniColorValues;
                if (i2 >= iArr.length) {
                    break;
                }
                iArr[i2] = list.get(i2).intValue();
                i2++;
            }
            this.updateFlags.isColorValuesUpdated = true;
        } catch (Throwable unused) {
        }
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final PolylineOptions geodesic(boolean z2) {
        this.isGeodesic = z2;
        return this;
    }

    public final int getColor() {
        return this.color;
    }

    public final List<Integer> getColorValues() {
        return this.colorValues;
    }

    public final BitmapDescriptor getCustomTexture() {
        return this.customTexture;
    }

    public final List<Integer> getCustomTextureIndex() {
        return this.customIndexs;
    }

    public final List<BitmapDescriptor> getCustomTextureList() {
        return this.customTextureList;
    }

    public final int getDottedLineType() {
        return this.dottedLineType;
    }

    public final int getEraseColor() {
        return this.eraseColor;
    }

    public final BitmapDescriptor getEraseTexture() {
        return this.eraseTexture;
    }

    public final boolean getEraseVisible() {
        return this.eraseVisible;
    }

    public final float getFootPrintGap() {
        return this.footPrintGap;
    }

    public final BitmapDescriptor getFootPrintTexture() {
        return this.footPrintTexture;
    }

    public final LineCapType getLineCapType() {
        return this.lineCapType;
    }

    public final LineJoinType getLineJoinType() {
        return this.lineJoinType;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final float getPolylineShownRangeBegin() {
        return this.shownPolylineRangeBegin;
    }

    public final float getPolylineShownRangeEnd() {
        return this.shownPolylineRangeEnd;
    }

    public final float getShownRangeBegin() {
        return this.shownRangeBegin;
    }

    public final float getShownRangeEnd() {
        return this.shownRangeEnd;
    }

    public final float getShownRatio() {
        return this.shownRatio;
    }

    public final float getTransparency() {
        return this.transparency;
    }

    public final PolylineUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isAboveMaskLayer() {
        return this.isAboveMaskLayer;
    }

    public final boolean isDottedLine() {
        return this.isDottedLine;
    }

    public final boolean isGeodesic() {
        return this.isGeodesic;
    }

    public final boolean isShowPolylineRangeEnable() {
        return this.showPolylineRangeEnable;
    }

    public final boolean isUseGradient() {
        return this.isGradient;
    }

    public final boolean isUseTexture() {
        return this.isUseTexture;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final PolylineOptions lineCapType(LineCapType lineCapType2) {
        if (lineCapType2 != null) {
            this.lineCapType = lineCapType2;
            this.nLineCapType = lineCapType2.getTypeValue();
        }
        return this;
    }

    public final PolylineOptions lineJoinType(LineJoinType lineJoinType2) {
        if (lineJoinType2 != null) {
            this.lineJoinType = lineJoinType2;
            this.nLineJoinType = lineJoinType2.getTypeValue();
        }
        return this;
    }

    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final PolylineOptions setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        this.customTexture = bitmapDescriptor;
        return this;
    }

    public final PolylineOptions setCustomTextureIndex(List<Integer> list) {
        try {
            this.customIndexs = list;
            this.jniCustomIndexes = new int[list.size()];
            int i2 = 0;
            while (true) {
                int[] iArr = this.jniCustomIndexes;
                if (i2 >= iArr.length) {
                    break;
                }
                iArr[i2] = list.get(i2).intValue();
                i2++;
            }
            this.updateFlags.isCustomIndexesUpdated = true;
            this.updateFlags.isCustomTextureListUpdated = true;
        } catch (Throwable unused) {
        }
        return this;
    }

    public final PolylineOptions setCustomTextureList(List<BitmapDescriptor> list) {
        this.customTextureList = list;
        this.updateFlags.isCustomTextureListUpdated = true;
        this.updateFlags.isCustomIndexesUpdated = true;
        return this;
    }

    public final PolylineOptions setDottedLine(boolean z2) {
        this.isDottedLine = z2;
        return this;
    }

    public final PolylineOptions setDottedLineType(int i2) {
        this.dottedLineType = i2 == 0 ? 0 : 1;
        return this;
    }

    public final PolylineOptions setEraseColor(boolean z2, int i2) {
        this.eraseVisible = z2;
        this.eraseColor = i2;
        this.updateFlags.eraseUpdate = true;
        return this;
    }

    public final PolylineOptions setEraseTexture(boolean z2, BitmapDescriptor bitmapDescriptor) {
        this.eraseVisible = z2;
        this.eraseTexture = bitmapDescriptor;
        this.updateFlags.eraseUpdate = true;
        return this;
    }

    public final PolylineOptions setFootPrintGap(float f2) {
        this.footPrintGap = f2;
        return this;
    }

    public final PolylineOptions setFootPrintTexture(BitmapDescriptor bitmapDescriptor) {
        this.footPrintTexture = bitmapDescriptor;
        this.updateFlags.footPrintBDUpdate = true;
        return this;
    }

    public final void setPoints(List<LatLng> list) {
        List<LatLng> list2;
        if (list != null && (list2 = this.points) != list) {
            try {
                list2.clear();
                this.points.addAll(list);
                this.updateFlags.isPointsUpdated = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final PolylineOptions setPolylineShowRange(float f2, float f3) {
        this.shownPolylineRangeBegin = f2;
        this.shownPolylineRangeEnd = f3;
        return this;
    }

    public final PolylineOptions setShownRange(float f2, float f3) {
        this.shownRangeBegin = f2;
        this.shownRangeEnd = f3;
        showPolylineRangeEnabled(true);
        setPolylineShowRange(f2, f3);
        return this;
    }

    public final PolylineOptions setShownRatio(float f2) {
        this.shownRatio = f2;
        setPolylineShowRange(0.0f, f2);
        showPolylineRangeEnabled(true);
        return this;
    }

    public final PolylineOptions setUseTexture(boolean z2) {
        this.isUseTexture = z2;
        return this;
    }

    public final PolylineOptions showPolylineRangeEnabled(boolean z2) {
        this.showPolylineRangeEnable = z2;
        return this;
    }

    public final PolylineOptions transparency(float f2) {
        this.transparency = f2;
        return this;
    }

    public final PolylineOptions useGradient(boolean z2) {
        this.isGradient = z2;
        return this;
    }

    public final PolylineOptions visible(boolean z2) {
        this.isVisible = z2;
        return this;
    }

    public final PolylineOptions width(float f2) {
        this.width = f2;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.width);
        parcel.writeInt(this.color);
        parcel.writeInt(this.dottedLineType);
        parcel.writeFloat(this.zIndex);
        parcel.writeFloat(this.transparency);
        parcel.writeString(this.f9752a);
        parcel.writeInt(this.lineCapType.getTypeValue());
        parcel.writeInt(this.lineJoinType.getTypeValue());
        parcel.writeBooleanArray(new boolean[]{this.isVisible, this.isDottedLine, this.isGeodesic, this.isGradient, this.isAboveMaskLayer});
        BitmapDescriptor bitmapDescriptor = this.customTexture;
        if (bitmapDescriptor != null) {
            parcel.writeParcelable(bitmapDescriptor, i2);
        }
        List<BitmapDescriptor> list = this.customTextureList;
        if (list != null) {
            parcel.writeList(list);
        }
        List<Integer> list2 = this.customIndexs;
        if (list2 != null) {
            parcel.writeList(list2);
        }
        List<Integer> list3 = this.colorValues;
        if (list3 != null) {
            parcel.writeList(list3);
        }
        parcel.writeFloat(this.shownRatio);
    }

    public final PolylineOptions zIndex(float f2) {
        if (this.zIndex != f2) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f2;
        return this;
    }
}
