package it.sephiroth.android.library.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import it.sephiroth.android.library.R;

public class a {
    private final int A;
    private final int B;
    private final int C;
    private final int D;

    /* renamed from: a  reason: collision with root package name */
    private final int f29317a;

    /* renamed from: b  reason: collision with root package name */
    private final Drawable f29318b;

    /* renamed from: c  reason: collision with root package name */
    private final Drawable f29319c;

    /* renamed from: d  reason: collision with root package name */
    private int f29320d;

    /* renamed from: e  reason: collision with root package name */
    private int f29321e;

    /* renamed from: f  reason: collision with root package name */
    private int f29322f;

    /* renamed from: g  reason: collision with root package name */
    private int f29323g;

    /* renamed from: h  reason: collision with root package name */
    private final int f29324h;

    /* renamed from: i  reason: collision with root package name */
    private float f29325i;

    /* renamed from: j  reason: collision with root package name */
    private float f29326j;

    /* renamed from: k  reason: collision with root package name */
    private float f29327k;

    /* renamed from: l  reason: collision with root package name */
    private float f29328l;

    /* renamed from: m  reason: collision with root package name */
    private float f29329m;

    /* renamed from: n  reason: collision with root package name */
    private float f29330n;

    /* renamed from: o  reason: collision with root package name */
    private float f29331o;

    /* renamed from: p  reason: collision with root package name */
    private float f29332p;

    /* renamed from: q  reason: collision with root package name */
    private float f29333q;

    /* renamed from: r  reason: collision with root package name */
    private float f29334r;

    /* renamed from: s  reason: collision with root package name */
    private float f29335s;

    /* renamed from: t  reason: collision with root package name */
    private float f29336t;

    /* renamed from: u  reason: collision with root package name */
    private long f29337u;

    /* renamed from: v  reason: collision with root package name */
    private float f29338v;

    /* renamed from: w  reason: collision with root package name */
    private final Interpolator f29339w;

    /* renamed from: x  reason: collision with root package name */
    private int f29340x = 0;

    /* renamed from: y  reason: collision with root package name */
    private float f29341y;

    /* renamed from: z  reason: collision with root package name */
    private final Rect f29342z = new Rect();

    public a(Context context, int i2) {
        Resources resources = context.getResources();
        Drawable drawable = resources.getDrawable(R.drawable.hlv_overscroll_edge);
        this.f29318b = drawable;
        Drawable drawable2 = resources.getDrawable(R.drawable.hlv_overscroll_glow);
        this.f29319c = drawable2;
        this.f29317a = i2;
        this.A = drawable.getIntrinsicHeight();
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        this.B = intrinsicHeight;
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        this.C = intrinsicWidth;
        this.D = (int) (Math.min((((((float) intrinsicHeight) * 4.0f) * ((float) intrinsicHeight)) / ((float) intrinsicWidth)) * 0.6f, ((float) intrinsicHeight) * 4.0f) + 0.5f);
        this.f29324h = (int) ((resources.getDisplayMetrics().density * 300.0f) + 0.5f);
        this.f29339w = new DecelerateInterpolator();
    }

    private void d() {
        float min = Math.min(((float) (AnimationUtils.currentAnimationTimeMillis() - this.f29337u)) / this.f29338v, 1.0f);
        float interpolation = this.f29339w.getInterpolation(min);
        float f2 = this.f29329m;
        this.f29325i = f2 + ((this.f29330n - f2) * interpolation);
        float f3 = this.f29331o;
        float f4 = this.f29332p;
        this.f29326j = ((f4 - f3) * interpolation) + f3;
        float f5 = this.f29333q;
        this.f29327k = f5 + ((this.f29334r - f5) * interpolation);
        float f6 = this.f29335s;
        float f7 = this.f29336t;
        this.f29328l = f6 + ((f7 - f6) * interpolation);
        if (min >= 0.999f) {
            int i2 = this.f29340x;
            if (i2 == 1) {
                this.f29340x = 4;
            } else if (i2 == 2) {
                this.f29340x = 3;
            } else if (i2 == 3) {
                this.f29340x = 0;
                return;
            } else if (i2 == 4) {
                this.f29326j = f3 + ((f4 - f3) * interpolation * (f7 != 0.0f ? 1.0f / (f7 * f7) : Float.MAX_VALUE));
                this.f29340x = 3;
                return;
            } else {
                return;
            }
            this.f29337u = AnimationUtils.currentAnimationTimeMillis();
            this.f29338v = 1000.0f;
            this.f29329m = this.f29325i;
            this.f29331o = this.f29326j;
            this.f29333q = this.f29327k;
            this.f29335s = this.f29328l;
            this.f29330n = 0.0f;
            this.f29332p = 0.0f;
            this.f29334r = 0.0f;
            this.f29336t = 0.0f;
        }
    }

    public Rect a(boolean z2) {
        int i2 = 0;
        this.f29342z.set(0, 0, this.f29320d, this.D);
        Rect rect = this.f29342z;
        int i3 = this.f29322f;
        int i4 = this.f29323g;
        if (z2) {
            i2 = this.D;
        }
        rect.offset(i3, i4 - i2);
        return this.f29342z;
    }

    public void a(float f2) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = this.f29340x;
        if (i2 != 4 || ((float) (currentAnimationTimeMillis - this.f29337u)) >= this.f29338v) {
            if (i2 != 1) {
                this.f29328l = 1.0f;
            }
            this.f29340x = 1;
            this.f29337u = currentAnimationTimeMillis;
            this.f29338v = 167.0f;
            float f3 = this.f29341y + f2;
            this.f29341y = f3;
            float abs = Math.abs(f3);
            float max = Math.max(0.6f, Math.min(abs, 1.0f));
            this.f29329m = max;
            this.f29325i = max;
            float max2 = Math.max(0.5f, Math.min(abs * 7.0f, 1.0f));
            this.f29331o = max2;
            this.f29326j = max2;
            float min = Math.min(1.0f, this.f29327k + (Math.abs(f2) * 1.1f));
            this.f29333q = min;
            this.f29327k = min;
            float abs2 = Math.abs(f2);
            if (f2 > 0.0f && this.f29341y < 0.0f) {
                abs2 = -abs2;
            }
            if (this.f29341y == 0.0f) {
                this.f29328l = 0.0f;
            }
            float min2 = Math.min(4.0f, Math.max(0.0f, this.f29328l + (abs2 * 7.0f)));
            this.f29335s = min2;
            this.f29328l = min2;
            this.f29330n = this.f29325i;
            this.f29332p = this.f29326j;
            this.f29334r = this.f29327k;
            this.f29336t = min2;
        }
    }

    public void a(int i2) {
        this.f29340x = 2;
        int max = Math.max(100, Math.abs(i2));
        this.f29337u = AnimationUtils.currentAnimationTimeMillis();
        this.f29338v = (((float) max) * 0.03f) + 0.1f;
        this.f29329m = 0.0f;
        this.f29331o = 0.0f;
        this.f29326j = 0.0f;
        this.f29333q = 0.5f;
        this.f29335s = 0.0f;
        int i3 = max * 8;
        this.f29330n = (float) Math.max(0, Math.min(i3, 1));
        this.f29332p = Math.max(0.5f, Math.min((float) i3, 1.0f));
        this.f29336t = Math.min((((float) ((max / 100) * max)) * 1.5E-4f) + 0.025f, 1.75f);
        this.f29334r = Math.max(this.f29333q, Math.min(((float) (max * 16)) * 1.0E-5f, 1.0f));
    }

    public void a(int i2, int i3) {
        this.f29320d = i2;
        this.f29321e = i3;
    }

    public boolean a() {
        return this.f29340x == 0;
    }

    public boolean a(Canvas canvas) {
        d();
        this.f29319c.setAlpha((int) (Math.max(0.0f, Math.min(this.f29327k, 1.0f)) * 255.0f));
        int i2 = this.B;
        int min = (int) Math.min((((((float) i2) * this.f29328l) * ((float) i2)) / ((float) this.C)) * 0.6f, ((float) i2) * 4.0f);
        int i3 = this.f29317a;
        this.f29319c.setBounds(0, 0, this.f29320d, min);
        this.f29319c.draw(canvas);
        this.f29318b.setAlpha((int) (Math.max(0.0f, Math.min(this.f29325i, 1.0f)) * 255.0f));
        int i4 = (int) (((float) this.A) * this.f29326j);
        int i5 = this.f29317a;
        this.f29318b.setBounds(0, 0, this.f29320d, i4);
        this.f29318b.draw(canvas);
        if (this.f29340x == 3 && min == 0 && i4 == 0) {
            this.f29340x = 0;
        }
        return this.f29340x != 0;
    }

    public void b() {
        this.f29340x = 0;
    }

    public void b(int i2, int i3) {
        this.f29322f = i2;
        this.f29323g = i3;
    }

    public void c() {
        this.f29341y = 0.0f;
        int i2 = this.f29340x;
        if (i2 == 1 || i2 == 4) {
            this.f29340x = 3;
            this.f29329m = this.f29325i;
            this.f29331o = this.f29326j;
            this.f29333q = this.f29327k;
            this.f29335s = this.f29328l;
            this.f29330n = 0.0f;
            this.f29332p = 0.0f;
            this.f29334r = 0.0f;
            this.f29336t = 0.0f;
            this.f29337u = AnimationUtils.currentAnimationTimeMillis();
            this.f29338v = 1000.0f;
        }
    }
}
