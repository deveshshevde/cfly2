package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.d;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;

public class f extends ConstraintWidget {

    /* renamed from: a  reason: collision with root package name */
    protected float f2441a = -1.0f;
    private int aA;
    private boolean aB;

    /* renamed from: aw  reason: collision with root package name */
    protected int f2442aw = -1;

    /* renamed from: ax  reason: collision with root package name */
    protected int f2443ax = -1;

    /* renamed from: ay  reason: collision with root package name */
    private ConstraintAnchor f2444ay = this.f2290z;

    /* renamed from: az  reason: collision with root package name */
    private int f2445az;

    /* renamed from: androidx.constraintlayout.solver.widgets.f$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2446a;

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
                f2446a = r0
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2446a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2446a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2446a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f2446a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f2446a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f2446a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f2446a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f2446a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.f.AnonymousClass1.<clinit>():void");
        }
    }

    public f() {
        this.f2445az = 0;
        this.aA = 0;
        this.H.clear();
        this.H.add(this.f2444ay);
        int length = this.G.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.G[i2] = this.f2444ay;
        }
    }

    public ConstraintAnchor a(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f2446a[type.ordinal()]) {
            case 1:
            case 2:
                if (this.f2445az == 1) {
                    return this.f2444ay;
                }
                break;
            case 3:
            case 4:
                if (this.f2445az == 0) {
                    return this.f2444ay;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(type.name());
    }

    public void a(int i2) {
        if (this.f2445az != i2) {
            this.f2445az = i2;
            this.H.clear();
            this.f2444ay = this.f2445az == 1 ? this.f2289y : this.f2290z;
            this.H.add(this.f2444ay);
            int length = this.G.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.G[i3] = this.f2444ay;
            }
        }
    }

    public void a(d dVar, boolean z2) {
        d dVar2 = (d) v();
        if (dVar2 != null) {
            ConstraintAnchor a2 = dVar2.a(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor a3 = dVar2.a(ConstraintAnchor.Type.RIGHT);
            boolean z3 = true;
            boolean z4 = this.J != null && this.J.I[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (this.f2445az == 0) {
                a2 = dVar2.a(ConstraintAnchor.Type.TOP);
                a3 = dVar2.a(ConstraintAnchor.Type.BOTTOM);
                if (this.J == null || this.J.I[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z3 = false;
                }
                z4 = z3;
            }
            if (this.aB && this.f2444ay.f()) {
                SolverVariable a4 = dVar.a((Object) this.f2444ay);
                dVar.a(a4, this.f2444ay.d());
                if (this.f2442aw != -1) {
                    if (z4) {
                        dVar.a(dVar.a((Object) a3), a4, 0, 5);
                    }
                } else if (this.f2443ax != -1 && z4) {
                    SolverVariable a5 = dVar.a((Object) a3);
                    dVar.a(a4, dVar.a((Object) a2), 0, 5);
                    dVar.a(a5, a4, 0, 5);
                }
                this.aB = false;
            } else if (this.f2442aw != -1) {
                SolverVariable a6 = dVar.a((Object) this.f2444ay);
                dVar.c(a6, dVar.a((Object) a2), this.f2442aw, 8);
                if (z4) {
                    dVar.a(dVar.a((Object) a3), a6, 0, 5);
                }
            } else if (this.f2443ax != -1) {
                SolverVariable a7 = dVar.a((Object) this.f2444ay);
                SolverVariable a8 = dVar.a((Object) a3);
                dVar.c(a7, a8, -this.f2443ax, 8);
                if (z4) {
                    dVar.a(a7, dVar.a((Object) a2), 0, 5);
                    dVar.a(a8, a7, 0, 5);
                }
            } else if (this.f2441a != -1.0f) {
                dVar.a(d.a(dVar, dVar.a((Object) this.f2444ay), dVar.a((Object) a3), this.f2441a));
            }
        }
    }

    public void a(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.a(constraintWidget, hashMap);
        f fVar = (f) constraintWidget;
        this.f2441a = fVar.f2441a;
        this.f2442aw = fVar.f2442aw;
        this.f2443ax = fVar.f2443ax;
        a(fVar.f2445az);
    }

    public boolean a() {
        return true;
    }

    public ConstraintAnchor b() {
        return this.f2444ay;
    }

    public void b(int i2) {
        if (i2 > -1) {
            this.f2441a = -1.0f;
            this.f2442aw = i2;
            this.f2443ax = -1;
        }
    }

    public void b(d dVar, boolean z2) {
        if (v() != null) {
            int b2 = dVar.b((Object) this.f2444ay);
            if (this.f2445az == 1) {
                m(b2);
                n(0);
                p(v().B());
                o(0);
                return;
            }
            m(0);
            n(b2);
            o(v().A());
            p(0);
        }
    }

    public int c() {
        return this.f2445az;
    }

    public boolean d() {
        return this.aB;
    }

    public void e(float f2) {
        if (f2 > -1.0f) {
            this.f2441a = f2;
            this.f2442aw = -1;
            this.f2443ax = -1;
        }
    }

    public boolean e() {
        return this.aB;
    }

    public float f() {
        return this.f2441a;
    }

    public int g() {
        return this.f2442aw;
    }

    public int h() {
        return this.f2443ax;
    }

    public void y(int i2) {
        if (i2 > -1) {
            this.f2441a = -1.0f;
            this.f2442aw = -1;
            this.f2443ax = i2;
        }
    }

    public void z(int i2) {
        this.f2444ay.a(i2);
        this.aB = true;
    }
}
