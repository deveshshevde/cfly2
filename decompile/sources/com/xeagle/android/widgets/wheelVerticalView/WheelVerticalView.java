package com.xeagle.android.widgets.wheelVerticalView;

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
import ll.c;

public class WheelVerticalView extends View {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f26114b = {-15658735, 11184810, 11184810};
    private final int A = 0;
    private final int B = 1;
    /* access modifiers changed from: private */
    public Handler C = new Handler() {
        public void handleMessage(Message message) {
            WheelVerticalView.this.f26134u.computeScrollOffset();
            int currY = WheelVerticalView.this.f26134u.getCurrY();
            int i2 = WheelVerticalView.this.f26135v - currY;
            int unused = WheelVerticalView.this.f26135v = currY;
            if (i2 != 0) {
                WheelVerticalView.this.b(i2);
            }
            if (Math.abs(currY - WheelVerticalView.this.f26134u.getFinalY()) < 1) {
                WheelVerticalView.this.f26134u.getFinalY();
                WheelVerticalView.this.f26134u.forceFinished(true);
            }
            if (!WheelVerticalView.this.f26134u.isFinished()) {
                WheelVerticalView.this.C.sendEmptyMessage(message.what);
            } else if (message.what == 0) {
                WheelVerticalView.this.g();
            } else {
                WheelVerticalView.this.c();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    boolean f26115a = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f26116c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f26117d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f26118e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f26119f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f26120g = 5;

    /* renamed from: h  reason: collision with root package name */
    private int f26121h = 0;

    /* renamed from: i  reason: collision with root package name */
    private TextPaint f26122i;

    /* renamed from: j  reason: collision with root package name */
    private TextPaint f26123j;

    /* renamed from: k  reason: collision with root package name */
    private StaticLayout f26124k;

    /* renamed from: l  reason: collision with root package name */
    private StaticLayout f26125l;

    /* renamed from: m  reason: collision with root package name */
    private StaticLayout f26126m;

    /* renamed from: n  reason: collision with root package name */
    private String f26127n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f26128o;

    /* renamed from: p  reason: collision with root package name */
    private GradientDrawable f26129p;

    /* renamed from: q  reason: collision with root package name */
    private GradientDrawable f26130q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f26131r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f26132s;

    /* renamed from: t  reason: collision with root package name */
    private GestureDetector f26133t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public Scroller f26134u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public int f26135v;

    /* renamed from: w  reason: collision with root package name */
    private List<a> f26136w = new LinkedList();

    /* renamed from: x  reason: collision with root package name */
    private List<c> f26137x = new LinkedList();

    /* renamed from: y  reason: collision with root package name */
    private List<b> f26138y = new LinkedList();

    /* renamed from: z  reason: collision with root package name */
    private GestureDetector.SimpleOnGestureListener f26139z = new GestureDetector.SimpleOnGestureListener() {
        public boolean onDown(MotionEvent motionEvent) {
            if (!WheelVerticalView.this.f26131r) {
                return false;
            }
            WheelVerticalView.this.f26134u.forceFinished(true);
            WheelVerticalView.this.f();
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            WheelVerticalView wheelVerticalView = WheelVerticalView.this;
            int unused = wheelVerticalView.f26135v = (wheelVerticalView.f26117d * WheelVerticalView.this.getItemHeight()) + WheelVerticalView.this.f26132s;
            int a2 = WheelVerticalView.this.f26115a ? SubsamplingScaleImageView.TILE_SIZE_AUTO : WheelVerticalView.this.f26116c.a() * WheelVerticalView.this.getItemHeight();
            WheelVerticalView.this.f26134u.fling(0, WheelVerticalView.this.f26135v, 0, ((int) (-f3)) / 2, 0, 0, WheelVerticalView.this.f26115a ? -a2 : 0, a2);
            WheelVerticalView.this.setNextMessage(0);
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            WheelVerticalView.this.h();
            WheelVerticalView.this.b((int) (-f3));
            return true;
        }
    };

    public WheelVerticalView(Context context) {
        super(context);
        a(context);
    }

    public WheelVerticalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WheelVerticalView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private int a(Layout layout) {
        if (layout == null) {
            return 0;
        }
        return Math.max(((getItemHeight() * this.f26120g) - 16) - 15, getSuggestedMinimumHeight());
    }

    private String a(int i2) {
        c cVar = this.f26116c;
        if (cVar == null || cVar.a() == 0) {
            return null;
        }
        int a2 = this.f26116c.a();
        if ((i2 < 0 || i2 >= a2) && !this.f26115a) {
            return null;
        }
        while (i2 < 0) {
            i2 += a2;
        }
        int i3 = i2 % a2;
        return this.f26116c.c(i3) + "";
    }

    private String a(boolean z2) {
        String a2;
        StringBuilder sb = new StringBuilder();
        int i2 = (this.f26120g / 2) + 1;
        int i3 = this.f26117d - i2;
        while (true) {
            int i4 = this.f26117d;
            if (i3 > i4 + i2) {
                return sb.toString();
            }
            if ((z2 || i3 != i4) && (a2 = a(i3)) != null) {
                sb.append(a2);
            }
            if (i3 < this.f26117d + i2) {
                sb.append("\n");
            }
            i3++;
        }
    }

    private void a(Context context) {
        GestureDetector gestureDetector = new GestureDetector(context, this.f26139z);
        this.f26133t = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f26134u = new Scroller(context);
    }

    private void a(Canvas canvas) {
        this.f26129p.setBounds(0, 0, getWidth(), getHeight() / this.f26120g);
        this.f26129p.draw(canvas);
        this.f26130q.setBounds(0, getHeight() - (getHeight() / this.f26120g), getWidth(), getHeight());
        this.f26130q.draw(canvas);
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        int a2;
        int i3 = this.f26132s + i2;
        this.f26132s = i3;
        int itemHeight = i3 / getItemHeight();
        int i4 = this.f26117d - itemHeight;
        if (this.f26115a && this.f26116c.a() > 0) {
            while (true) {
                a2 = this.f26116c.a();
                if (i4 >= 0) {
                    break;
                }
                i4 += a2;
            }
            i4 %= a2;
        } else if (!this.f26131r) {
            i4 = Math.min(Math.max(i4, 0), this.f26116c.a() - 1);
        } else if (i4 < 0) {
            itemHeight = this.f26117d;
            i4 = 0;
        } else if (i4 >= this.f26116c.a()) {
            itemHeight = (this.f26117d - this.f26116c.a()) + 1;
            i4 = this.f26116c.a() - 1;
        }
        int i5 = this.f26132s;
        if (i4 != this.f26117d) {
            a(i4, false);
        } else {
            invalidate();
        }
        int itemHeight2 = i5 - (itemHeight * getItemHeight());
        this.f26132s = itemHeight2;
        if (itemHeight2 > getHeight()) {
            this.f26132s = (this.f26132s % getHeight()) + getHeight();
        }
    }

    private void b(Canvas canvas) {
        this.f26123j.setColor(-268435456);
        this.f26123j.drawableState = getDrawableState();
        Rect rect = new Rect();
        this.f26124k.getLineBounds(this.f26120g / 2, rect);
        if (this.f26125l != null) {
            canvas.save();
            canvas.translate((float) (this.f26124k.getWidth() + 8), (float) rect.top);
            this.f26125l.draw(canvas);
            canvas.restore();
        }
        if (this.f26126m != null) {
            canvas.save();
            canvas.translate(0.0f, (float) (rect.top + this.f26132s));
            this.f26126m.draw(canvas);
            canvas.restore();
        }
    }

    private int c(int i2, int i3) {
        e();
        int maxTextLength = getMaxTextLength();
        if (maxTextLength > 0) {
            this.f26118e = (int) (((float) maxTextLength) * ((float) Math.ceil((double) Layout.getDesiredWidth("0", this.f26122i))));
        } else {
            this.f26118e = 0;
        }
        this.f26118e += 10;
        this.f26119f = 0;
        String str = this.f26127n;
        if (str != null && str.length() > 0) {
            this.f26119f = (int) Math.ceil((double) Layout.getDesiredWidth(this.f26127n, this.f26123j));
        }
        boolean z2 = true;
        if (i3 != 1073741824) {
            int i4 = this.f26118e;
            int i5 = this.f26119f;
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
                this.f26119f = 0;
                this.f26118e = 0;
            }
            int i8 = this.f26119f;
            if (i8 > 0) {
                int i9 = this.f26118e;
                double d2 = (double) i9;
                double d3 = (double) i7;
                Double.isNaN(d2);
                Double.isNaN(d3);
                double d4 = (double) (i9 + i8);
                Double.isNaN(d4);
                int i10 = (int) ((d2 * d3) / d4);
                this.f26118e = i10;
                this.f26119f = i7 - i10;
            } else {
                this.f26118e = i7 + 8;
            }
        }
        int i11 = this.f26118e;
        if (i11 > 0) {
            d(i11, this.f26119f);
        }
        return i2;
    }

    private void c(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (float) ((-this.f26124k.getLineTop(1)) + this.f26132s));
        this.f26122i.setColor(-16777216);
        this.f26122i.drawableState = getDrawableState();
        this.f26124k.draw(canvas);
        canvas.restore();
    }

    private void d() {
        this.f26124k = null;
        this.f26126m = null;
        this.f26132s = 0;
    }

    private void d(int i2, int i3) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2 = this.f26124k;
        if (staticLayout2 == null || staticLayout2.getWidth() > i2) {
            this.f26124k = new StaticLayout(a(this.f26131r), this.f26122i, i2, i3 > 0 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER, 1.0f, 15.0f, false);
        } else {
            this.f26124k.increaseWidthTo(i2);
        }
        String str = null;
        if (!this.f26131r && ((staticLayout = this.f26126m) == null || staticLayout.getWidth() > i2)) {
            if (getViewAdapter() != null) {
                str = getViewAdapter().c(this.f26117d) + "";
            }
            this.f26126m = new StaticLayout(str != null ? str : "", this.f26123j, i2, i3 > 0 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER, 1.0f, 15.0f, false);
        } else if (this.f26131r) {
            this.f26126m = null;
        } else {
            this.f26126m.increaseWidthTo(i2);
        }
        if (i3 > 0) {
            StaticLayout staticLayout3 = this.f26125l;
            if (staticLayout3 == null || staticLayout3.getWidth() > i3) {
                this.f26125l = new StaticLayout(this.f26127n, this.f26123j, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 15.0f, false);
            } else {
                this.f26125l.increaseWidthTo(i3);
            }
        }
    }

    private void d(Canvas canvas) {
        int height = getHeight() / 2;
        int itemHeight = getItemHeight() / 2;
        this.f26128o.setBounds(0, height - itemHeight, getWidth(), height + itemHeight);
        this.f26128o.draw(canvas);
    }

    private void e() {
        if (this.f26122i == null) {
            TextPaint textPaint = new TextPaint(33);
            this.f26122i = textPaint;
            textPaint.setTextSize(40.0f);
        }
        if (this.f26123j == null) {
            TextPaint textPaint2 = new TextPaint(37);
            this.f26123j = textPaint2;
            textPaint2.setTextSize(40.0f);
            this.f26123j.setShadowLayer(0.1f, 0.0f, 0.1f, -4144960);
        }
        if (this.f26128o == null) {
            this.f26128o = getContext().getResources().getDrawable(R.drawable.wheel_val);
        }
        if (this.f26129p == null) {
            this.f26129p = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, f26114b);
        }
        if (this.f26130q == null) {
            this.f26130q = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, f26114b);
        }
        setBackgroundResource(R.drawable.wheel_bg);
    }

    /* access modifiers changed from: private */
    public void f() {
        this.C.removeMessages(0);
        this.C.removeMessages(1);
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.f26116c != null) {
            boolean z2 = false;
            this.f26135v = 0;
            int i2 = this.f26132s;
            int itemHeight = getItemHeight();
            int i3 = this.f26117d;
            if (i2 <= 0 ? i3 > 0 : i3 < this.f26116c.a()) {
                z2 = true;
            }
            if ((this.f26115a || z2) && Math.abs((float) i2) > ((float) itemHeight) / 2.0f) {
                int i4 = itemHeight + 1;
                i2 = i2 < 0 ? i2 + i4 : i2 - i4;
            }
            int i5 = i2;
            if (Math.abs(i5) > 1) {
                this.f26134u.startScroll(0, 0, 0, i5, 400);
                setNextMessage(1);
                return;
            }
            c();
        }
    }

    /* access modifiers changed from: private */
    public int getItemHeight() {
        int i2 = this.f26121h;
        if (i2 != 0) {
            return i2;
        }
        StaticLayout staticLayout = this.f26124k;
        if (staticLayout == null || staticLayout.getLineCount() <= 2) {
            return getHeight() / this.f26120g;
        }
        int lineTop = this.f26124k.getLineTop(2) - this.f26124k.getLineTop(1);
        this.f26121h = lineTop;
        return lineTop;
    }

    private int getMaxTextLength() {
        return getViewAdapter() == null ? 0 : 3;
    }

    /* access modifiers changed from: private */
    public void h() {
        if (!this.f26131r) {
            this.f26131r = true;
            a();
        }
    }

    /* access modifiers changed from: private */
    public void setNextMessage(int i2) {
        f();
        this.C.sendEmptyMessage(i2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        for (c a2 : this.f26137x) {
            a2.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3) {
        for (a a2 : this.f26136w) {
            a2.a(this, i2, i3);
        }
    }

    public void a(int i2, boolean z2) {
        int min;
        int a2;
        c cVar = this.f26116c;
        if (cVar != null && cVar.a() != 0) {
            int a3 = this.f26116c.a();
            if (i2 < 0 || i2 >= this.f26116c.a()) {
                if (this.f26115a) {
                    while (true) {
                        a2 = this.f26116c.a();
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
            int i3 = this.f26117d;
            if (i2 == i3) {
                return;
            }
            if (z2) {
                int i4 = i2 - i3;
                if (this.f26115a && (min = (a3 + Math.min(i2, i3)) - Math.max(i2, this.f26117d)) < Math.abs(i4)) {
                    i4 = i4 < 0 ? min : -min;
                }
                b(i4, 400);
                return;
            }
            this.f26132s = 0;
            d();
            int i5 = this.f26117d;
            this.f26117d = i2;
            a(i5, i2);
            invalidate();
        }
    }

    public void a(a aVar) {
        this.f26136w.add(aVar);
    }

    public void a(b bVar) {
        this.f26138y.add(bVar);
    }

    public void a(c cVar) {
        this.f26137x.add(cVar);
    }

    /* access modifiers changed from: protected */
    public void b() {
        for (c b2 : this.f26137x) {
            b2.b(this);
        }
    }

    public void b(int i2, int i3) {
        this.f26134u.forceFinished(true);
        this.f26135v = this.f26132s;
        int itemHeight = i2 * getItemHeight();
        Scroller scroller = this.f26134u;
        int i4 = this.f26135v;
        scroller.startScroll(0, i4, 0, itemHeight - i4, i3);
        setNextMessage(0);
        h();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f26131r) {
            b();
            this.f26131r = false;
        }
        d();
        invalidate();
    }

    public int getCurrentItem() {
        return this.f26117d;
    }

    public String getLabel() {
        return this.f26127n;
    }

    public c getViewAdapter() {
        return this.f26116c;
    }

    public int getVisibleItems() {
        return this.f26120g;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f26124k == null) {
            int i2 = this.f26118e;
            if (i2 == 0) {
                c(getWidth(), (int) MemoryConstants.GB);
            } else {
                d(i2, this.f26119f);
            }
        }
        if (this.f26118e > 0) {
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
            int a2 = a((Layout) this.f26124k);
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(a2, size2) : a2;
        }
        setMeasuredDimension(c2, size2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getViewAdapter() != null && !this.f26133t.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            g();
        }
        return true;
    }

    public void setCurrentItem(int i2) {
        a(i2, false);
    }

    public void setCyclic(boolean z2) {
        this.f26115a = z2;
        invalidate();
        d();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f26134u.forceFinished(true);
        this.f26134u = new Scroller(getContext(), interpolator);
    }

    public void setLabel(String str) {
        String str2 = this.f26127n;
        if (str2 == null || !str2.equals(str)) {
            this.f26127n = str;
            this.f26125l = null;
            invalidate();
        }
    }

    public void setViewAdapter(c cVar) {
        this.f26116c = cVar;
        d();
        invalidate();
    }

    public void setVisibleItems(int i2) {
        this.f26120g = i2;
        invalidate();
    }
}
