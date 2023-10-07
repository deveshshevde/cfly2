package com.huantansheng.easyphotos.models.puzzle;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.huantansheng.easyphotos.models.puzzle.Line;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static Xfermode f20389a = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    /* renamed from: b  reason: collision with root package name */
    private Drawable f20390b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f20391c;

    /* renamed from: d  reason: collision with root package name */
    private Matrix f20392d;

    /* renamed from: e  reason: collision with root package name */
    private a f20393e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f20394f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f20395g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f20396h;

    /* renamed from: i  reason: collision with root package name */
    private float f20397i;

    /* renamed from: j  reason: collision with root package name */
    private float f20398j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f20399k;

    /* renamed from: l  reason: collision with root package name */
    private final PointF f20400l;

    /* renamed from: m  reason: collision with root package name */
    private final PointF f20401m;

    /* renamed from: n  reason: collision with root package name */
    private ValueAnimator f20402n;

    /* renamed from: o  reason: collision with root package name */
    private int f20403o = 300;

    /* renamed from: p  reason: collision with root package name */
    private Matrix f20404p;

    d(Drawable drawable, a aVar, Matrix matrix) {
        this.f20390b = drawable;
        this.f20393e = aVar;
        this.f20391c = matrix;
        this.f20392d = new Matrix();
        this.f20394f = new Rect(0, 0, c(), d());
        this.f20395g = new float[]{0.0f, 0.0f, (float) c(), 0.0f, (float) c(), (float) d(), 0.0f, (float) d()};
        this.f20396h = new float[8];
        this.f20399k = new RectF();
        this.f20400l = new PointF(aVar.e(), aVar.f());
        this.f20401m = new PointF();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f20402n = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        this.f20404p = new Matrix();
    }

    private void a(Canvas canvas, int i2, boolean z2) {
        if (this.f20390b instanceof BitmapDrawable) {
            int saveLayer = canvas.saveLayer((RectF) null, (Paint) null, 31);
            Bitmap bitmap = ((BitmapDrawable) this.f20390b).getBitmap();
            Paint paint = ((BitmapDrawable) this.f20390b).getPaint();
            paint.setColor(-1);
            paint.setAlpha(i2);
            if (z2) {
                canvas.drawPath(this.f20393e.h(), paint);
                paint.setXfermode(f20389a);
            }
            canvas.drawBitmap(bitmap, this.f20391c, paint);
            paint.setXfermode((Xfermode) null);
            canvas.restoreToCount(saveLayer);
            return;
        }
        canvas.save();
        if (z2) {
            canvas.clipPath(this.f20393e.h());
        }
        canvas.concat(this.f20391c);
        this.f20390b.setBounds(this.f20394f);
        this.f20390b.setAlpha(i2);
        this.f20390b.draw(canvas);
        canvas.restore();
    }

    private void a(final View view, final float f2, final float f3) {
        this.f20402n.end();
        this.f20402n.removeAllUpdateListeners();
        this.f20402n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.b(f2 * ((Float) valueAnimator.getAnimatedValue()).floatValue(), f3 * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                view.invalidate();
            }
        });
        this.f20402n.setDuration((long) this.f20403o);
        this.f20402n.start();
    }

    /* access modifiers changed from: private */
    public void b(float f2, float f3, PointF pointF) {
        this.f20391c.set(this.f20392d);
        a(f2, f3, pointF);
    }

    private RectF m() {
        this.f20391c.mapRect(this.f20399k, new RectF(this.f20394f));
        return this.f20399k;
    }

    private PointF n() {
        m();
        this.f20401m.x = this.f20399k.centerX();
        this.f20401m.y = this.f20399k.centerY();
        return this.f20401m;
    }

    private float o() {
        return b.a(this.f20391c);
    }

    public a a() {
        return this.f20393e;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        this.f20397i = f2;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, PointF pointF) {
        this.f20391c.postScale(f2, f3, pointF.x, pointF.y);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, PointF pointF, float f4, float f5) {
        this.f20391c.set(this.f20392d);
        c(f4, f5);
        a(f2, f3, pointF);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.f20403o = i2;
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        a(canvas, 255, true);
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, int i2) {
        a(canvas, i2, false);
    }

    /* access modifiers changed from: package-private */
    public void a(Matrix matrix) {
        this.f20391c.set(matrix);
        a((View) null);
    }

    public void a(Drawable drawable) {
        this.f20390b = drawable;
        this.f20394f = new Rect(0, 0, c(), d());
        this.f20395g = new float[]{0.0f, 0.0f, (float) c(), 0.0f, (float) c(), (float) d(), 0.0f, (float) d()};
    }

    /* access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent, Line line) {
        float x2 = (motionEvent.getX() - this.f20397i) / 2.0f;
        float y2 = (motionEvent.getY() - this.f20398j) / 2.0f;
        if (!h()) {
            a a2 = a();
            float a3 = b.a(this) / o();
            a(a3, a3, a2.g());
            i();
            this.f20397i = motionEvent.getX();
            this.f20398j = motionEvent.getY();
        }
        if (line.g() == Line.Direction.HORIZONTAL) {
            b(0.0f, y2);
        } else if (line.g() == Line.Direction.VERTICAL) {
            b(x2, 0.0f);
        }
        RectF m2 = m();
        a a4 = a();
        float b2 = m2.top > a4.b() ? a4.b() - m2.top : 0.0f;
        if (m2.bottom < a4.d()) {
            b2 = a4.d() - m2.bottom;
        }
        float a5 = m2.left > a4.a() ? a4.a() - m2.left : 0.0f;
        if (m2.right < a4.c()) {
            a5 = a4.c() - m2.right;
        }
        if (a5 != 0.0f || b2 != 0.0f) {
            this.f20397i = motionEvent.getX();
            this.f20398j = motionEvent.getY();
            c(a5, b2);
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        if (!g()) {
            i();
            RectF m2 = m();
            float f2 = 0.0f;
            float a2 = m2.left > this.f20393e.a() ? this.f20393e.a() - m2.left : 0.0f;
            if (m2.top > this.f20393e.b()) {
                f2 = this.f20393e.b() - m2.top;
            }
            if (m2.right < this.f20393e.c()) {
                a2 = this.f20393e.c() - m2.right;
            }
            if (m2.bottom < this.f20393e.d()) {
                f2 = this.f20393e.d() - m2.bottom;
            }
            if (view == null) {
                c(a2, f2);
            } else {
                a(view, a2, f2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, boolean z2) {
        if (!g()) {
            i();
            final float o2 = o();
            final float a2 = b.a(this);
            final PointF pointF = new PointF();
            pointF.set(n());
            this.f20404p.set(this.f20391c);
            float f2 = a2 / o2;
            this.f20404p.postScale(f2, f2, pointF.x, pointF.y);
            RectF rectF = new RectF(this.f20394f);
            this.f20404p.mapRect(rectF);
            float f3 = 0.0f;
            float a3 = rectF.left > this.f20393e.a() ? this.f20393e.a() - rectF.left : 0.0f;
            if (rectF.top > this.f20393e.b()) {
                f3 = this.f20393e.b() - rectF.top;
            }
            if (rectF.right < this.f20393e.c()) {
                a3 = this.f20393e.c() - rectF.right;
            }
            float f4 = a3;
            float d2 = rectF.bottom < this.f20393e.d() ? this.f20393e.d() - rectF.bottom : f3;
            this.f20402n.end();
            this.f20402n.removeAllUpdateListeners();
            final float f5 = f4;
            final float f6 = d2;
            final View view2 = view;
            this.f20402n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float f2 = o2;
                    float f3 = (((a2 - f2) * floatValue) + f2) / f2;
                    float f4 = f5 * floatValue;
                    float f5 = f6 * floatValue;
                    d.this.b(f3, f3, pointF);
                    d.this.c(f4, f5);
                    view2.invalidate();
                }
            });
            this.f20402n.setDuration(z2 ? 0 : (long) this.f20403o);
            this.f20402n.start();
        }
    }

    public void a(a aVar) {
        this.f20393e = aVar;
    }

    public boolean a(float f2, float f3) {
        return this.f20393e.a(f2, f3);
    }

    public boolean a(Line line) {
        return this.f20393e.a(line);
    }

    public Drawable b() {
        return this.f20390b;
    }

    /* access modifiers changed from: package-private */
    public void b(float f2) {
        this.f20398j = f2;
    }

    /* access modifiers changed from: package-private */
    public void b(float f2, float f3) {
        this.f20391c.set(this.f20392d);
        c(f2, f3);
    }

    public int c() {
        return this.f20390b.getIntrinsicWidth();
    }

    /* access modifiers changed from: package-private */
    public void c(float f2) {
        this.f20391c.postRotate(f2, this.f20393e.e(), this.f20393e.f());
        float a2 = b.a(this);
        if (o() < a2) {
            PointF pointF = new PointF();
            pointF.set(n());
            a(a2 / o(), a2 / o(), pointF);
        }
        if (!b.a(this, e())) {
            float[] b2 = b.b(this);
            c(-(b2[0] + b2[2]), -(b2[1] + b2[3]));
        }
    }

    /* access modifiers changed from: package-private */
    public void c(float f2, float f3) {
        this.f20391c.postTranslate(f2, f3);
    }

    public int d() {
        return this.f20390b.getIntrinsicHeight();
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return b.b(this.f20391c);
    }

    /* access modifiers changed from: package-private */
    public float[] f() {
        this.f20391c.mapPoints(this.f20396h, this.f20395g);
        return this.f20396h;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        RectF m2 = m();
        return m2.left <= this.f20393e.a() && m2.top <= this.f20393e.b() && m2.right >= this.f20393e.c() && m2.bottom >= this.f20393e.d();
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return b.a(this.f20391c) >= b.a(this);
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.f20392d.set(this.f20391c);
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f20391c.postScale(1.0f, -1.0f, this.f20393e.e(), this.f20393e.f());
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f20391c.postScale(-1.0f, 1.0f, this.f20393e.e(), this.f20393e.f());
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f20402n.isRunning();
    }
}
