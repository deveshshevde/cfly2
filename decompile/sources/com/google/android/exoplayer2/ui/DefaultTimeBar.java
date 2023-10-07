package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.ui.c;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

public class DefaultTimeBar extends View implements c {
    private long A;
    private int B;
    private Rect C;
    private ValueAnimator D;
    private float E;
    private boolean F;
    private long G;
    private long H;
    private long I;
    private long J;
    private int K;
    private long[] L;
    private boolean[] M;

    /* renamed from: a  reason: collision with root package name */
    private final Rect f16776a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f16777b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f16778c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f16779d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f16780e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f16781f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f16782g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f16783h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f16784i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f16785j;

    /* renamed from: k  reason: collision with root package name */
    private final Drawable f16786k;

    /* renamed from: l  reason: collision with root package name */
    private final int f16787l;

    /* renamed from: m  reason: collision with root package name */
    private final int f16788m;

    /* renamed from: n  reason: collision with root package name */
    private final int f16789n;

    /* renamed from: o  reason: collision with root package name */
    private final int f16790o;

    /* renamed from: p  reason: collision with root package name */
    private final int f16791p;

    /* renamed from: q  reason: collision with root package name */
    private final int f16792q;

    /* renamed from: r  reason: collision with root package name */
    private final int f16793r;

    /* renamed from: s  reason: collision with root package name */
    private final int f16794s;

    /* renamed from: t  reason: collision with root package name */
    private final StringBuilder f16795t;

    /* renamed from: u  reason: collision with root package name */
    private final Formatter f16796u;

    /* renamed from: v  reason: collision with root package name */
    private final Runnable f16797v;

    /* renamed from: w  reason: collision with root package name */
    private final CopyOnWriteArraySet<c.a> f16798w;

    /* renamed from: x  reason: collision with root package name */
    private final Point f16799x;

    /* renamed from: y  reason: collision with root package name */
    private final float f16800y;

    /* renamed from: z  reason: collision with root package name */
    private int f16801z;

    public DefaultTimeBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        int i3;
        int i4;
        AttributeSet attributeSet3 = attributeSet2;
        this.f16776a = new Rect();
        this.f16777b = new Rect();
        this.f16778c = new Rect();
        this.f16779d = new Rect();
        Paint paint = new Paint();
        this.f16780e = paint;
        Paint paint2 = new Paint();
        this.f16781f = paint2;
        Paint paint3 = new Paint();
        this.f16782g = paint3;
        Paint paint4 = new Paint();
        this.f16783h = paint4;
        Paint paint5 = new Paint();
        this.f16784i = paint5;
        Paint paint6 = new Paint();
        this.f16785j = paint6;
        paint6.setAntiAlias(true);
        this.f16798w = new CopyOnWriteArraySet<>();
        this.f16799x = new Point();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f16800y = f2;
        this.f16794s = a(f2, -50);
        int a2 = a(f2, 4);
        int a3 = a(f2, 26);
        int a4 = a(f2, 4);
        int a5 = a(f2, 12);
        int a6 = a(f2, 0);
        int a7 = a(f2, 16);
        if (attributeSet3 != null) {
            Paint paint7 = paint5;
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet3, R.styleable.DefaultTimeBar, 0, 0);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.DefaultTimeBar_scrubber_drawable);
                this.f16786k = drawable;
                if (drawable != null) {
                    a(drawable);
                    a3 = Math.max(drawable.getMinimumHeight(), a3);
                }
                this.f16787l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_bar_height, a2);
                this.f16788m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_touch_target_height, a3);
                this.f16789n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_ad_marker_width, a4);
                this.f16790o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_enabled_size, a5);
                this.f16791p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_disabled_size, a6);
                this.f16792q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_dragged_size, a7);
                int i5 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_color, -1);
                int i6 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_scrubber_color, -1);
                int i7 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_buffered_color, -855638017);
                int i8 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_unplayed_color, 872415231);
                int i9 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_ad_marker_color, -1291845888);
                int i10 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i5);
                paint6.setColor(i6);
                paint2.setColor(i7);
                paint3.setColor(i8);
                paint4.setColor(i9);
                paint7.setColor(i10);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.f16787l = a2;
            this.f16788m = a3;
            this.f16789n = a4;
            this.f16790o = a5;
            this.f16791p = a6;
            this.f16792q = a7;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f16786k = null;
        }
        StringBuilder sb = new StringBuilder();
        this.f16795t = sb;
        this.f16796u = new Formatter(sb, Locale.getDefault());
        this.f16797v = new Runnable() {
            public final void run() {
                DefaultTimeBar.this.c();
            }
        };
        Drawable drawable2 = this.f16786k;
        if (drawable2 != null) {
            i4 = drawable2.getMinimumWidth();
            i3 = 1;
        } else {
            i3 = 1;
            i4 = Math.max(this.f16791p, Math.max(this.f16790o, this.f16792q));
        }
        this.f16793r = (i4 + i3) / 2;
        this.E = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.D = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DefaultTimeBar.this.a(valueAnimator);
            }
        });
        this.H = -9223372036854775807L;
        this.A = -9223372036854775807L;
        this.f16801z = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private static int a(float f2, int i2) {
        return (int) ((((float) i2) * f2) + 0.5f);
    }

    private Point a(MotionEvent motionEvent) {
        this.f16799x.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f16799x;
    }

    private void a() {
        this.f16778c.set(this.f16777b);
        this.f16779d.set(this.f16777b);
        long j2 = this.F ? this.G : this.I;
        if (this.H > 0) {
            this.f16778c.right = Math.min(this.f16777b.left + ((int) ((((long) this.f16777b.width()) * this.J) / this.H)), this.f16777b.right);
            this.f16779d.right = Math.min(this.f16777b.left + ((int) ((((long) this.f16777b.width()) * j2) / this.H)), this.f16777b.right);
        } else {
            this.f16778c.right = this.f16777b.left;
            this.f16779d.right = this.f16777b.left;
        }
        invalidate(this.f16776a);
    }

    private void a(float f2) {
        this.f16779d.right = ad.a((int) f2, this.f16777b.left, this.f16777b.right);
    }

    private void a(int i2, int i3) {
        Rect rect = this.C;
        if (rect == null || rect.width() != i2 || this.C.height() != i3) {
            Rect rect2 = new Rect(0, 0, i2, i3);
            this.C = rect2;
            setSystemGestureExclusionRects(Collections.singletonList(rect2));
        }
    }

    private void a(long j2) {
        this.G = j2;
        this.F = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<c.a> it2 = this.f16798w.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, j2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.E = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f16776a);
    }

    private void a(Canvas canvas) {
        int height = this.f16777b.height();
        int centerY = this.f16777b.centerY() - (height / 2);
        int i2 = height + centerY;
        if (this.H <= 0) {
            canvas.drawRect((float) this.f16777b.left, (float) centerY, (float) this.f16777b.right, (float) i2, this.f16782g);
            return;
        }
        int i3 = this.f16778c.left;
        int i4 = this.f16778c.right;
        int max = Math.max(Math.max(this.f16777b.left, i4), this.f16779d.right);
        if (max < this.f16777b.right) {
            canvas.drawRect((float) max, (float) centerY, (float) this.f16777b.right, (float) i2, this.f16782g);
        }
        int max2 = Math.max(i3, this.f16779d.right);
        if (i4 > max2) {
            canvas.drawRect((float) max2, (float) centerY, (float) i4, (float) i2, this.f16781f);
        }
        if (this.f16779d.width() > 0) {
            canvas.drawRect((float) this.f16779d.left, (float) centerY, (float) this.f16779d.right, (float) i2, this.f16780e);
        }
        if (this.K != 0) {
            long[] jArr = (long[]) a.b(this.L);
            boolean[] zArr = (boolean[]) a.b(this.M);
            int i5 = this.f16789n / 2;
            for (int i6 = 0; i6 < this.K; i6++) {
                int min = this.f16777b.left + Math.min(this.f16777b.width() - this.f16789n, Math.max(0, ((int) ((((long) this.f16777b.width()) * ad.a(jArr[i6], 0, this.H)) / this.H)) - i5));
                canvas.drawRect((float) min, (float) centerY, (float) (min + this.f16789n), (float) i2, zArr[i6] ? this.f16784i : this.f16783h);
            }
        }
    }

    private void a(boolean z2) {
        removeCallbacks(this.f16797v);
        this.F = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<c.a> it2 = this.f16798w.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, this.G, z2);
        }
    }

    private boolean a(float f2, float f3) {
        return this.f16776a.contains((int) f2, (int) f3);
    }

    private boolean a(Drawable drawable) {
        return ad.f11755a >= 23 && a(drawable, getLayoutDirection());
    }

    private static boolean a(Drawable drawable, int i2) {
        return ad.f11755a >= 23 && drawable.setLayoutDirection(i2);
    }

    private static int b(float f2, int i2) {
        return (int) (((float) i2) / f2);
    }

    private void b() {
        Drawable drawable = this.f16786k;
        if (drawable != null && drawable.isStateful() && this.f16786k.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void b(long j2) {
        if (this.G != j2) {
            this.G = j2;
            Iterator<c.a> it2 = this.f16798w.iterator();
            while (it2.hasNext()) {
                it2.next().b(this, j2);
            }
        }
    }

    private void b(Canvas canvas) {
        if (this.H > 0) {
            int a2 = ad.a(this.f16779d.right, this.f16779d.left, this.f16777b.right);
            int centerY = this.f16779d.centerY();
            Drawable drawable = this.f16786k;
            if (drawable == null) {
                canvas.drawCircle((float) a2, (float) centerY, (float) ((int) ((((float) ((this.F || isFocused()) ? this.f16792q : isEnabled() ? this.f16790o : this.f16791p)) * this.E) / 2.0f)), this.f16785j);
                return;
            }
            int intrinsicWidth = ((int) (((float) drawable.getIntrinsicWidth()) * this.E)) / 2;
            int intrinsicHeight = ((int) (((float) this.f16786k.getIntrinsicHeight()) * this.E)) / 2;
            this.f16786k.setBounds(a2 - intrinsicWidth, centerY - intrinsicHeight, a2 + intrinsicWidth, centerY + intrinsicHeight);
            this.f16786k.draw(canvas);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        a(false);
    }

    private boolean c(long j2) {
        long j3 = this.H;
        if (j3 <= 0) {
            return false;
        }
        long j4 = this.F ? this.G : this.I;
        long a2 = ad.a(j4 + j2, 0, j3);
        if (a2 == j4) {
            return false;
        }
        if (!this.F) {
            a(a2);
        } else {
            b(a2);
        }
        a();
        return true;
    }

    private long getPositionIncrement() {
        long j2 = this.A;
        if (j2 != -9223372036854775807L) {
            return j2;
        }
        long j3 = this.H;
        if (j3 == -9223372036854775807L) {
            return 0;
        }
        return j3 / ((long) this.f16801z);
    }

    private String getProgressText() {
        return ad.a(this.f16795t, this.f16796u, this.I);
    }

    private long getScrubberPosition() {
        if (this.f16777b.width() <= 0 || this.H == -9223372036854775807L) {
            return 0;
        }
        return (((long) this.f16779d.width()) * this.H) / ((long) this.f16777b.width());
    }

    public void a(c.a aVar) {
        this.f16798w.add(aVar);
    }

    public void a(long[] jArr, boolean[] zArr, int i2) {
        a.a(i2 == 0 || !(jArr == null || zArr == null));
        this.K = i2;
        this.L = jArr;
        this.M = zArr;
        a();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        b();
    }

    public long getPreferredUpdateDelay() {
        int b2 = b(this.f16800y, this.f16777b.width());
        if (b2 != 0) {
            long j2 = this.H;
            if (!(j2 == 0 || j2 == -9223372036854775807L)) {
                return j2 / ((long) b2);
            }
        }
        return Long.MAX_VALUE;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f16786k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (this.F && !z2) {
            a(false);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.H > 0) {
            if (ad.f11755a >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                return;
            }
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (c(r0) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        removeCallbacks(r4.f16797v);
        postDelayed(r4.f16797v, 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L_0x0030
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L_0x0027
            switch(r5) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0027;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0030
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r0 = r4.c(r0)
            if (r0 == 0) goto L_0x0030
            java.lang.Runnable r5 = r4.f16797v
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.f16797v
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L_0x0027:
            boolean r0 = r4.F
            if (r0 == 0) goto L_0x0030
            r5 = 0
            r4.a((boolean) r5)
            return r3
        L_0x0030:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = (i7 - this.f16788m) / 2;
        int i9 = this.f16788m;
        int i10 = ((i9 - this.f16787l) / 2) + i8;
        this.f16776a.set(getPaddingLeft(), i8, i6 - getPaddingRight(), i9 + i8);
        this.f16777b.set(this.f16776a.left + this.f16793r, i10, this.f16776a.right - this.f16793r, this.f16787l + i10);
        if (ad.f11755a >= 29) {
            a(i6, i7);
        }
        a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 0) {
            size = this.f16788m;
        } else if (mode != 1073741824) {
            size = Math.min(this.f16788m, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i2), size);
        b();
    }

    public void onRtlPropertiesChanged(int i2) {
        Drawable drawable = this.f16786k;
        if (drawable != null && a(drawable, i2)) {
            invalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r3 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x006d
            long r2 = r7.H
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0010
            goto L_0x006d
        L_0x0010:
            android.graphics.Point r0 = r7.a((android.view.MotionEvent) r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L_0x005a
            r5 = 3
            if (r3 == r4) goto L_0x004b
            r6 = 2
            if (r3 == r6) goto L_0x0028
            if (r3 == r5) goto L_0x004b
            goto L_0x006d
        L_0x0028:
            boolean r8 = r7.F
            if (r8 == 0) goto L_0x006d
            int r8 = r7.f16794s
            if (r0 >= r8) goto L_0x0037
            int r8 = r7.B
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            goto L_0x003a
        L_0x0037:
            r7.B = r2
            float r8 = (float) r2
        L_0x003a:
            r7.a((float) r8)
            long r0 = r7.getScrubberPosition()
            r7.b((long) r0)
        L_0x0044:
            r7.a()
            r7.invalidate()
            return r4
        L_0x004b:
            boolean r0 = r7.F
            if (r0 == 0) goto L_0x006d
            int r8 = r8.getAction()
            if (r8 != r5) goto L_0x0056
            r1 = 1
        L_0x0056:
            r7.a((boolean) r1)
            return r4
        L_0x005a:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.a((float) r8, (float) r0)
            if (r0 == 0) goto L_0x006d
            r7.a((float) r8)
            long r0 = r7.getScrubberPosition()
            r7.a((long) r0)
            goto L_0x0044
        L_0x006d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (c(getPositionIncrement()) != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (c(-getPositionIncrement()) != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performAccessibilityAction(int r7, android.os.Bundle r8) {
        /*
            r6 = this;
            boolean r8 = super.performAccessibilityAction(r7, r8)
            r0 = 1
            if (r8 == 0) goto L_0x0008
            return r0
        L_0x0008:
            long r1 = r6.H
            r3 = 0
            r8 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0012
            return r8
        L_0x0012:
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r7 != r1) goto L_0x0025
            long r1 = r6.getPositionIncrement()
            long r1 = -r1
            boolean r7 = r6.c(r1)
            if (r7 == 0) goto L_0x0034
        L_0x0021:
            r6.a((boolean) r8)
            goto L_0x0034
        L_0x0025:
            r1 = 4096(0x1000, float:5.74E-42)
            if (r7 != r1) goto L_0x0039
            long r1 = r6.getPositionIncrement()
            boolean r7 = r6.c(r1)
            if (r7 == 0) goto L_0x0034
            goto L_0x0021
        L_0x0034:
            r7 = 4
            r6.sendAccessibilityEvent(r7)
            return r0
        L_0x0039:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.performAccessibilityAction(int, android.os.Bundle):boolean");
    }

    public void setAdMarkerColor(int i2) {
        this.f16783h.setColor(i2);
        invalidate(this.f16776a);
    }

    public void setBufferedColor(int i2) {
        this.f16781f.setColor(i2);
        invalidate(this.f16776a);
    }

    public void setBufferedPosition(long j2) {
        this.J = j2;
        a();
    }

    public void setDuration(long j2) {
        this.H = j2;
        if (this.F && j2 == -9223372036854775807L) {
            a(true);
        }
        a();
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (this.F && !z2) {
            a(true);
        }
    }

    public void setKeyCountIncrement(int i2) {
        a.a(i2 > 0);
        this.f16801z = i2;
        this.A = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j2) {
        a.a(j2 > 0);
        this.f16801z = -1;
        this.A = j2;
    }

    public void setPlayedAdMarkerColor(int i2) {
        this.f16784i.setColor(i2);
        invalidate(this.f16776a);
    }

    public void setPlayedColor(int i2) {
        this.f16780e.setColor(i2);
        invalidate(this.f16776a);
    }

    public void setPosition(long j2) {
        this.I = j2;
        setContentDescription(getProgressText());
        a();
    }

    public void setScrubberColor(int i2) {
        this.f16785j.setColor(i2);
        invalidate(this.f16776a);
    }

    public void setUnplayedColor(int i2) {
        this.f16782g.setColor(i2);
        invalidate(this.f16776a);
    }
}
