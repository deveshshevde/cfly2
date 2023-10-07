package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.c;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.h;
import com.github.mikephil.charting.listener.ChartTouchListener;
import ex.a;
import ez.b;
import fa.d;
import fa.f;
import fc.e;
import fe.g;
import fe.i;
import fg.j;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Chart<T extends h<? extends e<? extends Entry>>> extends ViewGroup implements fb.e {
    protected boolean B = false;
    protected T C = null;
    protected boolean D = true;
    protected b E = new b(0);
    protected Paint F;
    protected Paint G;
    protected XAxis H;
    protected boolean I = true;
    protected c J;
    protected Legend K;
    protected com.github.mikephil.charting.listener.c L;
    protected ChartTouchListener M;
    protected i N;
    protected g O;
    protected f P;
    protected j Q = new j();
    protected a R;
    protected d[] S;
    protected float T = 0.0f;
    protected boolean U = true;
    protected com.github.mikephil.charting.components.d V;
    protected ArrayList<Runnable> W = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private boolean f14796a = true;

    /* renamed from: b  reason: collision with root package name */
    private float f14797b = 0.9f;

    /* renamed from: c  reason: collision with root package name */
    private String f14798c = "No chart data available.";

    /* renamed from: d  reason: collision with root package name */
    private com.github.mikephil.charting.listener.b f14799d;

    /* renamed from: e  reason: collision with root package name */
    private float f14800e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f14801f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f14802g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f14803h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14804i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14805j = false;

    public Chart(Context context) {
        super(context);
        a();
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public Chart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback((Drawable.Callback) null);
        }
        if (view instanceof ViewGroup) {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 < viewGroup.getChildCount()) {
                    a(viewGroup.getChildAt(i2));
                    i2++;
                } else {
                    viewGroup.removeAllViews();
                    return;
                }
            }
        }
    }

    public void A() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void B() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public boolean C() {
        return this.U;
    }

    public d a(float f2, float f3) {
        if (this.C != null) {
            return getHighlighter().a(f2, f3);
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    /* access modifiers changed from: protected */
    public void a() {
        setWillNotDraw(false);
        this.R = new a(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Chart.this.postInvalidate();
            }
        });
        fg.i.a(getContext());
        this.T = fg.i.a(500.0f);
        this.J = new c();
        Legend legend = new Legend();
        this.K = legend;
        this.N = new i(this.Q, legend);
        this.H = new XAxis();
        this.F = new Paint(1);
        Paint paint = new Paint(1);
        this.G = paint;
        paint.setColor(Color.rgb(247, 189, 51));
        this.G.setTextAlign(Paint.Align.CENTER);
        this.G.setTextSize(fg.i.a(12.0f));
        if (this.B) {
            Log.i("", "Chart.init()");
        }
    }

    public void a(d dVar, boolean z2) {
        Entry entry = null;
        if (dVar == null) {
            this.S = null;
        } else {
            if (this.B) {
                Log.i("MPAndroidChart", "Highlighted: " + dVar.toString());
            }
            Entry a2 = this.C.a(dVar);
            if (a2 == null) {
                this.S = null;
                dVar = null;
            } else {
                this.S = new d[]{dVar};
            }
            entry = a2;
        }
        setLastHighlighted(this.S);
        if (z2 && this.L != null) {
            if (!x()) {
                this.L.a();
            } else {
                this.L.a(entry, dVar);
            }
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public float[] a(d dVar) {
        return new float[]{dVar.i(), dVar.j()};
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: protected */
    public void b(Canvas canvas) {
        float f2;
        float f3;
        c cVar = this.J;
        if (cVar != null && cVar.y()) {
            fg.e b2 = this.J.b();
            this.F.setTypeface(this.J.v());
            this.F.setTextSize(this.J.w());
            this.F.setColor(this.J.x());
            this.F.setTextAlign(this.J.c());
            if (b2 == null) {
                f3 = (((float) getWidth()) - this.Q.b()) - this.J.t();
                f2 = (((float) getHeight()) - this.Q.d()) - this.J.u();
            } else {
                float f4 = b2.f27222a;
                f2 = b2.f27223b;
                f3 = f4;
            }
            canvas.drawText(this.J.a(), f3, f2, this.F);
        }
    }

    /* access modifiers changed from: protected */
    public void c(float f2, float f3) {
        T t2 = this.C;
        this.E.a(fg.i.b((t2 == null || t2.i() < 2) ? Math.max(Math.abs(f2), Math.abs(f3)) : Math.abs(f3 - f2)));
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas) {
        if (this.V != null && C() && x()) {
            int i2 = 0;
            while (true) {
                d[] dVarArr = this.S;
                if (i2 < dVarArr.length) {
                    d dVar = dVarArr[i2];
                    e a2 = this.C.a(dVar.f());
                    Entry a3 = this.C.a(this.S[i2]);
                    int b2 = a2.b(a3);
                    if (a3 != null && ((float) b2) <= ((float) a2.u()) * this.R.b()) {
                        float[] a4 = a(dVar);
                        if (this.Q.b(a4[0], a4[1])) {
                            this.V.a(a3, dVar);
                            this.V.a(canvas, a4[0], a4[1]);
                        }
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public a getAnimator() {
        return this.R;
    }

    public fg.e getCenter() {
        return fg.e.a(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    public fg.e getCenterOfView() {
        return getCenter();
    }

    public fg.e getCenterOffsets() {
        return this.Q.l();
    }

    public Bitmap getChartBitmap() {
        int i2;
        int i3;
        if (getHeight() == 0 || getWidth() == 0) {
            i3 = 420;
            i2 = 260;
        } else {
            i3 = getWidth();
            i2 = getHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public RectF getContentRect() {
        return this.Q.k();
    }

    public T getData() {
        return this.C;
    }

    public ez.d getDefaultValueFormatter() {
        return this.E;
    }

    public c getDescription() {
        return this.J;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.f14797b;
    }

    public float getExtraBottomOffset() {
        return this.f14802g;
    }

    public float getExtraLeftOffset() {
        return this.f14803h;
    }

    public float getExtraRightOffset() {
        return this.f14801f;
    }

    public float getExtraTopOffset() {
        return this.f14800e;
    }

    public d[] getHighlighted() {
        return this.S;
    }

    public f getHighlighter() {
        return this.P;
    }

    public ArrayList<Runnable> getJobs() {
        return this.W;
    }

    public Legend getLegend() {
        return this.K;
    }

    public i getLegendRenderer() {
        return this.N;
    }

    public com.github.mikephil.charting.components.d getMarker() {
        return this.V;
    }

    @Deprecated
    public com.github.mikephil.charting.components.d getMarkerView() {
        return getMarker();
    }

    public float getMaxHighlightDistance() {
        return this.T;
    }

    public com.github.mikephil.charting.listener.b getOnChartGestureListener() {
        return this.f14799d;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.M;
    }

    public g getRenderer() {
        return this.O;
    }

    public j getViewPortHandler() {
        return this.Q;
    }

    public XAxis getXAxis() {
        return this.H;
    }

    public float getXChartMax() {
        return this.H.f14942t;
    }

    public float getXChartMin() {
        return this.H.f14943u;
    }

    public float getXRange() {
        return this.H.f14944v;
    }

    public float getYMax() {
        return this.C.e();
    }

    public float getYMin() {
        return this.C.d();
    }

    public abstract void h();

    /* access modifiers changed from: protected */
    public abstract void j();

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f14805j) {
            a((View) this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.C == null) {
            if (!TextUtils.isEmpty(this.f14798c)) {
                fg.e center = getCenter();
                canvas.drawText(this.f14798c, center.f27222a, center.f27223b, this.G);
            }
        } else if (!this.f14804i) {
            j();
            this.f14804i = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            getChildAt(i6).layout(i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int a2 = (int) fg.i.a(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), resolveSize(a2, i2)), Math.max(getSuggestedMinimumHeight(), resolveSize(a2, i3)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (this.B) {
            Log.i("MPAndroidChart", "OnSizeChanged()");
        }
        if (i2 > 0 && i3 > 0 && i2 < 10000 && i3 < 10000) {
            if (this.B) {
                Log.i("MPAndroidChart", "Setting chart dimens, width: " + i2 + ", height: " + i3);
            }
            this.Q.a((float) i2, (float) i3);
        } else if (this.B) {
            Log.w("MPAndroidChart", "*Avoiding* setting chart dimens! width: " + i2 + ", height: " + i3);
        }
        h();
        Iterator<Runnable> it2 = this.W.iterator();
        while (it2.hasNext()) {
            post(it2.next());
        }
        this.W.clear();
        super.onSizeChanged(i2, i3, i4, i5);
    }

    public void setData(T t2) {
        this.C = t2;
        this.f14804i = false;
        if (t2 != null) {
            c(t2.d(), t2.e());
            for (e eVar : this.C.h()) {
                if (eVar.i() || eVar.h() == this.E) {
                    eVar.a((ez.d) this.E);
                }
            }
            h();
            if (this.B) {
                Log.i("MPAndroidChart", "Data is set.");
            }
        }
    }

    public void setDescription(c cVar) {
        this.J = cVar;
    }

    public void setDragDecelerationEnabled(boolean z2) {
        this.f14796a = z2;
    }

    public void setDragDecelerationFrictionCoef(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 >= 1.0f) {
            f2 = 0.999f;
        }
        this.f14797b = f2;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z2) {
        setDrawMarkers(z2);
    }

    public void setDrawMarkers(boolean z2) {
        this.U = z2;
    }

    public void setExtraBottomOffset(float f2) {
        this.f14802g = fg.i.a(f2);
    }

    public void setExtraLeftOffset(float f2) {
        this.f14803h = fg.i.a(f2);
    }

    public void setExtraRightOffset(float f2) {
        this.f14801f = fg.i.a(f2);
    }

    public void setExtraTopOffset(float f2) {
        this.f14800e = fg.i.a(f2);
    }

    public void setHardwareAccelerationEnabled(boolean z2) {
        setLayerType(z2 ? 2 : 1, (Paint) null);
    }

    public void setHighlightPerTapEnabled(boolean z2) {
        this.D = z2;
    }

    public void setHighlighter(fa.b bVar) {
        this.P = bVar;
    }

    /* access modifiers changed from: protected */
    public void setLastHighlighted(d[] dVarArr) {
        if (dVarArr == null || dVarArr.length <= 0 || dVarArr[0] == null) {
            this.M.a((d) null);
        } else {
            this.M.a(dVarArr[0]);
        }
    }

    public void setLogEnabled(boolean z2) {
        this.B = z2;
    }

    public void setMarker(com.github.mikephil.charting.components.d dVar) {
        this.V = dVar;
    }

    @Deprecated
    public void setMarkerView(com.github.mikephil.charting.components.d dVar) {
        setMarker(dVar);
    }

    public void setMaxHighlightDistance(float f2) {
        this.T = fg.i.a(f2);
    }

    public void setNoDataText(String str) {
        this.f14798c = str;
    }

    public void setNoDataTextColor(int i2) {
        this.G.setColor(i2);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.G.setTypeface(typeface);
    }

    public void setOnChartGestureListener(com.github.mikephil.charting.listener.b bVar) {
        this.f14799d = bVar;
    }

    public void setOnChartValueSelectedListener(com.github.mikephil.charting.listener.c cVar) {
        this.L = cVar;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.M = chartTouchListener;
    }

    public void setRenderer(g gVar) {
        if (gVar != null) {
            this.O = gVar;
        }
    }

    public void setTouchEnabled(boolean z2) {
        this.I = z2;
    }

    public void setUnbindEnabled(boolean z2) {
        this.f14805j = z2;
    }

    public boolean w() {
        return this.D;
    }

    public boolean x() {
        d[] dVarArr = this.S;
        return (dVarArr == null || dVarArr.length <= 0 || dVarArr[0] == null) ? false : true;
    }

    public boolean y() {
        return this.f14796a;
    }

    public boolean z() {
        return this.B;
    }
}
