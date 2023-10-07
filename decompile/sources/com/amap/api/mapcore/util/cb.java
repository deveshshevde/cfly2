package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

public final class cb implements IInfoWindowManager, IInfoWindowAction {

    /* renamed from: a  reason: collision with root package name */
    aj f8120a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f8121b;

    /* renamed from: c  reason: collision with root package name */
    private final IGlOverlayLayer f8122c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8123d = "PopupOverlay";

    public cb(IGlOverlayLayer iGlOverlayLayer, Context context) {
        this.f8121b = context;
        this.f8122c = iGlOverlayLayer;
    }

    public final synchronized void hideInfoWindow() {
        IGlOverlayLayer iGlOverlayLayer = this.f8122c;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "hideInfoWindow", (Object[]) null);
        }
    }

    public final boolean isInfoWindowShown() {
        return false;
    }

    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        IGlOverlayLayer iGlOverlayLayer = this.f8122c;
        if (!(iGlOverlayLayer == null || motionEvent == null)) {
            Object nativeProperties = iGlOverlayLayer.getNativeProperties("PopupOverlay", "onInfoWindowTap", new Object[]{Double.valueOf((double) motionEvent.getX()), Double.valueOf((double) motionEvent.getY())});
            if (nativeProperties instanceof Boolean) {
                return ((Boolean) nativeProperties).booleanValue();
            }
        }
        return false;
    }

    public final void redrawInfoWindow() {
        IGlOverlayLayer iGlOverlayLayer = this.f8122c;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "redrawInfoWindow", (Object[]) null);
        }
    }

    public final void setInfoWindowAdapterManager(aj ajVar) {
        synchronized (this) {
            this.f8120a = ajVar;
        }
    }

    public final void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
    }

    public final void setInfoWindowAppearAnimation(Animation animation) {
    }

    public final void setInfoWindowBackColor(int i2) {
    }

    public final void setInfoWindowBackEnable(boolean z2) {
    }

    public final void setInfoWindowBackScale(float f2, float f3) {
    }

    public final void setInfoWindowDisappearAnimation(Animation animation) {
    }

    public final void setInfoWindowMovingAnimation(Animation animation) {
    }

    public final synchronized void showInfoWindow(BasePointOverlay basePointOverlay) throws RemoteException {
        IGlOverlayLayer iGlOverlayLayer = this.f8122c;
        if (!(iGlOverlayLayer == null || basePointOverlay == null)) {
            iGlOverlayLayer.getNativeProperties(basePointOverlay.getId(), "showInfoWindow", new Object[]{basePointOverlay.getId()});
        }
    }

    public final synchronized void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
    }

    public final void startAnimation() {
    }
}
