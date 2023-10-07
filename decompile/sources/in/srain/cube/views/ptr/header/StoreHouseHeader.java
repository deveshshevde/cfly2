package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import com.blankj.utilcode.constant.MemoryConstants;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.b;
import java.util.ArrayList;

public class StoreHouseHeader extends View implements b {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f13689a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private int f13690b = -1;

    /* renamed from: c  reason: collision with root package name */
    private float f13691c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private int f13692d = -1;

    /* renamed from: e  reason: collision with root package name */
    private float f13693e = 0.7f;

    /* renamed from: f  reason: collision with root package name */
    private int f13694f = -1;

    /* renamed from: g  reason: collision with root package name */
    private float f13695g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private int f13696h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f13697i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f13698j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f13699k = 0;

    /* renamed from: l  reason: collision with root package name */
    private float f13700l = 0.4f;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f13701m = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f13702n = 0.4f;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f13703o = 1000;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f13704p = 1000;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f13705q = 400;

    /* renamed from: r  reason: collision with root package name */
    private Transformation f13706r = new Transformation();

    /* renamed from: s  reason: collision with root package name */
    private boolean f13707s = false;

    /* renamed from: t  reason: collision with root package name */
    private a f13708t = new a();

    /* renamed from: u  reason: collision with root package name */
    private int f13709u = -1;

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f13711b;

        /* renamed from: c  reason: collision with root package name */
        private int f13712c;

        /* renamed from: d  reason: collision with root package name */
        private int f13713d;

        /* renamed from: e  reason: collision with root package name */
        private int f13714e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f13715f;

        private a() {
            this.f13711b = 0;
            this.f13712c = 0;
            this.f13713d = 0;
            this.f13714e = 0;
            this.f13715f = true;
        }

        /* access modifiers changed from: private */
        public void a() {
            this.f13715f = true;
            this.f13711b = 0;
            this.f13714e = StoreHouseHeader.this.f13703o / StoreHouseHeader.this.f13689a.size();
            this.f13712c = StoreHouseHeader.this.f13704p / this.f13714e;
            this.f13713d = (StoreHouseHeader.this.f13689a.size() / this.f13712c) + 1;
            run();
        }

        /* access modifiers changed from: private */
        public void b() {
            this.f13715f = false;
            StoreHouseHeader.this.removeCallbacks(this);
        }

        public void run() {
            int i2 = this.f13711b % this.f13712c;
            for (int i3 = 0; i3 < this.f13713d; i3++) {
                int i4 = (this.f13712c * i3) + i2;
                if (i4 <= this.f13711b) {
                    b bVar = StoreHouseHeader.this.f13689a.get(i4 % StoreHouseHeader.this.f13689a.size());
                    bVar.setFillAfter(false);
                    bVar.setFillEnabled(true);
                    bVar.setFillBefore(false);
                    bVar.setDuration((long) StoreHouseHeader.this.f13705q);
                    bVar.a(StoreHouseHeader.this.f13701m, StoreHouseHeader.this.f13702n);
                }
            }
            this.f13711b++;
            if (this.f13715f) {
                StoreHouseHeader.this.postDelayed(this, (long) this.f13714e);
            }
        }
    }

    public StoreHouseHeader(Context context) {
        super(context);
        a();
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        lr.b.a(getContext());
        this.f13690b = lr.b.a(1.0f);
        this.f13692d = lr.b.a(40.0f);
        this.f13694f = lr.b.f30988a / 2;
    }

    private void b() {
        this.f13707s = true;
        this.f13708t.a();
        invalidate();
    }

    private void c() {
        this.f13707s = false;
        this.f13708t.b();
    }

    private int getBottomOffset() {
        return getPaddingBottom() + lr.b.a(10.0f);
    }

    private int getTopOffset() {
        return getPaddingTop() + lr.b.a(10.0f);
    }

    private void setProgress(float f2) {
        this.f13695g = f2;
    }

    public void a(PtrFrameLayout ptrFrameLayout) {
        c();
        for (int i2 = 0; i2 < this.f13689a.size(); i2++) {
            this.f13689a.get(i2).a(this.f13694f);
        }
    }

    public void a(PtrFrameLayout ptrFrameLayout, boolean z2, byte b2, lq.a aVar) {
        setProgress(Math.min(1.0f, aVar.w()));
        invalidate();
    }

    public void b(PtrFrameLayout ptrFrameLayout) {
    }

    public void c(PtrFrameLayout ptrFrameLayout) {
        b();
    }

    public void d(PtrFrameLayout ptrFrameLayout) {
        c();
    }

    public int getLoadingAniDuration() {
        return this.f13703o;
    }

    public float getScale() {
        return this.f13691c;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.f13695g;
        int save = canvas.save();
        int size = this.f13689a.size();
        for (int i2 = 0; i2 < size; i2++) {
            canvas.save();
            b bVar = this.f13689a.get(i2);
            float f3 = ((float) this.f13698j) + bVar.f13771a.x;
            float f4 = ((float) this.f13699k) + bVar.f13771a.y;
            if (this.f13707s) {
                bVar.getTransformation(getDrawingTime(), this.f13706r);
                canvas.translate(f3, f4);
            } else {
                float f5 = 0.0f;
                if (f2 == 0.0f) {
                    bVar.a(this.f13694f);
                } else {
                    float f6 = this.f13693e;
                    float f7 = ((1.0f - f6) * ((float) i2)) / ((float) size);
                    float f8 = (1.0f - f6) - f7;
                    if (f2 == 1.0f || f2 >= 1.0f - f8) {
                        canvas.translate(f3, f4);
                        bVar.a(this.f13700l);
                    } else {
                        if (f2 > f7) {
                            f5 = Math.min(1.0f, (f2 - f7) / f6);
                        }
                        float f9 = 1.0f - f5;
                        float f10 = f3 + (bVar.f13772b * f9);
                        float f11 = f4 + (((float) (-this.f13692d)) * f9);
                        Matrix matrix = new Matrix();
                        matrix.postRotate(360.0f * f5);
                        matrix.postScale(f5, f5);
                        matrix.postTranslate(f10, f11);
                        bVar.a(this.f13700l * f5);
                        canvas.concat(matrix);
                    }
                }
            }
            bVar.a(canvas);
            canvas.restore();
        }
        if (this.f13707s) {
            invalidate();
        }
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getTopOffset() + this.f13697i + getBottomOffset(), MemoryConstants.GB));
        this.f13698j = (getMeasuredWidth() - this.f13696h) / 2;
        this.f13699k = getTopOffset();
        this.f13692d = getTopOffset();
    }

    public void setLoadingAniDuration(int i2) {
        this.f13703o = i2;
        this.f13704p = i2;
    }

    public void setScale(float f2) {
        this.f13691c = f2;
    }
}
