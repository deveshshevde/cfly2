package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import java.lang.ref.WeakReference;

public class GL3DModel extends BasePointOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private Object object;
    private GL3DModelOptions options;

    public GL3DModel(IGlOverlayLayer iGlOverlayLayer, GL3DModelOptions gL3DModelOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = gL3DModelOptions;
    }

    private Object a(String str, Object[] objArr) {
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

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null && iGlOverlayLayer != null) {
                iGlOverlayLayer.updateOption(this.overlayName, this.options);
            }
        } catch (Throwable unused) {
        }
    }

    public void destroy() {
        remove();
    }

    public float getAngle() {
        try {
            return this.options.getAngle();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public Object getObject() {
        return this.object;
    }

    public LatLng getPosition() {
        try {
            return this.options.getLatLng();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public float getRotateAngle() {
        try {
            return getAngle();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    public String getSnippet() {
        try {
            GL3DModelOptions gL3DModelOptions = this.options;
            return gL3DModelOptions != null ? gL3DModelOptions.getSnippet() : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getTitle() {
        try {
            GL3DModelOptions gL3DModelOptions = this.options;
            return gL3DModelOptions != null ? gL3DModelOptions.getTitle() : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public boolean isInfoWindowEnable() {
        return true;
    }

    public boolean isVisible() {
        try {
            return this.options.isVisible();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAngle(float f2) {
        try {
            this.options.angle(f2);
            a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setAnimation(Animation animation) {
        try {
            a("setAnimation", new Object[]{animation});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setGeoPoint(IPoint iPoint) {
    }

    public void setModelFixedLength(int i2) {
        try {
            this.options.setModelFixedLength(i2);
            a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setObject(Object obj) {
        try {
            this.object = obj;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.options.position(latLng);
            a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setRotateAngle(float f2) {
        try {
            setAngle(f2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setSnippet(String str) {
        GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions != null) {
            gL3DModelOptions.snippet(str);
            a();
        }
    }

    public void setTitle(String str) {
        GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions != null) {
            gL3DModelOptions.title(str);
            a();
        }
    }

    public void setVisible(boolean z2) {
        try {
            this.options.setVisible(z2);
            a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setZoomLimit(float f2) {
    }

    public void showInfoWindow() {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                iGlOverlayLayer.showInfoWindow(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean startAnimation() {
        Object a2 = a("startAnimation", (Object[]) null);
        if (a2 instanceof Boolean) {
            return ((Boolean) a2).booleanValue();
        }
        return false;
    }
}
