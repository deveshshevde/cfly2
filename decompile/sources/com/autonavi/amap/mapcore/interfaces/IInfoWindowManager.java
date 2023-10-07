package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;

public interface IInfoWindowManager {
    void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener);

    void setInfoWindowAppearAnimation(Animation animation);

    void setInfoWindowBackColor(int i2);

    void setInfoWindowBackEnable(boolean z2);

    void setInfoWindowBackScale(float f2, float f3);

    void setInfoWindowDisappearAnimation(Animation animation);

    void setInfoWindowMovingAnimation(Animation animation);

    void startAnimation();
}
