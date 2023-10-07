package com.amap.api.maps;

import com.autonavi.amap.mapcore.interfaces.IUiSettings;

public final class UiSettings {
    private final IUiSettings uiSettingsDelegate;

    public UiSettings(IUiSettings iUiSettings) {
        this.uiSettingsDelegate = iUiSettings;
    }

    public final float getLogoMarginRate(int i2) {
        try {
            return this.uiSettingsDelegate.getLogoMarginRate(i2);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final int getLogoPosition() {
        try {
            return this.uiSettingsDelegate.getLogoPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getZoomPosition() {
        try {
            return this.uiSettingsDelegate.getZoomPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 2;
        }
    }

    public final boolean isCompassEnabled() {
        try {
            return this.uiSettingsDelegate.isCompassEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isGestureScaleByMapCenter() {
        try {
            return this.uiSettingsDelegate.isGestureScaleByMapCenter();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isIndoorSwitchEnabled() {
        try {
            return this.uiSettingsDelegate.isIndoorSwitchEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isMyLocationButtonEnabled() {
        try {
            return this.uiSettingsDelegate.isMyLocationButtonEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isRotateGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isRotateGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isScaleControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isScaleControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isScrollGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isScrollGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isTiltGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isTiltGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isZoomControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isZoomGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final void setAllGesturesEnabled(boolean z2) {
        try {
            this.uiSettingsDelegate.setAllGesturesEnabled(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCompassEnabled(boolean z2) {
        try {
            this.uiSettingsDelegate.setCompassEnabled(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setGestureScaleByMapCenter(boolean z2) {
        try {
            this.uiSettingsDelegate.setGestureScaleByMapCenter(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setIndoorSwitchEnabled(boolean z2) {
        try {
            this.uiSettingsDelegate.setIndoorSwitchEnabled(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoBottomMargin(int i2) {
        try {
            this.uiSettingsDelegate.setLogoBottomMargin(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoCenter(int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public final void setLogoEnable(boolean z2) {
        try {
            this.uiSettingsDelegate.setLogoEnable(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoLeftMargin(int i2) {
        try {
            this.uiSettingsDelegate.setLogoLeftMargin(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoMarginRate(int i2, float f2) {
        try {
            this.uiSettingsDelegate.setLogoMarginRate(i2, f2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoPosition(int i2) {
        try {
            this.uiSettingsDelegate.setLogoPosition(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationButtonEnabled(boolean z2) {
        try {
            this.uiSettingsDelegate.setMyLocationButtonEnabled(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotateGesturesEnabled(boolean z2) {
        try {
            this.uiSettingsDelegate.setRotateGesturesEnabled(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setScaleControlsEnabled(boolean z2) {
        try {
            this.uiSettingsDelegate.setScaleControlsEnabled(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setScrollGesturesEnabled(boolean z2) {
        try {
            this.uiSettingsDelegate.setScrollGesturesEnabled(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTiltGesturesEnabled(boolean z2) {
        try {
            this.uiSettingsDelegate.setTiltGesturesEnabled(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomControlsEnabled(boolean z2) {
        try {
            this.uiSettingsDelegate.setZoomControlsEnabled(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomGesturesEnabled(boolean z2) {
        try {
            this.uiSettingsDelegate.setZoomGesturesEnabled(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomInByScreenCenter(boolean z2) {
        try {
            this.uiSettingsDelegate.setZoomInByScreenCenter(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomPosition(int i2) {
        try {
            this.uiSettingsDelegate.setZoomPosition(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
