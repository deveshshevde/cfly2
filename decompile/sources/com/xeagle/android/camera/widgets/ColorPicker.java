package com.xeagle.android.camera.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.xeagle.android.camera.widgets.ablum.a;
import fg.i;

public class ColorPicker extends View {
    private Matrix A;
    private float[] B = getHsv();

    /* renamed from: a  reason: collision with root package name */
    int f22369a = a.a(getContext());

    /* renamed from: b  reason: collision with root package name */
    float[] f22370b = new float[3];

    /* renamed from: c  reason: collision with root package name */
    private final int f22371c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final int f22372d = 5;

    /* renamed from: e  reason: collision with root package name */
    private final int f22373e = 10;

    /* renamed from: f  reason: collision with root package name */
    private final int f22374f = 4;

    /* renamed from: g  reason: collision with root package name */
    private Paint f22375g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f22376h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f22377i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f22378j;

    /* renamed from: k  reason: collision with root package name */
    private RectF f22379k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f22380l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f22381m;

    /* renamed from: n  reason: collision with root package name */
    private RectF f22382n;

    /* renamed from: o  reason: collision with root package name */
    private RectF f22383o;

    /* renamed from: p  reason: collision with root package name */
    private Path f22384p;

    /* renamed from: q  reason: collision with root package name */
    private Path f22385q;

    /* renamed from: r  reason: collision with root package name */
    private Path f22386r;

    /* renamed from: s  reason: collision with root package name */
    private Bitmap f22387s;

    /* renamed from: t  reason: collision with root package name */
    private int f22388t;

    /* renamed from: u  reason: collision with root package name */
    private int f22389u;

    /* renamed from: v  reason: collision with root package name */
    private int f22390v;

    /* renamed from: w  reason: collision with root package name */
    private int f22391w;

    /* renamed from: x  reason: collision with root package name */
    private int f22392x;

    /* renamed from: y  reason: collision with root package name */
    private int f22393y;

    /* renamed from: z  reason: collision with root package name */
    private int f22394z;

    public ColorPicker(Context context) {
        super(context);
        a();
    }

    public ColorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ColorPicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private Bitmap a(int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[13];
        float[] fArr = {0.0f, 1.0f, 1.0f};
        for (int i4 = 0; i4 < 13; i4++) {
            fArr[0] = (float) (((i4 * 30) + 180) % SpatialRelationUtil.A_CIRCLE_DEGREE);
            iArr[i4] = Color.HSVToColor(fArr);
        }
        iArr[12] = iArr[0];
        float f2 = (float) (i2 / 2);
        float f3 = (float) (i3 / 2);
        this.f22375g.setShader(new ComposeShader(new SweepGradient(f2, f3, iArr, (float[]) null), new RadialGradient(f2, f3, (float) this.f22394z, -1, 16777215, Shader.TileMode.CLAMP), PorterDuff.Mode.SRC_OVER));
        new Canvas(createBitmap).drawCircle(f2, f3, (float) this.f22394z, this.f22375g);
        return createBitmap;
    }

    private void a() {
        Paint paint = new Paint();
        this.f22378j = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f22378j.setStrokeWidth(2.0f);
        this.f22378j.setARGB(128, 0, 0, 0);
        Paint paint2 = new Paint();
        this.f22380l = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f22380l.setStrokeWidth(2.0f);
        this.f22381m = new Paint();
        Paint paint3 = new Paint();
        this.f22375g = paint3;
        paint3.setAntiAlias(true);
        this.f22375g.setDither(true);
        Paint paint4 = new Paint();
        this.f22376h = paint4;
        paint4.setAntiAlias(true);
        this.f22376h.setDither(true);
        Paint paint5 = new Paint();
        this.f22377i = paint5;
        paint5.setAntiAlias(true);
        this.f22384p = new Path();
        this.f22385q = new Path();
        this.f22386r = new Path();
        this.f22382n = new RectF();
        this.f22383o = new RectF();
        this.f22379k = new RectF();
    }

    private void a(Canvas canvas) {
        Canvas canvas2 = canvas;
        double d2 = (double) (this.B[2] - 0.5f);
        Double.isNaN(d2);
        double d3 = d2 * 3.141592653589793d;
        double d4 = d3 + 0.032724923474893676d;
        double d5 = d3 - 0.032724923474893676d;
        double cos = Math.cos(d3);
        double d6 = (double) this.f22392x;
        Double.isNaN(d6);
        double d7 = cos * d6;
        double sin = Math.sin(d3);
        double d8 = (double) this.f22392x;
        Double.isNaN(d8);
        double d9 = sin * d8;
        double cos2 = Math.cos(d4);
        double d10 = (double) (this.f22392x + this.f22391w);
        Double.isNaN(d10);
        double d11 = cos2 * d10;
        double sin2 = Math.sin(d4);
        double d12 = (double) (this.f22392x + this.f22391w);
        Double.isNaN(d12);
        double d13 = sin2 * d12;
        double cos3 = Math.cos(d5);
        int height = getHeight() / 2;
        double d14 = d13;
        double d15 = (double) (this.f22392x + this.f22391w);
        Double.isNaN(d15);
        double d16 = cos3 * d15;
        double sin3 = Math.sin(d5);
        double d17 = (double) (this.f22392x + this.f22391w);
        Double.isNaN(d17);
        double d18 = sin3 * d17;
        this.f22386r.reset();
        float width = (float) (getWidth() / 2);
        float f2 = ((float) d7) + width;
        float f3 = (float) height;
        float f4 = ((float) d9) + f3;
        this.f22386r.moveTo(f2, f4);
        this.f22386r.lineTo(((float) d11) + width, ((float) d14) + f3);
        this.f22386r.lineTo(((float) d16) + width, ((float) d18) + f3);
        this.f22386r.lineTo(f2, f4);
        this.f22381m.setColor(Color.HSVToColor(this.B));
        this.f22381m.setStyle(Paint.Style.FILL);
        Canvas canvas3 = canvas;
        canvas3.drawPath(this.f22386r, this.f22381m);
        this.f22381m.setStyle(Paint.Style.STROKE);
        this.f22381m.setStrokeJoin(Paint.Join.ROUND);
        this.f22381m.setColor(-16777216);
        canvas3.drawPath(this.f22386r, this.f22381m);
    }

    public int getColor() {
        return Color.HSVToColor(this.B);
    }

    public float[] getHsv() {
        Color.colorToHSV(this.f22369a, this.f22370b);
        return this.f22370b;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        Bitmap bitmap = this.f22387s;
        int i2 = this.f22394z;
        canvas2.drawBitmap(bitmap, (float) (width - i2), (float) (height - i2), (Paint) null);
        this.f22377i.setColor(Color.HSVToColor(this.B));
        canvas2.drawPath(this.f22384p, this.f22377i);
        float[] fArr = this.B;
        float f2 = (float) width;
        float f3 = (float) height;
        SweepGradient sweepGradient = new SweepGradient(f2, f3, new int[]{-16777216, Color.HSVToColor(new float[]{fArr[0], fArr[1], 1.0f}), -1}, (float[]) null);
        sweepGradient.setLocalMatrix(this.A);
        this.f22376h.setShader(sweepGradient);
        canvas2.drawPath(this.f22385q, this.f22376h);
        double radians = (double) ((float) Math.toRadians((double) this.B[0]));
        double d2 = (double) this.B[1];
        Double.isNaN(d2);
        double d3 = (-Math.cos(radians)) * d2;
        double d4 = (double) this.f22394z;
        Double.isNaN(d4);
        int i3 = ((int) (d3 * d4)) + width;
        double d5 = (double) this.B[1];
        Double.isNaN(d5);
        double d6 = (-Math.sin(radians)) * d5;
        int i4 = this.f22394z;
        double d7 = (double) i4;
        Double.isNaN(d7);
        int i5 = ((int) (d6 * d7)) + height;
        float f4 = ((float) i4) * 0.075f;
        float f5 = (float) i3;
        float f6 = f4 / 2.0f;
        float f7 = (float) ((int) (f5 - f6));
        float f8 = (float) ((int) (((float) i5) - f6));
        this.f22379k.set(f7, f8, f7 + f4, f4 + f8);
        canvas2.drawOval(this.f22379k, this.f22378j);
        this.f22380l.setColor(Color.HSVToColor(new float[]{0.0f, 0.0f, 1.0f - this.B[2]}));
        double d8 = (double) (this.B[2] - 0.5f);
        Double.isNaN(d8);
        double d9 = d8 * 3.141592653589793d;
        float cos = (float) Math.cos(d9);
        float sin = (float) Math.sin(d9);
        int i6 = this.f22393y;
        float f9 = (((float) i6) * sin) + f3;
        int i7 = this.f22392x;
        canvas.drawLine((((float) i6) * cos) + f2, f9, (cos * ((float) i7)) + f2, (sin * ((float) i7)) + f3, this.f22380l);
        if (this.f22391w > 0) {
            a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int min = Math.min(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        setMeasuredDimension(min, min);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.B = bundle.getFloatArray("color");
            parcelable = bundle.getParcelable("super");
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putFloatArray("color", this.B);
        bundle.putParcelable("super", super.onSaveInstanceState());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int i6 = i2 / 2;
        int i7 = i3 / 2;
        int i8 = (i2 * 5) / 100;
        this.f22389u = i8;
        int i9 = (i2 * 2) / 100;
        this.f22390v = i9;
        int i10 = (i2 * 4) / 100;
        this.f22391w = i10;
        int i11 = (i2 * 10) / 100;
        this.f22388t = i11;
        int i12 = (i6 - i9) - i10;
        this.f22392x = i12;
        int i13 = i12 - i11;
        this.f22393y = i13;
        this.f22394z = i13 - i8;
        this.f22382n.set((float) (i6 - i12), (float) (i7 - i12), (float) (i6 + i12), (float) (i12 + i7));
        RectF rectF = this.f22383o;
        int i14 = this.f22393y;
        rectF.set((float) (i6 - i14), (float) (i7 - i14), (float) (i6 + i14), (float) (i14 + i7));
        int i15 = this.f22394z;
        this.f22387s = a(i15 * 2, i15 * 2);
        Matrix matrix = new Matrix();
        this.A = matrix;
        matrix.preRotate(270.0f, (float) i6, (float) i7);
        this.f22384p.arcTo(this.f22382n, 270.0f, -180.0f);
        this.f22384p.arcTo(this.f22383o, 90.0f, 180.0f);
        this.f22385q.arcTo(this.f22382n, 270.0f, 180.0f);
        this.f22385q.arcTo(this.f22383o, 90.0f, -180.0f);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && action != 2) {
            return super.onTouchEvent(motionEvent);
        }
        int x2 = (int) motionEvent.getX();
        int width = x2 - (getWidth() / 2);
        int y2 = ((int) motionEvent.getY()) - (getHeight() / 2);
        double sqrt = Math.sqrt((double) ((width * width) + (y2 * y2)));
        if (sqrt <= ((double) this.f22394z)) {
            this.B[0] = (float) (Math.toDegrees(Math.atan2((double) y2, (double) width)) + 180.0d);
            float[] fArr = this.B;
            double d2 = (double) this.f22394z;
            Double.isNaN(d2);
            fArr[1] = Math.max(0.0f, Math.min(1.0f, (float) (sqrt / d2)));
        } else {
            if (x2 >= getWidth() / 2 && sqrt >= ((double) this.f22393y)) {
                this.B[2] = (float) Math.max(i.f27244a, Math.min(1.0d, (Math.atan2((double) y2, (double) width) / 3.141592653589793d) + 0.5d));
            }
            return true;
        }
        invalidate();
        return true;
    }

    public void setColor(int i2) {
        Color.colorToHSV(i2, this.B);
    }
}
