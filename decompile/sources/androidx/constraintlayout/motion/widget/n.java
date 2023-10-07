package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import fg.i;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import k.b;
import k.c;
import k.h;

public class n {
    private l[] A;
    private int B = c.f1802a;

    /* renamed from: a  reason: collision with root package name */
    View f1954a;

    /* renamed from: b  reason: collision with root package name */
    int f1955b;

    /* renamed from: c  reason: collision with root package name */
    String f1956c;

    /* renamed from: d  reason: collision with root package name */
    float f1957d = Float.NaN;

    /* renamed from: e  reason: collision with root package name */
    float f1958e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    float f1959f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private int f1960g = -1;

    /* renamed from: h  reason: collision with root package name */
    private p f1961h = new p();

    /* renamed from: i  reason: collision with root package name */
    private p f1962i = new p();

    /* renamed from: j  reason: collision with root package name */
    private m f1963j = new m();

    /* renamed from: k  reason: collision with root package name */
    private m f1964k = new m();

    /* renamed from: l  reason: collision with root package name */
    private b[] f1965l;

    /* renamed from: m  reason: collision with root package name */
    private b f1966m;

    /* renamed from: n  reason: collision with root package name */
    private int[] f1967n;

    /* renamed from: o  reason: collision with root package name */
    private double[] f1968o;

    /* renamed from: p  reason: collision with root package name */
    private double[] f1969p;

    /* renamed from: q  reason: collision with root package name */
    private String[] f1970q;

    /* renamed from: r  reason: collision with root package name */
    private int[] f1971r;

    /* renamed from: s  reason: collision with root package name */
    private int f1972s = 4;

    /* renamed from: t  reason: collision with root package name */
    private float[] f1973t = new float[4];

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<p> f1974u = new ArrayList<>();

    /* renamed from: v  reason: collision with root package name */
    private float[] f1975v = new float[1];

    /* renamed from: w  reason: collision with root package name */
    private ArrayList<c> f1976w = new ArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private HashMap<String, s> f1977x;

    /* renamed from: y  reason: collision with root package name */
    private HashMap<String, r> f1978y;

    /* renamed from: z  reason: collision with root package name */
    private HashMap<String, g> f1979z;

    n(View view) {
        a(view);
    }

    private float a(float f2, float[] fArr) {
        float f3 = 0.0f;
        float f4 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f5 = this.f1959f;
            if (((double) f5) != 1.0d) {
                float f6 = this.f1958e;
                if (f2 < f6) {
                    f2 = 0.0f;
                }
                if (f2 > f6 && ((double) f2) < 1.0d) {
                    f2 = (f2 - f6) * f5;
                }
            }
        }
        c cVar = this.f1961h.f1981b;
        float f7 = Float.NaN;
        Iterator<p> it2 = this.f1974u.iterator();
        while (it2.hasNext()) {
            p next = it2.next();
            if (next.f1981b != null) {
                if (next.f1983d < f2) {
                    c cVar2 = next.f1981b;
                    cVar = cVar2;
                    f3 = next.f1983d;
                } else if (Float.isNaN(f7)) {
                    f7 = next.f1983d;
                }
            }
        }
        if (cVar != null) {
            if (!Float.isNaN(f7)) {
                f4 = f7;
            }
            float f8 = f4 - f3;
            double d2 = (double) ((f2 - f3) / f8);
            f2 = (((float) cVar.a(d2)) * f8) + f3;
            if (fArr != null) {
                fArr[0] = (float) cVar.b(d2);
            }
        }
        return f2;
    }

    private void a(p pVar) {
        int binarySearch = Collections.binarySearch(this.f1974u, pVar);
        if (binarySearch == 0) {
            Log.e("MotionController", " KeyPath positon \"" + pVar.f1984e + "\" outside of range");
        }
        this.f1974u.add((-binarySearch) - 1, pVar);
    }

    private void b(p pVar) {
        pVar.a((float) ((int) this.f1954a.getX()), (float) ((int) this.f1954a.getY()), (float) this.f1954a.getWidth(), (float) this.f1954a.getHeight());
    }

    private float d() {
        float[] fArr = new float[2];
        float f2 = 1.0f / ((float) 99);
        double d2 = i.f27244a;
        double d3 = 0.0d;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < 100; i2++) {
            float f4 = ((float) i2) * f2;
            double d4 = (double) f4;
            c cVar = this.f1961h.f1981b;
            float f5 = Float.NaN;
            Iterator<p> it2 = this.f1974u.iterator();
            float f6 = 0.0f;
            while (it2.hasNext()) {
                p next = it2.next();
                if (next.f1981b != null) {
                    if (next.f1983d < f4) {
                        c cVar2 = next.f1981b;
                        f6 = next.f1983d;
                        cVar = cVar2;
                    } else if (Float.isNaN(f5)) {
                        f5 = next.f1983d;
                    }
                }
            }
            if (cVar != null) {
                if (Float.isNaN(f5)) {
                    f5 = 1.0f;
                }
                float f7 = f5 - f6;
                d4 = (double) ((((float) cVar.a((double) ((f4 - f6) / f7))) * f7) + f6);
            }
            this.f1965l[0].a(d4, this.f1968o);
            this.f1961h.a(this.f1967n, this.f1968o, fArr, 0);
            if (i2 > 0) {
                double d5 = (double) f3;
                double d6 = (double) fArr[1];
                Double.isNaN(d6);
                double d7 = d3 - d6;
                double d8 = (double) fArr[0];
                Double.isNaN(d8);
                double hypot = Math.hypot(d7, d2 - d8);
                Double.isNaN(d5);
                f3 = (float) (d5 + hypot);
            }
            d2 = (double) fArr[0];
            d3 = (double) fArr[1];
        }
        return f3;
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f1962i.f1985f;
    }

    /* access modifiers changed from: package-private */
    public int a(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] a2 = this.f1965l[0].a();
        if (iArr != null) {
            Iterator<p> it2 = this.f1974u.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                iArr[i2] = it2.next().f1993n;
                i2++;
            }
        }
        int i3 = 0;
        for (double a3 : a2) {
            this.f1965l[0].a(a3, this.f1968o);
            this.f1961h.a(this.f1967n, this.f1968o, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    /* access modifiers changed from: package-private */
    public p a(int i2) {
        return this.f1974u.get(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float a2 = a(f2, this.f1975v);
        b[] bVarArr = this.f1965l;
        int i2 = 0;
        if (bVarArr != null) {
            double d2 = (double) a2;
            bVarArr[0].b(d2, this.f1969p);
            this.f1965l[0].a(d2, this.f1968o);
            float f5 = this.f1975v[0];
            while (true) {
                dArr = this.f1969p;
                if (i2 >= dArr.length) {
                    break;
                }
                double d3 = dArr[i2];
                double d4 = (double) f5;
                Double.isNaN(d4);
                dArr[i2] = d3 * d4;
                i2++;
            }
            b bVar = this.f1966m;
            if (bVar != null) {
                double[] dArr2 = this.f1968o;
                if (dArr2.length > 0) {
                    bVar.a(d2, dArr2);
                    this.f1966m.b(d2, this.f1969p);
                    this.f1961h.a(f3, f4, fArr, this.f1967n, this.f1969p, this.f1968o);
                    return;
                }
                return;
            }
            this.f1961h.a(f3, f4, fArr, this.f1967n, dArr, this.f1968o);
            return;
        }
        float f6 = this.f1962i.f1985f - this.f1961h.f1985f;
        float f7 = this.f1962i.f1986g - this.f1961h.f1986g;
        float f8 = (this.f1962i.f1988i - this.f1961h.f1988i) + f7;
        fArr[0] = (f6 * (1.0f - f3)) + (((this.f1962i.f1987h - this.f1961h.f1987h) + f6) * f3);
        fArr[1] = (f7 * (1.0f - f4)) + (f8 * f4);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, int i2, int i3, float f3, float f4, float[] fArr) {
        float a2 = a(f2, this.f1975v);
        HashMap<String, r> hashMap = this.f1978y;
        g gVar = null;
        r rVar = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, r> hashMap2 = this.f1978y;
        r rVar2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, r> hashMap3 = this.f1978y;
        r rVar3 = hashMap3 == null ? null : hashMap3.get("rotation");
        HashMap<String, r> hashMap4 = this.f1978y;
        r rVar4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, r> hashMap5 = this.f1978y;
        r rVar5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, g> hashMap6 = this.f1979z;
        g gVar2 = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, g> hashMap7 = this.f1979z;
        g gVar3 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, g> hashMap8 = this.f1979z;
        g gVar4 = hashMap8 == null ? null : hashMap8.get("rotation");
        HashMap<String, g> hashMap9 = this.f1979z;
        g gVar5 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, g> hashMap10 = this.f1979z;
        if (hashMap10 != null) {
            gVar = hashMap10.get("scaleY");
        }
        h hVar = new h();
        hVar.a();
        hVar.a(rVar3, a2);
        hVar.a(rVar, rVar2, a2);
        hVar.b(rVar4, rVar5, a2);
        hVar.a(gVar4, a2);
        hVar.a(gVar2, gVar3, a2);
        hVar.b(gVar5, gVar, a2);
        b bVar = this.f1966m;
        if (bVar != null) {
            double[] dArr = this.f1968o;
            if (dArr.length > 0) {
                double d2 = (double) a2;
                bVar.a(d2, dArr);
                this.f1966m.b(d2, this.f1969p);
                this.f1961h.a(f3, f4, fArr, this.f1967n, this.f1969p, this.f1968o);
            }
            hVar.a(f3, f4, i2, i3, fArr);
            return;
        }
        int i4 = 0;
        if (this.f1965l != null) {
            double a3 = (double) a(a2, this.f1975v);
            this.f1965l[0].b(a3, this.f1969p);
            this.f1965l[0].a(a3, this.f1968o);
            float f5 = this.f1975v[0];
            while (true) {
                double[] dArr2 = this.f1969p;
                if (i4 < dArr2.length) {
                    double d3 = dArr2[i4];
                    double d4 = (double) f5;
                    Double.isNaN(d4);
                    dArr2[i4] = d3 * d4;
                    i4++;
                } else {
                    float f6 = f3;
                    float f7 = f4;
                    this.f1961h.a(f6, f7, fArr, this.f1967n, dArr2, this.f1968o);
                    hVar.a(f6, f7, i2, i3, fArr);
                    return;
                }
            }
        } else {
            float f8 = this.f1962i.f1985f - this.f1961h.f1985f;
            float f9 = this.f1962i.f1986g - this.f1961h.f1986g;
            g gVar6 = gVar;
            float f10 = (this.f1962i.f1988i - this.f1961h.f1988i) + f9;
            fArr[0] = (f8 * (1.0f - f3)) + (((this.f1962i.f1987h - this.f1961h.f1987h) + f8) * f3);
            fArr[1] = (f9 * (1.0f - f4)) + (f10 * f4);
            hVar.a();
            hVar.a(rVar3, a2);
            hVar.a(rVar, rVar2, a2);
            hVar.b(rVar4, rVar5, a2);
            hVar.a(gVar4, a2);
            hVar.a(gVar2, gVar3, a2);
            hVar.b(gVar5, gVar6, a2);
            hVar.a(f3, f4, i2, i3, fArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float[] fArr, int i2) {
        this.f1965l[0].a((double) a(f2, (float[]) null), this.f1968o);
        this.f1961h.b(this.f1967n, this.f1968o, fArr, i2);
    }

    public void a(int i2, int i3, float f2, long j2) {
        ArrayList arrayList;
        s sVar;
        ConstraintAttribute constraintAttribute;
        r rVar;
        ConstraintAttribute constraintAttribute2;
        Class<double> cls = double.class;
        new HashSet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashMap hashMap = new HashMap();
        if (this.B != c.f1802a) {
            this.f1961h.f1991l = this.B;
        }
        this.f1963j.a(this.f1964k, (HashSet<String>) hashSet2);
        ArrayList<c> arrayList2 = this.f1976w;
        if (arrayList2 != null) {
            Iterator<c> it2 = arrayList2.iterator();
            arrayList = null;
            while (it2.hasNext()) {
                c next = it2.next();
                if (next instanceof i) {
                    i iVar = (i) next;
                    a(new p(i2, i3, iVar, this.f1961h, this.f1962i));
                    if (iVar.f1888q != c.f1802a) {
                        this.f1960g = iVar.f1888q;
                    }
                } else if (next instanceof f) {
                    next.a((HashSet<String>) hashSet3);
                } else if (next instanceof k) {
                    next.a((HashSet<String>) hashSet);
                } else if (next instanceof l) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((l) next);
                } else {
                    next.b(hashMap);
                    next.a((HashSet<String>) hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        char c2 = 0;
        if (arrayList != null) {
            this.A = (l[]) arrayList.toArray(new l[0]);
        }
        char c3 = 1;
        if (!hashSet2.isEmpty()) {
            this.f1978y = new HashMap<>();
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                String str = (String) it3.next();
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[c3];
                    Iterator<c> it4 = this.f1976w.iterator();
                    while (it4.hasNext()) {
                        c next2 = it4.next();
                        if (!(next2.f1807f == null || (constraintAttribute2 = next2.f1807f.get(str2)) == null)) {
                            sparseArray.append(next2.f1803b, constraintAttribute2);
                        }
                    }
                    rVar = r.a(str, (SparseArray<ConstraintAttribute>) sparseArray);
                } else {
                    rVar = r.b(str);
                }
                if (rVar != null) {
                    rVar.a(str);
                    this.f1978y.put(str, rVar);
                }
                c3 = 1;
            }
            ArrayList<c> arrayList3 = this.f1976w;
            if (arrayList3 != null) {
                Iterator<c> it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    c next3 = it5.next();
                    if (next3 instanceof d) {
                        next3.a(this.f1978y);
                    }
                }
            }
            this.f1963j.a(this.f1978y, 0);
            this.f1964k.a(this.f1978y, 100);
            for (String next4 : this.f1978y.keySet()) {
                this.f1978y.get(next4).a(hashMap.containsKey(next4) ? ((Integer) hashMap.get(next4)).intValue() : 0);
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.f1977x == null) {
                this.f1977x = new HashMap<>();
            }
            Iterator it6 = hashSet.iterator();
            while (it6.hasNext()) {
                String str3 = (String) it6.next();
                if (!this.f1977x.containsKey(str3)) {
                    if (str3.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str4 = str3.split(",")[1];
                        Iterator<c> it7 = this.f1976w.iterator();
                        while (it7.hasNext()) {
                            c next5 = it7.next();
                            if (!(next5.f1807f == null || (constraintAttribute = next5.f1807f.get(str4)) == null)) {
                                sparseArray2.append(next5.f1803b, constraintAttribute);
                            }
                        }
                        sVar = s.a(str3, (SparseArray<ConstraintAttribute>) sparseArray2);
                        long j3 = j2;
                    } else {
                        sVar = s.a(str3, j2);
                    }
                    if (sVar != null) {
                        sVar.a(str3);
                        this.f1977x.put(str3, sVar);
                    }
                }
            }
            ArrayList<c> arrayList4 = this.f1976w;
            if (arrayList4 != null) {
                Iterator<c> it8 = arrayList4.iterator();
                while (it8.hasNext()) {
                    c next6 = it8.next();
                    if (next6 instanceof k) {
                        ((k) next6).c(this.f1977x);
                    }
                }
            }
            for (String next7 : this.f1977x.keySet()) {
                this.f1977x.get(next7).a(hashMap.containsKey(next7) ? ((Integer) hashMap.get(next7)).intValue() : 0);
            }
        }
        int i4 = 2;
        int size = this.f1974u.size() + 2;
        p[] pVarArr = new p[size];
        pVarArr[0] = this.f1961h;
        pVarArr[size - 1] = this.f1962i;
        if (this.f1974u.size() > 0 && this.f1960g == -1) {
            this.f1960g = 0;
        }
        Iterator<p> it9 = this.f1974u.iterator();
        int i5 = 1;
        while (it9.hasNext()) {
            pVarArr[i5] = it9.next();
            i5++;
        }
        HashSet hashSet4 = new HashSet();
        for (String next8 : this.f1962i.f1992m.keySet()) {
            if (this.f1961h.f1992m.containsKey(next8)) {
                if (!hashSet2.contains("CUSTOM," + next8)) {
                    hashSet4.add(next8);
                }
            }
        }
        String[] strArr = (String[]) hashSet4.toArray(new String[0]);
        this.f1970q = strArr;
        this.f1971r = new int[strArr.length];
        int i6 = 0;
        while (true) {
            String[] strArr2 = this.f1970q;
            if (i6 >= strArr2.length) {
                break;
            }
            String str5 = strArr2[i6];
            this.f1971r[i6] = 0;
            int i7 = 0;
            while (true) {
                if (i7 >= size) {
                    break;
                } else if (pVarArr[i7].f1992m.containsKey(str5)) {
                    int[] iArr = this.f1971r;
                    iArr[i6] = iArr[i6] + pVarArr[i7].f1992m.get(str5).b();
                    break;
                } else {
                    i7++;
                }
            }
            i6++;
        }
        boolean z2 = pVarArr[0].f1991l != c.f1802a;
        int length = 18 + this.f1970q.length;
        boolean[] zArr = new boolean[length];
        for (int i8 = 1; i8 < size; i8++) {
            pVarArr[i8].a(pVarArr[i8 - 1], zArr, this.f1970q, z2);
        }
        int i9 = 0;
        for (int i10 = 1; i10 < length; i10++) {
            if (zArr[i10]) {
                i9++;
            }
        }
        int[] iArr2 = new int[i9];
        this.f1967n = iArr2;
        this.f1968o = new double[iArr2.length];
        this.f1969p = new double[iArr2.length];
        int i11 = 0;
        for (int i12 = 1; i12 < length; i12++) {
            if (zArr[i12]) {
                this.f1967n[i11] = i12;
                i11++;
            }
        }
        int[] iArr3 = new int[2];
        iArr3[1] = this.f1967n.length;
        iArr3[0] = size;
        double[][] dArr = (double[][]) Array.newInstance(cls, iArr3);
        double[] dArr2 = new double[size];
        for (int i13 = 0; i13 < size; i13++) {
            pVarArr[i13].a(dArr[i13], this.f1967n);
            dArr2[i13] = (double) pVarArr[i13].f1983d;
        }
        int i14 = 0;
        while (true) {
            int[] iArr4 = this.f1967n;
            if (i14 >= iArr4.length) {
                break;
            }
            if (iArr4[i14] < p.f1980a.length) {
                String str6 = p.f1980a[this.f1967n[i14]] + " [";
                for (int i15 = 0; i15 < size; i15++) {
                    str6 = str6 + dArr[i15][i14];
                }
            }
            i14++;
        }
        this.f1965l = new b[(this.f1970q.length + 1)];
        int i16 = 0;
        while (true) {
            String[] strArr3 = this.f1970q;
            if (i16 >= strArr3.length) {
                break;
            }
            double[][] dArr3 = null;
            String str7 = strArr3[i16];
            double[] dArr4 = null;
            int i17 = 0;
            int i18 = 0;
            while (i17 < size) {
                if (pVarArr[i17].a(str7)) {
                    if (dArr3 == null) {
                        int[] iArr5 = new int[i4];
                        iArr5[1] = pVarArr[i17].b(str7);
                        iArr5[c2] = size;
                        dArr3 = (double[][]) Array.newInstance(cls, iArr5);
                        dArr4 = new double[size];
                    }
                    dArr4[i18] = (double) pVarArr[i17].f1983d;
                    pVarArr[i17].a(str7, dArr3[i18], 0);
                    i18++;
                }
                i17++;
                i4 = 2;
                c2 = 0;
            }
            i16++;
            this.f1965l[i16] = b.a(this.f1960g, Arrays.copyOf(dArr4, i18), (double[][]) Arrays.copyOf(dArr3, i18));
            i4 = 2;
            c2 = 0;
        }
        this.f1965l[0] = b.a(this.f1960g, dArr2, dArr);
        if (pVarArr[0].f1991l != c.f1802a) {
            int[] iArr6 = new int[size];
            double[] dArr5 = new double[size];
            int[] iArr7 = new int[2];
            iArr7[1] = 2;
            iArr7[0] = size;
            double[][] dArr6 = (double[][]) Array.newInstance(cls, iArr7);
            for (int i19 = 0; i19 < size; i19++) {
                iArr6[i19] = pVarArr[i19].f1991l;
                dArr5[i19] = (double) pVarArr[i19].f1983d;
                dArr6[i19][0] = (double) pVarArr[i19].f1985f;
                dArr6[i19][1] = (double) pVarArr[i19].f1986g;
            }
            this.f1966m = b.a(iArr6, dArr5, dArr6);
        }
        float f3 = Float.NaN;
        this.f1979z = new HashMap<>();
        if (this.f1976w != null) {
            Iterator it10 = hashSet3.iterator();
            while (it10.hasNext()) {
                String str8 = (String) it10.next();
                g b2 = g.b(str8);
                if (b2 != null) {
                    if (b2.a() && Float.isNaN(f3)) {
                        f3 = d();
                    }
                    b2.a(str8);
                    this.f1979z.put(str8, b2);
                }
            }
            Iterator<c> it11 = this.f1976w.iterator();
            while (it11.hasNext()) {
                c next9 = it11.next();
                if (next9 instanceof f) {
                    ((f) next9).c(this.f1979z);
                }
            }
            for (g c4 : this.f1979z.values()) {
                c4.c(f3);
            }
        }
    }

    public void a(View view) {
        this.f1954a = view;
        this.f1955b = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f1956c = ((ConstraintLayout.LayoutParams) layoutParams).c();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        this.f1976w.add(cVar);
    }

    /* access modifiers changed from: package-private */
    public void a(ConstraintWidget constraintWidget, androidx.constraintlayout.widget.b bVar) {
        this.f1961h.f1983d = 0.0f;
        this.f1961h.f1984e = 0.0f;
        b(this.f1961h);
        this.f1961h.a((float) constraintWidget.y(), (float) constraintWidget.z(), (float) constraintWidget.A(), (float) constraintWidget.B());
        b.a a2 = bVar.a(this.f1955b);
        this.f1961h.a(a2);
        this.f1957d = a2.f2640c.f2687f;
        this.f1963j.a(constraintWidget, bVar, this.f1955b);
    }

    /* access modifiers changed from: package-private */
    public void a(ArrayList<c> arrayList) {
        this.f1976w.addAll(arrayList);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(float[] r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            int r3 = r2 + -1
            float r3 = (float) r3
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = r4 / r3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r5 = r0.f1978y
            java.lang.String r6 = "translationX"
            r7 = 0
            if (r5 != 0) goto L_0x0016
            r5 = r7
            goto L_0x001c
        L_0x0016:
            java.lang.Object r5 = r5.get(r6)
            androidx.constraintlayout.motion.widget.r r5 = (androidx.constraintlayout.motion.widget.r) r5
        L_0x001c:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r8 = r0.f1978y
            java.lang.String r9 = "translationY"
            if (r8 != 0) goto L_0x0024
            r8 = r7
            goto L_0x002a
        L_0x0024:
            java.lang.Object r8 = r8.get(r9)
            androidx.constraintlayout.motion.widget.r r8 = (androidx.constraintlayout.motion.widget.r) r8
        L_0x002a:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.g> r10 = r0.f1979z
            if (r10 != 0) goto L_0x0030
            r6 = r7
            goto L_0x0036
        L_0x0030:
            java.lang.Object r6 = r10.get(r6)
            androidx.constraintlayout.motion.widget.g r6 = (androidx.constraintlayout.motion.widget.g) r6
        L_0x0036:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.g> r10 = r0.f1979z
            if (r10 != 0) goto L_0x003b
            goto L_0x0041
        L_0x003b:
            java.lang.Object r7 = r10.get(r9)
            androidx.constraintlayout.motion.widget.g r7 = (androidx.constraintlayout.motion.widget.g) r7
        L_0x0041:
            r10 = 0
        L_0x0042:
            if (r10 >= r2) goto L_0x0118
            float r11 = (float) r10
            float r11 = r11 * r3
            float r12 = r0.f1959f
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0065
            float r14 = r0.f1958e
            int r15 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r15 >= 0) goto L_0x0054
            r11 = 0
        L_0x0054:
            int r15 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r15 <= 0) goto L_0x0065
            r16 = r5
            double r4 = (double) r11
            r17 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r19 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r19 >= 0) goto L_0x0067
            float r11 = r11 - r14
            float r11 = r11 * r12
            goto L_0x0067
        L_0x0065:
            r16 = r5
        L_0x0067:
            double r4 = (double) r11
            androidx.constraintlayout.motion.widget.p r12 = r0.f1961h
            k.c r12 = r12.f1981b
            r14 = 2143289344(0x7fc00000, float:NaN)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p> r13 = r0.f1974u
            java.util.Iterator r13 = r13.iterator()
            r17 = 0
        L_0x0076:
            boolean r18 = r13.hasNext()
            if (r18 == 0) goto L_0x00a0
            java.lang.Object r18 = r13.next()
            r15 = r18
            androidx.constraintlayout.motion.widget.p r15 = (androidx.constraintlayout.motion.widget.p) r15
            k.c r9 = r15.f1981b
            if (r9 == 0) goto L_0x0076
            float r9 = r15.f1983d
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L_0x0096
            k.c r9 = r15.f1981b
            float r12 = r15.f1983d
            r17 = r12
            r12 = r9
            goto L_0x0076
        L_0x0096:
            boolean r9 = java.lang.Float.isNaN(r14)
            if (r9 == 0) goto L_0x0076
            float r9 = r15.f1983d
            r14 = r9
            goto L_0x0076
        L_0x00a0:
            if (r12 == 0) goto L_0x00ba
            boolean r4 = java.lang.Float.isNaN(r14)
            if (r4 == 0) goto L_0x00aa
            r14 = 1065353216(0x3f800000, float:1.0)
        L_0x00aa:
            float r4 = r11 - r17
            float r14 = r14 - r17
            float r4 = r4 / r14
            double r4 = (double) r4
            double r4 = r12.a((double) r4)
            float r4 = (float) r4
            float r4 = r4 * r14
            float r4 = r4 + r17
            double r4 = (double) r4
        L_0x00ba:
            k.b[] r9 = r0.f1965l
            r12 = 0
            r9 = r9[r12]
            double[] r13 = r0.f1968o
            r9.a((double) r4, (double[]) r13)
            k.b r9 = r0.f1966m
            if (r9 == 0) goto L_0x00d0
            double[] r13 = r0.f1968o
            int r14 = r13.length
            if (r14 <= 0) goto L_0x00d0
            r9.a((double) r4, (double[]) r13)
        L_0x00d0:
            androidx.constraintlayout.motion.widget.p r4 = r0.f1961h
            int[] r5 = r0.f1967n
            double[] r9 = r0.f1968o
            int r13 = r10 * 2
            r4.a((int[]) r5, (double[]) r9, (float[]) r1, (int) r13)
            if (r6 == 0) goto L_0x00e7
            r4 = r1[r13]
            float r5 = r6.a((float) r11)
            float r4 = r4 + r5
            r1[r13] = r4
            goto L_0x00f5
        L_0x00e7:
            if (r16 == 0) goto L_0x00f5
            r4 = r1[r13]
            r5 = r16
            float r9 = r5.a((float) r11)
            float r4 = r4 + r9
            r1[r13] = r4
            goto L_0x00f7
        L_0x00f5:
            r5 = r16
        L_0x00f7:
            if (r7 == 0) goto L_0x0105
            int r13 = r13 + 1
            r4 = r1[r13]
            float r9 = r7.a((float) r11)
            float r4 = r4 + r9
            r1[r13] = r4
            goto L_0x0112
        L_0x0105:
            if (r8 == 0) goto L_0x0112
            int r13 = r13 + 1
            r4 = r1[r13]
            float r9 = r8.a((float) r11)
            float r4 = r4 + r9
            r1[r13] = r4
        L_0x0112:
            int r10 = r10 + 1
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0042
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.n.a(float[], int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: androidx.constraintlayout.motion.widget.s} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: androidx.constraintlayout.motion.widget.s$d} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.View r23, float r24, long r25, androidx.constraintlayout.motion.widget.e r27) {
        /*
            r22 = this;
            r0 = r22
            r11 = r23
            r1 = 0
            r2 = r24
            float r12 = r0.a((float) r2, (float[]) r1)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r2 = r0.f1978y
            if (r2 == 0) goto L_0x0027
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0017:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0027
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.r r3 = (androidx.constraintlayout.motion.widget.r) r3
            r3.a((android.view.View) r11, (float) r12)
            goto L_0x0017
        L_0x0027:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s> r2 = r0.f1977x
            r13 = 0
            if (r2 == 0) goto L_0x0059
            java.util.Collection r2 = r2.values()
            java.util.Iterator r7 = r2.iterator()
            r8 = r1
            r9 = 0
        L_0x0036:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r7.next()
            androidx.constraintlayout.motion.widget.s r1 = (androidx.constraintlayout.motion.widget.s) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.widget.s.d
            if (r2 == 0) goto L_0x004a
            r8 = r1
            androidx.constraintlayout.motion.widget.s$d r8 = (androidx.constraintlayout.motion.widget.s.d) r8
            goto L_0x0036
        L_0x004a:
            r2 = r23
            r3 = r12
            r4 = r25
            r6 = r27
            boolean r1 = r1.a((android.view.View) r2, (float) r3, (long) r4, (androidx.constraintlayout.motion.widget.e) r6)
            r9 = r9 | r1
            goto L_0x0036
        L_0x0057:
            r14 = r9
            goto L_0x005b
        L_0x0059:
            r8 = r1
            r14 = 0
        L_0x005b:
            k.b[] r1 = r0.f1965l
            r15 = 1
            if (r1 == 0) goto L_0x013e
            r1 = r1[r13]
            double r9 = (double) r12
            double[] r2 = r0.f1968o
            r1.a((double) r9, (double[]) r2)
            k.b[] r1 = r0.f1965l
            r1 = r1[r13]
            double[] r2 = r0.f1969p
            r1.b((double) r9, (double[]) r2)
            k.b r1 = r0.f1966m
            if (r1 == 0) goto L_0x0084
            double[] r2 = r0.f1968o
            int r3 = r2.length
            if (r3 <= 0) goto L_0x0084
            r1.a((double) r9, (double[]) r2)
            k.b r1 = r0.f1966m
            double[] r2 = r0.f1969p
            r1.b((double) r9, (double[]) r2)
        L_0x0084:
            androidx.constraintlayout.motion.widget.p r1 = r0.f1961h
            int[] r3 = r0.f1967n
            double[] r4 = r0.f1968o
            double[] r5 = r0.f1969p
            r6 = 0
            r2 = r23
            r1.a((android.view.View) r2, (int[]) r3, (double[]) r4, (double[]) r5, (double[]) r6)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r1 = r0.f1978y
            if (r1 == 0) goto L_0x00bd
            java.util.Collection r1 = r1.values()
            java.util.Iterator r16 = r1.iterator()
        L_0x009e:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x00bd
            java.lang.Object r1 = r16.next()
            androidx.constraintlayout.motion.widget.r r1 = (androidx.constraintlayout.motion.widget.r) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.widget.r.d
            if (r2 == 0) goto L_0x009e
            androidx.constraintlayout.motion.widget.r$d r1 = (androidx.constraintlayout.motion.widget.r.d) r1
            double[] r2 = r0.f1969p
            r4 = r2[r13]
            r6 = r2[r15]
            r2 = r23
            r3 = r12
            r1.a(r2, r3, r4, r6)
            goto L_0x009e
        L_0x00bd:
            if (r8 == 0) goto L_0x00da
            double[] r1 = r0.f1969p
            r16 = r1[r13]
            r18 = r1[r15]
            r1 = r8
            r2 = r23
            r3 = r27
            r4 = r12
            r5 = r25
            r7 = r16
            r20 = r9
            r9 = r18
            boolean r1 = r1.a(r2, r3, r4, r5, r7, r9)
            r1 = r1 | r14
            r14 = r1
            goto L_0x00dc
        L_0x00da:
            r20 = r9
        L_0x00dc:
            r1 = 1
        L_0x00dd:
            k.b[] r2 = r0.f1965l
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0103
            r2 = r2[r1]
            float[] r3 = r0.f1973t
            r4 = r20
            r2.a((double) r4, (float[]) r3)
            androidx.constraintlayout.motion.widget.p r2 = r0.f1961h
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r2 = r2.f1992m
            java.lang.String[] r3 = r0.f1970q
            int r6 = r1 + -1
            r3 = r3[r6]
            java.lang.Object r2 = r2.get(r3)
            androidx.constraintlayout.widget.ConstraintAttribute r2 = (androidx.constraintlayout.widget.ConstraintAttribute) r2
            float[] r3 = r0.f1973t
            r2.a((android.view.View) r11, (float[]) r3)
            int r1 = r1 + 1
            goto L_0x00dd
        L_0x0103:
            androidx.constraintlayout.motion.widget.m r1 = r0.f1963j
            int r1 = r1.f1929a
            if (r1 != 0) goto L_0x012c
            r1 = 0
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x0116
            androidx.constraintlayout.motion.widget.m r1 = r0.f1963j
        L_0x0110:
            int r1 = r1.f1930b
            r11.setVisibility(r1)
            goto L_0x012c
        L_0x0116:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x011f
            androidx.constraintlayout.motion.widget.m r1 = r0.f1964k
            goto L_0x0110
        L_0x011f:
            androidx.constraintlayout.motion.widget.m r1 = r0.f1964k
            int r1 = r1.f1930b
            androidx.constraintlayout.motion.widget.m r2 = r0.f1963j
            int r2 = r2.f1930b
            if (r1 == r2) goto L_0x012c
            r11.setVisibility(r13)
        L_0x012c:
            androidx.constraintlayout.motion.widget.l[] r1 = r0.A
            if (r1 == 0) goto L_0x01b4
            r1 = 0
        L_0x0131:
            androidx.constraintlayout.motion.widget.l[] r2 = r0.A
            int r3 = r2.length
            if (r1 >= r3) goto L_0x01b4
            r2 = r2[r1]
            r2.a((float) r12, (android.view.View) r11)
            int r1 = r1 + 1
            goto L_0x0131
        L_0x013e:
            androidx.constraintlayout.motion.widget.p r1 = r0.f1961h
            float r1 = r1.f1985f
            androidx.constraintlayout.motion.widget.p r2 = r0.f1962i
            float r2 = r2.f1985f
            androidx.constraintlayout.motion.widget.p r3 = r0.f1961h
            float r3 = r3.f1985f
            float r2 = r2 - r3
            float r2 = r2 * r12
            float r1 = r1 + r2
            androidx.constraintlayout.motion.widget.p r2 = r0.f1961h
            float r2 = r2.f1986g
            androidx.constraintlayout.motion.widget.p r3 = r0.f1962i
            float r3 = r3.f1986g
            androidx.constraintlayout.motion.widget.p r4 = r0.f1961h
            float r4 = r4.f1986g
            float r3 = r3 - r4
            float r3 = r3 * r12
            float r2 = r2 + r3
            androidx.constraintlayout.motion.widget.p r3 = r0.f1961h
            float r3 = r3.f1987h
            androidx.constraintlayout.motion.widget.p r4 = r0.f1962i
            float r4 = r4.f1987h
            androidx.constraintlayout.motion.widget.p r5 = r0.f1961h
            float r5 = r5.f1987h
            float r4 = r4 - r5
            float r4 = r4 * r12
            float r3 = r3 + r4
            androidx.constraintlayout.motion.widget.p r4 = r0.f1961h
            float r4 = r4.f1988i
            androidx.constraintlayout.motion.widget.p r5 = r0.f1962i
            float r5 = r5.f1988i
            androidx.constraintlayout.motion.widget.p r6 = r0.f1961h
            float r6 = r6.f1988i
            float r5 = r5 - r6
            float r5 = r5 * r12
            float r4 = r4 + r5
            r5 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 + r5
            int r6 = (int) r1
            float r2 = r2 + r5
            int r5 = (int) r2
            float r1 = r1 + r3
            int r1 = (int) r1
            float r2 = r2 + r4
            int r2 = (int) r2
            int r3 = r1 - r6
            int r4 = r2 - r5
            androidx.constraintlayout.motion.widget.p r7 = r0.f1962i
            float r7 = r7.f1987h
            androidx.constraintlayout.motion.widget.p r8 = r0.f1961h
            float r8 = r8.f1987h
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x01a4
            androidx.constraintlayout.motion.widget.p r7 = r0.f1962i
            float r7 = r7.f1988i
            androidx.constraintlayout.motion.widget.p r8 = r0.f1961h
            float r8 = r8.f1988i
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 == 0) goto L_0x01b1
        L_0x01a4:
            r7 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r7)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r7)
            r11.measure(r3, r4)
        L_0x01b1:
            r11.layout(r6, r5, r1, r2)
        L_0x01b4:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.g> r1 = r0.f1979z
            if (r1 == 0) goto L_0x01e3
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x01c0:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x01e3
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.motion.widget.g r1 = (androidx.constraintlayout.motion.widget.g) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.widget.g.e
            if (r2 == 0) goto L_0x01df
            androidx.constraintlayout.motion.widget.g$e r1 = (androidx.constraintlayout.motion.widget.g.e) r1
            double[] r2 = r0.f1969p
            r4 = r2[r13]
            r6 = r2[r15]
            r2 = r23
            r3 = r12
            r1.a(r2, r3, r4, r6)
            goto L_0x01c0
        L_0x01df:
            r1.a(r11, r12)
            goto L_0x01c0
        L_0x01e3:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.n.a(android.view.View, float, long, androidx.constraintlayout.motion.widget.e):boolean");
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f1962i.f1986g;
    }

    public void b(int i2) {
        this.B = i2;
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        this.f1961h.f1983d = 0.0f;
        this.f1961h.f1984e = 0.0f;
        this.f1961h.a(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.f1963j.b(view);
    }

    /* access modifiers changed from: package-private */
    public void b(ConstraintWidget constraintWidget, androidx.constraintlayout.widget.b bVar) {
        this.f1962i.f1983d = 1.0f;
        this.f1962i.f1984e = 1.0f;
        b(this.f1962i);
        this.f1962i.a((float) constraintWidget.y(), (float) constraintWidget.z(), (float) constraintWidget.A(), (float) constraintWidget.B());
        this.f1962i.a(bVar.a(this.f1955b));
        this.f1964k.a(constraintWidget, bVar, this.f1955b);
    }

    public int c() {
        int i2 = this.f1961h.f1982c;
        Iterator<p> it2 = this.f1974u.iterator();
        while (it2.hasNext()) {
            i2 = Math.max(i2, it2.next().f1982c);
        }
        return Math.max(i2, this.f1962i.f1982c);
    }

    public String toString() {
        return " start: x: " + this.f1961h.f1985f + " y: " + this.f1961h.f1986g + " end: x: " + this.f1962i.f1985f + " y: " + this.f1962i.f1986g;
    }
}
