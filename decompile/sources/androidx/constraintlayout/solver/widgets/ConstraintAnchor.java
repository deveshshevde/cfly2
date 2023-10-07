package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.c;
import androidx.constraintlayout.solver.widgets.analyzer.h;
import androidx.constraintlayout.solver.widgets.analyzer.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintAnchor {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintWidget f2219a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f2220b;

    /* renamed from: c  reason: collision with root package name */
    public ConstraintAnchor f2221c;

    /* renamed from: d  reason: collision with root package name */
    public int f2222d = 0;

    /* renamed from: e  reason: collision with root package name */
    int f2223e = -1;

    /* renamed from: f  reason: collision with root package name */
    SolverVariable f2224f;

    /* renamed from: g  reason: collision with root package name */
    private HashSet<ConstraintAnchor> f2225g = null;

    /* renamed from: h  reason: collision with root package name */
    private int f2226h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2227i;

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintAnchor$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2228a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2228a = r0
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2228a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2228a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2228a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f2228a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f2228a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f2228a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f2228a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f2228a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintAnchor.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f2219a = constraintWidget;
        this.f2220b = type;
    }

    public HashSet<ConstraintAnchor> a() {
        return this.f2225g;
    }

    public void a(int i2) {
        this.f2226h = i2;
        this.f2227i = true;
    }

    public void a(int i2, ArrayList<n> arrayList, n nVar) {
        HashSet<ConstraintAnchor> hashSet = this.f2225g;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                h.a(it2.next().f2219a, i2, arrayList, nVar);
            }
        }
    }

    public void a(c cVar) {
        SolverVariable solverVariable = this.f2224f;
        if (solverVariable == null) {
            this.f2224f = new SolverVariable(SolverVariable.Type.UNRESTRICTED, (String) null);
        } else {
            solverVariable.b();
        }
    }

    public boolean a(ConstraintAnchor constraintAnchor) {
        boolean z2 = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type i2 = constraintAnchor.i();
        Type type = this.f2220b;
        if (i2 == type) {
            return type != Type.BASELINE || (constraintAnchor.h().K() && h().K());
        }
        switch (AnonymousClass1.f2228a[this.f2220b.ordinal()]) {
            case 1:
                return (i2 == Type.BASELINE || i2 == Type.CENTER_X || i2 == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z3 = i2 == Type.LEFT || i2 == Type.RIGHT;
                if (!(constraintAnchor.h() instanceof f)) {
                    return z3;
                }
                if (z3 || i2 == Type.CENTER_X) {
                    z2 = true;
                }
                return z2;
            case 4:
            case 5:
                boolean z4 = i2 == Type.TOP || i2 == Type.BOTTOM;
                if (!(constraintAnchor.h() instanceof f)) {
                    return z4;
                }
                if (z4 || i2 == Type.CENTER_Y) {
                    z2 = true;
                }
                return z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f2220b.name());
        }
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i2) {
        return a(constraintAnchor, i2, -1, false);
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i2, int i3, boolean z2) {
        if (constraintAnchor == null) {
            l();
            return true;
        } else if (!z2 && !a(constraintAnchor)) {
            return false;
        } else {
            this.f2221c = constraintAnchor;
            if (constraintAnchor.f2225g == null) {
                constraintAnchor.f2225g = new HashSet<>();
            }
            HashSet<ConstraintAnchor> hashSet = this.f2221c.f2225g;
            if (hashSet != null) {
                hashSet.add(this);
            }
            if (i2 > 0) {
                this.f2222d = i2;
            } else {
                this.f2222d = 0;
            }
            this.f2223e = i3;
            return true;
        }
    }

    public void b(int i2) {
        if (m()) {
            this.f2223e = i2;
        }
    }

    public boolean b() {
        HashSet<ConstraintAnchor> hashSet = this.f2225g;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean c() {
        HashSet<ConstraintAnchor> hashSet = this.f2225g;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            if (it2.next().n().m()) {
                return true;
            }
        }
        return false;
    }

    public int d() {
        if (!this.f2227i) {
            return 0;
        }
        return this.f2226h;
    }

    public void e() {
        this.f2227i = false;
        this.f2226h = 0;
    }

    public boolean f() {
        return this.f2227i;
    }

    public SolverVariable g() {
        return this.f2224f;
    }

    public ConstraintWidget h() {
        return this.f2219a;
    }

    public Type i() {
        return this.f2220b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r0 = r3.f2221c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int j() {
        /*
            r3 = this;
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r3.f2219a
            int r0 = r0.w()
            r1 = 8
            if (r0 != r1) goto L_0x000c
            r0 = 0
            return r0
        L_0x000c:
            int r0 = r3.f2223e
            r2 = -1
            if (r0 <= r2) goto L_0x0020
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r3.f2221c
            if (r0 == 0) goto L_0x0020
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.f2219a
            int r0 = r0.w()
            if (r0 != r1) goto L_0x0020
            int r0 = r3.f2223e
            return r0
        L_0x0020:
            int r0 = r3.f2222d
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintAnchor.j():int");
    }

    public ConstraintAnchor k() {
        return this.f2221c;
    }

    public void l() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f2221c;
        if (!(constraintAnchor == null || (hashSet = constraintAnchor.f2225g) == null)) {
            hashSet.remove(this);
            if (this.f2221c.f2225g.size() == 0) {
                this.f2221c.f2225g = null;
            }
        }
        this.f2225g = null;
        this.f2221c = null;
        this.f2222d = 0;
        this.f2223e = -1;
        this.f2227i = false;
        this.f2226h = 0;
    }

    public boolean m() {
        return this.f2221c != null;
    }

    public final ConstraintAnchor n() {
        switch (AnonymousClass1.f2228a[this.f2220b.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f2219a.A;
            case 3:
                return this.f2219a.f2289y;
            case 4:
                return this.f2219a.B;
            case 5:
                return this.f2219a.f2290z;
            default:
                throw new AssertionError(this.f2220b.name());
        }
    }

    public String toString() {
        return this.f2219a.x() + ":" + this.f2220b.toString();
    }
}
