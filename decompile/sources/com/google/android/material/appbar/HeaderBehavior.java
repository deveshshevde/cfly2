package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import t.ac;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* renamed from: a  reason: collision with root package name */
    OverScroller f18460a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f18461b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18462c;

    /* renamed from: d  reason: collision with root package name */
    private int f18463d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f18464e;

    /* renamed from: f  reason: collision with root package name */
    private int f18465f = -1;

    /* renamed from: g  reason: collision with root package name */
    private VelocityTracker f18466g;

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final CoordinatorLayout f18468b;

        /* renamed from: c  reason: collision with root package name */
        private final V f18469c;

        a(CoordinatorLayout coordinatorLayout, V v2) {
            this.f18468b = coordinatorLayout;
            this.f18469c = v2;
        }

        public void run() {
            if (this.f18469c != null && HeaderBehavior.this.f18460a != null) {
                if (HeaderBehavior.this.f18460a.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.a_(this.f18468b, this.f18469c, headerBehavior.f18460a.getCurrY());
                    ac.a((View) this.f18469c, (Runnable) this);
                    return;
                }
                HeaderBehavior.this.e(this.f18468b, this.f18469c);
            }
        }
    }

    public HeaderBehavior() {
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d() {
        if (this.f18466g == null) {
            this.f18466g = VelocityTracker.obtain();
        }
    }

    /* access modifiers changed from: package-private */
    public int a(V v2) {
        return v2.getHeight();
    }

    /* access modifiers changed from: package-private */
    public int a(CoordinatorLayout coordinatorLayout, V v2, int i2, int i3, int i4) {
        int a2;
        int c2 = c();
        if (i3 == 0 || c2 < i3 || c2 > i4 || c2 == (a2 = o.a.a(i2, i3, i4))) {
            return 0;
        }
        a(a2);
        return c2 - a2;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(CoordinatorLayout coordinatorLayout, V v2, int i2, int i3, float f2) {
        V v3 = v2;
        Runnable runnable = this.f18461b;
        if (runnable != null) {
            v2.removeCallbacks(runnable);
            this.f18461b = null;
        }
        if (this.f18460a == null) {
            this.f18460a = new OverScroller(v2.getContext());
        }
        this.f18460a.fling(0, c(), 0, Math.round(f2), 0, 0, i2, i3);
        if (this.f18460a.computeScrollOffset()) {
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            a aVar = new a(coordinatorLayout, v2);
            this.f18461b = aVar;
            ac.a((View) v2, (Runnable) aVar);
            return true;
        }
        CoordinatorLayout coordinatorLayout3 = coordinatorLayout;
        e(coordinatorLayout, v2);
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f18465f < 0) {
            this.f18465f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f18462c) {
            int i2 = this.f18463d;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y2 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y2 - this.f18464e) > this.f18465f) {
                this.f18464e = y2;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f18463d = -1;
            int x2 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            boolean z2 = c(v2) && coordinatorLayout.a((View) v2, x2, y3);
            this.f18462c = z2;
            if (z2) {
                this.f18464e = y3;
                this.f18463d = motionEvent.getPointerId(0);
                d();
                OverScroller overScroller = this.f18460a;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f18460a.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f18466g;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int a_(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        return a(coordinatorLayout, v2, i2, Integer.MIN_VALUE, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return c();
    }

    /* access modifiers changed from: package-private */
    public int b(V v2) {
        return -v2.getHeight();
    }

    /* access modifiers changed from: package-private */
    public final int b(CoordinatorLayout coordinatorLayout, V v2, int i2, int i3, int i4) {
        return a(coordinatorLayout, v2, b() - i2, i3, i4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L_0x004e
            r4 = 2
            if (r0 == r4) goto L_0x002d
            r12 = 3
            if (r0 == r12) goto L_0x0072
            r12 = 6
            if (r0 == r12) goto L_0x0013
            goto L_0x004c
        L_0x0013:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L_0x001b
            r12 = 1
            goto L_0x001c
        L_0x001b:
            r12 = 0
        L_0x001c:
            int r13 = r14.getPointerId(r12)
            r11.f18463d = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f18464e = r12
            goto L_0x004c
        L_0x002d:
            int r0 = r11.f18463d
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L_0x0036
            return r3
        L_0x0036:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f18464e
            int r7 = r1 - r0
            r11.f18464e = r0
            int r8 = r11.b(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.b(r5, r6, r7, r8, r9)
        L_0x004c:
            r12 = 0
            goto L_0x0081
        L_0x004e:
            android.view.VelocityTracker r0 = r11.f18466g
            if (r0 == 0) goto L_0x0072
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f18466g
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f18466g
            int r4 = r11.f18463d
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.a(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.a((androidx.coordinatorlayout.widget.CoordinatorLayout) r6, r7, (int) r8, (int) r9, (float) r10)
            r12 = 1
            goto L_0x0073
        L_0x0072:
            r12 = 0
        L_0x0073:
            r11.f18462c = r3
            r11.f18463d = r1
            android.view.VelocityTracker r13 = r11.f18466g
            if (r13 == 0) goto L_0x0081
            r13.recycle()
            r13 = 0
            r11.f18466g = r13
        L_0x0081:
            android.view.VelocityTracker r13 = r11.f18466g
            if (r13 == 0) goto L_0x0088
            r13.addMovement(r14)
        L_0x0088:
            boolean r13 = r11.f18462c
            if (r13 != 0) goto L_0x0090
            if (r12 == 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r2 = 0
        L_0x0090:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.b(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean c(V v2) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void e(CoordinatorLayout coordinatorLayout, V v2) {
    }
}
