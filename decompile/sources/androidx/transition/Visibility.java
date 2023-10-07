package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.a;
import l.g;
import org.xmlpull.v1.XmlPullParser;

public abstract class Visibility extends Transition {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4751a = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: i  reason: collision with root package name */
    private int f4752i = 3;

    private static class a extends AnimatorListenerAdapter implements Transition.c, a.C0041a {

        /* renamed from: a  reason: collision with root package name */
        boolean f4757a = false;

        /* renamed from: b  reason: collision with root package name */
        private final View f4758b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4759c;

        /* renamed from: d  reason: collision with root package name */
        private final ViewGroup f4760d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f4761e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4762f;

        a(View view, int i2, boolean z2) {
            this.f4758b = view;
            this.f4759c = i2;
            this.f4760d = (ViewGroup) view.getParent();
            this.f4761e = z2;
            a(true);
        }

        private void a() {
            if (!this.f4757a) {
                aj.a(this.f4758b, this.f4759c);
                ViewGroup viewGroup = this.f4760d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z2) {
            ViewGroup viewGroup;
            if (this.f4761e && this.f4762f != z2 && (viewGroup = this.f4760d) != null) {
                this.f4762f = z2;
                ae.a(viewGroup, z2);
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
            this.f4757a = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f4757a) {
                aj.a(this.f4758b, this.f4759c);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f4757a) {
                aj.a(this.f4758b, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f4763a;

        /* renamed from: b  reason: collision with root package name */
        boolean f4764b;

        /* renamed from: c  reason: collision with root package name */
        int f4765c;

        /* renamed from: d  reason: collision with root package name */
        int f4766d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f4767e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f4768f;

        b() {
        }
    }

    public Visibility() {
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f4866e);
        int a2 = g.a(obtainStyledAttributes, (XmlPullParser) (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (a2 != 0) {
            b(a2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007d, code lost:
        if (r0.f4766d == 0) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0087, code lost:
        if (r0.f4767e == null) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0099, code lost:
        if (r0.f4765c == 0) goto L_0x009b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.transition.Visibility.b b(androidx.transition.y r8, androidx.transition.y r9) {
        /*
            r7 = this;
            androidx.transition.Visibility$b r0 = new androidx.transition.Visibility$b
            r0.<init>()
            r1 = 0
            r0.f4763a = r1
            r0.f4764b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f4886a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f4886a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f4765c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f4886a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f4767e = r6
            goto L_0x0037
        L_0x0033:
            r0.f4765c = r4
            r0.f4767e = r3
        L_0x0037:
            if (r9 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.f4886a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f4886a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f4766d = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f4886a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f4768f = r2
            goto L_0x005e
        L_0x005a:
            r0.f4766d = r4
            r0.f4768f = r3
        L_0x005e:
            r2 = 1
            if (r8 == 0) goto L_0x008a
            if (r9 == 0) goto L_0x008a
            int r8 = r0.f4765c
            int r9 = r0.f4766d
            if (r8 != r9) goto L_0x0070
            android.view.ViewGroup r8 = r0.f4767e
            android.view.ViewGroup r9 = r0.f4768f
            if (r8 != r9) goto L_0x0070
            return r0
        L_0x0070:
            int r8 = r0.f4765c
            int r9 = r0.f4766d
            if (r8 == r9) goto L_0x0080
            int r8 = r0.f4765c
            if (r8 != 0) goto L_0x007b
            goto L_0x009b
        L_0x007b:
            int r8 = r0.f4766d
            if (r8 != 0) goto L_0x009e
            goto L_0x0090
        L_0x0080:
            android.view.ViewGroup r8 = r0.f4768f
            if (r8 != 0) goto L_0x0085
            goto L_0x009b
        L_0x0085:
            android.view.ViewGroup r8 = r0.f4767e
            if (r8 != 0) goto L_0x009e
            goto L_0x0090
        L_0x008a:
            if (r8 != 0) goto L_0x0095
            int r8 = r0.f4766d
            if (r8 != 0) goto L_0x0095
        L_0x0090:
            r0.f4764b = r2
        L_0x0092:
            r0.f4763a = r2
            goto L_0x009e
        L_0x0095:
            if (r9 != 0) goto L_0x009e
            int r8 = r0.f4765c
            if (r8 != 0) goto L_0x009e
        L_0x009b:
            r0.f4764b = r1
            goto L_0x0092
        L_0x009e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.b(androidx.transition.y, androidx.transition.y):androidx.transition.Visibility$b");
    }

    private void d(y yVar) {
        yVar.f4886a.put("android:visibility:visibility", Integer.valueOf(yVar.f4887b.getVisibility()));
        yVar.f4886a.put("android:visibility:parent", yVar.f4887b.getParent());
        int[] iArr = new int[2];
        yVar.f4887b.getLocationOnScreen(iArr);
        yVar.f4886a.put("android:visibility:screenLocation", iArr);
    }

    public Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        return null;
    }

    public Animator a(ViewGroup viewGroup, y yVar, int i2, y yVar2, int i3) {
        if ((this.f4752i & 1) != 1 || yVar2 == null) {
            return null;
        }
        if (yVar == null) {
            View view = (View) yVar2.f4887b.getParent();
            if (b(b(view, false), a(view, false)).f4763a) {
                return null;
            }
        }
        return a(viewGroup, yVar2.f4887b, yVar, yVar2);
    }

    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        b b2 = b(yVar, yVar2);
        if (!b2.f4763a) {
            return null;
        }
        if (b2.f4767e == null && b2.f4768f == null) {
            return null;
        }
        if (b2.f4764b) {
            return a(viewGroup, yVar, b2.f4765c, yVar2, b2.f4766d);
        }
        return b(viewGroup, yVar, b2.f4765c, yVar2, b2.f4766d);
    }

    public void a(y yVar) {
        d(yVar);
    }

    public boolean a(y yVar, y yVar2) {
        if (yVar == null && yVar2 == null) {
            return false;
        }
        if (yVar != null && yVar2 != null && yVar2.f4886a.containsKey("android:visibility:visibility") != yVar.f4886a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b2 = b(yVar, yVar2);
        if (b2.f4763a) {
            return b2.f4765c == 0 || b2.f4766d == 0;
        }
        return false;
    }

    public String[] a() {
        return f4751a;
    }

    public Animator b(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007f, code lost:
        if (r10.f4715f != false) goto L_0x0081;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator b(final android.view.ViewGroup r11, androidx.transition.y r12, int r13, androidx.transition.y r14, int r15) {
        /*
            r10 = this;
            int r13 = r10.f4752i
            r0 = 2
            r13 = r13 & r0
            r1 = 0
            if (r13 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r12 != 0) goto L_0x000b
            return r1
        L_0x000b:
            android.view.View r13 = r12.f4887b
            if (r14 == 0) goto L_0x0012
            android.view.View r2 = r14.f4887b
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            int r3 = androidx.transition.R.id.save_overlay_view
            java.lang.Object r3 = r13.getTag(r3)
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0023
            r2 = r1
            r6 = 1
            goto L_0x0089
        L_0x0023:
            if (r2 == 0) goto L_0x0036
            android.view.ViewParent r3 = r2.getParent()
            if (r3 != 0) goto L_0x002c
            goto L_0x0036
        L_0x002c:
            r3 = 4
            if (r15 != r3) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            if (r13 != r2) goto L_0x003b
        L_0x0032:
            r3 = r2
            r6 = 0
            r2 = r1
            goto L_0x003e
        L_0x0036:
            if (r2 == 0) goto L_0x003b
            r3 = r1
            r6 = 0
            goto L_0x003e
        L_0x003b:
            r2 = r1
            r3 = r2
            r6 = 1
        L_0x003e:
            if (r6 == 0) goto L_0x0085
            android.view.ViewParent r6 = r13.getParent()
            if (r6 != 0) goto L_0x0047
            goto L_0x0081
        L_0x0047:
            android.view.ViewParent r6 = r13.getParent()
            boolean r6 = r6 instanceof android.view.View
            if (r6 == 0) goto L_0x0085
            android.view.ViewParent r6 = r13.getParent()
            android.view.View r6 = (android.view.View) r6
            androidx.transition.y r7 = r10.a((android.view.View) r6, (boolean) r5)
            androidx.transition.y r8 = r10.b((android.view.View) r6, (boolean) r5)
            androidx.transition.Visibility$b r7 = r10.b(r7, r8)
            boolean r7 = r7.f4763a
            if (r7 != 0) goto L_0x006a
            android.view.View r2 = androidx.transition.x.a(r11, r13, r6)
            goto L_0x0085
        L_0x006a:
            int r7 = r6.getId()
            android.view.ViewParent r6 = r6.getParent()
            if (r6 != 0) goto L_0x0085
            r6 = -1
            if (r7 == r6) goto L_0x0085
            android.view.View r6 = r11.findViewById(r7)
            if (r6 == 0) goto L_0x0085
            boolean r6 = r10.f4715f
            if (r6 == 0) goto L_0x0085
        L_0x0081:
            r2 = r3
            r6 = 0
            r3 = r13
            goto L_0x0089
        L_0x0085:
            r6 = 0
            r9 = r3
            r3 = r2
            r2 = r9
        L_0x0089:
            if (r3 == 0) goto L_0x00dd
            if (r6 != 0) goto L_0x00bf
            java.util.Map<java.lang.String, java.lang.Object> r15 = r12.f4886a
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r15 = r15.get(r1)
            int[] r15 = (int[]) r15
            int[] r15 = (int[]) r15
            r1 = r15[r4]
            r15 = r15[r5]
            int[] r0 = new int[r0]
            r11.getLocationOnScreen(r0)
            r2 = r0[r4]
            int r1 = r1 - r2
            int r2 = r3.getLeft()
            int r1 = r1 - r2
            r3.offsetLeftAndRight(r1)
            r0 = r0[r5]
            int r15 = r15 - r0
            int r0 = r3.getTop()
            int r15 = r15 - r0
            r3.offsetTopAndBottom(r15)
            androidx.transition.ad r15 = androidx.transition.ae.a(r11)
            r15.a(r3)
        L_0x00bf:
            android.animation.Animator r12 = r10.b(r11, r3, r12, r14)
            if (r6 != 0) goto L_0x00dc
            if (r12 != 0) goto L_0x00cf
            androidx.transition.ad r11 = androidx.transition.ae.a(r11)
            r11.b(r3)
            goto L_0x00dc
        L_0x00cf:
            int r14 = androidx.transition.R.id.save_overlay_view
            r13.setTag(r14, r3)
            androidx.transition.Visibility$1 r14 = new androidx.transition.Visibility$1
            r14.<init>(r11, r3, r13)
            r10.a((androidx.transition.Transition.c) r14)
        L_0x00dc:
            return r12
        L_0x00dd:
            if (r2 == 0) goto L_0x00ff
            int r13 = r2.getVisibility()
            androidx.transition.aj.a((android.view.View) r2, (int) r4)
            android.animation.Animator r11 = r10.b(r11, r2, r12, r14)
            if (r11 == 0) goto L_0x00fb
            androidx.transition.Visibility$a r12 = new androidx.transition.Visibility$a
            r12.<init>(r2, r15, r5)
            r11.addListener(r12)
            androidx.transition.a.a(r11, r12)
            r10.a((androidx.transition.Transition.c) r12)
            goto L_0x00fe
        L_0x00fb:
            androidx.transition.aj.a((android.view.View) r2, (int) r13)
        L_0x00fe:
            return r11
        L_0x00ff:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.b(android.view.ViewGroup, androidx.transition.y, int, androidx.transition.y, int):android.animation.Animator");
    }

    public void b(int i2) {
        if ((i2 & -4) == 0) {
            this.f4752i = i2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public void b(y yVar) {
        d(yVar);
    }

    public int s() {
        return this.f4752i;
    }
}
