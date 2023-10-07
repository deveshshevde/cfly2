package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.b;
import java.util.HashSet;
import java.util.LinkedHashMap;
import k.c;

class m implements Comparable<m> {

    /* renamed from: d  reason: collision with root package name */
    static String[] f1928d = {"position", "x", "y", "width", "height", "pathRotate"};
    private float A;
    private float B = Float.NaN;
    private float C = Float.NaN;

    /* renamed from: a  reason: collision with root package name */
    int f1929a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f1930b;

    /* renamed from: c  reason: collision with root package name */
    public float f1931c = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    LinkedHashMap<String, ConstraintAttribute> f1932e = new LinkedHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    int f1933f = 0;

    /* renamed from: g  reason: collision with root package name */
    double[] f1934g = new double[18];

    /* renamed from: h  reason: collision with root package name */
    double[] f1935h = new double[18];

    /* renamed from: i  reason: collision with root package name */
    private float f1936i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1937j = false;

    /* renamed from: k  reason: collision with root package name */
    private float f1938k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f1939l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    private float f1940m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f1941n = 1.0f;

    /* renamed from: o  reason: collision with root package name */
    private float f1942o = 1.0f;

    /* renamed from: p  reason: collision with root package name */
    private float f1943p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    private float f1944q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    private float f1945r = 0.0f;

    /* renamed from: s  reason: collision with root package name */
    private float f1946s = 0.0f;

    /* renamed from: t  reason: collision with root package name */
    private float f1947t = 0.0f;

    /* renamed from: u  reason: collision with root package name */
    private c f1948u;

    /* renamed from: v  reason: collision with root package name */
    private int f1949v = 0;

    /* renamed from: w  reason: collision with root package name */
    private float f1950w;

    /* renamed from: x  reason: collision with root package name */
    private float f1951x;

    /* renamed from: y  reason: collision with root package name */
    private float f1952y;

    /* renamed from: z  reason: collision with root package name */
    private float f1953z;

    private boolean a(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    /* renamed from: a */
    public int compareTo(m mVar) {
        return Float.compare(this.f1950w, mVar.f1950w);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4, float f5) {
        this.f1951x = f2;
        this.f1952y = f3;
        this.f1953z = f4;
        this.A = f5;
    }

    public void a(View view) {
        this.f1930b = view.getVisibility();
        this.f1936i = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.f1937j = false;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1938k = view.getElevation();
        }
        this.f1939l = view.getRotation();
        this.f1940m = view.getRotationX();
        this.f1931c = view.getRotationY();
        this.f1941n = view.getScaleX();
        this.f1942o = view.getScaleY();
        this.f1943p = view.getPivotX();
        this.f1944q = view.getPivotY();
        this.f1945r = view.getTranslationX();
        this.f1946s = view.getTranslationY();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1947t = view.getTranslationZ();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(m mVar, HashSet<String> hashSet) {
        if (a(this.f1936i, mVar.f1936i)) {
            hashSet.add("alpha");
        }
        if (a(this.f1938k, mVar.f1938k)) {
            hashSet.add("elevation");
        }
        int i2 = this.f1930b;
        int i3 = mVar.f1930b;
        if (i2 != i3 && this.f1929a == 0 && (i2 == 0 || i3 == 0)) {
            hashSet.add("alpha");
        }
        if (a(this.f1939l, mVar.f1939l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.B) || !Float.isNaN(mVar.B)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.C) || !Float.isNaN(mVar.C)) {
            hashSet.add("progress");
        }
        if (a(this.f1940m, mVar.f1940m)) {
            hashSet.add("rotationX");
        }
        if (a(this.f1931c, mVar.f1931c)) {
            hashSet.add("rotationY");
        }
        if (a(this.f1943p, mVar.f1943p)) {
            hashSet.add("transformPivotX");
        }
        if (a(this.f1944q, mVar.f1944q)) {
            hashSet.add("transformPivotY");
        }
        if (a(this.f1941n, mVar.f1941n)) {
            hashSet.add("scaleX");
        }
        if (a(this.f1942o, mVar.f1942o)) {
            hashSet.add("scaleY");
        }
        if (a(this.f1945r, mVar.f1945r)) {
            hashSet.add("translationX");
        }
        if (a(this.f1946s, mVar.f1946s)) {
            hashSet.add("translationY");
        }
        if (a(this.f1947t, mVar.f1947t)) {
            hashSet.add("translationZ");
        }
    }

    public void a(ConstraintWidget constraintWidget, b bVar, int i2) {
        a((float) constraintWidget.y(), (float) constraintWidget.z(), (float) constraintWidget.A(), (float) constraintWidget.B());
        a(bVar.a(i2));
    }

    public void a(b.a aVar) {
        this.f1929a = aVar.f2639b.f2691c;
        this.f1930b = aVar.f2639b.f2690b;
        this.f1936i = (aVar.f2639b.f2690b == 0 || this.f1929a != 0) ? aVar.f2639b.f2692d : 0.0f;
        this.f1937j = aVar.f2642e.f2706l;
        this.f1938k = aVar.f2642e.f2707m;
        this.f1939l = aVar.f2642e.f2696b;
        this.f1940m = aVar.f2642e.f2697c;
        this.f1931c = aVar.f2642e.f2698d;
        this.f1941n = aVar.f2642e.f2699e;
        this.f1942o = aVar.f2642e.f2700f;
        this.f1943p = aVar.f2642e.f2701g;
        this.f1944q = aVar.f2642e.f2702h;
        this.f1945r = aVar.f2642e.f2703i;
        this.f1946s = aVar.f2642e.f2704j;
        this.f1947t = aVar.f2642e.f2705k;
        this.f1948u = c.a(aVar.f2640c.f2684c);
        this.B = aVar.f2640c.f2688g;
        this.f1949v = aVar.f2640c.f2686e;
        this.C = aVar.f2639b.f2693e;
        for (String next : aVar.f2643f.keySet()) {
            ConstraintAttribute constraintAttribute = aVar.f2643f.get(next);
            if (constraintAttribute.a() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.f1932e.put(next, constraintAttribute);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x015d, code lost:
        r2.a(r9, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0179, code lost:
        r2.a(r9, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r8, int r9) {
        /*
            r7 = this;
            java.util.Set r0 = r8.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0204
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r8.get(r1)
            androidx.constraintlayout.motion.widget.r r2 = (androidx.constraintlayout.motion.widget.r) r2
            r1.hashCode()
            r3 = -1
            int r4 = r1.hashCode()
            r5 = 1
            switch(r4) {
                case -1249320806: goto L_0x00c9;
                case -1249320805: goto L_0x00be;
                case -1225497657: goto L_0x00b3;
                case -1225497656: goto L_0x00a8;
                case -1225497655: goto L_0x009d;
                case -1001078227: goto L_0x0092;
                case -908189618: goto L_0x0087;
                case -908189617: goto L_0x007c;
                case -760884510: goto L_0x006e;
                case -760884509: goto L_0x0060;
                case -40300674: goto L_0x0052;
                case -4379043: goto L_0x0044;
                case 37232917: goto L_0x0036;
                case 92909918: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x00d3
        L_0x0028:
            java.lang.String r4 = "alpha"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0032
            goto L_0x00d3
        L_0x0032:
            r3 = 13
            goto L_0x00d3
        L_0x0036:
            java.lang.String r4 = "transitionPathRotate"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0040
            goto L_0x00d3
        L_0x0040:
            r3 = 12
            goto L_0x00d3
        L_0x0044:
            java.lang.String r4 = "elevation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x004e
            goto L_0x00d3
        L_0x004e:
            r3 = 11
            goto L_0x00d3
        L_0x0052:
            java.lang.String r4 = "rotation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x005c
            goto L_0x00d3
        L_0x005c:
            r3 = 10
            goto L_0x00d3
        L_0x0060:
            java.lang.String r4 = "transformPivotY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x006a
            goto L_0x00d3
        L_0x006a:
            r3 = 9
            goto L_0x00d3
        L_0x006e:
            java.lang.String r4 = "transformPivotX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0078
            goto L_0x00d3
        L_0x0078:
            r3 = 8
            goto L_0x00d3
        L_0x007c:
            java.lang.String r4 = "scaleY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0085
            goto L_0x00d3
        L_0x0085:
            r3 = 7
            goto L_0x00d3
        L_0x0087:
            java.lang.String r4 = "scaleX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0090
            goto L_0x00d3
        L_0x0090:
            r3 = 6
            goto L_0x00d3
        L_0x0092:
            java.lang.String r4 = "progress"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x009b
            goto L_0x00d3
        L_0x009b:
            r3 = 5
            goto L_0x00d3
        L_0x009d:
            java.lang.String r4 = "translationZ"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00a6
            goto L_0x00d3
        L_0x00a6:
            r3 = 4
            goto L_0x00d3
        L_0x00a8:
            java.lang.String r4 = "translationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00b1
            goto L_0x00d3
        L_0x00b1:
            r3 = 3
            goto L_0x00d3
        L_0x00b3:
            java.lang.String r4 = "translationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00bc
            goto L_0x00d3
        L_0x00bc:
            r3 = 2
            goto L_0x00d3
        L_0x00be:
            java.lang.String r4 = "rotationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00c7
            goto L_0x00d3
        L_0x00c7:
            r3 = 1
            goto L_0x00d3
        L_0x00c9:
            java.lang.String r4 = "rotationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00d2
            goto L_0x00d3
        L_0x00d2:
            r3 = 0
        L_0x00d3:
            r4 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            switch(r3) {
                case 0: goto L_0x01f6;
                case 1: goto L_0x01ea;
                case 2: goto L_0x01de;
                case 3: goto L_0x01d2;
                case 4: goto L_0x01c6;
                case 5: goto L_0x01ba;
                case 6: goto L_0x01ae;
                case 7: goto L_0x01a2;
                case 8: goto L_0x0196;
                case 9: goto L_0x018a;
                case 10: goto L_0x017e;
                case 11: goto L_0x016e;
                case 12: goto L_0x0162;
                case 13: goto L_0x0152;
                default: goto L_0x00d9;
            }
        L_0x00d9:
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r1.startsWith(r3)
            java.lang.String r4 = "MotionPaths"
            if (r3 == 0) goto L_0x0140
            java.lang.String r3 = ","
            java.lang.String[] r3 = r1.split(r3)
            r3 = r3[r5]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r5 = r7.f1932e
            boolean r5 = r5.containsKey(r3)
            if (r5 == 0) goto L_0x012e
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r5 = r7.f1932e
            java.lang.Object r3 = r5.get(r3)
            androidx.constraintlayout.widget.ConstraintAttribute r3 = (androidx.constraintlayout.widget.ConstraintAttribute) r3
            boolean r5 = r2 instanceof androidx.constraintlayout.motion.widget.r.b
            if (r5 == 0) goto L_0x0106
            androidx.constraintlayout.motion.widget.r$b r2 = (androidx.constraintlayout.motion.widget.r.b) r2
            r2.a((int) r9, (androidx.constraintlayout.widget.ConstraintAttribute) r3)
            goto L_0x0008
        L_0x0106:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r1 = " splineSet not a CustomSet frame = "
            r5.append(r1)
            r5.append(r9)
            java.lang.String r1 = ", value"
            r5.append(r1)
            float r1 = r3.c()
            r5.append(r1)
            r5.append(r2)
            java.lang.String r1 = r5.toString()
        L_0x0129:
            android.util.Log.e(r4, r1)
            goto L_0x0008
        L_0x012e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "UNKNOWN customName "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            goto L_0x0129
        L_0x0140:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "UNKNOWN spline "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L_0x0129
        L_0x0152:
            float r1 = r7.f1936i
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x015b
            goto L_0x015d
        L_0x015b:
            float r4 = r7.f1936i
        L_0x015d:
            r2.a((int) r9, (float) r4)
            goto L_0x0008
        L_0x0162:
            float r1 = r7.B
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x016b
            goto L_0x0179
        L_0x016b:
            float r6 = r7.B
            goto L_0x0179
        L_0x016e:
            float r1 = r7.f1938k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0177
            goto L_0x0179
        L_0x0177:
            float r6 = r7.f1938k
        L_0x0179:
            r2.a((int) r9, (float) r6)
            goto L_0x0008
        L_0x017e:
            float r1 = r7.f1939l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0187
            goto L_0x0179
        L_0x0187:
            float r6 = r7.f1939l
            goto L_0x0179
        L_0x018a:
            float r1 = r7.f1944q
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0193
            goto L_0x0179
        L_0x0193:
            float r6 = r7.f1944q
            goto L_0x0179
        L_0x0196:
            float r1 = r7.f1943p
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x019f
            goto L_0x0179
        L_0x019f:
            float r6 = r7.f1943p
            goto L_0x0179
        L_0x01a2:
            float r1 = r7.f1942o
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01ab
            goto L_0x015d
        L_0x01ab:
            float r4 = r7.f1942o
            goto L_0x015d
        L_0x01ae:
            float r1 = r7.f1941n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01b7
            goto L_0x015d
        L_0x01b7:
            float r4 = r7.f1941n
            goto L_0x015d
        L_0x01ba:
            float r1 = r7.C
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01c3
            goto L_0x0179
        L_0x01c3:
            float r6 = r7.C
            goto L_0x0179
        L_0x01c6:
            float r1 = r7.f1947t
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01cf
            goto L_0x0179
        L_0x01cf:
            float r6 = r7.f1947t
            goto L_0x0179
        L_0x01d2:
            float r1 = r7.f1946s
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01db
            goto L_0x0179
        L_0x01db:
            float r6 = r7.f1946s
            goto L_0x0179
        L_0x01de:
            float r1 = r7.f1945r
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01e7
            goto L_0x0179
        L_0x01e7:
            float r6 = r7.f1945r
            goto L_0x0179
        L_0x01ea:
            float r1 = r7.f1931c
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01f3
            goto L_0x0179
        L_0x01f3:
            float r6 = r7.f1931c
            goto L_0x0179
        L_0x01f6:
            float r1 = r7.f1940m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0200
            goto L_0x0179
        L_0x0200:
            float r6 = r7.f1940m
            goto L_0x0179
        L_0x0204:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.m.a(java.util.HashMap, int):void");
    }

    public void b(View view) {
        a(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        a(view);
    }
}
