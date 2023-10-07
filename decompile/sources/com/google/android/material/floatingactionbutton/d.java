package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.R;
import gw.h;
import gw.i;
import gw.m;
import gw.p;
import java.util.ArrayList;
import java.util.Iterator;
import t.ac;

class d {

    /* renamed from: a  reason: collision with root package name */
    static final TimeInterpolator f19113a = gl.a.f28537c;

    /* renamed from: m  reason: collision with root package name */
    static final int[] f19114m = {16842919, 16842910};

    /* renamed from: n  reason: collision with root package name */
    static final int[] f19115n = {16843623, 16842908, 16842910};

    /* renamed from: o  reason: collision with root package name */
    static final int[] f19116o = {16842908, 16842910};

    /* renamed from: p  reason: collision with root package name */
    static final int[] f19117p = {16843623, 16842910};

    /* renamed from: q  reason: collision with root package name */
    static final int[] f19118q = {16842910};

    /* renamed from: r  reason: collision with root package name */
    static final int[] f19119r = new int[0];
    private float A;
    /* access modifiers changed from: private */
    public float B = 1.0f;
    private int C;
    /* access modifiers changed from: private */
    public int D = 0;
    private ArrayList<Animator.AnimatorListener> E;
    private ArrayList<Animator.AnimatorListener> F;
    private ArrayList<C0129d> G;
    private final Rect H = new Rect();
    private final RectF I = new RectF();
    private final RectF J = new RectF();
    private final Matrix K = new Matrix();
    private ViewTreeObserver.OnPreDrawListener L;

    /* renamed from: b  reason: collision with root package name */
    m f19120b;

    /* renamed from: c  reason: collision with root package name */
    h f19121c;

    /* renamed from: d  reason: collision with root package name */
    Drawable f19122d;

    /* renamed from: e  reason: collision with root package name */
    c f19123e;

    /* renamed from: f  reason: collision with root package name */
    Drawable f19124f;

    /* renamed from: g  reason: collision with root package name */
    boolean f19125g;

    /* renamed from: h  reason: collision with root package name */
    boolean f19126h = true;

    /* renamed from: i  reason: collision with root package name */
    float f19127i;

    /* renamed from: j  reason: collision with root package name */
    float f19128j;

    /* renamed from: k  reason: collision with root package name */
    float f19129k;

    /* renamed from: l  reason: collision with root package name */
    int f19130l;

    /* renamed from: s  reason: collision with root package name */
    final FloatingActionButton f19131s;

    /* renamed from: t  reason: collision with root package name */
    final gv.b f19132t;

    /* renamed from: u  reason: collision with root package name */
    private final com.google.android.material.internal.h f19133u;

    /* renamed from: v  reason: collision with root package name */
    private gl.h f19134v;

    /* renamed from: w  reason: collision with root package name */
    private gl.h f19135w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public Animator f19136x;

    /* renamed from: y  reason: collision with root package name */
    private gl.h f19137y;

    /* renamed from: z  reason: collision with root package name */
    private gl.h f19138z;

    private class a extends g {
        a() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            return 0.0f;
        }
    }

    private class b extends g {
        b() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            return d.this.f19127i + d.this.f19128j;
        }
    }

    private class c extends g {
        c() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            return d.this.f19127i + d.this.f19129k;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.d$d  reason: collision with other inner class name */
    interface C0129d {
        void a();

        void b();
    }

    interface e {
        void a();

        void b();
    }

    private class f extends g {
        f() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            return d.this.f19127i;
        }
    }

    private abstract class g extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f19154a;

        /* renamed from: c  reason: collision with root package name */
        private float f19156c;

        /* renamed from: d  reason: collision with root package name */
        private float f19157d;

        private g() {
        }

        /* access modifiers changed from: protected */
        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            d.this.e((float) ((int) this.f19157d));
            this.f19154a = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f19154a) {
                this.f19156c = d.this.f19121c == null ? 0.0f : d.this.f19121c.V();
                this.f19157d = a();
                this.f19154a = true;
            }
            d dVar = d.this;
            float f2 = this.f19156c;
            dVar.e((float) ((int) (f2 + ((this.f19157d - f2) * valueAnimator.getAnimatedFraction()))));
        }
    }

    d(FloatingActionButton floatingActionButton, gv.b bVar) {
        this.f19131s = floatingActionButton;
        this.f19132t = bVar;
        com.google.android.material.internal.h hVar = new com.google.android.material.internal.h();
        this.f19133u = hVar;
        hVar.a(f19114m, a((g) new c()));
        hVar.a(f19115n, a((g) new b()));
        hVar.a(f19116o, a((g) new b()));
        hVar.a(f19117p, a((g) new b()));
        hVar.a(f19118q, a((g) new f()));
        hVar.a(f19119r, a((g) new a()));
        this.A = floatingActionButton.getRotation();
    }

    private ViewTreeObserver.OnPreDrawListener A() {
        if (this.L == null) {
            this.L = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    d.this.t();
                    return true;
                }
            };
        }
        return this.L;
    }

    private boolean B() {
        return ac.G(this.f19131s) && !this.f19131s.isInEditMode();
    }

    private AnimatorSet a(gl.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f19131s, View.ALPHA, new float[]{f2});
        hVar.b("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f19131s, View.SCALE_X, new float[]{f3});
        hVar.b("scale").a((Animator) ofFloat2);
        a(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f19131s, View.SCALE_Y, new float[]{f3});
        hVar.b("scale").a((Animator) ofFloat3);
        a(ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.K);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f19131s, new gl.f(), new gl.g() {
            /* renamed from: a */
            public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
                float unused = d.this.B = f2;
                return super.evaluate(f2, matrix, matrix2);
            }
        }, new Matrix[]{new Matrix(this.K)});
        hVar.b("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        gl.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private ValueAnimator a(g gVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f19113a);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(gVar);
        valueAnimator.addUpdateListener(gVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f19131s.getDrawable();
        if (drawable != null && this.C != 0) {
            RectF rectF = this.I;
            RectF rectF2 = this.J;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.C;
            rectF2.set(0.0f, 0.0f, (float) i2, (float) i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.C;
            matrix.postScale(f2, f2, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    private void a(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimator.setEvaluator(new TypeEvaluator<Float>() {

                /* renamed from: a  reason: collision with root package name */
                FloatEvaluator f19147a = new FloatEvaluator();

                /* renamed from: a */
                public Float evaluate(float f2, Float f3, Float f4) {
                    float floatValue = this.f19147a.evaluate(f2, f3, f4).floatValue();
                    if (floatValue < 0.1f) {
                        floatValue = 0.0f;
                    }
                    return Float.valueOf(floatValue);
                }
            });
        }
    }

    private gl.h y() {
        if (this.f19134v == null) {
            this.f19134v = gl.h.a(this.f19131s.getContext(), R.animator.design_fab_show_motion_spec);
        }
        return (gl.h) s.f.a(this.f19134v);
    }

    private gl.h z() {
        if (this.f19135w == null) {
            this.f19135w = gl.h.a(this.f19131s.getContext(), R.animator.design_fab_hide_motion_spec);
        }
        return (gl.h) s.f.a(this.f19135w);
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f19127i;
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2) {
        if (this.f19127i != f2) {
            this.f19127i = f2;
            a(f2, this.f19128j, this.f19129k);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4) {
        o();
        e(f2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.f19130l = i2;
    }

    /* access modifiers changed from: package-private */
    public void a(Animator.AnimatorListener animatorListener) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        h hVar = this.f19121c;
        if (hVar != null) {
            hVar.setTintList(colorStateList);
        }
        c cVar = this.f19123e;
        if (cVar != null) {
            cVar.a(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        h u2 = u();
        this.f19121c = u2;
        u2.setTintList(colorStateList);
        if (mode != null) {
            this.f19121c.setTintMode(mode);
        }
        this.f19121c.G(-12303292);
        this.f19121c.a(this.f19131s.getContext());
        gu.a aVar = new gu.a(this.f19121c.M());
        aVar.setTintList(gu.b.b(colorStateList2));
        this.f19122d = aVar;
        this.f19124f = new LayerDrawable(new Drawable[]{(Drawable) s.f.a(this.f19121c), aVar});
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        h hVar = this.f19121c;
        if (hVar != null) {
            hVar.setTintMode(mode);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        int sizeDimension = this.f19125g ? (this.f19130l - this.f19131s.getSizeDimension()) / 2 : 0;
        float a2 = this.f19126h ? a() + this.f19129k : 0.0f;
        int max = Math.max(sizeDimension, (int) Math.ceil((double) a2));
        int max2 = Math.max(sizeDimension, (int) Math.ceil((double) (a2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    /* access modifiers changed from: package-private */
    public void a(C0129d dVar) {
        if (this.G == null) {
            this.G = new ArrayList<>();
        }
        this.G.add(dVar);
    }

    /* access modifiers changed from: package-private */
    public void a(final e eVar, final boolean z2) {
        if (!w()) {
            Animator animator = this.f19136x;
            if (animator != null) {
                animator.cancel();
            }
            if (B()) {
                gl.h hVar = this.f19138z;
                if (hVar == null) {
                    hVar = z();
                }
                AnimatorSet a2 = a(hVar, 0.0f, 0.0f, 0.0f);
                a2.addListener(new AnimatorListenerAdapter() {

                    /* renamed from: d  reason: collision with root package name */
                    private boolean f19142d;

                    public void onAnimationCancel(Animator animator) {
                        this.f19142d = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        int unused = d.this.D = 0;
                        Animator unused2 = d.this.f19136x = null;
                        if (!this.f19142d) {
                            FloatingActionButton floatingActionButton = d.this.f19131s;
                            boolean z2 = z2;
                            floatingActionButton.a(z2 ? 8 : 4, z2);
                            e eVar = eVar;
                            if (eVar != null) {
                                eVar.b();
                            }
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        d.this.f19131s.a(0, z2);
                        int unused = d.this.D = 1;
                        Animator unused2 = d.this.f19136x = animator;
                        this.f19142d = false;
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = this.F;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        a2.addListener(it2.next());
                    }
                }
                a2.start();
                return;
            }
            this.f19131s.a(z2 ? 8 : 4, z2);
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(gl.h hVar) {
        this.f19137y = hVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(m mVar) {
        this.f19120b = mVar;
        h hVar = this.f19121c;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(mVar);
        }
        Drawable drawable = this.f19122d;
        if (drawable instanceof p) {
            ((p) drawable).setShapeAppearanceModel(mVar);
        }
        c cVar = this.f19123e;
        if (cVar != null) {
            cVar.a(mVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.f19125g = z2;
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr) {
        this.f19133u.a(iArr);
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f19128j;
    }

    /* access modifiers changed from: package-private */
    public final void b(float f2) {
        if (this.f19128j != f2) {
            this.f19128j = f2;
            a(this.f19127i, f2, this.f19129k);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        if (this.C != i2) {
            this.C = i2;
            d();
        }
    }

    public void b(Animator.AnimatorListener animatorListener) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.f19122d;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, gu.b.b(colorStateList));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.graphics.drawable.Drawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.graphics.drawable.InsetDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.graphics.drawable.InsetDrawable} */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.graphics.Rect r8) {
        /*
            r7 = this;
            android.graphics.drawable.Drawable r0 = r7.f19124f
            java.lang.String r1 = "Didn't initialize content background"
            s.f.a(r0, (java.lang.Object) r1)
            boolean r0 = r7.p()
            if (r0 == 0) goto L_0x0020
            android.graphics.drawable.InsetDrawable r0 = new android.graphics.drawable.InsetDrawable
            android.graphics.drawable.Drawable r2 = r7.f19124f
            int r3 = r8.left
            int r4 = r8.top
            int r5 = r8.right
            int r6 = r8.bottom
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            gv.b r8 = r7.f19132t
            goto L_0x0024
        L_0x0020:
            gv.b r8 = r7.f19132t
            android.graphics.drawable.Drawable r0 = r7.f19124f
        L_0x0024:
            r8.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.d.b(android.graphics.Rect):void");
    }

    /* access modifiers changed from: package-private */
    public void b(final e eVar, final boolean z2) {
        if (!v()) {
            Animator animator = this.f19136x;
            if (animator != null) {
                animator.cancel();
            }
            if (B()) {
                if (this.f19131s.getVisibility() != 0) {
                    this.f19131s.setAlpha(0.0f);
                    this.f19131s.setScaleY(0.0f);
                    this.f19131s.setScaleX(0.0f);
                    d(0.0f);
                }
                gl.h hVar = this.f19137y;
                if (hVar == null) {
                    hVar = y();
                }
                AnimatorSet a2 = a(hVar, 1.0f, 1.0f, 1.0f);
                a2.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        int unused = d.this.D = 0;
                        Animator unused2 = d.this.f19136x = null;
                        e eVar = eVar;
                        if (eVar != null) {
                            eVar.a();
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        d.this.f19131s.a(0, z2);
                        int unused = d.this.D = 2;
                        Animator unused2 = d.this.f19136x = animator;
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = this.E;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        a2.addListener(it2.next());
                    }
                }
                a2.start();
                return;
            }
            this.f19131s.a(0, z2);
            this.f19131s.setAlpha(1.0f);
            this.f19131s.setScaleY(1.0f);
            this.f19131s.setScaleX(1.0f);
            d(1.0f);
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(gl.h hVar) {
        this.f19138z = hVar;
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.f19126h = z2;
        o();
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f19129k;
    }

    /* access modifiers changed from: package-private */
    public final void c(float f2) {
        if (this.f19129k != f2) {
            this.f19129k = f2;
            a(this.f19127i, this.f19128j, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        d(this.B);
    }

    /* access modifiers changed from: package-private */
    public final void d(float f2) {
        this.B = f2;
        Matrix matrix = this.K;
        a(f2, matrix);
        this.f19131s.setImageMatrix(matrix);
    }

    /* access modifiers changed from: package-private */
    public final m e() {
        return this.f19120b;
    }

    /* access modifiers changed from: package-private */
    public void e(float f2) {
        h hVar = this.f19121c;
        if (hVar != null) {
            hVar.r(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public final gl.h f() {
        return this.f19137y;
    }

    /* access modifiers changed from: package-private */
    public final gl.h g() {
        return this.f19138z;
    }

    /* access modifiers changed from: package-private */
    public final boolean h() {
        return !this.f19125g || this.f19131s.getSizeDimension() >= this.f19130l;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f19125g;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f19133u.a();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        ArrayList<C0129d> arrayList = this.G;
        if (arrayList != null) {
            Iterator<C0129d> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        ArrayList<C0129d> arrayList = this.G;
        if (arrayList != null) {
            Iterator<C0129d> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Drawable m() {
        return this.f19124f;
    }

    /* access modifiers changed from: package-private */
    public void n() {
    }

    /* access modifiers changed from: package-private */
    public final void o() {
        Rect rect = this.H;
        a(rect);
        b(rect);
        this.f19132t.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        h hVar = this.f19121c;
        if (hVar != null) {
            i.a((View) this.f19131s, hVar);
        }
        if (s()) {
            this.f19131s.getViewTreeObserver().addOnPreDrawListener(A());
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        ViewTreeObserver viewTreeObserver = this.f19131s.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.L;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.L = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        float rotation = this.f19131s.getRotation();
        if (this.A != rotation) {
            this.A = rotation;
            x();
        }
    }

    /* access modifiers changed from: package-private */
    public h u() {
        return new h((m) s.f.a(this.f19120b));
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        return this.f19131s.getVisibility() != 0 ? this.D == 2 : this.D != 1;
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        return this.f19131s.getVisibility() == 0 ? this.D == 1 : this.D != 2;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        int i2;
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 19) {
            if (this.A % 90.0f != 0.0f) {
                i2 = 1;
                if (this.f19131s.getLayerType() != 1) {
                    floatingActionButton = this.f19131s;
                }
            } else if (this.f19131s.getLayerType() != 0) {
                floatingActionButton = this.f19131s;
                i2 = 0;
            }
            floatingActionButton.setLayerType(i2, (Paint) null);
        }
        h hVar = this.f19121c;
        if (hVar != null) {
            hVar.F((int) this.A);
        }
    }
}
