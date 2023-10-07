package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import l.g;
import org.xmlpull.v1.XmlPullParser;
import t.ac;

public class ChangeTransform extends Transition {

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f4658i = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    /* renamed from: j  reason: collision with root package name */
    private static final Property<b, float[]> f4659j = new Property<b, float[]>(float[].class, "nonTranslations") {
        /* renamed from: a */
        public void set(b bVar, float[] fArr) {
            bVar.a(fArr);
        }

        /* renamed from: a */
        public float[] get(b bVar) {
            return null;
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private static final Property<b, PointF> f4660k = new Property<b, PointF>(PointF.class, "translations") {
        /* renamed from: a */
        public PointF get(b bVar) {
            return null;
        }

        /* renamed from: a */
        public void set(b bVar, PointF pointF) {
            bVar.a(pointF);
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private static final boolean f4661l = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: a  reason: collision with root package name */
    boolean f4662a = true;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4663m = true;

    /* renamed from: n  reason: collision with root package name */
    private Matrix f4664n = new Matrix();

    private static class a extends u {

        /* renamed from: a  reason: collision with root package name */
        private View f4673a;

        /* renamed from: b  reason: collision with root package name */
        private f f4674b;

        a(View view, f fVar) {
            this.f4673a = view;
            this.f4674b = fVar;
        }

        public void b(Transition transition) {
            transition.b((Transition.c) this);
            j.a(this.f4673a);
            this.f4673a.setTag(R.id.transition_transform, (Object) null);
            this.f4673a.setTag(R.id.parent_matrix, (Object) null);
        }

        public void c(Transition transition) {
            this.f4674b.setVisibility(4);
        }

        public void d(Transition transition) {
            this.f4674b.setVisibility(0);
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Matrix f4675a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final View f4676b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f4677c;

        /* renamed from: d  reason: collision with root package name */
        private float f4678d;

        /* renamed from: e  reason: collision with root package name */
        private float f4679e;

        b(View view, float[] fArr) {
            this.f4676b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f4677c = fArr2;
            this.f4678d = fArr2[2];
            this.f4679e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.f4677c;
            fArr[2] = this.f4678d;
            fArr[5] = this.f4679e;
            this.f4675a.setValues(fArr);
            aj.c(this.f4676b, this.f4675a);
        }

        /* access modifiers changed from: package-private */
        public Matrix a() {
            return this.f4675a;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f4678d = pointF.x;
            this.f4679e = pointF.y;
            b();
        }

        /* access modifiers changed from: package-private */
        public void a(float[] fArr) {
            System.arraycopy(fArr, 0, this.f4677c, 0, fArr.length);
            b();
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final float f4680a;

        /* renamed from: b  reason: collision with root package name */
        final float f4681b;

        /* renamed from: c  reason: collision with root package name */
        final float f4682c;

        /* renamed from: d  reason: collision with root package name */
        final float f4683d;

        /* renamed from: e  reason: collision with root package name */
        final float f4684e;

        /* renamed from: f  reason: collision with root package name */
        final float f4685f;

        /* renamed from: g  reason: collision with root package name */
        final float f4686g;

        /* renamed from: h  reason: collision with root package name */
        final float f4687h;

        c(View view) {
            this.f4680a = view.getTranslationX();
            this.f4681b = view.getTranslationY();
            this.f4682c = ac.t(view);
            this.f4683d = view.getScaleX();
            this.f4684e = view.getScaleY();
            this.f4685f = view.getRotationX();
            this.f4686g = view.getRotationY();
            this.f4687h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.a(view, this.f4680a, this.f4681b, this.f4682c, this.f4683d, this.f4684e, this.f4685f, this.f4686g, this.f4687h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f4680a == this.f4680a && cVar.f4681b == this.f4681b && cVar.f4682c == this.f4682c && cVar.f4683d == this.f4683d && cVar.f4684e == this.f4684e && cVar.f4685f == this.f4685f && cVar.f4686g == this.f4686g && cVar.f4687h == this.f4687h;
        }

        public int hashCode() {
            float f2 = this.f4680a;
            int i2 = 0;
            int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.f4681b;
            int floatToIntBits2 = (floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f4682c;
            int floatToIntBits3 = (floatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f4683d;
            int floatToIntBits4 = (floatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f4684e;
            int floatToIntBits5 = (floatToIntBits4 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f4685f;
            int floatToIntBits6 = (floatToIntBits5 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.f4686g;
            int floatToIntBits7 = (floatToIntBits6 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.f4687h;
            if (f9 != 0.0f) {
                i2 = Float.floatToIntBits(f9);
            }
            return floatToIntBits7 + i2;
        }
    }

    public ChangeTransform() {
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f4868g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f4662a = g.a(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.f4663m = g.a(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    private ObjectAnimator a(y yVar, y yVar2, boolean z2) {
        Matrix matrix = (Matrix) yVar.f4886a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) yVar2.f4886a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = l.f4850a;
        }
        if (matrix2 == null) {
            matrix2 = l.f4850a;
        }
        final Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        final c cVar = (c) yVar2.f4886a.get("android:changeTransform:transforms");
        final View view = yVar2.f4887b;
        a(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        final b bVar = new b(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bVar, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(f4659j, new d(new float[9]), new float[][]{fArr, fArr2}), o.a(f4660k, m().a(fArr[2], fArr[5], fArr2[2], fArr2[5]))});
        final boolean z3 = z2;
        AnonymousClass3 r1 = new AnimatorListenerAdapter() {

            /* renamed from: g  reason: collision with root package name */
            private boolean f4671g;

            /* renamed from: h  reason: collision with root package name */
            private Matrix f4672h = new Matrix();

            private void a(Matrix matrix) {
                this.f4672h.set(matrix);
                view.setTag(R.id.transition_transform, this.f4672h);
                cVar.a(view);
            }

            public void onAnimationCancel(Animator animator) {
                this.f4671g = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.f4671g) {
                    if (!z3 || !ChangeTransform.this.f4662a) {
                        view.setTag(R.id.transition_transform, (Object) null);
                        view.setTag(R.id.parent_matrix, (Object) null);
                    } else {
                        a(matrix3);
                    }
                }
                aj.c(view, (Matrix) null);
                cVar.a(view);
            }

            public void onAnimationPause(Animator animator) {
                a(bVar.a());
            }

            public void onAnimationResume(Animator animator) {
                ChangeTransform.a(view);
            }
        };
        ofPropertyValuesHolder.addListener(r1);
        a.a(ofPropertyValuesHolder, r1);
        return ofPropertyValuesHolder;
    }

    static void a(View view) {
        a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    static void a(View view, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        ac.e(view, f4);
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setRotationX(f7);
        view.setRotationY(f8);
        view.setRotation(f9);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r5 == r4.f4887b) goto L_0x001e;
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
            androidx.transition.y r4 = r3.b((android.view.View) r4, (boolean) r1)
            if (r4 == 0) goto L_0x001f
            android.view.View r4 = r4.f4887b
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.a(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    private void b(ViewGroup viewGroup, y yVar, y yVar2) {
        View view = yVar2.f4887b;
        Matrix matrix = new Matrix((Matrix) yVar2.f4886a.get("android:changeTransform:parentMatrix"));
        aj.b(viewGroup, matrix);
        f a2 = j.a(view, viewGroup, matrix);
        if (a2 != null) {
            a2.a((ViewGroup) yVar.f4886a.get("android:changeTransform:parent"), yVar.f4887b);
            Transition transition = this;
            while (transition.f4714e != null) {
                transition = transition.f4714e;
            }
            transition.a((Transition.c) new a(view, a2));
            if (f4661l) {
                if (yVar.f4887b != yVar2.f4887b) {
                    aj.a(yVar.f4887b, 0.0f);
                }
                aj.a(view, 1.0f);
            }
        }
    }

    private void b(y yVar, y yVar2) {
        Matrix matrix = (Matrix) yVar2.f4886a.get("android:changeTransform:parentMatrix");
        yVar2.f4887b.setTag(R.id.parent_matrix, matrix);
        Matrix matrix2 = this.f4664n;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) yVar.f4886a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            yVar.f4886a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) yVar.f4886a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    private void d(y yVar) {
        View view = yVar.f4887b;
        if (view.getVisibility() != 8) {
            yVar.f4886a.put("android:changeTransform:parent", view.getParent());
            yVar.f4886a.put("android:changeTransform:transforms", new c(view));
            Matrix matrix = view.getMatrix();
            yVar.f4886a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
            if (this.f4663m) {
                Matrix matrix2 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                aj.a((View) viewGroup, matrix2);
                matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                yVar.f4886a.put("android:changeTransform:parentMatrix", matrix2);
                yVar.f4886a.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
                yVar.f4886a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
            }
        }
    }

    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        if (yVar == null || yVar2 == null || !yVar.f4886a.containsKey("android:changeTransform:parent") || !yVar2.f4886a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) yVar.f4886a.get("android:changeTransform:parent");
        boolean z2 = this.f4663m && !a(viewGroup2, (ViewGroup) yVar2.f4886a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) yVar.f4886a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            yVar.f4886a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) yVar.f4886a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            yVar.f4886a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z2) {
            b(yVar, yVar2);
        }
        ObjectAnimator a2 = a(yVar, yVar2, z2);
        if (z2 && a2 != null && this.f4662a) {
            b(viewGroup, yVar, yVar2);
        } else if (!f4661l) {
            viewGroup2.endViewTransition(yVar.f4887b);
        }
        return a2;
    }

    public void a(y yVar) {
        d(yVar);
        if (!f4661l) {
            ((ViewGroup) yVar.f4887b.getParent()).startViewTransition(yVar.f4887b);
        }
    }

    public String[] a() {
        return f4658i;
    }

    public void b(y yVar) {
        d(yVar);
    }
}
