package com.autonavi.amap.mapcore.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;
import java.util.ArrayList;
import java.util.List;

public class GLAnimationSet extends GLAnimation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private ArrayList<GLAnimation> mAnimations = new ArrayList<>();
    private boolean mDirty;
    private int mFlags = 0;
    private boolean mHasAlpha;
    private long mLastEnd;
    private GLTransformation mTempTransformation = new GLTransformation();

    public GLAnimationSet(boolean z2) {
        setFlag(16, z2);
        init();
    }

    private void init() {
        this.mStartTime = 0;
    }

    private void setFlag(int i2, boolean z2) {
        int i3;
        if (z2) {
            i3 = i2 | this.mFlags;
        } else {
            i3 = (i2 ^ -1) & this.mFlags;
        }
        this.mFlags = i3;
    }

    public void addAnimation(Animation animation) {
        this.mAnimations.add(animation.glAnimation);
        boolean z2 = false;
        if (((this.mFlags & 64) == 0) && animation.glAnimation.willChangeTransformationMatrix()) {
            this.mFlags |= 64;
        }
        if ((this.mFlags & 128) == 0) {
            z2 = true;
        }
        if (z2 && animation.glAnimation.willChangeBounds()) {
            this.mFlags |= 128;
        }
        if ((this.mFlags & 32) != 32) {
            if (this.mAnimations.size() == 1) {
                this.mDuration = animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration();
            } else {
                long max = Math.max(this.mLastEnd, animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration());
                this.mLastEnd = max;
                this.mDuration = max - this.mStartOffset;
                this.mDirty = true;
            }
        }
        this.mLastEnd = this.mStartOffset + this.mDuration;
        this.mDirty = true;
    }

    public void cleanAnimation() {
        this.mAnimations.clear();
    }

    public GLAnimationSet clone() throws CloneNotSupportedException {
        GLAnimationSet gLAnimationSet = (GLAnimationSet) super.clone();
        gLAnimationSet.mTempTransformation = new GLTransformation();
        gLAnimationSet.mAnimations = new ArrayList<>();
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i2 = 0; i2 < size; i2++) {
            gLAnimationSet.mAnimations.add(arrayList.get(i2).clone());
        }
        return gLAnimationSet;
    }

    public long computeDurationHint() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j2 = 0;
        for (int i2 = size - 1; i2 >= 0; i2--) {
            long computeDurationHint = arrayList.get(i2).computeDurationHint();
            if (computeDurationHint > j2) {
                j2 = computeDurationHint;
            }
        }
        return j2;
    }

    public List<GLAnimation> getAnimations() {
        return this.mAnimations;
    }

    public long getDuration() {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        if ((this.mFlags & 32) == 32) {
            return this.mDuration;
        }
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            j2 = Math.max(j2, arrayList.get(i2).getDuration());
        }
        return j2;
    }

    public long getStartTime() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            j2 = Math.min(j2, arrayList.get(i2).getStartTime());
        }
        return j2;
    }

    public boolean getTransformation(long j2, GLTransformation gLTransformation) {
        if (!this.mInitialized) {
            initialize();
        }
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        GLTransformation gLTransformation2 = this.mTempTransformation;
        gLTransformation.clear();
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = true;
        for (int i2 = size - 1; i2 >= 0; i2--) {
            GLAnimation gLAnimation = arrayList.get(i2);
            gLTransformation2.clear();
            z3 = gLAnimation.getTransformation(j2, gLTransformation, getScaleFactor()) || z3;
            z2 = z2 || gLAnimation.hasStarted();
            z4 = gLAnimation.hasEnded() && z4;
        }
        if (z2) {
            try {
                if (!this.mStarted) {
                    if (this.mListener != null) {
                        this.mListener.onAnimationStart();
                    }
                    this.mStarted = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (z4 != this.mEnded) {
            if (this.mListener != null) {
                this.mListener.onAnimationEnd();
            }
            this.mEnded = z4;
        }
        return z3;
    }

    public boolean hasAlpha() {
        if (this.mDirty) {
            int i2 = 0;
            this.mHasAlpha = false;
            this.mDirty = false;
            int size = this.mAnimations.size();
            ArrayList<GLAnimation> arrayList = this.mAnimations;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (arrayList.get(i2).hasAlpha()) {
                    this.mHasAlpha = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return this.mHasAlpha;
    }

    public void initialize() {
        boolean z2;
        boolean z3;
        super.initialize();
        int i2 = this.mFlags;
        boolean z4 = true;
        boolean z5 = (i2 & 32) == 32;
        boolean z6 = (i2 & 1) == 1;
        boolean z7 = (i2 & 2) == 2;
        boolean z8 = (i2 & 4) == 4;
        boolean z9 = (i2 & 16) == 16;
        if ((i2 & 8) != 8) {
            z4 = false;
        }
        if (z9) {
            ensureInterpolator();
        }
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        long j2 = this.mDuration;
        boolean z10 = this.mFillAfter;
        boolean z11 = this.mFillBefore;
        int i3 = this.mRepeatMode;
        Interpolator interpolator = this.mInterpolator;
        boolean z12 = z4;
        long j3 = this.mStartOffset;
        int i4 = 0;
        while (i4 < size) {
            ArrayList<GLAnimation> arrayList2 = arrayList;
            GLAnimation gLAnimation = arrayList.get(i4);
            if (z5) {
                gLAnimation.setDuration(j2);
            }
            if (z6) {
                gLAnimation.setFillAfter(z10);
            }
            if (z7) {
                gLAnimation.setFillBefore(z11);
            }
            if (z8) {
                gLAnimation.setRepeatMode(i3);
            }
            if (z9) {
                gLAnimation.setInterpolator(interpolator);
            }
            if (z12) {
                z3 = z5;
                z2 = z6;
                gLAnimation.setStartOffset(gLAnimation.getStartOffset() + j3);
            } else {
                z3 = z5;
                z2 = z6;
            }
            gLAnimation.initialize();
            i4++;
            z5 = z3;
            arrayList = arrayList2;
            z6 = z2;
        }
    }

    public void reset() {
        super.reset();
    }

    public void restrictDuration(long j2) {
        super.restrictDuration(j2);
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).restrictDuration(j2);
        }
    }

    public void scaleCurrentDuration(float f2) {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).scaleCurrentDuration(f2);
        }
    }

    public void setDuration(long j2) {
        this.mFlags |= 32;
        super.setDuration(j2);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    public void setFillAfter(boolean z2) {
        this.mFlags |= 1;
        super.setFillAfter(z2);
    }

    public void setFillBefore(boolean z2) {
        this.mFlags |= 2;
        super.setFillBefore(z2);
    }

    public void setRepeatMode(int i2) {
        this.mFlags |= 4;
        super.setRepeatMode(i2);
    }

    public void setStartOffset(long j2) {
        this.mFlags |= 8;
        super.setStartOffset(j2);
    }

    public void setStartTime(long j2) {
        super.setStartTime(j2);
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).setStartTime(j2);
        }
    }

    public boolean willChangeBounds() {
        return (this.mFlags & 128) == 128;
    }

    public boolean willChangeTransformationMatrix() {
        return (this.mFlags & 64) == 64;
    }
}
