package com.xeagle.android.widgets.marquee;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatTextView;

public class MarqueeScrollerView extends AppCompatTextView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Scroller f25901a;

    /* renamed from: b  reason: collision with root package name */
    private int f25902b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f25903c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f25904e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25905f;

    /* renamed from: g  reason: collision with root package name */
    private int f25906g;

    /* renamed from: h  reason: collision with root package name */
    private int f25907h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f25908i;

    public MarqueeScrollerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MarqueeScrollerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeScrollerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25903c = 0;
        this.f25904e = true;
        this.f25905f = true;
        this.f25908i = false;
        a(context, attributeSet, i2);
    }

    public static int a(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        this.f25902b = 5000;
        this.f25906g = 101;
        this.f25907h = 0;
        setSingleLine();
        setEllipsize((TextUtils.TruncateAt) null);
    }

    private int d() {
        TextPaint paint = getPaint();
        Rect rect = new Rect();
        String charSequence = getText().toString();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return rect.width();
    }

    public void a() {
        this.f25903c = 0;
        this.f25904e = true;
        this.f25905f = true;
        b();
    }

    public void b() {
        int d2 = d();
        final int a2 = (d2 - a(getContext())) + 100;
        if (this.f25904e && a2 >= 100) {
            setHorizontallyScrolling(true);
            if (this.f25901a == null) {
                Scroller scroller = new Scroller(getContext(), new LinearInterpolator());
                this.f25901a = scroller;
                setScroller(scroller);
            }
            double d3 = (double) (this.f25902b * a2);
            Double.isNaN(d3);
            double d4 = (double) d2;
            Double.isNaN(d4);
            final int intValue = Double.valueOf((d3 * 1.0d) / d4).intValue();
            if (this.f25905f) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        MarqueeScrollerView.this.f25901a.startScroll(MarqueeScrollerView.this.f25903c, 0, a2, 0, intValue);
                        MarqueeScrollerView.this.invalidate();
                        boolean unused = MarqueeScrollerView.this.f25904e = false;
                    }
                }, (long) this.f25907h);
                return;
            }
            this.f25901a.startScroll(this.f25903c, 0, a2, 0, intValue);
            invalidate();
            this.f25904e = false;
        }
    }

    public void c() {
        Scroller scroller = this.f25901a;
        if (scroller != null) {
            this.f25904e = true;
            if (this.f25908i) {
                scroller.startScroll(0, 0, 0, 0, 0);
            }
        }
    }

    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.f25901a;
        if (scroller == null || !scroller.isFinished() || this.f25904e) {
            return;
        }
        if (this.f25906g == 101) {
            c();
            return;
        }
        this.f25904e = true;
        this.f25903c = getWidth() * -1;
        this.f25905f = false;
        b();
    }

    public int getRndDuration() {
        return this.f25902b;
    }

    public int getScrollFirstDelay() {
        return this.f25907h;
    }

    public int getScrollMode() {
        return this.f25906g;
    }

    public boolean isFocused() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        if (z2) {
            super.onFocusChanged(z2, i2, rect);
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        if (z2) {
            super.onWindowFocusChanged(z2);
        }
    }

    public void setRndDuration(int i2) {
        this.f25902b = i2;
    }

    public void setScrollFirstDelay(int i2) {
        this.f25907h = i2;
    }

    public void setScrollMode(int i2) {
        this.f25906g = i2;
    }
}
