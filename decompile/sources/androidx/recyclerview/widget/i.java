package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.xeagle.android.login.common.ListenerStickView;
import t.ac;

class i extends RecyclerView.g implements RecyclerView.k {

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f4191k = {16842919};

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f4192l = new int[0];
    private int A = 0;
    private final int[] B = new int[2];
    private final int[] C = new int[2];
    private final Runnable D;
    private final RecyclerView.l E;

    /* renamed from: a  reason: collision with root package name */
    final StateListDrawable f4193a;

    /* renamed from: b  reason: collision with root package name */
    final Drawable f4194b;

    /* renamed from: c  reason: collision with root package name */
    int f4195c;

    /* renamed from: d  reason: collision with root package name */
    int f4196d;

    /* renamed from: e  reason: collision with root package name */
    float f4197e;

    /* renamed from: f  reason: collision with root package name */
    int f4198f;

    /* renamed from: g  reason: collision with root package name */
    int f4199g;

    /* renamed from: h  reason: collision with root package name */
    float f4200h;

    /* renamed from: i  reason: collision with root package name */
    final ValueAnimator f4201i;

    /* renamed from: j  reason: collision with root package name */
    int f4202j;

    /* renamed from: m  reason: collision with root package name */
    private final int f4203m;

    /* renamed from: n  reason: collision with root package name */
    private final int f4204n;

    /* renamed from: o  reason: collision with root package name */
    private final int f4205o;

    /* renamed from: p  reason: collision with root package name */
    private final int f4206p;

    /* renamed from: q  reason: collision with root package name */
    private final StateListDrawable f4207q;

    /* renamed from: r  reason: collision with root package name */
    private final Drawable f4208r;

    /* renamed from: s  reason: collision with root package name */
    private final int f4209s;

    /* renamed from: t  reason: collision with root package name */
    private final int f4210t;

    /* renamed from: u  reason: collision with root package name */
    private int f4211u = 0;

    /* renamed from: v  reason: collision with root package name */
    private int f4212v = 0;

    /* renamed from: w  reason: collision with root package name */
    private RecyclerView f4213w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f4214x = false;

    /* renamed from: y  reason: collision with root package name */
    private boolean f4215y = false;

    /* renamed from: z  reason: collision with root package name */
    private int f4216z = 0;

    private class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f4220b = false;

        a() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f4220b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f4220b) {
                this.f4220b = false;
            } else if (((Float) i.this.f4201i.getAnimatedValue()).floatValue() == 0.0f) {
                i.this.f4202j = 0;
                i.this.a(0);
            } else {
                i.this.f4202j = 2;
                i.this.a();
            }
        }
    }

    private class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            i.this.f4193a.setAlpha(floatValue);
            i.this.f4194b.setAlpha(floatValue);
            i.this.a();
        }
    }

    i(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f4201i = ofFloat;
        this.f4202j = 0;
        this.D = new Runnable() {
            public void run() {
                i.this.b(500);
            }
        };
        this.E = new RecyclerView.l() {
            public void a(RecyclerView recyclerView, int i2, int i3) {
                i.this.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
            }
        };
        this.f4193a = stateListDrawable;
        this.f4194b = drawable;
        this.f4207q = stateListDrawable2;
        this.f4208r = drawable2;
        this.f4205o = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f4206p = Math.max(i2, drawable.getIntrinsicWidth());
        this.f4209s = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f4210t = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f4203m = i3;
        this.f4204n = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new a());
        ofFloat.addUpdateListener(new b());
        a(recyclerView);
    }

    private int a(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / ((float) i5)) * ((float) i6));
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    private void a(float f2) {
        int[] g2 = g();
        float max = Math.max((float) g2[0], Math.min((float) g2[1], f2));
        if (Math.abs(((float) this.f4196d) - max) >= 2.0f) {
            int a2 = a(this.f4197e, max, g2, this.f4213w.computeVerticalScrollRange(), this.f4213w.computeVerticalScrollOffset(), this.f4212v);
            if (a2 != 0) {
                this.f4213w.scrollBy(0, a2);
            }
            this.f4197e = max;
        }
    }

    private void a(Canvas canvas) {
        int i2 = this.f4211u;
        int i3 = this.f4205o;
        int i4 = i2 - i3;
        int i5 = this.f4196d;
        int i6 = this.f4195c;
        int i7 = i5 - (i6 / 2);
        this.f4193a.setBounds(0, 0, i3, i6);
        this.f4194b.setBounds(0, 0, this.f4206p, this.f4212v);
        if (e()) {
            this.f4194b.draw(canvas);
            canvas.translate((float) this.f4205o, (float) i7);
            canvas.scale(-1.0f, 1.0f);
            this.f4193a.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            i4 = this.f4205o;
        } else {
            canvas.translate((float) i4, 0.0f);
            this.f4194b.draw(canvas);
            canvas.translate(0.0f, (float) i7);
            this.f4193a.draw(canvas);
        }
        canvas.translate((float) (-i4), (float) (-i7));
    }

    private void b(float f2) {
        int[] h2 = h();
        float max = Math.max((float) h2[0], Math.min((float) h2[1], f2));
        if (Math.abs(((float) this.f4199g) - max) >= 2.0f) {
            int a2 = a(this.f4200h, max, h2, this.f4213w.computeHorizontalScrollRange(), this.f4213w.computeHorizontalScrollOffset(), this.f4211u);
            if (a2 != 0) {
                this.f4213w.scrollBy(a2, 0);
            }
            this.f4200h = max;
        }
    }

    private void b(Canvas canvas) {
        int i2 = this.f4212v;
        int i3 = this.f4209s;
        int i4 = i2 - i3;
        int i5 = this.f4199g;
        int i6 = this.f4198f;
        int i7 = i5 - (i6 / 2);
        this.f4207q.setBounds(0, 0, i6, i3);
        this.f4208r.setBounds(0, 0, this.f4211u, this.f4210t);
        canvas.translate(0.0f, (float) i4);
        this.f4208r.draw(canvas);
        canvas.translate((float) i7, 0.0f);
        this.f4207q.draw(canvas);
        canvas.translate((float) (-i7), (float) (-i4));
    }

    private void c() {
        this.f4213w.a((RecyclerView.g) this);
        this.f4213w.a((RecyclerView.k) this);
        this.f4213w.a(this.E);
    }

    private void c(int i2) {
        f();
        this.f4213w.postDelayed(this.D, (long) i2);
    }

    private void d() {
        this.f4213w.b((RecyclerView.g) this);
        this.f4213w.b((RecyclerView.k) this);
        this.f4213w.b(this.E);
        f();
    }

    private boolean e() {
        return ac.i(this.f4213w) == 1;
    }

    private void f() {
        this.f4213w.removeCallbacks(this.D);
    }

    private int[] g() {
        int[] iArr = this.B;
        int i2 = this.f4204n;
        iArr[0] = i2;
        iArr[1] = this.f4212v - i2;
        return iArr;
    }

    private int[] h() {
        int[] iArr = this.C;
        int i2 = this.f4204n;
        iArr[0] = i2;
        iArr[1] = this.f4211u - i2;
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f4213w.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        int i3;
        if (i2 == 2 && this.f4216z != 2) {
            this.f4193a.setState(f4191k);
            f();
        }
        if (i2 == 0) {
            a();
        } else {
            b();
        }
        if (this.f4216z != 2 || i2 == 2) {
            if (i2 == 1) {
                i3 = ListenerStickView.RC_TRIM;
            }
            this.f4216z = i2;
        }
        this.f4193a.setState(f4192l);
        i3 = 1200;
        c(i3);
        this.f4216z = i2;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        int computeVerticalScrollRange = this.f4213w.computeVerticalScrollRange();
        int i4 = this.f4212v;
        this.f4214x = computeVerticalScrollRange - i4 > 0 && i4 >= this.f4203m;
        int computeHorizontalScrollRange = this.f4213w.computeHorizontalScrollRange();
        int i5 = this.f4211u;
        boolean z2 = computeHorizontalScrollRange - i5 > 0 && i5 >= this.f4203m;
        this.f4215y = z2;
        boolean z3 = this.f4214x;
        if (z3 || z2) {
            if (z3) {
                float f2 = (float) i4;
                this.f4196d = (int) ((f2 * (((float) i3) + (f2 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f4195c = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
            }
            if (this.f4215y) {
                float f3 = (float) i5;
                this.f4199g = (int) ((f3 * (((float) i2) + (f3 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f4198f = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
            }
            int i6 = this.f4216z;
            if (i6 == 0 || i6 == 1) {
                a(1);
            }
        } else if (this.f4216z != 0) {
            a(0);
        }
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4213w;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                d();
            }
            this.f4213w = recyclerView;
            if (recyclerView != null) {
                c();
            }
        }
    }

    public void a(boolean z2) {
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f2, float f3) {
        if (!e() ? f2 >= ((float) (this.f4211u - this.f4205o)) : f2 <= ((float) this.f4205o)) {
            int i2 = this.f4196d;
            int i3 = this.f4195c;
            return f3 >= ((float) (i2 - (i3 / 2))) && f3 <= ((float) (i2 + (i3 / 2)));
        }
    }

    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i2 = this.f4216z;
        if (i2 != 1) {
            return i2 == 2;
        }
        boolean a2 = a(motionEvent.getX(), motionEvent.getY());
        boolean b2 = b(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (!a2 && !b2) {
            return false;
        }
        if (b2) {
            this.A = 1;
            this.f4200h = (float) ((int) motionEvent.getX());
        } else if (a2) {
            this.A = 2;
            this.f4197e = (float) ((int) motionEvent.getY());
        }
        a(2);
    }

    public void b() {
        int i2 = this.f4202j;
        if (i2 != 0) {
            if (i2 == 3) {
                this.f4201i.cancel();
            } else {
                return;
            }
        }
        this.f4202j = 1;
        ValueAnimator valueAnimator = this.f4201i;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.f4201i.setDuration(500);
        this.f4201i.setStartDelay(0);
        this.f4201i.start();
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        int i3 = this.f4202j;
        if (i3 == 1) {
            this.f4201i.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.f4202j = 3;
        ValueAnimator valueAnimator = this.f4201i;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.f4201i.setDuration((long) i2);
        this.f4201i.start();
    }

    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f4216z != 0) {
            if (motionEvent.getAction() == 0) {
                boolean a2 = a(motionEvent.getX(), motionEvent.getY());
                boolean b2 = b(motionEvent.getX(), motionEvent.getY());
                if (a2 || b2) {
                    if (b2) {
                        this.A = 1;
                        this.f4200h = (float) ((int) motionEvent.getX());
                    } else if (a2) {
                        this.A = 2;
                        this.f4197e = (float) ((int) motionEvent.getY());
                    }
                    a(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f4216z == 2) {
                this.f4197e = 0.0f;
                this.f4200h = 0.0f;
                a(1);
                this.A = 0;
            } else if (motionEvent.getAction() == 2 && this.f4216z == 2) {
                b();
                if (this.A == 1) {
                    b(motionEvent.getX());
                }
                if (this.A == 2) {
                    a(motionEvent.getY());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(float f2, float f3) {
        if (f3 >= ((float) (this.f4212v - this.f4209s))) {
            int i2 = this.f4199g;
            int i3 = this.f4198f;
            return f2 >= ((float) (i2 - (i3 / 2))) && f2 <= ((float) (i2 + (i3 / 2)));
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        if (this.f4211u != this.f4213w.getWidth() || this.f4212v != this.f4213w.getHeight()) {
            this.f4211u = this.f4213w.getWidth();
            this.f4212v = this.f4213w.getHeight();
            a(0);
        } else if (this.f4202j != 0) {
            if (this.f4214x) {
                a(canvas);
            }
            if (this.f4215y) {
                b(canvas);
            }
        }
    }
}
