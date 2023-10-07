package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import s.f;

public class b extends Drawable implements Animatable {

    /* renamed from: c  reason: collision with root package name */
    private static final Interpolator f4572c = new LinearInterpolator();

    /* renamed from: d  reason: collision with root package name */
    private static final Interpolator f4573d = new aa.b();

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f4574e = {-16777216};

    /* renamed from: a  reason: collision with root package name */
    float f4575a;

    /* renamed from: b  reason: collision with root package name */
    boolean f4576b;

    /* renamed from: f  reason: collision with root package name */
    private final a f4577f;

    /* renamed from: g  reason: collision with root package name */
    private float f4578g;

    /* renamed from: h  reason: collision with root package name */
    private Resources f4579h;

    /* renamed from: i  reason: collision with root package name */
    private Animator f4580i;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final RectF f4585a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        final Paint f4586b;

        /* renamed from: c  reason: collision with root package name */
        final Paint f4587c;

        /* renamed from: d  reason: collision with root package name */
        final Paint f4588d;

        /* renamed from: e  reason: collision with root package name */
        float f4589e;

        /* renamed from: f  reason: collision with root package name */
        float f4590f;

        /* renamed from: g  reason: collision with root package name */
        float f4591g;

        /* renamed from: h  reason: collision with root package name */
        float f4592h;

        /* renamed from: i  reason: collision with root package name */
        int[] f4593i;

        /* renamed from: j  reason: collision with root package name */
        int f4594j;

        /* renamed from: k  reason: collision with root package name */
        float f4595k;

        /* renamed from: l  reason: collision with root package name */
        float f4596l;

        /* renamed from: m  reason: collision with root package name */
        float f4597m;

        /* renamed from: n  reason: collision with root package name */
        boolean f4598n;

        /* renamed from: o  reason: collision with root package name */
        Path f4599o;

        /* renamed from: p  reason: collision with root package name */
        float f4600p;

        /* renamed from: q  reason: collision with root package name */
        float f4601q;

        /* renamed from: r  reason: collision with root package name */
        int f4602r;

        /* renamed from: s  reason: collision with root package name */
        int f4603s;

        /* renamed from: t  reason: collision with root package name */
        int f4604t;

        /* renamed from: u  reason: collision with root package name */
        int f4605u;

        a() {
            Paint paint = new Paint();
            this.f4586b = paint;
            Paint paint2 = new Paint();
            this.f4587c = paint2;
            Paint paint3 = new Paint();
            this.f4588d = paint3;
            this.f4589e = 0.0f;
            this.f4590f = 0.0f;
            this.f4591g = 0.0f;
            this.f4592h = 5.0f;
            this.f4600p = 1.0f;
            this.f4604t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f4593i[b()];
        }

        /* access modifiers changed from: package-private */
        public void a(float f2) {
            this.f4592h = f2;
            this.f4586b.setStrokeWidth(f2);
        }

        /* access modifiers changed from: package-private */
        public void a(float f2, float f3) {
            this.f4602r = (int) f2;
            this.f4603s = (int) f3;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f4605u = i2;
        }

        /* access modifiers changed from: package-private */
        public void a(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.f4598n) {
                Path path = this.f4599o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f4599o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f4599o.moveTo(0.0f, 0.0f);
                this.f4599o.lineTo(((float) this.f4602r) * this.f4600p, 0.0f);
                Path path3 = this.f4599o;
                float f4 = this.f4600p;
                path3.lineTo((((float) this.f4602r) * f4) / 2.0f, ((float) this.f4603s) * f4);
                this.f4599o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.f4602r) * this.f4600p) / 2.0f), rectF.centerY() + (this.f4592h / 2.0f));
                this.f4599o.close();
                this.f4587c.setColor(this.f4605u);
                this.f4587c.setAlpha(this.f4604t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f4599o, this.f4587c);
                canvas.restore();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f4585a;
            float f2 = this.f4601q;
            float f3 = (this.f4592h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                f3 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.f4602r) * this.f4600p) / 2.0f, this.f4592h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f3, ((float) rect.centerY()) - f3, ((float) rect.centerX()) + f3, ((float) rect.centerY()) + f3);
            float f4 = this.f4589e;
            float f5 = this.f4591g;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.f4590f + f5) * 360.0f) - f6;
            this.f4586b.setColor(this.f4605u);
            this.f4586b.setAlpha(this.f4604t);
            float f8 = this.f4592h / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f4588d);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.f4586b);
            a(canvas, f6, f7, rectF);
        }

        /* access modifiers changed from: package-private */
        public void a(ColorFilter colorFilter) {
            this.f4586b.setColorFilter(colorFilter);
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z2) {
            if (this.f4598n != z2) {
                this.f4598n = z2;
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int[] iArr) {
            this.f4593i = iArr;
            b(0);
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return (this.f4594j + 1) % this.f4593i.length;
        }

        /* access modifiers changed from: package-private */
        public void b(float f2) {
            this.f4589e = f2;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            this.f4594j = i2;
            this.f4605u = this.f4593i[i2];
        }

        /* access modifiers changed from: package-private */
        public void c() {
            b(b());
        }

        /* access modifiers changed from: package-private */
        public void c(float f2) {
            this.f4590f = f2;
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            this.f4604t = i2;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return this.f4604t;
        }

        /* access modifiers changed from: package-private */
        public void d(float f2) {
            this.f4591g = f2;
        }

        /* access modifiers changed from: package-private */
        public float e() {
            return this.f4589e;
        }

        /* access modifiers changed from: package-private */
        public void e(float f2) {
            this.f4601q = f2;
        }

        /* access modifiers changed from: package-private */
        public float f() {
            return this.f4595k;
        }

        /* access modifiers changed from: package-private */
        public void f(float f2) {
            if (f2 != this.f4600p) {
                this.f4600p = f2;
            }
        }

        /* access modifiers changed from: package-private */
        public float g() {
            return this.f4596l;
        }

        /* access modifiers changed from: package-private */
        public int h() {
            return this.f4593i[this.f4594j];
        }

        /* access modifiers changed from: package-private */
        public float i() {
            return this.f4590f;
        }

        /* access modifiers changed from: package-private */
        public float j() {
            return this.f4597m;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.f4595k = this.f4589e;
            this.f4596l = this.f4590f;
            this.f4597m = this.f4591g;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            this.f4595k = 0.0f;
            this.f4596l = 0.0f;
            this.f4597m = 0.0f;
            b(0.0f);
            c(0.0f);
            d(0.0f);
        }
    }

    public b(Context context) {
        this.f4579h = ((Context) f.a(context)).getResources();
        a aVar = new a();
        this.f4577f = aVar;
        aVar.a(f4574e);
        a(2.5f);
        a();
    }

    private int a(float f2, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) (((float) (((i3 >> 24) & 255) - i4)) * f2))) << 24) | ((i5 + ((int) (((float) (((i3 >> 16) & 255) - i5)) * f2))) << 16) | ((i6 + ((int) (((float) (((i3 >> 8) & 255) - i6)) * f2))) << 8) | (i7 + ((int) (f2 * ((float) ((i3 & 255) - i7)))));
    }

    private void a() {
        final a aVar = this.f4577f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.this.a(floatValue, aVar);
                b.this.a(floatValue, aVar, false);
                b.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f4572c);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
                b.this.a(1.0f, aVar, true);
                aVar.k();
                aVar.c();
                if (b.this.f4576b) {
                    b.this.f4576b = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    aVar.a(false);
                    return;
                }
                b.this.f4575a += 1.0f;
            }

            public void onAnimationStart(Animator animator) {
                b.this.f4575a = 0.0f;
            }
        });
        this.f4580i = ofFloat;
    }

    private void a(float f2, float f3, float f4, float f5) {
        a aVar = this.f4577f;
        float f6 = this.f4579h.getDisplayMetrics().density;
        aVar.a(f3 * f6);
        aVar.e(f2 * f6);
        aVar.b(0);
        aVar.a(f4 * f6, f5 * f6);
    }

    private void b(float f2, a aVar) {
        a(f2, aVar);
        aVar.b(aVar.f() + (((aVar.g() - 0.01f) - aVar.f()) * f2));
        aVar.c(aVar.g());
        aVar.d(aVar.j() + ((((float) (Math.floor((double) (aVar.j() / 0.8f)) + 1.0d)) - aVar.j()) * f2));
    }

    private void d(float f2) {
        this.f4578g = f2;
    }

    public void a(float f2) {
        this.f4577f.a(f2);
        invalidateSelf();
    }

    public void a(float f2, float f3) {
        this.f4577f.b(f2);
        this.f4577f.c(f3);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, a aVar) {
        aVar.a(f2 > 0.75f ? a((f2 - 0.75f) / 0.25f, aVar.h(), aVar.a()) : aVar.h());
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, a aVar, boolean z2) {
        float f3;
        float f4;
        if (this.f4576b) {
            b(f2, aVar);
        } else if (f2 != 1.0f || z2) {
            float j2 = aVar.j();
            if (f2 < 0.5f) {
                f3 = aVar.f();
                f4 = (f4573d.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + f3;
            } else {
                float f5 = aVar.f() + 0.79f;
                float f6 = f5;
                f3 = f5 - (((1.0f - f4573d.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f4 = f6;
            }
            aVar.b(f3);
            aVar.c(f4);
            aVar.d(j2 + (0.20999998f * f2));
            d((f2 + this.f4575a) * 216.0f);
        }
    }

    public void a(int i2) {
        float f2;
        float f3;
        float f4;
        float f5;
        if (i2 == 0) {
            f2 = 11.0f;
            f5 = 3.0f;
            f4 = 12.0f;
            f3 = 6.0f;
        } else {
            f2 = 7.5f;
            f5 = 2.5f;
            f4 = 10.0f;
            f3 = 5.0f;
        }
        a(f2, f5, f4, f3);
        invalidateSelf();
    }

    public void a(boolean z2) {
        this.f4577f.a(z2);
        invalidateSelf();
    }

    public void a(int... iArr) {
        this.f4577f.a(iArr);
        this.f4577f.b(0);
        invalidateSelf();
    }

    public void b(float f2) {
        this.f4577f.f(f2);
        invalidateSelf();
    }

    public void c(float f2) {
        this.f4577f.d(f2);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f4578g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f4577f.a(canvas, bounds);
        canvas.restore();
    }

    public int getAlpha() {
        return this.f4577f.d();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f4580i.isRunning();
    }

    public void setAlpha(int i2) {
        this.f4577f.c(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f4577f.a(colorFilter);
        invalidateSelf();
    }

    public void start() {
        long j2;
        Animator animator;
        this.f4580i.cancel();
        this.f4577f.k();
        if (this.f4577f.i() != this.f4577f.e()) {
            this.f4576b = true;
            animator = this.f4580i;
            j2 = 666;
        } else {
            this.f4577f.b(0);
            this.f4577f.l();
            animator = this.f4580i;
            j2 = 1332;
        }
        animator.setDuration(j2);
        this.f4580i.start();
    }

    public void stop() {
        this.f4580i.cancel();
        d(0.0f);
        this.f4577f.a(false);
        this.f4577f.b(0);
        this.f4577f.l();
        invalidateSelf();
    }
}
