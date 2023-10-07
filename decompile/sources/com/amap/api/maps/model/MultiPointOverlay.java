package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.List;

public class MultiPointOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private MultiPointOverlayOptions options;

    public MultiPointOverlay(IGlOverlayLayer iGlOverlayLayer, MultiPointOverlayOptions multiPointOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = multiPointOverlayOptions;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
        if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
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

    public List<MultiPointItem> getItems() {
        MultiPointOverlayOptions multiPointOverlayOptions = this.options;
        if (multiPointOverlayOptions != null) {
            return multiPointOverlayOptions.getMultiPointItems();
        }
        return null;
    }

    public void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable unused) {
        }
    }

    public void setAnchor(float f2, float f3) {
        MultiPointOverlayOptions multiPointOverlayOptions = this.options;
        if (multiPointOverlayOptions != null) {
            multiPointOverlayOptions.anchor(f2, f3);
            a();
        }
    }

    public void setEnable(boolean z2) {
        MultiPointOverlayOptions multiPointOverlayOptions = this.options;
        if (multiPointOverlayOptions != null) {
            multiPointOverlayOptions.setEnable(z2);
            a();
        }
    }

    public void setItems(List<MultiPointItem> list) {
        MultiPointOverlayOptions multiPointOverlayOptions = this.options;
        if (multiPointOverlayOptions != null) {
            multiPointOverlayOptions.setMultiPointItems(list);
            a();
        }
    }
}
