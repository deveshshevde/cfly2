package com.xeagle.android.editor.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.blankj.utilcode.constant.MemoryConstants;
import com.xeagle.R;

public class VideoRangeSeekBar extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f22921a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f22922b;

    /* renamed from: c  reason: collision with root package name */
    private final ThumbView f22923c;

    /* renamed from: d  reason: collision with root package name */
    private final ThumbView f22924d;

    /* renamed from: e  reason: collision with root package name */
    private final ThumbView f22925e;

    /* renamed from: f  reason: collision with root package name */
    private int f22926f;

    /* renamed from: g  reason: collision with root package name */
    private int f22927g;

    /* renamed from: h  reason: collision with root package name */
    private int f22928h;

    /* renamed from: i  reason: collision with root package name */
    private int f22929i;

    /* renamed from: j  reason: collision with root package name */
    private int f22930j;

    /* renamed from: k  reason: collision with root package name */
    private int f22931k;

    /* renamed from: l  reason: collision with root package name */
    private int f22932l;

    /* renamed from: m  reason: collision with root package name */
    private int f22933m;

    /* renamed from: n  reason: collision with root package name */
    private float f22934n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f22935o;

    /* renamed from: p  reason: collision with root package name */
    private a f22936p;

    public interface a {
        void a();

        void a(int i2);

        void a(int i2, int i3, int i4);

        void a(VideoRangeSeekBar videoRangeSeekBar, int i2, int i3, int i4);
    }

    public VideoRangeSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public VideoRangeSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoRangeSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22930j = 0;
        this.f22931k = 5;
        this.f22932l = 1;
        this.f22933m = (5 - 0) / 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VideoRangeSeekBar);
        this.f22929i = obtainStyledAttributes.getDimensionPixelOffset(9, 7);
        this.f22934n = (float) obtainStyledAttributes.getDimensionPixelOffset(3, 1);
        Paint paint = new Paint();
        this.f22922b = paint;
        paint.setColor(obtainStyledAttributes.getColor(4, -1610612736));
        Paint paint2 = new Paint();
        this.f22921a = paint2;
        paint2.setColor(obtainStyledAttributes.getColor(2, -42932));
        this.f22926f = ViewConfiguration.get(context).getScaledTouchSlop();
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(7);
        Drawable drawable3 = obtainStyledAttributes.getDrawable(6);
        ThumbView thumbView = new ThumbView(context, drawable == null ? new ColorDrawable(-42932) : drawable, this.f22929i);
        this.f22923c = thumbView;
        ThumbView thumbView2 = new ThumbView(context, drawable2 == null ? new ColorDrawable(-42932) : drawable2, this.f22929i);
        this.f22924d = thumbView2;
        ThumbView thumbView3 = new ThumbView(context, drawable3 == null ? new ColorDrawable(-42932) : drawable3, 2);
        this.f22925e = thumbView3;
        setTickCount(obtainStyledAttributes.getInteger(10, 5));
        a(obtainStyledAttributes.getInteger(1, 0), obtainStyledAttributes.getInteger(8, this.f22933m));
        obtainStyledAttributes.recycle();
        addView(thumbView);
        addView(thumbView2);
        addView(thumbView3);
        setWillNotDraw(false);
    }

    private int a(float f2) {
        return Math.round(f2 / getIntervalLength());
    }

    private void a() {
        int a2 = a(this.f22923c.getX());
        int rangeIndex = this.f22924d.getRangeIndex();
        if (a2 >= rangeIndex) {
            a2 = rangeIndex - 1;
        }
        if (a(this.f22923c, a2)) {
            g(1);
        }
        this.f22923c.setPressed(false);
    }

    private void a(int i2, int i3) {
        if (!b(i2, i3)) {
            if (this.f22923c.getRangeIndex() != i2) {
                this.f22923c.setTickIndex(i2);
            }
            if (this.f22924d.getRangeIndex() != i3) {
                this.f22924d.setTickIndex(i3);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Thumb index left " + i2 + ", or right " + i3 + " is out of bounds. Check that it is greater than the minimum (" + this.f22930j + ") and less than the maximum value (" + this.f22931k + ")");
    }

    private boolean a(ThumbView thumbView, int i2) {
        thumbView.setX(((float) i2) * getIntervalLength());
        if (thumbView.getRangeIndex() == i2) {
            return false;
        }
        thumbView.setTickIndex(i2);
        return true;
    }

    private void b() {
        int a2 = a(this.f22924d.getX());
        int rangeIndex = this.f22923c.getRangeIndex();
        if (a2 <= rangeIndex) {
            a2 = rangeIndex + 1;
        }
        if (a(this.f22924d, a2)) {
            g(2);
        }
        this.f22924d.setPressed(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r1.f22933m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(int r2, int r3) {
        /*
            r1 = this;
            if (r2 < 0) goto L_0x000d
            int r0 = r1.f22933m
            if (r2 > r0) goto L_0x000d
            if (r3 < 0) goto L_0x000d
            if (r3 <= r0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            r2 = 0
            goto L_0x000e
        L_0x000d:
            r2 = 1
        L_0x000e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.editor.widget.VideoRangeSeekBar.b(int, int):boolean");
    }

    private boolean e(int i2) {
        return i2 > 1;
    }

    private void f(int i2) {
        float x2 = this.f22924d.getX() + ((float) i2);
        float intervalLength = getIntervalLength();
        int i3 = this.f22930j;
        int i4 = this.f22932l;
        float f2 = ((float) (this.f22931k / i4)) * intervalLength;
        if (x2 > ((float) (i3 / i4)) * intervalLength && x2 < f2 && x2 > this.f22923c.getX() + ((float) this.f22929i)) {
            this.f22924d.setX(x2);
            int a2 = a(x2);
            if (this.f22924d.getRangeIndex() != a2) {
                this.f22924d.setTickIndex(a2);
                g(2);
            }
        }
    }

    private void g(int i2) {
        a aVar = this.f22936p;
        if (aVar != null) {
            aVar.a(this, i2, this.f22923c.getRangeIndex(), this.f22924d.getRangeIndex());
        }
    }

    private float getIntervalLength() {
        return getRangeLength() / ((float) this.f22933m);
    }

    private float getRangeLength() {
        int measuredWidth = getMeasuredWidth();
        int i2 = this.f22929i;
        if (measuredWidth < i2) {
            return 0.0f;
        }
        return (float) (measuredWidth - i2);
    }

    private void setTickCount(int i2) {
        int i3 = (i2 - this.f22930j) / this.f22932l;
        if (e(i3)) {
            this.f22931k = i2;
            this.f22933m = i3;
            this.f22924d.setTickIndex(i3);
            return;
        }
        throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
    }

    public void a(int i2) {
        this.f22925e.setX(((float) i2) * getIntervalLength());
    }

    public void b(int i2) {
        a(this.f22924d, i2);
    }

    public void c(int i2) {
        float x2 = this.f22923c.getX() + ((float) i2);
        float intervalLength = getIntervalLength();
        int i3 = this.f22930j;
        int i4 = this.f22932l;
        float f2 = ((float) (this.f22931k / i4)) * intervalLength;
        if (x2 > ((float) (i3 / i4)) * intervalLength && x2 < f2 && x2 < this.f22924d.getX() - ((float) this.f22929i)) {
            this.f22923c.setX(x2);
            int a2 = a(x2);
            if (this.f22923c.getRangeIndex() != a2) {
                this.f22923c.setTickIndex(a2);
                g(1);
            }
        }
    }

    public float d(int i2) {
        return ((float) i2) * getIntervalLength();
    }

    public int getLeftIndex() {
        return this.f22923c.getRangeIndex();
    }

    public int getRightIndex() {
        return this.f22924d.getRangeIndex();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.f22923c.getMeasuredWidth();
        float x2 = this.f22923c.getX();
        float x3 = this.f22924d.getX();
        float f2 = this.f22934n;
        float f3 = (float) measuredHeight;
        Canvas canvas2 = canvas;
        float f4 = ((float) measuredWidth2) + x2;
        float f5 = x3;
        canvas2.drawRect(f4, 0.0f, f5, f2, this.f22921a);
        canvas2.drawRect(f4, f3 - f2, f5, f3, this.f22921a);
        int i2 = this.f22929i;
        if (x2 > ((float) i2)) {
            canvas.drawRect(0.0f, 0.0f, x2 + ((float) i2), f3, this.f22922b);
        }
        if (x3 < ((float) (measuredWidth - this.f22929i))) {
            canvas.drawRect(x3, 0.0f, (float) measuredWidth, f3, this.f22922b);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.f22923c.getMeasuredWidth();
        int measuredHeight = this.f22923c.getMeasuredHeight();
        this.f22923c.layout(0, 0, measuredWidth, measuredHeight);
        this.f22924d.layout(0, 0, measuredWidth, measuredHeight);
        ThumbView thumbView = this.f22925e;
        thumbView.layout(0, 0, thumbView.getMeasuredWidth(), measuredHeight);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), MemoryConstants.GB);
        super.onMeasure(makeMeasureSpec, i3);
        this.f22923c.measure(makeMeasureSpec, i3);
        this.f22924d.measure(makeMeasureSpec, i3);
        this.f22925e.measure(makeMeasureSpec, i3);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        ThumbView thumbView = this.f22923c;
        a(thumbView, thumbView.getRangeIndex());
        ThumbView thumbView2 = this.f22924d;
        a(thumbView2, thumbView2.getRangeIndex());
        ThumbView thumbView3 = this.f22925e;
        a(thumbView3, thumbView3.getRangeIndex());
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.isEnabled()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = r6.getAction()
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L_0x00b9
            if (r0 == r3) goto L_0x0066
            if (r0 == r2) goto L_0x0019
            r6 = 3
            if (r0 == r6) goto L_0x0066
            goto L_0x0119
        L_0x0019:
            float r6 = r6.getX()
            int r6 = (int) r6
            boolean r0 = r5.f22935o
            if (r0 != 0) goto L_0x0030
            int r0 = r5.f22927g
            int r0 = r6 - r0
            int r0 = java.lang.Math.abs(r0)
            int r2 = r5.f22926f
            if (r0 <= r2) goto L_0x0030
            r5.f22935o = r3
        L_0x0030:
            boolean r0 = r5.f22935o
            if (r0 == 0) goto L_0x0062
            int r0 = r5.f22928h
            int r0 = r6 - r0
            com.xeagle.android.editor.widget.ThumbView r2 = r5.f22923c
            boolean r2 = r2.isPressed()
            if (r2 == 0) goto L_0x004f
            android.view.ViewParent r1 = r5.getParent()
            r1.requestDisallowInterceptTouchEvent(r3)
            r5.c(r0)
        L_0x004a:
            r5.invalidate()
            r1 = 1
            goto L_0x0062
        L_0x004f:
            com.xeagle.android.editor.widget.ThumbView r2 = r5.f22924d
            boolean r2 = r2.isPressed()
            if (r2 == 0) goto L_0x0062
            android.view.ViewParent r1 = r5.getParent()
            r1.requestDisallowInterceptTouchEvent(r3)
            r5.f(r0)
            goto L_0x004a
        L_0x0062:
            r5.f22928h = r6
            goto L_0x0119
        L_0x0066:
            r5.f22935o = r1
            r5.f22928h = r1
            r5.f22927g = r1
            android.view.ViewParent r6 = r5.getParent()
            r6.requestDisallowInterceptTouchEvent(r1)
            com.xeagle.android.editor.widget.ThumbView r6 = r5.f22923c
            boolean r6 = r6.isPressed()
            if (r6 == 0) goto L_0x0097
            r5.a()
            r5.invalidate()
            com.xeagle.android.editor.widget.VideoRangeSeekBar$a r6 = r5.f22936p
            if (r6 == 0) goto L_0x0094
            com.xeagle.android.editor.widget.ThumbView r0 = r5.f22923c
            int r0 = r0.getRangeIndex()
            com.xeagle.android.editor.widget.ThumbView r1 = r5.f22924d
            int r1 = r1.getRangeIndex()
            r6.a(r3, r0, r1)
        L_0x0094:
            r1 = 1
            goto L_0x0119
        L_0x0097:
            com.xeagle.android.editor.widget.ThumbView r6 = r5.f22924d
            boolean r6 = r6.isPressed()
            if (r6 == 0) goto L_0x0119
            r5.b()
            r5.invalidate()
            com.xeagle.android.editor.widget.VideoRangeSeekBar$a r6 = r5.f22936p
            if (r6 == 0) goto L_0x0094
            com.xeagle.android.editor.widget.ThumbView r0 = r5.f22923c
            int r0 = r0.getRangeIndex()
            com.xeagle.android.editor.widget.ThumbView r1 = r5.f22924d
            int r1 = r1.getRangeIndex()
            r6.a(r2, r0, r1)
            goto L_0x0094
        L_0x00b9:
            float r0 = r6.getX()
            int r0 = (int) r0
            float r6 = r6.getY()
            int r6 = (int) r6
            r5.f22927g = r0
            r5.f22928h = r0
            r5.f22935o = r1
            com.xeagle.android.editor.widget.ThumbView r4 = r5.f22923c
            boolean r4 = r4.isPressed()
            if (r4 != 0) goto L_0x00e7
            com.xeagle.android.editor.widget.ThumbView r4 = r5.f22923c
            boolean r4 = r4.a(r0, r6)
            if (r4 == 0) goto L_0x00e7
            com.xeagle.android.editor.widget.ThumbView r6 = r5.f22923c
            r6.setPressed(r3)
            com.xeagle.android.editor.widget.VideoRangeSeekBar$a r6 = r5.f22936p
            if (r6 == 0) goto L_0x00e5
            r6.a(r3)
        L_0x00e5:
            r1 = 1
            goto L_0x0104
        L_0x00e7:
            com.xeagle.android.editor.widget.ThumbView r4 = r5.f22924d
            boolean r4 = r4.isPressed()
            if (r4 != 0) goto L_0x0104
            com.xeagle.android.editor.widget.ThumbView r4 = r5.f22924d
            boolean r6 = r4.a(r0, r6)
            if (r6 == 0) goto L_0x0104
            com.xeagle.android.editor.widget.ThumbView r6 = r5.f22924d
            r6.setPressed(r3)
            com.xeagle.android.editor.widget.VideoRangeSeekBar$a r6 = r5.f22936p
            if (r6 == 0) goto L_0x00e5
            r6.a(r2)
            goto L_0x00e5
        L_0x0104:
            com.xeagle.android.editor.widget.ThumbView r6 = r5.f22924d
            boolean r6 = r6.isPressed()
            if (r6 != 0) goto L_0x0119
            com.xeagle.android.editor.widget.ThumbView r6 = r5.f22923c
            boolean r6 = r6.isPressed()
            if (r6 != 0) goto L_0x0119
            com.xeagle.android.editor.widget.VideoRangeSeekBar$a r6 = r5.f22936p
            r6.a()
        L_0x0119:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.editor.widget.VideoRangeSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setLeftThumbDrawable(Drawable drawable) {
        this.f22923c.setThumbDrawable(drawable);
    }

    public void setLineColor(int i2) {
        this.f22921a.setColor(i2);
    }

    public void setLineSize(float f2) {
        this.f22934n = f2;
    }

    public void setMaskColor(int i2) {
        this.f22922b.setColor(i2);
    }

    public void setOnRangeChangeListener(a aVar) {
        this.f22936p = aVar;
    }

    public void setProgressThumb(Drawable drawable) {
        this.f22925e.setThumbDrawable(drawable);
    }

    public void setProgressThumbVisible(boolean z2) {
        ThumbView thumbView;
        int i2;
        if (z2) {
            thumbView = this.f22925e;
            i2 = 0;
        } else {
            thumbView = this.f22925e;
            i2 = 8;
        }
        thumbView.setVisibility(i2);
    }

    public void setRightThumbDrawable(Drawable drawable) {
        this.f22924d.setThumbDrawable(drawable);
    }

    public void setThumbWidth(int i2) {
        this.f22929i = i2;
        this.f22923c.setThumbWidth(i2);
        this.f22924d.setThumbWidth(i2);
    }
}
