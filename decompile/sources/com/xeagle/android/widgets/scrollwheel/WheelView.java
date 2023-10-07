package com.xeagle.android.widgets.scrollwheel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.blankj.utilcode.constant.MemoryConstants;
import com.cfly.uav_pro.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.LinkedList;
import java.util.List;

public class WheelView extends View {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f25989b = {-15658735, 11184810, 11184810};
    private final int A = 1;
    /* access modifiers changed from: private */
    public Handler B = new Handler() {
        public void handleMessage(Message message) {
            WheelView.this.f26009u.computeScrollOffset();
            int currY = WheelView.this.f26009u.getCurrY();
            int i2 = WheelView.this.f26010v - currY;
            int unused = WheelView.this.f26010v = currY;
            if (i2 != 0) {
                WheelView.this.b(i2);
            }
            if (Math.abs(currY - WheelView.this.f26009u.getFinalY()) < 1) {
                WheelView.this.f26009u.getFinalY();
                WheelView.this.f26009u.forceFinished(true);
            }
            if (!WheelView.this.f26009u.isFinished()) {
                WheelView.this.B.sendEmptyMessage(message.what);
            } else if (message.what == 0) {
                WheelView.this.g();
            } else {
                WheelView.this.c();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    boolean f25990a = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public d f25991c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f25992d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f25993e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f25994f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f25995g = 5;

    /* renamed from: h  reason: collision with root package name */
    private int f25996h = 0;

    /* renamed from: i  reason: collision with root package name */
    private TextPaint f25997i;

    /* renamed from: j  reason: collision with root package name */
    private TextPaint f25998j;

    /* renamed from: k  reason: collision with root package name */
    private StaticLayout f25999k;

    /* renamed from: l  reason: collision with root package name */
    private StaticLayout f26000l;

    /* renamed from: m  reason: collision with root package name */
    private StaticLayout f26001m;

    /* renamed from: n  reason: collision with root package name */
    private String f26002n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f26003o;

    /* renamed from: p  reason: collision with root package name */
    private GradientDrawable f26004p;

    /* renamed from: q  reason: collision with root package name */
    private GradientDrawable f26005q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f26006r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f26007s;

    /* renamed from: t  reason: collision with root package name */
    private GestureDetector f26008t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public Scroller f26009u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public int f26010v;

    /* renamed from: w  reason: collision with root package name */
    private List<b> f26011w = new LinkedList();

    /* renamed from: x  reason: collision with root package name */
    private List<c> f26012x = new LinkedList();

    /* renamed from: y  reason: collision with root package name */
    private GestureDetector.SimpleOnGestureListener f26013y = new GestureDetector.SimpleOnGestureListener() {
        public boolean onDown(MotionEvent motionEvent) {
            if (!WheelView.this.f26006r) {
                return false;
            }
            WheelView.this.f26009u.forceFinished(true);
            WheelView.this.f();
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            WheelView wheelView = WheelView.this;
            int unused = wheelView.f26010v = (wheelView.f25992d * WheelView.this.getItemHeight()) + WheelView.this.f26007s;
            int a2 = WheelView.this.f25990a ? SubsamplingScaleImageView.TILE_SIZE_AUTO : WheelView.this.f25991c.a() * WheelView.this.getItemHeight();
            WheelView.this.f26009u.fling(0, WheelView.this.f26010v, 0, ((int) (-f3)) / 2, 0, 0, WheelView.this.f25990a ? -a2 : 0, a2);
            WheelView.this.setNextMessage(0);
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            WheelView.this.h();
            WheelView.this.b((int) (-f3));
            return true;
        }
    };

    /* renamed from: z  reason: collision with root package name */
    private final int f26014z = 0;

    public WheelView(Context context) {
        super(context);
        a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private int a(Layout layout) {
        if (layout == null) {
            return 0;
        }
        return Math.max(((getItemHeight() * this.f25995g) - 16) - 15, getSuggestedMinimumHeight());
    }

    private String a(int i2) {
        d dVar = this.f25991c;
        if (dVar == null || dVar.a() == 0) {
            return null;
        }
        int a2 = this.f25991c.a();
        if ((i2 < 0 || i2 >= a2) && !this.f25990a) {
            return null;
        }
        while (i2 < 0) {
            i2 += a2;
        }
        return this.f25991c.a(i2 % a2);
    }

    private String a(boolean z2) {
        String a2;
        StringBuilder sb = new StringBuilder();
        int i2 = (this.f25995g / 2) + 1;
        int i3 = this.f25992d - i2;
        while (true) {
            int i4 = this.f25992d;
            if (i3 > i4 + i2) {
                return sb.toString();
            }
            if ((z2 || i3 != i4) && (a2 = a(i3)) != null) {
                sb.append(a2);
            }
            if (i3 < this.f25992d + i2) {
                sb.append("\n");
            }
            i3++;
        }
    }

    private void a(Context context) {
        GestureDetector gestureDetector = new GestureDetector(context, this.f26013y);
        this.f26008t = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f26009u = new Scroller(context);
    }

    private void a(Canvas canvas) {
        this.f26004p.setBounds(0, 0, getWidth(), getHeight() / this.f25995g);
        this.f26004p.draw(canvas);
        this.f26005q.setBounds(0, getHeight() - (getHeight() / this.f25995g), getWidth(), getHeight());
        this.f26005q.draw(canvas);
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        int a2;
        int i3 = this.f26007s + i2;
        this.f26007s = i3;
        int itemHeight = i3 / getItemHeight();
        int i4 = this.f25992d - itemHeight;
        if (this.f25990a && this.f25991c.a() > 0) {
            while (true) {
                a2 = this.f25991c.a();
                if (i4 >= 0) {
                    break;
                }
                i4 += a2;
            }
            i4 %= a2;
        } else if (!this.f26006r) {
            i4 = Math.min(Math.max(i4, 0), this.f25991c.a() - 1);
        } else if (i4 < 0) {
            itemHeight = this.f25992d;
            i4 = 0;
        } else if (i4 >= this.f25991c.a()) {
            itemHeight = (this.f25992d - this.f25991c.a()) + 1;
            i4 = this.f25991c.a() - 1;
        }
        int i5 = this.f26007s;
        if (i4 != this.f25992d) {
            a(i4, false);
        } else {
            invalidate();
        }
        int itemHeight2 = i5 - (itemHeight * getItemHeight());
        this.f26007s = itemHeight2;
        if (itemHeight2 > getHeight()) {
            this.f26007s = (this.f26007s % getHeight()) + getHeight();
        }
    }

    private void b(Canvas canvas) {
        this.f25998j.setColor(-268435456);
        this.f25998j.drawableState = getDrawableState();
        Rect rect = new Rect();
        this.f25999k.getLineBounds(this.f25995g / 2, rect);
        if (this.f26000l != null) {
            canvas.save();
            canvas.translate((float) (this.f25999k.getWidth() + 8), (float) rect.top);
            this.f26000l.draw(canvas);
            canvas.restore();
        }
        if (this.f26001m != null) {
            canvas.save();
            canvas.translate(0.0f, (float) (rect.top + this.f26007s));
            this.f26001m.draw(canvas);
            canvas.restore();
        }
    }

    private int c(int i2, int i3) {
        e();
        int maxTextLength = getMaxTextLength();
        if (maxTextLength > 0) {
            this.f25993e = (int) (((float) maxTextLength) * ((float) Math.ceil((double) Layout.getDesiredWidth("0", this.f25997i))));
        } else {
            this.f25993e = 0;
        }
        this.f25993e += 10;
        this.f25994f = 0;
        String str = this.f26002n;
        if (str != null && str.length() > 0) {
            this.f25994f = (int) Math.ceil((double) Layout.getDesiredWidth(this.f26002n, this.f25998j));
        }
        boolean z2 = true;
        if (i3 != 1073741824) {
            int i4 = this.f25993e;
            int i5 = this.f25994f;
            int i6 = i4 + i5 + 20;
            if (i5 > 0) {
                i6 += 8;
            }
            int max = Math.max(i6, getSuggestedMinimumWidth());
            if (i3 != Integer.MIN_VALUE || i2 >= max) {
                i2 = max;
                z2 = false;
            }
        }
        if (z2) {
            int i7 = (i2 - 8) - 20;
            if (i7 <= 0) {
                this.f25994f = 0;
                this.f25993e = 0;
            }
            int i8 = this.f25994f;
            if (i8 > 0) {
                int i9 = this.f25993e;
                double d2 = (double) i9;
                double d3 = (double) i7;
                Double.isNaN(d2);
                Double.isNaN(d3);
                double d4 = (double) (i9 + i8);
                Double.isNaN(d4);
                int i10 = (int) ((d2 * d3) / d4);
                this.f25993e = i10;
                this.f25994f = i7 - i10;
            } else {
                this.f25993e = i7 + 8;
            }
        }
        int i11 = this.f25993e;
        if (i11 > 0) {
            d(i11, this.f25994f);
        }
        return i2;
    }

    private void c(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (float) ((-this.f25999k.getLineTop(1)) + this.f26007s));
        this.f25997i.setColor(-16777216);
        this.f25997i.drawableState = getDrawableState();
        this.f25999k.draw(canvas);
        canvas.restore();
    }

    private void d() {
        this.f25999k = null;
        this.f26001m = null;
        this.f26007s = 0;
    }

    private void d(int i2, int i3) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2 = this.f25999k;
        if (staticLayout2 == null || staticLayout2.getWidth() > i2) {
            this.f25999k = new StaticLayout(a(this.f26006r), this.f25997i, i2, i3 > 0 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER, 1.0f, 15.0f, false);
        } else {
            this.f25999k.increaseWidthTo(i2);
        }
        String str = null;
        if (!this.f26006r && ((staticLayout = this.f26001m) == null || staticLayout.getWidth() > i2)) {
            if (getAdapter() != null) {
                str = getAdapter().a(this.f25992d);
            }
            if (str == null) {
                str = "";
            }
            this.f26001m = new StaticLayout(str, this.f25998j, i2, i3 > 0 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER, 1.0f, 15.0f, false);
        } else if (this.f26006r) {
            this.f26001m = null;
        } else {
            this.f26001m.increaseWidthTo(i2);
        }
        if (i3 > 0) {
            StaticLayout staticLayout3 = this.f26000l;
            if (staticLayout3 == null || staticLayout3.getWidth() > i3) {
                this.f26000l = new StaticLayout(this.f26002n, this.f25998j, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 15.0f, false);
            } else {
                this.f26000l.increaseWidthTo(i3);
            }
        }
    }

    private void d(Canvas canvas) {
        int height = getHeight() / 2;
        int itemHeight = getItemHeight() / 2;
        this.f26003o.setBounds(0, height - itemHeight, getWidth(), height + itemHeight);
        this.f26003o.draw(canvas);
    }

    private void e() {
        if (this.f25997i == null) {
            TextPaint textPaint = new TextPaint(33);
            this.f25997i = textPaint;
            textPaint.setTextSize(40.0f);
        }
        if (this.f25998j == null) {
            TextPaint textPaint2 = new TextPaint(37);
            this.f25998j = textPaint2;
            textPaint2.setTextSize(40.0f);
            this.f25998j.setShadowLayer(0.1f, 0.0f, 0.1f, -4144960);
        }
        if (this.f26003o == null) {
            this.f26003o = getContext().getResources().getDrawable(R.drawable.wheel_val);
        }
        if (this.f26004p == null) {
            this.f26004p = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, f25989b);
        }
        if (this.f26005q == null) {
            this.f26005q = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, f25989b);
        }
        setBackgroundResource(R.drawable.wheel_bg);
    }

    /* access modifiers changed from: private */
    public void f() {
        this.B.removeMessages(0);
        this.B.removeMessages(1);
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.f25991c != null) {
            boolean z2 = false;
            this.f26010v = 0;
            int i2 = this.f26007s;
            int itemHeight = getItemHeight();
            int i3 = this.f25992d;
            if (i2 <= 0 ? i3 > 0 : i3 < this.f25991c.a()) {
                z2 = true;
            }
            if ((this.f25990a || z2) && Math.abs((float) i2) > ((float) itemHeight) / 2.0f) {
                int i4 = itemHeight + 1;
                i2 = i2 < 0 ? i2 + i4 : i2 - i4;
            }
            int i5 = i2;
            if (Math.abs(i5) > 1) {
                this.f26009u.startScroll(0, 0, 0, i5, 400);
                setNextMessage(1);
                return;
            }
            c();
        }
    }

    /* access modifiers changed from: private */
    public int getItemHeight() {
        int i2 = this.f25996h;
        if (i2 != 0) {
            return i2;
        }
        StaticLayout staticLayout = this.f25999k;
        if (staticLayout == null || staticLayout.getLineCount() <= 2) {
            return getHeight() / this.f25995g;
        }
        int lineTop = this.f25999k.getLineTop(2) - this.f25999k.getLineTop(1);
        this.f25996h = lineTop;
        return lineTop;
    }

    private int getMaxTextLength() {
        d adapter = getAdapter();
        if (adapter == null) {
            return 0;
        }
        int b2 = adapter.b();
        if (b2 > 0) {
            return b2;
        }
        String str = null;
        for (int max = Math.max(this.f25992d - (this.f25995g / 2), 0); max < Math.min(this.f25992d + this.f25995g, adapter.a()); max++) {
            String a2 = adapter.a(max);
            if (a2 != null && (str == null || str.length() < a2.length())) {
                str = a2;
            }
        }
        if (str != null) {
            return str.length();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void h() {
        if (!this.f26006r) {
            this.f26006r = true;
            a();
        }
    }

    /* access modifiers changed from: private */
    public void setNextMessage(int i2) {
        f();
        this.B.sendEmptyMessage(i2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        for (c a2 : this.f26012x) {
            a2.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3) {
        for (b a2 : this.f26011w) {
            a2.a(this, i2, i3);
        }
    }

    public void a(int i2, boolean z2) {
        int a2;
        d dVar = this.f25991c;
        if (dVar != null && dVar.a() != 0) {
            if (i2 < 0 || i2 >= this.f25991c.a()) {
                if (this.f25990a) {
                    while (true) {
                        a2 = this.f25991c.a();
                        if (i2 >= 0) {
                            break;
                        }
                        i2 += a2;
                    }
                    i2 %= a2;
                } else {
                    return;
                }
            }
            int i3 = this.f25992d;
            if (i2 == i3) {
                return;
            }
            if (z2) {
                b(i2 - i3, 400);
                return;
            }
            d();
            int i4 = this.f25992d;
            this.f25992d = i2;
            a(i4, i2);
            invalidate();
        }
    }

    public void a(b bVar) {
        this.f26011w.add(bVar);
    }

    /* access modifiers changed from: protected */
    public void b() {
        for (c b2 : this.f26012x) {
            b2.b(this);
        }
    }

    public void b(int i2, int i3) {
        this.f26009u.forceFinished(true);
        this.f26010v = this.f26007s;
        int itemHeight = i2 * getItemHeight();
        Scroller scroller = this.f26009u;
        int i4 = this.f26010v;
        scroller.startScroll(0, i4, 0, itemHeight - i4, i3);
        setNextMessage(0);
        h();
    }

    public void b(b bVar) {
        this.f26011w.remove(bVar);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f26006r) {
            b();
            this.f26006r = false;
        }
        d();
        invalidate();
    }

    public d getAdapter() {
        return this.f25991c;
    }

    public int getCurrentItem() {
        return this.f25992d;
    }

    public String getLabel() {
        return this.f26002n;
    }

    public int getVisibleItems() {
        return this.f25995g;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f25999k == null) {
            int i2 = this.f25993e;
            if (i2 == 0) {
                c(getWidth(), (int) MemoryConstants.GB);
            } else {
                d(i2, this.f25994f);
            }
        }
        if (this.f25993e > 0) {
            canvas.save();
            canvas.translate(10.0f, -8.0f);
            c(canvas);
            b(canvas);
            canvas.restore();
        }
        d(canvas);
        a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int c2 = c(size, mode);
        if (mode2 != 1073741824) {
            int a2 = a((Layout) this.f25999k);
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(a2, size2) : a2;
        }
        setMeasuredDimension(c2, size2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getAdapter() != null && !this.f26008t.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            g();
        }
        return true;
    }

    public void setAdapter(d dVar) {
        this.f25991c = dVar;
        d();
        invalidate();
    }

    public void setCurrentItem(int i2) {
        a(i2, false);
    }

    public void setCyclic(boolean z2) {
        this.f25990a = z2;
        invalidate();
        d();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f26009u.forceFinished(true);
        this.f26009u = new Scroller(getContext(), interpolator);
    }

    public void setLabel(String str) {
        String str2 = this.f26002n;
        if (str2 == null || !str2.equals(str)) {
            this.f26002n = str;
            this.f26000l = null;
            invalidate();
        }
    }

    public void setVisibleItems(int i2) {
        this.f25995g = i2;
        invalidate();
    }
}
