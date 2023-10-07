package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.utils.g;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final g<View> f21933a = (Build.VERSION.SDK_INT >= 14 ? new g<View>() {
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            view.setTranslationX(pointF.x);
            view.setTranslationY(pointF.y);
        }
    } : null);

    private static class a extends AnimatorListenerAdapter implements Transition.c {

        /* renamed from: a  reason: collision with root package name */
        private final View f21934a;

        /* renamed from: b  reason: collision with root package name */
        private final View f21935b;

        /* renamed from: c  reason: collision with root package name */
        private final int f21936c;

        /* renamed from: d  reason: collision with root package name */
        private final int f21937d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f21938e;

        /* renamed from: f  reason: collision with root package name */
        private float f21939f;

        /* renamed from: g  reason: collision with root package name */
        private float f21940g;

        /* renamed from: h  reason: collision with root package name */
        private final float f21941h;

        /* renamed from: i  reason: collision with root package name */
        private final float f21942i;

        private a(View view, View view2, int i2, int i3, float f2, float f3) {
            this.f21935b = view;
            this.f21934a = view2;
            this.f21936c = i2 - Math.round(view.getTranslationX());
            this.f21937d = i3 - Math.round(view.getTranslationY());
            this.f21941h = f2;
            this.f21942i = f3;
            int[] iArr = (int[]) view2.getTag(R.id.transitionPosition);
            this.f21938e = iArr;
            if (iArr != null) {
                view2.setTag(R.id.transitionPosition, (Object) null);
            }
        }

        public void a(Transition transition) {
        }

        public void b(Transition transition) {
            this.f21935b.setTranslationX(this.f21941h);
            this.f21935b.setTranslationY(this.f21942i);
        }

        public void c(Transition transition) {
        }

        public void d(Transition transition) {
        }

        public void e(Transition transition) {
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f21938e == null) {
                this.f21938e = new int[2];
            }
            this.f21938e[0] = Math.round(((float) this.f21936c) + this.f21935b.getTranslationX());
            this.f21938e[1] = Math.round(((float) this.f21937d) + this.f21935b.getTranslationY());
            this.f21934a.setTag(R.id.transitionPosition, this.f21938e);
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationPause(Animator animator) {
            this.f21939f = this.f21935b.getTranslationX();
            this.f21940g = this.f21935b.getTranslationY();
            this.f21935b.setTranslationX(this.f21941h);
            this.f21935b.setTranslationY(this.f21942i);
        }

        public void onAnimationResume(Animator animator) {
            this.f21935b.setTranslationX(this.f21939f);
            this.f21935b.setTranslationY(this.f21940g);
        }
    }

    public static Animator a(View view, h hVar, int i2, int i3, float f2, float f3, float f4, float f5, TimeInterpolator timeInterpolator, Transition transition) {
        float f6;
        float f7;
        View view2 = view;
        h hVar2 = hVar;
        g<View> gVar = f21933a;
        if (gVar == null) {
            return null;
        }
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) hVar2.f21926a.getTag(R.id.transitionPosition);
        if (iArr != null) {
            f7 = ((float) (iArr[0] - i2)) + translationX;
            f6 = ((float) (iArr[1] - i3)) + translationY;
        } else {
            f7 = f2;
            f6 = f3;
        }
        int round = i2 + Math.round(f7 - translationX);
        int round2 = i3 + Math.round(f6 - translationY);
        view.setTranslationX(f7);
        view.setTranslationY(f6);
        Animator a2 = com.transitionseverywhere.utils.a.a(view, gVar, f7, f6, f4, f5);
        if (a2 != null) {
            a aVar = new a(view, hVar2.f21926a, round, round2, translationX, translationY);
            transition.a((Transition.c) aVar);
            a2.addListener(aVar);
            com.transitionseverywhere.utils.a.a(a2, aVar);
            a2.setInterpolator(timeInterpolator);
        }
        return a2;
    }
}
