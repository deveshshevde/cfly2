package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import t.ac;
import t.ag;
import t.ah;

abstract class a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final C0018a f1375a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f1376b;

    /* renamed from: c  reason: collision with root package name */
    protected ActionMenuView f1377c;

    /* renamed from: d  reason: collision with root package name */
    protected ActionMenuPresenter f1378d;

    /* renamed from: e  reason: collision with root package name */
    protected int f1379e;

    /* renamed from: f  reason: collision with root package name */
    protected ag f1380f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1381g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1382h;

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    protected class C0018a implements ah {

        /* renamed from: a  reason: collision with root package name */
        int f1383a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1385c = false;

        protected C0018a() {
        }

        public C0018a a(ag agVar, int i2) {
            a.this.f1380f = agVar;
            this.f1383a = i2;
            return this;
        }

        public void a(View view) {
            a.super.setVisibility(0);
            this.f1385c = false;
        }

        public void b(View view) {
            if (!this.f1385c) {
                a.this.f1380f = null;
                a.super.setVisibility(this.f1383a);
            }
        }

        public void c(View view) {
            this.f1385c = true;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1375a = new C0018a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1376b = context;
        } else {
            this.f1376b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int a(int i2, int i3, boolean z2) {
        return z2 ? i2 - i3 : i2 + i3;
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i2, int i3, int i4, boolean z2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z2) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z2 ? -measuredWidth : measuredWidth;
    }

    public ag a(int i2, long j2) {
        ag a2;
        ag agVar = this.f1380f;
        if (agVar != null) {
            agVar.b();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            a2 = ac.r(this).a(1.0f);
        } else {
            a2 = ac.r(this).a(0.0f);
        }
        a2.a(j2);
        a2.a((ah) this.f1375a.a(a2, i2));
        return a2;
    }

    public boolean a() {
        ActionMenuPresenter actionMenuPresenter = this.f1378d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.e();
        }
        return false;
    }

    public int getAnimatedVisibility() {
        return this.f1380f != null ? this.f1375a.f1383a : getVisibility();
    }

    public int getContentHeight() {
        return this.f1379e;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1378d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1382h = false;
        }
        if (!this.f1382h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1382h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1382h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1381g = false;
        }
        if (!this.f1381g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1381g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1381g = false;
        }
        return true;
    }

    public void setContentHeight(int i2) {
        this.f1379e = i2;
        requestLayout();
    }

    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            ag agVar = this.f1380f;
            if (agVar != null) {
                agVar.b();
            }
            super.setVisibility(i2);
        }
    }
}
