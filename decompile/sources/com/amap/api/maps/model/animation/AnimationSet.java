package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import java.util.ArrayList;
import java.util.List;

public class AnimationSet extends Animation {
    private List<Animation> mAnimations = new ArrayList();
    private boolean shareInterpolator = false;

    public AnimationSet(boolean z2) {
        this.glAnimation = new GLAnimationSet(z2);
        this.shareInterpolator = z2;
    }

    public void addAnimation(Animation animation) {
        ((GLAnimationSet) this.glAnimation).addAnimation(animation);
        this.mAnimations.add(animation);
    }

    public void cleanAnimation() {
        ((GLAnimationSet) this.glAnimation).cleanAnimation();
        this.mAnimations.clear();
    }

    /* access modifiers changed from: protected */
    public String getAnimationType() {
        return "AnimationSet";
    }
}
