package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.transitionseverywhere.utils.m;
import j.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public abstract class Transition implements Cloneable {
    private static final ThreadLocal<j.a<Animator, a>> G = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f21841a = {2, 1, 3, 4};
    ArrayList<Animator> A = new ArrayList<>();
    f B;
    b C;
    j.a<String, String> D;
    PathMotion E = PathMotion.f21832a;
    private i F = new i();
    /* access modifiers changed from: private */
    public ArrayList<Animator> H = new ArrayList<>();
    private boolean I = false;

    /* renamed from: b  reason: collision with root package name */
    private String f21842b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    private i f21843c = new i();

    /* renamed from: d  reason: collision with root package name */
    long f21844d = -1;

    /* renamed from: e  reason: collision with root package name */
    long f21845e = -1;

    /* renamed from: f  reason: collision with root package name */
    TimeInterpolator f21846f = null;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<Integer> f21847g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    ArrayList<View> f21848h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    ArrayList<String> f21849i = null;

    /* renamed from: j  reason: collision with root package name */
    ArrayList<Class> f21850j = null;

    /* renamed from: k  reason: collision with root package name */
    ArrayList<Integer> f21851k = null;

    /* renamed from: l  reason: collision with root package name */
    ArrayList<View> f21852l = null;

    /* renamed from: m  reason: collision with root package name */
    ArrayList<Class> f21853m = null;

    /* renamed from: n  reason: collision with root package name */
    ArrayList<String> f21854n = null;

    /* renamed from: o  reason: collision with root package name */
    ArrayList<Integer> f21855o = null;

    /* renamed from: p  reason: collision with root package name */
    ArrayList<View> f21856p = null;

    /* renamed from: q  reason: collision with root package name */
    ArrayList<Class> f21857q = null;

    /* renamed from: r  reason: collision with root package name */
    TransitionSet f21858r = null;

    /* renamed from: s  reason: collision with root package name */
    int[] f21859s = f21841a;

    /* renamed from: t  reason: collision with root package name */
    ArrayList<h> f21860t;

    /* renamed from: u  reason: collision with root package name */
    ArrayList<h> f21861u;

    /* renamed from: v  reason: collision with root package name */
    ViewGroup f21862v = null;

    /* renamed from: w  reason: collision with root package name */
    boolean f21863w = false;

    /* renamed from: x  reason: collision with root package name */
    int f21864x = 0;

    /* renamed from: y  reason: collision with root package name */
    boolean f21865y = false;

    /* renamed from: z  reason: collision with root package name */
    ArrayList<c> f21866z = null;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final View f21870a;

        /* renamed from: b  reason: collision with root package name */
        final String f21871b;

        /* renamed from: c  reason: collision with root package name */
        final h f21872c;

        /* renamed from: d  reason: collision with root package name */
        final Object f21873d;

        /* renamed from: e  reason: collision with root package name */
        final Transition f21874e;

        a(View view, String str, Transition transition, Object obj, h hVar) {
            this.f21870a = view;
            this.f21871b = str;
            this.f21872c = hVar;
            this.f21873d = obj;
            this.f21874e = transition;
        }
    }

    public static abstract class b {
        public abstract Rect a(Transition transition);
    }

    public interface c {
        void a(Transition transition);

        void b(Transition transition);

        void c(Transition transition);

        void d(Transition transition);

        void e(Transition transition);
    }

    public static class d implements c {
        public void a(Transition transition) {
        }

        public void b(Transition transition) {
        }

        public void c(Transition transition) {
        }

        public void d(Transition transition) {
        }

        public void e(Transition transition) {
        }
    }

    public Transition() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x008a, code lost:
        if (r3 >= 0) goto L_0x007d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Transition(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            r7.<init>()
            java.lang.Class r0 = r7.getClass()
            java.lang.String r0 = r0.getName()
            r7.f21842b = r0
            r0 = -1
            r7.f21844d = r0
            r7.f21845e = r0
            r0 = 0
            r7.f21846f = r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r7.f21847g = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r7.f21848h = r1
            r7.f21849i = r0
            r7.f21850j = r0
            r7.f21851k = r0
            r7.f21852l = r0
            r7.f21853m = r0
            r7.f21854n = r0
            r7.f21855o = r0
            r7.f21856p = r0
            r7.f21857q = r0
            com.transitionseverywhere.i r1 = new com.transitionseverywhere.i
            r1.<init>()
            r7.f21843c = r1
            com.transitionseverywhere.i r1 = new com.transitionseverywhere.i
            r1.<init>()
            r7.F = r1
            r7.f21858r = r0
            int[] r1 = f21841a
            r7.f21859s = r1
            r7.f21862v = r0
            r1 = 0
            r7.f21863w = r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r7.H = r2
            r7.f21864x = r1
            r7.f21865y = r1
            r7.I = r1
            r7.f21866z = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r7.A = r0
            com.transitionseverywhere.PathMotion r0 = com.transitionseverywhere.PathMotion.f21832a
            r7.E = r0
            int[] r0 = com.transitionseverywhere.R.styleable.Transition
            android.content.res.TypedArray r9 = r8.obtainStyledAttributes(r9, r0)
            int r0 = com.transitionseverywhere.R.styleable.Transition_duration
            r2 = -1
            int r0 = r9.getInt(r0, r2)
            long r3 = (long) r0
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0081
        L_0x007d:
            r7.a((long) r3)
            goto L_0x008d
        L_0x0081:
            int r0 = com.transitionseverywhere.R.styleable.Transition_android_duration
            int r0 = r9.getInt(r0, r2)
            long r3 = (long) r0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x008d
            goto L_0x007d
        L_0x008d:
            int r0 = com.transitionseverywhere.R.styleable.Transition_startDelay
            int r0 = r9.getInt(r0, r2)
            long r2 = (long) r0
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x009b
            r7.b((long) r2)
        L_0x009b:
            int r0 = com.transitionseverywhere.R.styleable.Transition_interpolator
            int r0 = r9.getResourceId(r0, r1)
            if (r0 <= 0) goto L_0x00ab
        L_0x00a3:
            android.view.animation.Interpolator r8 = android.view.animation.AnimationUtils.loadInterpolator(r8, r0)
            r7.a((android.animation.TimeInterpolator) r8)
            goto L_0x00b4
        L_0x00ab:
            int r0 = com.transitionseverywhere.R.styleable.Transition_android_interpolator
            int r0 = r9.getResourceId(r0, r1)
            if (r0 <= 0) goto L_0x00b4
            goto L_0x00a3
        L_0x00b4:
            int r8 = com.transitionseverywhere.R.styleable.Transition_matchOrder
            java.lang.String r8 = r9.getString(r8)
            if (r8 == 0) goto L_0x00c3
            int[] r8 = b((java.lang.String) r8)
            r7.a((int[]) r8)
        L_0x00c3:
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.Transition.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private void a(Animator animator, final j.a<Animator, a> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    aVar.remove(animator);
                    Transition.this.H.remove(animator);
                }

                public void onAnimationStart(Animator animator) {
                    Transition.this.H.add(animator);
                }
            });
            a(animator);
        }
    }

    static void a(i iVar, View view, h hVar) {
        iVar.f21929a.put(view, hVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (iVar.f21930b.indexOfKey(id2) >= 0) {
                iVar.f21930b.put(id2, (Object) null);
            } else {
                iVar.f21930b.put(id2, view);
            }
        }
        String b2 = m.b(view);
        if (b2 != null) {
            if (iVar.f21932d.containsKey(b2)) {
                iVar.f21932d.put(b2, null);
            } else {
                iVar.f21932d.put(b2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (iVar.f21931c.d(itemIdAtPosition) >= 0) {
                    View a2 = iVar.f21931c.a(itemIdAtPosition);
                    if (a2 != null) {
                        m.b(a2, false);
                        iVar.f21931c.b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                m.b(view, true);
                iVar.f21931c.b(itemIdAtPosition, view);
            }
        }
    }

    private void a(i iVar, i iVar2) {
        j.a aVar = new j.a((g) iVar.f21929a);
        j.a aVar2 = new j.a((g) iVar2.f21929a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.f21859s;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 == 1) {
                    a((j.a<View, h>) aVar, (j.a<View, h>) aVar2);
                } else if (i3 == 2) {
                    a((j.a<View, h>) aVar, (j.a<View, h>) aVar2, iVar.f21932d, iVar2.f21932d);
                } else if (i3 == 3) {
                    a((j.a<View, h>) aVar, (j.a<View, h>) aVar2, iVar.f21930b, iVar2.f21930b);
                } else if (i3 == 4) {
                    a((j.a<View, h>) aVar, (j.a<View, h>) aVar2, iVar.f21931c, iVar2.f21931c);
                }
                i2++;
            } else {
                b((j.a<View, h>) aVar, (j.a<View, h>) aVar2);
                return;
            }
        }
    }

    private void a(j.a<View, h> aVar, j.a<View, h> aVar2) {
        h remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View b2 = aVar.b(size);
            if (b2 != null && b(b2) && (remove = aVar2.remove(b2)) != null && b(remove.f21926a)) {
                this.f21860t.add(aVar.d(size));
                this.f21861u.add(remove);
            }
        }
    }

    private void a(j.a<View, h> aVar, j.a<View, h> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && b(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && b(view)) {
                h hVar = aVar.get(valueAt);
                h hVar2 = aVar2.get(view);
                if (!(hVar == null || hVar2 == null)) {
                    this.f21860t.add(hVar);
                    this.f21861u.add(hVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void a(j.a<View, h> aVar, j.a<View, h> aVar2, j.a<String, View> aVar3, j.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View c2 = aVar3.c(i2);
            if (c2 != null && b(c2) && (view = aVar4.get(aVar3.b(i2))) != null && b(view)) {
                h hVar = aVar.get(c2);
                h hVar2 = aVar2.get(view);
                if (!(hVar == null || hVar2 == null)) {
                    this.f21860t.add(hVar);
                    this.f21861u.add(hVar2);
                    aVar.remove(c2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void a(j.a<View, h> aVar, j.a<View, h> aVar2, j.d<View> dVar, j.d<View> dVar2) {
        View a2;
        int b2 = dVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View c2 = dVar.c(i2);
            if (c2 != null && b(c2) && (a2 = dVar2.a(dVar.b(i2))) != null && b(a2)) {
                h hVar = aVar.get(c2);
                h hVar2 = aVar2.get(a2);
                if (!(hVar == null || hVar2 == null)) {
                    this.f21860t.add(hVar);
                    this.f21861u.add(hVar2);
                    aVar.remove(c2);
                    aVar2.remove(a2);
                }
            }
        }
    }

    private static boolean a(int i2) {
        return i2 >= 1 && i2 <= 4;
    }

    private static boolean a(h hVar, h hVar2, String str) {
        if (hVar.f21927b.containsKey(str) != hVar2.f21927b.containsKey(str)) {
            return false;
        }
        Object obj = hVar.f21927b.get(str);
        Object obj2 = hVar2.f21927b.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private static boolean a(int[] iArr, int i2) {
        int i3 = iArr[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            if (iArr[i4] == i3) {
                return true;
            }
        }
        return false;
    }

    private static j.a<Animator, a> b() {
        ThreadLocal<j.a<Animator, a>> threadLocal = G;
        j.a<Animator, a> aVar = threadLocal.get();
        if (aVar != null) {
            return aVar;
        }
        j.a<Animator, a> aVar2 = new j.a<>();
        threadLocal.set(aVar2);
        return aVar2;
    }

    private void b(j.a<View, h> aVar, j.a<View, h> aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            this.f21860t.add(aVar.c(i2));
            this.f21861u.add((Object) null);
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            this.f21861u.add(aVar2.c(i3));
            this.f21860t.add((Object) null);
        }
    }

    private static int[] b(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i2] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i2] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i2] = 2;
            } else if ("viewName".equalsIgnoreCase(trim)) {
                iArr[i2] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i2] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                i2--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i2++;
        }
        return iArr;
    }

    private void c(View view, boolean z2) {
        if (view != null) {
            int id2 = view.getId();
            ArrayList<Integer> arrayList = this.f21851k;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
                ArrayList<View> arrayList2 = this.f21852l;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class> arrayList3 = this.f21853m;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (!this.f21853m.get(i2).isInstance(view)) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        h hVar = new h(view);
                        if (z2) {
                            a(hVar);
                        } else {
                            b(hVar);
                        }
                        hVar.f21928c.add(this);
                        c(hVar);
                        a(z2 ? this.f21843c : this.F, view, hVar);
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.f21855o;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                            ArrayList<View> arrayList5 = this.f21856p;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class> arrayList6 = this.f21857q;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i3 = 0;
                                    while (i3 < size2) {
                                        if (!this.f21857q.get(i3).isInstance(view)) {
                                            i3++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                    c(viewGroup.getChildAt(i4), z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Animator a(ViewGroup viewGroup, h hVar, h hVar2) {
        return null;
    }

    public Transition a(long j2) {
        this.f21845e = j2;
        return this;
    }

    public Transition a(TimeInterpolator timeInterpolator) {
        this.f21846f = timeInterpolator;
        return this;
    }

    public Transition a(PathMotion pathMotion) {
        if (pathMotion == null) {
            pathMotion = PathMotion.f21832a;
        }
        this.E = pathMotion;
        return this;
    }

    public Transition a(c cVar) {
        if (this.f21866z == null) {
            this.f21866z = new ArrayList<>();
        }
        this.f21866z.add(cVar);
        return this;
    }

    public Transition a(f fVar) {
        this.B = fVar;
        return this;
    }

    public Transition a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.f21859s = f21841a;
        } else {
            int i2 = 0;
            while (i2 < iArr.length) {
                if (!a(iArr[i2])) {
                    throw new IllegalArgumentException("matches contains invalid value");
                } else if (!a(iArr, i2)) {
                    i2++;
                } else {
                    throw new IllegalArgumentException("matches contains a duplicate value");
                }
            }
            this.f21859s = (int[]) iArr.clone();
        }
        return this;
    }

    public h a(View view, boolean z2) {
        TransitionSet transitionSet = this.f21858r;
        if (transitionSet != null) {
            return transitionSet.a(view, z2);
        }
        return (z2 ? this.f21843c : this.F).f21929a.get(view);
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f21845e != -1) {
            str2 = str2 + "dur(" + this.f21845e + ") ";
        }
        if (this.f21844d != -1) {
            str2 = str2 + "dly(" + this.f21844d + ") ";
        }
        if (this.f21846f != null) {
            str2 = str2 + "interp(" + this.f21846f + ") ";
        }
        if (this.f21847g.size() <= 0 && this.f21848h.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f21847g.size() > 0) {
            for (int i2 = 0; i2 < this.f21847g.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f21847g.get(i2);
            }
        }
        if (this.f21848h.size() > 0) {
            for (int i3 = 0; i3 < this.f21848h.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f21848h.get(i3);
            }
        }
        return str3 + ")";
    }

    /* access modifiers changed from: protected */
    public void a(Animator animator) {
        if (animator == null) {
            h();
            return;
        }
        if (c() >= 0) {
            animator.setDuration(c());
        }
        if (d() >= 0) {
            animator.setStartDelay(d() + animator.getStartDelay());
        }
        if (e() != null) {
            animator.setInterpolator(e());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Transition.this.h();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
        a aVar;
        this.f21860t = new ArrayList<>();
        this.f21861u = new ArrayList<>();
        a(this.f21843c, this.F);
        j.a<Animator, a> b2 = b();
        synchronized (G) {
            int size = b2.size();
            Object e2 = m.e(viewGroup);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                Animator b3 = b2.b(i2);
                if (!(b3 == null || (aVar = b2.get(b3)) == null || aVar.f21870a == null || aVar.f21873d != e2)) {
                    h hVar = aVar.f21872c;
                    View view = aVar.f21870a;
                    h a2 = a(view, true);
                    h b4 = b(view, true);
                    if (a2 == null && b4 == null) {
                        b4 = this.F.f21929a.get(view);
                    }
                    if (!(a2 == null && b4 == null) && aVar.f21874e.a(hVar, b4)) {
                        if (!b3.isRunning()) {
                            if (!com.transitionseverywhere.utils.a.c(b3)) {
                                b2.remove(b3);
                            }
                        }
                        b3.cancel();
                    }
                }
            }
        }
        a(viewGroup, this.f21843c, this.F, this.f21860t, this.f21861u);
        f();
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, i iVar, i iVar2, ArrayList<h> arrayList, ArrayList<h> arrayList2) {
        int i2;
        int i3;
        Animator a2;
        View view;
        Animator animator;
        h hVar;
        Animator animator2;
        h hVar2;
        ViewGroup viewGroup2 = viewGroup;
        j.a<Animator, a> b2 = b();
        this.A.size();
        SparseArray sparseArray = new SparseArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            h hVar3 = arrayList.get(i4);
            h hVar4 = arrayList2.get(i4);
            if (hVar3 != null && !hVar3.f21928c.contains(this)) {
                hVar3 = null;
            }
            if (hVar4 != null && !hVar4.f21928c.contains(this)) {
                hVar4 = null;
            }
            if (!(hVar3 == null && hVar4 == null)) {
                if ((hVar3 == null || hVar4 == null || a(hVar3, hVar4)) && (a2 = a(viewGroup2, hVar3, hVar4)) != null) {
                    if (hVar4 != null) {
                        view = hVar4.f21926a;
                        String[] a3 = a();
                        if (a3 == null || a3.length <= 0) {
                            i3 = size;
                            i2 = i4;
                            animator2 = a2;
                            hVar2 = null;
                        } else {
                            h hVar5 = new h(view);
                            Animator animator3 = a2;
                            i3 = size;
                            h hVar6 = iVar2.f21929a.get(view);
                            if (hVar6 != null) {
                                int i5 = 0;
                                while (i5 < a3.length) {
                                    hVar5.f21927b.put(a3[i5], hVar6.f21927b.get(a3[i5]));
                                    i5++;
                                    ArrayList<h> arrayList3 = arrayList2;
                                    i4 = i4;
                                    hVar6 = hVar6;
                                }
                            }
                            i2 = i4;
                            synchronized (G) {
                                int size2 = b2.size();
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= size2) {
                                        break;
                                    }
                                    a aVar = b2.get(b2.b(i6));
                                    if (aVar.f21872c != null && aVar.f21870a == view && aVar.f21871b.equals(m()) && aVar.f21872c.equals(hVar5)) {
                                        animator3 = null;
                                        break;
                                    }
                                    i6++;
                                }
                            }
                            hVar2 = hVar5;
                            animator2 = animator3;
                        }
                        animator = animator2;
                        hVar = hVar2;
                    } else {
                        i3 = size;
                        i2 = i4;
                        view = hVar3.f21926a;
                        animator = a2;
                        hVar = null;
                    }
                    if (animator != null) {
                        f fVar = this.B;
                        if (fVar != null) {
                            long a4 = fVar.a(viewGroup2, this, hVar3, hVar4);
                            sparseArray.put(this.A.size(), Long.valueOf(a4));
                            j2 = Math.min(a4, j2);
                        }
                        b2.put(animator, new a(view, m(), this, m.e(viewGroup), hVar));
                        this.A.add(animator);
                        j2 = j2;
                    }
                    i4 = i2 + 1;
                    size = i3;
                }
            }
            i3 = size;
            i2 = i4;
            i4 = i2 + 1;
            size = i3;
        }
        if (sparseArray.size() != 0) {
            for (int i7 = 0; i7 < sparseArray.size(); i7++) {
                Animator animator4 = this.A.get(sparseArray.keyAt(i7));
                animator4.setStartDelay((((Long) sparseArray.valueAt(i7)).longValue() - j2) + animator4.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup, boolean z2) {
        j.a<String, String> aVar;
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        b(z2);
        if ((this.f21847g.size() > 0 || this.f21848h.size() > 0) && (((arrayList = this.f21849i) == null || arrayList.isEmpty()) && ((arrayList2 = this.f21850j) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.f21847g.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.f21847g.get(i2).intValue());
                if (findViewById != null) {
                    h hVar = new h(findViewById);
                    if (z2) {
                        a(hVar);
                    } else {
                        b(hVar);
                    }
                    hVar.f21928c.add(this);
                    c(hVar);
                    a(z2 ? this.f21843c : this.F, findViewById, hVar);
                }
            }
            for (int i3 = 0; i3 < this.f21848h.size(); i3++) {
                View view = this.f21848h.get(i3);
                h hVar2 = new h(view);
                if (z2) {
                    a(hVar2);
                } else {
                    b(hVar2);
                }
                hVar2.f21928c.add(this);
                c(hVar2);
                a(z2 ? this.f21843c : this.F, view, hVar2);
            }
        } else {
            c(viewGroup, z2);
        }
        if (!z2 && (aVar = this.D) != null) {
            int size = aVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                arrayList3.add(this.f21843c.f21932d.remove(this.D.b(i4)));
            }
            for (int i5 = 0; i5 < size; i5++) {
                View view2 = (View) arrayList3.get(i5);
                if (view2 != null) {
                    this.f21843c.f21932d.put(this.D.c(i5), view2);
                }
            }
        }
    }

    public abstract void a(h hVar);

    public boolean a(h hVar, h hVar2) {
        if (hVar == null || hVar2 == null) {
            return false;
        }
        String[] a2 = a();
        if (a2 != null) {
            int length = a2.length;
            int i2 = 0;
            while (i2 < length) {
                if (!a(hVar, hVar2, a2[i2])) {
                    i2++;
                }
            }
            return false;
        }
        for (String a3 : hVar.f21927b.keySet()) {
            if (a(hVar, hVar2, a3)) {
            }
        }
        return false;
        return true;
    }

    public String[] a() {
        return null;
    }

    public Transition b(long j2) {
        this.f21844d = j2;
        return this;
    }

    public Transition b(c cVar) {
        ArrayList<c> arrayList = this.f21866z;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(cVar);
        if (this.f21866z.size() == 0) {
            this.f21866z = null;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public h b(View view, boolean z2) {
        TransitionSet transitionSet = this.f21858r;
        if (transitionSet != null) {
            return transitionSet.b(view, z2);
        }
        ArrayList<h> arrayList = z2 ? this.f21860t : this.f21861u;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            h hVar = arrayList.get(i3);
            if (hVar == null) {
                return null;
            }
            if (hVar.f21926a == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z2 ? this.f21861u : this.f21860t).get(i2);
    }

    public abstract void b(h hVar);

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        if (z2) {
            this.f21843c.f21929a.clear();
            this.f21843c.f21930b.clear();
            this.f21843c.f21931c.d();
            this.f21843c.f21932d.clear();
            this.f21860t = null;
            return;
        }
        this.F.f21929a.clear();
        this.F.f21930b.clear();
        this.F.f21931c.d();
        this.F.f21932d.clear();
        this.f21861u = null;
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        if (view == null) {
            return false;
        }
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.f21851k;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f21852l;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class> arrayList5 = this.f21853m;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f21853m.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        String b2 = m.b(view);
        ArrayList<String> arrayList6 = this.f21854n;
        if (arrayList6 != null && b2 != null && arrayList6.contains(b2)) {
            return false;
        }
        if ((this.f21847g.size() == 0 && this.f21848h.size() == 0 && (((arrayList = this.f21850j) == null || arrayList.isEmpty()) && ((arrayList2 = this.f21849i) == null || arrayList2.isEmpty()))) || this.f21847g.contains(Integer.valueOf(id2)) || this.f21848h.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList7 = this.f21849i;
        if (arrayList7 != null && arrayList7.contains(b2)) {
            return true;
        }
        if (this.f21850j != null) {
            for (int i3 = 0; i3 < this.f21850j.size(); i3++) {
                if (this.f21850j.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public long c() {
        return this.f21845e;
    }

    public void c(View view) {
        if (!this.I) {
            synchronized (G) {
                j.a<Animator, a> b2 = b();
                int size = b2.size();
                Object e2 = m.e(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a c2 = b2.c(i2);
                    if (!(c2.f21870a == null || e2 == null || !e2.equals(c2.f21873d))) {
                        com.transitionseverywhere.utils.a.a(b2.b(i2));
                    }
                }
            }
            ArrayList<c> arrayList = this.f21866z;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f21866z.clone();
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((c) arrayList2.get(i3)).c(this);
                }
            }
            this.f21865y = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void c(h hVar) {
        if (this.B != null && !hVar.f21927b.isEmpty()) {
            String[] a2 = this.B.a();
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= a2.length) {
                    z2 = true;
                    break;
                } else if (!hVar.f21927b.containsKey(a2[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                this.B.a(hVar);
            }
        }
    }

    public long d() {
        return this.f21844d;
    }

    public void d(View view) {
        if (this.f21865y) {
            if (!this.I) {
                j.a<Animator, a> b2 = b();
                int size = b2.size();
                Object e2 = m.e(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a c2 = b2.c(i2);
                    if (!(c2.f21870a == null || e2 == null || !e2.equals(c2.f21873d))) {
                        com.transitionseverywhere.utils.a.b(b2.b(i2));
                    }
                }
                ArrayList<c> arrayList = this.f21866z;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f21866z.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((c) arrayList2.get(i3)).d(this);
                    }
                }
            }
            this.f21865y = false;
        }
    }

    public TimeInterpolator e() {
        return this.f21846f;
    }

    /* access modifiers changed from: protected */
    public void f() {
        g();
        j.a<Animator, a> b2 = b();
        Iterator<Animator> it2 = this.A.iterator();
        while (it2.hasNext()) {
            Animator next = it2.next();
            if (b2.containsKey(next)) {
                g();
                a(next, b2);
            }
        }
        this.A.clear();
        h();
    }

    /* access modifiers changed from: protected */
    public void g() {
        if (this.f21864x == 0) {
            ArrayList<c> arrayList = this.f21866z;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f21866z.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).e(this);
                }
            }
            this.I = false;
        }
        this.f21864x++;
    }

    /* access modifiers changed from: protected */
    public void h() {
        int i2 = this.f21864x - 1;
        this.f21864x = i2;
        if (i2 == 0) {
            ArrayList<c> arrayList = this.f21866z;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f21866z.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((c) arrayList2.get(i3)).b(this);
                }
            }
            for (int i4 = 0; i4 < this.f21843c.f21931c.b(); i4++) {
                View c2 = this.f21843c.f21931c.c(i4);
                if (c2 != null) {
                    m.b(c2, false);
                }
            }
            for (int i5 = 0; i5 < this.F.f21931c.b(); i5++) {
                View c3 = this.F.f21931c.c(i5);
                if (c3 != null) {
                    m.b(c3, false);
                }
            }
            this.I = true;
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            this.H.get(size).cancel();
        }
        ArrayList<c> arrayList = this.f21866z;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f21866z.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((c) arrayList2.get(i2)).a(this);
            }
        }
    }

    public Rect j() {
        b bVar = this.C;
        if (bVar == null) {
            return null;
        }
        return bVar.a(this);
    }

    public PathMotion k() {
        return this.E;
    }

    /* renamed from: l */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.A = new ArrayList<>();
            transition.f21843c = new i();
            transition.F = new i();
            transition.f21860t = null;
            transition.f21861u = null;
            return transition;
        } catch (CloneNotSupportedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public String m() {
        return this.f21842b;
    }

    public String toString() {
        return a("");
    }
}
