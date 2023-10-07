package com.blankj.utilcode.util;

import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Objects;

public final class SnackbarUtils {
    private static final int COLOR_DEFAULT = -16777217;
    private static final int COLOR_ERROR = -65536;
    private static final int COLOR_MESSAGE = -1;
    private static final int COLOR_SUCCESS = -13912576;
    private static final int COLOR_WARNING = -16128;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    private static WeakReference<Snackbar> sWeakSnackbar;
    private View.OnClickListener actionListener;
    private CharSequence actionText;
    private int actionTextColor;
    private int bgColor;
    private int bgResource;
    private int bottomMargin;
    private int duration;
    private CharSequence message;
    private int messageColor;
    private View view;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    private SnackbarUtils(View view2) {
        setDefault();
        this.view = view2;
    }

    public static void addView(int i2, ViewGroup.LayoutParams layoutParams) {
        Objects.requireNonNull(layoutParams, "Argument 'params' of type ViewGroup.LayoutParams (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View view2 = getView();
        if (view2 != null) {
            view2.setPadding(0, 0, 0, 0);
            ((Snackbar.SnackbarLayout) view2).addView(LayoutInflater.from(view2.getContext()).inflate(i2, (ViewGroup) null), -1, layoutParams);
        }
    }

    public static void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        Objects.requireNonNull(view2, "Argument 'child' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(layoutParams, "Argument 'params' of type ViewGroup.LayoutParams (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View view3 = getView();
        if (view3 != null) {
            view3.setPadding(0, 0, 0, 0);
            ((Snackbar.SnackbarLayout) view3).addView(view2, layoutParams);
        }
    }

    public static void dismiss() {
        WeakReference<Snackbar> weakReference = sWeakSnackbar;
        if (weakReference != null && weakReference.get() != null) {
            ((Snackbar) sWeakSnackbar.get()).f();
            sWeakSnackbar = null;
        }
    }

    private static ViewGroup findSuitableParentCopyFromSnackbar(View view2) {
        ViewGroup viewGroup = null;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    continue;
                } else {
                    view2 = null;
                    continue;
                }
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    public static View getView() {
        Snackbar snackbar = (Snackbar) sWeakSnackbar.get();
        if (snackbar == null) {
            return null;
        }
        return snackbar.d();
    }

    private void setDefault() {
        this.message = "";
        this.messageColor = COLOR_DEFAULT;
        this.bgColor = COLOR_DEFAULT;
        this.bgResource = -1;
        this.duration = -1;
        this.actionText = "";
        this.actionTextColor = COLOR_DEFAULT;
        this.bottomMargin = 0;
    }

    public static SnackbarUtils with(View view2) {
        Objects.requireNonNull(view2, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return new SnackbarUtils(view2);
    }

    public SnackbarUtils setAction(CharSequence charSequence, int i2, View.OnClickListener onClickListener) {
        Objects.requireNonNull(charSequence, "Argument 'text' of type CharSequence (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(onClickListener, "Argument 'listener' of type View.OnClickListener (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.actionText = charSequence;
        this.actionTextColor = i2;
        this.actionListener = onClickListener;
        return this;
    }

    public SnackbarUtils setAction(CharSequence charSequence, View.OnClickListener onClickListener) {
        Objects.requireNonNull(charSequence, "Argument 'text' of type CharSequence (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(onClickListener, "Argument 'listener' of type View.OnClickListener (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return setAction(charSequence, COLOR_DEFAULT, onClickListener);
    }

    public SnackbarUtils setBgColor(int i2) {
        this.bgColor = i2;
        return this;
    }

    public SnackbarUtils setBgResource(int i2) {
        this.bgResource = i2;
        return this;
    }

    public SnackbarUtils setBottomMargin(int i2) {
        this.bottomMargin = i2;
        return this;
    }

    public SnackbarUtils setDuration(int i2) {
        this.duration = i2;
        return this;
    }

    public SnackbarUtils setMessage(CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "Argument 'msg' of type CharSequence (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.message = charSequence;
        return this;
    }

    public SnackbarUtils setMessageColor(int i2) {
        this.messageColor = i2;
        return this;
    }

    public Snackbar show() {
        return show(false);
    }

    public Snackbar show(boolean z2) {
        View view2 = this.view;
        if (view2 == null) {
            return null;
        }
        if (z2) {
            ViewGroup findSuitableParentCopyFromSnackbar = findSuitableParentCopyFromSnackbar(view2);
            View findViewWithTag = findSuitableParentCopyFromSnackbar.findViewWithTag("topSnackBarCoordinatorLayout");
            CoordinatorLayout coordinatorLayout = findViewWithTag;
            if (findViewWithTag == null) {
                CoordinatorLayout coordinatorLayout2 = new CoordinatorLayout(view2.getContext());
                coordinatorLayout2.setTag("topSnackBarCoordinatorLayout");
                coordinatorLayout2.setRotation(180.0f);
                if (Build.VERSION.SDK_INT >= 21) {
                    coordinatorLayout2.setElevation(100.0f);
                }
                findSuitableParentCopyFromSnackbar.addView(coordinatorLayout2, -1, -1);
                coordinatorLayout = coordinatorLayout2;
            }
            view2 = coordinatorLayout;
        }
        if (this.messageColor != COLOR_DEFAULT) {
            SpannableString spannableString = new SpannableString(this.message);
            spannableString.setSpan(new ForegroundColorSpan(this.messageColor), 0, spannableString.length(), 33);
            sWeakSnackbar = new WeakReference<>(Snackbar.a(view2, (CharSequence) spannableString, this.duration));
        } else {
            sWeakSnackbar = new WeakReference<>(Snackbar.a(view2, this.message, this.duration));
        }
        Snackbar snackbar = (Snackbar) sWeakSnackbar.get();
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.d();
        if (z2) {
            for (int i2 = 0; i2 < snackbarLayout.getChildCount(); i2++) {
                snackbarLayout.getChildAt(i2).setRotation(180.0f);
            }
        }
        int i3 = this.bgResource;
        if (i3 != -1) {
            snackbarLayout.setBackgroundResource(i3);
        } else {
            int i4 = this.bgColor;
            if (i4 != COLOR_DEFAULT) {
                snackbarLayout.setBackgroundColor(i4);
            }
        }
        if (this.bottomMargin != 0) {
            ((ViewGroup.MarginLayoutParams) snackbarLayout.getLayoutParams()).bottomMargin = this.bottomMargin;
        }
        if (this.actionText.length() > 0 && this.actionListener != null) {
            int i5 = this.actionTextColor;
            if (i5 != COLOR_DEFAULT) {
                snackbar.e(i5);
            }
            snackbar.a(this.actionText, this.actionListener);
        }
        snackbar.e();
        return snackbar;
    }

    public void showError() {
        showError(false);
    }

    public void showError(boolean z2) {
        this.bgColor = COLOR_ERROR;
        this.messageColor = -1;
        this.actionTextColor = -1;
        show(z2);
    }

    public void showSuccess() {
        showSuccess(false);
    }

    public void showSuccess(boolean z2) {
        this.bgColor = COLOR_SUCCESS;
        this.messageColor = -1;
        this.actionTextColor = -1;
        show(z2);
    }

    public void showWarning() {
        showWarning(false);
    }

    public void showWarning(boolean z2) {
        this.bgColor = COLOR_WARNING;
        this.messageColor = -1;
        this.actionTextColor = -1;
        show(z2);
    }
}
