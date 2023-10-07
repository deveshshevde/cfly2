package com.amap.api.maps;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

public class SwipeDismissTouchListener implements View.OnTouchListener {
    public static final int A_HALF = 2;
    public static final int MIN_VIEW_WIDTH = 2;
    public static final int ONE_THIRD = 3;
    private long mAnimationTime;
    private DismissCallbacks mCallbacks;
    private boolean mCanFinish;
    private float mDownX;
    private float mDownY;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private boolean mO;
    private int mSlop;
    private boolean mSwiping;
    private int mSwipingSlop;
    private Object mToken;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;
    /* access modifiers changed from: private */
    public View mView;
    private int mViewWidth = 1;

    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);

        void onNotifySwipe();
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.mSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mAnimationTime = (long) view.getContext().getResources().getInteger(17694720);
        this.mView = view;
        this.mToken = obj;
        this.mCallbacks = dismissCallbacks;
    }

    /* access modifiers changed from: private */
    public void a() {
        this.mCallbacks.onDismiss(this.mView, this.mToken);
        final ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        final int height = this.mView.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{height, 1}).setDuration(this.mAnimationTime);
        duration.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                SwipeDismissTouchListener.this.mView.setAlpha(0.0f);
                SwipeDismissTouchListener.this.mView.setTranslationX(0.0f);
                layoutParams.height = height;
                SwipeDismissTouchListener.this.mView.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SwipeDismissTouchListener.this.mView.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r11.mVelocityTracker == null) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a7, code lost:
        if (r11.mSwiping != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
            r11 = this;
            float r12 = r11.mTranslationX
            r0 = 0
            r13.offsetLocation(r12, r0)
            int r12 = r11.mViewWidth
            r1 = 2
            if (r12 >= r1) goto L_0x0013
            android.view.View r12 = r11.mView
            int r12 = r12.getWidth()
            r11.mViewWidth = r12
        L_0x0013:
            int r12 = r13.getActionMasked()
            r2 = 0
            r3 = 1
            if (r12 == 0) goto L_0x01ac
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r12 == r3) goto L_0x00fe
            r6 = 3
            if (r12 == r1) goto L_0x0053
            if (r12 == r6) goto L_0x0027
            goto L_0x01ab
        L_0x0027:
            android.view.VelocityTracker r12 = r11.mVelocityTracker
            if (r12 == 0) goto L_0x01ab
        L_0x002b:
            android.view.View r12 = r11.mView
            android.view.ViewPropertyAnimator r12 = r12.animate()
            android.view.ViewPropertyAnimator r12 = r12.translationX(r0)
            android.view.ViewPropertyAnimator r12 = r12.alpha(r5)
            long r5 = r11.mAnimationTime
            android.view.ViewPropertyAnimator r12 = r12.setDuration(r5)
            r12.setListener(r4)
        L_0x0042:
            android.view.VelocityTracker r12 = r11.mVelocityTracker
            r12.recycle()
            r11.mVelocityTracker = r4
            r11.mTranslationX = r0
            r11.mDownX = r0
            r11.mDownY = r0
            r11.mSwiping = r2
            goto L_0x01ab
        L_0x0053:
            android.view.VelocityTracker r12 = r11.mVelocityTracker
            if (r12 == 0) goto L_0x01ab
            r12.addMovement(r13)
            float r12 = r13.getRawX()
            float r1 = r11.mDownX
            float r12 = r12 - r1
            float r1 = r13.getRawY()
            float r4 = r11.mDownY
            float r1 = r1 - r4
            float r4 = java.lang.Math.abs(r12)
            int r7 = r11.mSlop
            float r7 = (float) r7
            r8 = 1073741824(0x40000000, float:2.0)
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x00d4
            float r1 = java.lang.Math.abs(r1)
            float r4 = java.lang.Math.abs(r12)
            float r4 = r4 / r8
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00d4
            r11.mSwiping = r3
            int r1 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x008b
            int r1 = r11.mSlop
            goto L_0x008e
        L_0x008b:
            int r1 = r11.mSlop
            int r1 = -r1
        L_0x008e:
            r11.mSwipingSlop = r1
            android.view.View r1 = r11.mView
            android.view.ViewParent r1 = r1.getParent()
            r1.requestDisallowInterceptTouchEvent(r3)
            boolean r1 = r11.mO
            if (r1 != 0) goto L_0x00a4
            r11.mO = r3
            com.amap.api.maps.SwipeDismissTouchListener$DismissCallbacks r1 = r11.mCallbacks
            r1.onNotifySwipe()
        L_0x00a4:
            float r1 = java.lang.Math.abs(r12)
            int r4 = r11.mViewWidth
            int r4 = r4 / r6
            float r4 = (float) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00bc
            boolean r1 = r11.mCanFinish
            if (r1 != 0) goto L_0x00be
            r11.mCanFinish = r3
            com.amap.api.maps.SwipeDismissTouchListener$DismissCallbacks r1 = r11.mCallbacks
            r1.onNotifySwipe()
            goto L_0x00be
        L_0x00bc:
            r11.mCanFinish = r2
        L_0x00be:
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r13)
            int r13 = r13.getActionIndex()
            int r13 = r13 << 8
            r13 = r13 | r6
            r1.setAction(r13)
            android.view.View r13 = r11.mView
            r13.onTouchEvent(r1)
            r1.recycle()
        L_0x00d4:
            boolean r13 = r11.mSwiping
            if (r13 == 0) goto L_0x01ab
            r11.mTranslationX = r12
            android.view.View r13 = r11.mView
            int r1 = r11.mSwipingSlop
            float r1 = (float) r1
            float r1 = r12 - r1
            r13.setTranslationX(r1)
            android.view.View r13 = r11.mView
            float r12 = java.lang.Math.abs(r12)
            float r12 = r12 * r8
            int r1 = r11.mViewWidth
            float r1 = (float) r1
            float r12 = r12 / r1
            float r12 = r5 - r12
            float r12 = java.lang.Math.min(r5, r12)
            float r12 = java.lang.Math.max(r0, r12)
            r13.setAlpha(r12)
            return r3
        L_0x00fe:
            android.view.VelocityTracker r12 = r11.mVelocityTracker
            if (r12 == 0) goto L_0x01ab
            float r12 = r13.getRawX()
            float r6 = r11.mDownX
            float r12 = r12 - r6
            android.view.VelocityTracker r6 = r11.mVelocityTracker
            r6.addMovement(r13)
            android.view.VelocityTracker r13 = r11.mVelocityTracker
            r6 = 1000(0x3e8, float:1.401E-42)
            r13.computeCurrentVelocity(r6)
            android.view.VelocityTracker r13 = r11.mVelocityTracker
            float r13 = r13.getXVelocity()
            float r6 = java.lang.Math.abs(r13)
            android.view.VelocityTracker r7 = r11.mVelocityTracker
            float r7 = r7.getYVelocity()
            float r7 = java.lang.Math.abs(r7)
            float r8 = java.lang.Math.abs(r12)
            int r9 = r11.mViewWidth
            int r9 = r9 / r1
            float r1 = (float) r9
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0141
            boolean r1 = r11.mSwiping
            if (r1 == 0) goto L_0x0141
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 <= 0) goto L_0x013f
            r12 = 1
            goto L_0x017c
        L_0x013f:
            r12 = 0
            goto L_0x017c
        L_0x0141:
            int r1 = r11.mMinFlingVelocity
            float r1 = (float) r1
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 > 0) goto L_0x017a
            int r1 = r11.mMaxFlingVelocity
            float r1 = (float) r1
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x017a
            int r1 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x017a
            boolean r1 = r11.mSwiping
            if (r1 == 0) goto L_0x017a
            int r13 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r13 >= 0) goto L_0x015d
            r13 = 1
            goto L_0x015e
        L_0x015d:
            r13 = 0
        L_0x015e:
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 >= 0) goto L_0x0164
            r12 = 1
            goto L_0x0165
        L_0x0164:
            r12 = 0
        L_0x0165:
            if (r13 != r12) goto L_0x0169
            r12 = 1
            goto L_0x016a
        L_0x0169:
            r12 = 0
        L_0x016a:
            android.view.VelocityTracker r13 = r11.mVelocityTracker
            float r13 = r13.getXVelocity()
            int r13 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r13 <= 0) goto L_0x0175
            goto L_0x0176
        L_0x0175:
            r3 = 0
        L_0x0176:
            r10 = r3
            r3 = r12
            r12 = r10
            goto L_0x017c
        L_0x017a:
            r12 = 0
            r3 = 0
        L_0x017c:
            if (r3 == 0) goto L_0x01a5
            android.view.View r13 = r11.mView
            android.view.ViewPropertyAnimator r13 = r13.animate()
            if (r12 == 0) goto L_0x0189
            int r12 = r11.mViewWidth
            goto L_0x018c
        L_0x0189:
            int r12 = r11.mViewWidth
            int r12 = -r12
        L_0x018c:
            float r12 = (float) r12
            android.view.ViewPropertyAnimator r12 = r13.translationX(r12)
            android.view.ViewPropertyAnimator r12 = r12.alpha(r0)
            r5 = 50
            android.view.ViewPropertyAnimator r12 = r12.setDuration(r5)
            com.amap.api.maps.SwipeDismissTouchListener$1 r13 = new com.amap.api.maps.SwipeDismissTouchListener$1
            r13.<init>()
            r12.setListener(r13)
            goto L_0x0042
        L_0x01a5:
            boolean r12 = r11.mSwiping
            if (r12 == 0) goto L_0x0042
            goto L_0x002b
        L_0x01ab:
            return r2
        L_0x01ac:
            float r12 = r13.getRawX()
            r11.mDownX = r12
            float r12 = r13.getRawY()
            r11.mDownY = r12
            com.amap.api.maps.SwipeDismissTouchListener$DismissCallbacks r12 = r11.mCallbacks
            java.lang.Object r0 = r11.mToken
            boolean r12 = r12.canDismiss(r0)
            if (r12 == 0) goto L_0x01cd
            r11.mO = r2
            android.view.VelocityTracker r12 = android.view.VelocityTracker.obtain()
            r11.mVelocityTracker = r12
            r12.addMovement(r13)
        L_0x01cd:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.SwipeDismissTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
