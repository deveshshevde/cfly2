package com.amap.api.maps.model;

import android.graphics.Point;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import java.util.ArrayList;
import java.util.List;

public class BuildingOverlayOptions extends BaseOptions {
    private int buildingHeight = -1;
    private int buildingHeightScale = 1;
    private List<LatLng> buildingLatlngs = new ArrayList();
    private int[] buildingLatlngsPoints;
    private int buildingSideColor = -7829368;
    private int buildingTopColor = -7829368;
    private boolean isVisible = true;
    private float zindex;

    public int getBuildingHeight() {
        return this.buildingHeight;
    }

    public int getBuildingHeightScale() {
        return this.buildingHeightScale;
    }

    public List<LatLng> getBuildingLatlngs() {
        return this.buildingLatlngs;
    }

    public int getBuildingSideColor() {
        return this.buildingSideColor;
    }

    public int getBuildingTopColor() {
        return this.buildingTopColor;
    }

    public synchronized int[] getPoints() {
        List<LatLng> list = this.buildingLatlngs;
        if (list == null || list.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[(this.buildingLatlngs.size() * 2)];
        int i2 = 0;
        for (int i3 = 0; i3 < this.buildingLatlngs.size(); i3++) {
            LatLng latLng = this.buildingLatlngs.get(i3);
            if (latLng != null) {
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int i4 = i2 + 1;
                iArr[i2] = latLongToPixels.x;
                i2 = i4 + 1;
                iArr[i4] = latLongToPixels.y;
            }
        }
        return iArr;
    }

    public float getZIndex() {
        return this.zindex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public BuildingOverlayOptions setBuildingHeight(int i2) {
        this.buildingHeight = i2;
        return this;
    }

    public BuildingOverlayOptions setBuildingHeightScale(int i2) {
        this.buildingHeightScale = i2;
        return this;
    }

    public synchronized BuildingOverlayOptions setBuildingLatlngs(List<LatLng> list) {
        this.buildingLatlngs = list;
        if (list != null && list.size() > 0) {
            this.buildingLatlngsPoints = new int[(list.size() * 2)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < list.size()) {
                LatLng latLng = list.get(i2);
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int i4 = i3 + 1;
                this.buildingLatlngsPoints[i3] = latLongToPixels.x;
                int i5 = i4 + 1;
                this.buildingLatlngsPoints[i4] = latLongToPixels.y;
                i2++;
                i3 = i5;
            }
        }
        return this;
    }

    public BuildingOverlayOptions setBuildingSideColor(int i2) {
        this.buildingSideColor = i2;
        return this;
    }

    public BuildingOverlayOptions setBuildingTopColor(int i2) {
        this.buildingTopColor = i2;
        return this;
    }

    public void setVisible(boolean z2) {
        this.isVisible = z2;
    }

    public void setZIndex(float f2) {
        this.zindex = f2;
    }
}
