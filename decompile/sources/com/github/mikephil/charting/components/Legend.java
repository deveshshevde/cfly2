package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import fg.b;
import fg.i;
import java.util.ArrayList;
import java.util.List;

public class Legend extends b {
    private List<b> C = new ArrayList(16);
    private List<Boolean> D = new ArrayList(16);
    private List<b> E = new ArrayList(16);

    /* renamed from: a  reason: collision with root package name */
    public float f14852a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f14853b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f14854c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f14855d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private e[] f14856e = new e[0];

    /* renamed from: f  reason: collision with root package name */
    private e[] f14857f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14858g = false;

    /* renamed from: h  reason: collision with root package name */
    private LegendHorizontalAlignment f14859h = LegendHorizontalAlignment.LEFT;

    /* renamed from: i  reason: collision with root package name */
    private LegendVerticalAlignment f14860i = LegendVerticalAlignment.BOTTOM;

    /* renamed from: j  reason: collision with root package name */
    private LegendOrientation f14861j = LegendOrientation.HORIZONTAL;

    /* renamed from: k  reason: collision with root package name */
    private boolean f14862k = false;

    /* renamed from: l  reason: collision with root package name */
    private LegendDirection f14863l = LegendDirection.LEFT_TO_RIGHT;

    /* renamed from: m  reason: collision with root package name */
    private LegendForm f14864m = LegendForm.SQUARE;

    /* renamed from: n  reason: collision with root package name */
    private float f14865n = 8.0f;

    /* renamed from: o  reason: collision with root package name */
    private float f14866o = 3.0f;

    /* renamed from: p  reason: collision with root package name */
    private DashPathEffect f14867p = null;

    /* renamed from: q  reason: collision with root package name */
    private float f14868q = 6.0f;

    /* renamed from: r  reason: collision with root package name */
    private float f14869r = 0.0f;

    /* renamed from: s  reason: collision with root package name */
    private float f14870s = 5.0f;

    /* renamed from: t  reason: collision with root package name */
    private float f14871t = 3.0f;

    /* renamed from: u  reason: collision with root package name */
    private float f14872u = 0.95f;

    /* renamed from: v  reason: collision with root package name */
    private boolean f14873v = false;

    /* renamed from: com.github.mikephil.charting.components.Legend$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14874a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r0 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14874a = r0
                com.github.mikephil.charting.components.Legend$LegendOrientation r1 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14874a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendOrientation r1 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.AnonymousClass1.<clinit>():void");
        }
    }

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.A = i.a(10.0f);
        this.f14946x = i.a(5.0f);
        this.f14947y = i.a(3.0f);
    }

    public float a(Paint paint) {
        float a2 = i.a(this.f14870s);
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (e eVar : this.f14856e) {
            float a3 = i.a(Float.isNaN(eVar.f14954c) ? this.f14865n : eVar.f14954c);
            if (a3 > f3) {
                f3 = a3;
            }
            String str = eVar.f14952a;
            if (str != null) {
                float a4 = (float) i.a(paint, str);
                if (a4 > f2) {
                    f2 = a4;
                }
            }
        }
        return f2 + f3 + a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:88:0x01dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.graphics.Paint r28, fg.j r29) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            float r2 = r0.f14865n
            float r2 = fg.i.a((float) r2)
            float r3 = r0.f14871t
            float r3 = fg.i.a((float) r3)
            float r4 = r0.f14870s
            float r4 = fg.i.a((float) r4)
            float r5 = r0.f14868q
            float r5 = fg.i.a((float) r5)
            float r6 = r0.f14869r
            float r6 = fg.i.a((float) r6)
            boolean r7 = r0.f14873v
            com.github.mikephil.charting.components.e[] r8 = r0.f14856e
            int r9 = r8.length
            float r10 = r27.a((android.graphics.Paint) r28)
            r0.f14855d = r10
            float r10 = r27.b(r28)
            r0.f14854c = r10
            int[] r10 = com.github.mikephil.charting.components.Legend.AnonymousClass1.f14874a
            com.github.mikephil.charting.components.Legend$LegendOrientation r11 = r0.f14861j
            int r11 = r11.ordinal()
            r10 = r10[r11]
            r12 = 1
            if (r10 == r12) goto L_0x017c
            r14 = 2
            if (r10 == r14) goto L_0x0045
            goto L_0x01f9
        L_0x0045:
            float r10 = fg.i.a((android.graphics.Paint) r28)
            float r14 = fg.i.b((android.graphics.Paint) r28)
            float r14 = r14 + r6
            float r6 = r29.i()
            float r15 = r0.f14872u
            float r6 = r6 * r15
            java.util.List<java.lang.Boolean> r15 = r0.D
            r15.clear()
            java.util.List<fg.b> r15 = r0.C
            r15.clear()
            java.util.List<fg.b> r15 = r0.E
            r15.clear()
            r12 = 0
            r13 = -1
            r17 = 0
            r19 = 0
            r20 = 0
        L_0x006d:
            if (r12 >= r9) goto L_0x0151
            r15 = r8[r12]
            com.github.mikephil.charting.components.Legend$LegendForm r11 = r15.f14953b
            r22 = r2
            com.github.mikephil.charting.components.Legend$LegendForm r2 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            if (r11 == r2) goto L_0x007b
            r2 = 1
            goto L_0x007c
        L_0x007b:
            r2 = 0
        L_0x007c:
            float r11 = r15.f14954c
            boolean r11 = java.lang.Float.isNaN(r11)
            if (r11 == 0) goto L_0x0087
            r11 = r22
            goto L_0x008d
        L_0x0087:
            float r11 = r15.f14954c
            float r11 = fg.i.a((float) r11)
        L_0x008d:
            java.lang.String r15 = r15.f14952a
            r23 = r5
            java.util.List<java.lang.Boolean> r5 = r0.D
            r24 = r8
            r21 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r21)
            r5.add(r8)
            r5 = -1
            if (r13 != r5) goto L_0x00a3
            r5 = 0
            goto L_0x00a5
        L_0x00a3:
            float r5 = r19 + r3
        L_0x00a5:
            if (r15 == 0) goto L_0x00c5
            java.util.List<fg.b> r8 = r0.C
            r19 = r3
            fg.b r3 = fg.i.c(r1, r15)
            r8.add(r3)
            if (r2 == 0) goto L_0x00b7
            float r2 = r4 + r11
            goto L_0x00b8
        L_0x00b7:
            r2 = 0
        L_0x00b8:
            float r5 = r5 + r2
            java.util.List<fg.b> r2 = r0.C
            java.lang.Object r2 = r2.get(r12)
            fg.b r2 = (fg.b) r2
            float r2 = r2.f27215a
            float r5 = r5 + r2
            goto L_0x00de
        L_0x00c5:
            r19 = r3
            java.util.List<fg.b> r3 = r0.C
            r25 = r11
            r8 = 0
            fg.b r11 = fg.b.a(r8, r8)
            r3.add(r11)
            if (r2 == 0) goto L_0x00d8
            r11 = r25
            goto L_0x00d9
        L_0x00d8:
            r11 = 0
        L_0x00d9:
            float r5 = r5 + r11
            r2 = -1
            if (r13 != r2) goto L_0x00de
            r13 = r12
        L_0x00de:
            if (r15 != 0) goto L_0x00e4
            int r2 = r9 + -1
            if (r12 != r2) goto L_0x0140
        L_0x00e4:
            r2 = r20
            r8 = 0
            int r3 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x00ed
            r3 = 0
            goto L_0x00ef
        L_0x00ed:
            r3 = r23
        L_0x00ef:
            if (r7 == 0) goto L_0x0121
            int r11 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r11 == 0) goto L_0x0121
            float r11 = r6 - r2
            float r18 = r3 + r5
            int r11 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r11 < 0) goto L_0x00fe
            goto L_0x0121
        L_0x00fe:
            java.util.List<fg.b> r3 = r0.E
            fg.b r11 = fg.b.a(r2, r10)
            r3.add(r11)
            r11 = r17
            float r2 = java.lang.Math.max(r11, r2)
            java.util.List<java.lang.Boolean> r3 = r0.D
            r11 = -1
            if (r13 <= r11) goto L_0x0114
            r8 = r13
            goto L_0x0115
        L_0x0114:
            r8 = r12
        L_0x0115:
            r16 = 1
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r16)
            r3.set(r8, r11)
            r3 = r5
            r8 = -1
            goto L_0x012a
        L_0x0121:
            r11 = r17
            r8 = -1
            float r3 = r3 + r5
            float r20 = r2 + r3
            r2 = r11
            r3 = r20
        L_0x012a:
            int r11 = r9 + -1
            if (r12 != r11) goto L_0x013c
            java.util.List<fg.b> r11 = r0.E
            fg.b r8 = fg.b.a(r3, r10)
            r11.add(r8)
            float r17 = java.lang.Math.max(r2, r3)
            goto L_0x013e
        L_0x013c:
            r17 = r2
        L_0x013e:
            r20 = r3
        L_0x0140:
            if (r15 == 0) goto L_0x0143
            r13 = -1
        L_0x0143:
            int r12 = r12 + 1
            r3 = r19
            r2 = r22
            r8 = r24
            r19 = r5
            r5 = r23
            goto L_0x006d
        L_0x0151:
            r11 = r17
            r21 = 0
            r0.f14852a = r11
            java.util.List<fg.b> r1 = r0.E
            int r1 = r1.size()
            float r1 = (float) r1
            float r10 = r10 * r1
            java.util.List<fg.b> r1 = r0.E
            int r1 = r1.size()
            if (r1 != 0) goto L_0x016a
            r11 = 0
            goto L_0x0174
        L_0x016a:
            java.util.List<fg.b> r1 = r0.E
            int r1 = r1.size()
            r16 = 1
            int r11 = r1 + -1
        L_0x0174:
            float r1 = (float) r11
            float r14 = r14 * r1
            float r10 = r10 + r14
            r0.f14853b = r10
            goto L_0x01f9
        L_0x017c:
            r22 = r2
            r19 = r3
            r24 = r8
            r16 = 1
            r21 = 0
            float r2 = fg.i.a((android.graphics.Paint) r28)
            r3 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r10 = 0
        L_0x018f:
            if (r7 >= r9) goto L_0x01f5
            r11 = r24[r7]
            com.github.mikephil.charting.components.Legend$LegendForm r12 = r11.f14953b
            com.github.mikephil.charting.components.Legend$LegendForm r13 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            if (r12 == r13) goto L_0x019b
            r12 = 1
            goto L_0x019c
        L_0x019b:
            r12 = 0
        L_0x019c:
            float r13 = r11.f14954c
            boolean r13 = java.lang.Float.isNaN(r13)
            if (r13 == 0) goto L_0x01a7
            r13 = r22
            goto L_0x01ad
        L_0x01a7:
            float r13 = r11.f14954c
            float r13 = fg.i.a((float) r13)
        L_0x01ad:
            java.lang.String r11 = r11.f14952a
            if (r10 != 0) goto L_0x01b2
            r5 = 0
        L_0x01b2:
            if (r12 == 0) goto L_0x01b9
            if (r10 == 0) goto L_0x01b8
            float r5 = r5 + r19
        L_0x01b8:
            float r5 = r5 + r13
        L_0x01b9:
            if (r11 == 0) goto L_0x01e6
            if (r12 == 0) goto L_0x01c1
            if (r10 != 0) goto L_0x01c1
            float r5 = r5 + r4
            goto L_0x01ce
        L_0x01c1:
            if (r10 == 0) goto L_0x01ce
            float r8 = java.lang.Math.max(r8, r5)
            float r5 = r2 + r6
            float r3 = r3 + r5
            r5 = r8
            r8 = 0
            r10 = 0
            goto L_0x01d3
        L_0x01ce:
            r26 = r8
            r8 = r5
            r5 = r26
        L_0x01d3:
            int r11 = fg.i.a((android.graphics.Paint) r1, (java.lang.String) r11)
            float r11 = (float) r11
            float r8 = r8 + r11
            int r11 = r9 + -1
            if (r7 >= r11) goto L_0x01e0
            float r11 = r2 + r6
            float r3 = r3 + r11
        L_0x01e0:
            r26 = r8
            r8 = r5
            r5 = r26
            goto L_0x01ee
        L_0x01e6:
            float r5 = r5 + r13
            int r10 = r9 + -1
            if (r7 >= r10) goto L_0x01ed
            float r5 = r5 + r19
        L_0x01ed:
            r10 = 1
        L_0x01ee:
            float r8 = java.lang.Math.max(r8, r5)
            int r7 = r7 + 1
            goto L_0x018f
        L_0x01f5:
            r0.f14852a = r8
            r0.f14853b = r3
        L_0x01f9:
            float r1 = r0.f14853b
            float r2 = r0.f14947y
            float r1 = r1 + r2
            r0.f14853b = r1
            float r1 = r0.f14852a
            float r2 = r0.f14946x
            float r1 = r1 + r2
            r0.f14852a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.a(android.graphics.Paint, fg.j):void");
    }

    public void a(List<e> list) {
        this.f14856e = (e[]) list.toArray(new e[list.size()]);
    }

    public e[] a() {
        return this.f14856e;
    }

    public float b(Paint paint) {
        float f2 = 0.0f;
        for (e eVar : this.f14856e) {
            String str = eVar.f14952a;
            if (str != null) {
                float b2 = (float) i.b(paint, str);
                if (b2 > f2) {
                    f2 = b2;
                }
            }
        }
        return f2;
    }

    public e[] b() {
        return this.f14857f;
    }

    public boolean c() {
        return this.f14858g;
    }

    public LegendHorizontalAlignment d() {
        return this.f14859h;
    }

    public LegendVerticalAlignment e() {
        return this.f14860i;
    }

    public LegendOrientation f() {
        return this.f14861j;
    }

    public boolean g() {
        return this.f14862k;
    }

    public LegendDirection h() {
        return this.f14863l;
    }

    public LegendForm i() {
        return this.f14864m;
    }

    public float j() {
        return this.f14865n;
    }

    public float k() {
        return this.f14866o;
    }

    public DashPathEffect l() {
        return this.f14867p;
    }

    public float m() {
        return this.f14868q;
    }

    public float n() {
        return this.f14869r;
    }

    public float o() {
        return this.f14870s;
    }

    public float p() {
        return this.f14871t;
    }

    public float q() {
        return this.f14872u;
    }

    public List<b> r() {
        return this.C;
    }

    public List<Boolean> s() {
        return this.D;
    }

    public List<b> z() {
        return this.E;
    }
}
