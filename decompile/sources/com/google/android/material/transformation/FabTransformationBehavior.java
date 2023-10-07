package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import gl.d;
import gl.e;
import gl.h;
import gl.i;
import gl.j;
import java.util.ArrayList;
import java.util.List;
import t.ac;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f20004a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f20005b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final RectF f20006c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    private final int[] f20007d = new int[2];

    /* renamed from: e  reason: collision with root package name */
    private float f20008e;

    /* renamed from: f  reason: collision with root package name */
    private float f20009f;

    protected static class a {

        /* renamed from: a  reason: collision with root package name */
        public h f20021a;

        /* renamed from: b  reason: collision with root package name */
        public j f20022b;

        protected a() {
        }
    }

    public FabTransformationBehavior() {
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private float a(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f20005b;
        RectF rectF2 = this.f20006c;
        b(view, rectF);
        a(view2, rectF2);
        int i2 = jVar.f28555a & 7;
        if (i2 == 1) {
            f4 = rectF2.centerX();
            f3 = rectF.centerX();
        } else if (i2 == 3) {
            f4 = rectF2.left;
            f3 = rectF.left;
        } else if (i2 != 5) {
            f2 = 0.0f;
            return f2 + jVar.f28556b;
        } else {
            f4 = rectF2.right;
            f3 = rectF.right;
        }
        f2 = f4 - f3;
        return f2 + jVar.f28556b;
    }

    private float a(a aVar, i iVar, float f2, float f3) {
        long a2 = iVar.a();
        long b2 = iVar.b();
        i b3 = aVar.f20021a.b("expansion");
        return gl.a.a(f2, f3, iVar.c().getInterpolation(((float) (((b3.a() + b3.b()) + 17) - a2)) / ((float) b2)));
    }

    private Pair<i, i> a(float f2, float f3, boolean z2, a aVar) {
        String str;
        h hVar;
        i iVar;
        if (f2 == 0.0f || f3 == 0.0f) {
            iVar = aVar.f20021a.b("translationXLinear");
            hVar = aVar.f20021a;
            str = "translationYLinear";
        } else if ((!z2 || f3 >= 0.0f) && (z2 || f3 <= 0.0f)) {
            iVar = aVar.f20021a.b("translationXCurveDownwards");
            hVar = aVar.f20021a;
            str = "translationYCurveDownwards";
        } else {
            iVar = aVar.f20021a.b("translationXCurveUpwards");
            hVar = aVar.f20021a;
            str = "translationYCurveUpwards";
        }
        return new Pair<>(iVar, hVar.b(str));
    }

    private ViewGroup a(View view) {
        View findViewById = view.findViewById(R.id.mtrl_child_content_container);
        return findViewById != null ? b(findViewById) : ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) ? b(((ViewGroup) view).getChildAt(0)) : b(view);
    }

    private void a(View view, long j2, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && j2 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j2);
            list.add(createCircularReveal);
        }
    }

    private void a(View view, long j2, long j3, long j4, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j5 = j2 + j3;
            if (j5 < j4) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                createCircularReveal.setStartDelay(j5);
                createCircularReveal.setDuration(j4 - j5);
                list.add(createCircularReveal);
            }
        }
    }

    private void a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f20007d;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private void a(View view, View view2, boolean z2, a aVar, List<Animator> list) {
        float a2 = a(view, view2, aVar.f20022b);
        float b2 = b(view, view2, aVar.f20022b);
        Pair<i, i> a3 = a(a2, b2, z2, aVar);
        i iVar = (i) a3.first;
        i iVar2 = (i) a3.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z2) {
            a2 = this.f20008e;
        }
        fArr[0] = a2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z2) {
            b2 = this.f20009f;
        }
        fArr2[0] = b2;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        iVar.a((Animator) ofFloat);
        iVar2.a((Animator) ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private void a(View view, View view2, boolean z2, boolean z3, a aVar, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        View view3 = view;
        View view4 = view2;
        a aVar2 = aVar;
        if (view4 instanceof c) {
            final c cVar = (c) view4;
            float c2 = c(view3, view4, aVar2.f20022b);
            float d2 = d(view3, view4, aVar2.f20022b);
            ((FloatingActionButton) view3).a(this.f20004a);
            float width = ((float) this.f20004a.width()) / 2.0f;
            i b2 = aVar2.f20021a.b("expansion");
            if (z2) {
                if (!z3) {
                    cVar.setRevealInfo(new c.d(c2, d2, width));
                }
                if (z3) {
                    width = cVar.getRevealInfo().f18863c;
                }
                animator = com.google.android.material.circularreveal.a.a(cVar, c2, d2, gs.a.a(c2, d2, 0.0f, 0.0f, f2, f3));
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        c.d revealInfo = cVar.getRevealInfo();
                        revealInfo.f18863c = Float.MAX_VALUE;
                        cVar.setRevealInfo(revealInfo);
                    }
                });
                a(view2, b2.a(), (int) c2, (int) d2, width, list);
            } else {
                float f4 = cVar.getRevealInfo().f18863c;
                Animator a2 = com.google.android.material.circularreveal.a.a(cVar, c2, d2, width);
                int i2 = (int) c2;
                int i3 = (int) d2;
                View view5 = view2;
                a(view5, b2.a(), i2, i3, f4, list);
                long a3 = b2.a();
                long b3 = b2.b();
                long a4 = aVar2.f20021a.a();
                a(view5, a3, b3, a4, i2, i3, width, list);
                animator = a2;
            }
            b2.a(animator);
            list.add(animator);
            list2.add(com.google.android.material.circularreveal.a.a(cVar));
        }
    }

    private void a(View view, View view2, boolean z2, boolean z3, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float s2 = ac.s(view2) - ac.s(view);
        if (z2) {
            if (!z3) {
                view2.setTranslationZ(-s2);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-s2});
        }
        aVar.f20021a.b("elevation").a((Animator) objectAnimator);
        list.add(objectAnimator);
    }

    private void a(View view, View view2, boolean z2, boolean z3, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        View view3 = view;
        View view4 = view2;
        boolean z4 = z2;
        a aVar2 = aVar;
        List<Animator> list3 = list;
        float a2 = a(view3, view4, aVar2.f20022b);
        float b2 = b(view3, view4, aVar2.f20022b);
        Pair<i, i> a3 = a(a2, b2, z4, aVar2);
        i iVar = (i) a3.first;
        i iVar2 = (i) a3.second;
        if (z4) {
            if (!z3) {
                view4.setTranslationX(-a2);
                view4.setTranslationY(-b2);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{0.0f});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{0.0f});
            a(view2, aVar, iVar, iVar2, -a2, -b2, 0.0f, 0.0f, rectF);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-a2});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{-b2});
        }
        iVar.a((Animator) objectAnimator2);
        iVar2.a((Animator) objectAnimator);
        list3.add(objectAnimator2);
        list3.add(objectAnimator);
    }

    private void a(View view, a aVar, i iVar, i iVar2, float f2, float f3, float f4, float f5, RectF rectF) {
        float a2 = a(aVar, iVar, f2, f4);
        float a3 = a(aVar, iVar2, f3, f5);
        Rect rect = this.f20004a;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f20005b;
        rectF2.set(rect);
        RectF rectF3 = this.f20006c;
        a(view, rectF3);
        rectF3.offset(a2, a3);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float b(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f20005b;
        RectF rectF2 = this.f20006c;
        b(view, rectF);
        a(view2, rectF2);
        int i2 = jVar.f28555a & 112;
        if (i2 == 16) {
            f4 = rectF2.centerY();
            f3 = rectF.centerY();
        } else if (i2 == 48) {
            f4 = rectF2.top;
            f3 = rectF.top;
        } else if (i2 != 80) {
            f2 = 0.0f;
            return f2 + jVar.f28557c;
        } else {
            f4 = rectF2.bottom;
            f3 = rectF.bottom;
        }
        f2 = f4 - f3;
        return f2 + jVar.f28557c;
    }

    private ViewGroup b(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private void b(View view, RectF rectF) {
        a(view, rectF);
        rectF.offset(this.f20008e, this.f20009f);
    }

    private void b(View view, final View view2, boolean z2, boolean z3, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof c) && (view instanceof ImageView)) {
            final c cVar = (c) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z2) {
                    if (!z3) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, e.f28542a, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, e.f28542a, new int[]{255});
                }
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view2.invalidate();
                    }
                });
                aVar.f20021a.b("iconFade").a((Animator) objectAnimator);
                list.add(objectAnimator);
                list2.add(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        cVar.setCircularRevealOverlayDrawable((Drawable) null);
                    }

                    public void onAnimationStart(Animator animator) {
                        cVar.setCircularRevealOverlayDrawable(drawable);
                    }
                });
            }
        }
    }

    private float c(View view, View view2, j jVar) {
        RectF rectF = this.f20005b;
        RectF rectF2 = this.f20006c;
        b(view, rectF);
        a(view2, rectF2);
        rectF2.offset(-a(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private int c(View view) {
        ColorStateList C = ac.C(view);
        if (C != null) {
            return C.getColorForState(view.getDrawableState(), C.getDefaultColor());
        }
        return 0;
    }

    private void c(View view, View view2, boolean z2, boolean z3, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof c) {
            c cVar = (c) view2;
            int c2 = c(view);
            int i2 = 16777215 & c2;
            if (z2) {
                if (!z3) {
                    cVar.setCircularRevealScrimColor(c2);
                }
                objectAnimator = ObjectAnimator.ofInt(cVar, c.C0128c.f18860a, new int[]{i2});
            } else {
                objectAnimator = ObjectAnimator.ofInt(cVar, c.C0128c.f18860a, new int[]{c2});
            }
            objectAnimator.setEvaluator(gl.c.a());
            aVar.f20021a.b("color").a((Animator) objectAnimator);
            list.add(objectAnimator);
        }
    }

    private float d(View view, View view2, j jVar) {
        RectF rectF = this.f20005b;
        RectF rectF2 = this.f20006c;
        b(view, rectF);
        a(view2, rectF2);
        rectF2.offset(0.0f, -b(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private void d(View view, View view2, boolean z2, boolean z3, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup a2;
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if ((!(view2 instanceof c) || b.f18847a != 0) && (a2 = a(view2)) != null) {
                if (z2) {
                    if (!z3) {
                        d.f28541a.set(a2, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(a2, d.f28541a, new float[]{1.0f});
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(a2, d.f28541a, new float[]{0.0f});
                }
                aVar.f20021a.b("contentFade").a((Animator) objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract a a(Context context, boolean z2);

    public void a(CoordinatorLayout.d dVar) {
        if (dVar.f2760h == 0) {
            dVar.f2760h = 80;
        }
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
        }
    }

    /* access modifiers changed from: protected */
    public AnimatorSet b(View view, View view2, boolean z2, boolean z3) {
        final boolean z4 = z2;
        a a2 = a(view2.getContext(), z4);
        if (z4) {
            this.f20008e = view.getTranslationX();
            this.f20009f = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            a(view, view2, z2, z3, a2, arrayList, arrayList2);
        }
        RectF rectF = this.f20005b;
        View view3 = view;
        View view4 = view2;
        boolean z5 = z2;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        a(view3, view4, z5, z3, a2, (List<Animator>) arrayList3, (List<Animator.AnimatorListener>) arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        a(view3, view4, z5, a2, arrayList);
        boolean z6 = z3;
        a aVar = a2;
        b(view3, view4, z5, z6, aVar, arrayList3, arrayList4);
        a(view3, view4, z5, z6, aVar, width, height, (List<Animator>) arrayList, (List<Animator.AnimatorListener>) arrayList2);
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = arrayList2;
        c(view3, view4, z5, z6, aVar, arrayList5, arrayList6);
        d(view3, view4, z5, z6, aVar, arrayList5, arrayList6);
        AnimatorSet animatorSet = new AnimatorSet();
        gl.b.a(animatorSet, arrayList);
        final View view5 = view;
        final View view6 = view2;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!z4) {
                    view6.setVisibility(4);
                    view5.setAlpha(1.0f);
                    view5.setVisibility(0);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (z4) {
                    view6.setVisibility(0);
                    view5.setAlpha(0.0f);
                    view5.setVisibility(4);
                }
            }
        });
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i2));
        }
        return animatorSet;
    }
}
