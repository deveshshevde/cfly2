package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import fg.i;
import java.util.ArrayList;

public class a extends Drawable implements Animatable {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f13716a = new LinearInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Interpolator f13717b = new C0102a();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Interpolator f13718c = new d();

    /* renamed from: d  reason: collision with root package name */
    private static final Interpolator f13719d = new AccelerateDecelerateInterpolator();

    /* renamed from: e  reason: collision with root package name */
    private final int[] f13720e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<Animation> f13721f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private final c f13722g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable.Callback f13723h;

    /* renamed from: i  reason: collision with root package name */
    private float f13724i;

    /* renamed from: j  reason: collision with root package name */
    private Resources f13725j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public View f13726k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public Animation f13727l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f13728m;

    /* renamed from: n  reason: collision with root package name */
    private double f13729n;

    /* renamed from: o  reason: collision with root package name */
    private double f13730o;

    /* renamed from: p  reason: collision with root package name */
    private Animation f13731p;

    /* renamed from: q  reason: collision with root package name */
    private int f13732q;

    /* renamed from: r  reason: collision with root package name */
    private ShapeDrawable f13733r;

    /* renamed from: in.srain.cube.views.ptr.header.a$a  reason: collision with other inner class name */
    private static class C0102a extends AccelerateDecelerateInterpolator {
        private C0102a() {
        }

        public float getInterpolation(float f2) {
            return super.getInterpolation(Math.max(0.0f, (f2 - 0.5f) * 2.0f));
        }
    }

    private class b extends OvalShape {

        /* renamed from: b  reason: collision with root package name */
        private RadialGradient f13744b;

        /* renamed from: c  reason: collision with root package name */
        private int f13745c;

        /* renamed from: d  reason: collision with root package name */
        private Paint f13746d = new Paint();

        /* renamed from: e  reason: collision with root package name */
        private int f13747e;

        public b(int i2, int i3) {
            this.f13745c = i2;
            this.f13747e = i3;
            int i4 = this.f13747e;
            RadialGradient radialGradient = new RadialGradient((float) (i4 / 2), (float) (i4 / 2), (float) this.f13745c, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f13744b = radialGradient;
            this.f13746d.setShader(radialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            float width = (float) (a.this.getBounds().width() / 2);
            float height = (float) (a.this.getBounds().height() / 2);
            canvas.drawCircle(width, height, (float) ((this.f13747e / 2) + this.f13745c), this.f13746d);
            canvas.drawCircle(width, height, (float) (this.f13747e / 2), paint);
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private final RectF f13748a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        private final Paint f13749b;

        /* renamed from: c  reason: collision with root package name */
        private final Paint f13750c;

        /* renamed from: d  reason: collision with root package name */
        private final Drawable.Callback f13751d;

        /* renamed from: e  reason: collision with root package name */
        private final Paint f13752e;

        /* renamed from: f  reason: collision with root package name */
        private float f13753f;

        /* renamed from: g  reason: collision with root package name */
        private float f13754g;

        /* renamed from: h  reason: collision with root package name */
        private float f13755h;

        /* renamed from: i  reason: collision with root package name */
        private float f13756i;

        /* renamed from: j  reason: collision with root package name */
        private float f13757j;

        /* renamed from: k  reason: collision with root package name */
        private int[] f13758k;

        /* renamed from: l  reason: collision with root package name */
        private int f13759l;

        /* renamed from: m  reason: collision with root package name */
        private float f13760m;

        /* renamed from: n  reason: collision with root package name */
        private float f13761n;

        /* renamed from: o  reason: collision with root package name */
        private float f13762o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f13763p;

        /* renamed from: q  reason: collision with root package name */
        private Path f13764q;

        /* renamed from: r  reason: collision with root package name */
        private float f13765r;

        /* renamed from: s  reason: collision with root package name */
        private double f13766s;

        /* renamed from: t  reason: collision with root package name */
        private int f13767t;

        /* renamed from: u  reason: collision with root package name */
        private int f13768u;

        /* renamed from: v  reason: collision with root package name */
        private int f13769v;

        /* renamed from: w  reason: collision with root package name */
        private int f13770w;

        public c(Drawable.Callback callback) {
            Paint paint = new Paint();
            this.f13749b = paint;
            Paint paint2 = new Paint();
            this.f13750c = paint2;
            Paint paint3 = new Paint();
            this.f13752e = paint3;
            this.f13753f = 0.0f;
            this.f13754g = 0.0f;
            this.f13755h = 0.0f;
            this.f13756i = 5.0f;
            this.f13757j = 2.5f;
            this.f13751d = callback;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setAntiAlias(true);
        }

        private void a(Canvas canvas, float f2, float f3, Rect rect) {
            if (this.f13763p) {
                Path path = this.f13764q;
                if (path == null) {
                    Path path2 = new Path();
                    this.f13764q = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f4 = ((float) (((int) this.f13757j) / 2)) * this.f13765r;
                double cos = this.f13766s * Math.cos(i.f27244a);
                double exactCenterX = (double) rect.exactCenterX();
                Double.isNaN(exactCenterX);
                double sin = this.f13766s * Math.sin(i.f27244a);
                double exactCenterY = (double) rect.exactCenterY();
                Double.isNaN(exactCenterY);
                float f5 = (float) (sin + exactCenterY);
                this.f13764q.moveTo(0.0f, 0.0f);
                this.f13764q.lineTo(((float) this.f13767t) * this.f13765r, 0.0f);
                Path path3 = this.f13764q;
                float f6 = this.f13765r;
                path3.lineTo((((float) this.f13767t) * f6) / 2.0f, ((float) this.f13768u) * f6);
                this.f13764q.offset(((float) (cos + exactCenterX)) - f4, f5);
                this.f13764q.close();
                this.f13750c.setColor(this.f13758k[this.f13759l]);
                this.f13750c.setAlpha(this.f13769v);
                canvas.rotate((f2 + f3) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f13764q, this.f13750c);
            }
        }

        private void l() {
            this.f13751d.invalidateDrawable((Drawable) null);
        }

        public void a() {
            this.f13759l = (this.f13759l + 1) % this.f13758k.length;
        }

        public void a(double d2) {
            this.f13766s = d2;
        }

        public void a(float f2) {
            this.f13756i = f2;
            this.f13749b.setStrokeWidth(f2);
            l();
        }

        public void a(float f2, float f3) {
            this.f13767t = (int) f2;
            this.f13768u = (int) f3;
        }

        public void a(int i2) {
            this.f13770w = i2;
        }

        public void a(int i2, int i3) {
            double d2;
            float min = (float) Math.min(i2, i3);
            double d3 = this.f13766s;
            if (d3 <= i.f27244a || min < 0.0f) {
                d2 = Math.ceil((double) (this.f13756i / 2.0f));
            } else {
                double d4 = (double) (min / 2.0f);
                Double.isNaN(d4);
                d2 = d4 - d3;
            }
            this.f13757j = (float) d2;
        }

        public void a(Canvas canvas, Rect rect) {
            this.f13752e.setColor(this.f13770w);
            this.f13752e.setAlpha(this.f13769v);
            canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f13752e);
            RectF rectF = this.f13748a;
            rectF.set(rect);
            float f2 = this.f13757j;
            rectF.inset(f2, f2);
            float f3 = this.f13753f;
            float f4 = this.f13755h;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.f13754g + f4) * 360.0f) - f5;
            this.f13749b.setColor(this.f13758k[this.f13759l]);
            this.f13749b.setAlpha(this.f13769v);
            canvas.drawArc(rectF, f5, f6, false, this.f13749b);
            a(canvas, f5, f6, rect);
        }

        public void a(ColorFilter colorFilter) {
            this.f13749b.setColorFilter(colorFilter);
            l();
        }

        public void a(boolean z2) {
            if (this.f13763p != z2) {
                this.f13763p = z2;
                l();
            }
        }

        public void a(int[] iArr) {
            this.f13758k = iArr;
            b(0);
        }

        public int b() {
            return this.f13769v;
        }

        public void b(float f2) {
            this.f13753f = f2;
            l();
        }

        public void b(int i2) {
            this.f13759l = i2;
        }

        public float c() {
            return this.f13756i;
        }

        public void c(float f2) {
            this.f13754g = f2;
            l();
        }

        public void c(int i2) {
            this.f13769v = i2;
        }

        public float d() {
            return this.f13753f;
        }

        public void d(float f2) {
            this.f13755h = f2;
            l();
        }

        public float e() {
            return this.f13760m;
        }

        public void e(float f2) {
            if (f2 != this.f13765r) {
                this.f13765r = f2;
                l();
            }
        }

        public float f() {
            return this.f13761n;
        }

        public float g() {
            return this.f13754g;
        }

        public double h() {
            return this.f13766s;
        }

        public float i() {
            return this.f13762o;
        }

        public void j() {
            this.f13760m = this.f13753f;
            this.f13761n = this.f13754g;
            this.f13762o = this.f13755h;
        }

        public void k() {
            this.f13760m = 0.0f;
            this.f13761n = 0.0f;
            this.f13762o = 0.0f;
            b(0.0f);
            c(0.0f);
            d(0.0f);
        }
    }

    private static class d extends AccelerateDecelerateInterpolator {
        private d() {
        }

        public float getInterpolation(float f2) {
            return super.getInterpolation(Math.min(1.0f, f2 * 2.0f));
        }
    }

    public a(Context context, View view) {
        int[] iArr = {-3591113, -13149199, -536002, -13327536};
        this.f13720e = iArr;
        AnonymousClass1 r1 = new Drawable.Callback() {
            public void invalidateDrawable(Drawable drawable) {
                a.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
                a.this.scheduleSelf(runnable, j2);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                a.this.unscheduleSelf(runnable);
            }
        };
        this.f13723h = r1;
        this.f13726k = view;
        this.f13725j = context.getResources();
        c cVar = new c(r1);
        this.f13722g = cVar;
        cVar.a(iArr);
        a(1);
        c();
    }

    private void a(double d2) {
        lr.b.a(this.f13726k.getContext());
        int a2 = lr.b.a(1.75f);
        int a3 = lr.b.a(0.0f);
        int a4 = lr.b.a(3.5f);
        this.f13733r = new ShapeDrawable(new b(a4, (int) d2));
        if (Build.VERSION.SDK_INT >= 11) {
            this.f13726k.setLayerType(1, this.f13733r.getPaint());
        }
        this.f13733r.getPaint().setShadowLayer((float) a4, (float) a3, (float) a2, 503316480);
    }

    private void a(double d2, double d3, double d4, double d5, float f2, float f3) {
        c cVar = this.f13722g;
        float f4 = this.f13725j.getDisplayMetrics().density;
        double d6 = (double) f4;
        Double.isNaN(d6);
        this.f13729n = d2 * d6;
        Double.isNaN(d6);
        this.f13730o = d3 * d6;
        cVar.a(((float) d5) * f4);
        Double.isNaN(d6);
        cVar.a(d4 * d6);
        cVar.b(0);
        cVar.a(f2 * f4, f3 * f4);
        cVar.a((int) this.f13729n, (int) this.f13730o);
        a(this.f13729n);
    }

    private void c() {
        final c cVar = this.f13722g;
        AnonymousClass2 r1 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                float floor = (float) (Math.floor((double) (cVar.i() / 0.8f)) + 1.0d);
                cVar.b(cVar.e() + ((cVar.f() - cVar.e()) * f2));
                cVar.d(cVar.i() + ((floor - cVar.i()) * f2));
                cVar.e(1.0f - f2);
            }
        };
        r1.setInterpolator(f13719d);
        r1.setDuration(666);
        r1.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                cVar.a();
                cVar.j();
                cVar.a(false);
                a.this.f13726k.startAnimation(a.this.f13727l);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        AnonymousClass4 r2 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                double c2 = (double) cVar.c();
                Double.isNaN(c2);
                float radians = (float) Math.toRadians(c2 / (cVar.h() * 6.283185307179586d));
                float f3 = cVar.f();
                float e2 = cVar.e();
                float i2 = cVar.i();
                cVar.c(f3 + ((0.8f - radians) * a.f13718c.getInterpolation(f2)));
                cVar.b(e2 + (a.f13717b.getInterpolation(f2) * 0.8f));
                cVar.d(i2 + (0.25f * f2));
                a.this.c((f2 * 144.0f) + ((a.this.f13728m / 5.0f) * 720.0f));
            }
        };
        r2.setRepeatCount(-1);
        r2.setRepeatMode(1);
        r2.setInterpolator(f13716a);
        r2.setDuration(1333);
        r2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
                cVar.j();
                cVar.a();
                c cVar = cVar;
                cVar.b(cVar.g());
                a aVar = a.this;
                float unused = aVar.f13728m = (aVar.f13728m + 1.0f) % 5.0f;
            }

            public void onAnimationStart(Animation animation) {
                float unused = a.this.f13728m = 0.0f;
            }
        });
        this.f13731p = r1;
        this.f13727l = r2;
    }

    public void a(float f2) {
        this.f13722g.e(f2);
    }

    public void a(float f2, float f3) {
        this.f13722g.b(f2);
        this.f13722g.c(f3);
    }

    public void a(int i2) {
        if (i2 == 0) {
            a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void a(boolean z2) {
        this.f13722g.a(z2);
    }

    public void a(int... iArr) {
        this.f13722g.a(iArr);
        this.f13722g.b(0);
    }

    public void b(float f2) {
        this.f13722g.d(f2);
    }

    public void b(int i2) {
        this.f13732q = i2;
        this.f13722g.a(i2);
    }

    /* access modifiers changed from: package-private */
    public void c(float f2) {
        this.f13724i = f2;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        ShapeDrawable shapeDrawable = this.f13733r;
        if (shapeDrawable != null) {
            shapeDrawable.getPaint().setColor(this.f13732q);
            this.f13733r.draw(canvas);
        }
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f13724i, bounds.exactCenterX(), bounds.exactCenterY());
        this.f13722g.a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public int getAlpha() {
        return this.f13722g.b();
    }

    public int getIntrinsicHeight() {
        return (int) this.f13730o;
    }

    public int getIntrinsicWidth() {
        return (int) this.f13729n;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.f13721f;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Animation animation = arrayList.get(i2);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void setAlpha(int i2) {
        this.f13722g.c(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f13722g.a(colorFilter);
    }

    public void start() {
        Animation animation;
        View view;
        this.f13727l.reset();
        this.f13722g.j();
        if (this.f13722g.g() != this.f13722g.d()) {
            view = this.f13726k;
            animation = this.f13731p;
        } else {
            this.f13722g.b(0);
            this.f13722g.k();
            view = this.f13726k;
            animation = this.f13727l;
        }
        view.startAnimation(animation);
    }

    public void stop() {
        this.f13726k.clearAnimation();
        c(0.0f);
        this.f13722g.a(false);
        this.f13722g.b(0);
        this.f13722g.k();
    }
}
