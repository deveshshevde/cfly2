package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import com.blankj.utilcode.constant.MemoryConstants;
import t.ac;
import t.ag;

public class ActionBarContextView extends a {

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f982g;

    /* renamed from: h  reason: collision with root package name */
    private CharSequence f983h;

    /* renamed from: i  reason: collision with root package name */
    private View f984i;

    /* renamed from: j  reason: collision with root package name */
    private View f985j;

    /* renamed from: k  reason: collision with root package name */
    private View f986k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f987l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f988m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f989n;

    /* renamed from: o  reason: collision with root package name */
    private int f990o;

    /* renamed from: p  reason: collision with root package name */
    private int f991p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f992q;

    /* renamed from: r  reason: collision with root package name */
    private int f993r;

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        af a2 = af.a(context, attributeSet, R.styleable.ActionMode, i2, 0);
        ac.a((View) this, a2.a(R.styleable.ActionMode_background));
        this.f990o = a2.g(R.styleable.ActionMode_titleTextStyle, 0);
        this.f991p = a2.g(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f1379e = a2.f(R.styleable.ActionMode_height, 0);
        this.f993r = a2.g(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        a2.b();
    }

    private void e() {
        if (this.f987l == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f987l = linearLayout;
            this.f988m = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f989n = (TextView) this.f987l.findViewById(R.id.action_bar_subtitle);
            if (this.f990o != 0) {
                this.f988m.setTextAppearance(getContext(), this.f990o);
            }
            if (this.f991p != 0) {
                this.f989n.setTextAppearance(getContext(), this.f991p);
            }
        }
        this.f988m.setText(this.f982g);
        this.f989n.setText(this.f983h);
        boolean z2 = !TextUtils.isEmpty(this.f982g);
        boolean z3 = !TextUtils.isEmpty(this.f983h);
        int i2 = 0;
        this.f989n.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout2 = this.f987l;
        if (!z2 && !z3) {
            i2 = 8;
        }
        linearLayout2.setVisibility(i2);
        if (this.f987l.getParent() == null) {
            addView(this.f987l);
        }
    }

    public /* bridge */ /* synthetic */ ag a(int i2, long j2) {
        return super.a(i2, j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final f.b r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.f984i
            if (r0 != 0) goto L_0x0019
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.f993r
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.f984i = r0
        L_0x0015:
            r3.addView(r0)
            goto L_0x0022
        L_0x0019:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x0022
            android.view.View r0 = r3.f984i
            goto L_0x0015
        L_0x0022:
            android.view.View r0 = r3.f984i
            int r1 = androidx.appcompat.R.id.action_mode_close_button
            android.view.View r0 = r0.findViewById(r1)
            r3.f985j = r0
            androidx.appcompat.widget.ActionBarContextView$1 r1 = new androidx.appcompat.widget.ActionBarContextView$1
            r1.<init>(r4)
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.b()
            androidx.appcompat.view.menu.g r4 = (androidx.appcompat.view.menu.g) r4
            androidx.appcompat.widget.ActionMenuPresenter r0 = r3.f1378d
            if (r0 == 0) goto L_0x0043
            androidx.appcompat.widget.ActionMenuPresenter r0 = r3.f1378d
            r0.h()
        L_0x0043:
            androidx.appcompat.widget.ActionMenuPresenter r0 = new androidx.appcompat.widget.ActionMenuPresenter
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.f1378d = r0
            androidx.appcompat.widget.ActionMenuPresenter r0 = r3.f1378d
            r1 = 1
            r0.b((boolean) r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            androidx.appcompat.widget.ActionMenuPresenter r1 = r3.f1378d
            android.content.Context r2 = r3.f1376b
            r4.a((androidx.appcompat.view.menu.m) r1, (android.content.Context) r2)
            androidx.appcompat.widget.ActionMenuPresenter r4 = r3.f1378d
            androidx.appcompat.view.menu.n r4 = r4.a((android.view.ViewGroup) r3)
            androidx.appcompat.widget.ActionMenuView r4 = (androidx.appcompat.widget.ActionMenuView) r4
            r3.f1377c = r4
            androidx.appcompat.widget.ActionMenuView r4 = r3.f1377c
            r1 = 0
            t.ac.a((android.view.View) r4, (android.graphics.drawable.Drawable) r1)
            androidx.appcompat.widget.ActionMenuView r4 = r3.f1377c
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.a(f.b):void");
    }

    public boolean a() {
        if (this.f1378d != null) {
            return this.f1378d.e();
        }
        return false;
    }

    public void b() {
        if (this.f984i == null) {
            c();
        }
    }

    public void c() {
        removeAllViews();
        this.f986k = null;
        this.f1377c = null;
        this.f1378d = null;
        View view = this.f985j;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public boolean d() {
        return this.f992q;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f983h;
    }

    public CharSequence getTitle() {
        return this.f982g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1378d != null) {
            this.f1378d.g();
            this.f1378d.i();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f982g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean a2 = al.a(this);
        int paddingRight = a2 ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f984i;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f984i.getLayoutParams();
            int i6 = a2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a3 = a(paddingRight, i6, a2);
            paddingRight = a(a3 + a(this.f984i, a3, paddingTop, paddingTop2, a2), i7, a2);
        }
        int i8 = paddingRight;
        LinearLayout linearLayout = this.f987l;
        if (!(linearLayout == null || this.f986k != null || linearLayout.getVisibility() == 8)) {
            i8 += a(this.f987l, i8, paddingTop, paddingTop2, a2);
        }
        int i9 = i8;
        View view2 = this.f986k;
        if (view2 != null) {
            a(view2, i9, paddingTop, paddingTop2, a2);
        }
        int paddingLeft = a2 ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        if (this.f1377c != null) {
            a(this.f1377c, paddingLeft, paddingTop, paddingTop2, !a2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int i4 = MemoryConstants.GB;
        if (mode != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i3) != 0) {
            int size = View.MeasureSpec.getSize(i2);
            int size2 = this.f1379e > 0 ? this.f1379e : View.MeasureSpec.getSize(i3);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            View view = this.f984i;
            if (view != null) {
                int a2 = a(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f984i.getLayoutParams();
                paddingLeft = a2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            if (this.f1377c != null && this.f1377c.getParent() == this) {
                paddingLeft = a(this.f1377c, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.f987l;
            if (linearLayout != null && this.f986k == null) {
                if (this.f992q) {
                    this.f987l.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f987l.getMeasuredWidth();
                    boolean z2 = measuredWidth <= paddingLeft;
                    if (z2) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f987l.setVisibility(z2 ? 0 : 8);
                } else {
                    paddingLeft = a(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f986k;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i6 = layoutParams.width != -2 ? MemoryConstants.GB : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i4 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    i5 = Math.min(layoutParams.height, i5);
                }
                this.f986k.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i5, i4));
            }
            if (this.f1379e <= 0) {
                int childCount = getChildCount();
                int i7 = 0;
                for (int i8 = 0; i8 < childCount; i8++) {
                    int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i7) {
                        i7 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i7);
                return;
            }
            setMeasuredDimension(size, size2);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i2) {
        this.f1379e = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f986k;
        if (view2 != null) {
            removeView(view2);
        }
        this.f986k = view;
        if (!(view == null || (linearLayout = this.f987l) == null)) {
            removeView(linearLayout);
            this.f987l = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f983h = charSequence;
        e();
    }

    public void setTitle(CharSequence charSequence) {
        this.f982g = charSequence;
        e();
    }

    public void setTitleOptional(boolean z2) {
        if (z2 != this.f992q) {
            requestLayout();
        }
        this.f992q = z2;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
