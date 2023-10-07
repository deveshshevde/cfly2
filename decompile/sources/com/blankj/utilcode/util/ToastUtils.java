package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.k;
import androidx.core.content.b;
import com.blankj.utilcode.R;
import com.blankj.utilcode.util.Utils;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Objects;
import t.ac;

public final class ToastUtils {
    private static final int COLOR_DEFAULT = -16777217;
    private static final ToastUtils DEFAULT_MAKER = make();
    private static final String NOTHING = "toast nothing";
    private static final String NULL = "toast null";
    private static final String TAG_TOAST = "TAG_TOAST";
    /* access modifiers changed from: private */
    public static WeakReference<IToast> sWeakToast;
    private boolean isLong = false;
    private boolean isNotUseSystemToast = false;
    /* access modifiers changed from: private */
    public int mBgColor = COLOR_DEFAULT;
    /* access modifiers changed from: private */
    public int mBgResource = -1;
    /* access modifiers changed from: private */
    public int mGravity = -1;
    private Drawable[] mIcons = new Drawable[4];
    private String mMode;
    /* access modifiers changed from: private */
    public int mTextColor = COLOR_DEFAULT;
    /* access modifiers changed from: private */
    public int mTextSize = -1;
    /* access modifiers changed from: private */
    public int mXOffset = -1;
    /* access modifiers changed from: private */
    public int mYOffset = -1;

    static abstract class AbsToast implements IToast {
        protected Toast mToast = new Toast(Utils.getApp());
        protected ToastUtils mToastUtils;
        protected View mToastView;

        AbsToast(ToastUtils toastUtils) {
            this.mToastUtils = toastUtils;
            if (toastUtils.mGravity != -1 || this.mToastUtils.mXOffset != -1 || this.mToastUtils.mYOffset != -1) {
                this.mToast.setGravity(this.mToastUtils.mGravity, this.mToastUtils.mXOffset, this.mToastUtils.mYOffset);
            }
        }

        private void processRtlIfNeed() {
            if (UtilsBridge.isLayoutRtl()) {
                setToastView(getToastViewSnapshot(-1));
            }
        }

        private void setBg(TextView textView) {
            Drawable mutate;
            PorterDuffColorFilter porterDuffColorFilter;
            if (this.mToastUtils.mBgResource != -1) {
                this.mToastView.setBackgroundResource(this.mToastUtils.mBgResource);
            } else if (this.mToastUtils.mBgColor != ToastUtils.COLOR_DEFAULT) {
                Drawable background = this.mToastView.getBackground();
                Drawable background2 = textView.getBackground();
                if (background == null || background2 == null) {
                    if (background != null) {
                        mutate = background.mutate();
                        porterDuffColorFilter = new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN);
                    } else if (background2 != null) {
                        mutate = background2.mutate();
                        porterDuffColorFilter = new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN);
                    } else {
                        this.mToastView.setBackgroundColor(this.mToastUtils.mBgColor);
                        return;
                    }
                    mutate.setColorFilter(porterDuffColorFilter);
                    return;
                }
                background.mutate().setColorFilter(new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN));
            } else {
                return;
            }
            textView.setBackgroundColor(0);
        }

        public void cancel() {
            Toast toast = this.mToast;
            if (toast != null) {
                toast.cancel();
            }
            this.mToast = null;
            this.mToastView = null;
        }

        /* access modifiers changed from: package-private */
        public View getToastViewSnapshot(int i2) {
            Bitmap view2Bitmap = UtilsBridge.view2Bitmap(this.mToastView);
            ImageView imageView = new ImageView(Utils.getApp());
            imageView.setTag(ToastUtils.TAG_TOAST + i2);
            imageView.setImageBitmap(view2Bitmap);
            return imageView;
        }

        public void setToastView(View view) {
            this.mToastView = view;
            this.mToast.setView(view);
        }

        public void setToastView(CharSequence charSequence) {
            View access$700 = this.mToastUtils.tryApplyUtilsToastView(charSequence);
            if (access$700 != null) {
                setToastView(access$700);
            } else {
                View view = this.mToast.getView();
                this.mToastView = view;
                if (view == null || view.findViewById(16908299) == null) {
                    setToastView(UtilsBridge.layoutId2View(R.layout.utils_toast_view));
                }
                TextView textView = (TextView) this.mToastView.findViewById(16908299);
                textView.setText(charSequence);
                if (this.mToastUtils.mTextColor != ToastUtils.COLOR_DEFAULT) {
                    textView.setTextColor(this.mToastUtils.mTextColor);
                }
                if (this.mToastUtils.mTextSize != -1) {
                    textView.setTextSize((float) this.mToastUtils.mTextSize);
                }
                setBg(textView);
            }
            processRtlIfNeed();
        }
    }

    static final class ActivityToast extends AbsToast {
        private static int sShowingIndex;
        private IToast iToast;
        private Utils.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

        ActivityToast(ToastUtils toastUtils) {
            super(toastUtils);
        }

        /* access modifiers changed from: private */
        public boolean isShowing() {
            return this.mActivityLifecycleCallbacks != null;
        }

        private void registerLifecycleCallback() {
            final int i2 = sShowingIndex;
            AnonymousClass2 r1 = new Utils.ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity) {
                    Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                    if (ActivityToast.this.isShowing()) {
                        ActivityToast.this.showWithActivityView(activity, i2, false);
                    }
                }
            };
            this.mActivityLifecycleCallbacks = r1;
            UtilsBridge.addActivityLifecycleCallbacks(r1);
        }

        private IToast showSystemToast(int i2) {
            SystemToast systemToast = new SystemToast(this.mToastUtils);
            systemToast.mToast = this.mToast;
            systemToast.show(i2);
            return systemToast;
        }

        /* access modifiers changed from: private */
        public void showWithActivityView(Activity activity, int i2, boolean z2) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.mToast.getGravity();
                layoutParams.bottomMargin = this.mToast.getYOffset() + UtilsBridge.getNavBarHeight();
                layoutParams.topMargin = this.mToast.getYOffset() + UtilsBridge.getStatusBarHeight();
                layoutParams.leftMargin = this.mToast.getXOffset();
                View toastViewSnapshot = getToastViewSnapshot(i2);
                if (z2) {
                    toastViewSnapshot.setAlpha(0.0f);
                    toastViewSnapshot.animate().alpha(1.0f).setDuration(200).start();
                }
                viewGroup.addView(toastViewSnapshot, layoutParams);
            }
        }

        private IToast showWithActivityWindow(Activity activity, int i2) {
            WindowManagerToast windowManagerToast = new WindowManagerToast(this.mToastUtils, activity.getWindowManager(), 99);
            windowManagerToast.mToastView = getToastViewSnapshot(-1);
            windowManagerToast.mToast = this.mToast;
            windowManagerToast.show(i2);
            return windowManagerToast;
        }

        private void unregisterLifecycleCallback() {
            UtilsBridge.removeActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
            this.mActivityLifecycleCallbacks = null;
        }

        public void cancel() {
            Window window;
            if (isShowing()) {
                unregisterLifecycleCallback();
                for (Activity next : UtilsBridge.getActivityList()) {
                    if (UtilsBridge.isActivityAlive(next) && (window = next.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb = new StringBuilder();
                        sb.append(ToastUtils.TAG_TOAST);
                        sb.append(sShowingIndex - 1);
                        View findViewWithTag = viewGroup.findViewWithTag(sb.toString());
                        if (findViewWithTag != null) {
                            try {
                                viewGroup.removeView(findViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            IToast iToast2 = this.iToast;
            if (iToast2 != null) {
                iToast2.cancel();
                this.iToast = null;
            }
            super.cancel();
        }

        public void show(int i2) {
            if (this.mToast != null) {
                if (!UtilsBridge.isAppForeground()) {
                    this.iToast = showSystemToast(i2);
                    return;
                }
                boolean z2 = false;
                for (Activity next : UtilsBridge.getActivityList()) {
                    if (UtilsBridge.isActivityAlive(next)) {
                        if (!z2) {
                            this.iToast = showWithActivityWindow(next, i2);
                            z2 = true;
                        } else {
                            showWithActivityView(next, sShowingIndex, true);
                        }
                    }
                }
                if (z2) {
                    registerLifecycleCallback();
                    UtilsBridge.runOnUiThreadDelayed(new Runnable() {
                        public void run() {
                            ActivityToast.this.cancel();
                        }
                    }, i2 == 0 ? 2000 : 3500);
                    sShowingIndex++;
                    return;
                }
                this.iToast = showSystemToast(i2);
            }
        }
    }

    interface IToast {
        void cancel();

        void setToastView(View view);

        void setToastView(CharSequence charSequence);

        void show(int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MODE {
        public static final String DARK = "dark";
        public static final String LIGHT = "light";
    }

    static final class SystemToast extends AbsToast {

        static class SafeHandler extends Handler {
            private Handler impl;

            SafeHandler(Handler handler) {
                this.impl = handler;
            }

            public void dispatchMessage(Message message) {
                Objects.requireNonNull(message, "Argument 'msg' of type Message (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                try {
                    this.impl.dispatchMessage(message);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            public void handleMessage(Message message) {
                Objects.requireNonNull(message, "Argument 'msg' of type Message (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                this.impl.handleMessage(message);
            }
        }

        SystemToast(ToastUtils toastUtils) {
            super(toastUtils);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.mToast);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new SafeHandler((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        public void show(int i2) {
            if (this.mToast != null) {
                this.mToast.setDuration(i2);
                this.mToast.show();
            }
        }
    }

    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {
        private static final int SPACING = UtilsBridge.dp2px(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(UtilsBridge.getAppScreenWidth() - SPACING, Integer.MIN_VALUE), i3);
        }
    }

    static final class WindowManagerToast extends AbsToast {
        private WindowManager.LayoutParams mParams;
        private WindowManager mWM;

        WindowManagerToast(ToastUtils toastUtils, int i2) {
            super(toastUtils);
            this.mParams = new WindowManager.LayoutParams();
            this.mWM = (WindowManager) Utils.getApp().getSystemService("window");
            this.mParams.type = i2;
        }

        WindowManagerToast(ToastUtils toastUtils, WindowManager windowManager, int i2) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.mParams = layoutParams;
            this.mWM = windowManager;
            layoutParams.type = i2;
        }

        public void cancel() {
            try {
                WindowManager windowManager = this.mWM;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.mToastView);
                    this.mWM = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }

        public void show(int i2) {
            if (this.mToast != null) {
                this.mParams.height = -2;
                this.mParams.width = -2;
                this.mParams.format = -3;
                this.mParams.windowAnimations = 16973828;
                this.mParams.setTitle("ToastWithoutNotification");
                this.mParams.flags = 152;
                this.mParams.packageName = Utils.getApp().getPackageName();
                this.mParams.gravity = this.mToast.getGravity();
                if ((this.mParams.gravity & 7) == 7) {
                    this.mParams.horizontalWeight = 1.0f;
                }
                if ((this.mParams.gravity & 112) == 112) {
                    this.mParams.verticalWeight = 1.0f;
                }
                this.mParams.x = this.mToast.getXOffset();
                this.mParams.y = this.mToast.getYOffset();
                this.mParams.horizontalMargin = this.mToast.getHorizontalMargin();
                this.mParams.verticalMargin = this.mToast.getVerticalMargin();
                try {
                    WindowManager windowManager = this.mWM;
                    if (windowManager != null) {
                        windowManager.addView(this.mToastView, this.mParams);
                    }
                } catch (Exception unused) {
                }
                UtilsBridge.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        WindowManagerToast.this.cancel();
                    }
                }, i2 == 0 ? 2000 : 3500);
            }
        }
    }

    public static void cancel() {
        UtilsBridge.runOnUiThread(new Runnable() {
            public void run() {
                if (ToastUtils.sWeakToast != null) {
                    IToast iToast = (IToast) ToastUtils.sWeakToast.get();
                    if (iToast != null) {
                        iToast.cancel();
                    }
                    WeakReference unused = ToastUtils.sWeakToast = null;
                }
            }
        });
    }

    public static ToastUtils getDefaultMaker() {
        ToastUtils toastUtils = DEFAULT_MAKER;
        Objects.requireNonNull(toastUtils, "Detected an attempt to return null from a method com.blankj.utilcode.util.ToastUtils.getDefaultMaker() marked by @androidx.annotation.NonNull");
        return toastUtils;
    }

    private int getDuration() {
        return this.isLong ? 1 : 0;
    }

    private static CharSequence getToastFriendlyText(CharSequence charSequence) {
        return charSequence == null ? NULL : charSequence.length() == 0 ? NOTHING : charSequence;
    }

    public static ToastUtils make() {
        return new ToastUtils();
    }

    /* access modifiers changed from: private */
    public static IToast newToast(ToastUtils toastUtils) {
        if (!toastUtils.isNotUseSystemToast && k.a((Context) Utils.getApp()).b()) {
            if (Build.VERSION.SDK_INT < 23) {
                return new SystemToast(toastUtils);
            }
            if (!UtilsBridge.isGrantedDrawOverlays()) {
                return new SystemToast(toastUtils);
            }
        }
        return Build.VERSION.SDK_INT < 25 ? new WindowManagerToast(toastUtils, CameraGlobal.GET_RECORD_STATUS) : UtilsBridge.isGrantedDrawOverlays() ? Build.VERSION.SDK_INT >= 26 ? new WindowManagerToast(toastUtils, 2038) : new WindowManagerToast(toastUtils, CameraGlobal.GET_DEVICE_INFO) : new ActivityToast(toastUtils);
    }

    private static void show(View view, int i2, ToastUtils toastUtils) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        show(view, (CharSequence) null, i2, toastUtils);
    }

    private static void show(final View view, final CharSequence charSequence, final int i2, ToastUtils toastUtils) {
        Objects.requireNonNull(toastUtils, "Argument 'utils' of type ToastUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        UtilsBridge.runOnUiThread(new Runnable(toastUtils) {
            final /* synthetic */ ToastUtils val$utils;

            {
                this.val$utils = r1;
            }

            public void run() {
                ToastUtils.cancel();
                IToast access$100 = ToastUtils.newToast(this.val$utils);
                WeakReference unused = ToastUtils.sWeakToast = new WeakReference(access$100);
                View view = view;
                if (view != null) {
                    access$100.setToastView(view);
                } else {
                    access$100.setToastView(charSequence);
                }
                access$100.show(i2);
            }
        });
    }

    private static void show(CharSequence charSequence, int i2, ToastUtils toastUtils) {
        show((View) null, getToastFriendlyText(charSequence), i2, toastUtils);
    }

    public static void showLong(int i2) {
        show((CharSequence) UtilsBridge.getString(i2), 1, DEFAULT_MAKER);
    }

    public static void showLong(int i2, Object... objArr) {
        show((CharSequence) UtilsBridge.getString(i2, objArr), 1, DEFAULT_MAKER);
    }

    public static void showLong(CharSequence charSequence) {
        show(charSequence, 1, DEFAULT_MAKER);
    }

    public static void showLong(String str, Object... objArr) {
        show((CharSequence) UtilsBridge.format(str, objArr), 1, DEFAULT_MAKER);
    }

    public static void showShort(int i2) {
        show((CharSequence) UtilsBridge.getString(i2), 0, DEFAULT_MAKER);
    }

    public static void showShort(int i2, Object... objArr) {
        show((CharSequence) UtilsBridge.getString(i2, objArr), 0, DEFAULT_MAKER);
    }

    public static void showShort(CharSequence charSequence) {
        show(charSequence, 0, DEFAULT_MAKER);
    }

    public static void showShort(String str, Object... objArr) {
        show((CharSequence) UtilsBridge.format(str, objArr), 0, DEFAULT_MAKER);
    }

    /* access modifiers changed from: private */
    public View tryApplyUtilsToastView(CharSequence charSequence) {
        if (!MODE.DARK.equals(this.mMode) && !MODE.LIGHT.equals(this.mMode)) {
            Drawable[] drawableArr = this.mIcons;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View layoutId2View = UtilsBridge.layoutId2View(R.layout.utils_toast_view);
        TextView textView = (TextView) layoutId2View.findViewById(16908299);
        if (MODE.DARK.equals(this.mMode)) {
            ((GradientDrawable) layoutId2View.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.mIcons[0] != null) {
            View findViewById = layoutId2View.findViewById(R.id.utvLeftIconView);
            ac.a(findViewById, this.mIcons[0]);
            findViewById.setVisibility(0);
        }
        if (this.mIcons[1] != null) {
            View findViewById2 = layoutId2View.findViewById(R.id.utvTopIconView);
            ac.a(findViewById2, this.mIcons[1]);
            findViewById2.setVisibility(0);
        }
        if (this.mIcons[2] != null) {
            View findViewById3 = layoutId2View.findViewById(R.id.utvRightIconView);
            ac.a(findViewById3, this.mIcons[2]);
            findViewById3.setVisibility(0);
        }
        if (this.mIcons[3] != null) {
            View findViewById4 = layoutId2View.findViewById(R.id.utvBottomIconView);
            ac.a(findViewById4, this.mIcons[3]);
            findViewById4.setVisibility(0);
        }
        return layoutId2View;
    }

    public final ToastUtils setBgColor(int i2) {
        this.mBgColor = i2;
        return this;
    }

    public final ToastUtils setBgResource(int i2) {
        this.mBgResource = i2;
        return this;
    }

    public final ToastUtils setBottomIcon(int i2) {
        ToastUtils bottomIcon = setBottomIcon(b.a((Context) Utils.getApp(), i2));
        Objects.requireNonNull(bottomIcon, "Detected an attempt to return null from a method com.blankj.utilcode.util.ToastUtils.setBottomIcon() marked by @androidx.annotation.NonNull");
        return bottomIcon;
    }

    public final ToastUtils setBottomIcon(Drawable drawable) {
        this.mIcons[3] = drawable;
        return this;
    }

    public final ToastUtils setDurationIsLong(boolean z2) {
        this.isLong = z2;
        return this;
    }

    public final ToastUtils setGravity(int i2, int i3, int i4) {
        this.mGravity = i2;
        this.mXOffset = i3;
        this.mYOffset = i4;
        return this;
    }

    public final ToastUtils setLeftIcon(int i2) {
        ToastUtils leftIcon = setLeftIcon(b.a((Context) Utils.getApp(), i2));
        Objects.requireNonNull(leftIcon, "Detected an attempt to return null from a method com.blankj.utilcode.util.ToastUtils.setLeftIcon() marked by @androidx.annotation.NonNull");
        return leftIcon;
    }

    public final ToastUtils setLeftIcon(Drawable drawable) {
        this.mIcons[0] = drawable;
        return this;
    }

    public final ToastUtils setMode(String str) {
        this.mMode = str;
        return this;
    }

    public final ToastUtils setNotUseSystemToast() {
        this.isNotUseSystemToast = true;
        return this;
    }

    public final ToastUtils setRightIcon(int i2) {
        ToastUtils rightIcon = setRightIcon(b.a((Context) Utils.getApp(), i2));
        Objects.requireNonNull(rightIcon, "Detected an attempt to return null from a method com.blankj.utilcode.util.ToastUtils.setRightIcon() marked by @androidx.annotation.NonNull");
        return rightIcon;
    }

    public final ToastUtils setRightIcon(Drawable drawable) {
        this.mIcons[2] = drawable;
        return this;
    }

    public final ToastUtils setTextColor(int i2) {
        this.mTextColor = i2;
        return this;
    }

    public final ToastUtils setTextSize(int i2) {
        this.mTextSize = i2;
        return this;
    }

    public final ToastUtils setTopIcon(int i2) {
        ToastUtils topIcon = setTopIcon(b.a((Context) Utils.getApp(), i2));
        Objects.requireNonNull(topIcon, "Detected an attempt to return null from a method com.blankj.utilcode.util.ToastUtils.setTopIcon() marked by @androidx.annotation.NonNull");
        return topIcon;
    }

    public final ToastUtils setTopIcon(Drawable drawable) {
        this.mIcons[1] = drawable;
        return this;
    }

    public final void show(int i2) {
        show((CharSequence) UtilsBridge.getString(i2), getDuration(), this);
    }

    public final void show(int i2, Object... objArr) {
        show((CharSequence) UtilsBridge.getString(i2, objArr), getDuration(), this);
    }

    public final void show(View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        show(view, getDuration(), this);
    }

    public final void show(CharSequence charSequence) {
        show(charSequence, getDuration(), this);
    }

    public final void show(String str, Object... objArr) {
        show((CharSequence) UtilsBridge.format(str, objArr), getDuration(), this);
    }
}
