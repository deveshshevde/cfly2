package com.xeagle.android.widgets.TextViewMatch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import com.blankj.utilcode.constant.MemoryConstants;
import java.util.ArrayList;

public class MatchView extends View {
    private int A = 15;
    private float B = 25.0f;
    /* access modifiers changed from: private */
    public int C = 0;
    /* access modifiers changed from: private */
    public b D;
    /* access modifiers changed from: private */
    public c E;

    /* renamed from: a  reason: collision with root package name */
    private int f25630a;

    /* renamed from: b  reason: collision with root package name */
    private float f25631b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private int f25632c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<a> f25633d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private float f25634e = 0.7f;

    /* renamed from: f  reason: collision with root package name */
    private int f25635f;

    /* renamed from: g  reason: collision with root package name */
    private float f25636g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private int f25637h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f25638i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f25639j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f25640k = 0;

    /* renamed from: l  reason: collision with root package name */
    private float f25641l = 0.4f;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f25642m = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f25643n = 0.4f;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f25644o = 1000;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f25645p = 1000;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f25646q = 400;

    /* renamed from: r  reason: collision with root package name */
    private Transformation f25647r = new Transformation();
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f25648s = false;

    /* renamed from: t  reason: collision with root package name */
    private a f25649t = new a();

    /* renamed from: u  reason: collision with root package name */
    private int f25650u = -1;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public Handler f25651v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public float f25652w = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public float f25653x = 0.8f;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public float f25654y = 0.8f;

    /* renamed from: z  reason: collision with root package name */
    private boolean f25655z = true;

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f25658b;

        /* renamed from: c  reason: collision with root package name */
        private int f25659c;

        /* renamed from: d  reason: collision with root package name */
        private int f25660d;

        /* renamed from: e  reason: collision with root package name */
        private int f25661e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f25662f;

        private a() {
            this.f25658b = 0;
            this.f25659c = 0;
            this.f25660d = 0;
            this.f25661e = 0;
            this.f25662f = true;
        }

        /* access modifiers changed from: private */
        public void a() {
            this.f25662f = true;
            this.f25658b = 0;
            this.f25661e = MatchView.this.f25644o / MatchView.this.f25633d.size();
            this.f25659c = MatchView.this.f25645p / this.f25661e;
            this.f25660d = (MatchView.this.f25633d.size() / this.f25659c) + 1;
            run();
        }

        /* access modifiers changed from: private */
        public void b() {
            this.f25662f = false;
            MatchView.this.removeCallbacks(this);
        }

        public void run() {
            int i2 = this.f25658b % this.f25659c;
            for (int i3 = 0; i3 < this.f25660d; i3++) {
                int i4 = (this.f25659c * i3) + i2;
                if (i4 <= this.f25658b) {
                    a aVar = MatchView.this.f25633d.get(i4 % MatchView.this.f25633d.size());
                    aVar.setFillAfter(false);
                    aVar.setFillEnabled(true);
                    aVar.setFillBefore(false);
                    aVar.setDuration((long) MatchView.this.f25646q);
                    aVar.a(MatchView.this.f25642m, MatchView.this.f25643n);
                }
            }
            this.f25658b++;
            if (this.f25662f) {
                MatchView.this.postDelayed(this, (long) this.f25661e);
            }
        }
    }

    public interface b {
        void a();

        void a(float f2);

        void b();
    }

    public interface c {
        void a();

        void a(float f2);
    }

    public MatchView(Context context) {
        super(context);
        a();
    }

    public MatchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MatchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        setLayerType(1, (Paint) null);
        c.a(getContext());
        this.f25630a = c.a(1.0f);
        this.f25632c = c.a(40.0f);
        this.f25635f = c.f25673a / 2;
        setPadding(0, c.a((float) this.A), 0, c.a((float) this.A));
        this.f25651v = new Handler() {
            public void dispatchMessage(Message message) {
                Handler e2;
                float i2;
                super.dispatchMessage(message);
                if (MatchView.this.C == 1) {
                    if (MatchView.this.f25652w < 100.0f) {
                        MatchView.c(MatchView.this);
                        MatchView matchView = MatchView.this;
                        matchView.setProgress((matchView.f25652w * 1.0f) / 100.0f);
                        e2 = MatchView.this.f25651v;
                        i2 = MatchView.this.f25653x;
                    } else {
                        int unused = MatchView.this.C = 2;
                        if (MatchView.this.D != null) {
                            MatchView.this.D.b();
                            return;
                        }
                        return;
                    }
                } else if (MatchView.this.C == 2) {
                    if (MatchView.this.f25648s) {
                        MatchView.this.e();
                    }
                    if (MatchView.this.f25652w > 0.0f) {
                        MatchView.h(MatchView.this);
                        MatchView matchView2 = MatchView.this;
                        matchView2.setProgress((matchView2.f25652w * 1.0f) / 100.0f);
                        e2 = MatchView.this.f25651v;
                        i2 = MatchView.this.f25654y;
                    } else {
                        float unused2 = MatchView.this.f25652w = 0.0f;
                        if (MatchView.this.E != null) {
                            MatchView.this.E.a();
                        }
                        int unused3 = MatchView.this.C = 1;
                        return;
                    }
                } else {
                    return;
                }
                e2.sendEmptyMessageDelayed(0, (long) (i2 * 10.0f));
            }
        };
    }

    static /* synthetic */ float c(MatchView matchView) {
        float f2 = matchView.f25652w;
        matchView.f25652w = 1.0f + f2;
        return f2;
    }

    private int getBottomOffset() {
        return getPaddingBottom() + c.a(10.0f);
    }

    private int getTopOffset() {
        return getPaddingTop() + c.a(10.0f);
    }

    static /* synthetic */ float h(MatchView matchView) {
        float f2 = matchView.f25652w;
        matchView.f25652w = f2 - 1.0f;
        return f2;
    }

    public MatchView a(int i2) {
        this.f25650u = i2;
        for (int i3 = 0; i3 < this.f25633d.size(); i3++) {
            this.f25633d.get(i3).b(i2);
        }
        return this;
    }

    public void a(String str) {
        a(str, this.B);
    }

    public void a(String str, float f2) {
        a(b.a(str, f2 * 0.01f, 14));
    }

    public void a(ArrayList<float[]> arrayList) {
        boolean z2 = this.f25633d.size() > 0;
        this.f25633d.clear();
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float[] fArr = arrayList.get(i2);
            PointF pointF = new PointF(((float) c.a(fArr[0])) * this.f25631b, ((float) c.a(fArr[1])) * this.f25631b);
            PointF pointF2 = new PointF(((float) c.a(fArr[2])) * this.f25631b, ((float) c.a(fArr[3])) * this.f25631b);
            f2 = Math.max(Math.max(f2, pointF.x), pointF2.x);
            f3 = Math.max(Math.max(f3, pointF.y), pointF2.y);
            a aVar = new a(i2, pointF, pointF2, this.f25650u, this.f25630a);
            aVar.c(this.f25635f);
            this.f25633d.add(aVar);
        }
        this.f25637h = (int) Math.ceil((double) f2);
        this.f25638i = (int) Math.ceil((double) f3);
        if (z2) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.f25633d.size() != 0) {
            this.C = 1;
            this.f25651v.sendEmptyMessage(0);
            b bVar = this.D;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void d() {
        this.f25648s = true;
        this.f25649t.a();
        invalidate();
    }

    public void e() {
        this.f25648s = false;
        this.f25649t.b();
    }

    public int getLoadingAniDuration() {
        return this.f25644o;
    }

    public float getScale() {
        return this.f25631b;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.f25636g;
        int save = canvas.save();
        int size = this.f25633d.size();
        for (int i2 = 0; i2 < this.f25633d.size(); i2++) {
            canvas.save();
            a aVar = this.f25633d.get(i2);
            float f3 = ((float) this.f25639j) + aVar.f25663a.x;
            float f4 = ((float) this.f25640k) + aVar.f25663a.y;
            if (this.f25648s) {
                aVar.getTransformation(getDrawingTime(), this.f25647r);
                canvas.translate(f3, f4);
            } else {
                float f5 = 0.0f;
                if (f2 == 0.0f) {
                    aVar.c(this.f25635f);
                } else {
                    float f6 = this.f25634e;
                    float f7 = ((1.0f - f6) * ((float) i2)) / ((float) size);
                    float f8 = (1.0f - f6) - f7;
                    if (f2 == 1.0f || f2 >= 1.0f - f8) {
                        canvas.translate(f3, f4);
                        aVar.a(this.f25641l);
                    } else {
                        if (f2 > f7) {
                            f5 = Math.min(1.0f, (f2 - f7) / f6);
                        }
                        float f9 = 1.0f - f5;
                        float f10 = f3 + (aVar.f25664b * f9);
                        float f11 = f4 + (((float) (-this.f25632c)) * f9);
                        Matrix matrix = new Matrix();
                        matrix.postRotate(360.0f * f5);
                        matrix.postScale(f5, f5);
                        matrix.postTranslate(f10, f11);
                        aVar.a(this.f25641l * f5);
                        canvas.concat(matrix);
                    }
                }
            }
            aVar.a(canvas);
            canvas.restore();
        }
        if (this.f25648s) {
            invalidate();
        }
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getTopOffset() + this.f25638i + getBottomOffset(), MemoryConstants.GB));
        this.f25639j = (getMeasuredWidth() - this.f25637h) / 2;
        this.f25640k = getTopOffset();
        this.f25632c = getTopOffset();
    }

    public void setInTime(float f2) {
        this.f25653x = f2;
    }

    public void setLight(boolean z2) {
        this.f25655z = z2;
    }

    public void setLoadingAniDuration(int i2) {
        this.f25644o = i2;
        this.f25645p = i2;
    }

    public void setMatchInListener(b bVar) {
        this.D = bVar;
    }

    public void setMatchOutListener(c cVar) {
        this.E = cVar;
    }

    public void setOutTime(float f2) {
        this.f25654y = f2;
    }

    public void setPaddingTop(int i2) {
        this.A = i2;
    }

    public void setProgress(float f2) {
        b bVar = this.D;
        if (bVar == null || this.C != 1) {
            c cVar = this.E;
            if (cVar != null && this.C == 2) {
                cVar.a(f2);
            }
        } else {
            bVar.a(f2);
        }
        if (f2 == 1.0f) {
            if (this.f25655z) {
                d();
            }
        } else if (this.f25648s) {
            e();
        }
        this.f25636g = f2;
        postInvalidate();
    }

    public void setScale(float f2) {
        this.f25631b = f2;
    }

    public void setTextSize(float f2) {
        this.B = f2;
    }
}
