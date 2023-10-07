package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.utils.d;
import com.transitionseverywhere.utils.m;

public class ChangeTransform extends Transition {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f21802a = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Property<View, Matrix> f21803b = (Build.VERSION.SDK_INT >= 14 ? new Property<View, Matrix>(Matrix.class, "animationMatrix") {
        /* renamed from: a */
        public Matrix get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, Matrix matrix) {
            m.c(view, matrix);
        }
    } : null);
    private boolean F = true;
    private Matrix G = new Matrix();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f21804c = true;

    private static class a extends Transition.d {

        /* renamed from: a  reason: collision with root package name */
        private View f21812a;

        /* renamed from: b  reason: collision with root package name */
        private View f21813b;

        /* renamed from: c  reason: collision with root package name */
        private Matrix f21814c;

        public a(View view, View view2, Matrix matrix) {
            this.f21812a = view;
            this.f21813b = view2;
            this.f21814c = matrix;
        }

        public void b(Transition transition) {
            transition.b((Transition.c) this);
            m.d(this.f21812a);
            this.f21812a.setTag(R.id.transitionTransform, (Object) null);
            this.f21812a.setTag(R.id.parentMatrix, (Object) null);
        }

        public void c(Transition transition) {
            this.f21813b.setVisibility(4);
        }

        public void d(Transition transition) {
            this.f21813b.setVisibility(0);
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public final float f21815a;

        /* renamed from: b  reason: collision with root package name */
        public final float f21816b;

        /* renamed from: c  reason: collision with root package name */
        public final float f21817c;

        /* renamed from: d  reason: collision with root package name */
        public final float f21818d;

        /* renamed from: e  reason: collision with root package name */
        public final float f21819e;

        /* renamed from: f  reason: collision with root package name */
        public final float f21820f;

        /* renamed from: g  reason: collision with root package name */
        public final float f21821g;

        /* renamed from: h  reason: collision with root package name */
        public final float f21822h;

        public b(View view) {
            this.f21815a = view.getTranslationX();
            this.f21816b = view.getTranslationY();
            this.f21817c = m.c(view);
            this.f21818d = view.getScaleX();
            this.f21819e = view.getScaleY();
            this.f21820f = view.getRotationX();
            this.f21821g = view.getRotationY();
            this.f21822h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.b(view, this.f21815a, this.f21816b, this.f21817c, this.f21818d, this.f21819e, this.f21820f, this.f21821g, this.f21822h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f21815a == this.f21815a && bVar.f21816b == this.f21816b && bVar.f21817c == this.f21817c && bVar.f21818d == this.f21818d && bVar.f21819e == this.f21819e && bVar.f21820f == this.f21820f && bVar.f21821g == this.f21821g && bVar.f21822h == this.f21822h;
        }
    }

    public ChangeTransform() {
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ChangeTransform);
        this.f21804c = obtainStyledAttributes.getBoolean(R.styleable.ChangeTransform_reparentWithOverlay, true);
        this.F = obtainStyledAttributes.getBoolean(R.styleable.ChangeTransform_reparent, true);
        obtainStyledAttributes.recycle();
    }

    private ObjectAnimator a(h hVar, h hVar2, boolean z2) {
        Matrix matrix = (Matrix) hVar.f21927b.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) hVar2.f21927b.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = d.f21951a;
        }
        if (matrix2 == null) {
            matrix2 = d.f21951a;
        }
        final Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        final b bVar = (b) hVar2.f21927b.get("android:changeTransform:transforms");
        final View view = hVar2.f21926a;
        e(view);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, f21803b, new d.a(), new Matrix[]{matrix, matrix3});
        final boolean z3 = z2;
        AnonymousClass2 r1 = new AnimatorListenerAdapter() {

            /* renamed from: f  reason: collision with root package name */
            private boolean f21810f;

            /* renamed from: g  reason: collision with root package name */
            private Matrix f21811g = new Matrix();

            private void a(Matrix matrix) {
                this.f21811g.set(matrix);
                view.setTag(R.id.transitionTransform, this.f21811g);
                bVar.a(view);
            }

            public void onAnimationCancel(Animator animator) {
                this.f21810f = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.f21810f) {
                    if (!z3 || !ChangeTransform.this.f21804c) {
                        view.setTag(R.id.transitionTransform, (Object) null);
                        view.setTag(R.id.parentMatrix, (Object) null);
                    } else {
                        a(matrix3);
                    }
                }
                ChangeTransform.f21803b.set(view, (Object) null);
                bVar.a(view);
            }

            public void onAnimationPause(Animator animator) {
                a((Matrix) ((ValueAnimator) animator).getAnimatedValue());
            }

            public void onAnimationResume(Animator animator) {
                ChangeTransform.e(view);
            }
        };
        ofObject.addListener(r1);
        ofObject.addPauseListener(r1);
        return ofObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r5 == r4.f21926a) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if (r4 == r5) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.b((android.view.View) r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001a
            boolean r0 = r3.b((android.view.View) r5)
            if (r0 != 0) goto L_0x000f
            goto L_0x001a
        L_0x000f:
            com.transitionseverywhere.h r4 = r3.b((android.view.View) r4, (boolean) r1)
            if (r4 == 0) goto L_0x001f
            android.view.View r4 = r4.f21926a
            if (r5 != r4) goto L_0x001d
            goto L_0x001e
        L_0x001a:
            if (r4 != r5) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r1 = 0
        L_0x001e:
            r2 = r1
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.ChangeTransform.a(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    /* access modifiers changed from: private */
    public static void b(View view, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        m.a(view, f4);
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setRotationX(f7);
        view.setRotationY(f8);
        view.setRotation(f9);
    }

    private void b(ViewGroup viewGroup, h hVar, h hVar2) {
        View view = hVar2.f21926a;
        Matrix matrix = (Matrix) hVar2.f21927b.get("android:changeTransform:parentMatrix");
        Matrix matrix2 = new Matrix(matrix);
        m.b((View) viewGroup, matrix2);
        Transition transition = this;
        while (transition.f21858r != null) {
            transition = transition.f21858r;
        }
        View a2 = m.a(view, viewGroup, matrix2);
        if (a2 != null) {
            transition.a((Transition.c) new a(view, a2, matrix));
        }
        if (hVar.f21926a != hVar2.f21926a) {
            view.setAlpha(0.0f);
        }
        view.setAlpha(1.0f);
    }

    private void b(h hVar, h hVar2) {
        Matrix matrix = (Matrix) hVar2.f21927b.get("android:changeTransform:parentMatrix");
        hVar2.f21926a.setTag(R.id.parentMatrix, matrix);
        Matrix matrix2 = this.G;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) hVar.f21927b.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            hVar.f21927b.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) hVar.f21927b.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    private void d(h hVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            View view = hVar.f21926a;
            if (view.getVisibility() != 8) {
                hVar.f21927b.put("android:changeTransform:parent", view.getParent());
                hVar.f21927b.put("android:changeTransform:transforms", new b(view));
                Matrix matrix = view.getMatrix();
                hVar.f21927b.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
                if (this.F) {
                    Matrix matrix2 = new Matrix();
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    m.a((View) viewGroup, matrix2);
                    matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                    hVar.f21927b.put("android:changeTransform:parentMatrix", matrix2);
                    hVar.f21927b.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transitionTransform));
                    hVar.f21927b.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parentMatrix));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void e(View view) {
        b(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    public Animator a(ViewGroup viewGroup, h hVar, h hVar2) {
        if (hVar == null || hVar2 == null || Build.VERSION.SDK_INT < 21 || !hVar.f21927b.containsKey("android:changeTransform:parent") || !hVar2.f21927b.containsKey("android:changeTransform:parent")) {
            return null;
        }
        boolean z2 = this.F && !a((ViewGroup) hVar.f21927b.get("android:changeTransform:parent"), (ViewGroup) hVar2.f21927b.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) hVar.f21927b.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            hVar.f21927b.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) hVar.f21927b.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            hVar.f21927b.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z2) {
            b(hVar, hVar2);
        }
        ObjectAnimator a2 = a(hVar, hVar2, z2);
        if (z2 && a2 != null && this.f21804c) {
            b(viewGroup, hVar, hVar2);
        }
        return a2;
    }

    public void a(h hVar) {
        d(hVar);
    }

    public String[] a() {
        return f21802a;
    }

    public void b(h hVar) {
        d(hVar);
    }
}
