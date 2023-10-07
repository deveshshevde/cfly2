package com.xeagle.android.newUI.widgets;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Checkable;
import com.blankj.utilcode.constant.MemoryConstants;
import com.xeagle.R;

public class NiceSwitchButton extends View implements Checkable {

    /* renamed from: a  reason: collision with root package name */
    private static final int f24068a = b(58.0f);

    /* renamed from: b  reason: collision with root package name */
    private static final int f24069b = b(36.0f);
    private int A;
    /* access modifiers changed from: private */
    public int B;
    private int C;
    private float D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K;
    private int L;
    /* access modifiers changed from: private */
    public float M;
    /* access modifiers changed from: private */
    public float N;
    private Paint O;
    private Paint P;
    /* access modifiers changed from: private */
    public b Q;
    /* access modifiers changed from: private */
    public b R;
    /* access modifiers changed from: private */
    public b S;
    private RectF T = new RectF();
    /* access modifiers changed from: private */
    public int U = 0;
    private ValueAnimator V;
    /* access modifiers changed from: private */
    public final ArgbEvaluator W = new ArgbEvaluator();
    /* access modifiers changed from: private */

    /* renamed from: aa  reason: collision with root package name */
    public boolean f24070aa;

    /* renamed from: ab  reason: collision with root package name */
    private boolean f24071ab;

    /* renamed from: ac  reason: collision with root package name */
    private boolean f24072ac;

    /* renamed from: ad  reason: collision with root package name */
    private boolean f24073ad;

    /* renamed from: ae  reason: collision with root package name */
    private boolean f24074ae = false;
    /* access modifiers changed from: private */

    /* renamed from: af  reason: collision with root package name */
    public boolean f24075af;

    /* renamed from: ag  reason: collision with root package name */
    private boolean f24076ag = false;

    /* renamed from: ah  reason: collision with root package name */
    private boolean f24077ah = false;

    /* renamed from: ai  reason: collision with root package name */
    private a f24078ai;

    /* renamed from: aj  reason: collision with root package name */
    private long f24079aj;

    /* renamed from: ak  reason: collision with root package name */
    private Runnable f24080ak = new Runnable() {
        public void run() {
            if (!NiceSwitchButton.this.d()) {
                NiceSwitchButton.this.g();
            }
        }
    };

    /* renamed from: al  reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f24081al = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int c2 = NiceSwitchButton.this.U;
            if (c2 == 1 || c2 == 3 || c2 == 4) {
                NiceSwitchButton.this.Q.f24112c = ((Integer) NiceSwitchButton.this.W.evaluate(floatValue, Integer.valueOf(NiceSwitchButton.this.R.f24112c), Integer.valueOf(NiceSwitchButton.this.S.f24112c))).intValue();
                NiceSwitchButton.this.Q.f24113d = NiceSwitchButton.this.R.f24113d + ((NiceSwitchButton.this.S.f24113d - NiceSwitchButton.this.R.f24113d) * floatValue);
                if (NiceSwitchButton.this.U != 1) {
                    NiceSwitchButton.this.Q.f24110a = NiceSwitchButton.this.R.f24110a + ((NiceSwitchButton.this.S.f24110a - NiceSwitchButton.this.R.f24110a) * floatValue);
                }
                NiceSwitchButton.this.Q.f24111b = ((Integer) NiceSwitchButton.this.W.evaluate(floatValue, Integer.valueOf(NiceSwitchButton.this.R.f24111b), Integer.valueOf(NiceSwitchButton.this.S.f24111b))).intValue();
            } else if (c2 == 5) {
                NiceSwitchButton.this.Q.f24110a = NiceSwitchButton.this.R.f24110a + ((NiceSwitchButton.this.S.f24110a - NiceSwitchButton.this.R.f24110a) * floatValue);
                float h2 = (NiceSwitchButton.this.Q.f24110a - NiceSwitchButton.this.M) / (NiceSwitchButton.this.N - NiceSwitchButton.this.M);
                NiceSwitchButton.this.Q.f24111b = ((Integer) NiceSwitchButton.this.W.evaluate(h2, Integer.valueOf(NiceSwitchButton.this.f24105y), Integer.valueOf(NiceSwitchButton.this.f24106z))).intValue();
                NiceSwitchButton.this.Q.f24113d = NiceSwitchButton.this.f24094n * h2;
                NiceSwitchButton.this.Q.f24112c = ((Integer) NiceSwitchButton.this.W.evaluate(h2, 0, Integer.valueOf(NiceSwitchButton.this.B))).intValue();
            }
            NiceSwitchButton.this.postInvalidate();
        }
    };

    /* renamed from: am  reason: collision with root package name */
    private Animator.AnimatorListener f24082am = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            int c2 = NiceSwitchButton.this.U;
            if (c2 == 1) {
                int unused = NiceSwitchButton.this.U = 2;
                NiceSwitchButton.this.Q.f24112c = 0;
                NiceSwitchButton.this.Q.f24113d = NiceSwitchButton.this.f24094n;
            } else if (c2 != 3) {
                if (c2 == 4) {
                    int unused2 = NiceSwitchButton.this.U = 0;
                    NiceSwitchButton.this.postInvalidate();
                    if (!NiceSwitchButton.this.f24075af) {
                        return;
                    }
                } else if (c2 == 5) {
                    NiceSwitchButton niceSwitchButton = NiceSwitchButton.this;
                    boolean unused3 = niceSwitchButton.f24070aa = true ^ niceSwitchButton.f24070aa;
                    int unused4 = NiceSwitchButton.this.U = 0;
                    NiceSwitchButton.this.postInvalidate();
                    if (!NiceSwitchButton.this.f24075af) {
                        return;
                    }
                } else {
                    return;
                }
                NiceSwitchButton.this.c();
                boolean unused5 = NiceSwitchButton.this.f24075af = false;
                return;
            } else {
                int unused6 = NiceSwitchButton.this.U = 0;
            }
            NiceSwitchButton.this.postInvalidate();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final int f24083c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final int f24084d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final int f24085e = 2;

    /* renamed from: f  reason: collision with root package name */
    private final int f24086f = 3;

    /* renamed from: g  reason: collision with root package name */
    private final int f24087g = 4;

    /* renamed from: h  reason: collision with root package name */
    private final int f24088h = 5;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24089i = false;

    /* renamed from: j  reason: collision with root package name */
    private long f24090j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f24091k;

    /* renamed from: l  reason: collision with root package name */
    private int f24092l;

    /* renamed from: m  reason: collision with root package name */
    private int f24093m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f24094n;

    /* renamed from: o  reason: collision with root package name */
    private float f24095o;

    /* renamed from: p  reason: collision with root package name */
    private float f24096p;

    /* renamed from: q  reason: collision with root package name */
    private float f24097q;

    /* renamed from: r  reason: collision with root package name */
    private float f24098r;

    /* renamed from: s  reason: collision with root package name */
    private float f24099s;

    /* renamed from: t  reason: collision with root package name */
    private float f24100t;

    /* renamed from: u  reason: collision with root package name */
    private float f24101u;

    /* renamed from: v  reason: collision with root package name */
    private float f24102v;

    /* renamed from: w  reason: collision with root package name */
    private float f24103w;

    /* renamed from: x  reason: collision with root package name */
    private int f24104x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public int f24105y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public int f24106z;

    public interface a {
        void onCheckedChanged(NiceSwitchButton niceSwitchButton, boolean z2);
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        float f24110a;

        /* renamed from: b  reason: collision with root package name */
        int f24111b;

        /* renamed from: c  reason: collision with root package name */
        int f24112c;

        /* renamed from: d  reason: collision with root package name */
        float f24113d;

        b() {
        }

        /* access modifiers changed from: private */
        public void a(b bVar) {
            this.f24110a = bVar.f24110a;
            this.f24111b = bVar.f24111b;
            this.f24112c = bVar.f24112c;
            this.f24113d = bVar.f24113d;
        }
    }

    public NiceSwitchButton(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public NiceSwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public NiceSwitchButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private static float a(float f2) {
        return TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    private static float a(TypedArray typedArray, int i2, float f2) {
        return typedArray == null ? f2 : typedArray.getDimension(i2, f2);
    }

    private static int a(TypedArray typedArray, int i2, int i3) {
        return typedArray == null ? i3 : typedArray.getInt(i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, R.styleable.NiceSwitchButton) : null;
        this.f24072ac = a(obtainStyledAttributes, 11, true);
        this.E = c(obtainStyledAttributes, 17, -5592406);
        this.F = b(obtainStyledAttributes, 19, b(1.5f));
        this.G = a(10.0f);
        this.H = a(obtainStyledAttributes, 18, a(4.0f));
        this.I = a(4.0f);
        this.J = a(4.0f);
        this.f24091k = b(obtainStyledAttributes, 13, b(2.5f));
        this.f24092l = b(obtainStyledAttributes, 12, b(1.5f));
        this.f24093m = c(obtainStyledAttributes, 10, 855638016);
        this.f24105y = c(obtainStyledAttributes, 15, -2236963);
        this.f24106z = c(obtainStyledAttributes, 4, -11414681);
        this.A = b(obtainStyledAttributes, 1, b(1.0f));
        this.B = c(obtainStyledAttributes, 6, -1);
        this.C = b(obtainStyledAttributes, 7, b(1.0f));
        this.D = a(6.0f);
        int c2 = c(obtainStyledAttributes, 2, -1);
        this.K = c(obtainStyledAttributes, 16, c2);
        this.L = c(obtainStyledAttributes, 5, c2);
        int a2 = a(obtainStyledAttributes, 8, 300);
        this.f24070aa = a(obtainStyledAttributes, 3, false);
        this.f24073ad = a(obtainStyledAttributes, 14, true);
        this.f24104x = c(obtainStyledAttributes, 0, -1);
        this.f24071ab = a(obtainStyledAttributes, 9, true);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        this.P = new Paint(1);
        Paint paint = new Paint(1);
        this.O = paint;
        paint.setColor(c2);
        if (this.f24072ac) {
            this.O.setShadowLayer((float) this.f24091k, 0.0f, (float) this.f24092l, this.f24093m);
        }
        this.Q = new b();
        this.R = new b();
        this.S = new b();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.V = ofFloat;
        ofFloat.setDuration((long) a2);
        this.V.setRepeatCount(0);
        this.V.addUpdateListener(this.f24081al);
        this.V.addListener(this.f24082am);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
    }

    private void a(Canvas canvas, float f2, float f3) {
        canvas.drawCircle(f2, f3, this.f24095o, this.O);
        this.P.setStyle(Paint.Style.STROKE);
        this.P.setStrokeWidth(1.0f);
        this.P.setColor(-2236963);
        canvas.drawCircle(f2, f3, this.f24095o, this.P);
    }

    private void a(Canvas canvas, float f2, float f3, float f4, float f5, float f6, float f7, Paint paint) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawArc(f2, f3, f4, f5, f6, f7, true, paint);
            return;
        }
        float f8 = f2;
        float f9 = f3;
        this.T.set(f2, f3, f4, f5);
        canvas.drawArc(this.T, f6, f7, true, paint);
    }

    private void a(Canvas canvas, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(f2, f3, f4, f5, f6, f6, paint);
            return;
        }
        this.T.set(f2, f3, f4, f5);
        canvas.drawRoundRect(this.T, f6, f6, paint);
    }

    private void a(boolean z2, boolean z3) {
        if (this.f24077ah) {
            throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
        } else if (!this.f24076ag) {
            this.f24070aa = !this.f24070aa;
            if (z3) {
                c();
            }
        } else {
            if (this.V.isRunning()) {
                this.V.cancel();
            }
            if (!this.f24071ab || !z2) {
                this.f24070aa = !this.f24070aa;
                if (isChecked()) {
                    setCheckedViewState(this.Q);
                } else {
                    setUncheckViewState(this.Q);
                }
                postInvalidate();
                if (z3) {
                    c();
                    return;
                }
                return;
            }
            this.U = 5;
            this.R.a(this.Q);
            if (isChecked()) {
                setUncheckViewState(this.S);
            } else {
                setCheckedViewState(this.S);
            }
            this.V.start();
        }
    }

    private static boolean a(TypedArray typedArray, int i2, boolean z2) {
        return typedArray == null ? z2 : typedArray.getBoolean(i2, z2);
    }

    private static int b(float f2) {
        return (int) a(f2);
    }

    private static int b(TypedArray typedArray, int i2, int i3) {
        return typedArray == null ? i3 : typedArray.getDimensionPixelOffset(i2, i3);
    }

    private void b(Canvas canvas) {
        a(canvas, this.E, (float) this.F, this.f24100t - this.G, this.f24103w, this.H, this.P);
    }

    private static int c(TypedArray typedArray, int i2, int i3) {
        return typedArray == null ? i3 : typedArray.getColor(i2, i3);
    }

    /* access modifiers changed from: private */
    public void c() {
        a aVar = this.f24078ai;
        if (aVar != null) {
            this.f24077ah = true;
            aVar.onCheckedChanged(this, isChecked());
        }
        this.f24077ah = false;
    }

    /* access modifiers changed from: private */
    public boolean d() {
        return this.U != 0;
    }

    private boolean e() {
        int i2 = this.U;
        return i2 == 1 || i2 == 3;
    }

    private boolean f() {
        return this.U == 2;
    }

    /* access modifiers changed from: private */
    public void g() {
        if (!d() && this.f24074ae) {
            if (this.V.isRunning()) {
                this.V.cancel();
            }
            this.U = 1;
            this.R.a(this.Q);
            this.S.a(this.Q);
            if (isChecked()) {
                this.S.f24111b = this.f24106z;
                this.S.f24110a = this.N;
                this.S.f24112c = this.f24106z;
            } else {
                this.S.f24111b = this.f24105y;
                this.S.f24110a = this.M;
                this.S.f24113d = this.f24094n;
            }
            this.V.start();
        }
    }

    private void h() {
        if (f() || e()) {
            if (this.V.isRunning()) {
                this.V.cancel();
            }
            this.U = 3;
            this.R.a(this.Q);
            if (isChecked()) {
                setCheckedViewState(this.S);
            } else {
                setUncheckViewState(this.S);
            }
            this.V.start();
        }
    }

    private void i() {
        if (this.V.isRunning()) {
            this.V.cancel();
        }
        this.U = 4;
        this.R.a(this.Q);
        if (isChecked()) {
            setCheckedViewState(this.S);
        } else {
            setUncheckViewState(this.S);
        }
        this.V.start();
    }

    private void setCheckedViewState(b bVar) {
        bVar.f24113d = this.f24094n;
        bVar.f24111b = this.f24106z;
        bVar.f24112c = this.B;
        bVar.f24110a = this.N;
        this.O.setColor(this.L);
    }

    private void setUncheckViewState(b bVar) {
        bVar.f24113d = 0.0f;
        bVar.f24111b = this.f24105y;
        bVar.f24112c = 0;
        bVar.f24110a = this.M;
        this.O.setColor(this.K);
    }

    public void a() {
        a(true, false);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        int i2 = this.Q.f24112c;
        float f2 = (float) this.C;
        float f3 = this.f24098r;
        float f4 = this.f24094n;
        float f5 = (f3 + f4) - this.I;
        float f6 = this.f24103w;
        float f7 = this.D;
        float f8 = f6 - f7;
        float f9 = (f3 + f4) - this.J;
        a(canvas, i2, f2, f5, f8, f9, f6 + f7, this.P);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, int i2, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i2);
        paint.setStrokeWidth(f2);
        canvas.drawLine(f3, f4, f5, f6, paint);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, int i2, float f2, float f3, float f4, float f5, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i2);
        paint.setStrokeWidth(f2);
        canvas.drawCircle(f3, f4, f5, paint);
    }

    public void a(boolean z2) {
        a(z2, true);
    }

    public void b() {
        this.f24089i = true;
    }

    public boolean isChecked() {
        return this.f24070aa;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.P.setStrokeWidth((float) this.A);
        this.P.setStyle(Paint.Style.FILL);
        this.P.setColor(this.f24104x);
        Canvas canvas2 = canvas;
        a(canvas2, this.f24098r, this.f24099s, this.f24100t, this.f24101u, this.f24094n, this.P);
        this.P.setStyle(Paint.Style.STROKE);
        this.P.setColor(this.f24105y);
        a(canvas2, this.f24098r, this.f24099s, this.f24100t, this.f24101u, this.f24094n, this.P);
        if (this.f24073ad) {
            b(canvas);
        }
        float f2 = this.Q.f24113d * 0.5f;
        this.P.setStyle(Paint.Style.STROKE);
        this.P.setColor(this.Q.f24111b);
        this.P.setStrokeWidth(((float) this.A) + (f2 * 2.0f));
        Canvas canvas3 = canvas;
        a(canvas3, this.f24098r + f2, this.f24099s + f2, this.f24100t - f2, this.f24101u - f2, this.f24094n, this.P);
        this.P.setStyle(Paint.Style.FILL);
        this.P.setStrokeWidth(1.0f);
        float f3 = this.f24098r;
        float f4 = this.f24099s;
        float f5 = this.f24094n;
        a(canvas3, f3, f4, f3 + (f5 * 2.0f), f4 + (f5 * 2.0f), 90.0f, 180.0f, this.P);
        canvas.drawRect(this.f24098r + this.f24094n, this.f24099s, this.Q.f24110a, this.f24099s + (this.f24094n * 2.0f), this.P);
        if (this.f24073ad) {
            a(canvas);
        }
        a(canvas, this.Q.f24110a, this.f24103w);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(f24068a, MemoryConstants.GB);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(f24069b, MemoryConstants.GB);
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float max = (float) Math.max(this.f24091k + this.f24092l, this.A);
        float f2 = ((float) i3) - max;
        float f3 = f2 - max;
        this.f24096p = f3;
        float f4 = ((float) i2) - max;
        this.f24097q = f4 - max;
        float f5 = f3 * 0.5f;
        this.f24094n = f5;
        this.f24095o = f5 - ((float) this.A);
        this.f24098r = max;
        this.f24099s = max;
        this.f24100t = f4;
        this.f24101u = f2;
        this.f24102v = (max + f4) * 0.5f;
        this.f24103w = (f2 + max) * 0.5f;
        this.M = max + f5;
        this.N = f4 - f5;
        if (isChecked()) {
            setCheckedViewState(this.Q);
        } else {
            setUncheckViewState(this.Q);
        }
        this.f24076ag = true;
        postInvalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (f() == false) goto L_0x011e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.isEnabled()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = r10.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x010a
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == r2) goto L_0x009d
            r5 = 2
            if (r0 == r5) goto L_0x0036
            r10 = 3
            if (r0 == r10) goto L_0x001c
            goto L_0x011e
        L_0x001c:
            r9.f24075af = r1
            r9.f24074ae = r1
            java.lang.Runnable r10 = r9.f24080ak
            r9.removeCallbacks(r10)
            boolean r10 = r9.e()
            if (r10 != 0) goto L_0x0031
            boolean r10 = r9.f()
            if (r10 == 0) goto L_0x011e
        L_0x0031:
            r9.h()
            goto L_0x011e
        L_0x0036:
            float r10 = r10.getX()
            boolean r0 = r9.e()
            if (r0 == 0) goto L_0x005c
            int r0 = r9.getWidth()
            float r0 = (float) r0
            float r10 = r10 / r0
            float r10 = java.lang.Math.min(r3, r10)
            float r10 = java.lang.Math.max(r4, r10)
            com.xeagle.android.newUI.widgets.NiceSwitchButton$b r0 = r9.Q
            float r1 = r9.M
            float r3 = r9.N
            float r3 = r3 - r1
            float r3 = r3 * r10
            float r1 = r1 + r3
            r0.f24110a = r1
            goto L_0x011e
        L_0x005c:
            boolean r0 = r9.f()
            if (r0 == 0) goto L_0x011e
            int r0 = r9.getWidth()
            float r0 = (float) r0
            float r10 = r10 / r0
            float r10 = java.lang.Math.min(r3, r10)
            float r10 = java.lang.Math.max(r4, r10)
            com.xeagle.android.newUI.widgets.NiceSwitchButton$b r0 = r9.Q
            float r1 = r9.M
            float r3 = r9.N
            float r3 = r3 - r1
            float r3 = r3 * r10
            float r1 = r1 + r3
            r0.f24110a = r1
            com.xeagle.android.newUI.widgets.NiceSwitchButton$b r0 = r9.Q
            android.animation.ArgbEvaluator r1 = r9.W
            int r3 = r9.f24105y
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r4 = r9.f24106z
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r10 = r1.evaluate(r10, r3, r4)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            r0.f24111b = r10
            r9.postInvalidate()
            goto L_0x011e
        L_0x009d:
            r9.f24074ae = r1
            java.lang.Runnable r0 = r9.f24080ak
            r9.removeCallbacks(r0)
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r9.f24079aj
            long r5 = r5 - r7
            r7 = 300(0x12c, double:1.48E-321)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x00d1
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = r9.f24090j
            long r3 = r3 - r5
            r5 = 500(0x1f4, double:2.47E-321)
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 <= 0) goto L_0x00ca
            long r0 = java.lang.System.currentTimeMillis()
            r9.f24090j = r0
            r9.f24075af = r2
            r9.toggle()
            goto L_0x011e
        L_0x00ca:
            r10 = 2131820780(0x7f1100ec, float:1.9274285E38)
            com.blankj.utilcode.util.ToastUtils.showShort((int) r10)
            return r1
        L_0x00d1:
            boolean r0 = r9.f()
            if (r0 == 0) goto L_0x0100
            r9.f24075af = r2
            float r10 = r10.getX()
            int r0 = r9.getWidth()
            float r0 = (float) r0
            float r10 = r10 / r0
            float r10 = java.lang.Math.min(r3, r10)
            float r10 = java.lang.Math.max(r4, r10)
            r0 = 1056964608(0x3f000000, float:0.5)
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 <= 0) goto L_0x00f2
            r1 = 1
        L_0x00f2:
            boolean r10 = r9.isChecked()
            if (r1 != r10) goto L_0x00fa
            goto L_0x0031
        L_0x00fa:
            r9.f24070aa = r1
            r9.i()
            goto L_0x011e
        L_0x0100:
            boolean r10 = r9.e()
            if (r10 == 0) goto L_0x011e
            r9.f24075af = r1
            goto L_0x0031
        L_0x010a:
            r9.f24074ae = r2
            long r0 = java.lang.System.currentTimeMillis()
            r9.f24079aj = r0
            java.lang.Runnable r10 = r9.f24080ak
            r9.removeCallbacks(r10)
            java.lang.Runnable r10 = r9.f24080ak
            r0 = 100
            r9.postDelayed(r10, r0)
        L_0x011e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.widgets.NiceSwitchButton.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setChecked(boolean z2) {
        if (z2 == isChecked()) {
            postInvalidate();
        } else {
            a(this.f24071ab, false);
        }
    }

    public void setEnableEffect(boolean z2) {
        this.f24071ab = z2;
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.f24078ai = aVar;
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public final void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
    }

    public final void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(0, 0, 0, 0);
    }

    public void setShadowEffect(boolean z2) {
        if (this.f24072ac != z2) {
            this.f24072ac = z2;
            if (z2) {
                this.O.setShadowLayer((float) this.f24091k, 0.0f, (float) this.f24092l, this.f24093m);
            } else {
                this.O.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void toggle() {
        if (this.f24089i) {
            a();
            this.f24089i = false;
            return;
        }
        a(true);
    }
}
