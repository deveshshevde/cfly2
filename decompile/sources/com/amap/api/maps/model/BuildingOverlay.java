package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class BuildingOverlay extends BaseOverlay {
    private BuildingOverlayTotalOptions buildingOverlayTotalOptions = new BuildingOverlayTotalOptions();
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private BuildingOverlayOptions mDefaultOptions;
    private List<BuildingOverlayOptions> optionList;

    protected class BuildingOverlayTotalOptions extends BaseOptions {
        public List<BuildingOverlayOptions> allOptionList;
        public boolean isVisible = true;
        /* access modifiers changed from: private */
        public float zIndex = 0.0f;

        public BuildingOverlayTotalOptions() {
            this.type = "BuildingOptions";
        }
    }

    public BuildingOverlay(IGlOverlayLayer iGlOverlayLayer, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.buildingOverlayTotalOptions.allOptionList = new ArrayList();
        try {
            if (this.mDefaultOptions == null) {
                BuildingOverlayOptions buildingOverlayOptions = new BuildingOverlayOptions();
                this.mDefaultOptions = buildingOverlayOptions;
                buildingOverlayOptions.setVisible(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new LatLng(84.9d, -179.9d));
                arrayList.add(new LatLng(84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, -179.9d));
                this.mDefaultOptions.setBuildingLatlngs(arrayList);
                this.mDefaultOptions.setBuildingTopColor(-65536);
                this.mDefaultOptions.setBuildingSideColor(-12303292);
                this.mDefaultOptions.setVisible(true);
                this.mDefaultOptions.setZIndex(1.0f);
                this.buildingOverlayTotalOptions.allOptionList.add(this.mDefaultOptions);
                a(true);
            }
        } catch (Throwable unused) {
        }
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                iGlOverlayLayer.updateOption(this.overlayName, this.buildingOverlayTotalOptions);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z2) {
        try {
            synchronized (this) {
                if (z2) {
                    this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);
                } else {
                    this.buildingOverlayTotalOptions.allOptionList.removeAll(this.optionList);
                    this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);
                    this.buildingOverlayTotalOptions.allOptionList.addAll(this.optionList);
                }
                IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
                if (iGlOverlayLayer != null) {
                    iGlOverlayLayer.updateOption(this.overlayName, this.buildingOverlayTotalOptions);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void destroy() {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable unused) {
        }
    }

    public List<BuildingOverlayOptions> getCustomOptions() {
        return this.optionList;
    }

    public BuildingOverlayOptions getDefaultOptions() {
        return this.mDefaultOptions;
    }

    public String getId() {
        return this.overlayName;
    }

    public float getZIndex() {
        BuildingOverlayTotalOptions buildingOverlayTotalOptions2 = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions2 != null) {
            return buildingOverlayTotalOptions2.zIndex;
        }
        return 0.0f;
    }

    public boolean isVisible() {
        BuildingOverlayTotalOptions buildingOverlayTotalOptions2 = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions2 != null) {
            return buildingOverlayTotalOptions2.isVisible;
        }
        return false;
    }

    public void setCustomOptions(List<BuildingOverlayOptions> list) {
        if (list != null && list.size() > 0) {
            synchronized (this) {
                this.optionList = list;
            }
            a(false);
        }
    }

    public void setDefaultOptions(BuildingOverlayOptions buildingOverlayOptions) {
        if (buildingOverlayOptions != null) {
            synchronized (this) {
                this.mDefaultOptions = buildingOverlayOptions;
            }
            a(true);
        }
    }

    public void setVisible(boolean z2) {
        BuildingOverlayTotalOptions buildingOverlayTotalOptions2 = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions2 != null) {
            buildingOverlayTotalOptions2.isVisible = z2;
            a();
        }
    }

    public void setZIndex(float f2) {
        BuildingOverlayOptions buildingOverlayOptions = this.mDefaultOptions;
        if (buildingOverlayOptions != null) {
            buildingOverlayOptions.setZIndex(f2);
        }
        BuildingOverlayTotalOptions buildingOverlayTotalOptions2 = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions2 != null) {
            float unused = buildingOverlayTotalOptions2.zIndex = f2;
            a();
        }
    }
}
