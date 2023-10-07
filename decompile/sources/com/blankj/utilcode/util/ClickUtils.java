package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.blankj.utilcode.util.ShadowUtils;
import java.util.Objects;
import t.ac;

public class ClickUtils {
    private static final long DEBOUNCING_DEFAULT_VALUE = 1000;
    private static final float PRESSED_BG_ALPHA_DEFAULT_VALUE = 0.9f;
    private static final int PRESSED_BG_ALPHA_STYLE = 4;
    private static final float PRESSED_BG_DARK_DEFAULT_VALUE = 0.9f;
    private static final int PRESSED_BG_DARK_STYLE = 5;
    private static final float PRESSED_VIEW_ALPHA_DEFAULT_VALUE = 0.8f;
    private static final int PRESSED_VIEW_ALPHA_SRC_TAG = -3;
    private static final int PRESSED_VIEW_ALPHA_TAG = -2;
    private static final float PRESSED_VIEW_SCALE_DEFAULT_VALUE = -0.06f;
    private static final int PRESSED_VIEW_SCALE_TAG = -1;
    private static final long TIP_DURATION = 2000;
    private static int sClickCount;
    private static long sLastClickMillis;

    public interface Back2HomeFriendlyListener {
        public static final Back2HomeFriendlyListener DEFAULT = new Back2HomeFriendlyListener() {
            public void dismiss() {
                UtilsBridge.toastCancel();
            }

            public void show(CharSequence charSequence, long j2) {
                UtilsBridge.toastShowShort(charSequence);
            }
        };

        void dismiss();

        void show(CharSequence charSequence, long j2);
    }

    static class ClickDrawableWrapper extends ShadowUtils.DrawableWrapper {
        private BitmapDrawable mBitmapDrawable = null;
        private Paint mColorPaint = null;

        public ClickDrawableWrapper(Drawable drawable) {
            super(drawable);
            if (drawable instanceof ColorDrawable) {
                Paint paint = new Paint(5);
                this.mColorPaint = paint;
                paint.setColor(((ColorDrawable) drawable).getColor());
            }
        }

        public void draw(Canvas canvas) {
            if (this.mBitmapDrawable == null) {
                Bitmap createBitmap = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                if (this.mColorPaint != null) {
                    canvas2.drawRect(getBounds(), this.mColorPaint);
                } else {
                    super.draw(canvas2);
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), createBitmap);
                this.mBitmapDrawable = bitmapDrawable;
                bitmapDrawable.setBounds(getBounds());
            }
            this.mBitmapDrawable.draw(canvas);
        }

        public void setAlpha(int i2) {
            Paint paint;
            super.setAlpha(i2);
            if (Build.VERSION.SDK_INT < 21 && (paint = this.mColorPaint) != null) {
                paint.setColor(((ColorDrawable) getWrappedDrawable()).getColor());
            }
        }

        public void setColorFilter(ColorFilter colorFilter) {
            Paint paint;
            super.setColorFilter(colorFilter);
            if (Build.VERSION.SDK_INT < 21 && (paint = this.mColorPaint) != null) {
                paint.setColorFilter(colorFilter);
            }
        }
    }

    public static abstract class OnDebouncingClickListener implements View.OnClickListener {
        private static final Runnable ENABLE_AGAIN = new Runnable() {
            public void run() {
                boolean unused = OnDebouncingClickListener.mEnabled = true;
            }
        };
        /* access modifiers changed from: private */
        public static boolean mEnabled = true;
        private long mDuration;
        private boolean mIsGlobal;

        public OnDebouncingClickListener() {
            this(true, ClickUtils.DEBOUNCING_DEFAULT_VALUE);
        }

        public OnDebouncingClickListener(long j2) {
            this(true, j2);
        }

        public OnDebouncingClickListener(boolean z2) {
            this(z2, ClickUtils.DEBOUNCING_DEFAULT_VALUE);
        }

        public OnDebouncingClickListener(boolean z2, long j2) {
            this.mIsGlobal = z2;
            this.mDuration = j2;
        }

        private static boolean isValid(View view, long j2) {
            Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            return UtilsBridge.isValid(view, j2);
        }

        public final void onClick(View view) {
            if (this.mIsGlobal) {
                if (mEnabled) {
                    mEnabled = false;
                    view.postDelayed(ENABLE_AGAIN, this.mDuration);
                } else {
                    return;
                }
            } else if (!isValid(view, this.mDuration)) {
                return;
            }
            onDebouncingClick(view);
        }

        public abstract void onDebouncingClick(View view);
    }

    public static abstract class OnMultiClickListener implements View.OnClickListener {
        private static final long INTERVAL_DEFAULT_VALUE = 666;
        private int mClickCount;
        private final long mClickInterval;
        private long mLastClickTime;
        private final int mTriggerClickCount;

        public OnMultiClickListener(int i2) {
            this(i2, INTERVAL_DEFAULT_VALUE);
        }

        public OnMultiClickListener(int i2, long j2) {
            this.mTriggerClickCount = i2;
            this.mClickInterval = j2;
        }

        public abstract void onBeforeTriggerClick(View view, int i2);

        public void onClick(View view) {
            if (this.mTriggerClickCount <= 1) {
                onTriggerClick(view);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastClickTime < this.mClickInterval) {
                int i2 = this.mClickCount + 1;
                this.mClickCount = i2;
                int i3 = this.mTriggerClickCount;
                if (i2 == i3) {
                    onTriggerClick(view);
                } else if (i2 < i3) {
                    onBeforeTriggerClick(view, i2);
                }
                this.mLastClickTime = currentTimeMillis;
            }
            this.mClickCount = 1;
            onBeforeTriggerClick(view, 1);
            this.mLastClickTime = currentTimeMillis;
        }

        public abstract void onTriggerClick(View view);
    }

    private static class OnUtilsTouchListener implements View.OnTouchListener {

        private static class LazyHolder {
            /* access modifiers changed from: private */
            public static final OnUtilsTouchListener INSTANCE = new OnUtilsTouchListener();

            private LazyHolder() {
            }
        }

        private OnUtilsTouchListener() {
        }

        public static OnUtilsTouchListener getInstance() {
            return LazyHolder.INSTANCE;
        }

        private void processAlpha(View view, boolean z2) {
            Object tag = view.getTag(z2 ? -2 : -3);
            if (tag instanceof Float) {
                view.setAlpha(((Float) tag).floatValue());
            }
        }

        private void processScale(View view, boolean z2) {
            Object tag = view.getTag(-1);
            if (tag instanceof Float) {
                float f2 = 1.0f;
                if (z2) {
                    f2 = 1.0f + ((Float) tag).floatValue();
                }
                view.animate().scaleX(f2).scaleY(f2).setDuration(200).start();
            }
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                processScale(view, true);
                processAlpha(view, true);
            } else if (action == 1 || action == 3) {
                processScale(view, false);
                processAlpha(view, false);
            }
            return false;
        }
    }

    private ClickUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static void applyDebouncing(View[] viewArr, boolean z2, long j2, final View.OnClickListener onClickListener) {
        if (viewArr != null && viewArr.length != 0 && onClickListener != null) {
            for (View view : viewArr) {
                if (view != null) {
                    view.setOnClickListener(new OnDebouncingClickListener(z2, j2) {
                        public void onDebouncingClick(View view) {
                            onClickListener.onClick(view);
                        }
                    });
                }
            }
        }
    }

    public static void applyGlobalDebouncing(View view, long j2, View.OnClickListener onClickListener) {
        applyGlobalDebouncing(new View[]{view}, j2, onClickListener);
    }

    public static void applyGlobalDebouncing(View view, View.OnClickListener onClickListener) {
        applyGlobalDebouncing(new View[]{view}, onClickListener);
    }

    public static void applyGlobalDebouncing(View[] viewArr, long j2, View.OnClickListener onClickListener) {
        applyDebouncing(viewArr, true, j2, onClickListener);
    }

    public static void applyGlobalDebouncing(View[] viewArr, View.OnClickListener onClickListener) {
        applyGlobalDebouncing(viewArr, (long) DEBOUNCING_DEFAULT_VALUE, onClickListener);
    }

    public static void applyPressedBgAlpha(View view) {
        applyPressedBgAlpha(view, 0.9f);
    }

    public static void applyPressedBgAlpha(View view, float f2) {
        applyPressedBgStyle(view, 4, f2);
    }

    public static void applyPressedBgDark(View view) {
        applyPressedBgDark(view, 0.9f);
    }

    public static void applyPressedBgDark(View view, float f2) {
        applyPressedBgStyle(view, 5, f2);
    }

    private static void applyPressedBgStyle(View view, int i2, float f2) {
        if (view != null) {
            Drawable background = view.getBackground();
            int i3 = -i2;
            Object tag = view.getTag(i3);
            if (tag instanceof Drawable) {
                ac.a(view, (Drawable) tag);
                return;
            }
            Drawable createStyleDrawable = createStyleDrawable(background, i2, f2);
            ac.a(view, createStyleDrawable);
            view.setTag(i3, createStyleDrawable);
        }
    }

    public static void applyPressedViewAlpha(View view, float f2) {
        if (view != null) {
            view.setTag(-2, Float.valueOf(f2));
            view.setTag(-3, Float.valueOf(view.getAlpha()));
            view.setClickable(true);
            view.setOnTouchListener(OnUtilsTouchListener.getInstance());
        }
    }

    public static void applyPressedViewAlpha(View... viewArr) {
        applyPressedViewAlpha(viewArr, (float[]) null);
    }

    public static void applyPressedViewAlpha(View[] viewArr, float[] fArr) {
        float f2;
        View view;
        if (viewArr != null && viewArr.length != 0) {
            for (int i2 = 0; i2 < viewArr.length; i2++) {
                if (fArr == null || i2 >= fArr.length) {
                    view = viewArr[i2];
                    f2 = PRESSED_VIEW_ALPHA_DEFAULT_VALUE;
                } else {
                    view = viewArr[i2];
                    f2 = fArr[i2];
                }
                applyPressedViewAlpha(view, f2);
            }
        }
    }

    public static void applyPressedViewScale(View view, float f2) {
        if (view != null) {
            view.setTag(-1, Float.valueOf(f2));
            view.setClickable(true);
            view.setOnTouchListener(OnUtilsTouchListener.getInstance());
        }
    }

    public static void applyPressedViewScale(View... viewArr) {
        applyPressedViewScale(viewArr, (float[]) null);
    }

    public static void applyPressedViewScale(View[] viewArr, float[] fArr) {
        float f2;
        View view;
        if (viewArr != null && viewArr.length != 0) {
            for (int i2 = 0; i2 < viewArr.length; i2++) {
                if (fArr == null || i2 >= fArr.length) {
                    view = viewArr[i2];
                    f2 = PRESSED_VIEW_SCALE_DEFAULT_VALUE;
                } else {
                    view = viewArr[i2];
                    f2 = fArr[i2];
                }
                applyPressedViewScale(view, f2);
            }
        }
    }

    public static void applySingleDebouncing(View view, long j2, View.OnClickListener onClickListener) {
        applySingleDebouncing(new View[]{view}, j2, onClickListener);
    }

    public static void applySingleDebouncing(View view, View.OnClickListener onClickListener) {
        applySingleDebouncing(new View[]{view}, onClickListener);
    }

    public static void applySingleDebouncing(View[] viewArr, long j2, View.OnClickListener onClickListener) {
        applyDebouncing(viewArr, false, j2, onClickListener);
    }

    public static void applySingleDebouncing(View[] viewArr, View.OnClickListener onClickListener) {
        applySingleDebouncing(viewArr, (long) DEBOUNCING_DEFAULT_VALUE, onClickListener);
    }

    public static void back2HomeFriendly(CharSequence charSequence) {
        back2HomeFriendly(charSequence, TIP_DURATION, Back2HomeFriendlyListener.DEFAULT);
    }

    public static void back2HomeFriendly(CharSequence charSequence, long j2, Back2HomeFriendlyListener back2HomeFriendlyListener) {
        Objects.requireNonNull(charSequence, "Argument 'tip' of type CharSequence (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(back2HomeFriendlyListener, "Argument 'listener' of type Back2HomeFriendlyListener (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (Math.abs(elapsedRealtime - sLastClickMillis) < j2) {
            int i2 = sClickCount + 1;
            sClickCount = i2;
            if (i2 == 2) {
                UtilsBridge.startHomeActivity();
                back2HomeFriendlyListener.dismiss();
                sLastClickMillis = 0;
                return;
            }
            return;
        }
        sClickCount = 1;
        back2HomeFriendlyListener.show(charSequence, j2);
        sLastClickMillis = elapsedRealtime;
    }

    private static Drawable createAlphaDrawable(Drawable drawable, float f2) {
        ClickDrawableWrapper clickDrawableWrapper = new ClickDrawableWrapper(drawable);
        clickDrawableWrapper.setAlpha((int) (f2 * 255.0f));
        return clickDrawableWrapper;
    }

    private static Drawable createDarkDrawable(Drawable drawable, float f2) {
        ClickDrawableWrapper clickDrawableWrapper = new ClickDrawableWrapper(drawable);
        clickDrawableWrapper.setColorFilter(getDarkColorFilter(f2));
        return clickDrawableWrapper;
    }

    private static Drawable createStyleDrawable(Drawable drawable, int i2, float f2) {
        if (drawable == null) {
            drawable = new ColorDrawable(0);
        }
        if (drawable.getConstantState() == null) {
            return drawable;
        }
        Drawable mutate = drawable.getConstantState().newDrawable().mutate();
        if (i2 == 4) {
            mutate = createAlphaDrawable(mutate, f2);
        } else if (i2 == 5) {
            mutate = createDarkDrawable(mutate, f2);
        }
        Drawable createAlphaDrawable = createAlphaDrawable(drawable.getConstantState().newDrawable().mutate(), 0.5f);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, mutate);
        stateListDrawable.addState(new int[]{-16842910}, createAlphaDrawable);
        stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        return stateListDrawable;
    }

    public static void expandClickArea(View view, int i2) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        expandClickArea(view, i2, i2, i2, i2);
    }

    public static void expandClickArea(View view, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View view2 = (View) view.getParent();
        if (view2 == null) {
            Log.e("ClickUtils", "expandClickArea must have parent view.");
            return;
        }
        final View view3 = view;
        final int i6 = i2;
        final int i7 = i5;
        final int i8 = i3;
        final int i9 = i4;
        final View view4 = view2;
        view2.post(new Runnable() {
            public void run() {
                Rect rect = new Rect();
                view3.getHitRect(rect);
                rect.top -= i6;
                rect.bottom += i7;
                rect.left -= i8;
                rect.right += i9;
                view4.setTouchDelegate(new TouchDelegate(rect, view3));
            }
        });
    }

    private static ColorMatrixColorFilter getDarkColorFilter(float f2) {
        return new ColorMatrixColorFilter(new ColorMatrix(new float[]{f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f}));
    }
}
