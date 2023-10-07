package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.b;
import com.github.mikephil.charting.data.h;
import com.github.mikephil.charting.listener.a;
import com.github.mikephil.charting.listener.d;
import fe.q;
import fe.t;
import fg.g;
import fg.i;

public abstract class BarLineChartBase<T extends b<? extends fc.b<? extends Entry>>> extends Chart<T> implements fb.b {
    protected float[] A = new float[2];

    /* renamed from: a  reason: collision with root package name */
    private boolean f14760a = true;

    /* renamed from: aa  reason: collision with root package name */
    private boolean f14761aa = true;

    /* renamed from: ab  reason: collision with root package name */
    private boolean f14762ab = true;

    /* renamed from: ac  reason: collision with root package name */
    private boolean f14763ac = true;

    /* renamed from: ad  reason: collision with root package name */
    private long f14764ad = 0;

    /* renamed from: ae  reason: collision with root package name */
    private long f14765ae = 0;

    /* renamed from: af  reason: collision with root package name */
    private RectF f14766af = new RectF();

    /* renamed from: ag  reason: collision with root package name */
    private boolean f14767ag = false;

    /* renamed from: b  reason: collision with root package name */
    protected int f14768b = 100;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f14769c = false;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f14770d = false;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f14771e = true;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f14772f = true;

    /* renamed from: g  reason: collision with root package name */
    protected Paint f14773g;

    /* renamed from: h  reason: collision with root package name */
    protected Paint f14774h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f14775i = false;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f14776j = false;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f14777k = false;

    /* renamed from: l  reason: collision with root package name */
    protected float f14778l = 15.0f;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f14779m = false;

    /* renamed from: n  reason: collision with root package name */
    protected d f14780n;

    /* renamed from: o  reason: collision with root package name */
    protected YAxis f14781o;

    /* renamed from: p  reason: collision with root package name */
    protected YAxis f14782p;

    /* renamed from: q  reason: collision with root package name */
    protected t f14783q;

    /* renamed from: r  reason: collision with root package name */
    protected t f14784r;

    /* renamed from: s  reason: collision with root package name */
    protected g f14785s;

    /* renamed from: t  reason: collision with root package name */
    protected g f14786t;

    /* renamed from: u  reason: collision with root package name */
    protected q f14787u;

    /* renamed from: v  reason: collision with root package name */
    protected Matrix f14788v = new Matrix();

    /* renamed from: w  reason: collision with root package name */
    protected Matrix f14789w = new Matrix();

    /* renamed from: x  reason: collision with root package name */
    protected float[] f14790x = new float[2];

    /* renamed from: y  reason: collision with root package name */
    protected fg.d f14791y = fg.d.a(i.f27244a, i.f27244a);

    /* renamed from: z  reason: collision with root package name */
    protected fg.d f14792z = fg.d.a(i.f27244a, i.f27244a);

    /* renamed from: com.github.mikephil.charting.charts.BarLineChartBase$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14793a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f14794b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f14795c;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(2:13|14)|15|17|18|19|20|22) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r0 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14795c = r0
                r1 = 1
                com.github.mikephil.charting.components.Legend$LegendOrientation r2 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f14795c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendOrientation r3 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f14794b = r2
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f14794b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r2 = f14794b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f14793a = r2
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r1 = f14793a     // Catch:{ NoSuchFieldError -> 0x005e }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM     // Catch:{ NoSuchFieldError -> 0x005e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.BarLineChartBase.AnonymousClass1.<clinit>():void");
        }
    }

    public BarLineChartBase(Context context) {
        super(context);
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public g a(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.f14785s : this.f14786t;
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.f14781o = new YAxis(YAxis.AxisDependency.LEFT);
        this.f14782p = new YAxis(YAxis.AxisDependency.RIGHT);
        this.f14785s = new g(this.Q);
        this.f14786t = new g(this.Q);
        this.f14783q = new t(this.Q, this.f14781o, this.f14785s);
        this.f14784r = new t(this.Q, this.f14782p, this.f14786t);
        this.f14787u = new q(this.Q, this.H, this.f14785s);
        setHighlighter(new fa.b(this));
        this.M = new a(this, this.Q.p(), 3.0f);
        Paint paint = new Paint();
        this.f14773g = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f14773g.setColor(Color.rgb(GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN));
        Paint paint2 = new Paint();
        this.f14774h = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f14774h.setColor(-16777216);
        this.f14774h.setStrokeWidth(i.a(1.0f));
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.Q.a(f2, f3, f4, -f5, this.f14788v);
        this.Q.a(this.f14788v, this, false);
        j();
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        if (this.f14775i) {
            canvas.drawRect(this.Q.k(), this.f14773g);
        }
        if (this.f14776j) {
            canvas.drawRect(this.Q.k(), this.f14774h);
        }
    }

    /* access modifiers changed from: protected */
    public void a(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        if (this.K != null && this.K.y() && !this.K.g()) {
            int i2 = AnonymousClass1.f14795c[this.K.f().ordinal()];
            if (i2 == 1) {
                int i3 = AnonymousClass1.f14794b[this.K.d().ordinal()];
                if (i3 == 1) {
                    rectF.left += Math.min(this.K.f14852a, this.Q.n() * this.K.q()) + this.K.t();
                    return;
                } else if (i3 == 2) {
                    rectF.right += Math.min(this.K.f14852a, this.Q.n() * this.K.q()) + this.K.t();
                    return;
                } else if (i3 == 3) {
                    int i4 = AnonymousClass1.f14793a[this.K.e().ordinal()];
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return;
                        }
                    }
                    rectF.top += Math.min(this.K.f14853b, this.Q.m() * this.K.q()) + this.K.u();
                    return;
                } else {
                    return;
                }
            } else if (i2 == 2) {
                int i5 = AnonymousClass1.f14793a[this.K.e().ordinal()];
                if (i5 != 1) {
                    if (i5 != 2) {
                        return;
                    }
                }
                rectF.top += Math.min(this.K.f14853b, this.Q.m() * this.K.q()) + this.K.u();
                return;
            } else {
                return;
            }
            rectF.bottom += Math.min(this.K.f14853b, this.Q.m() * this.K.q()) + this.K.u();
        }
    }

    public YAxis b(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.f14781o : this.f14782p;
    }

    public fc.b b(float f2, float f3) {
        fa.d a2 = a(f2, f3);
        if (a2 != null) {
            return (fc.b) ((b) this.C).a(a2.f());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.H.a(((b) this.C).f(), ((b) this.C).g());
        this.f14781o.a(((b) this.C).a(YAxis.AxisDependency.LEFT), ((b) this.C).b(YAxis.AxisDependency.LEFT));
        this.f14782p.a(((b) this.C).a(YAxis.AxisDependency.RIGHT), ((b) this.C).b(YAxis.AxisDependency.RIGHT));
    }

    public boolean c(YAxis.AxisDependency axisDependency) {
        return b(axisDependency).F();
    }

    public void computeScroll() {
        if (this.M instanceof a) {
            ((a) this.M).b();
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
        if (this.B) {
            Log.i("MPAndroidChart", "Preparing Value-Px Matrix, xmin: " + this.H.f14943u + ", xmax: " + this.H.f14942t + ", xdelta: " + this.H.f14944v);
        }
        this.f14786t.a(this.H.f14943u, this.H.f14944v, this.f14782p.f14944v, this.f14782p.f14943u);
        this.f14785s.a(this.H.f14943u, this.H.f14944v, this.f14781o.f14944v, this.f14781o.f14943u);
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.f14786t.a(this.f14782p.F());
        this.f14785s.a(this.f14781o.F());
    }

    public YAxis getAxisLeft() {
        return this.f14781o;
    }

    public YAxis getAxisRight() {
        return this.f14782p;
    }

    public /* bridge */ /* synthetic */ b getData() {
        return (b) super.getData();
    }

    public d getDrawListener() {
        return this.f14780n;
    }

    public float getHighestVisibleX() {
        a(YAxis.AxisDependency.LEFT).a(this.Q.g(), this.Q.h(), this.f14792z);
        return (float) Math.min((double) this.H.f14942t, this.f14792z.f27218a);
    }

    public float getLowestVisibleX() {
        a(YAxis.AxisDependency.LEFT).a(this.Q.f(), this.Q.h(), this.f14791y);
        return (float) Math.max((double) this.H.f14943u, this.f14791y.f27218a);
    }

    public int getMaxVisibleCount() {
        return this.f14768b;
    }

    public float getMinOffset() {
        return this.f14778l;
    }

    public t getRendererLeftYAxis() {
        return this.f14783q;
    }

    public t getRendererRightYAxis() {
        return this.f14784r;
    }

    public q getRendererXAxis() {
        return this.f14787u;
    }

    public float getScaleX() {
        if (this.Q == null) {
            return 1.0f;
        }
        return this.Q.q();
    }

    public float getScaleY() {
        if (this.Q == null) {
            return 1.0f;
        }
        return this.Q.r();
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    public float getYChartMax() {
        return Math.max(this.f14781o.f14942t, this.f14782p.f14942t);
    }

    public float getYChartMin() {
        return Math.min(this.f14781o.f14943u, this.f14782p.f14943u);
    }

    public void h() {
        if (this.C != null) {
            if (this.B) {
                Log.i("MPAndroidChart", "Preparing...");
            }
            if (this.O != null) {
                this.O.a();
            }
            b();
            this.f14783q.a(this.f14781o.f14943u, this.f14781o.f14942t, this.f14781o.F());
            this.f14784r.a(this.f14782p.f14943u, this.f14782p.f14942t, this.f14782p.F());
            this.f14787u.a(this.H.f14943u, this.H.f14942t, false);
            if (this.K != null) {
                this.N.a((h<?>) this.C);
            }
            j();
        } else if (this.B) {
            Log.i("MPAndroidChart", "Preparing... DATA NOT SET.");
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        ((b) this.C).a(getLowestVisibleX(), getHighestVisibleX());
        this.H.a(((b) this.C).f(), ((b) this.C).g());
        if (this.f14781o.y()) {
            this.f14781o.a(((b) this.C).a(YAxis.AxisDependency.LEFT), ((b) this.C).b(YAxis.AxisDependency.LEFT));
        }
        if (this.f14782p.y()) {
            this.f14782p.a(((b) this.C).a(YAxis.AxisDependency.RIGHT), ((b) this.C).b(YAxis.AxisDependency.RIGHT));
        }
        j();
    }

    public void j() {
        if (!this.f14767ag) {
            a(this.f14766af);
            float f2 = this.f14766af.left + 0.0f;
            float f3 = this.f14766af.top + 0.0f;
            float f4 = this.f14766af.right + 0.0f;
            float f5 = this.f14766af.bottom + 0.0f;
            if (this.f14781o.L()) {
                f2 += this.f14781o.a(this.f14783q.a());
            }
            if (this.f14782p.L()) {
                f4 += this.f14782p.a(this.f14784r.a());
            }
            if (this.H.y() && this.H.h()) {
                float u2 = ((float) this.H.F) + this.H.u();
                if (this.H.z() == XAxis.XAxisPosition.BOTTOM) {
                    f5 += u2;
                } else {
                    if (this.H.z() != XAxis.XAxisPosition.TOP) {
                        if (this.H.z() == XAxis.XAxisPosition.BOTH_SIDED) {
                            f5 += u2;
                        }
                    }
                    f3 += u2;
                }
            }
            float extraTopOffset = f3 + getExtraTopOffset();
            float extraRightOffset = f4 + getExtraRightOffset();
            float extraBottomOffset = f5 + getExtraBottomOffset();
            float extraLeftOffset = f2 + getExtraLeftOffset();
            float a2 = i.a(this.f14778l);
            this.Q.a(Math.max(a2, extraLeftOffset), Math.max(a2, extraTopOffset), Math.max(a2, extraRightOffset), Math.max(a2, extraBottomOffset));
            if (this.B) {
                Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
                StringBuilder sb = new StringBuilder();
                sb.append("Content: ");
                sb.append(this.Q.k().toString());
                Log.i("MPAndroidChart", sb.toString());
            }
        }
        g();
        f();
    }

    public boolean k() {
        return this.f14772f;
    }

    public boolean l() {
        return this.f14760a || this.f14761aa;
    }

    public boolean m() {
        return this.f14760a;
    }

    public boolean n() {
        return this.f14761aa;
    }

    public boolean o() {
        return this.f14762ab;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.C != null) {
            long currentTimeMillis = System.currentTimeMillis();
            a(canvas);
            if (this.f14769c) {
                i();
            }
            if (this.f14781o.y()) {
                this.f14783q.a(this.f14781o.f14943u, this.f14781o.f14942t, this.f14781o.F());
            }
            if (this.f14782p.y()) {
                this.f14784r.a(this.f14782p.f14943u, this.f14782p.f14942t, this.f14782p.F());
            }
            if (this.H.y()) {
                this.f14787u.a(this.H.f14943u, this.H.f14942t, false);
            }
            this.f14787u.b(canvas);
            this.f14783q.b(canvas);
            this.f14784r.b(canvas);
            if (this.H.o()) {
                this.f14787u.c(canvas);
            }
            if (this.f14781o.o()) {
                this.f14783q.c(canvas);
            }
            if (this.f14782p.o()) {
                this.f14784r.c(canvas);
            }
            if (this.H.y() && this.H.n()) {
                this.f14787u.d(canvas);
            }
            if (this.f14781o.y() && this.f14781o.n()) {
                this.f14783q.e(canvas);
            }
            if (this.f14782p.y() && this.f14782p.n()) {
                this.f14784r.e(canvas);
            }
            int save = canvas.save();
            canvas.clipRect(this.Q.k());
            this.O.a(canvas);
            if (!this.H.o()) {
                this.f14787u.c(canvas);
            }
            if (!this.f14781o.o()) {
                this.f14783q.c(canvas);
            }
            if (!this.f14782p.o()) {
                this.f14784r.c(canvas);
            }
            if (x()) {
                this.O.a(canvas, this.S);
            }
            canvas.restoreToCount(save);
            this.O.c(canvas);
            if (this.H.y() && !this.H.n()) {
                this.f14787u.d(canvas);
            }
            if (this.f14781o.y() && !this.f14781o.n()) {
                this.f14783q.e(canvas);
            }
            if (this.f14782p.y() && !this.f14782p.n()) {
                this.f14784r.e(canvas);
            }
            this.f14787u.a(canvas);
            this.f14783q.a(canvas);
            this.f14784r.a(canvas);
            if (r()) {
                int save2 = canvas.save();
                canvas.clipRect(this.Q.k());
                this.O.b(canvas);
                canvas.restoreToCount(save2);
            } else {
                this.O.b(canvas);
            }
            this.N.a(canvas);
            b(canvas);
            c(canvas);
            if (this.B) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long j2 = this.f14764ad + currentTimeMillis2;
                this.f14764ad = j2;
                long j3 = this.f14765ae + 1;
                this.f14765ae = j3;
                Log.i("MPAndroidChart", "Drawtime: " + currentTimeMillis2 + " ms, average: " + (j2 / j3) + " ms, cycles: " + this.f14765ae);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        float[] fArr = this.A;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.f14779m) {
            fArr[0] = this.Q.f();
            this.A[1] = this.Q.e();
            a(YAxis.AxisDependency.LEFT).b(this.A);
        }
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.f14779m) {
            a(YAxis.AxisDependency.LEFT).a(this.A);
            this.Q.a(this.A, (View) this);
            return;
        }
        this.Q.a(this.Q.p(), this, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.M == null || this.C == null || !this.I) {
            return false;
        }
        return this.M.onTouch(this, motionEvent);
    }

    public boolean p() {
        return this.f14763ac;
    }

    public boolean q() {
        return this.f14771e;
    }

    public boolean r() {
        return this.f14777k;
    }

    public boolean s() {
        return this.Q.s();
    }

    public void setAutoScaleMinMaxEnabled(boolean z2) {
        this.f14769c = z2;
    }

    public void setBorderColor(int i2) {
        this.f14774h.setColor(i2);
    }

    public void setBorderWidth(float f2) {
        this.f14774h.setStrokeWidth(i.a(f2));
    }

    public void setClipValuesToContent(boolean z2) {
        this.f14777k = z2;
    }

    public void setDoubleTapToZoomEnabled(boolean z2) {
        this.f14771e = z2;
    }

    public void setDragEnabled(boolean z2) {
        this.f14760a = z2;
        this.f14761aa = z2;
    }

    public void setDragOffsetX(float f2) {
        this.Q.k(f2);
    }

    public void setDragOffsetY(float f2) {
        this.Q.l(f2);
    }

    public void setDragXEnabled(boolean z2) {
        this.f14760a = z2;
    }

    public void setDragYEnabled(boolean z2) {
        this.f14761aa = z2;
    }

    public void setDrawBorders(boolean z2) {
        this.f14776j = z2;
    }

    public void setDrawGridBackground(boolean z2) {
        this.f14775i = z2;
    }

    public void setGridBackgroundColor(int i2) {
        this.f14773g.setColor(i2);
    }

    public void setHighlightPerDragEnabled(boolean z2) {
        this.f14772f = z2;
    }

    public void setKeepPositionOnRotation(boolean z2) {
        this.f14779m = z2;
    }

    public void setMaxVisibleValueCount(int i2) {
        this.f14768b = i2;
    }

    public void setMinOffset(float f2) {
        this.f14778l = f2;
    }

    public void setOnDrawListener(d dVar) {
        this.f14780n = dVar;
    }

    public void setPinchZoom(boolean z2) {
        this.f14770d = z2;
    }

    public void setRendererLeftYAxis(t tVar) {
        this.f14783q = tVar;
    }

    public void setRendererRightYAxis(t tVar) {
        this.f14784r = tVar;
    }

    public void setScaleEnabled(boolean z2) {
        this.f14762ab = z2;
        this.f14763ac = z2;
    }

    public void setScaleXEnabled(boolean z2) {
        this.f14762ab = z2;
    }

    public void setScaleYEnabled(boolean z2) {
        this.f14763ac = z2;
    }

    public void setVisibleXRangeMaximum(float f2) {
        this.Q.a(this.H.f14944v / f2);
    }

    public void setVisibleXRangeMinimum(float f2) {
        this.Q.b(this.H.f14944v / f2);
    }

    public void setXAxisRenderer(q qVar) {
        this.f14787u = qVar;
    }

    public boolean t() {
        return this.f14770d;
    }

    public boolean u() {
        return this.Q.v();
    }

    public boolean v() {
        return this.f14781o.F() || this.f14782p.F();
    }
}
