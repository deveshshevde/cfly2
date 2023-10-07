package com.amap.api.maps.model;

import android.text.TextUtils;
import android.util.Log;
import com.amap.api.mapcore.util.dj;
import com.amap.api.mapcore.util.ie;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class Marker extends BasePointOverlay {
    private IPoint geoPoint;
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private boolean isClickable = true;
    private boolean isInfoWindowEnable = true;
    private boolean isRemoved = false;
    private boolean isUseAnimation = false;
    private Animation mCurAnimation = null;
    private Animation.AnimationListener mCurAnimationListener = null;
    private a mCurInnerAnimationListener = null;
    private Object object;
    private MarkerOptions options;
    private LatLng viewModeLatLng = null;
    private DPoint viewModeLatLngDp = new DPoint();

    private class a implements Animation.AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        private final ie f9741b;

        /* renamed from: c  reason: collision with root package name */
        private final ie f9742c;

        private a(final Animation.AnimationListener animationListener) {
            this.f9741b = new ie(Marker.this) {
                public final void runTask() {
                    try {
                        Animation.AnimationListener animationListener = animationListener;
                        if (animationListener != null) {
                            animationListener.onAnimationStart();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            this.f9742c = new ie(Marker.this) {
                public final void runTask() {
                    try {
                        Animation.AnimationListener animationListener = animationListener;
                        if (animationListener != null) {
                            animationListener.onAnimationEnd();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
        }

        /* synthetic */ a(Marker marker, Animation.AnimationListener animationListener, byte b2) {
            this(animationListener);
        }

        public final void onAnimationEnd() {
            dj.a().a(this.f9742c);
        }

        public final void onAnimationStart() {
            dj.a().a(this.f9741b);
        }
    }

    public Marker(IGlOverlayLayer iGlOverlayLayer, MarkerOptions markerOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = markerOptions;
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
            if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                iGlOverlayLayer.updateOption(this.overlayName, this.options);
            }
        } catch (Throwable unused) {
        }
    }

    public final void destroy() {
        try {
            remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Marker)) {
            try {
                MarkerOptions markerOptions = this.options;
                return markerOptions != null && markerOptions.equals(((Marker) obj).options) && this.overlayName.equals(((Marker) obj).overlayName);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = a("getAlpha", (java.lang.Object[]) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float getAlpha() {
        /*
            r2 = this;
            com.amap.api.maps.model.MarkerOptions r0 = r2.options
            if (r0 == 0) goto L_0x001f
            boolean r0 = r2.isUseAnimation
            if (r0 == 0) goto L_0x0018
            r0 = 0
            java.lang.String r1 = "getAlpha"
            java.lang.Object r0 = r2.a(r1, r0)
            if (r0 == 0) goto L_0x0018
            java.lang.Double r0 = (java.lang.Double) r0
            float r0 = r0.floatValue()
            return r0
        L_0x0018:
            com.amap.api.maps.model.MarkerOptions r0 = r2.options
            float r0 = r0.getAlpha()
            return r0
        L_0x001f:
            r0 = 1065353216(0x3f800000, float:1.0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.Marker.getAlpha():float");
    }

    public final float getAnchorU() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorU();
        }
        return 0.0f;
    }

    public final float getAnchorV() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorV();
        }
        return 0.0f;
    }

    public final int getDisplayLevel() {
        return 5;
    }

    public final IPoint getGeoPoint() {
        if (this.geoPoint == null) {
            this.geoPoint = new IPoint();
        }
        LatLng position = getPosition();
        if (position != null) {
            VirtualEarthProjection.latLongToPixels(position.latitude, position.longitude, 20, this.geoPoint);
        }
        return this.geoPoint;
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.options.getIcons();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Object getObject() {
        return this.object;
    }

    public final MarkerOptions getOptions() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions;
        }
        return null;
    }

    public final int getPeriod() {
        try {
            return this.options.getPeriod();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final LatLng getPosition() {
        Object a2;
        try {
            if (this.options != null) {
                if (!isViewMode()) {
                    return (!this.isUseAnimation || (a2 = a("getPosition", (Object[]) null)) == null) ? this.options.getPosition() : (LatLng) a2;
                }
                ((IGlOverlayLayer) this.glOverlayLayerRef.get()).getMap().getPixel2LatLng(this.options.getScreenX(), this.options.getScreenY(), this.viewModeLatLngDp);
                LatLng latLng = this.viewModeLatLng;
                return (latLng != null && latLng.latitude == this.viewModeLatLngDp.f10010y && this.viewModeLatLng.longitude == this.viewModeLatLngDp.f10009x) ? this.viewModeLatLng : new LatLng(this.viewModeLatLngDp.f10010y, this.viewModeLatLngDp.f10009x);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public final float getRotateAngle() {
        if (this.options == null) {
            return 0.0f;
        }
        if (this.isUseAnimation) {
            Object a2 = a("getRotateAngle", (Object[]) null);
            Log.e("mapcore", "getRotateAngle ".concat(String.valueOf(a2)));
            if (a2 != null) {
                return ((Double) a2).floatValue();
            }
        }
        return this.options.getRotateAngle();
    }

    public final String getSnippet() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getSnippet();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String getTitle() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getTitle();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getZIndex() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getZIndex();
        }
        return 0.0f;
    }

    public final int hashCode() {
        if (this.options == null) {
            return super.hashCode();
        }
        return (((this.overlayName == null ? 0 : this.overlayName.hashCode()) + 31) * 31) + this.options.hashCode();
    }

    public final void hideInfoWindow() {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                iGlOverlayLayer.hideInfoWindow(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isClickable() {
        Object a2 = a("isClickable", (Object[]) null);
        return a2 instanceof Boolean ? ((Boolean) a2).booleanValue() : this.isClickable;
    }

    public final boolean isDraggable() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isDraggable();
        }
        return false;
    }

    public final boolean isFlat() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isFlat();
        }
        return false;
    }

    public final boolean isInfoWindowAutoOverturn() {
        return false;
    }

    public final boolean isInfoWindowEnable() {
        MarkerOptions markerOptions = this.options;
        return markerOptions != null ? markerOptions.isInfoWindowEnable() : this.isInfoWindowEnable;
    }

    public final boolean isInfoWindowShown() {
        IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return false;
        }
        Object a2 = a("isInfoWindowShown", (Object[]) null);
        if (a2 instanceof Boolean) {
            return ((Boolean) a2).booleanValue();
        }
        return false;
    }

    public final boolean isPerspective() {
        return false;
    }

    public final boolean isRemoved() {
        return this.isRemoved;
    }

    public final boolean isViewMode() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isViewMode();
        }
        return false;
    }

    public final boolean isVisible() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void remove() {
        try {
            if (isInfoWindowShown()) {
                hideInfoWindow();
            }
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
            this.isRemoved = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setAlpha(float f2) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.alpha(f2);
            a();
        }
    }

    public final void setAnchor(float f2, float f3) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.anchor(f2, f3);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setAnimation(Animation animation) {
        if (animation != null) {
            try {
                Animation.AnimationListener animationListener = this.mCurAnimationListener;
                if (animationListener != null) {
                    animation.setAnimationListener(animationListener);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        this.mCurAnimation = animation;
        this.isUseAnimation = animation != null;
        a("setAnimation", new Object[]{animation});
        if (animation != null) {
            animation.resetUpdateFlags();
        }
    }

    public final void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mCurAnimationListener = animationListener;
        a aVar = new a(this, animationListener, (byte) 0);
        this.mCurInnerAnimationListener = aVar;
        if (this.mCurAnimation != null) {
            a("setAnimationListener", new Object[]{aVar});
        }
    }

    public final void setAutoOverturnInfoWindow(boolean z2) {
    }

    public final void setBelowMaskLayer(boolean z2) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.belowMaskLayer(z2);
            a();
        }
    }

    public final void setClickable(boolean z2) {
        this.isClickable = z2;
        a("setClickable", new Object[]{Boolean.valueOf(z2)});
    }

    public final void setDisplayLevel(int i2) {
    }

    public final void setDraggable(boolean z2) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.draggable(z2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFixingPointEnable(boolean z2) {
    }

    public final void setFlat(boolean z2) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.setFlat(z2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setGeoPoint(IPoint iPoint) {
        this.geoPoint = iPoint;
        if (iPoint != null) {
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) iPoint.x, (long) iPoint.y, 20);
            LatLng latLng = new LatLng(pixelsToLatLong.f10010y, pixelsToLatLong.f10009x, false);
            pixelsToLatLong.recycle();
            this.options.position(latLng);
            a();
        }
    }

    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                MarkerOptions markerOptions = this.options;
                if (markerOptions != null) {
                    markerOptions.icon(bitmapDescriptor);
                    a();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.options.icons(arrayList);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setInfoWindowEnable(boolean z2) {
        this.isInfoWindowEnable = z2;
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.infoWindowEnable(z2);
            a();
        }
    }

    public final void setMarkerOptions(MarkerOptions markerOptions) {
        this.options = markerOptions;
        a();
    }

    public final void setObject(Object obj) {
        this.object = obj;
    }

    public final void setPeriod(int i2) {
        try {
            this.options.period(i2);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPerspective(boolean z2) {
    }

    public final void setPosition(LatLng latLng) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.position(latLng);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPositionByPixels(int i2, int i3) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.setScreenPosition(i2, i3);
            a();
        }
    }

    public final void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    public final void setRotateAngle(float f2) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.rotateAngle(f2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotateAngleNotUpdate(float f2) {
    }

    public final void setSnippet(String str) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.snippet(str);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTitle(String str) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.title(str);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setToTop() {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                iGlOverlayLayer.set2Top(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z2) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.visible(z2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f2) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.zIndex(f2);
            a();
        }
    }

    public final void showInfoWindow() {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                iGlOverlayLayer.showInfoWindow(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean startAnimation() {
        Object a2 = a("startAnimation", (Object[]) null);
        if (a2 instanceof Boolean) {
            return ((Boolean) a2).booleanValue();
        }
        return false;
    }
}
