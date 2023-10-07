package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import t.ac;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Drawable f972a;

    /* renamed from: b  reason: collision with root package name */
    Drawable f973b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f974c;

    /* renamed from: d  reason: collision with root package name */
    boolean f975d;

    /* renamed from: e  reason: collision with root package name */
    boolean f976e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f977f;

    /* renamed from: g  reason: collision with root package name */
    private View f978g;

    /* renamed from: h  reason: collision with root package name */
    private View f979h;

    /* renamed from: i  reason: collision with root package name */
    private View f980i;

    /* renamed from: j  reason: collision with root package name */
    private int f981j;

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ac.a((View) this, (Drawable) new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f972a = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f973b = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f981j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean z2 = true;
        if (getId() == R.id.split_action_bar) {
            this.f975d = true;
            this.f974c = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f975d ? !(this.f972a == null && this.f973b == null) : this.f974c != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
    }

    private boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f972a;
        if (drawable != null && drawable.isStateful()) {
            this.f972a.setState(getDrawableState());
        }
        Drawable drawable2 = this.f973b;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f973b.setState(getDrawableState());
        }
        Drawable drawable3 = this.f974c;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f974c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f978g;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f972a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f973b;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f974c;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f979h = findViewById(R.id.action_bar);
        this.f980i = findViewById(R.id.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f977f || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        Drawable drawable2;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z2, i2, i3, i4, i5);
        View view2 = this.f978g;
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (!(view2 == null || view2.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            view2.layout(i2, (measuredHeight - view2.getMeasuredHeight()) - layoutParams.bottomMargin, i4, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.f975d) {
            Drawable drawable3 = this.f974c;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = false;
            }
        } else {
            if (this.f972a != null) {
                if (this.f979h.getVisibility() == 0) {
                    drawable2 = this.f972a;
                    left = this.f979h.getLeft();
                    top = this.f979h.getTop();
                    right = this.f979h.getRight();
                    view = this.f979h;
                } else {
                    View view3 = this.f980i;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f972a.setBounds(0, 0, 0, 0);
                        z4 = true;
                    } else {
                        drawable2 = this.f972a;
                        left = this.f980i.getLeft();
                        top = this.f980i.getTop();
                        right = this.f980i.getRight();
                        view = this.f980i;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z4 = true;
            }
            this.f976e = z5;
            if (!z5 || (drawable = this.f973b) == null) {
                z3 = z4;
            } else {
                drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        }
        if (z3) {
            invalidate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r3.f979h
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L_0x001c
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L_0x001c
            int r0 = r3.f981j
            if (r0 < 0) goto L_0x001c
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = java.lang.Math.min(r0, r5)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L_0x001c:
            super.onMeasure(r4, r5)
            android.view.View r4 = r3.f979h
            if (r4 != 0) goto L_0x0024
            return
        L_0x0024:
            int r4 = android.view.View.MeasureSpec.getMode(r5)
            android.view.View r0 = r3.f978g
            if (r0 == 0) goto L_0x006f
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L_0x006f
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == r0) goto L_0x006f
            android.view.View r0 = r3.f979h
            boolean r0 = r3.a(r0)
            if (r0 != 0) goto L_0x0047
            android.view.View r0 = r3.f979h
        L_0x0042:
            int r0 = r3.b(r0)
            goto L_0x0053
        L_0x0047:
            android.view.View r0 = r3.f980i
            boolean r0 = r3.a(r0)
            if (r0 != 0) goto L_0x0052
            android.view.View r0 = r3.f980i
            goto L_0x0042
        L_0x0052:
            r0 = 0
        L_0x0053:
            if (r4 != r1) goto L_0x005a
            int r4 = android.view.View.MeasureSpec.getSize(r5)
            goto L_0x005d
        L_0x005a:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x005d:
            int r5 = r3.getMeasuredWidth()
            android.view.View r1 = r3.f978g
            int r1 = r3.b(r1)
            int r0 = r0 + r1
            int r4 = java.lang.Math.min(r0, r4)
            r3.setMeasuredDimension(r5, r4)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f972a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f972a);
        }
        this.f972a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f979h;
            if (view != null) {
                this.f972a.setBounds(view.getLeft(), this.f979h.getTop(), this.f979h.getRight(), this.f979h.getBottom());
            }
        }
        boolean z2 = true;
        if (!this.f975d ? !(this.f972a == null && this.f973b == null) : this.f974c != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f974c;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f974c);
        }
        this.f974c = drawable;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f975d && (drawable2 = this.f974c) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f975d ? this.f972a == null && this.f973b == null : this.f974c == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f973b;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f973b);
        }
        this.f973b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f976e && (drawable2 = this.f973b) != null) {
                drawable2.setBounds(this.f978g.getLeft(), this.f978g.getTop(), this.f978g.getRight(), this.f978g.getBottom());
            }
        }
        boolean z2 = true;
        if (!this.f975d ? !(this.f972a == null && this.f973b == null) : this.f974c != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f978g;
        if (view != null) {
            removeView(view);
        }
        this.f978g = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z2) {
        this.f977f = z2;
        setDescendantFocusability(z2 ? 393216 : 262144);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.f972a;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
        Drawable drawable2 = this.f973b;
        if (drawable2 != null) {
            drawable2.setVisible(z2, false);
        }
        Drawable drawable3 = this.f974c;
        if (drawable3 != null) {
            drawable3.setVisible(z2, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f972a && !this.f975d) || (drawable == this.f973b && this.f976e) || ((drawable == this.f974c && this.f975d) || super.verifyDrawable(drawable));
    }
}
