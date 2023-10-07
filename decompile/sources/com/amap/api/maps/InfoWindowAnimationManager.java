package com.amap.api.maps;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;

public class InfoWindowAnimationManager {

    /* renamed from: a  reason: collision with root package name */
    IInfoWindowManager f9721a = null;

    public InfoWindowAnimationManager(IInfoWindowManager iInfoWindowManager) {
        this.f9721a = iInfoWindowManager;
    }

    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
        this.f9721a.setInfoWindowAnimation(animation, animationListener);
    }

    public void setInfoWindowAppearAnimation(Animation animation) {
        this.f9721a.setInfoWindowAppearAnimation(animation);
    }

    public void setInfoWindowBackColor(int i2) {
        this.f9721a.setInfoWindowBackColor(i2);
    }

    public void setInfoWindowBackEnable(boolean z2) {
        this.f9721a.setInfoWindowBackEnable(z2);
    }

    public void setInfoWindowBackScale(float f2, float f3) {
        this.f9721a.setInfoWindowBackScale(f2, f3);
    }

    public void setInfoWindowDisappearAnimation(Animation animation) {
        this.f9721a.setInfoWindowDisappearAnimation(animation);
    }

    public void setInfoWindowMovingAnimation(Animation animation) {
        this.f9721a.setInfoWindowMovingAnimation(animation);
    }

    public void startAnimation() {
        this.f9721a.startAnimation();
    }
}
