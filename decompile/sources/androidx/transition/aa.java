package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.transition.Transition;

class aa {

    private static class a extends AnimatorListenerAdapter implements Transition.c {

        /* renamed from: a  reason: collision with root package name */
        private final View f4769a;

        /* renamed from: b  reason: collision with root package name */
        private final View f4770b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4771c;

        /* renamed from: d  reason: collision with root package name */
        private final int f4772d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f4773e;

        /* renamed from: f  reason: collision with root package name */
        private float f4774f;

        /* renamed from: g  reason: collision with root package name */
        private float f4775g;

        /* renamed from: h  reason: collision with root package name */
        private final float f4776h;

        /* renamed from: i  reason: collision with root package name */
        private final float f4777i;

        a(View view, View view2, int i2, int i3, float f2, float f3) {
            this.f4770b = view;
            this.f4769a = view2;
            this.f4771c = i2 - Math.round(view.getTranslationX());
            this.f4772d = i3 - Math.round(view.getTranslationY());
            this.f4776h = f2;
            this.f4777i = f3;
            int[] iArr = (int[]) view2.getTag(R.id.transition_position);
            this.f4773e = iArr;
            if (iArr != null) {
                view2.setTag(R.id.transition_position, (Object) null);
            }
        }

        public void a(Transition transition) {
        }

        public void b(Transition transition) {
            this.f4770b.setTranslationX(this.f4776h);
            this.f4770b.setTranslationY(this.f4777i);
            transition.b((Transition.c) this);
        }

        public void c(Transition transition) {
        }

        public void d(Transition transition) {
        }

        public void e(Transition transition) {
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f4773e == null) {
                this.f4773e = new int[2];
            }
            this.f4773e[0] = Math.round(((float) this.f4771c) + this.f4770b.getTranslationX());
            this.f4773e[1] = Math.round(((float) this.f4772d) + this.f4770b.getTranslationY());
            this.f4769a.setTag(R.id.transition_position, this.f4773e);
        }

        public void onAnimationPause(Animator animator) {
            this.f4774f = this.f4770b.getTranslationX();
            this.f4775g = this.f4770b.getTranslationY();
            this.f4770b.setTranslationX(this.f4776h);
            this.f4770b.setTranslationY(this.f4777i);
        }

        public void onAnimationResume(Animator animator) {
            this.f4770b.setTranslationX(this.f4774f);
            this.f4770b.setTranslationY(this.f4775g);
        }
    }

    static Animator a(View view, y yVar, int i2, int i3, float f2, float f3, float f4, float f5, TimeInterpolator timeInterpolator, Transition transition) {
        float f6;
        float f7;
        View view2 = view;
        y yVar2 = yVar;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) yVar2.f4887b.getTag(R.id.transition_position);
        if (iArr != null) {
            f6 = ((float) (iArr[0] - i2)) + translationX;
            f7 = ((float) (iArr[1] - i3)) + translationY;
        } else {
            f6 = f2;
            f7 = f3;
        }
        int round = i2 + Math.round(f6 - translationX);
        int round2 = i3 + Math.round(f7 - translationY);
        view.setTranslationX(f6);
        view.setTranslationY(f7);
        if (f6 == f4 && f7 == f5) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f6, f4}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f7, f5})});
        a aVar = new a(view, yVar2.f4887b, round, round2, translationX, translationY);
        transition.a((Transition.c) aVar);
        ofPropertyValuesHolder.addListener(aVar);
        a.a(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
