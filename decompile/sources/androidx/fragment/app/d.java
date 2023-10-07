package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.b;
import androidx.fragment.R;
import androidx.fragment.app.t;
import t.x;

class d {

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f3378a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f3379b;

        a(Animator animator) {
            this.f3378a = null;
            this.f3379b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        a(Animation animation) {
            this.f3378a = animation;
            this.f3379b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    static class b extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f3380a;

        /* renamed from: b  reason: collision with root package name */
        private final View f3381b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3382c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3383d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3384e = true;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f3380a = viewGroup;
            this.f3381b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j2, Transformation transformation) {
            this.f3384e = true;
            if (this.f3382c) {
                return !this.f3383d;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f3382c = true;
                x.a(this.f3380a, this);
            }
            return true;
        }

        public boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.f3384e = true;
            if (this.f3382c) {
                return !this.f3383d;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f3382c = true;
                x.a(this.f3380a, this);
            }
            return true;
        }

        public void run() {
            if (this.f3382c || !this.f3384e) {
                this.f3380a.endViewTransition(this.f3381b);
                this.f3383d = true;
                return;
            }
            this.f3384e = false;
            this.f3380a.post(this);
        }
    }

    private static int a(int i2, boolean z2) {
        if (i2 == 4097) {
            return z2 ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
        }
        if (i2 == 4099) {
            return z2 ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z2 ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
    }

    private static int a(Fragment fragment, boolean z2, boolean z3) {
        return z3 ? z2 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z2 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    static a a(Context context, Fragment fragment, boolean z2, boolean z3) {
        int nextTransition = fragment.getNextTransition();
        int a2 = a(fragment, z2, z3);
        boolean z4 = false;
        fragment.setAnimations(0, 0, 0, 0);
        if (!(fragment.mContainer == null || fragment.mContainer.getTag(R.id.visible_removing_fragment_view_tag) == null)) {
            fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, (Object) null);
        }
        if (fragment.mContainer != null && fragment.mContainer.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z2, a2);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z2, a2);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (a2 == 0 && nextTransition != 0) {
            a2 = a(nextTransition, z2);
        }
        if (a2 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(a2));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, a2);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z4 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z4) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, a2);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, a2);
                        if (loadAnimation2 != null) {
                            return new a(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        return null;
    }

    static void a(final Fragment fragment, a aVar, final t.a aVar2) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        final androidx.core.os.b bVar = new androidx.core.os.b();
        bVar.a(new b.a() {
            public void a() {
                if (Fragment.this.getAnimatingAway() != null) {
                    View animatingAway = Fragment.this.getAnimatingAway();
                    Fragment.this.setAnimatingAway((View) null);
                    animatingAway.clearAnimation();
                }
                Fragment.this.setAnimator((Animator) null);
            }
        });
        aVar2.a(fragment, bVar);
        if (aVar.f3378a != null) {
            b bVar2 = new b(aVar.f3378a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            bVar2.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() {
                        public void run() {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway((View) null);
                                aVar2.b(fragment, bVar);
                            }
                        }
                    });
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            fragment.mView.startAnimation(bVar2);
            return;
        }
        Animator animator = aVar.f3379b;
        fragment.setAnimator(aVar.f3379b);
        final Fragment fragment2 = fragment;
        final t.a aVar3 = aVar2;
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                Animator animator2 = fragment2.getAnimator();
                fragment2.setAnimator((Animator) null);
                if (animator2 != null && viewGroup.indexOfChild(view) < 0) {
                    aVar3.b(fragment2, bVar);
                }
            }
        });
        animator.setTarget(fragment.mView);
        animator.start();
    }
}
