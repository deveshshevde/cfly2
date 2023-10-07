package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

public abstract class s {

    /* renamed from: k  reason: collision with root package name */
    private static float f2048k = 6.2831855f;

    /* renamed from: a  reason: collision with root package name */
    protected k.b f2049a;

    /* renamed from: b  reason: collision with root package name */
    protected int f2050b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int[] f2051c = new int[10];

    /* renamed from: d  reason: collision with root package name */
    protected float[][] f2052d = ((float[][]) Array.newInstance(float.class, new int[]{10, 3}));

    /* renamed from: e  reason: collision with root package name */
    protected boolean f2053e = false;

    /* renamed from: f  reason: collision with root package name */
    long f2054f;

    /* renamed from: g  reason: collision with root package name */
    float f2055g = Float.NaN;

    /* renamed from: h  reason: collision with root package name */
    private int f2056h;

    /* renamed from: i  reason: collision with root package name */
    private String f2057i;

    /* renamed from: j  reason: collision with root package name */
    private float[] f2058j = new float[3];

    static class a extends s {
        a() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            view.setAlpha(a(f2, j2, view, eVar));
            return this.f2053e;
        }
    }

    static class b extends s {

        /* renamed from: h  reason: collision with root package name */
        String f2059h;

        /* renamed from: i  reason: collision with root package name */
        SparseArray<ConstraintAttribute> f2060i;

        /* renamed from: j  reason: collision with root package name */
        SparseArray<float[]> f2061j = new SparseArray<>();

        /* renamed from: k  reason: collision with root package name */
        float[] f2062k;

        /* renamed from: l  reason: collision with root package name */
        float[] f2063l;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f2059h = str.split(",")[1];
            this.f2060i = sparseArray;
        }

        public void a(int i2) {
            int size = this.f2060i.size();
            int b2 = this.f2060i.valueAt(0).b();
            double[] dArr = new double[size];
            int i3 = b2 + 2;
            this.f2062k = new float[i3];
            this.f2063l = new float[b2];
            int[] iArr = new int[2];
            iArr[1] = i3;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = this.f2060i.keyAt(i4);
                float[] valueAt = this.f2061j.valueAt(i4);
                double d2 = (double) keyAt;
                Double.isNaN(d2);
                dArr[i4] = d2 * 0.01d;
                this.f2060i.valueAt(i4).a(this.f2062k);
                int i5 = 0;
                while (true) {
                    float[] fArr = this.f2062k;
                    if (i5 >= fArr.length) {
                        break;
                    }
                    dArr2[i4][i5] = (double) fArr[i5];
                    i5++;
                }
                dArr2[i4][b2] = (double) valueAt[0];
                dArr2[i4][b2 + 1] = (double) valueAt[1];
            }
            this.f2049a = k.b.a(i2, dArr, dArr2);
        }

        public void a(int i2, float f2, float f3, int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void a(int i2, ConstraintAttribute constraintAttribute, float f2, int i3, float f3) {
            this.f2060i.append(i2, constraintAttribute);
            this.f2061j.append(i2, new float[]{f2, f3});
            this.f2050b = Math.max(this.f2050b, i3);
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            View view2 = view;
            long j3 = j2;
            this.f2049a.a((double) f2, this.f2062k);
            float[] fArr = this.f2062k;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j4 = j3 - this.f2054f;
            if (Float.isNaN(this.f2055g)) {
                this.f2055g = eVar.a(view2, this.f2059h, 0);
                if (Float.isNaN(this.f2055g)) {
                    this.f2055g = 0.0f;
                }
            }
            double d2 = (double) this.f2055g;
            double d3 = (double) j4;
            Double.isNaN(d3);
            double d4 = (double) f3;
            Double.isNaN(d4);
            Double.isNaN(d2);
            this.f2055g = (float) ((d2 + ((d3 * 1.0E-9d) * d4)) % 1.0d);
            this.f2054f = j3;
            float a2 = a(this.f2055g);
            this.f2053e = false;
            for (int i2 = 0; i2 < this.f2063l.length; i2++) {
                this.f2053e |= ((double) this.f2062k[i2]) != fg.i.f27244a;
                this.f2063l[i2] = (this.f2062k[i2] * a2) + f4;
            }
            this.f2060i.valueAt(0).a(view2, this.f2063l);
            if (f3 != 0.0f) {
                this.f2053e = true;
            }
            return this.f2053e;
        }
    }

    static class c extends s {
        c() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f2, j2, view, eVar));
            }
            return this.f2053e;
        }
    }

    static class d extends s {
        d() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            return this.f2053e;
        }

        public boolean a(View view, e eVar, float f2, long j2, double d2, double d3) {
            view.setRotation(a(f2, j2, view, eVar) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
            return this.f2053e;
        }
    }

    static class e extends s {

        /* renamed from: h  reason: collision with root package name */
        boolean f2064h = false;

        e() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            View view2 = view;
            if (view2 instanceof MotionLayout) {
                ((MotionLayout) view2).setProgress(a(f2, j2, view, eVar));
            } else if (this.f2064h) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f2064h = true;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, new Object[]{Float.valueOf(a(f2, j2, view, eVar))});
                    } catch (IllegalAccessException | InvocationTargetException e2) {
                        Log.e("SplineSet", "unable to setProgress", e2);
                    }
                }
            }
            return this.f2053e;
        }
    }

    static class f extends s {
        f() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            view.setRotation(a(f2, j2, view, eVar));
            return this.f2053e;
        }
    }

    static class g extends s {
        g() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            view.setRotationX(a(f2, j2, view, eVar));
            return this.f2053e;
        }
    }

    static class h extends s {
        h() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            view.setRotationY(a(f2, j2, view, eVar));
            return this.f2053e;
        }
    }

    static class i extends s {
        i() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            view.setScaleX(a(f2, j2, view, eVar));
            return this.f2053e;
        }
    }

    static class j extends s {
        j() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            view.setScaleY(a(f2, j2, view, eVar));
            return this.f2053e;
        }
    }

    private static class k {
        static void a(int[] iArr, float[][] fArr, int i2, int i3) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i3;
            iArr2[1] = i2;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = i4 - 1;
                int i6 = iArr2[i5];
                i4 = i5 - 1;
                int i7 = iArr2[i4];
                if (i6 < i7) {
                    int b2 = b(iArr, fArr, i6, i7);
                    int i8 = i4 + 1;
                    iArr2[i4] = b2 - 1;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    int i10 = i9 + 1;
                    iArr2[i9] = i7;
                    i4 = i10 + 1;
                    iArr2[i10] = b2 + 1;
                }
            }
        }

        private static int b(int[] iArr, float[][] fArr, int i2, int i3) {
            int i4 = iArr[i3];
            int i5 = i2;
            while (i2 < i3) {
                if (iArr[i2] <= i4) {
                    c(iArr, fArr, i5, i2);
                    i5++;
                }
                i2++;
            }
            c(iArr, fArr, i5, i3);
            return i5;
        }

        private static void c(int[] iArr, float[][] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float[] fArr2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = fArr2;
        }
    }

    static class l extends s {
        l() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            view.setTranslationX(a(f2, j2, view, eVar));
            return this.f2053e;
        }
    }

    static class m extends s {
        m() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            view.setTranslationY(a(f2, j2, view, eVar));
            return this.f2053e;
        }
    }

    static class n extends s {
        n() {
        }

        public boolean a(View view, float f2, long j2, e eVar) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f2, j2, view, eVar));
            }
            return this.f2053e;
        }
    }

    static s a(String str, long j2) {
        s sVar;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = 8;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 9;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 10;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 11;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                sVar = new g();
                break;
            case 1:
                sVar = new h();
                break;
            case 2:
                sVar = new l();
                break;
            case 3:
                sVar = new m();
                break;
            case 4:
                sVar = new n();
                break;
            case 5:
                sVar = new e();
                break;
            case 6:
                sVar = new i();
                break;
            case 7:
                sVar = new j();
                break;
            case 8:
                sVar = new f();
                break;
            case 9:
                sVar = new c();
                break;
            case 10:
                sVar = new d();
                break;
            case 11:
                sVar = new a();
                break;
            default:
                return null;
        }
        sVar.a(j2);
        return sVar;
    }

    static s a(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    /* access modifiers changed from: protected */
    public float a(float f2) {
        float abs;
        switch (this.f2050b) {
            case 1:
                return Math.signum(f2 * f2048k);
            case 2:
                abs = Math.abs(f2);
                break;
            case 3:
                return (((f2 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f2 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos((double) (f2 * f2048k));
            case 6:
                float abs2 = 1.0f - Math.abs(((f2 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin((double) (f2 * f2048k));
        }
        return 1.0f - abs;
    }

    public float a(float f2, long j2, View view, e eVar) {
        long j3 = j2;
        View view2 = view;
        e eVar2 = eVar;
        this.f2049a.a((double) f2, this.f2058j);
        float[] fArr = this.f2058j;
        boolean z2 = true;
        float f3 = fArr[1];
        if (f3 == 0.0f) {
            this.f2053e = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f2055g)) {
            float a2 = eVar2.a(view2, this.f2057i, 0);
            this.f2055g = a2;
            if (Float.isNaN(a2)) {
                this.f2055g = 0.0f;
            }
        }
        double d2 = (double) this.f2055g;
        double d3 = (double) (j3 - this.f2054f);
        Double.isNaN(d3);
        double d4 = (double) f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        float f4 = (float) ((d2 + ((d3 * 1.0E-9d) * d4)) % 1.0d);
        this.f2055g = f4;
        eVar2.a(view2, this.f2057i, 0, f4);
        this.f2054f = j3;
        float f5 = this.f2058j[0];
        float a3 = (a(this.f2055g) * f5) + this.f2058j[2];
        if (f5 == 0.0f && f3 == 0.0f) {
            z2 = false;
        }
        this.f2053e = z2;
        return a3;
    }

    public void a(int i2) {
        int i3 = this.f2056h;
        if (i3 == 0) {
            Log.e("SplineSet", "Error no points added to " + this.f2057i);
            return;
        }
        k.a(this.f2051c, this.f2052d, 0, i3 - 1);
        int i4 = 1;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f2051c;
            if (i4 >= iArr.length) {
                break;
            }
            if (iArr[i4] != iArr[i4 - 1]) {
                i5++;
            }
            i4++;
        }
        if (i5 == 0) {
            i5 = 1;
        }
        double[] dArr = new double[i5];
        int[] iArr2 = new int[2];
        iArr2[1] = 3;
        iArr2[0] = i5;
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr2);
        int i6 = 0;
        for (int i7 = 0; i7 < this.f2056h; i7++) {
            if (i7 > 0) {
                int[] iArr3 = this.f2051c;
                if (iArr3[i7] == iArr3[i7 - 1]) {
                }
            }
            double d2 = (double) this.f2051c[i7];
            Double.isNaN(d2);
            dArr[i6] = d2 * 0.01d;
            double[] dArr3 = dArr2[i6];
            float[][] fArr = this.f2052d;
            dArr3[0] = (double) fArr[i7][0];
            dArr2[i6][1] = (double) fArr[i7][1];
            dArr2[i6][2] = (double) fArr[i7][2];
            i6++;
        }
        this.f2049a = k.b.a(i2, dArr, dArr2);
    }

    public void a(int i2, float f2, float f3, int i3, float f4) {
        int[] iArr = this.f2051c;
        int i4 = this.f2056h;
        iArr[i4] = i2;
        float[][] fArr = this.f2052d;
        fArr[i4][0] = f2;
        fArr[i4][1] = f3;
        fArr[i4][2] = f4;
        this.f2050b = Math.max(this.f2050b, i3);
        this.f2056h++;
    }

    /* access modifiers changed from: protected */
    public void a(long j2) {
        this.f2054f = j2;
    }

    public void a(String str) {
        this.f2057i = str;
    }

    public abstract boolean a(View view, float f2, long j2, e eVar);

    public String toString() {
        String str = this.f2057i;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.f2056h; i2++) {
            str = str + "[" + this.f2051c[i2] + " , " + decimalFormat.format(this.f2052d[i2]) + "] ";
        }
        return str;
    }
}
