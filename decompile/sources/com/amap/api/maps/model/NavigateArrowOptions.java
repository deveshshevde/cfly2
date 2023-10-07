package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class NavigateArrowOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final NavigateArrowOptionsCreator CREATOR = new NavigateArrowOptionsCreator();

    /* renamed from: a  reason: collision with root package name */
    String f9750a;
    private int arrowLineInnerResId = 111;
    private int arrowLineOuterResId = AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID;
    private int arrowLineShadowResId = AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID;
    private boolean is3DModel = false;
    private boolean isVisible = true;
    private final List<LatLng> points = new ArrayList();
    private int sideColor = Color.argb(170, 0, 172, 146);
    private int topColor = Color.argb(221, 87, 235, 204);
    private float width = 10.0f;
    private float zIndex = 0.0f;

    public NavigateArrowOptions() {
        this.type = "NavigateArrowOptions";
    }

    public final NavigateArrowOptions add(LatLng latLng) {
        this.points.add(latLng);
        return this;
    }

    public final NavigateArrowOptions add(LatLng... latLngArr) {
        this.points.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public final NavigateArrowOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.points.add(add);
        }
        return this;
    }

    public final NavigateArrowOptions clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
        NavigateArrowOptions navigateArrowOptions = new NavigateArrowOptions();
        navigateArrowOptions.points.addAll(this.points);
        navigateArrowOptions.width = this.width;
        navigateArrowOptions.topColor = this.topColor;
        navigateArrowOptions.sideColor = this.sideColor;
        navigateArrowOptions.zIndex = this.zIndex;
        navigateArrowOptions.isVisible = this.isVisible;
        navigateArrowOptions.is3DModel = this.is3DModel;
        navigateArrowOptions.f9750a = this.f9750a;
        navigateArrowOptions.arrowLineInnerResId = this.arrowLineInnerResId;
        navigateArrowOptions.arrowLineOuterResId = this.arrowLineOuterResId;
        navigateArrowOptions.arrowLineShadowResId = this.arrowLineShadowResId;
        return navigateArrowOptions;
    }

    public final int describeContents() {
        return 0;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final int getSideColor() {
        return this.sideColor;
    }

    public final int getTopColor() {
        return this.topColor;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean is3DModel() {
        return this.is3DModel;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final NavigateArrowOptions set3DModel(boolean z2) {
        this.is3DModel = z2;
        return this;
    }

    public final void setPoints(List<LatLng> list) {
        List<LatLng> list2;
        if (list != null && (list2 = this.points) != list) {
            try {
                list2.clear();
                this.points.addAll(list);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final NavigateArrowOptions sideColor(int i2) {
        this.sideColor = i2;
        return this;
    }

    public final NavigateArrowOptions topColor(int i2) {
        this.topColor = i2;
        return this;
    }

    public final NavigateArrowOptions visible(boolean z2) {
        this.isVisible = z2;
        return this;
    }

    public final NavigateArrowOptions width(float f2) {
        this.width = f2;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.width);
        parcel.writeInt(this.topColor);
        parcel.writeInt(this.sideColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : 0);
        parcel.writeString(this.f9750a);
        parcel.writeByte(this.is3DModel ? (byte) 1 : 0);
    }

    public final NavigateArrowOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }
}
