package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.mapcore.util.dj;
import com.amap.api.mapcore.util.ie;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.amap.mapcore.animation.GLAnimation;

public abstract class Animation {
    public static final int FILL_MODE_BACKWARDS = 1;
    public static final int FILL_MODE_FORWARDS = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    protected String animationType;
    private long duration;
    private int fillMode;
    public GLAnimation glAnimation;
    private Interpolator interpolator;
    private boolean mFillAfter;
    private boolean mFillBefore;
    private boolean mFillEnabled;
    private AnimationListener mListener;
    private int mRepeatCount;
    private int mRepeatMode;
    private AnimationUpdateFlags updateFlags;

    public interface AnimationListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    protected static class AnimationUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean durationUpdate = false;
        protected boolean fillModeUpdate = false;
        protected boolean interpolatorUpdate = false;
        protected boolean mFillAfterUpdate = false;
        protected boolean mFillBeforeUpdate = false;
        protected boolean mFillEnabledUpdate = false;
        protected boolean mListenerUpdate = false;
        protected boolean mRepeatCountUpdate = false;
        protected boolean mRepeatModeUpdate = false;

        protected AnimationUpdateFlags() {
        }

        public void reset() {
            super.reset();
            this.mListenerUpdate = false;
            this.durationUpdate = false;
            this.interpolatorUpdate = false;
            this.fillModeUpdate = false;
            this.mFillEnabledUpdate = false;
            this.mFillAfterUpdate = false;
            this.mFillBeforeUpdate = false;
            this.mRepeatCountUpdate = false;
            this.mRepeatModeUpdate = false;
        }
    }

    private class a implements AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        private final ie f9761b;

        /* renamed from: c  reason: collision with root package name */
        private final ie f9762c;

        private a(final AnimationListener animationListener) {
            this.f9761b = new ie(Animation.this) {
                public final void runTask() {
                    try {
                        AnimationListener animationListener = animationListener;
                        if (animationListener != null) {
                            animationListener.onAnimationStart();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            this.f9762c = new ie(Animation.this) {
                public final void runTask() {
                    try {
                        AnimationListener animationListener = animationListener;
                        if (animationListener != null) {
                            animationListener.onAnimationEnd();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
        }

        /* synthetic */ a(Animation animation, AnimationListener animationListener, byte b2) {
            this(animationListener);
        }

        public final void onAnimationEnd() {
            dj.a().a(this.f9762c);
        }

        public final void onAnimationStart() {
            dj.a().a(this.f9761b);
        }
    }

    public Animation() {
        this.fillMode = 0;
        this.duration = 500;
        this.interpolator = null;
        this.animationType = "typeAnimtionBase";
        this.mFillBefore = true;
        this.mFillAfter = false;
        this.mFillEnabled = false;
        this.mRepeatCount = 0;
        this.mRepeatMode = 1;
        this.glAnimation = null;
        this.updateFlags = new AnimationUpdateFlags();
        this.glAnimation = new GLAnimation();
        this.animationType = getAnimationType();
    }

    private void a(boolean z2) {
        this.mFillEnabled = z2;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillEnabled(z2);
        }
        this.updateFlags.mFillEnabledUpdate = true;
    }

    private void b(boolean z2) {
        this.mFillAfter = z2;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillAfter(z2);
        }
        this.updateFlags.mFillAfterUpdate = true;
    }

    private void c(boolean z2) {
        this.mFillBefore = z2;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillBefore(z2);
        }
        this.updateFlags.mFillBeforeUpdate = true;
    }

    /* access modifiers changed from: protected */
    public abstract String getAnimationType();

    public int getFillMode() {
        return this.fillMode;
    }

    public int getRepeatCount() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatCount();
        }
        return 0;
    }

    public int getRepeatMode() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatMode();
        }
        return 1;
    }

    public AnimationUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mListener = new a(this, animationListener, (byte) 0);
        this.glAnimation.setAnimationListener(animationListener);
        this.updateFlags.mListenerUpdate = true;
    }

    public void setDuration(long j2) {
        this.duration = j2;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setDuration(j2);
        }
        this.updateFlags.durationUpdate = true;
    }

    public void setFillMode(int i2) {
        this.fillMode = i2;
        if (i2 == 0) {
            b(true);
            c(false);
            a(false);
        } else {
            b(false);
            a(true);
            c(true);
        }
        this.updateFlags.fillModeUpdate = true;
    }

    public void setInterpolator(Interpolator interpolator2) {
        this.interpolator = interpolator2;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setInterpolator(interpolator2);
        }
        this.updateFlags.interpolatorUpdate = true;
    }

    public void setRepeatCount(int i2) {
        this.mRepeatCount = i2;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatCount(i2);
        }
        this.updateFlags.mRepeatCountUpdate = true;
    }

    public void setRepeatMode(int i2) {
        this.mRepeatMode = i2;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatMode(i2);
        }
        this.updateFlags.mRepeatModeUpdate = true;
    }
}
