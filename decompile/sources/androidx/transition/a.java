package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

class a {

    /* renamed from: androidx.transition.a$a  reason: collision with other inner class name */
    interface C0041a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    static void a(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                Animator.AnimatorListener animatorListener = listeners.get(i2);
                if (animatorListener instanceof C0041a) {
                    ((C0041a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    static void b(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                Animator.AnimatorListener animatorListener = listeners.get(i2);
                if (animatorListener instanceof C0041a) {
                    ((C0041a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
