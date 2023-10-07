package t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ag {

    /* renamed from: a  reason: collision with root package name */
    Runnable f34431a = null;

    /* renamed from: b  reason: collision with root package name */
    Runnable f34432b = null;

    /* renamed from: c  reason: collision with root package name */
    int f34433c = -1;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<View> f34434d;

    static class a implements ah {

        /* renamed from: a  reason: collision with root package name */
        ag f34441a;

        /* renamed from: b  reason: collision with root package name */
        boolean f34442b;

        a(ag agVar) {
            this.f34441a = agVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: t.ah} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f34442b = r0
                t.ag r0 = r3.f34441a
                int r0 = r0.f34433c
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000f:
                t.ag r0 = r3.f34441a
                java.lang.Runnable r0 = r0.f34431a
                if (r0 == 0) goto L_0x0020
                t.ag r0 = r3.f34441a
                java.lang.Runnable r0 = r0.f34431a
                t.ag r2 = r3.f34441a
                r2.f34431a = r1
                r0.run()
            L_0x0020:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof t.ah
                if (r2 == 0) goto L_0x002d
                r1 = r0
                t.ah r1 = (t.ah) r1
            L_0x002d:
                if (r1 == 0) goto L_0x0032
                r1.a(r4)
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t.ag.a.a(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: t.ah} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(android.view.View r4) {
            /*
                r3 = this;
                t.ag r0 = r3.f34441a
                int r0 = r0.f34433c
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x0013
                t.ag r0 = r3.f34441a
                int r0 = r0.f34433c
                r4.setLayerType(r0, r2)
                t.ag r0 = r3.f34441a
                r0.f34433c = r1
            L_0x0013:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 >= r1) goto L_0x001d
                boolean r0 = r3.f34442b
                if (r0 != 0) goto L_0x0043
            L_0x001d:
                t.ag r0 = r3.f34441a
                java.lang.Runnable r0 = r0.f34432b
                if (r0 == 0) goto L_0x002e
                t.ag r0 = r3.f34441a
                java.lang.Runnable r0 = r0.f34432b
                t.ag r1 = r3.f34441a
                r1.f34432b = r2
                r0.run()
            L_0x002e:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof t.ah
                if (r1 == 0) goto L_0x003b
                r2 = r0
                t.ah r2 = (t.ah) r2
            L_0x003b:
                if (r2 == 0) goto L_0x0040
                r2.b(r4)
            L_0x0040:
                r4 = 1
                r3.f34442b = r4
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t.ag.a.b(android.view.View):void");
        }

        public void c(View view) {
            Object tag = view.getTag(2113929216);
            ah ahVar = tag instanceof ah ? (ah) tag : null;
            if (ahVar != null) {
                ahVar.c(view);
            }
        }
    }

    ag(View view) {
        this.f34434d = new WeakReference<>(view);
    }

    private void a(final View view, final ah ahVar) {
        if (ahVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    ahVar.c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    ahVar.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    ahVar.a(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public long a() {
        View view = (View) this.f34434d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public ag a(float f2) {
        View view = (View) this.f34434d.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public ag a(long j2) {
        View view = (View) this.f34434d.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public ag a(Interpolator interpolator) {
        View view = (View) this.f34434d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public ag a(ah ahVar) {
        View view = (View) this.f34434d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, ahVar);
                ahVar = new a(this);
            }
            a(view, ahVar);
        }
        return this;
    }

    public ag a(final aj ajVar) {
        final View view = (View) this.f34434d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            AnonymousClass2 r1 = null;
            if (ajVar != null) {
                r1 = new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ajVar.a(view);
                    }
                };
            }
            view.animate().setUpdateListener(r1);
        }
        return this;
    }

    public ag b(float f2) {
        View view = (View) this.f34434d.get();
        if (view != null) {
            view.animate().translationX(f2);
        }
        return this;
    }

    public ag b(long j2) {
        View view = (View) this.f34434d.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    public void b() {
        View view = (View) this.f34434d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public ag c(float f2) {
        View view = (View) this.f34434d.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public void c() {
        View view = (View) this.f34434d.get();
        if (view != null) {
            view.animate().start();
        }
    }
}
