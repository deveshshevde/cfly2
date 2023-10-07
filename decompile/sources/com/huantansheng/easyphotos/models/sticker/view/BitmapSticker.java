package com.huantansheng.easyphotos.models.sticker.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import ho.a;

public class BitmapSticker extends View {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f20468a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f20469b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f20470c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f20471d;

    /* renamed from: e  reason: collision with root package name */
    private int f20472e;

    /* renamed from: f  reason: collision with root package name */
    private Matrix f20473f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f20474g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f20475h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f20476i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f20477j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f20478k;

    /* renamed from: l  reason: collision with root package name */
    private float f20479l;

    /* renamed from: m  reason: collision with root package name */
    private float f20480m;

    /* renamed from: n  reason: collision with root package name */
    private float f20481n;

    /* renamed from: o  reason: collision with root package name */
    private float f20482o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f20483p;

    /* renamed from: q  reason: collision with root package name */
    private GestureDetector f20484q;

    /* renamed from: r  reason: collision with root package name */
    private float f20485r;

    /* renamed from: s  reason: collision with root package name */
    private float f20486s;

    /* renamed from: t  reason: collision with root package name */
    private a f20487t;

    /* renamed from: u  reason: collision with root package name */
    private Path f20488u;

    private void a(float f2, float f3, float f4, float f5) {
        this.f20479l = f2;
        this.f20480m = f3;
        this.f20481n = f4;
        this.f20482o = f5;
    }

    private void a(Canvas canvas) {
        Canvas canvas2 = canvas;
        this.f20488u.reset();
        Path path = this.f20488u;
        float[] fArr = this.f20475h;
        path.moveTo(fArr[0], fArr[1]);
        Path path2 = this.f20488u;
        float[] fArr2 = this.f20475h;
        path2.lineTo(fArr2[2], fArr2[3]);
        Path path3 = this.f20488u;
        float[] fArr3 = this.f20475h;
        path3.lineTo(fArr3[4], fArr3[5]);
        Path path4 = this.f20488u;
        float[] fArr4 = this.f20475h;
        path4.lineTo(fArr4[6], fArr4[7]);
        Path path5 = this.f20488u;
        float[] fArr5 = this.f20475h;
        path5.lineTo(fArr5[0], fArr5[1]);
        int i2 = 0;
        while (true) {
            if (i2 >= 7) {
                break;
            }
            float[] fArr6 = this.f20475h;
            if (i2 == 6) {
                canvas.drawLine(fArr6[i2], fArr6[i2 + 1], fArr6[0], fArr6[1], this.f20477j);
                break;
            }
            int i3 = i2 + 2;
            canvas.drawLine(fArr6[i2], fArr6[i2 + 1], fArr6[i3], fArr6[i2 + 3], this.f20477j);
            i2 = i3;
        }
        Bitmap bitmap = this.f20469b;
        float[] fArr7 = this.f20475h;
        float f2 = fArr7[2];
        int i4 = this.f20472e;
        canvas2.drawBitmap(bitmap, f2 - ((float) (i4 / 2)), fArr7[3] - ((float) (i4 / 2)), this.f20476i);
        Bitmap bitmap2 = this.f20471d;
        float[] fArr8 = this.f20475h;
        float f3 = fArr8[0];
        int i5 = this.f20472e;
        canvas2.drawBitmap(bitmap2, f3 - ((float) (i5 / 2)), fArr8[1] - ((float) (i5 / 2)), this.f20476i);
        Bitmap bitmap3 = this.f20470c;
        float[] fArr9 = this.f20475h;
        float f4 = fArr9[4];
        int i6 = this.f20472e;
        canvas2.drawBitmap(bitmap3, f4 - ((float) (i6 / 2)), fArr9[5] - ((float) (i6 / 2)), this.f20476i);
    }

    public float a(Point point, Point point2) {
        float f2;
        float f3 = (float) (point.x - point2.x);
        float f4 = (float) (point.y - point2.y);
        double d2 = (double) f3;
        double sqrt = Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
        Double.isNaN(d2);
        float asin = (float) ((Math.asin(d2 / sqrt) * 180.0d) / 3.141592653589793d);
        if (!Float.isNaN(asin)) {
            if (f3 >= 0.0f && f4 <= 0.0f) {
                return asin;
            }
            if (f3 <= 0.0f && f4 <= 0.0f) {
                return asin;
            }
            if (f3 <= 0.0f && f4 >= 0.0f) {
                f2 = -180.0f;
            } else if (f3 >= 0.0f && f4 >= 0.0f) {
                f2 = 180.0f;
            }
            return f2 - asin;
        }
        return 0.0f;
    }

    public boolean a() {
        return this.f20478k;
    }

    public float getScaleValue() {
        float[] fArr = this.f20474g;
        float f2 = ((fArr[8] - fArr[0]) * (fArr[8] - fArr[0])) + ((fArr[9] - fArr[1]) * (fArr[9] - fArr[1]));
        float[] fArr2 = this.f20475h;
        return (float) Math.sqrt((double) ((((fArr2[8] - fArr2[0]) * (fArr2[8] - fArr2[0])) + ((fArr2[9] - fArr2[1]) * (fArr2[9] - fArr2[1]))) / f2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.f20468a, this.f20473f, this.f20476i);
        if (this.f20478k) {
            a(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f20484q.onTouchEvent(motionEvent);
        if (1 == motionEvent.getAction() || 6 == motionEvent.getAction() || 6 == motionEvent.getAction() || 262 == motionEvent.getAction()) {
            a(0.0f, 0.0f, 0.0f, 0.0f);
            this.f20486s = 1000.0f;
            float[] fArr = this.f20475h;
            Point point = new Point((int) fArr[4], (int) fArr[5]);
            float[] fArr2 = this.f20475h;
            this.f20485r = a(point, new Point((int) fArr2[8], (int) fArr2[9]));
        }
        return !this.f20483p;
    }

    public void setOnStickerClickListener(a aVar) {
        this.f20487t = aVar;
    }

    public void setUsing(boolean z2) {
        this.f20478k = z2;
        postInvalidate();
    }
}
