package com.flypro.photoview_library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import ep.f;
import java.lang.ref.WeakReference;

public class d implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, c, ep.e {

    /* renamed from: a  reason: collision with root package name */
    static final Interpolator f14475a = new AccelerateDecelerateInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f14476c = Log.isLoggable("PhotoViewAttacher", 3);
    private ImageView.ScaleType A = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: b  reason: collision with root package name */
    int f14477b = 200;

    /* renamed from: d  reason: collision with root package name */
    private float f14478d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f14479e = 1.75f;

    /* renamed from: f  reason: collision with root package name */
    private float f14480f = 3.0f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14481g = true;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<ImageView> f14482h;

    /* renamed from: i  reason: collision with root package name */
    private GestureDetector f14483i;

    /* renamed from: j  reason: collision with root package name */
    private ep.d f14484j;

    /* renamed from: k  reason: collision with root package name */
    private final Matrix f14485k = new Matrix();

    /* renamed from: l  reason: collision with root package name */
    private final Matrix f14486l = new Matrix();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Matrix f14487m = new Matrix();

    /* renamed from: n  reason: collision with root package name */
    private final RectF f14488n = new RectF();

    /* renamed from: o  reason: collision with root package name */
    private final float[] f14489o = new float[9];

    /* renamed from: p  reason: collision with root package name */
    private c f14490p;

    /* renamed from: q  reason: collision with root package name */
    private C0104d f14491q;

    /* renamed from: r  reason: collision with root package name */
    private e f14492r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public View.OnLongClickListener f14493s;

    /* renamed from: t  reason: collision with root package name */
    private int f14494t;

    /* renamed from: u  reason: collision with root package name */
    private int f14495u;

    /* renamed from: v  reason: collision with root package name */
    private int f14496v;

    /* renamed from: w  reason: collision with root package name */
    private int f14497w;

    /* renamed from: x  reason: collision with root package name */
    private b f14498x;

    /* renamed from: y  reason: collision with root package name */
    private int f14499y = 2;

    /* renamed from: z  reason: collision with root package name */
    private boolean f14500z;

    /* renamed from: com.flypro.photoview_library.d$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14502a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14502a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14502a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14502a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14502a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f14502a     // Catch:{ NoSuchFieldError -> 0x003e }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flypro.photoview_library.d.AnonymousClass2.<clinit>():void");
        }
    }

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final float f14504b;

        /* renamed from: c  reason: collision with root package name */
        private final float f14505c;

        /* renamed from: d  reason: collision with root package name */
        private final long f14506d = System.currentTimeMillis();

        /* renamed from: e  reason: collision with root package name */
        private final float f14507e;

        /* renamed from: f  reason: collision with root package name */
        private final float f14508f;

        public a(float f2, float f3, float f4, float f5) {
            this.f14504b = f4;
            this.f14505c = f5;
            this.f14507e = f2;
            this.f14508f = f3;
        }

        private float a() {
            return d.f14475a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f14506d)) * 1.0f) / ((float) d.this.f14477b)));
        }

        public void run() {
            ImageView c2 = d.this.c();
            if (c2 != null) {
                float a2 = a();
                float f2 = this.f14507e;
                float g2 = (f2 + ((this.f14508f - f2) * a2)) / d.this.g();
                d.this.f14487m.postScale(g2, g2, this.f14504b, this.f14505c);
                d.this.p();
                if (a2 < 1.0f) {
                    a.a(c2, this);
                }
            }
        }
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final er.d f14510b;

        /* renamed from: c  reason: collision with root package name */
        private int f14511c;

        /* renamed from: d  reason: collision with root package name */
        private int f14512d;

        public b(Context context) {
            this.f14510b = er.d.a(context);
        }

        public void a() {
            if (d.f14476c) {
                eq.a.a().a("PhotoViewAttacher", "Cancel Fling");
            }
            this.f14510b.a(true);
        }

        public void a(int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            RectF b2 = d.this.b();
            if (b2 != null) {
                int round = Math.round(-b2.left);
                float f2 = (float) i2;
                if (f2 < b2.width()) {
                    i6 = Math.round(b2.width() - f2);
                    i7 = 0;
                } else {
                    i7 = round;
                    i6 = i7;
                }
                int round2 = Math.round(-b2.top);
                float f3 = (float) i3;
                if (f3 < b2.height()) {
                    i8 = Math.round(b2.height() - f3);
                    i9 = 0;
                } else {
                    i9 = round2;
                    i8 = i9;
                }
                this.f14511c = round;
                this.f14512d = round2;
                if (d.f14476c) {
                    eq.b a2 = eq.a.a();
                    a2.a("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i6 + " MaxY:" + i8);
                }
                if (round != i6 || round2 != i8) {
                    this.f14510b.a(round, round2, i4, i5, i7, i6, i9, i8, 0, 0);
                }
            }
        }

        public void run() {
            ImageView c2;
            if (!this.f14510b.b() && (c2 = d.this.c()) != null && this.f14510b.a()) {
                int c3 = this.f14510b.c();
                int d2 = this.f14510b.d();
                if (d.f14476c) {
                    eq.b a2 = eq.a.a();
                    a2.a("PhotoViewAttacher", "fling run(). CurrentX:" + this.f14511c + " CurrentY:" + this.f14512d + " NewX:" + c3 + " NewY:" + d2);
                }
                d.this.f14487m.postTranslate((float) (this.f14511c - c3), (float) (this.f14512d - d2));
                d dVar = d.this;
                dVar.b(dVar.l());
                this.f14511c = c3;
                this.f14512d = d2;
                a.a(c2, this);
            }
        }
    }

    public interface c {
        void a(RectF rectF);
    }

    /* renamed from: com.flypro.photoview_library.d$d  reason: collision with other inner class name */
    public interface C0104d {
        void onPhotoTap(View view, float f2, float f3);
    }

    public interface e {
        void a(View view, float f2, float f3);
    }

    public d(ImageView imageView) {
        this.f14482h = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        b(imageView);
        if (!imageView.isInEditMode()) {
            this.f14484j = f.a(imageView.getContext(), this);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public void onLongPress(MotionEvent motionEvent) {
                    if (d.this.f14493s != null) {
                        d.this.f14493s.onLongClick(d.this.c());
                    }
                }
            });
            this.f14483i = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new b(this));
            b(true);
        }
    }

    private float a(Matrix matrix, int i2) {
        matrix.getValues(this.f14489o);
        return this.f14489o[i2];
    }

    private RectF a(Matrix matrix) {
        Drawable drawable;
        ImageView c2 = c();
        if (c2 == null || (drawable = c2.getDrawable()) == null) {
            return null;
        }
        this.f14488n.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.f14488n);
        return this.f14488n;
    }

    private void a(Drawable drawable) {
        Matrix.ScaleToFit scaleToFit;
        Matrix matrix;
        float min;
        ImageView c2 = c();
        if (c2 != null && drawable != null) {
            float c3 = (float) c(c2);
            float d2 = (float) d(c2);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.f14485k.reset();
            float f2 = (float) intrinsicWidth;
            float f3 = c3 / f2;
            float f4 = (float) intrinsicHeight;
            float f5 = d2 / f4;
            if (this.A == ImageView.ScaleType.CENTER) {
                this.f14485k.postTranslate((c3 - f2) / 2.0f, (d2 - f4) / 2.0f);
            } else {
                if (this.A == ImageView.ScaleType.CENTER_CROP) {
                    min = Math.max(f3, f5);
                } else if (this.A == ImageView.ScaleType.CENTER_INSIDE) {
                    min = Math.min(1.0f, Math.min(f3, f5));
                } else {
                    RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
                    RectF rectF2 = new RectF(0.0f, 0.0f, c3, d2);
                    int i2 = AnonymousClass2.f14502a[this.A.ordinal()];
                    if (i2 == 2) {
                        matrix = this.f14485k;
                        scaleToFit = Matrix.ScaleToFit.START;
                    } else if (i2 == 3) {
                        matrix = this.f14485k;
                        scaleToFit = Matrix.ScaleToFit.END;
                    } else if (i2 == 4) {
                        matrix = this.f14485k;
                        scaleToFit = Matrix.ScaleToFit.CENTER;
                    } else if (i2 == 5) {
                        matrix = this.f14485k;
                        scaleToFit = Matrix.ScaleToFit.FILL;
                    }
                    matrix.setRectToRect(rectF, rectF2, scaleToFit);
                }
                this.f14485k.postScale(min, min);
                this.f14485k.postTranslate((c3 - (f2 * min)) / 2.0f, (d2 - (f4 * min)) / 2.0f);
            }
            s();
        }
    }

    private static boolean a(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static void b(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        } else if (f3 >= f4) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    /* access modifiers changed from: private */
    public void b(Matrix matrix) {
        RectF a2;
        ImageView c2 = c();
        if (c2 != null) {
            q();
            c2.setImageMatrix(matrix);
            if (this.f14490p != null && (a2 = a(matrix)) != null) {
                this.f14490p.a(a2);
            }
        }
    }

    private static void b(ImageView imageView) {
        if (imageView != null && !(imageView instanceof c) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    private static boolean b(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (AnonymousClass2.f14502a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    private int c(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private int d(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private void o() {
        b bVar = this.f14498x;
        if (bVar != null) {
            bVar.a();
            this.f14498x = null;
        }
    }

    /* access modifiers changed from: private */
    public void p() {
        if (r()) {
            b(l());
        }
    }

    private void q() {
        ImageView c2 = c();
        if (c2 != null && !(c2 instanceof c) && !ImageView.ScaleType.MATRIX.equals(c2.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean r() {
        /*
            r12 = this;
            android.widget.ImageView r0 = r12.c()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.graphics.Matrix r2 = r12.l()
            android.graphics.RectF r2 = r12.a((android.graphics.Matrix) r2)
            if (r2 != 0) goto L_0x0013
            return r1
        L_0x0013:
            float r3 = r2.height()
            float r4 = r2.width()
            int r5 = r12.d((android.widget.ImageView) r0)
            float r5 = (float) r5
            r6 = 1073741824(0x40000000, float:2.0)
            r7 = 3
            r8 = 2
            r9 = 0
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 > 0) goto L_0x003d
            int[] r10 = com.flypro.photoview_library.d.AnonymousClass2.f14502a
            android.widget.ImageView$ScaleType r11 = r12.A
            int r11 = r11.ordinal()
            r10 = r10[r11]
            if (r10 == r8) goto L_0x0043
            float r5 = r5 - r3
            if (r10 == r7) goto L_0x0039
            float r5 = r5 / r6
        L_0x0039:
            float r3 = r2.top
        L_0x003b:
            float r5 = r5 - r3
            goto L_0x0051
        L_0x003d:
            float r3 = r2.top
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x0047
        L_0x0043:
            float r3 = r2.top
            float r5 = -r3
            goto L_0x0051
        L_0x0047:
            float r3 = r2.bottom
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0050
            float r3 = r2.bottom
            goto L_0x003b
        L_0x0050:
            r5 = 0
        L_0x0051:
            int r0 = r12.c((android.widget.ImageView) r0)
            float r0 = (float) r0
            r3 = 1
            int r10 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x0076
            int[] r1 = com.flypro.photoview_library.d.AnonymousClass2.f14502a
            android.widget.ImageView$ScaleType r9 = r12.A
            int r9 = r9.ordinal()
            r1 = r1[r9]
            if (r1 == r8) goto L_0x006f
            float r0 = r0 - r4
            if (r1 == r7) goto L_0x006b
            float r0 = r0 / r6
        L_0x006b:
            float r1 = r2.left
            float r0 = r0 - r1
            goto L_0x0072
        L_0x006f:
            float r0 = r2.left
            float r0 = -r0
        L_0x0072:
            r9 = r0
            r12.f14499y = r8
            goto L_0x0092
        L_0x0076:
            float r4 = r2.left
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x0082
            r12.f14499y = r1
            float r0 = r2.left
            float r9 = -r0
            goto L_0x0092
        L_0x0082:
            float r1 = r2.right
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x008f
            float r1 = r2.right
            float r9 = r0 - r1
            r12.f14499y = r3
            goto L_0x0092
        L_0x008f:
            r0 = -1
            r12.f14499y = r0
        L_0x0092:
            android.graphics.Matrix r0 = r12.f14487m
            r0.postTranslate(r9, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flypro.photoview_library.d.r():boolean");
    }

    private void s() {
        this.f14487m.reset();
        b(l());
        r();
    }

    public void a() {
        WeakReference<ImageView> weakReference = this.f14482h;
        if (weakReference != null) {
            ImageView imageView = (ImageView) weakReference.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener((View.OnTouchListener) null);
                o();
            }
            GestureDetector gestureDetector = this.f14483i;
            if (gestureDetector != null) {
                gestureDetector.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) null);
            }
            this.f14490p = null;
            this.f14491q = null;
            this.f14492r = null;
            this.f14482h = null;
        }
    }

    public void a(float f2) {
        this.f14487m.setRotate(f2 % 360.0f);
        p();
    }

    public void a(float f2, float f3) {
        if (!this.f14484j.a()) {
            if (f14476c) {
                eq.a.a().a("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[]{Float.valueOf(f2), Float.valueOf(f3)}));
            }
            ImageView c2 = c();
            this.f14487m.postTranslate(f2, f3);
            p();
            ViewParent parent = c2.getParent();
            if (this.f14481g && !this.f14484j.a()) {
                int i2 = this.f14499y;
                if ((i2 == 2 || ((i2 == 0 && f2 >= 1.0f) || (i2 == 1 && f2 <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public void a(float f2, float f3, float f4) {
        if (f14476c) {
            eq.a.a().a("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}));
        }
        if (g() < this.f14480f || f2 < 1.0f) {
            this.f14487m.postScale(f2, f2, f3, f4);
            p();
        }
    }

    public void a(float f2, float f3, float f4, float f5) {
        if (f14476c) {
            eq.b a2 = eq.a.a();
            a2.a("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView c2 = c();
        b bVar = new b(c2.getContext());
        this.f14498x = bVar;
        bVar.a(c(c2), d(c2), (int) f4, (int) f5);
        c2.post(this.f14498x);
    }

    public void a(float f2, float f3, float f4, boolean z2) {
        ImageView c2 = c();
        if (c2 == null) {
            return;
        }
        if (f2 < this.f14478d || f2 > this.f14480f) {
            eq.a.a().b("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
        } else if (z2) {
            c2.post(new a(g(), f2, f3, f4));
        } else {
            this.f14487m.setScale(f2, f2, f3, f4);
            p();
        }
    }

    public void a(float f2, boolean z2) {
        ImageView c2 = c();
        if (c2 != null) {
            a(f2, (float) (c2.getRight() / 2), (float) (c2.getBottom() / 2), z2);
        }
    }

    public void a(int i2) {
        if (i2 < 0) {
            i2 = 200;
        }
        this.f14477b = i2;
    }

    public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.f14483i.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.f14483i.setOnDoubleTapListener(new b(this));
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.f14493s = onLongClickListener;
    }

    public void a(ImageView.ScaleType scaleType) {
        if (b(scaleType) && scaleType != this.A) {
            this.A = scaleType;
            k();
        }
    }

    public void a(c cVar) {
        this.f14490p = cVar;
    }

    public void a(C0104d dVar) {
        this.f14491q = dVar;
    }

    public void a(e eVar) {
        this.f14492r = eVar;
    }

    public void a(boolean z2) {
        this.f14481g = z2;
    }

    public RectF b() {
        r();
        return a(l());
    }

    public void b(float f2) {
        this.f14487m.postRotate(f2 % 360.0f);
        p();
    }

    public void b(boolean z2) {
        this.f14500z = z2;
        k();
    }

    public ImageView c() {
        WeakReference<ImageView> weakReference = this.f14482h;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        if (imageView == null) {
            a();
            Log.i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public void c(float f2) {
        b(f2, this.f14479e, this.f14480f);
        this.f14478d = f2;
    }

    public float d() {
        return this.f14478d;
    }

    public void d(float f2) {
        b(this.f14478d, f2, this.f14480f);
        this.f14479e = f2;
    }

    public float e() {
        return this.f14479e;
    }

    public void e(float f2) {
        b(this.f14478d, this.f14479e, f2);
        this.f14480f = f2;
    }

    public float f() {
        return this.f14480f;
    }

    public void f(float f2) {
        a(f2, false);
    }

    public float g() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) a(this.f14487m, 0), 2.0d)) + ((float) Math.pow((double) a(this.f14487m, 3), 2.0d))));
    }

    public ImageView.ScaleType h() {
        return this.A;
    }

    public C0104d i() {
        return this.f14491q;
    }

    public e j() {
        return this.f14492r;
    }

    public void k() {
        ImageView c2 = c();
        if (c2 == null) {
            return;
        }
        if (this.f14500z) {
            b(c2);
            a(c2.getDrawable());
            return;
        }
        s();
    }

    public Matrix l() {
        this.f14486l.set(this.f14485k);
        this.f14486l.postConcat(this.f14487m);
        return this.f14486l;
    }

    public Bitmap m() {
        ImageView c2 = c();
        if (c2 == null) {
            return null;
        }
        return c2.getDrawingCache();
    }

    public void onGlobalLayout() {
        ImageView c2 = c();
        if (c2 == null) {
            return;
        }
        if (this.f14500z) {
            int top = c2.getTop();
            int right = c2.getRight();
            int bottom = c2.getBottom();
            int left = c2.getLeft();
            if (top != this.f14494t || bottom != this.f14496v || left != this.f14497w || right != this.f14495u) {
                a(c2.getDrawable());
                this.f14494t = top;
                this.f14495u = right;
                this.f14496v = bottom;
                this.f14497w = left;
                return;
            }
            return;
        }
        a(c2.getDrawable());
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF b2;
        boolean z2 = false;
        if (!this.f14500z || !a((ImageView) view)) {
            return false;
        }
        ViewParent parent = view.getParent();
        int action = motionEvent.getAction();
        if (action == 0) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            } else {
                Log.i("PhotoViewAttacher", "onTouch getParent() returned null");
            }
            o();
        } else if ((action == 1 || action == 3) && g() < this.f14478d && (b2 = b()) != null) {
            view.post(new a(g(), this.f14478d, b2.centerX(), b2.centerY()));
            z2 = true;
        }
        ep.d dVar = this.f14484j;
        if (dVar != null && dVar.c(motionEvent)) {
            z2 = true;
        }
        GestureDetector gestureDetector = this.f14483i;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(motionEvent)) {
            return z2;
        }
        return true;
    }
}
