package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import j.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import l.g;
import org.xmlpull.v1.XmlPullParser;
import t.ac;

public abstract class Transition implements Cloneable {
    private static ThreadLocal<j.a<Animator, a>> A = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f4709a = {2, 1, 3, 4};

    /* renamed from: i  reason: collision with root package name */
    private static final PathMotion f4710i = new PathMotion() {
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };
    private ViewGroup B = null;
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private ArrayList<c> F = null;
    private ArrayList<Animator> G = new ArrayList<>();
    private b H;
    private j.a<String, String> I;
    private PathMotion J = f4710i;

    /* renamed from: b  reason: collision with root package name */
    long f4711b = -1;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<Integer> f4712c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<View> f4713d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    TransitionSet f4714e = null;

    /* renamed from: f  reason: collision with root package name */
    boolean f4715f = false;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<Animator> f4716g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    w f4717h;

    /* renamed from: j  reason: collision with root package name */
    private String f4718j = getClass().getName();

    /* renamed from: k  reason: collision with root package name */
    private long f4719k = -1;

    /* renamed from: l  reason: collision with root package name */
    private TimeInterpolator f4720l = null;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<String> f4721m = null;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<Class<?>> f4722n = null;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<Integer> f4723o = null;

    /* renamed from: p  reason: collision with root package name */
    private ArrayList<View> f4724p = null;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<Class<?>> f4725q = null;

    /* renamed from: r  reason: collision with root package name */
    private ArrayList<String> f4726r = null;

    /* renamed from: s  reason: collision with root package name */
    private ArrayList<Integer> f4727s = null;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<View> f4728t = null;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<Class<?>> f4729u = null;

    /* renamed from: v  reason: collision with root package name */
    private z f4730v = new z();

    /* renamed from: w  reason: collision with root package name */
    private z f4731w = new z();

    /* renamed from: x  reason: collision with root package name */
    private int[] f4732x = f4709a;

    /* renamed from: y  reason: collision with root package name */
    private ArrayList<y> f4733y;

    /* renamed from: z  reason: collision with root package name */
    private ArrayList<y> f4734z;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        View f4738a;

        /* renamed from: b  reason: collision with root package name */
        String f4739b;

        /* renamed from: c  reason: collision with root package name */
        y f4740c;

        /* renamed from: d  reason: collision with root package name */
        at f4741d;

        /* renamed from: e  reason: collision with root package name */
        Transition f4742e;

        a(View view, String str, Transition transition, at atVar, y yVar) {
            this.f4738a = view;
            this.f4739b = str;
            this.f4740c = yVar;
            this.f4741d = atVar;
            this.f4742e = transition;
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

    public Transition() {
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f4864c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long a2 = (long) g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "duration", 1, -1);
        if (a2 >= 0) {
            a(a2);
        }
        long a3 = (long) g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (a3 > 0) {
            b(a3);
        }
        int c2 = g.c(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (c2 > 0) {
            a((TimeInterpolator) AnimationUtils.loadInterpolator(context, c2));
        }
        String a4 = g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "matchOrder", 3);
        if (a4 != null) {
            a(b(a4));
        }
        obtainStyledAttributes.recycle();
    }

    private void a(Animator animator, final j.a<Animator, a> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    aVar.remove(animator);
                    Transition.this.f4716g.remove(animator);
                }

                public void onAnimationStart(Animator animator) {
                    Transition.this.f4716g.add(animator);
                }
            });
            a(animator);
        }
    }

    private static void a(z zVar, View view, y yVar) {
        zVar.f4889a.put(view, yVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (zVar.f4890b.indexOfKey(id2) >= 0) {
                zVar.f4890b.put(id2, (Object) null);
            } else {
                zVar.f4890b.put(id2, view);
            }
        }
        String u2 = ac.u(view);
        if (u2 != null) {
            if (zVar.f4892d.containsKey(u2)) {
                zVar.f4892d.put(u2, null);
            } else {
                zVar.f4892d.put(u2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (zVar.f4891c.d(itemIdAtPosition) >= 0) {
                    View a2 = zVar.f4891c.a(itemIdAtPosition);
                    if (a2 != null) {
                        ac.a(a2, false);
                        zVar.f4891c.b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ac.a(view, true);
                zVar.f4891c.b(itemIdAtPosition, view);
            }
        }
    }

    private void a(z zVar, z zVar2) {
        j.a aVar = new j.a((j.g) zVar.f4889a);
        j.a aVar2 = new j.a((j.g) zVar2.f4889a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.f4732x;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 == 1) {
                    a((j.a<View, y>) aVar, (j.a<View, y>) aVar2);
                } else if (i3 == 2) {
                    a((j.a<View, y>) aVar, (j.a<View, y>) aVar2, zVar.f4892d, zVar2.f4892d);
                } else if (i3 == 3) {
                    a((j.a<View, y>) aVar, (j.a<View, y>) aVar2, zVar.f4890b, zVar2.f4890b);
                } else if (i3 == 4) {
                    a((j.a<View, y>) aVar, (j.a<View, y>) aVar2, zVar.f4891c, zVar2.f4891c);
                }
                i2++;
            } else {
                b((j.a<View, y>) aVar, (j.a<View, y>) aVar2);
                return;
            }
        }
    }

    private void a(j.a<View, y> aVar, j.a<View, y> aVar2) {
        y remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View b2 = aVar.b(size);
            if (b2 != null && b(b2) && (remove = aVar2.remove(b2)) != null && b(remove.f4887b)) {
                this.f4733y.add(aVar.d(size));
                this.f4734z.add(remove);
            }
        }
    }

    private void a(j.a<View, y> aVar, j.a<View, y> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && b(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && b(view)) {
                y yVar = aVar.get(valueAt);
                y yVar2 = aVar2.get(view);
                if (!(yVar == null || yVar2 == null)) {
                    this.f4733y.add(yVar);
                    this.f4734z.add(yVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void a(j.a<View, y> aVar, j.a<View, y> aVar2, j.a<String, View> aVar3, j.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View c2 = aVar3.c(i2);
            if (c2 != null && b(c2) && (view = aVar4.get(aVar3.b(i2))) != null && b(view)) {
                y yVar = aVar.get(c2);
                y yVar2 = aVar2.get(view);
                if (!(yVar == null || yVar2 == null)) {
                    this.f4733y.add(yVar);
                    this.f4734z.add(yVar2);
                    aVar.remove(c2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void a(j.a<View, y> aVar, j.a<View, y> aVar2, d<View> dVar, d<View> dVar2) {
        View a2;
        int b2 = dVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View c2 = dVar.c(i2);
            if (c2 != null && b(c2) && (a2 = dVar2.a(dVar.b(i2))) != null && b(a2)) {
                y yVar = aVar.get(c2);
                y yVar2 = aVar2.get(a2);
                if (!(yVar == null || yVar2 == null)) {
                    this.f4733y.add(yVar);
                    this.f4734z.add(yVar2);
                    aVar.remove(c2);
                    aVar2.remove(a2);
                }
            }
        }
    }

    private static boolean a(int i2) {
        return i2 >= 1 && i2 <= 4;
    }

    private static boolean a(y yVar, y yVar2, String str) {
        Object obj = yVar.f4886a.get(str);
        Object obj2 = yVar2.f4886a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
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

    private void b(j.a<View, y> aVar, j.a<View, y> aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            y c2 = aVar.c(i2);
            if (b(c2.f4887b)) {
                this.f4733y.add(c2);
                this.f4734z.add((Object) null);
            }
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            y c3 = aVar2.c(i3);
            if (b(c3.f4887b)) {
                this.f4734z.add(c3);
                this.f4733y.add((Object) null);
            }
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
            ArrayList<Integer> arrayList = this.f4723o;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
                ArrayList<View> arrayList2 = this.f4724p;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.f4725q;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (!this.f4725q.get(i2).isInstance(view)) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        y yVar = new y(view);
                        if (z2) {
                            a(yVar);
                        } else {
                            b(yVar);
                        }
                        yVar.f4888c.add(this);
                        c(yVar);
                        a(z2 ? this.f4730v : this.f4731w, view, yVar);
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.f4727s;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                            ArrayList<View> arrayList5 = this.f4728t;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.f4729u;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i3 = 0;
                                    while (i3 < size2) {
                                        if (!this.f4729u.get(i3).isInstance(view)) {
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

    private static j.a<Animator, a> s() {
        j.a<Animator, a> aVar = A.get();
        if (aVar != null) {
            return aVar;
        }
        j.a<Animator, a> aVar2 = new j.a<>();
        A.set(aVar2);
        return aVar2;
    }

    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        return null;
    }

    public Transition a(long j2) {
        this.f4711b = j2;
        return this;
    }

    public Transition a(TimeInterpolator timeInterpolator) {
        this.f4720l = timeInterpolator;
        return this;
    }

    public Transition a(c cVar) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(cVar);
        return this;
    }

    public y a(View view, boolean z2) {
        TransitionSet transitionSet = this.f4714e;
        if (transitionSet != null) {
            return transitionSet.a(view, z2);
        }
        return (z2 ? this.f4730v : this.f4731w).f4889a.get(view);
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f4711b != -1) {
            str2 = str2 + "dur(" + this.f4711b + ") ";
        }
        if (this.f4719k != -1) {
            str2 = str2 + "dly(" + this.f4719k + ") ";
        }
        if (this.f4720l != null) {
            str2 = str2 + "interp(" + this.f4720l + ") ";
        }
        if (this.f4712c.size() <= 0 && this.f4713d.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f4712c.size() > 0) {
            for (int i2 = 0; i2 < this.f4712c.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f4712c.get(i2);
            }
        }
        if (this.f4713d.size() > 0) {
            for (int i3 = 0; i3 < this.f4713d.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f4713d.get(i3);
            }
        }
        return str3 + ")";
    }

    /* access modifiers changed from: protected */
    public void a(Animator animator) {
        if (animator == null) {
            k();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (c() >= 0) {
            animator.setStartDelay(c() + animator.getStartDelay());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Transition.this.k();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
        a aVar;
        this.f4733y = new ArrayList<>();
        this.f4734z = new ArrayList<>();
        a(this.f4730v, this.f4731w);
        j.a<Animator, a> s2 = s();
        int size = s2.size();
        at b2 = aj.b(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator b3 = s2.b(i2);
            if (!(b3 == null || (aVar = s2.get(b3)) == null || aVar.f4738a == null || !b2.equals(aVar.f4741d))) {
                y yVar = aVar.f4740c;
                View view = aVar.f4738a;
                y a2 = a(view, true);
                y b4 = b(view, true);
                if (a2 == null && b4 == null) {
                    b4 = this.f4731w.f4889a.get(view);
                }
                if (!(a2 == null && b4 == null) && aVar.f4742e.a(yVar, b4)) {
                    if (b3.isRunning() || b3.isStarted()) {
                        b3.cancel();
                    } else {
                        s2.remove(b3);
                    }
                }
            }
        }
        a(viewGroup, this.f4730v, this.f4731w, this.f4733y, this.f4734z);
        e();
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, z zVar, z zVar2, ArrayList<y> arrayList, ArrayList<y> arrayList2) {
        int i2;
        int i3;
        Animator a2;
        View view;
        Animator animator;
        y yVar;
        y yVar2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        j.a<Animator, a> s2 = s();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            y yVar3 = arrayList.get(i4);
            y yVar4 = arrayList2.get(i4);
            if (yVar3 != null && !yVar3.f4888c.contains(this)) {
                yVar3 = null;
            }
            if (yVar4 != null && !yVar4.f4888c.contains(this)) {
                yVar4 = null;
            }
            if (!(yVar3 == null && yVar4 == null)) {
                if ((yVar3 == null || yVar4 == null || a(yVar3, yVar4)) && (a2 = a(viewGroup2, yVar3, yVar4)) != null) {
                    if (yVar4 != null) {
                        view = yVar4.f4887b;
                        String[] a3 = a();
                        if (a3 != null && a3.length > 0) {
                            yVar2 = new y(view);
                            Animator animator3 = a2;
                            i3 = size;
                            y yVar5 = zVar2.f4889a.get(view);
                            if (yVar5 != null) {
                                int i5 = 0;
                                while (i5 < a3.length) {
                                    yVar2.f4886a.put(a3[i5], yVar5.f4886a.get(a3[i5]));
                                    i5++;
                                    ArrayList<y> arrayList3 = arrayList2;
                                    i4 = i4;
                                    yVar5 = yVar5;
                                }
                            }
                            i2 = i4;
                            int size2 = s2.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    animator2 = animator3;
                                    break;
                                }
                                a aVar = s2.get(s2.b(i6));
                                if (aVar.f4740c != null && aVar.f4738a == view && aVar.f4739b.equals(r()) && aVar.f4740c.equals(yVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i3 = size;
                            i2 = i4;
                            animator2 = a2;
                            yVar2 = null;
                        }
                        animator = animator2;
                        yVar = yVar2;
                    } else {
                        i3 = size;
                        i2 = i4;
                        view = yVar3.f4887b;
                        animator = a2;
                        yVar = null;
                    }
                    if (animator != null) {
                        w wVar = this.f4717h;
                        if (wVar != null) {
                            long a4 = wVar.a(viewGroup2, this, yVar3, yVar4);
                            sparseIntArray.put(this.G.size(), (int) a4);
                            j2 = Math.min(a4, j2);
                        }
                        s2.put(animator, new a(view, r(), this, aj.b(viewGroup), yVar));
                        this.G.add(animator);
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
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator4 = this.G.get(sparseIntArray.keyAt(i7));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i7)) - j2) + animator4.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup, boolean z2) {
        j.a<String, String> aVar;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        b(z2);
        if ((this.f4712c.size() > 0 || this.f4713d.size() > 0) && (((arrayList = this.f4721m) == null || arrayList.isEmpty()) && ((arrayList2 = this.f4722n) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.f4712c.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.f4712c.get(i2).intValue());
                if (findViewById != null) {
                    y yVar = new y(findViewById);
                    if (z2) {
                        a(yVar);
                    } else {
                        b(yVar);
                    }
                    yVar.f4888c.add(this);
                    c(yVar);
                    a(z2 ? this.f4730v : this.f4731w, findViewById, yVar);
                }
            }
            for (int i3 = 0; i3 < this.f4713d.size(); i3++) {
                View view = this.f4713d.get(i3);
                y yVar2 = new y(view);
                if (z2) {
                    a(yVar2);
                } else {
                    b(yVar2);
                }
                yVar2.f4888c.add(this);
                c(yVar2);
                a(z2 ? this.f4730v : this.f4731w, view, yVar2);
            }
        } else {
            c(viewGroup, z2);
        }
        if (!z2 && (aVar = this.I) != null) {
            int size = aVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                arrayList3.add(this.f4730v.f4892d.remove(this.I.b(i4)));
            }
            for (int i5 = 0; i5 < size; i5++) {
                View view2 = (View) arrayList3.get(i5);
                if (view2 != null) {
                    this.f4730v.f4892d.put(this.I.c(i5), view2);
                }
            }
        }
    }

    public void a(PathMotion pathMotion) {
        if (pathMotion == null) {
            pathMotion = f4710i;
        }
        this.J = pathMotion;
    }

    public void a(b bVar) {
        this.H = bVar;
    }

    public void a(w wVar) {
        this.f4717h = wVar;
    }

    public abstract void a(y yVar);

    public void a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.f4732x = f4709a;
            return;
        }
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
        this.f4732x = (int[]) iArr.clone();
    }

    public boolean a(y yVar, y yVar2) {
        if (yVar == null || yVar2 == null) {
            return false;
        }
        String[] a2 = a();
        if (a2 != null) {
            int length = a2.length;
            int i2 = 0;
            while (i2 < length) {
                if (!a(yVar, yVar2, a2[i2])) {
                    i2++;
                }
            }
            return false;
        }
        for (String a3 : yVar.f4886a.keySet()) {
            if (a(yVar, yVar2, a3)) {
            }
        }
        return false;
        return true;
    }

    public String[] a() {
        return null;
    }

    public long b() {
        return this.f4711b;
    }

    public Transition b(long j2) {
        this.f4719k = j2;
        return this;
    }

    public Transition b(c cVar) {
        ArrayList<c> arrayList = this.F;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(cVar);
        if (this.F.size() == 0) {
            this.F = null;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public y b(View view, boolean z2) {
        TransitionSet transitionSet = this.f4714e;
        if (transitionSet != null) {
            return transitionSet.b(view, z2);
        }
        ArrayList<y> arrayList = z2 ? this.f4733y : this.f4734z;
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
            y yVar = arrayList.get(i3);
            if (yVar == null) {
                return null;
            }
            if (yVar.f4887b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z2 ? this.f4734z : this.f4733y).get(i2);
    }

    public abstract void b(y yVar);

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        z zVar;
        if (z2) {
            this.f4730v.f4889a.clear();
            this.f4730v.f4890b.clear();
            zVar = this.f4730v;
        } else {
            this.f4731w.f4889a.clear();
            this.f4731w.f4890b.clear();
            zVar = this.f4731w;
        }
        zVar.f4891c.d();
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.f4723o;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f4724p;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f4725q;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f4725q.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f4726r != null && ac.u(view) != null && this.f4726r.contains(ac.u(view))) {
            return false;
        }
        if ((this.f4712c.size() == 0 && this.f4713d.size() == 0 && (((arrayList = this.f4722n) == null || arrayList.isEmpty()) && ((arrayList2 = this.f4721m) == null || arrayList2.isEmpty()))) || this.f4712c.contains(Integer.valueOf(id2)) || this.f4713d.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f4721m;
        if (arrayList6 != null && arrayList6.contains(ac.u(view))) {
            return true;
        }
        if (this.f4722n != null) {
            for (int i3 = 0; i3 < this.f4722n.size(); i3++) {
                if (this.f4722n.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public long c() {
        return this.f4719k;
    }

    public Transition c(View view) {
        this.f4713d.add(view);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void c(y yVar) {
        String[] a2;
        if (this.f4717h != null && !yVar.f4886a.isEmpty() && (a2 = this.f4717h.a()) != null) {
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= a2.length) {
                    z2 = true;
                    break;
                } else if (!yVar.f4886a.containsKey(a2[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                this.f4717h.a(yVar);
            }
        }
    }

    public TimeInterpolator d() {
        return this.f4720l;
    }

    public Transition d(View view) {
        this.f4713d.remove(view);
        return this;
    }

    /* access modifiers changed from: protected */
    public void e() {
        j();
        j.a<Animator, a> s2 = s();
        Iterator<Animator> it2 = this.G.iterator();
        while (it2.hasNext()) {
            Animator next = it2.next();
            if (s2.containsKey(next)) {
                j();
                a(next, s2);
            }
        }
        this.G.clear();
        k();
    }

    public void e(View view) {
        if (!this.E) {
            j.a<Animator, a> s2 = s();
            int size = s2.size();
            at b2 = aj.b(view);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a c2 = s2.c(i2);
                if (c2.f4738a != null && b2.equals(c2.f4741d)) {
                    a.a(s2.b(i2));
                }
            }
            ArrayList<c> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((c) arrayList2.get(i3)).c(this);
                }
            }
            this.D = true;
        }
    }

    public List<Integer> f() {
        return this.f4712c;
    }

    public void f(View view) {
        if (this.D) {
            if (!this.E) {
                j.a<Animator, a> s2 = s();
                int size = s2.size();
                at b2 = aj.b(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a c2 = s2.c(i2);
                    if (c2.f4738a != null && b2.equals(c2.f4741d)) {
                        a.b(s2.b(i2));
                    }
                }
                ArrayList<c> arrayList = this.F;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.F.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((c) arrayList2.get(i3)).d(this);
                    }
                }
            }
            this.D = false;
        }
    }

    public List<View> g() {
        return this.f4713d;
    }

    public List<String> h() {
        return this.f4721m;
    }

    public List<Class<?>> i() {
        return this.f4722n;
    }

    /* access modifiers changed from: protected */
    public void j() {
        if (this.C == 0) {
            ArrayList<c> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).e(this);
                }
            }
            this.E = false;
        }
        this.C++;
    }

    /* access modifiers changed from: protected */
    public void k() {
        int i2 = this.C - 1;
        this.C = i2;
        if (i2 == 0) {
            ArrayList<c> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((c) arrayList2.get(i3)).b(this);
                }
            }
            for (int i4 = 0; i4 < this.f4730v.f4891c.b(); i4++) {
                View c2 = this.f4730v.f4891c.c(i4);
                if (c2 != null) {
                    ac.a(c2, false);
                }
            }
            for (int i5 = 0; i5 < this.f4731w.f4891c.b(); i5++) {
                View c3 = this.f4731w.f4891c.c(i5);
                if (c3 != null) {
                    ac.a(c3, false);
                }
            }
            this.E = true;
        }
    }

    /* access modifiers changed from: protected */
    public void l() {
        for (int size = this.f4716g.size() - 1; size >= 0; size--) {
            this.f4716g.get(size).cancel();
        }
        ArrayList<c> arrayList = this.F;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.F.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((c) arrayList2.get(i2)).a(this);
            }
        }
    }

    public PathMotion m() {
        return this.J;
    }

    public b n() {
        return this.H;
    }

    public Rect o() {
        b bVar = this.H;
        if (bVar == null) {
            return null;
        }
        return bVar.a(this);
    }

    public w p() {
        return this.f4717h;
    }

    /* renamed from: q */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.G = new ArrayList<>();
            transition.f4730v = new z();
            transition.f4731w = new z();
            transition.f4733y = null;
            transition.f4734z = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String r() {
        return this.f4718j;
    }

    public String toString() {
        return a("");
    }
}
