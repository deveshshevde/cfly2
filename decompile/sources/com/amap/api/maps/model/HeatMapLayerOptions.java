package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import fg.i;
import java.util.ArrayList;
import java.util.Collection;

public class HeatMapLayerOptions extends BaseOptions {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    public static final int TYPE_GRID = 1;
    public static final int TYPE_HEXAGON = 2;
    public static final int TYPE_NORMAL = 0;
    private boolean isPointsUpdated = false;
    private boolean isVisible = true;
    private int[] mColors;
    private Collection<WeightedLatLng> mData;
    private float mGap = 0.0f;
    private Gradient mGradient = DEFAULT_GRADIENT;
    private double mLatitude;
    private float mOpacity = 1.0f;
    private float mSize = 2000.0f;
    private float[] mStartPoints;
    private int mType = 2;
    private double maxIntensity = i.f27244a;
    private float maxZoom = 20.0f;
    private float minZoom = 3.0f;
    private double[] pointList;
    private float zIndex = 0.0f;

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    public HeatMapLayerOptions() {
        this.type = "HeatMapLayerOptions";
    }

    private static Collection<WeightedLatLng> a(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng weightedLatLng : collection) {
            arrayList.add(new WeightedLatLng(weightedLatLng));
        }
        return arrayList;
    }

    private void a() {
        if (this.isPointsUpdated) {
            double d2 = i.f27244a;
            Collection<WeightedLatLng> data = getData();
            if (data != null) {
                this.pointList = new double[(data.size() * 3)];
                int i2 = 0;
                double d3 = Double.NaN;
                double d4 = Double.NaN;
                for (WeightedLatLng next : data) {
                    if (next == null || next.latLng == null) {
                        Log.e("mapcore", "read file failed");
                    } else {
                        int i3 = i2 * 3;
                        this.pointList[i3] = next.latLng.latitude;
                        this.pointList[i3 + 1] = next.latLng.longitude;
                        this.pointList[i3 + 2] = next.intensity;
                        i2++;
                        double d5 = next.latLng.latitude;
                        if (Double.isNaN(d3)) {
                            d3 = d5;
                        }
                        if (Double.isNaN(d4)) {
                            d4 = d5;
                        }
                        if (d5 > d4) {
                            d4 = d5;
                        }
                        if (d5 < d3) {
                            d3 = d5;
                        }
                    }
                }
                if (!Double.isNaN(d3) && !Double.isNaN(d4)) {
                    d2 = (d3 + d4) / 2.0d;
                }
                this.mLatitude = d2;
            }
        }
    }

    public HeatMapLayerOptions data(Collection<LatLng> collection) {
        return weightedData(a(collection));
    }

    public HeatMapLayerOptions gap(float f2) {
        this.mGap = f2;
        return this;
    }

    public Collection<WeightedLatLng> getData() {
        return this.mData;
    }

    public float getGap() {
        return this.mGap;
    }

    public Gradient getGradient() {
        return this.mGradient;
    }

    public double getMaxIntensity() {
        return this.maxIntensity;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public float getSize() {
        return this.mSize;
    }

    public int getType() {
        return this.mType;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public HeatMapLayerOptions gradient(Gradient gradient) {
        this.mGradient = gradient;
        if (gradient != null) {
            this.mColors = gradient.getColors();
            this.mStartPoints = this.mGradient.getStartPoints();
        }
        return this;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public HeatMapLayerOptions maxIntensity(double d2) {
        this.maxIntensity = d2;
        return this;
    }

    public HeatMapLayerOptions maxZoom(float f2) {
        this.maxZoom = f2;
        return this;
    }

    public HeatMapLayerOptions minZoom(float f2) {
        this.minZoom = f2;
        return this;
    }

    public HeatMapLayerOptions opacity(float f2) {
        this.mOpacity = Math.max(0.0f, Math.min(f2, 1.0f));
        return this;
    }

    public HeatMapLayerOptions size(float f2) {
        this.mSize = f2;
        return this;
    }

    public HeatMapLayerOptions type(int i2) {
        this.mType = i2;
        return this;
    }

    public HeatMapLayerOptions visible(boolean z2) {
        this.isVisible = z2;
        return this;
    }

    public HeatMapLayerOptions weightedData(Collection<WeightedLatLng> collection) {
        this.mData = collection;
        this.isPointsUpdated = true;
        a();
        return this;
    }

    public HeatMapLayerOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }
}
