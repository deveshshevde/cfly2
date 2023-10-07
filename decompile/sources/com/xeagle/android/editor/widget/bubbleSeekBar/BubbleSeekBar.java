package com.xeagle.android.editor.widget.bubbleSeekBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import com.xeagle.R;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class BubbleSeekBar extends View {
    private boolean A;
    private boolean B;
    /* access modifiers changed from: private */
    public long C;
    /* access modifiers changed from: private */
    public boolean D;
    private long E;
    /* access modifiers changed from: private */
    public boolean F;
    private boolean G;
    private boolean H;
    /* access modifiers changed from: private */
    public int I;
    /* access modifiers changed from: private */
    public int J;
    /* access modifiers changed from: private */
    public int K;
    private float L;
    private float M;
    /* access modifiers changed from: private */
    public float N;
    private float O;
    private float P;
    /* access modifiers changed from: private */
    public boolean Q;
    private int R;
    /* access modifiers changed from: private */
    public boolean S;
    private SparseArray<String> T;
    private float U;
    private boolean V;
    private Drawable W;

    /* renamed from: a  reason: collision with root package name */
    float f22969a;

    /* renamed from: aa  reason: collision with root package name */
    private Bitmap f22970aa;

    /* renamed from: ab  reason: collision with root package name */
    private int f22971ab;

    /* renamed from: ac  reason: collision with root package name */
    private float f22972ac;

    /* renamed from: ad  reason: collision with root package name */
    private Drawable f22973ad;

    /* renamed from: ae  reason: collision with root package name */
    private Bitmap f22974ae;
    /* access modifiers changed from: private */

    /* renamed from: af  reason: collision with root package name */
    public c f22975af;

    /* renamed from: ag  reason: collision with root package name */
    private float f22976ag;

    /* renamed from: ah  reason: collision with root package name */
    private float f22977ah;

    /* renamed from: ai  reason: collision with root package name */
    private Paint f22978ai;

    /* renamed from: aj  reason: collision with root package name */
    private Rect f22979aj;
    /* access modifiers changed from: private */

    /* renamed from: ak  reason: collision with root package name */
    public WindowManager f22980ak;
    /* access modifiers changed from: private */

    /* renamed from: al  reason: collision with root package name */
    public a f22981al;
    /* access modifiers changed from: private */

    /* renamed from: am  reason: collision with root package name */
    public int f22982am;

    /* renamed from: an  reason: collision with root package name */
    private float f22983an;

    /* renamed from: ao  reason: collision with root package name */
    private float f22984ao;
    /* access modifiers changed from: private */

    /* renamed from: ap  reason: collision with root package name */
    public float f22985ap;
    /* access modifiers changed from: private */

    /* renamed from: aq  reason: collision with root package name */
    public WindowManager.LayoutParams f22986aq;

    /* renamed from: ar  reason: collision with root package name */
    private int[] f22987ar;
    /* access modifiers changed from: private */

    /* renamed from: as  reason: collision with root package name */
    public boolean f22988as;

    /* renamed from: at  reason: collision with root package name */
    private float f22989at;

    /* renamed from: b  reason: collision with root package name */
    private Context f22990b;

    /* renamed from: c  reason: collision with root package name */
    private float f22991c;

    /* renamed from: d  reason: collision with root package name */
    private float f22992d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public float f22993e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22994f;

    /* renamed from: g  reason: collision with root package name */
    private int f22995g;

    /* renamed from: h  reason: collision with root package name */
    private int f22996h;

    /* renamed from: i  reason: collision with root package name */
    private int f22997i;

    /* renamed from: j  reason: collision with root package name */
    private int f22998j;

    /* renamed from: k  reason: collision with root package name */
    private int f22999k;

    /* renamed from: l  reason: collision with root package name */
    private int f23000l;

    /* renamed from: m  reason: collision with root package name */
    private int f23001m;

    /* renamed from: n  reason: collision with root package name */
    private int f23002n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f23003o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f23004p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f23005q;

    /* renamed from: r  reason: collision with root package name */
    private int f23006r;

    /* renamed from: s  reason: collision with root package name */
    private int f23007s;

    /* renamed from: t  reason: collision with root package name */
    private int f23008t;

    /* renamed from: u  reason: collision with root package name */
    private int f23009u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f23010v;

    /* renamed from: w  reason: collision with root package name */
    private int f23011w;

    /* renamed from: x  reason: collision with root package name */
    private int f23012x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public boolean f23013y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f23014z;

    private class a extends View {

        /* renamed from: b  reason: collision with root package name */
        private Paint f23025b;

        /* renamed from: c  reason: collision with root package name */
        private Path f23026c;

        /* renamed from: d  reason: collision with root package name */
        private RectF f23027d;

        /* renamed from: e  reason: collision with root package name */
        private Rect f23028e;

        /* renamed from: f  reason: collision with root package name */
        private String f23029f;

        a(BubbleSeekBar bubbleSeekBar, Context context) {
            this(bubbleSeekBar, context, (AttributeSet) null);
        }

        a(BubbleSeekBar bubbleSeekBar, Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        a(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f23029f = "";
            Paint paint = new Paint();
            this.f23025b = paint;
            paint.setAntiAlias(true);
            this.f23025b.setTextAlign(Paint.Align.CENTER);
            this.f23026c = new Path();
            this.f23027d = new RectF();
            this.f23028e = new Rect();
        }

        /* access modifiers changed from: package-private */
        public void a(String str) {
            if (str != null && !this.f23029f.equals(str)) {
                this.f23029f = str;
                invalidate();
            }
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.f23026c.reset();
            float measuredWidth = ((float) getMeasuredWidth()) / 2.0f;
            float measuredHeight = ((float) getMeasuredHeight()) - (((float) BubbleSeekBar.this.f22982am) / 3.0f);
            this.f23026c.moveTo(measuredWidth, measuredHeight);
            double measuredWidth2 = (double) (((float) getMeasuredWidth()) / 2.0f);
            double p2 = (double) BubbleSeekBar.this.f22982am;
            Double.isNaN(p2);
            Double.isNaN(measuredWidth2);
            float sqrt = (float) (measuredWidth2 - ((Math.sqrt(3.0d) / 2.0d) * p2));
            float p3 = ((float) BubbleSeekBar.this.f22982am) * 1.5f;
            this.f23026c.quadTo(sqrt - ((float) a.a(2)), p3 - ((float) a.a(2)), sqrt, p3);
            this.f23026c.arcTo(this.f23027d, 150.0f, 240.0f);
            double measuredWidth3 = (double) (((float) getMeasuredWidth()) / 2.0f);
            double p4 = (double) BubbleSeekBar.this.f22982am;
            Double.isNaN(p4);
            Double.isNaN(measuredWidth3);
            this.f23026c.quadTo(((float) (measuredWidth3 + ((Math.sqrt(3.0d) / 2.0d) * p4))) + ((float) a.a(2)), p3 - ((float) a.a(2)), measuredWidth, measuredHeight);
            this.f23026c.close();
            this.f23025b.setColor(BubbleSeekBar.this.I);
            canvas.drawPath(this.f23026c, this.f23025b);
            this.f23025b.setTextSize((float) BubbleSeekBar.this.J);
            this.f23025b.setColor(BubbleSeekBar.this.K);
            Paint paint = this.f23025b;
            String str = this.f23029f;
            paint.getTextBounds(str, 0, str.length(), this.f23028e);
            Paint.FontMetrics fontMetrics = this.f23025b.getFontMetrics();
            canvas.drawText(this.f23029f, ((float) getMeasuredWidth()) / 2.0f, (((float) BubbleSeekBar.this.f22982am) + ((fontMetrics.descent - fontMetrics.ascent) / 2.0f)) - fontMetrics.descent, this.f23025b);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(BubbleSeekBar.this.f22982am * 3, BubbleSeekBar.this.f22982am * 3);
            this.f23027d.set((((float) getMeasuredWidth()) / 2.0f) - ((float) BubbleSeekBar.this.f22982am), 0.0f, (((float) getMeasuredWidth()) / 2.0f) + ((float) BubbleSeekBar.this.f22982am), (float) (BubbleSeekBar.this.f22982am * 2));
        }
    }

    public interface b {
        SparseArray<String> a(int i2, SparseArray<String> sparseArray);
    }

    public interface c {
        void a(BubbleSeekBar bubbleSeekBar, int i2, float f2);

        void a(BubbleSeekBar bubbleSeekBar, int i2, float f2, boolean z2);

        void b(BubbleSeekBar bubbleSeekBar, int i2, float f2, boolean z2);
    }

    public BubbleSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public BubbleSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23008t = -1;
        this.T = new SparseArray<>();
        this.f22987ar = new int[2];
        this.f22988as = true;
        this.f22990b = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BubbleSeekBar, i2, 0);
        this.f22991c = obtainStyledAttributes.getFloat(11, 0.0f);
        this.f22992d = obtainStyledAttributes.getFloat(10, 100.0f);
        this.f22993e = obtainStyledAttributes.getFloat(12, this.f22991c);
        this.f22972ac = obtainStyledAttributes.getFloat(39, 10.0f);
        this.f22994f = obtainStyledAttributes.getBoolean(9, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(37, a.a(2));
        this.f22995g = dimensionPixelSize;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(15, dimensionPixelSize + a.a(2));
        this.f22996h = dimensionPixelSize2;
        this.f22997i = obtainStyledAttributes.getDimensionPixelSize(30, dimensionPixelSize2 + a.a(2));
        this.f22998j = obtainStyledAttributes.getDimensionPixelSize(31, this.f22996h * 2);
        this.f23002n = obtainStyledAttributes.getInteger(16, 10);
        this.f22999k = obtainStyledAttributes.getColor(36, androidx.core.content.b.c(context, com.cfly.uav_pro.R.color.colorPrimaryDarkGray));
        int color = obtainStyledAttributes.getColor(14, androidx.core.content.b.c(context, com.cfly.uav_pro.R.color.colorAccent));
        this.f23000l = color;
        this.f23001m = obtainStyledAttributes.getColor(28, color);
        this.f23005q = obtainStyledAttributes.getBoolean(26, false);
        this.f23006r = obtainStyledAttributes.getDimensionPixelSize(20, a.b(10));
        this.f23007s = obtainStyledAttributes.getColor(17, this.f22999k);
        this.A = obtainStyledAttributes.getBoolean(22, false);
        this.B = obtainStyledAttributes.getBoolean(21, false);
        int integer = obtainStyledAttributes.getInteger(19, -1);
        if (integer == 0) {
            this.f23008t = 0;
        } else if (integer == 1) {
            this.f23008t = 1;
        } else if (integer == 2) {
            this.f23008t = 2;
        } else {
            this.f23008t = -1;
        }
        this.f23009u = obtainStyledAttributes.getInteger(18, 1);
        this.f23010v = obtainStyledAttributes.getBoolean(27, false);
        this.f23011w = obtainStyledAttributes.getDimensionPixelSize(34, a.b(10));
        this.f23012x = obtainStyledAttributes.getColor(33, this.f23000l);
        this.I = obtainStyledAttributes.getColor(5, this.f23000l);
        this.J = obtainStyledAttributes.getDimensionPixelSize(7, a.b(10));
        this.K = obtainStyledAttributes.getColor(6, -1);
        this.f23003o = obtainStyledAttributes.getBoolean(25, false);
        this.f23004p = obtainStyledAttributes.getBoolean(4, false);
        this.f23013y = obtainStyledAttributes.getBoolean(24, false);
        int integer2 = obtainStyledAttributes.getInteger(3, -1);
        this.C = integer2 < 0 ? 200 : (long) integer2;
        this.f23014z = obtainStyledAttributes.getBoolean(35, false);
        this.D = obtainStyledAttributes.getBoolean(1, false);
        int integer3 = obtainStyledAttributes.getInteger(2, 0);
        this.E = integer3 < 0 ? 0 : (long) integer3;
        this.F = obtainStyledAttributes.getBoolean(8, false);
        this.G = obtainStyledAttributes.getBoolean(13, false);
        setEnabled(obtainStyledAttributes.getBoolean(0, isEnabled()));
        this.H = obtainStyledAttributes.getBoolean(23, false);
        this.f22971ab = obtainStyledAttributes.getDimensionPixelSize(32, a.a(14));
        this.W = obtainStyledAttributes.getDrawable(29);
        this.f22973ad = obtainStyledAttributes.getDrawable(38);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f22978ai = paint;
        paint.setAntiAlias(true);
        this.f22978ai.setStrokeCap(Paint.Cap.ROUND);
        this.f22978ai.setTextAlign(Paint.Align.CENTER);
        this.f22979aj = new Rect();
        this.R = a.a(2);
        a();
        if (!this.F) {
            this.f22980ak = (WindowManager) context.getSystemService("window");
            a aVar = new a(this, context);
            this.f22981al = aVar;
            aVar.a(this.f23013y ? String.valueOf(getProgressFloat()) : String.valueOf(getProgress()));
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f22986aq = layoutParams;
            layoutParams.gravity = 8388659;
            this.f22986aq.width = -2;
            this.f22986aq.height = -2;
            this.f22986aq.format = -3;
            this.f22986aq.flags = 524328;
            if (a.a() || Build.VERSION.SDK_INT >= 25) {
                this.f22986aq.type = 2;
            } else {
                this.f22986aq.type = CameraGlobal.GET_RECORD_STATUS;
            }
            b();
        }
    }

    private int a(Drawable drawable, int i2) {
        return Math.round(((((float) i2) * 1.0f) * ((float) drawable.getIntrinsicHeight())) / ((float) drawable.getIntrinsicWidth()));
    }

    private Bitmap a(Drawable drawable) {
        Object invoke;
        if (drawable == null) {
            return null;
        }
        if (!(drawable instanceof StateListDrawable)) {
            return b(drawable);
        }
        try {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            Class<?> cls = stateListDrawable.getClass();
            int intValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
            if (intValue == 2) {
                Method method = cls.getMethod("getStateSet", new Class[]{Integer.TYPE});
                Method method2 = cls.getMethod("getStateDrawable", new Class[]{Integer.TYPE});
                for (int i2 = 0; i2 < intValue; i2++) {
                    int[] iArr = (int[]) method.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)});
                    if (iArr.length <= 0) {
                        invoke = method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)});
                    } else if (iArr[0] == 16842919) {
                        invoke = method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)});
                    } else {
                        throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                    }
                    Drawable drawable2 = (Drawable) invoke;
                }
                return null;
            }
            throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
        } catch (Exception unused) {
            return b(drawable);
        }
    }

    private void a() {
        if (this.f22991c == this.f22992d) {
            this.f22991c = 0.0f;
            this.f22992d = 100.0f;
        }
        float f2 = this.f22991c;
        float f3 = this.f22992d;
        if (f2 > f3) {
            this.f22992d = f2;
            this.f22991c = f3;
        }
        float f4 = this.f22993e;
        float f5 = this.f22991c;
        if (f4 < f5) {
            this.f22993e = f5;
        }
        float f6 = this.f22993e;
        float f7 = this.f22992d;
        if (f6 > f7) {
            this.f22993e = f7;
        }
        int i2 = this.f22996h;
        int i3 = this.f22995g;
        if (i2 < i3) {
            this.f22996h = i3 + a.a(2);
        }
        int i4 = this.f22997i;
        int i5 = this.f22996h;
        if (i4 <= i5) {
            this.f22997i = i5 + a.a(2);
        }
        int i6 = this.f22998j;
        int i7 = this.f22996h;
        if (i6 <= i7) {
            this.f22998j = i7 * 2;
        }
        if (this.f23002n <= 0) {
            this.f23002n = 10;
        }
        float f8 = this.f22992d - this.f22991c;
        this.L = f8;
        float f9 = f8 / ((float) this.f23002n);
        this.M = f9;
        if (f9 < 1.0f) {
            this.f22994f = true;
        }
        if (this.f22994f) {
            this.f23013y = true;
        }
        int i8 = this.f23008t;
        if (i8 != -1) {
            this.f23005q = true;
        }
        if (this.f23005q) {
            if (i8 == -1) {
                this.f23008t = 0;
            }
            if (this.f23008t == 2) {
                this.f23003o = true;
            }
        }
        if (this.f23009u < 1) {
            this.f23009u = 1;
        }
        c();
        if (this.A) {
            this.B = false;
            this.f23004p = false;
        }
        if (this.f23004p && !this.f23003o) {
            this.f23004p = false;
        }
        if (this.B) {
            float f10 = this.f22991c;
            this.f22989at = f10;
            if (this.f22993e != f10) {
                this.f22989at = this.M;
            }
            this.f23003o = true;
            this.f23004p = true;
        }
        if (this.F) {
            this.D = false;
        }
        if (this.D) {
            setProgress(this.f22993e);
        }
        this.f23011w = (this.f22994f || this.B || (this.f23005q && this.f23008t == 2)) ? this.f23006r : this.f23011w;
    }

    private boolean a(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float f2 = (this.O / this.L) * (this.f22993e - this.f22991c);
        float f3 = this.G ? this.f22977ah - f2 : this.f22976ag + f2;
        float measuredHeight = ((float) getMeasuredHeight()) / 2.0f;
        return ((motionEvent.getX() - f3) * (motionEvent.getX() - f3)) + ((motionEvent.getY() - measuredHeight) * (motionEvent.getY() - measuredHeight)) <= (this.f22976ag + ((float) a.a(8))) * (this.f22976ag + ((float) a.a(8)));
    }

    private float b(float f2) {
        float f3 = this.f22976ag;
        if (f2 <= f3) {
            return f3;
        }
        float f4 = this.f22977ah;
        if (f2 >= f4) {
            return f4;
        }
        float f5 = 0.0f;
        int i2 = 0;
        while (i2 <= this.f23002n) {
            float f6 = this.P;
            f5 = (((float) i2) * f6) + this.f22976ag;
            if (f5 <= f2 && f2 - f5 <= f6) {
                break;
            }
            i2++;
        }
        float f7 = this.P;
        return f2 - f5 <= f7 / 2.0f ? f5 : (((float) (i2 + 1)) * f7) + this.f22976ag;
    }

    private Bitmap b(Drawable drawable) {
        int i2;
        if (drawable == null) {
            return null;
        }
        int a2 = a.a(30);
        if (drawable.getIntrinsicWidth() > a2) {
            int i3 = this.f22971ab;
            i2 = a(drawable, i3);
            if (i3 > a2) {
                i2 = a(drawable, a2);
            } else {
                a2 = i3;
            }
        } else {
            a2 = drawable.getIntrinsicWidth();
            i2 = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(a2, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (r6.G != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r6.G != false) goto L_0x001e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r6 = this;
            android.graphics.Paint r0 = r6.f22978ai
            int r1 = r6.J
            float r1 = (float) r1
            r0.setTextSize(r1)
            boolean r0 = r6.f23013y
            if (r0 == 0) goto L_0x0016
            boolean r0 = r6.G
            if (r0 == 0) goto L_0x002d
            goto L_0x001e
        L_0x0011:
            java.lang.String r0 = r6.c((float) r0)
            goto L_0x0033
        L_0x0016:
            boolean r0 = r6.G
            if (r0 == 0) goto L_0x0029
            boolean r0 = r6.f22994f
            if (r0 == 0) goto L_0x0021
        L_0x001e:
            float r0 = r6.f22992d
            goto L_0x0011
        L_0x0021:
            float r0 = r6.f22992d
        L_0x0023:
            int r0 = (int) r0
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x0033
        L_0x0029:
            boolean r0 = r6.f22994f
            if (r0 == 0) goto L_0x0030
        L_0x002d:
            float r0 = r6.f22991c
            goto L_0x0011
        L_0x0030:
            float r0 = r6.f22991c
            goto L_0x0023
        L_0x0033:
            android.graphics.Paint r1 = r6.f22978ai
            int r2 = r0.length()
            android.graphics.Rect r3 = r6.f22979aj
            r4 = 0
            r1.getTextBounds(r0, r4, r2, r3)
            android.graphics.Rect r0 = r6.f22979aj
            int r0 = r0.width()
            int r1 = r6.R
            int r1 = r1 * 2
            int r0 = r0 + r1
            int r0 = r0 >> 1
            boolean r1 = r6.f23013y
            if (r1 == 0) goto L_0x005a
            boolean r1 = r6.G
            if (r1 == 0) goto L_0x0071
            goto L_0x0062
        L_0x0055:
            java.lang.String r1 = r6.c((float) r1)
            goto L_0x0077
        L_0x005a:
            boolean r1 = r6.G
            if (r1 == 0) goto L_0x006d
            boolean r1 = r6.f22994f
            if (r1 == 0) goto L_0x0065
        L_0x0062:
            float r1 = r6.f22991c
            goto L_0x0055
        L_0x0065:
            float r1 = r6.f22991c
        L_0x0067:
            int r1 = (int) r1
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L_0x0077
        L_0x006d:
            boolean r1 = r6.f22994f
            if (r1 == 0) goto L_0x0074
        L_0x0071:
            float r1 = r6.f22992d
            goto L_0x0055
        L_0x0074:
            float r1 = r6.f22992d
            goto L_0x0067
        L_0x0077:
            android.graphics.Paint r2 = r6.f22978ai
            int r3 = r1.length()
            android.graphics.Rect r5 = r6.f22979aj
            r2.getTextBounds(r1, r4, r3, r5)
            android.graphics.Rect r1 = r6.f22979aj
            int r1 = r1.width()
            int r2 = r6.R
            int r2 = r2 * 2
            int r1 = r1 + r2
            int r1 = r1 >> 1
            r2 = 12
            int r2 = com.xeagle.android.editor.widget.bubbleSeekBar.a.a(r2)
            r6.f22982am = r2
            int r0 = java.lang.Math.max(r0, r1)
            int r0 = java.lang.Math.max(r2, r0)
            int r1 = r6.R
            int r0 = r0 + r1
            r6.f22982am = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar.b():void");
    }

    private boolean b(MotionEvent motionEvent) {
        return isEnabled() && motionEvent.getX() >= ((float) getPaddingLeft()) && motionEvent.getX() <= ((float) (getMeasuredWidth() - getPaddingRight())) && motionEvent.getY() >= ((float) getPaddingTop()) && motionEvent.getY() <= ((float) (getMeasuredHeight() - getPaddingBottom()));
    }

    private String c(float f2) {
        return String.valueOf(d(f2));
    }

    private void c() {
        String str;
        int i2 = 0;
        boolean z2 = true;
        boolean z3 = this.f23008t == 2;
        if (this.f23009u <= 1 || this.f23002n % 2 != 0) {
            z2 = false;
        }
        while (true) {
            int i3 = this.f23002n;
            if (i2 <= i3) {
                boolean z4 = this.G;
                float f2 = z4 ? this.f22992d - (this.M * ((float) i2)) : this.f22991c + (this.M * ((float) i2));
                if (z3) {
                    if (z2) {
                        if (i2 % this.f23009u != 0) {
                            i2++;
                        } else {
                            f2 = z4 ? this.f22992d - (this.M * ((float) i2)) : this.f22991c + (this.M * ((float) i2));
                        }
                    }
                } else if (!(i2 == 0 || i2 == i3)) {
                    i2++;
                }
                SparseArray<String> sparseArray = this.T;
                if (this.f22994f) {
                    str = c(f2);
                } else {
                    str = ((int) f2) + "";
                }
                sparseArray.put(i2, str);
                i2++;
            } else {
                return;
            }
        }
    }

    private float d(float f2) {
        return BigDecimal.valueOf((double) f2).setScale(1, 4).floatValue();
    }

    private void d() {
        float f2;
        float f3;
        Window window;
        getLocationOnScreen(this.f22987ar);
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof View)) {
            View view = (View) parent;
            if (view.getMeasuredWidth() > 0) {
                int[] iArr = this.f22987ar;
                iArr[0] = iArr[0] % view.getMeasuredWidth();
            }
        }
        if (this.G) {
            f3 = (float) this.f22987ar[0];
            f2 = this.f22977ah;
        } else {
            f3 = (float) this.f22987ar[0];
            f2 = this.f22976ag;
        }
        this.f22983an = (f3 + f2) - (((float) this.f22981al.getMeasuredWidth()) / 2.0f);
        this.f22985ap = h();
        float measuredHeight = (float) (this.f22987ar[1] - this.f22981al.getMeasuredHeight());
        this.f22984ao = measuredHeight;
        this.f22984ao = measuredHeight - ((float) a.a(24));
        Context context = getContext();
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && (window.getAttributes().flags & 1024) != 0) {
            Resources system = Resources.getSystem();
            this.f22984ao += (float) system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
        }
    }

    private float e(float f2) {
        return this.G ? this.f22977ah - (((f2 - this.f22991c) * this.O) / this.L) : (((f2 - this.f22991c) * this.O) / this.L) + this.f22976ag;
    }

    /* access modifiers changed from: private */
    public void e() {
        float f2 = 0.0f;
        int i2 = 0;
        float f3 = 0.0f;
        while (i2 <= this.f23002n) {
            float f4 = this.P;
            f3 = (((float) i2) * f4) + this.f22976ag;
            float f5 = this.N;
            if (f3 <= f5 && f5 - f3 <= f4) {
                break;
            }
            i2++;
        }
        boolean z2 = BigDecimal.valueOf((double) this.N).setScale(1, 4).floatValue() == f3;
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimator = null;
        if (!z2) {
            float f6 = this.N;
            float f7 = this.P;
            valueAnimator = f6 - f3 <= f7 / 2.0f ? ValueAnimator.ofFloat(new float[]{f6, f3}) : ValueAnimator.ofFloat(new float[]{f6, (((float) (i2 + 1)) * f7) + this.f22976ag});
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = BubbleSeekBar.this.N = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
                    float unused2 = bubbleSeekBar.f22993e = bubbleSeekBar.i();
                    if (!BubbleSeekBar.this.F) {
                        BubbleSeekBar bubbleSeekBar2 = BubbleSeekBar.this;
                        float unused3 = bubbleSeekBar2.f22985ap = bubbleSeekBar2.h();
                        BubbleSeekBar.this.f22986aq.x = (int) (BubbleSeekBar.this.f22985ap + 0.5f);
                        if (BubbleSeekBar.this.f22981al.getParent() != null) {
                            BubbleSeekBar.this.f22980ak.updateViewLayout(BubbleSeekBar.this.f22981al, BubbleSeekBar.this.f22986aq);
                        }
                        BubbleSeekBar.this.f22981al.a(BubbleSeekBar.this.f23013y ? String.valueOf(BubbleSeekBar.this.getProgressFloat()) : String.valueOf(BubbleSeekBar.this.getProgress()));
                    } else {
                        float unused4 = BubbleSeekBar.this.j();
                    }
                    BubbleSeekBar.this.invalidate();
                    if (BubbleSeekBar.this.f22975af != null) {
                        c n2 = BubbleSeekBar.this.f22975af;
                        BubbleSeekBar bubbleSeekBar3 = BubbleSeekBar.this;
                        n2.a(bubbleSeekBar3, bubbleSeekBar3.getProgress(), BubbleSeekBar.this.getProgressFloat(), true);
                    }
                }
            });
        }
        if (!this.F) {
            a aVar = this.f22981al;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            if (this.D) {
                f2 = 1.0f;
            }
            fArr[0] = f2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar, property, fArr);
            if (z2) {
                animatorSet.setDuration(this.C).play(ofFloat);
            } else {
                animatorSet.setDuration(this.C).playTogether(new Animator[]{valueAnimator, ofFloat});
            }
        } else if (!z2) {
            animatorSet.setDuration(this.C).playTogether(new Animator[]{valueAnimator});
        }
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                if (!BubbleSeekBar.this.F && !BubbleSeekBar.this.D) {
                    BubbleSeekBar.this.g();
                }
                BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
                float unused = bubbleSeekBar.f22993e = bubbleSeekBar.i();
                boolean unused2 = BubbleSeekBar.this.Q = false;
                boolean unused3 = BubbleSeekBar.this.f22988as = true;
                BubbleSeekBar.this.invalidate();
            }

            public void onAnimationEnd(Animator animator) {
                if (!BubbleSeekBar.this.F && !BubbleSeekBar.this.D) {
                    BubbleSeekBar.this.g();
                }
                BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
                float unused = bubbleSeekBar.f22993e = bubbleSeekBar.i();
                boolean unused2 = BubbleSeekBar.this.Q = false;
                boolean unused3 = BubbleSeekBar.this.f22988as = true;
                BubbleSeekBar.this.invalidate();
                if (BubbleSeekBar.this.f22975af != null) {
                    c n2 = BubbleSeekBar.this.f22975af;
                    BubbleSeekBar bubbleSeekBar2 = BubbleSeekBar.this;
                    n2.b(bubbleSeekBar2, bubbleSeekBar2.getProgress(), BubbleSeekBar.this.getProgressFloat(), true);
                }
            }
        });
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    public void f() {
        a aVar = this.f22981al;
        if (aVar != null && aVar.getParent() == null) {
            this.f22986aq.x = (int) (this.f22985ap + 0.5f);
            this.f22986aq.y = (int) (this.f22984ao + 0.5f);
            this.f22981al.setAlpha(0.0f);
            this.f22981al.setVisibility(0);
            this.f22981al.animate().alpha(1.0f).setDuration(this.f23014z ? 0 : this.C).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    BubbleSeekBar.this.f22980ak.addView(BubbleSeekBar.this.f22981al, BubbleSeekBar.this.f22986aq);
                }
            }).start();
            this.f22981al.a(this.f23013y ? String.valueOf(getProgressFloat()) : String.valueOf(getProgress()));
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        a aVar = this.f22981al;
        if (aVar != null) {
            aVar.setVisibility(8);
            if (this.f22981al.getParent() != null) {
                this.f22980ak.removeViewImmediate(this.f22981al);
            }
        }
    }

    /* access modifiers changed from: private */
    public float h() {
        return this.G ? this.f22983an - ((this.O * (this.f22993e - this.f22991c)) / this.L) : this.f22983an + ((this.O * (this.f22993e - this.f22991c)) / this.L);
    }

    /* access modifiers changed from: private */
    public float i() {
        float f2;
        float f3;
        if (this.G) {
            f2 = this.f22977ah;
            f3 = this.N;
        } else {
            f2 = this.N;
            f3 = this.f22976ag;
        }
        return (((f2 - f3) * this.L) / this.O) + this.f22991c;
    }

    /* access modifiers changed from: private */
    public float j() {
        float f2 = this.f22993e;
        if (!this.B || !this.V) {
            return f2;
        }
        float f3 = this.M / 2.0f;
        if (this.f23014z) {
            if (f2 == this.f22991c || f2 == this.f22992d) {
                return f2;
            }
            for (int i2 = 0; i2 <= this.f23002n; i2++) {
                float f4 = this.M;
                float f5 = ((float) i2) * f4;
                if (f5 < f2 && f5 + f4 >= f2) {
                    return f3 + f5 > f2 ? f5 : f5 + f4;
                }
            }
        }
        float f6 = this.f22989at;
        if (f2 >= f6) {
            if (f2 >= f3 + f6) {
                f6 += this.M;
            }
            return f6;
        } else if (f2 >= f6 - f3) {
            return f6;
        } else {
            f6 -= this.M;
        }
        this.f22989at = f6;
        return f6;
    }

    public void a(float f2) {
        this.f22972ac = f2;
        invalidate();
    }

    public float getMax() {
        return this.f22992d;
    }

    public float getMin() {
        return this.f22991c;
    }

    public c getOnProgressChangedListener() {
        return this.f22975af;
    }

    public int getProgress() {
        return Math.round(j());
    }

    public float getProgressFloat() {
        return d(j());
    }

    public float getWarnProgress() {
        return this.f22972ac;
    }

    public float getmProgress() {
        return this.f22993e;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        g();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x024b, code lost:
        if (r2 != r0.f22992d) goto L_0x0257;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r25) {
        /*
            r24 = this;
            r0 = r24
            r7 = r25
            super.onDraw(r25)
            int r1 = r24.getPaddingLeft()
            float r1 = (float) r1
            int r2 = r24.getMeasuredWidth()
            int r3 = r24.getPaddingRight()
            int r2 = r2 - r3
            float r2 = (float) r2
            int r3 = r24.getPaddingTop()
            int r4 = r0.f22998j
            int r3 = r3 + r4
            float r8 = (float) r3
            boolean r3 = r0.f23005q
            r4 = 10
            java.lang.String r5 = "0123456789"
            r6 = 1073741824(0x40000000, float:2.0)
            r9 = 1
            r10 = 0
            if (r3 == 0) goto L_0x00ff
            android.graphics.Paint r3 = r0.f22978ai
            int r11 = r0.f23007s
            r3.setColor(r11)
            android.graphics.Paint r3 = r0.f22978ai
            int r11 = r0.f23006r
            float r11 = (float) r11
            r3.setTextSize(r11)
            android.graphics.Paint r3 = r0.f22978ai
            android.graphics.Rect r11 = r0.f22979aj
            r3.getTextBounds(r5, r10, r4, r11)
            int r3 = r0.f23008t
            if (r3 != 0) goto L_0x00ac
            android.graphics.Rect r3 = r0.f22979aj
            int r3 = r3.height()
            float r3 = (float) r3
            float r3 = r3 / r6
            float r3 = r3 + r8
            android.util.SparseArray<java.lang.String> r11 = r0.T
            java.lang.Object r11 = r11.get(r10)
            java.lang.String r11 = (java.lang.String) r11
            android.graphics.Paint r12 = r0.f22978ai
            int r13 = r11.length()
            android.graphics.Rect r14 = r0.f22979aj
            r12.getTextBounds(r11, r10, r13, r14)
            android.graphics.Rect r12 = r0.f22979aj
            int r12 = r12.width()
            float r12 = (float) r12
            float r12 = r12 / r6
            float r12 = r12 + r1
            android.graphics.Paint r13 = r0.f22978ai
            r7.drawText(r11, r12, r3, r13)
            android.graphics.Rect r11 = r0.f22979aj
            int r11 = r11.width()
            int r12 = r0.R
            int r11 = r11 + r12
            float r11 = (float) r11
            float r1 = r1 + r11
            android.util.SparseArray<java.lang.String> r11 = r0.T
            int r12 = r0.f23002n
            java.lang.Object r11 = r11.get(r12)
            java.lang.String r11 = (java.lang.String) r11
            android.graphics.Paint r12 = r0.f22978ai
            int r13 = r11.length()
            android.graphics.Rect r14 = r0.f22979aj
            r12.getTextBounds(r11, r10, r13, r14)
            android.graphics.Rect r12 = r0.f22979aj
            int r12 = r12.width()
            float r12 = (float) r12
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            float r12 = r12 / r6
            float r12 = r2 - r12
            android.graphics.Paint r13 = r0.f22978ai
            r7.drawText(r11, r12, r3, r13)
            android.graphics.Rect r3 = r0.f22979aj
            int r3 = r3.width()
            int r11 = r0.R
            int r3 = r3 + r11
            float r3 = (float) r3
            float r2 = r2 - r3
            goto L_0x010c
        L_0x00ac:
            if (r3 < r9) goto L_0x010c
            int r1 = r0.f22998j
            float r1 = (float) r1
            float r1 = r1 + r8
            int r2 = r0.R
            float r2 = (float) r2
            float r1 = r1 + r2
            android.util.SparseArray<java.lang.String> r2 = r0.T
            java.lang.Object r2 = r2.get(r10)
            java.lang.String r2 = (java.lang.String) r2
            android.graphics.Paint r3 = r0.f22978ai
            int r11 = r2.length()
            android.graphics.Rect r12 = r0.f22979aj
            r3.getTextBounds(r2, r10, r11, r12)
            android.graphics.Rect r3 = r0.f22979aj
            int r3 = r3.height()
            float r3 = (float) r3
            float r1 = r1 + r3
            float r3 = r0.f22976ag
            int r11 = r0.f23008t
            if (r11 != r9) goto L_0x00dc
            android.graphics.Paint r11 = r0.f22978ai
            r7.drawText(r2, r3, r1, r11)
        L_0x00dc:
            android.util.SparseArray<java.lang.String> r2 = r0.T
            int r11 = r0.f23002n
            java.lang.Object r2 = r2.get(r11)
            java.lang.String r2 = (java.lang.String) r2
            android.graphics.Paint r11 = r0.f22978ai
            int r12 = r2.length()
            android.graphics.Rect r13 = r0.f22979aj
            r11.getTextBounds(r2, r10, r12, r13)
            float r11 = r0.f22977ah
            int r12 = r0.f23008t
            if (r12 != r9) goto L_0x00fc
            android.graphics.Paint r12 = r0.f22978ai
            r7.drawText(r2, r11, r1, r12)
        L_0x00fc:
            r1 = r3
            r2 = r11
            goto L_0x010c
        L_0x00ff:
            boolean r3 = r0.f23010v
            if (r3 == 0) goto L_0x010c
            int r3 = r0.f23008t
            r11 = -1
            if (r3 != r11) goto L_0x010c
            float r1 = r0.f22976ag
            float r2 = r0.f22977ah
        L_0x010c:
            boolean r3 = r0.f23005q
            if (r3 != 0) goto L_0x0114
            boolean r11 = r0.f23010v
            if (r11 == 0) goto L_0x0118
        L_0x0114:
            int r11 = r0.f23008t
            if (r11 != 0) goto L_0x011e
        L_0x0118:
            int r11 = r0.f22998j
            float r12 = (float) r11
            float r1 = r1 + r12
            float r11 = (float) r11
            float r2 = r2 - r11
        L_0x011e:
            r11 = r1
            r12 = r2
            r1 = 2
            if (r3 == 0) goto L_0x0129
            int r2 = r0.f23008t
            if (r2 != r1) goto L_0x0129
            r2 = 1
            goto L_0x012a
        L_0x0129:
            r2 = 0
        L_0x012a:
            r13 = 0
            if (r2 != 0) goto L_0x0131
            boolean r3 = r0.f23003o
            if (r3 == 0) goto L_0x01d6
        L_0x0131:
            android.graphics.Paint r3 = r0.f22978ai
            int r14 = r0.f23006r
            float r14 = (float) r14
            r3.setTextSize(r14)
            android.graphics.Paint r3 = r0.f22978ai
            android.graphics.Rect r14 = r0.f22979aj
            r3.getTextBounds(r5, r10, r4, r14)
            android.graphics.Rect r3 = r0.f22979aj
            int r3 = r3.height()
            float r3 = (float) r3
            float r3 = r3 + r8
            int r14 = r0.f22998j
            float r15 = (float) r14
            float r3 = r3 + r15
            int r15 = r0.R
            float r15 = (float) r15
            float r3 = r3 + r15
            int r15 = com.xeagle.android.editor.widget.bubbleSeekBar.a.a(r1)
            int r14 = r14 - r15
            float r14 = (float) r14
            float r14 = r14 / r6
            boolean r6 = r0.G
            if (r6 == 0) goto L_0x016f
            float r6 = r0.f22977ah
            float r15 = r0.O
            float r1 = r0.L
            float r15 = r15 / r1
            float r1 = r0.f22993e
            float r9 = r0.f22991c
            float r1 = r1 - r9
            float r1 = java.lang.Math.abs(r1)
            float r15 = r15 * r1
            float r6 = r6 - r15
            goto L_0x0182
        L_0x016f:
            float r1 = r0.f22976ag
            float r6 = r0.O
            float r9 = r0.L
            float r6 = r6 / r9
            float r9 = r0.f22993e
            float r15 = r0.f22991c
            float r9 = r9 - r15
            float r9 = java.lang.Math.abs(r9)
            float r6 = r6 * r9
            float r6 = r6 + r1
        L_0x0182:
            r1 = 0
        L_0x0183:
            int r9 = r0.f23002n
            if (r1 > r9) goto L_0x01d6
            float r9 = (float) r1
            float r15 = r0.P
            float r9 = r9 * r15
            float r9 = r9 + r11
            boolean r15 = r0.G
            if (r15 == 0) goto L_0x01a0
            android.graphics.Paint r15 = r0.f22978ai
            int r16 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r16 > 0) goto L_0x019a
            int r4 = r0.f22999k
            goto L_0x019c
        L_0x019a:
            int r4 = r0.f23000l
        L_0x019c:
            r15.setColor(r4)
            goto L_0x01ae
        L_0x01a0:
            android.graphics.Paint r4 = r0.f22978ai
            int r15 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r15 > 0) goto L_0x01a9
            int r15 = r0.f23000l
            goto L_0x01ab
        L_0x01a9:
            int r15 = r0.f22999k
        L_0x01ab:
            r4.setColor(r15)
        L_0x01ae:
            android.graphics.Paint r4 = r0.f22978ai
            r7.drawCircle(r9, r8, r14, r4)
            if (r2 == 0) goto L_0x01d1
            android.graphics.Paint r4 = r0.f22978ai
            int r15 = r0.f23007s
            r4.setColor(r15)
            android.util.SparseArray<java.lang.String> r4 = r0.T
            java.lang.Object r4 = r4.get(r1, r13)
            if (r4 == 0) goto L_0x01d1
            android.util.SparseArray<java.lang.String> r4 = r0.T
            java.lang.Object r4 = r4.get(r1)
            java.lang.String r4 = (java.lang.String) r4
            android.graphics.Paint r15 = r0.f22978ai
            r7.drawText(r4, r9, r3, r15)
        L_0x01d1:
            int r1 = r1 + 1
            r4 = 10
            goto L_0x0183
        L_0x01d6:
            boolean r1 = r0.Q
            if (r1 == 0) goto L_0x01de
            boolean r2 = r0.D
            if (r2 == 0) goto L_0x0200
        L_0x01de:
            boolean r2 = r0.G
            if (r2 == 0) goto L_0x01f1
            float r2 = r0.O
            float r3 = r0.L
            float r2 = r2 / r3
            float r3 = r0.f22993e
            float r4 = r0.f22991c
            float r3 = r3 - r4
            float r2 = r2 * r3
            float r2 = r12 - r2
            goto L_0x01fe
        L_0x01f1:
            float r2 = r0.O
            float r3 = r0.L
            float r2 = r2 / r3
            float r3 = r0.f22993e
            float r4 = r0.f22991c
            float r3 = r3 - r4
            float r2 = r2 * r3
            float r2 = r2 + r11
        L_0x01fe:
            r0.N = r2
        L_0x0200:
            boolean r2 = r0.f23010v
            if (r2 == 0) goto L_0x0266
            if (r1 != 0) goto L_0x0266
            boolean r1 = r0.f22988as
            if (r1 == 0) goto L_0x0266
            android.graphics.Paint r1 = r0.f22978ai
            int r2 = r0.f23012x
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.f22978ai
            int r2 = r0.f23011w
            float r2 = (float) r2
            r1.setTextSize(r2)
            android.graphics.Paint r1 = r0.f22978ai
            android.graphics.Rect r2 = r0.f22979aj
            r3 = 10
            r1.getTextBounds(r5, r10, r3, r2)
            android.graphics.Rect r1 = r0.f22979aj
            int r1 = r1.height()
            float r1 = (float) r1
            float r1 = r1 + r8
            int r2 = r0.f22998j
            float r2 = (float) r2
            float r1 = r1 + r2
            int r2 = r0.R
            float r2 = (float) r2
            float r1 = r1 + r2
            boolean r2 = r0.f22994f
            if (r2 != 0) goto L_0x0257
            boolean r2 = r0.f23013y
            if (r2 == 0) goto L_0x024e
            int r2 = r0.f23008t
            r3 = 1
            if (r2 != r3) goto L_0x024e
            float r2 = r0.f22993e
            float r3 = r0.f22991c
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x024e
            float r3 = r0.f22992d
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x024e
            goto L_0x0257
        L_0x024e:
            int r2 = r24.getProgress()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            goto L_0x025f
        L_0x0257:
            float r2 = r24.getProgressFloat()
            java.lang.String r2 = java.lang.String.valueOf(r2)
        L_0x025f:
            float r3 = r0.N
            android.graphics.Paint r4 = r0.f22978ai
            r7.drawText(r2, r3, r1, r4)
        L_0x0266:
            android.graphics.Paint r1 = r0.f22978ai
            int r2 = r0.f23000l
            r1.setColor(r2)
            boolean r1 = r0.H
            if (r1 == 0) goto L_0x02c2
            android.graphics.LinearGradient r1 = new android.graphics.LinearGradient
            r17 = 0
            r18 = 0
            int r2 = r24.getMeasuredWidth()
            float r2 = (float) r2
            r20 = 0
            r3 = 4
            int[] r4 = new int[r3]
            r5 = -65536(0xffffffffffff0000, float:NaN)
            r4[r10] = r5
            android.content.Context r5 = r0.f22990b
            r6 = 2131099957(0x7f060135, float:1.7812282E38)
            int r5 = androidx.core.content.b.c(r5, r6)
            r6 = 1
            r4[r6] = r5
            android.content.Context r5 = r0.f22990b
            r6 = 2131099742(0x7f06005e, float:1.7811846E38)
            int r5 = androidx.core.content.b.c(r5, r6)
            r6 = 2
            r4[r6] = r5
            r5 = 3
            r6 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            r4[r5] = r6
            float[] r3 = new float[r3]
            r3 = {0, 1036831949, 1053609165, 1065353216} // fill-array
            android.graphics.Shader$TileMode r23 = android.graphics.Shader.TileMode.CLAMP
            r16 = r1
            r19 = r2
            r21 = r4
            r22 = r3
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            android.graphics.Paint r2 = r0.f22978ai
            r2.setShader(r1)
            android.graphics.Paint r1 = r0.f22978ai
            int r2 = r0.f22996h
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
        L_0x02c2:
            boolean r1 = r0.G
            float r4 = r0.N
            android.graphics.Paint r6 = r0.f22978ai
            if (r1 == 0) goto L_0x02ce
            r1 = r25
            r2 = r12
            goto L_0x02d1
        L_0x02ce:
            r1 = r25
            r2 = r11
        L_0x02d1:
            r3 = r8
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            boolean r1 = r0.H
            if (r1 == 0) goto L_0x02df
            android.graphics.Paint r1 = r0.f22978ai
            r1.setShader(r13)
        L_0x02df:
            android.graphics.Paint r1 = r0.f22978ai
            int r2 = r0.f22999k
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.f22978ai
            int r2 = r0.f22995g
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            boolean r1 = r0.G
            float r2 = r0.N
            android.graphics.Paint r6 = r0.f22978ai
            if (r1 == 0) goto L_0x02fb
            r1 = r25
            r3 = r8
            r4 = r11
            goto L_0x02ff
        L_0x02fb:
            r1 = r25
            r3 = r8
            r4 = r12
        L_0x02ff:
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            android.graphics.Paint r1 = r0.f22978ai
            int r2 = r0.f23001m
            r1.setColor(r2)
            android.graphics.drawable.Drawable r1 = r0.W
            android.graphics.Bitmap r1 = r0.a((android.graphics.drawable.Drawable) r1)
            r0.f22970aa = r1
            r2 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r1 != 0) goto L_0x0328
            float r1 = r0.N
            boolean r4 = r0.Q
            if (r4 == 0) goto L_0x031f
            int r4 = r0.f22998j
            goto L_0x0321
        L_0x031f:
            int r4 = r0.f22997i
        L_0x0321:
            float r4 = (float) r4
            android.graphics.Paint r5 = r0.f22978ai
            r7.drawCircle(r1, r8, r4, r5)
            goto L_0x034f
        L_0x0328:
            float r4 = r0.N
            double r4 = (double) r4
            int r6 = r1.getWidth()
            double r9 = (double) r6
            java.lang.Double.isNaN(r9)
            double r9 = r9 / r2
            java.lang.Double.isNaN(r4)
            double r4 = r4 - r9
            float r4 = (float) r4
            double r5 = (double) r8
            android.graphics.Bitmap r9 = r0.f22970aa
            int r9 = r9.getHeight()
            double r9 = (double) r9
            java.lang.Double.isNaN(r9)
            double r9 = r9 / r2
            java.lang.Double.isNaN(r5)
            double r5 = r5 - r9
            float r5 = (float) r5
            android.graphics.Paint r6 = r0.f22978ai
            r7.drawBitmap(r1, r4, r5, r6)
        L_0x034f:
            android.graphics.drawable.Drawable r1 = r0.f22973ad
            android.graphics.Bitmap r1 = r0.a((android.graphics.drawable.Drawable) r1)
            r0.f22974ae = r1
            if (r1 == 0) goto L_0x0386
            float r1 = r0.f22972ac
            float r1 = r0.e((float) r1)
            android.graphics.Bitmap r4 = r0.f22974ae
            double r5 = (double) r1
            int r1 = r4.getWidth()
            double r9 = (double) r1
            java.lang.Double.isNaN(r9)
            double r9 = r9 / r2
            java.lang.Double.isNaN(r5)
            double r5 = r5 - r9
            float r1 = (float) r5
            double r5 = (double) r8
            android.graphics.Bitmap r8 = r0.f22974ae
            int r8 = r8.getHeight()
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r8 = r8 / r2
            java.lang.Double.isNaN(r5)
            double r5 = r5 - r8
            float r2 = (float) r5
            android.graphics.Paint r3 = r0.f22978ai
            r7.drawBitmap(r4, r1, r2, r3)
        L_0x0386:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (!this.F) {
            d();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00cf, code lost:
        if (r0 >= 1) goto L_0x00e3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            super.onMeasure(r7, r8)
            int r0 = r6.f22998j
            int r0 = r0 * 2
            boolean r1 = r6.f23010v
            java.lang.String r2 = "j"
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0025
            android.graphics.Paint r1 = r6.f22978ai
            int r5 = r6.f23011w
            float r5 = (float) r5
            r1.setTextSize(r5)
            android.graphics.Paint r1 = r6.f22978ai
            android.graphics.Rect r5 = r6.f22979aj
            r1.getTextBounds(r2, r4, r3, r5)
            android.graphics.Rect r1 = r6.f22979aj
            int r1 = r1.height()
            int r0 = r0 + r1
        L_0x0025:
            boolean r1 = r6.f23005q
            if (r1 == 0) goto L_0x004b
            int r1 = r6.f23008t
            if (r1 < r3) goto L_0x004b
            android.graphics.Paint r1 = r6.f22978ai
            int r5 = r6.f23006r
            float r5 = (float) r5
            r1.setTextSize(r5)
            android.graphics.Paint r1 = r6.f22978ai
            android.graphics.Rect r5 = r6.f22979aj
            r1.getTextBounds(r2, r4, r3, r5)
            int r1 = r6.f22998j
            int r1 = r1 * 2
            android.graphics.Rect r2 = r6.f22979aj
            int r2 = r2.height()
            int r1 = r1 + r2
            int r0 = java.lang.Math.max(r0, r1)
        L_0x004b:
            int r1 = r6.R
            int r1 = r1 * 2
            int r0 = r0 + r1
            r1 = 180(0xb4, float:2.52E-43)
            int r1 = com.xeagle.android.editor.widget.bubbleSeekBar.a.a(r1)
            int r1 = resolveSize(r1, r7)
            r6.setMeasuredDimension(r1, r0)
            int r0 = r6.getPaddingLeft()
            int r1 = r6.f22998j
            int r0 = r0 + r1
            float r0 = (float) r0
            r6.f22976ag = r0
            int r0 = r6.getMeasuredWidth()
            int r1 = r6.getPaddingRight()
            int r0 = r0 - r1
            int r1 = r6.f22998j
            int r0 = r0 - r1
            float r0 = (float) r0
            r6.f22977ah = r0
            boolean r0 = r6.f23005q
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 == 0) goto L_0x00d2
            android.graphics.Paint r0 = r6.f22978ai
            int r2 = r6.f23006r
            float r2 = (float) r2
            r0.setTextSize(r2)
            int r0 = r6.f23008t
            if (r0 != 0) goto L_0x00cf
            android.util.SparseArray<java.lang.String> r0 = r6.T
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r0 = (java.lang.String) r0
            android.graphics.Paint r1 = r6.f22978ai
            int r2 = r0.length()
            android.graphics.Rect r3 = r6.f22979aj
            r1.getTextBounds(r0, r4, r2, r3)
            float r0 = r6.f22976ag
            android.graphics.Rect r1 = r6.f22979aj
            int r1 = r1.width()
            int r2 = r6.R
            int r1 = r1 + r2
            float r1 = (float) r1
            float r0 = r0 + r1
            r6.f22976ag = r0
            android.util.SparseArray<java.lang.String> r0 = r6.T
            int r1 = r6.f23002n
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            android.graphics.Paint r1 = r6.f22978ai
            int r2 = r0.length()
            android.graphics.Rect r3 = r6.f22979aj
            r1.getTextBounds(r0, r4, r2, r3)
            float r0 = r6.f22977ah
            android.graphics.Rect r1 = r6.f22979aj
            int r1 = r1.width()
            int r2 = r6.R
            int r1 = r1 + r2
            float r1 = (float) r1
            float r0 = r0 - r1
            r6.f22977ah = r0
            goto L_0x0146
        L_0x00cf:
            if (r0 < r3) goto L_0x0146
            goto L_0x00e3
        L_0x00d2:
            boolean r0 = r6.f23010v
            if (r0 == 0) goto L_0x0146
            int r0 = r6.f23008t
            r2 = -1
            if (r0 != r2) goto L_0x0146
            android.graphics.Paint r0 = r6.f22978ai
            int r2 = r6.f23011w
            float r2 = (float) r2
            r0.setTextSize(r2)
        L_0x00e3:
            android.util.SparseArray<java.lang.String> r0 = r6.T
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r0 = (java.lang.String) r0
            android.graphics.Paint r2 = r6.f22978ai
            int r3 = r0.length()
            android.graphics.Rect r5 = r6.f22979aj
            r2.getTextBounds(r0, r4, r3, r5)
            int r0 = r6.f22998j
            float r0 = (float) r0
            android.graphics.Rect r2 = r6.f22979aj
            int r2 = r2.width()
            float r2 = (float) r2
            float r2 = r2 / r1
            float r0 = java.lang.Math.max(r0, r2)
            int r2 = r6.getPaddingLeft()
            float r2 = (float) r2
            float r2 = r2 + r0
            int r0 = r6.R
            float r0 = (float) r0
            float r2 = r2 + r0
            r6.f22976ag = r2
            android.util.SparseArray<java.lang.String> r0 = r6.T
            int r2 = r6.f23002n
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            android.graphics.Paint r2 = r6.f22978ai
            int r3 = r0.length()
            android.graphics.Rect r5 = r6.f22979aj
            r2.getTextBounds(r0, r4, r3, r5)
            int r0 = r6.f22998j
            float r0 = (float) r0
            android.graphics.Rect r2 = r6.f22979aj
            int r2 = r2.width()
            float r2 = (float) r2
            float r2 = r2 / r1
            float r0 = java.lang.Math.max(r0, r2)
            int r1 = r6.getMeasuredWidth()
            int r2 = r6.getPaddingRight()
            int r1 = r1 - r2
            float r1 = (float) r1
            float r1 = r1 - r0
            int r0 = r6.R
            float r0 = (float) r0
            float r1 = r1 - r0
            r6.f22977ah = r1
        L_0x0146:
            float r0 = r6.f22977ah
            float r1 = r6.f22976ag
            float r0 = r0 - r1
            r6.O = r0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            int r1 = r6.f23002n
            float r1 = (float) r1
            float r0 = r0 / r1
            r6.P = r0
            boolean r0 = r6.F
            if (r0 != 0) goto L_0x0160
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$a r0 = r6.f22981al
            r0.measure(r7, r8)
        L_0x0160:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f22993e = bundle.getFloat("progress");
            super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
            a aVar = this.f22981al;
            if (aVar != null) {
                aVar.a(this.f23013y ? String.valueOf(getProgressFloat()) : String.valueOf(getProgress()));
            }
            setProgress(this.f22993e);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.f22993e);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        post(new Runnable() {
            public void run() {
                BubbleSeekBar.this.requestLayout();
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (r0 != 3) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0146, code lost:
        if (r5.F == false) goto L_0x0148;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x011e
            if (r0 == r2) goto L_0x00a8
            r3 = 2
            if (r0 == r3) goto L_0x0012
            r3 = 3
            if (r0 == r3) goto L_0x00a8
            goto L_0x01b1
        L_0x0012:
            boolean r0 = r5.Q
            if (r0 == 0) goto L_0x01b1
            boolean r0 = r5.A
            if (r0 == 0) goto L_0x002f
            float r0 = r6.getX()
            float r0 = r5.b((float) r0)
            float r3 = r5.U
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x002d
            r5.U = r0
            r5.N = r0
            goto L_0x004a
        L_0x002d:
            r0 = 0
            goto L_0x004b
        L_0x002f:
            float r0 = r6.getX()
            float r3 = r5.f22969a
            float r0 = r0 + r3
            r5.N = r0
            float r3 = r5.f22976ag
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0040
            r5.N = r3
        L_0x0040:
            float r0 = r5.N
            float r3 = r5.f22977ah
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x004a
            r5.N = r3
        L_0x004a:
            r0 = 1
        L_0x004b:
            if (r0 == 0) goto L_0x01b1
            float r0 = r5.i()
            r5.f22993e = r0
            boolean r0 = r5.F
            if (r0 != 0) goto L_0x0091
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$a r0 = r5.f22981al
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0091
            float r0 = r5.h()
            r5.f22985ap = r0
            android.view.WindowManager$LayoutParams r3 = r5.f22986aq
            r4 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r4
            int r0 = (int) r0
            r3.x = r0
            android.view.WindowManager r0 = r5.f22980ak
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$a r3 = r5.f22981al
            android.view.WindowManager$LayoutParams r4 = r5.f22986aq
            r0.updateViewLayout(r3, r4)
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$a r0 = r5.f22981al
            boolean r3 = r5.f23013y
            if (r3 == 0) goto L_0x0085
            float r3 = r5.getProgressFloat()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            goto L_0x008d
        L_0x0085:
            int r3 = r5.getProgress()
            java.lang.String r3 = java.lang.String.valueOf(r3)
        L_0x008d:
            r0.a(r3)
            goto L_0x0094
        L_0x0091:
            r5.j()
        L_0x0094:
            r5.invalidate()
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$c r0 = r5.f22975af
            if (r0 == 0) goto L_0x01b1
            int r3 = r5.getProgress()
            float r4 = r5.getProgressFloat()
            r0.a(r5, r3, r4, r2)
            goto L_0x01b1
        L_0x00a8:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
            boolean r0 = r5.f23004p
            if (r0 == 0) goto L_0x00c6
            boolean r0 = r5.f23014z
            if (r0 == 0) goto L_0x00c2
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$2 r0 = new com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$2
            r0.<init>()
        L_0x00bc:
            long r3 = r5.C
            r5.postDelayed(r0, r3)
            goto L_0x0100
        L_0x00c2:
            r5.e()
            goto L_0x0100
        L_0x00c6:
            boolean r0 = r5.Q
            if (r0 != 0) goto L_0x00ce
            boolean r0 = r5.f23014z
            if (r0 == 0) goto L_0x0100
        L_0x00ce:
            boolean r0 = r5.F
            if (r0 == 0) goto L_0x00fa
            android.view.ViewPropertyAnimator r0 = r5.animate()
            long r3 = r5.C
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r3)
            boolean r3 = r5.Q
            if (r3 != 0) goto L_0x00e7
            boolean r3 = r5.f23014z
            if (r3 == 0) goto L_0x00e7
            r3 = 300(0x12c, double:1.48E-321)
            goto L_0x00e9
        L_0x00e7:
            r3 = 0
        L_0x00e9:
            android.view.ViewPropertyAnimator r0 = r0.setStartDelay(r3)
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$3 r3 = new com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$3
            r3.<init>()
            android.view.ViewPropertyAnimator r0 = r0.setListener(r3)
            r0.start()
            goto L_0x0100
        L_0x00fa:
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$4 r0 = new com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$4
            r0.<init>()
            goto L_0x00bc
        L_0x0100:
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$c r0 = r5.f22975af
            if (r0 == 0) goto L_0x01b1
            int r3 = r5.getProgress()
            float r4 = r5.getProgressFloat()
            r0.a(r5, r3, r4, r2)
            com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar$c r0 = r5.f22975af
            int r3 = r5.getProgress()
            float r4 = r5.getProgressFloat()
            r0.a(r5, r3, r4)
            goto L_0x01b1
        L_0x011e:
            r5.performClick()
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            boolean r0 = r5.a((android.view.MotionEvent) r6)
            r5.Q = r0
            if (r0 == 0) goto L_0x014f
            boolean r0 = r5.B
            if (r0 == 0) goto L_0x013a
            boolean r0 = r5.V
            if (r0 != 0) goto L_0x013a
            r5.V = r2
        L_0x013a:
            boolean r0 = r5.D
            if (r0 == 0) goto L_0x0144
            boolean r0 = r5.S
            if (r0 != 0) goto L_0x0144
            r5.S = r2
        L_0x0144:
            boolean r0 = r5.F
            if (r0 != 0) goto L_0x014b
        L_0x0148:
            r5.f()
        L_0x014b:
            r5.invalidate()
            goto L_0x01a8
        L_0x014f:
            boolean r0 = r5.f23014z
            if (r0 == 0) goto L_0x01a8
            boolean r0 = r5.b((android.view.MotionEvent) r6)
            if (r0 == 0) goto L_0x01a8
            r5.Q = r2
            boolean r0 = r5.B
            if (r0 == 0) goto L_0x0165
            boolean r0 = r5.V
            if (r0 != 0) goto L_0x0165
            r5.V = r2
        L_0x0165:
            boolean r0 = r5.D
            if (r0 == 0) goto L_0x016e
            r5.g()
            r5.S = r2
        L_0x016e:
            boolean r0 = r5.A
            if (r0 == 0) goto L_0x017f
            float r0 = r6.getX()
            float r0 = r5.b((float) r0)
            r5.U = r0
            r5.N = r0
            goto L_0x0197
        L_0x017f:
            float r0 = r6.getX()
            r5.N = r0
            float r3 = r5.f22976ag
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x018d
            r5.N = r3
        L_0x018d:
            float r0 = r5.N
            float r3 = r5.f22977ah
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0197
            r5.N = r3
        L_0x0197:
            float r0 = r5.i()
            r5.f22993e = r0
            boolean r0 = r5.F
            if (r0 != 0) goto L_0x014b
            float r0 = r5.h()
            r5.f22985ap = r0
            goto L_0x0148
        L_0x01a8:
            float r0 = r5.N
            float r3 = r6.getX()
            float r0 = r0 - r3
            r5.f22969a = r0
        L_0x01b1:
            boolean r0 = r5.Q
            if (r0 != 0) goto L_0x01bf
            boolean r0 = r5.f23014z
            if (r0 != 0) goto L_0x01bf
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x01c0
        L_0x01bf:
            r1 = 1
        L_0x01c0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.editor.widget.bubbleSeekBar.BubbleSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        if (!this.F && this.D) {
            if (i2 != 0) {
                g();
            } else if (this.S) {
                f();
            }
            super.onVisibilityChanged(view, i2);
        }
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void setBubbleColor(int i2) {
        if (this.I != i2) {
            this.I = i2;
            a aVar = this.f22981al;
            if (aVar != null) {
                aVar.invalidate();
            }
        }
    }

    public void setCustomSectionTextArray(b bVar) {
        this.T = bVar.a(this.f23002n, this.T);
        for (int i2 = 0; i2 <= this.f23002n; i2++) {
            if (this.T.get(i2) == null) {
                this.T.put(i2, "");
            }
        }
        this.f23010v = false;
        requestLayout();
        invalidate();
    }

    public void setMax(float f2) {
        this.f22992d = f2;
        a();
        invalidate();
    }

    public void setMin(float f2) {
        this.f22991c = f2;
        a();
        invalidate();
    }

    public void setOnProgressChangedListener(c cVar) {
        this.f22975af = cVar;
    }

    public void setProgress(float f2) {
        this.f22993e = f2;
        c cVar = this.f22975af;
        if (cVar != null) {
            cVar.a(this, getProgress(), getProgressFloat(), false);
            this.f22975af.b(this, getProgress(), getProgressFloat(), false);
        }
        if (!this.F) {
            this.f22985ap = h();
        }
        if (this.D) {
            g();
            postDelayed(new Runnable() {
                public void run() {
                    BubbleSeekBar.this.f();
                    boolean unused = BubbleSeekBar.this.S = true;
                }
            }, this.E);
        }
        if (this.B) {
            this.V = false;
        }
        postInvalidate();
    }

    public void setSecondTrackColor(int i2) {
        if (this.f23000l != i2) {
            this.f23000l = i2;
            invalidate();
        }
    }

    public void setThumbColor(int i2) {
        if (this.f23001m != i2) {
            this.f23001m = i2;
            invalidate();
        }
    }

    public void setTrackColor(int i2) {
        if (this.f22999k != i2) {
            this.f22999k = i2;
            invalidate();
        }
    }
}
