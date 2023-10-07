package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.blankj.utilcode.constant.MemoryConstants;
import t.ac;
import u.c;
import u.f;
import x.c;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    c f18530a;

    /* renamed from: b  reason: collision with root package name */
    a f18531b;

    /* renamed from: c  reason: collision with root package name */
    int f18532c = 2;

    /* renamed from: d  reason: collision with root package name */
    float f18533d = 0.5f;

    /* renamed from: e  reason: collision with root package name */
    float f18534e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    float f18535f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18536g;

    /* renamed from: h  reason: collision with root package name */
    private float f18537h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private boolean f18538i;

    /* renamed from: j  reason: collision with root package name */
    private final c.a f18539j = new c.a() {

        /* renamed from: b  reason: collision with root package name */
        private int f18541b;

        /* renamed from: c  reason: collision with root package name */
        private int f18542c = -1;

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0029 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003c A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a(android.view.View r6, float r7) {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                r2 = 1
                int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r3 == 0) goto L_0x003e
                int r6 = t.ac.i(r6)
                if (r6 != r2) goto L_0x000f
                r6 = 1
                goto L_0x0010
            L_0x000f:
                r6 = 0
            L_0x0010:
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r3 = r3.f18532c
                r4 = 2
                if (r3 != r4) goto L_0x0018
                return r2
            L_0x0018:
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r3 = r3.f18532c
                if (r3 != 0) goto L_0x002b
                if (r6 == 0) goto L_0x0025
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 >= 0) goto L_0x002a
                goto L_0x0029
            L_0x0025:
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 <= 0) goto L_0x002a
            L_0x0029:
                r1 = 1
            L_0x002a:
                return r1
            L_0x002b:
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r3 = r3.f18532c
                if (r3 != r2) goto L_0x003d
                if (r6 == 0) goto L_0x0038
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 <= 0) goto L_0x003d
                goto L_0x003c
            L_0x0038:
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 >= 0) goto L_0x003d
            L_0x003c:
                r1 = 1
            L_0x003d:
                return r1
            L_0x003e:
                int r7 = r6.getLeft()
                int r0 = r5.f18541b
                int r7 = r7 - r0
                int r6 = r6.getWidth()
                float r6 = (float) r6
                com.google.android.material.behavior.SwipeDismissBehavior r0 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r0 = r0.f18533d
                float r6 = r6 * r0
                int r6 = java.lang.Math.round(r6)
                int r7 = java.lang.Math.abs(r7)
                if (r7 < r6) goto L_0x005b
                r1 = 1
            L_0x005b:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.a(android.view.View, float):boolean");
        }

        public int a(View view) {
            return view.getWidth();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
            if (r5 != false) goto L_0x001c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
            if (r5 != false) goto L_0x0012;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            r5 = r2.f18541b;
            r3 = r3.getWidth() + r5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(android.view.View r3, int r4, int r5) {
            /*
                r2 = this;
                int r5 = t.ac.i(r3)
                r0 = 1
                if (r5 != r0) goto L_0x0009
                r5 = 1
                goto L_0x000a
            L_0x0009:
                r5 = 0
            L_0x000a:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.f18532c
                if (r1 != 0) goto L_0x0024
                if (r5 == 0) goto L_0x001c
            L_0x0012:
                int r5 = r2.f18541b
                int r3 = r3.getWidth()
                int r5 = r5 - r3
                int r3 = r2.f18541b
                goto L_0x003b
            L_0x001c:
                int r5 = r2.f18541b
                int r3 = r3.getWidth()
                int r3 = r3 + r5
                goto L_0x003b
            L_0x0024:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.f18532c
                if (r1 != r0) goto L_0x002d
                if (r5 == 0) goto L_0x0012
                goto L_0x001c
            L_0x002d:
                int r5 = r2.f18541b
                int r0 = r3.getWidth()
                int r5 = r5 - r0
                int r0 = r2.f18541b
                int r3 = r3.getWidth()
                int r3 = r3 + r0
            L_0x003b:
                int r3 = com.google.android.material.behavior.SwipeDismissBehavior.a((int) r5, (int) r4, (int) r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.a(android.view.View, int, int):int");
        }

        public void a(int i2) {
            if (SwipeDismissBehavior.this.f18531b != null) {
                SwipeDismissBehavior.this.f18531b.a(i2);
            }
        }

        public void a(View view, float f2, float f3) {
            boolean z2;
            int i2;
            this.f18542c = -1;
            int width = view.getWidth();
            if (a(view, f2)) {
                int left = view.getLeft();
                int i3 = this.f18541b;
                i2 = left < i3 ? i3 - width : i3 + width;
                z2 = true;
            } else {
                i2 = this.f18541b;
                z2 = false;
            }
            if (SwipeDismissBehavior.this.f18530a.a(i2, view.getTop())) {
                ac.a(view, (Runnable) new b(view, z2));
            } else if (z2 && SwipeDismissBehavior.this.f18531b != null) {
                SwipeDismissBehavior.this.f18531b.a(view);
            }
        }

        public void a(View view, int i2) {
            this.f18542c = i2;
            this.f18541b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            float width = ((float) this.f18541b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f18534e);
            float width2 = ((float) this.f18541b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f18535f);
            float f2 = (float) i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f2), 1.0f));
            }
        }

        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        public boolean b(View view, int i2) {
            int i3 = this.f18542c;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.a(view);
        }
    };

    public interface a {
        void a(int i2);

        void a(View view);
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final View f18545b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f18546c;

        b(View view, boolean z2) {
            this.f18545b = view;
            this.f18546c = z2;
        }

        public void run() {
            if (SwipeDismissBehavior.this.f18530a != null && SwipeDismissBehavior.this.f18530a.a(true)) {
                ac.a(this.f18545b, (Runnable) this);
            } else if (this.f18546c && SwipeDismissBehavior.this.f18531b != null) {
                SwipeDismissBehavior.this.f18531b.a(this.f18545b);
            }
        }
    }

    static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int a(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }

    private void a(ViewGroup viewGroup) {
        if (this.f18530a == null) {
            this.f18530a = this.f18538i ? c.a(viewGroup, this.f18537h, this.f18539j) : c.a(viewGroup, this.f18539j);
        }
    }

    static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    private void b(View view) {
        ac.c(view, (int) MemoryConstants.MB);
        if (a(view)) {
            ac.a(view, c.a.f34551u, (CharSequence) null, new f() {
                public boolean a(View view, f.a aVar) {
                    boolean z2 = false;
                    if (!SwipeDismissBehavior.this.a(view)) {
                        return false;
                    }
                    boolean z3 = ac.i(view) == 1;
                    if ((SwipeDismissBehavior.this.f18532c == 0 && z3) || (SwipeDismissBehavior.this.f18532c == 1 && !z3)) {
                        z2 = true;
                    }
                    int width = view.getWidth();
                    if (z2) {
                        width = -width;
                    }
                    ac.f(view, width);
                    view.setAlpha(0.0f);
                    if (SwipeDismissBehavior.this.f18531b != null) {
                        SwipeDismissBehavior.this.f18531b.a(view);
                    }
                    return true;
                }
            });
        }
    }

    public void a(float f2) {
        this.f18534e = a(0.0f, f2, 1.0f);
    }

    public void a(int i2) {
        this.f18532c = i2;
    }

    public void a(a aVar) {
        this.f18531b = aVar;
    }

    public boolean a(View view) {
        return true;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        boolean a2 = super.a(coordinatorLayout, v2, i2);
        if (ac.f(v2) == 0) {
            ac.b((View) v2, 1);
            b((View) v2);
        }
        return a2;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        boolean z2 = this.f18536g;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z2 = coordinatorLayout.a((View) v2, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f18536g = z2;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f18536g = false;
        }
        if (!z2) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.f18530a.a(motionEvent);
    }

    public void b(float f2) {
        this.f18535f = a(0.0f, f2, 1.0f);
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        x.c cVar = this.f18530a;
        if (cVar == null) {
            return false;
        }
        cVar.b(motionEvent);
        return true;
    }
}
