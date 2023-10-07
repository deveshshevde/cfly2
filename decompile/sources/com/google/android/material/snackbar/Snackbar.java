package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class Snackbar extends BaseTransientBottomBar<Snackbar> {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f19631f = {R.attr.snackbarButtonStyle};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f19632g = {R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle};

    /* renamed from: d  reason: collision with root package name */
    private final AccessibilityManager f19633d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19634e;

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), MemoryConstants.GB));
                }
            }
        }

        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    private Snackbar(Context context, ViewGroup viewGroup, View view, a aVar) {
        super(context, viewGroup, view, aVar);
        this.f19633d = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    private static ViewGroup a(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private static Snackbar a(Context context, View view, CharSequence charSequence, int i2) {
        ViewGroup a2 = a(view);
        if (a2 != null) {
            if (context == null) {
                context = a2.getContext();
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(a(context) ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, a2, false);
            Snackbar snackbar = new Snackbar(context, a2, snackbarContentLayout, snackbarContentLayout);
            snackbar.a(charSequence);
            snackbar.a(i2);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    public static Snackbar a(View view, int i2, int i3) {
        return a(view, view.getResources().getText(i2), i3);
    }

    public static Snackbar a(View view, CharSequence charSequence, int i2) {
        return a((Context) null, view, charSequence, i2);
    }

    private static boolean a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f19632g);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    public Snackbar a(CharSequence charSequence) {
        ((SnackbarContentLayout) this.f19578b.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    public Snackbar a(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f19578b.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener((View.OnClickListener) null);
            this.f19634e = false;
        } else {
            this.f19634e = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    Snackbar.this.b(1);
                }
            });
        }
        return this;
    }

    public int c() {
        int c2 = super.c();
        if (c2 == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f19633d.getRecommendedTimeoutMillis(c2, (this.f19634e ? 4 : 0) | 1 | 2);
        } else if (!this.f19634e || !this.f19633d.isTouchExplorationEnabled()) {
            return c2;
        } else {
            return -2;
        }
    }

    public Snackbar e(int i2) {
        ((SnackbarContentLayout) this.f19578b.getChildAt(0)).getActionView().setTextColor(i2);
        return this;
    }

    public void e() {
        super.e();
    }

    public void f() {
        super.f();
    }
}
