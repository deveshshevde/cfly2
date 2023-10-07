package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.util.a;
import java.util.ArrayList;
import java.util.List;

public final class MarkerOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();

    /* renamed from: a  reason: collision with root package name */
    String f9749a;
    private float alpha = 1.0f;
    private float anchorU = 0.5f;
    private float anchorV = 1.0f;
    private float angleOffset = 0.0f;
    private boolean autoOverturn = false;
    private List<BitmapDescriptor> bitmapDescriptors = new ArrayList();
    private int dispLevel = 5;
    private LatLng gpsLatLng;
    private boolean infoWindowEnabled = true;
    private boolean isBelowMaskLayer;
    private boolean isDraggable = false;
    private boolean isFlat = false;
    private boolean isGps = false;
    private boolean isRotatingMode = false;
    private boolean isViewMode = false;
    private boolean isVisible = true;
    private LatLng latLng;
    private int offsetX = 0;
    private int offsetY = 0;
    private int period = 20;
    private boolean perspective = false;
    private float rotate;
    private int screenX;
    private int screenY;
    private String snippet;
    private String title;
    private MarkerUpdateFlags updateFlags = new MarkerUpdateFlags();
    private float zIndex = 0.0f;

    protected static class MarkerUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean bitmapDescriptorsUpdate = false;
        protected boolean gpsLatLngUpdate = false;
        protected boolean latlngUpdate = false;

        protected MarkerUpdateFlags() {
        }

        public void reset() {
            super.reset();
            this.latlngUpdate = false;
            this.gpsLatLngUpdate = false;
            this.bitmapDescriptorsUpdate = false;
        }
    }

    public MarkerOptions() {
        this.type = "MarkerOptions";
    }

    private void a() {
        if (this.bitmapDescriptors == null) {
            try {
                this.bitmapDescriptors = new ArrayList();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void b() {
        LatLng latLng2;
        try {
            if (this.isGps && (latLng2 = this.latLng) != null) {
                double[] a2 = a.a(latLng2.longitude, this.latLng.latitude);
                this.gpsLatLng = new LatLng(a2[1], a2[0]);
                this.updateFlags.gpsLatLngUpdate = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final MarkerOptions alpha(float f2) {
        this.alpha = f2;
        return this;
    }

    public final MarkerOptions anchor(float f2, float f3) {
        this.anchorU = f2;
        this.anchorV = f3;
        return this;
    }

    /* access modifiers changed from: protected */
    public final MarkerOptions angleOffset(float f2) {
        this.angleOffset = f2;
        return this;
    }

    public final MarkerOptions autoOverturnInfoWindow(boolean z2) {
        this.autoOverturn = z2;
        return this;
    }

    public final MarkerOptions belowMaskLayer(boolean z2) {
        this.isBelowMaskLayer = z2;
        return this;
    }

    public final MarkerOptions clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.latLng = this.latLng;
        markerOptions.gpsLatLng = this.gpsLatLng;
        markerOptions.title = this.title;
        markerOptions.snippet = this.snippet;
        markerOptions.anchorU = this.anchorU;
        markerOptions.anchorV = this.anchorV;
        markerOptions.zIndex = this.zIndex;
        markerOptions.isDraggable = this.isDraggable;
        markerOptions.isVisible = this.isVisible;
        markerOptions.f9749a = this.f9749a;
        markerOptions.perspective = this.perspective;
        markerOptions.offsetX = this.offsetX;
        markerOptions.offsetY = this.offsetY;
        markerOptions.bitmapDescriptors = this.bitmapDescriptors;
        markerOptions.period = this.period;
        markerOptions.isGps = this.isGps;
        markerOptions.isFlat = this.isFlat;
        markerOptions.isRotatingMode = this.isRotatingMode;
        markerOptions.angleOffset = this.angleOffset;
        markerOptions.screenX = this.screenX;
        markerOptions.screenY = this.screenY;
        markerOptions.isViewMode = this.isViewMode;
        markerOptions.alpha = this.alpha;
        markerOptions.autoOverturn = this.autoOverturn;
        markerOptions.infoWindowEnabled = this.infoWindowEnabled;
        markerOptions.dispLevel = this.dispLevel;
        markerOptions.rotate = this.rotate;
        markerOptions.isBelowMaskLayer = this.isBelowMaskLayer;
        markerOptions.updateFlags = this.updateFlags;
        return markerOptions;
    }

    public final int describeContents() {
        return 0;
    }

    public final MarkerOptions displayLevel(int i2) {
        this.dispLevel = i2;
        return this;
    }

    public final MarkerOptions draggable(boolean z2) {
        this.isDraggable = z2;
        return this;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getAnchorU() {
        return this.anchorU;
    }

    public final float getAnchorV() {
        return this.anchorV;
    }

    public final float getAngleOffset() {
        return this.angleOffset;
    }

    public final int getDisplayLevel() {
        return this.dispLevel;
    }

    public final BitmapDescriptor getIcon() {
        List<BitmapDescriptor> list = this.bitmapDescriptors;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.bitmapDescriptors.get(0);
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        return (ArrayList) this.bitmapDescriptors;
    }

    public final int getInfoWindowOffsetX() {
        return this.offsetX;
    }

    public final int getInfoWindowOffsetY() {
        return this.offsetY;
    }

    public final int getPeriod() {
        return this.period;
    }

    public final LatLng getPosition() {
        return this.latLng;
    }

    public final float getRotateAngle() {
        return this.rotate;
    }

    /* access modifiers changed from: protected */
    public final int getScreenX() {
        return this.screenX;
    }

    /* access modifiers changed from: protected */
    public final int getScreenY() {
        return this.screenY;
    }

    public final String getSnippet() {
        return this.snippet;
    }

    public final String getTitle() {
        return this.title;
    }

    public final MarkerUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        try {
            a();
            this.bitmapDescriptors.clear();
            this.bitmapDescriptors.add(bitmapDescriptor);
            this.isRotatingMode = false;
            this.updateFlags.bitmapDescriptorsUpdate = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.bitmapDescriptors = arrayList;
            this.isRotatingMode = false;
            this.updateFlags.bitmapDescriptorsUpdate = true;
        }
        return this;
    }

    public final MarkerOptions infoWindowEnable(boolean z2) {
        this.infoWindowEnabled = z2;
        return this;
    }

    public final boolean isBelowMaskLayer() {
        return this.isBelowMaskLayer;
    }

    public final boolean isDraggable() {
        return this.isDraggable;
    }

    public final boolean isFlat() {
        return this.isFlat;
    }

    public final boolean isGps() {
        return this.isGps;
    }

    public final boolean isInfoWindowAutoOverturn() {
        return this.autoOverturn;
    }

    public final boolean isInfoWindowEnable() {
        return this.infoWindowEnabled;
    }

    public final boolean isPerspective() {
        return this.perspective;
    }

    public final boolean isRotatingMode() {
        return this.isRotatingMode;
    }

    /* access modifiers changed from: protected */
    public final boolean isViewMode() {
        return this.isViewMode;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final MarkerOptions period(int i2) {
        if (i2 <= 1) {
            this.period = 1;
        } else {
            this.period = i2;
        }
        return this;
    }

    public final MarkerOptions perspective(boolean z2) {
        this.perspective = z2;
        return this;
    }

    public final MarkerOptions position(LatLng latLng2) {
        this.latLng = latLng2;
        this.isViewMode = false;
        b();
        this.updateFlags.latlngUpdate = true;
        return this;
    }

    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final MarkerOptions rotateAngle(float f2) {
        this.rotate = f2;
        return this;
    }

    public final MarkerOptions rotatingIcons(ArrayList<BitmapDescriptor> arrayList, float f2) {
        if (arrayList != null && arrayList.size() > 0) {
            this.bitmapDescriptors = arrayList;
            if (f2 == 0.0f) {
                f2 = 360.0f / ((float) arrayList.size());
            }
            this.angleOffset = f2;
            this.isRotatingMode = true;
            this.updateFlags.bitmapDescriptorsUpdate = true;
        }
        return this;
    }

    public final MarkerOptions setFlat(boolean z2) {
        this.isFlat = z2;
        return this;
    }

    public final MarkerOptions setGps(boolean z2) {
        this.isGps = z2;
        b();
        return this;
    }

    public final MarkerOptions setInfoWindowOffset(int i2, int i3) {
        this.offsetX = i2;
        this.offsetY = i3;
        return this;
    }

    /* access modifiers changed from: protected */
    public final MarkerOptions setRotatingMode(boolean z2) {
        this.isRotatingMode = z2;
        return this;
    }

    /* access modifiers changed from: protected */
    public final void setScreenPosition(int i2, int i3) {
        this.screenX = i2;
        this.screenY = i3;
        this.isViewMode = true;
    }

    public final MarkerOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public final MarkerOptions title(String str) {
        this.title = str;
        return this;
    }

    public final MarkerOptions visible(boolean z2) {
        this.isVisible = z2;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.latLng, i2);
        parcel.writeString(this.title);
        parcel.writeString(this.snippet);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
        parcel.writeInt(this.offsetX);
        parcel.writeInt(this.offsetY);
        parcel.writeBooleanArray(new boolean[]{this.isVisible, this.isDraggable, this.isGps, this.isFlat, this.autoOverturn, this.infoWindowEnabled, this.isBelowMaskLayer, this.isRotatingMode});
        parcel.writeString(this.f9749a);
        parcel.writeInt(this.period);
        parcel.writeList(this.bitmapDescriptors);
        parcel.writeFloat(this.zIndex);
        parcel.writeFloat(this.alpha);
        parcel.writeInt(this.dispLevel);
        parcel.writeFloat(this.rotate);
        parcel.writeFloat(this.angleOffset);
        parcel.writeInt(this.screenX);
        parcel.writeInt(this.screenY);
        List<BitmapDescriptor> list = this.bitmapDescriptors;
        if (list != null && list.size() != 0) {
            parcel.writeParcelable(this.bitmapDescriptors.get(0), i2);
        }
    }

    public final MarkerOptions zIndex(float f2) {
        if (this.zIndex != f2) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f2;
        return this;
    }
}
