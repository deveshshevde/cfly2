package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

public class k implements View.OnLayoutChangeListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private static float f14715a = 3.0f;

    /* renamed from: b  reason: collision with root package name */
    private static float f14716b = 1.75f;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static float f14717c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private static int f14718d = 200;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static int f14719e = 1;
    /* access modifiers changed from: private */
    public g A;
    /* access modifiers changed from: private */
    public h B;
    /* access modifiers changed from: private */
    public i C;
    /* access modifiers changed from: private */
    public b D;
    /* access modifiers changed from: private */
    public int E = 2;
    /* access modifiers changed from: private */
    public int F = 2;
    private float G;
    private boolean H = true;
    private ImageView.ScaleType I = ImageView.ScaleType.FIT_CENTER;
    /* access modifiers changed from: private */
    public c J = new c() {
        public void a(float f2, float f3) {
            if (!k.this.f14729o.a()) {
                if (k.this.C != null) {
                    k.this.C.a(f2, f3);
                }
                k.this.f14732r.postTranslate(f2, f3);
                k.this.m();
                ViewParent parent = k.this.f14727m.getParent();
                if (!k.this.f14725k || k.this.f14729o.a() || k.this.f14726l) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((k.this.E == 2 || ((k.this.E == 0 && f2 >= 1.0f) || ((k.this.E == 1 && f2 <= -1.0f) || ((k.this.F == 0 && f3 >= 1.0f) || (k.this.F == 1 && f3 <= -1.0f))))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }

        public void a(float f2, float f3, float f4) {
            if (k.this.e() < k.this.f14724j || f2 < 1.0f) {
                if (k.this.A != null) {
                    k.this.A.a(f2, f3, f4);
                }
                k.this.f14732r.postScale(f2, f2, f3, f4);
                k.this.m();
            }
        }

        public void a(float f2, float f3, float f4, float f5) {
            k kVar = k.this;
            b unused = kVar.D = new b(kVar.f14727m.getContext());
            b j2 = k.this.D;
            k kVar2 = k.this;
            int a2 = kVar2.a(kVar2.f14727m);
            k kVar3 = k.this;
            j2.a(a2, kVar3.b(kVar3.f14727m), (int) f4, (int) f5);
            k.this.f14727m.post(k.this.D);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Interpolator f14720f = new AccelerateDecelerateInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f14721g = f14718d;

    /* renamed from: h  reason: collision with root package name */
    private float f14722h = f14717c;

    /* renamed from: i  reason: collision with root package name */
    private float f14723i = f14716b;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public float f14724j = f14715a;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f14725k = true;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f14726l = false;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public ImageView f14727m;

    /* renamed from: n  reason: collision with root package name */
    private GestureDetector f14728n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public b f14729o;

    /* renamed from: p  reason: collision with root package name */
    private final Matrix f14730p = new Matrix();

    /* renamed from: q  reason: collision with root package name */
    private final Matrix f14731q = new Matrix();
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final Matrix f14732r = new Matrix();

    /* renamed from: s  reason: collision with root package name */
    private final RectF f14733s = new RectF();

    /* renamed from: t  reason: collision with root package name */
    private final float[] f14734t = new float[9];

    /* renamed from: u  reason: collision with root package name */
    private d f14735u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public f f14736v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public e f14737w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public j f14738x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public View.OnClickListener f14739y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public View.OnLongClickListener f14740z;

    /* renamed from: com.github.chrisbanes.photoview.k$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14744a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14744a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14744a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14744a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14744a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.chrisbanes.photoview.k.AnonymousClass4.<clinit>():void");
        }
    }

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final float f14746b;

        /* renamed from: c  reason: collision with root package name */
        private final float f14747c;

        /* renamed from: d  reason: collision with root package name */
        private final long f14748d = System.currentTimeMillis();

        /* renamed from: e  reason: collision with root package name */
        private final float f14749e;

        /* renamed from: f  reason: collision with root package name */
        private final float f14750f;

        public a(float f2, float f3, float f4, float f5) {
            this.f14746b = f4;
            this.f14747c = f5;
            this.f14749e = f2;
            this.f14750f = f3;
        }

        private float a() {
            return k.this.f14720f.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f14748d)) * 1.0f) / ((float) k.this.f14721g)));
        }

        public void run() {
            float a2 = a();
            float f2 = this.f14749e;
            k.this.J.a((f2 + ((this.f14750f - f2) * a2)) / k.this.e(), this.f14746b, this.f14747c);
            if (a2 < 1.0f) {
                a.a(k.this.f14727m, this);
            }
        }
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final OverScroller f14752b;

        /* renamed from: c  reason: collision with root package name */
        private int f14753c;

        /* renamed from: d  reason: collision with root package name */
        private int f14754d;

        public b(Context context) {
            this.f14752b = new OverScroller(context);
        }

        public void a() {
            this.f14752b.forceFinished(true);
        }

        public void a(int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            RectF a2 = k.this.a();
            if (a2 != null) {
                int round = Math.round(-a2.left);
                float f2 = (float) i2;
                if (f2 < a2.width()) {
                    i6 = Math.round(a2.width() - f2);
                    i7 = 0;
                } else {
                    i7 = round;
                    i6 = i7;
                }
                int round2 = Math.round(-a2.top);
                float f3 = (float) i3;
                if (f3 < a2.height()) {
                    i8 = Math.round(a2.height() - f3);
                    i9 = 0;
                } else {
                    i9 = round2;
                    i8 = i9;
                }
                this.f14753c = round;
                this.f14754d = round2;
                if (round != i6 || round2 != i8) {
                    this.f14752b.fling(round, round2, i4, i5, i7, i6, i9, i8, 0, 0);
                }
            }
        }

        public void run() {
            if (!this.f14752b.isFinished() && this.f14752b.computeScrollOffset()) {
                int currX = this.f14752b.getCurrX();
                int currY = this.f14752b.getCurrY();
                k.this.f14732r.postTranslate((float) (this.f14753c - currX), (float) (this.f14754d - currY));
                k.this.m();
                this.f14753c = currX;
                this.f14754d = currY;
                a.a(k.this.f14727m, this);
            }
        }
    }

    public k(ImageView imageView) {
        this.f14727m = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (!imageView.isInEditMode()) {
            this.G = 0.0f;
            this.f14729o = new b(imageView.getContext(), this.J);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    if (k.this.B == null || k.this.e() > k.f14717c || motionEvent.getPointerCount() > k.f14719e || motionEvent2.getPointerCount() > k.f14719e) {
                        return false;
                    }
                    return k.this.B.a(motionEvent, motionEvent2, f2, f3);
                }

                public void onLongPress(MotionEvent motionEvent) {
                    if (k.this.f14740z != null) {
                        k.this.f14740z.onLongClick(k.this.f14727m);
                    }
                }
            });
            this.f14728n = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    k kVar;
                    float b2;
                    try {
                        float e2 = k.this.e();
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (e2 < k.this.c()) {
                            kVar = k.this;
                            b2 = kVar.c();
                        } else if (e2 < k.this.c() || e2 >= k.this.d()) {
                            kVar = k.this;
                            b2 = kVar.b();
                        } else {
                            kVar = k.this;
                            b2 = kVar.d();
                        }
                        kVar.a(b2, x2, y2, true);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                    return true;
                }

                public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                    return false;
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    if (k.this.f14739y != null) {
                        k.this.f14739y.onClick(k.this.f14727m);
                    }
                    RectF a2 = k.this.a();
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    if (k.this.f14738x != null) {
                        k.this.f14738x.a(k.this.f14727m, x2, y2);
                    }
                    if (a2 == null) {
                        return false;
                    }
                    if (a2.contains(x2, y2)) {
                        float width = (x2 - a2.left) / a2.width();
                        float height = (y2 - a2.top) / a2.height();
                        if (k.this.f14736v == null) {
                            return true;
                        }
                        k.this.f14736v.a(k.this.f14727m, width, height);
                        return true;
                    } else if (k.this.f14737w == null) {
                        return false;
                    } else {
                        k.this.f14737w.a(k.this.f14727m);
                        return false;
                    }
                }
            });
        }
    }

    private float a(Matrix matrix, int i2) {
        matrix.getValues(this.f14734t);
        return this.f14734t[i2];
    }

    /* access modifiers changed from: private */
    public int a(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private void a(Matrix matrix) {
        RectF b2;
        this.f14727m.setImageMatrix(matrix);
        if (this.f14735u != null && (b2 = b(matrix)) != null) {
            this.f14735u.a(b2);
        }
    }

    private void a(Drawable drawable) {
        Matrix matrix;
        Matrix.ScaleToFit scaleToFit;
        float min;
        if (drawable != null) {
            float a2 = (float) a(this.f14727m);
            float b2 = (float) b(this.f14727m);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.f14730p.reset();
            float f2 = (float) intrinsicWidth;
            float f3 = a2 / f2;
            float f4 = (float) intrinsicHeight;
            float f5 = b2 / f4;
            if (this.I == ImageView.ScaleType.CENTER) {
                this.f14730p.postTranslate((a2 - f2) / 2.0f, (b2 - f4) / 2.0f);
            } else {
                if (this.I == ImageView.ScaleType.CENTER_CROP) {
                    min = Math.max(f3, f5);
                } else if (this.I == ImageView.ScaleType.CENTER_INSIDE) {
                    min = Math.min(1.0f, Math.min(f3, f5));
                } else {
                    RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
                    RectF rectF2 = new RectF(0.0f, 0.0f, a2, b2);
                    if (((int) this.G) % 180 != 0) {
                        rectF = new RectF(0.0f, 0.0f, f4, f2);
                    }
                    int i2 = AnonymousClass4.f14744a[this.I.ordinal()];
                    if (i2 == 1) {
                        matrix = this.f14730p;
                        scaleToFit = Matrix.ScaleToFit.CENTER;
                    } else if (i2 == 2) {
                        matrix = this.f14730p;
                        scaleToFit = Matrix.ScaleToFit.START;
                    } else if (i2 == 3) {
                        matrix = this.f14730p;
                        scaleToFit = Matrix.ScaleToFit.END;
                    } else if (i2 == 4) {
                        matrix = this.f14730p;
                        scaleToFit = Matrix.ScaleToFit.FILL;
                    }
                    matrix.setRectToRect(rectF, rectF2, scaleToFit);
                }
                this.f14730p.postScale(min, min);
                this.f14730p.postTranslate((a2 - (f2 * min)) / 2.0f, (b2 - (f4 * min)) / 2.0f);
            }
            l();
        }
    }

    /* access modifiers changed from: private */
    public int b(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private RectF b(Matrix matrix) {
        Drawable drawable = this.f14727m.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.f14733s.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.f14733s);
        return this.f14733s;
    }

    private Matrix k() {
        this.f14731q.set(this.f14730p);
        this.f14731q.postConcat(this.f14732r);
        return this.f14731q;
    }

    private void l() {
        this.f14732r.reset();
        b(this.G);
        a(k());
        n();
    }

    /* access modifiers changed from: private */
    public void m() {
        if (n()) {
            a(k());
        }
    }

    private boolean n() {
        float f2;
        RectF b2 = b(k());
        if (b2 == null) {
            return false;
        }
        float height = b2.height();
        float width = b2.width();
        float b3 = (float) b(this.f14727m);
        float f3 = 0.0f;
        if (height <= b3) {
            int i2 = AnonymousClass4.f14744a[this.I.ordinal()];
            if (i2 != 2) {
                float f4 = b3 - height;
                if (i2 != 3) {
                    f4 /= 2.0f;
                }
                f2 = f4 - b2.top;
            } else {
                f2 = -b2.top;
            }
            this.F = 2;
        } else if (b2.top > 0.0f) {
            this.F = 0;
            f2 = -b2.top;
        } else if (b2.bottom < b3) {
            this.F = 1;
            f2 = b3 - b2.bottom;
        } else {
            this.F = -1;
            f2 = 0.0f;
        }
        float a2 = (float) a(this.f14727m);
        if (width <= a2) {
            int i3 = AnonymousClass4.f14744a[this.I.ordinal()];
            if (i3 != 2) {
                float f5 = a2 - width;
                if (i3 != 3) {
                    f5 /= 2.0f;
                }
                f3 = f5 - b2.left;
            } else {
                f3 = -b2.left;
            }
            this.E = 2;
        } else if (b2.left > 0.0f) {
            this.E = 0;
            f3 = -b2.left;
        } else if (b2.right < a2) {
            f3 = a2 - b2.right;
            this.E = 1;
        } else {
            this.E = -1;
        }
        this.f14732r.postTranslate(f3, f2);
        return true;
    }

    private void o() {
        b bVar = this.D;
        if (bVar != null) {
            bVar.a();
            this.D = null;
        }
    }

    public RectF a() {
        n();
        return b(k());
    }

    public void a(float f2) {
        this.f14732r.setRotate(f2 % 360.0f);
        m();
    }

    public void a(float f2, float f3, float f4, boolean z2) {
        if (f2 < this.f14722h || f2 > this.f14724j) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        } else if (z2) {
            this.f14727m.post(new a(e(), f2, f3, f4));
        } else {
            this.f14732r.setScale(f2, f2, f3, f4);
            m();
        }
    }

    public void a(float f2, boolean z2) {
        a(f2, (float) (this.f14727m.getRight() / 2), (float) (this.f14727m.getBottom() / 2), z2);
    }

    public void a(int i2) {
        this.f14721g = i2;
    }

    public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f14728n.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f14739y = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.f14740z = onLongClickListener;
    }

    public void a(ImageView.ScaleType scaleType) {
        if (l.a(scaleType) && scaleType != this.I) {
            this.I = scaleType;
            g();
        }
    }

    public void a(d dVar) {
        this.f14735u = dVar;
    }

    public void a(e eVar) {
        this.f14737w = eVar;
    }

    public void a(f fVar) {
        this.f14736v = fVar;
    }

    public void a(g gVar) {
        this.A = gVar;
    }

    public void a(h hVar) {
        this.B = hVar;
    }

    public void a(i iVar) {
        this.C = iVar;
    }

    public void a(j jVar) {
        this.f14738x = jVar;
    }

    public void a(boolean z2) {
        this.f14725k = z2;
    }

    public float b() {
        return this.f14722h;
    }

    public void b(float f2) {
        this.f14732r.postRotate(f2 % 360.0f);
        m();
    }

    public void b(boolean z2) {
        this.H = z2;
        g();
    }

    public float c() {
        return this.f14723i;
    }

    public void c(float f2) {
        l.a(f2, this.f14723i, this.f14724j);
        this.f14722h = f2;
    }

    public float d() {
        return this.f14724j;
    }

    public void d(float f2) {
        l.a(this.f14722h, f2, this.f14724j);
        this.f14723i = f2;
    }

    public float e() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) a(this.f14732r, 0), 2.0d)) + ((float) Math.pow((double) a(this.f14732r, 3), 2.0d))));
    }

    public void e(float f2) {
        l.a(this.f14722h, this.f14723i, f2);
        this.f14724j = f2;
    }

    public ImageView.ScaleType f() {
        return this.I;
    }

    public void f(float f2) {
        a(f2, false);
    }

    public void g() {
        if (this.H) {
            a(this.f14727m.getDrawable());
        } else {
            l();
        }
    }

    public Matrix h() {
        return this.f14731q;
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 != i6 || i3 != i7 || i4 != i8 || i5 != i9) {
            a(this.f14727m.getDrawable());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ba A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.H
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00bb
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.github.chrisbanes.photoview.l.a((android.widget.ImageView) r0)
            if (r0 == 0) goto L_0x00bb
            int r0 = r12.getAction()
            if (r0 == 0) goto L_0x006b
            if (r0 == r2) goto L_0x001b
            r3 = 3
            if (r0 == r3) goto L_0x001b
            goto L_0x0077
        L_0x001b:
            float r0 = r10.e()
            float r3 = r10.f14722h
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0041
            android.graphics.RectF r0 = r10.a()
            if (r0 == 0) goto L_0x0077
            com.github.chrisbanes.photoview.k$a r9 = new com.github.chrisbanes.photoview.k$a
            float r5 = r10.e()
            float r6 = r10.f14722h
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            goto L_0x0066
        L_0x0041:
            float r0 = r10.e()
            float r3 = r10.f14724j
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0077
            android.graphics.RectF r0 = r10.a()
            if (r0 == 0) goto L_0x0077
            com.github.chrisbanes.photoview.k$a r9 = new com.github.chrisbanes.photoview.k$a
            float r5 = r10.e()
            float r6 = r10.f14724j
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
        L_0x0066:
            r11.post(r9)
            r11 = 1
            goto L_0x0078
        L_0x006b:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L_0x0074
            r11.requestDisallowInterceptTouchEvent(r2)
        L_0x0074:
            r10.o()
        L_0x0077:
            r11 = 0
        L_0x0078:
            com.github.chrisbanes.photoview.b r0 = r10.f14729o
            if (r0 == 0) goto L_0x00af
            boolean r11 = r0.a()
            com.github.chrisbanes.photoview.b r0 = r10.f14729o
            boolean r0 = r0.b()
            com.github.chrisbanes.photoview.b r3 = r10.f14729o
            boolean r3 = r3.a((android.view.MotionEvent) r12)
            if (r11 != 0) goto L_0x0098
            com.github.chrisbanes.photoview.b r11 = r10.f14729o
            boolean r11 = r11.a()
            if (r11 != 0) goto L_0x0098
            r11 = 1
            goto L_0x0099
        L_0x0098:
            r11 = 0
        L_0x0099:
            if (r0 != 0) goto L_0x00a5
            com.github.chrisbanes.photoview.b r0 = r10.f14729o
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x00a5
            r0 = 1
            goto L_0x00a6
        L_0x00a5:
            r0 = 0
        L_0x00a6:
            if (r11 == 0) goto L_0x00ab
            if (r0 == 0) goto L_0x00ab
            r1 = 1
        L_0x00ab:
            r10.f14726l = r1
            r1 = r3
            goto L_0x00b0
        L_0x00af:
            r1 = r11
        L_0x00b0:
            android.view.GestureDetector r11 = r10.f14728n
            if (r11 == 0) goto L_0x00bb
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto L_0x00bb
            r1 = 1
        L_0x00bb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.chrisbanes.photoview.k.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
