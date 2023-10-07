package com.xeagle.android.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.cfly.uav_pro.R;
import ef.a;
import fg.i;

public class DroneIndicatorView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f25575a;

    /* renamed from: b  reason: collision with root package name */
    private float f25576b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f25577c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f25578d;

    /* renamed from: e  reason: collision with root package name */
    private a f25579e;

    /* renamed from: f  reason: collision with root package name */
    private a f25580f;

    /* renamed from: g  reason: collision with root package name */
    private float f25581g;

    /* renamed from: h  reason: collision with root package name */
    private float f25582h;

    /* renamed from: i  reason: collision with root package name */
    private float f25583i;

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f25584j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f25585k;

    /* renamed from: l  reason: collision with root package name */
    private float f25586l;

    /* renamed from: m  reason: collision with root package name */
    private Matrix f25587m;

    /* renamed from: n  reason: collision with root package name */
    private Context f25588n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f25589o;

    public DroneIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25588n = context;
        a();
        a(0.0f, 0.0f, 1);
        a(new a(i.f27244a, i.f27244a), new a(i.f27244a, i.f27244a));
    }

    private Bitmap a(Bitmap bitmap, float f2) {
        if (bitmap == null) {
            return null;
        }
        this.f25587m.setRotate(f2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), this.f25587m, false);
    }

    private void a() {
        this.f25587m = new Matrix();
        this.f25577c = new Paint();
        this.f25578d = new RectF();
        this.f25577c.setAntiAlias(true);
        this.f25577c.setStyle(Paint.Style.STROKE);
        this.f25577c.setColor(-7829368);
        this.f25577c.setStrokeWidth(3.0f);
        this.f25584j = BitmapFactory.decodeResource(getResources(), R.drawable.newui_small_map_drone_direct);
        this.f25585k = BitmapFactory.decodeResource(getResources(), R.drawable.newui_small_map_rc);
    }

    private void a(Canvas canvas) {
        Bitmap bitmap = this.f25585k;
        canvas.drawBitmap(bitmap, (this.f25583i - ((float) (bitmap.getWidth() / 2))) + ((float) (getPaddingLeft() / 2)), this.f25583i - ((float) this.f25585k.getHeight()), this.f25577c);
    }

    private void b(Canvas canvas) {
        Bitmap a2;
        float f2;
        double d2;
        double d3;
        int paddingLeft;
        if (this.f25589o) {
            canvas.save();
            float f3 = this.f25586l;
            if (f3 == 0.0f) {
                a2 = a(this.f25584j, this.f25575a);
                float f4 = this.f25583i;
                double d4 = (double) f4;
                double d5 = (double) f4;
                double d6 = (double) (this.f25586l / 180.0f);
                Double.isNaN(d6);
                double cos = Math.cos(d6 * 3.141592653589793d);
                Double.isNaN(d5);
                Double.isNaN(d4);
                double d7 = d4 - (d5 * cos);
                double width = (double) (this.f25584j.getWidth() / 2);
                Double.isNaN(width);
                d3 = d7 - width;
                paddingLeft = (getPaddingLeft() / 3) * 2;
            } else if (f3 == 180.0f) {
                a2 = a(this.f25584j, this.f25575a);
                float f5 = this.f25583i;
                double d8 = (double) f5;
                double d9 = (double) f5;
                double d10 = (double) (this.f25586l / 180.0f);
                Double.isNaN(d10);
                double cos2 = Math.cos(d10 * 3.141592653589793d);
                Double.isNaN(d9);
                Double.isNaN(d8);
                double d11 = d8 - (d9 * cos2);
                double width2 = (double) (this.f25584j.getWidth() / 2);
                Double.isNaN(width2);
                d3 = d11 - width2;
                paddingLeft = getPaddingLeft() / 5;
            } else {
                a2 = a(this.f25584j, this.f25575a);
                float f6 = this.f25583i;
                double d12 = (double) f6;
                double d13 = (double) f6;
                double d14 = (double) (this.f25586l / 180.0f);
                Double.isNaN(d14);
                double cos3 = Math.cos(d14 * 3.141592653589793d);
                Double.isNaN(d13);
                Double.isNaN(d12);
                double d15 = d12 - (d13 * cos3);
                double width3 = (double) (this.f25584j.getWidth() / 2);
                Double.isNaN(width3);
                double d16 = d15 - width3;
                double paddingLeft2 = (double) (getPaddingLeft() / 3);
                Double.isNaN(paddingLeft2);
                f2 = (float) (d16 + paddingLeft2);
                float f7 = this.f25583i;
                double d17 = (double) f7;
                double d18 = (double) f7;
                double d19 = (double) (this.f25586l / 180.0f);
                Double.isNaN(d19);
                double sin = Math.sin(d19 * 3.141592653589793d);
                Double.isNaN(d18);
                Double.isNaN(d17);
                double height = (double) (this.f25584j.getHeight() / 2);
                Double.isNaN(height);
                double d20 = (d17 - (d18 * sin)) - height;
                double paddingTop = (double) getPaddingTop();
                Double.isNaN(paddingTop);
                d2 = d20 + paddingTop;
                canvas.drawBitmap(a2, f2, (float) d2, this.f25577c);
                canvas.restore();
            }
            double d21 = (double) paddingLeft;
            Double.isNaN(d21);
            f2 = (float) (d3 + d21);
            float f8 = this.f25583i;
            double d22 = (double) f8;
            double d23 = (double) f8;
            double d24 = (double) (this.f25586l / 180.0f);
            Double.isNaN(d24);
            double sin2 = Math.sin(d24 * 3.141592653589793d);
            Double.isNaN(d23);
            Double.isNaN(d22);
            double height2 = (double) (this.f25584j.getHeight() / 2);
            Double.isNaN(height2);
            d2 = (d22 - (d23 * sin2)) - height2;
            canvas.drawBitmap(a2, f2, (float) d2, this.f25577c);
            canvas.restore();
        }
    }

    private boolean b(a aVar, a aVar2) {
        return (aVar == null || aVar2 == null || aVar.d() == i.f27244a || aVar.c() == i.f27244a || aVar2.c() == i.f27244a || aVar2.d() == i.f27244a) ? false : true;
    }

    public void a(float f2, float f3, int i2) {
        float f4 = (((f2 - f3) + 90.0f) + 180.0f) % 360.0f;
        this.f25575a = f4;
        if (f4 < 0.0f) {
            this.f25575a = f4 + 360.0f;
        }
    }

    public void a(a aVar, a aVar2) {
        float f2;
        this.f25579e = aVar;
        this.f25580f = aVar2;
        if (!b(aVar, aVar2)) {
            f2 = 90.0f;
        } else {
            float d2 = (float) eg.a.d(aVar, aVar2);
            this.f25586l = d2;
            if (d2 < 180.0f || d2 > 270.0f) {
                if (d2 > 270.0f && d2 <= 360.0f) {
                    f2 = 0.0f;
                }
                postInvalidate();
            }
            this.f25586l = 180.0f;
            postInvalidate();
        }
        this.f25586l = f2;
        postInvalidate();
    }

    public void a(a aVar, a aVar2, float f2) {
        this.f25579e = aVar;
        this.f25580f = aVar2;
        float f3 = 90.0f;
        if (b(aVar, aVar2) && eg.a.c(aVar2, aVar).a() > 10.0d) {
            float d2 = (float) eg.a.d(aVar2, aVar);
            this.f25586l = d2;
            float f4 = d2 - f2;
            this.f25586l = f4;
            float f5 = f4 % 360.0f;
            this.f25586l = f5;
            if (f5 < 0.0f) {
                this.f25586l = f5 + 360.0f;
            }
            float f6 = this.f25586l;
            f3 = 180.0f;
            if (f6 < 180.0f || f6 > 270.0f) {
                if (f6 > 270.0f && f6 <= 360.0f) {
                    this.f25586l = 0.0f;
                }
                postInvalidate();
            }
        }
        this.f25586l = f3;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f25578d, 180.0f, 180.0f, true, this.f25577c);
        a(canvas);
        b(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        float f2 = this.f25583i;
        this.f25578d.set((float) getPaddingLeft(), (float) getPaddingTop(), f2 * 2.0f, f2 * 2.0f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f25581g = (float) ((i3 - getPaddingTop()) / 2);
        float paddingLeft = (float) (((i2 - getPaddingLeft()) - getPaddingRight()) / 2);
        this.f25582h = paddingLeft;
        this.f25583i = Math.min(this.f25581g * 2.0f, paddingLeft);
    }

    public void setConnected(boolean z2) {
        this.f25589o = z2;
        postInvalidate();
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPhoneYaw(float f2) {
        if (this.f25576b != f2) {
            this.f25576b = f2;
            postInvalidate();
        }
    }
}
