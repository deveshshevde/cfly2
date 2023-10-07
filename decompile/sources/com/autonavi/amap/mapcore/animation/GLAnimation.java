package com.autonavi.amap.mapcore.animation;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;

public class GLAnimation implements Cloneable {
    public static final int ABSOLUTE = 0;
    public static final int INFINITE = -1;
    public static final int RELATIVE_TO_PARENT = 2;
    public static final int RELATIVE_TO_SELF = 1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int START_ON_FIRST_FRAME = -1;
    public static final int ZORDER_BOTTOM = -1;
    public static final int ZORDER_NORMAL = 0;
    public static final int ZORDER_TOP = 1;
    private int mBackgroundColor;
    boolean mCycleFlip = false;
    private boolean mDetachWallpaper = false;
    long mDuration = 500;
    boolean mEnded = false;
    boolean mFillAfter = false;
    boolean mFillBefore = true;
    boolean mFillEnabled = false;
    boolean mInitialized = false;
    Interpolator mInterpolator;
    Animation.AnimationListener mListener;
    private Handler mListenerHandler;
    private boolean mMore = true;
    private Runnable mOnEnd;
    private Runnable mOnStart;
    private boolean mOneMoreTime = true;
    RectF mPreviousRegion = new RectF();
    GLTransformation mPreviousTransformation = new GLTransformation();
    RectF mRegion = new RectF();
    int mRepeatCount = 0;
    int mRepeatMode = 1;
    int mRepeated = 0;
    private float mScaleFactor = 1.0f;
    long mStartOffset;
    long mStartTime = -1;
    boolean mStarted = false;
    private int mZAdjustment;

    public GLAnimation() {
        try {
            ensureInterpolator();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void fireAnimationEnd() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationEnd();
            } else {
                handler.postAtFrontOfQueue(this.mOnEnd);
            }
        }
    }

    private void fireAnimationRepeat() {
    }

    private void fireAnimationStart() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationStart();
            } else {
                handler.postAtFrontOfQueue(this.mOnStart);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, GLTransformation gLTransformation) {
    }

    public void cancel() {
        if (this.mStarted && !this.mEnded) {
            fireAnimationEnd();
            this.mEnded = true;
        }
        this.mStartTime = Long.MIN_VALUE;
        this.mOneMoreTime = false;
        this.mMore = false;
    }

    public GLAnimation clone() throws CloneNotSupportedException {
        GLAnimation gLAnimation = (GLAnimation) super.clone();
        gLAnimation.mPreviousRegion = new RectF();
        gLAnimation.mRegion = new RectF();
        gLAnimation.mPreviousTransformation = new GLTransformation();
        return gLAnimation;
    }

    public long computeDurationHint() {
        return (getStartOffset() + getDuration()) * ((long) (getRepeatCount() + 1));
    }

    public void detach() {
        if (this.mStarted && !this.mEnded) {
            this.mEnded = true;
            fireAnimationEnd();
        }
    }

    /* access modifiers changed from: protected */
    public void ensureInterpolator() {
        if (this.mInterpolator == null) {
            this.mInterpolator = new AccelerateDecelerateInterpolator();
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public boolean getDetachWallpaper() {
        return this.mDetachWallpaper;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public boolean getFillAfter() {
        return this.mFillAfter;
    }

    public boolean getFillBefore() {
        return this.mFillBefore;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    /* access modifiers changed from: protected */
    public float getScaleFactor() {
        return this.mScaleFactor;
    }

    public long getStartOffset() {
        return this.mStartOffset;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public boolean getTransformation(long j2, GLTransformation gLTransformation) {
        if (this.mStartTime == -1) {
            this.mStartTime = j2;
        }
        long startOffset = getStartOffset();
        long j3 = this.mDuration;
        float f2 = j3 != 0 ? ((float) (j2 - (this.mStartTime + startOffset))) / ((float) j3) : j2 < this.mStartTime ? 0.0f : 1.0f;
        boolean z2 = f2 >= 1.0f;
        this.mMore = !z2;
        if (!this.mFillEnabled) {
            f2 = Math.max(Math.min(f2, 1.0f), 0.0f);
        }
        if ((f2 >= 0.0f || this.mFillBefore) && (f2 <= 1.0f || this.mFillAfter)) {
            if (!this.mStarted) {
                try {
                    fireAnimationStart();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.mStarted = true;
            }
            if (this.mFillEnabled) {
                f2 = Math.max(Math.min(f2, 1.0f), 0.0f);
            }
            if (this.mCycleFlip) {
                f2 = 1.0f - f2;
            }
            applyTransformation(this.mInterpolator.getInterpolation(f2), gLTransformation);
        }
        if (z2) {
            int i2 = this.mRepeatCount;
            int i3 = this.mRepeated;
            if (i2 != i3) {
                if (i2 > 0) {
                    this.mRepeated = i3 + 1;
                }
                if (this.mRepeatMode == 2) {
                    this.mCycleFlip = !this.mCycleFlip;
                }
                this.mStartTime = -1;
                this.mMore = true;
                fireAnimationRepeat();
            } else if (!this.mEnded) {
                this.mEnded = true;
                fireAnimationEnd();
            }
        }
        boolean z3 = this.mMore;
        if (z3 || !this.mOneMoreTime) {
            return z3;
        }
        this.mOneMoreTime = false;
        return true;
    }

    public boolean getTransformation(long j2, GLTransformation gLTransformation, float f2) {
        this.mScaleFactor = f2;
        return getTransformation(j2, gLTransformation);
    }

    public int getZAdjustment() {
        return this.mZAdjustment;
    }

    public boolean hasAlpha() {
        return false;
    }

    public boolean hasEnded() {
        return this.mEnded;
    }

    /* access modifiers changed from: protected */
    public boolean hasStarted() {
        return this.mStarted;
    }

    public void initialize() {
        reset();
        this.mInitialized = true;
    }

    public boolean isFillEnabled() {
        return this.mFillEnabled;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void reset() {
        this.mPreviousRegion.setEmpty();
        this.mPreviousTransformation.clear();
        this.mInitialized = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
        this.mOneMoreTime = true;
        this.mListenerHandler = null;
    }

    public void restrictDuration(long j2) {
        long j3 = this.mStartOffset;
        if (j3 > j2) {
            this.mStartOffset = j2;
        } else {
            long j4 = this.mDuration + j3;
            if (j4 > j2) {
                this.mDuration = j2 - j3;
                j4 = j2;
            }
            if (this.mDuration > 0) {
                int i2 = this.mRepeatCount;
                if (i2 < 0 || ((long) i2) > j2 || ((long) i2) * j4 > j2) {
                    int i3 = ((int) (j2 / j4)) - 1;
                    this.mRepeatCount = i3;
                    if (i3 < 0) {
                        this.mRepeatCount = 0;
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.mDuration = 0;
        this.mRepeatCount = 0;
    }

    public void scaleCurrentDuration(float f2) {
        this.mDuration = (long) (((float) this.mDuration) * f2);
        this.mStartOffset = (long) (((float) this.mStartOffset) * f2);
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int i2) {
        this.mBackgroundColor = i2;
    }

    public void setDetachWallpaper(boolean z2) {
        this.mDetachWallpaper = z2;
    }

    public void setDuration(long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        this.mDuration = j2;
    }

    public void setFillAfter(boolean z2) {
        this.mFillAfter = z2;
    }

    public void setFillBefore(boolean z2) {
        this.mFillBefore = z2;
    }

    public void setFillEnabled(boolean z2) {
        this.mFillEnabled = z2;
    }

    public void setInterpolator(Context context, int i2) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i2));
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setRepeatCount(int i2) {
        if (i2 < 0) {
            i2 = -1;
        }
        this.mRepeatCount = i2;
    }

    public void setRepeatMode(int i2) {
        this.mRepeatMode = i2;
    }

    public void setStartOffset(long j2) {
        this.mStartOffset = j2;
    }

    public void setStartTime(long j2) {
        this.mStartTime = j2;
        this.mEnded = false;
        this.mStarted = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
    }

    public void setZAdjustment(int i2) {
        this.mZAdjustment = i2;
    }

    public void start() {
        setStartTime(-1);
    }

    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    public boolean willChangeBounds() {
        return true;
    }

    public boolean willChangeTransformationMatrix() {
        return true;
    }
}
