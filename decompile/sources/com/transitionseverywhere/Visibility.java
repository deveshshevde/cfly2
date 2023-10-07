package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.utils.k;
import com.transitionseverywhere.utils.m;

public abstract class Visibility extends Transition {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f21881a = {"android:visibility:visibility", "android:visibility:parent"};
    private int F = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f21882b = 3;

    /* renamed from: c  reason: collision with root package name */
    private int f21883c = -1;

    private static class a extends AnimatorListenerAdapter implements Transition.c {

        /* renamed from: a  reason: collision with root package name */
        boolean f21889a = false;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f21890b;

        /* renamed from: c  reason: collision with root package name */
        private final View f21891c;

        /* renamed from: d  reason: collision with root package name */
        private final int f21892d;

        /* renamed from: e  reason: collision with root package name */
        private final ViewGroup f21893e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f21894f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f21895g;

        public a(View view, int i2, boolean z2) {
            this.f21891c = view;
            this.f21890b = z2;
            this.f21892d = i2;
            this.f21893e = (ViewGroup) view.getParent();
            a(true);
        }

        private void a() {
            if (!this.f21889a) {
                if (this.f21890b) {
                    this.f21891c.setTag(R.id.transitionAlpha, Float.valueOf(this.f21891c.getAlpha()));
                    this.f21891c.setAlpha(0.0f);
                } else if (!this.f21895g) {
                    m.a(this.f21891c, this.f21892d);
                    ViewGroup viewGroup = this.f21893e;
                    if (viewGroup != null) {
                        viewGroup.invalidate();
                    }
                    this.f21895g = true;
                }
            }
            a(false);
        }

        private void a(boolean z2) {
            ViewGroup viewGroup;
            if (this.f21894f != z2 && (viewGroup = this.f21893e) != null && !this.f21890b) {
                this.f21894f = z2;
                k.a(viewGroup, z2);
            }
        }

        public void a(Transition transition) {
        }

        public void b(Transition transition) {
            a();
            transition.b((Transition.c) this);
        }

        public void c(Transition transition) {
            a(false);
        }

        public void d(Transition transition) {
            a(true);
        }

        public void e(Transition transition) {
        }

        public void onAnimationCancel(Animator animator) {
            this.f21889a = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f21889a && !this.f21890b) {
                m.a(this.f21891c, this.f21892d);
            }
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f21889a && !this.f21890b) {
                m.a(this.f21891c, 0);
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f21896a;

        /* renamed from: b  reason: collision with root package name */
        boolean f21897b;

        /* renamed from: c  reason: collision with root package name */
        int f21898c;

        /* renamed from: d  reason: collision with root package name */
        int f21899d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f21900e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f21901f;

        private b() {
        }
    }

    public Visibility() {
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VisibilityTransition);
        int i2 = obtainStyledAttributes.getInt(R.styleable.VisibilityTransition_transitionVisibilityMode, 0);
        obtainStyledAttributes.recycle();
        if (i2 != 0) {
            b(i2);
        }
    }

    private void a(h hVar, int i2) {
        if (i2 == -1) {
            i2 = hVar.f21926a.getVisibility();
        }
        hVar.f21927b.put("android:visibility:visibility", Integer.valueOf(i2));
        hVar.f21927b.put("android:visibility:parent", hVar.f21926a.getParent());
        int[] iArr = new int[2];
        hVar.f21926a.getLocationOnScreen(iArr);
        hVar.f21927b.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        if (r0.f21899d == 0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008b, code lost:
        if (r0.f21900e == null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009d, code lost:
        if (r0.f21898c == 0) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.transitionseverywhere.Visibility.b b(com.transitionseverywhere.h r7, com.transitionseverywhere.h r8) {
        /*
            com.transitionseverywhere.Visibility$b r0 = new com.transitionseverywhere.Visibility$b
            r1 = 0
            r0.<init>()
            r2 = 0
            r0.f21896a = r2
            r0.f21897b = r2
            java.lang.String r3 = "android:visibility:parent"
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r7 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r7.f21927b
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r7.f21927b
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f21898c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r7.f21927b
            java.lang.Object r6 = r6.get(r3)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f21900e = r6
            goto L_0x0037
        L_0x0033:
            r0.f21898c = r4
            r0.f21900e = r1
        L_0x0037:
            if (r8 == 0) goto L_0x0058
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f21927b
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x0058
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.f21927b
            java.lang.Object r1 = r1.get(r5)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r0.f21899d = r1
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.f21927b
            java.lang.Object r1 = r1.get(r3)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            goto L_0x005a
        L_0x0058:
            r0.f21899d = r4
        L_0x005a:
            r0.f21901f = r1
            r1 = 1
            if (r7 == 0) goto L_0x008e
            if (r8 == 0) goto L_0x008e
            int r7 = r0.f21898c
            int r8 = r0.f21899d
            if (r7 != r8) goto L_0x006e
            android.view.ViewGroup r7 = r0.f21900e
            android.view.ViewGroup r8 = r0.f21901f
            if (r7 != r8) goto L_0x006e
            return r0
        L_0x006e:
            int r7 = r0.f21898c
            int r8 = r0.f21899d
            if (r7 == r8) goto L_0x007e
            int r7 = r0.f21898c
            if (r7 != 0) goto L_0x0079
            goto L_0x009f
        L_0x0079:
            int r7 = r0.f21899d
            if (r7 != 0) goto L_0x00a2
            goto L_0x0094
        L_0x007e:
            android.view.ViewGroup r7 = r0.f21900e
            android.view.ViewGroup r8 = r0.f21901f
            if (r7 == r8) goto L_0x00a2
            android.view.ViewGroup r7 = r0.f21901f
            if (r7 != 0) goto L_0x0089
            goto L_0x009f
        L_0x0089:
            android.view.ViewGroup r7 = r0.f21900e
            if (r7 != 0) goto L_0x00a2
            goto L_0x0094
        L_0x008e:
            if (r7 != 0) goto L_0x0099
            int r7 = r0.f21899d
            if (r7 != 0) goto L_0x0099
        L_0x0094:
            r0.f21897b = r1
        L_0x0096:
            r0.f21896a = r1
            goto L_0x00a2
        L_0x0099:
            if (r8 != 0) goto L_0x00a2
            int r7 = r0.f21898c
            if (r7 != 0) goto L_0x00a2
        L_0x009f:
            r0.f21897b = r2
            goto L_0x0096
        L_0x00a2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.Visibility.b(com.transitionseverywhere.h, com.transitionseverywhere.h):com.transitionseverywhere.Visibility$b");
    }

    public Animator a(ViewGroup viewGroup, View view, h hVar, h hVar2) {
        return null;
    }

    public Animator a(ViewGroup viewGroup, h hVar, int i2, h hVar2, int i3) {
        boolean z2 = true;
        if ((this.f21882b & 1) != 1 || hVar2 == null) {
            return null;
        }
        if (hVar == null) {
            View view = (View) hVar2.f21926a.getParent();
            if (b(b(view, false), a(view, false)).f21896a) {
                return null;
            }
        }
        if (this.f21883c == -1 && this.F == -1) {
            z2 = false;
        }
        if (z2) {
            Object tag = hVar2.f21926a.getTag(R.id.transitionAlpha);
            if (tag instanceof Float) {
                hVar2.f21926a.setAlpha(((Float) tag).floatValue());
                hVar2.f21926a.setTag(R.id.transitionAlpha, (Object) null);
            }
        }
        return a(viewGroup, hVar2.f21926a, hVar, hVar2);
    }

    public Animator a(ViewGroup viewGroup, h hVar, h hVar2) {
        b b2 = b(hVar, hVar2);
        if (!b2.f21896a) {
            return null;
        }
        if (b2.f21900e == null && b2.f21901f == null) {
            return null;
        }
        if (b2.f21897b) {
            return a(viewGroup, hVar, b2.f21898c, hVar2, b2.f21899d);
        }
        return b(viewGroup, hVar, b2.f21898c, hVar2, b2.f21899d);
    }

    public void a(h hVar) {
        a(hVar, this.f21883c);
    }

    public boolean a(h hVar, h hVar2) {
        if (hVar == null && hVar2 == null) {
            return false;
        }
        if (hVar != null && hVar2 != null && hVar2.f21927b.containsKey("android:visibility:visibility") != hVar.f21927b.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b2 = b(hVar, hVar2);
        if (b2.f21896a) {
            return b2.f21898c == 0 || b2.f21899d == 0;
        }
        return false;
    }

    public String[] a() {
        return f21881a;
    }

    public int b() {
        return this.f21882b;
    }

    public Animator b(ViewGroup viewGroup, View view, h hVar, h hVar2) {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008b, code lost:
        if (r9.f21863w != false) goto L_0x008d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0091 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f7 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator b(android.view.ViewGroup r10, com.transitionseverywhere.h r11, int r12, com.transitionseverywhere.h r13, int r14) {
        /*
            r9 = this;
            int r12 = r9.f21882b
            r0 = 2
            r12 = r12 & r0
            r1 = 0
            if (r12 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r11 == 0) goto L_0x000e
            android.view.View r12 = r11.f21926a
            r7 = r12
            goto L_0x000f
        L_0x000e:
            r7 = r1
        L_0x000f:
            if (r13 == 0) goto L_0x0014
            android.view.View r12 = r13.f21926a
            goto L_0x0015
        L_0x0014:
            r12 = r1
        L_0x0015:
            r0 = 0
            r2 = 1
            if (r12 == 0) goto L_0x002b
            android.view.ViewParent r3 = r12.getParent()
            if (r3 != 0) goto L_0x0020
            goto L_0x002b
        L_0x0020:
            r3 = 4
            if (r14 != r3) goto L_0x0024
            goto L_0x0028
        L_0x0024:
            if (r7 == r12) goto L_0x0028
            if (r7 != 0) goto L_0x0031
        L_0x0028:
            r3 = r12
            r12 = r1
            goto L_0x0037
        L_0x002b:
            if (r12 == 0) goto L_0x002f
            r3 = r1
            goto L_0x0037
        L_0x002f:
            if (r7 == 0) goto L_0x0035
        L_0x0031:
            r12 = r1
            r3 = r12
            r4 = 1
            goto L_0x0038
        L_0x0035:
            r12 = r1
            r3 = r12
        L_0x0037:
            r4 = 0
        L_0x0038:
            r5 = -1
            if (r4 == 0) goto L_0x008e
            int r4 = com.transitionseverywhere.R.id.overlay_view
            java.lang.Object r4 = r7.getTag(r4)
            if (r4 == 0) goto L_0x004d
            int r12 = com.transitionseverywhere.R.id.overlay_view
            java.lang.Object r12 = r7.getTag(r12)
            android.view.View r12 = (android.view.View) r12
            r4 = 1
            goto L_0x008f
        L_0x004d:
            android.view.ViewParent r4 = r7.getParent()
            if (r4 != 0) goto L_0x0054
            goto L_0x008d
        L_0x0054:
            android.view.ViewParent r4 = r7.getParent()
            boolean r4 = r4 instanceof android.view.View
            if (r4 == 0) goto L_0x008e
            android.view.ViewParent r4 = r7.getParent()
            android.view.View r4 = (android.view.View) r4
            com.transitionseverywhere.h r6 = r9.a((android.view.View) r4, (boolean) r2)
            com.transitionseverywhere.h r8 = r9.b((android.view.View) r4, (boolean) r2)
            com.transitionseverywhere.Visibility$b r6 = b(r6, r8)
            boolean r6 = r6.f21896a
            if (r6 != 0) goto L_0x0077
            android.view.View r12 = com.transitionseverywhere.g.a((android.view.ViewGroup) r10, (android.view.View) r7, (android.view.View) r4)
            goto L_0x008e
        L_0x0077:
            android.view.ViewParent r6 = r4.getParent()
            if (r6 != 0) goto L_0x008e
            int r4 = r4.getId()
            if (r4 == r5) goto L_0x008e
            android.view.View r4 = r10.findViewById(r4)
            if (r4 == 0) goto L_0x008e
            boolean r4 = r9.f21863w
            if (r4 == 0) goto L_0x008e
        L_0x008d:
            r12 = r7
        L_0x008e:
            r4 = 0
        L_0x008f:
            if (r12 == 0) goto L_0x00c7
            if (r11 == 0) goto L_0x00c7
            java.util.Map<java.lang.String, java.lang.Object> r14 = r11.f21927b
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r14 = r14.get(r1)
            int[] r14 = (int[]) r14
            r6 = r14
            int[] r6 = (int[]) r6
            if (r4 != 0) goto L_0x00a9
            r14 = r6[r0]
            r0 = r6[r2]
            com.transitionseverywhere.utils.j.a(r10, r12, r14, r0)
        L_0x00a9:
            android.animation.Animator r11 = r9.b(r10, r12, r11, r13)
            if (r11 != 0) goto L_0x00b3
            com.transitionseverywhere.utils.j.a(r10, r12)
            goto L_0x00c6
        L_0x00b3:
            if (r4 != 0) goto L_0x00c6
            int r13 = com.transitionseverywhere.R.id.overlay_view
            r7.setTag(r13, r12)
            com.transitionseverywhere.Visibility$1 r13 = new com.transitionseverywhere.Visibility$1
            r2 = r13
            r3 = r9
            r4 = r10
            r5 = r12
            r2.<init>(r4, r5, r6, r7)
            r9.a((com.transitionseverywhere.Transition.c) r13)
        L_0x00c6:
            return r11
        L_0x00c7:
            if (r3 == 0) goto L_0x00f7
            int r12 = r9.f21883c
            if (r12 != r5) goto L_0x00d3
            int r12 = r9.F
            if (r12 == r5) goto L_0x00d2
            goto L_0x00d3
        L_0x00d2:
            r2 = 0
        L_0x00d3:
            if (r2 != 0) goto L_0x00dc
            int r5 = r3.getVisibility()
            com.transitionseverywhere.utils.m.a((android.view.View) r3, (int) r0)
        L_0x00dc:
            android.animation.Animator r10 = r9.b(r10, r3, r11, r13)
            if (r10 == 0) goto L_0x00f1
            com.transitionseverywhere.Visibility$a r11 = new com.transitionseverywhere.Visibility$a
            r11.<init>(r3, r14, r2)
            r10.addListener(r11)
            com.transitionseverywhere.utils.a.a(r10, r11)
            r9.a((com.transitionseverywhere.Transition.c) r11)
            goto L_0x00f6
        L_0x00f1:
            if (r2 != 0) goto L_0x00f6
            com.transitionseverywhere.utils.m.a((android.view.View) r3, (int) r5)
        L_0x00f6:
            return r10
        L_0x00f7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.Visibility.b(android.view.ViewGroup, com.transitionseverywhere.h, int, com.transitionseverywhere.h, int):android.animation.Animator");
    }

    public Visibility b(int i2) {
        if ((i2 & -4) == 0) {
            this.f21882b = i2;
            return this;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public void b(h hVar) {
        a(hVar, this.F);
    }
}
