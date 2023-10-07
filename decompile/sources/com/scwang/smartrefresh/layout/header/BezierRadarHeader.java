package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.b;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import ja.g;
import ja.j;

public class BezierRadarHeader extends InternalAbstract implements g {

    /* renamed from: a  reason: collision with root package name */
    protected int f12133a;

    /* renamed from: b  reason: collision with root package name */
    protected int f12134b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f12135c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f12136d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f12137e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f12138f;

    /* renamed from: g  reason: collision with root package name */
    protected Path f12139g;

    /* renamed from: h  reason: collision with root package name */
    protected Paint f12140h;

    /* renamed from: i  reason: collision with root package name */
    protected int f12141i;

    /* renamed from: j  reason: collision with root package name */
    protected int f12142j;

    /* renamed from: k  reason: collision with root package name */
    protected int f12143k;

    /* renamed from: l  reason: collision with root package name */
    protected int f12144l;

    /* renamed from: m  reason: collision with root package name */
    protected float f12145m;

    /* renamed from: n  reason: collision with root package name */
    protected float f12146n;

    /* renamed from: o  reason: collision with root package name */
    protected float f12147o;

    /* renamed from: p  reason: collision with root package name */
    protected float f12148p;

    /* renamed from: q  reason: collision with root package name */
    protected int f12149q;

    /* renamed from: r  reason: collision with root package name */
    protected float f12150r;

    /* renamed from: s  reason: collision with root package name */
    protected float f12151s;

    /* renamed from: t  reason: collision with root package name */
    protected float f12152t;

    /* renamed from: u  reason: collision with root package name */
    protected Animator f12153u;

    /* renamed from: v  reason: collision with root package name */
    protected RectF f12154v;

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21561a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21561a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21561a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.header.BezierRadarHeader.AnonymousClass1.<clinit>():void");
        }
    }

    protected class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        byte f21562a;

        a(byte b2) {
            this.f21562a = b2;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b2 = this.f21562a;
            if (b2 == 0) {
                BezierRadarHeader.this.f12152t = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b2) {
                if (BezierRadarHeader.this.f12137e) {
                    valueAnimator.cancel();
                    return;
                } else {
                    BezierRadarHeader.this.f12142j = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
                }
            } else if (2 == b2) {
                BezierRadarHeader.this.f12145m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b2) {
                BezierRadarHeader.this.f12148p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b2) {
                BezierRadarHeader.this.f12149q = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            BezierRadarHeader.this.invalidate();
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, (AttributeSet) null);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f12138f = false;
        this.f12143k = -1;
        this.f12144l = 0;
        this.f12149q = 0;
        this.f12150r = 0.0f;
        this.f12151s = 0.0f;
        this.f12152t = 0.0f;
        this.f12154v = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f12189y = b.f12101c;
        this.f12139g = new Path();
        Paint paint = new Paint();
        this.f12140h = paint;
        paint.setAntiAlias(true);
        this.f12147o = (float) jc.b.a(7.0f);
        this.f12150r = (float) jc.b.a(20.0f);
        this.f12151s = (float) jc.b.a(7.0f);
        this.f12140h.setStrokeWidth((float) jc.b.a(3.0f));
        setMinimumHeight(jc.b.a(100.0f));
        if (isInEditMode()) {
            this.f12141i = 1000;
            this.f12152t = 1.0f;
            this.f12149q = SubsamplingScaleImageView.ORIENTATION_270;
        } else {
            this.f12152t = 0.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BezierRadarHeader);
        this.f12138f = obtainStyledAttributes.getBoolean(R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.f12138f);
        b(obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlAccentColor, -1));
        a(obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlPrimaryColor, -14540254));
        this.f12136d = obtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlAccentColor);
        this.f12135c = obtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlPrimaryColor);
        obtainStyledAttributes.recycle();
    }

    public int a(j jVar, boolean z2) {
        Animator animator = this.f12153u;
        if (animator != null) {
            animator.removeAllListeners();
            this.f12153u.end();
            this.f12153u = null;
        }
        int width = getWidth();
        int i2 = this.f12144l;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f12150r, (float) Math.sqrt((double) ((width * width) + (i2 * i2)))});
        ofFloat.setDuration(400);
        ofFloat.addUpdateListener(new a((byte) 3));
        ofFloat.start();
        return 400;
    }

    public BezierRadarHeader a(int i2) {
        this.f12134b = i2;
        this.f12135c = true;
        return this;
    }

    public void a(float f2, int i2, int i3) {
        this.f12143k = i2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, int i2) {
        this.f12139g.reset();
        this.f12139g.lineTo(0.0f, (float) this.f12141i);
        Path path = this.f12139g;
        int i3 = this.f12143k;
        float f2 = i3 >= 0 ? (float) i3 : ((float) i2) / 2.0f;
        int i4 = this.f12141i;
        float f3 = (float) i2;
        path.quadTo(f2, (float) (this.f12142j + i4), f3, (float) i4);
        this.f12139g.lineTo(f3, 0.0f);
        this.f12140h.setColor(this.f12134b);
        canvas.drawPath(this.f12139g, this.f12140h);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, int i2, int i3) {
        float f2 = 0.0f;
        if (this.f12145m > 0.0f) {
            this.f12140h.setColor(this.f12133a);
            float a2 = jc.b.a(i3);
            float f3 = (float) i2;
            float f4 = 7.0f;
            float f5 = (f3 * 1.0f) / 7.0f;
            float f6 = this.f12146n;
            float f7 = (f5 * f6) - (f6 > 1.0f ? ((f6 - 1.0f) * f5) / f6 : 0.0f);
            float f8 = (float) i3;
            if (f6 > 1.0f) {
                f2 = (((f6 - 1.0f) * f8) / 2.0f) / f6;
            }
            float f9 = f8 - f2;
            int i4 = 0;
            while (i4 < 7) {
                float f10 = (((float) i4) + 1.0f) - 4.0f;
                Paint paint = this.f12140h;
                double abs = (double) (this.f12145m * (1.0f - ((Math.abs(f10) / f4) * 2.0f)) * 255.0f);
                double d2 = (double) a2;
                Double.isNaN(d2);
                Double.isNaN(abs);
                paint.setAlpha((int) (abs * (1.0d - (1.0d / Math.pow((d2 / 800.0d) + 1.0d, 15.0d)))));
                float f11 = this.f12147o * (1.0f - (1.0f / ((a2 / 10.0f) + 1.0f)));
                canvas.drawCircle(((f3 / 2.0f) - (f11 / 2.0f)) + (f7 * f10), f9 / 2.0f, f11, this.f12140h);
                i4++;
                f4 = 7.0f;
            }
            this.f12140h.setAlpha(255);
        }
    }

    public void a(j jVar, int i2, int i3) {
        this.f12141i = i2 - 1;
        this.f12137e = false;
        jc.b bVar = new jc.b(jc.b.f13808b);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(bVar);
        ofFloat.addUpdateListener(new a((byte) 2));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(bVar);
        ofFloat2.addUpdateListener(new a((byte) 0));
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, SpatialRelationUtil.A_CIRCLE_DEGREE});
        ofInt.setDuration(720);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new a((byte) 4));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofFloat, ofFloat2, ofInt});
        animatorSet.start();
        int i4 = this.f12142j;
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{i4, 0, -((int) (((float) i4) * 0.8f)), 0, -((int) (((float) i4) * 0.4f)), 0});
        ofInt2.addUpdateListener(new a((byte) 1));
        ofInt2.setInterpolator(new jc.b(jc.b.f13808b));
        ofInt2.setDuration(800);
        ofInt2.start();
        this.f12153u = animatorSet;
    }

    public void a(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        int i2 = AnonymousClass1.f21561a[refreshState2.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.f12145m = 1.0f;
            this.f12152t = 0.0f;
            this.f12148p = 0.0f;
        }
    }

    public void a(boolean z2, float f2, int i2, int i3, int i4) {
        this.f12144l = i2;
        if (z2 || this.f12137e) {
            this.f12137e = true;
            this.f12141i = Math.min(i3, i2);
            this.f12142j = (int) (((float) Math.max(0, i2 - i3)) * 1.9f);
            this.f12146n = f2;
            invalidate();
        }
    }

    public boolean a() {
        return this.f12138f;
    }

    public BezierRadarHeader b(int i2) {
        this.f12133a = i2;
        this.f12136d = true;
        return this;
    }

    /* access modifiers changed from: protected */
    public void b(Canvas canvas, int i2, int i3) {
        if (this.f12153u != null || isInEditMode()) {
            float f2 = this.f12150r;
            float f3 = this.f12152t;
            float f4 = f2 * f3;
            float f5 = this.f12151s * f3;
            this.f12140h.setColor(this.f12133a);
            this.f12140h.setStyle(Paint.Style.FILL);
            float f6 = ((float) i2) / 2.0f;
            float f7 = ((float) i3) / 2.0f;
            canvas.drawCircle(f6, f7, f4, this.f12140h);
            this.f12140h.setStyle(Paint.Style.STROKE);
            float f8 = f5 + f4;
            canvas.drawCircle(f6, f7, f8, this.f12140h);
            this.f12140h.setColor((this.f12134b & 16777215) | 1426063360);
            this.f12140h.setStyle(Paint.Style.FILL);
            this.f12154v.set(f6 - f4, f7 - f4, f6 + f4, f4 + f7);
            canvas.drawArc(this.f12154v, 270.0f, (float) this.f12149q, true, this.f12140h);
            this.f12140h.setStyle(Paint.Style.STROKE);
            this.f12154v.set(f6 - f8, f7 - f8, f6 + f8, f7 + f8);
            canvas.drawArc(this.f12154v, 270.0f, (float) this.f12149q, false, this.f12140h);
            this.f12140h.setStyle(Paint.Style.FILL);
        }
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas, int i2, int i3) {
        if (this.f12148p > 0.0f) {
            this.f12140h.setColor(this.f12133a);
            canvas.drawCircle(((float) i2) / 2.0f, ((float) i3) / 2.0f, this.f12148p, this.f12140h);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = isInEditMode() ? getHeight() : this.f12144l;
        a(canvas, width);
        a(canvas, width, height);
        b(canvas, width, height);
        c(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.f12153u;
        if (animator != null) {
            animator.removeAllListeners();
            this.f12153u.end();
            this.f12153u = null;
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0 && !this.f12135c) {
            a(iArr[0]);
            this.f12135c = false;
        }
        if (iArr.length > 1 && !this.f12136d) {
            b(iArr[1]);
            this.f12136d = false;
        }
    }
}
