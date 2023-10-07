package com.amap.api.maps.model;

import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.lang.ref.WeakReference;

public final class TileOverlay extends BaseOverlay {
    protected WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    protected TileOverlayOptions options;

    public TileOverlay(IGlOverlayLayer iGlOverlayLayer, TileOverlayOptions tileOverlayOptions, String str) {
        super(str);
        TileProviderInner tileProviderInner;
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = tileOverlayOptions;
        if (tileOverlayOptions != null && (tileProviderInner = tileOverlayOptions.getTileProviderInner()) != null) {
            tileProviderInner.init(iGlOverlayLayer, str);
        }
    }

    /* access modifiers changed from: protected */
    public final Object callNativeFunction(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void clearTileCache() {
        callNativeFunction("clearTileCache", (Object[]) null);
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof TileOverlay)) {
            try {
                TileOverlayOptions tileOverlayOptions = this.options;
                return tileOverlayOptions != null && tileOverlayOptions.equals(((TileOverlay) obj).options) && this.overlayName.equals(((TileOverlay) obj).overlayName);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final String getId() {
        return this.overlayName;
    }

    public final float getZIndex() {
        return this.options.getZIndex();
    }

    public final int hashCode() {
        if (this.options == null) {
            return super.hashCode();
        }
        return (((this.overlayName == null ? 0 : this.overlayName.hashCode()) + 31) * 31) + this.options.hashCode();
    }

    public final boolean isVisible() {
        return this.options.isVisible();
    }

    public final void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public final void setVisible(boolean z2) {
        this.options.visible(z2);
        updateOption();
    }

    public final void setZIndex(float f2) {
        this.options.zIndex(f2);
        updateOption();
    }

    /* access modifiers changed from: protected */
    public final void updateOption() {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                iGlOverlayLayer.updateOption(this.overlayName, this.options);
            }
        } catch (Throwable unused) {
        }
    }
}
