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
import java.util.Arrays;

public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    protected k.b f2039a;

    /* renamed from: b  reason: collision with root package name */
    protected int[] f2040b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    protected float[] f2041c = new float[10];

    /* renamed from: d  reason: collision with root package name */
    private int f2042d;

    /* renamed from: e  reason: collision with root package name */
    private String f2043e;

    static class a extends r {
        a() {
        }

        public void a(View view, float f2) {
            view.setAlpha(a(f2));
        }
    }

    static class b extends r {

        /* renamed from: d  reason: collision with root package name */
        String f2044d;

        /* renamed from: e  reason: collision with root package name */
        SparseArray<ConstraintAttribute> f2045e;

        /* renamed from: f  reason: collision with root package name */
        float[] f2046f;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f2044d = str.split(",")[1];
            this.f2045e = sparseArray;
        }

        public void a(int i2) {
            int size = this.f2045e.size();
            int b2 = this.f2045e.valueAt(0).b();
            double[] dArr = new double[size];
            this.f2046f = new float[b2];
            int[] iArr = new int[2];
            iArr[1] = b2;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            for (int i3 = 0; i3 < size; i3++) {
                double keyAt = (double) this.f2045e.keyAt(i3);
                Double.isNaN(keyAt);
                dArr[i3] = keyAt * 0.01d;
                this.f2045e.valueAt(i3).a(this.f2046f);
                int i4 = 0;
                while (true) {
                    float[] fArr = this.f2046f;
                    if (i4 >= fArr.length) {
                        break;
                    }
                    dArr2[i3][i4] = (double) fArr[i4];
                    i4++;
                }
            }
            this.f2039a = k.b.a(i2, dArr, dArr2);
        }

        public void a(int i2, float f2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void a(int i2, ConstraintAttribute constraintAttribute) {
            this.f2045e.append(i2, constraintAttribute);
        }

        public void a(View view, float f2) {
            this.f2039a.a((double) f2, this.f2046f);
            this.f2045e.valueAt(0).a(view, this.f2046f);
        }
    }

    static class c extends r {
        c() {
        }

        public void a(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f2));
            }
        }
    }

    static class d extends r {
        d() {
        }

        public void a(View view, float f2) {
        }

        public void a(View view, float f2, double d2, double d3) {
            view.setRotation(a(f2) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
        }
    }

    static class e extends r {
        e() {
        }

        public void a(View view, float f2) {
            view.setPivotX(a(f2));
        }
    }

    static class f extends r {
        f() {
        }

        public void a(View view, float f2) {
            view.setPivotY(a(f2));
        }
    }

    static class g extends r {

        /* renamed from: d  reason: collision with root package name */
        boolean f2047d = false;

        g() {
        }

        public void a(View view, float f2) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2));
            } else if (!this.f2047d) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f2047d = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(a(f2))});
                    } catch (IllegalAccessException | InvocationTargetException e2) {
                        Log.e("SplineSet", "unable to setProgress", e2);
                    }
                }
            }
        }
    }

    static class h extends r {
        h() {
        }

        public void a(View view, float f2) {
            view.setRotation(a(f2));
        }
    }

    static class i extends r {
        i() {
        }

        public void a(View view, float f2) {
            view.setRotationX(a(f2));
        }
    }

    static class j extends r {
        j() {
        }

        public void a(View view, float f2) {
            view.setRotationY(a(f2));
        }
    }

    static class k extends r {
        k() {
        }

        public void a(View view, float f2) {
            view.setScaleX(a(f2));
        }
    }

    static class l extends r {
        l() {
        }

        public void a(View view, float f2) {
            view.setScaleY(a(f2));
        }
    }

    private static class m {
        static void a(int[] iArr, float[] fArr, int i2, int i3) {
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

        private static int b(int[] iArr, float[] fArr, int i2, int i3) {
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

        private static void c(int[] iArr, float[] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
        }
    }

    static class n extends r {
        n() {
        }

        public void a(View view, float f2) {
            view.setTranslationX(a(f2));
        }
    }

    static class o extends r {
        o() {
        }

        public void a(View view, float f2) {
            view.setTranslationY(a(f2));
        }
    }

    static class p extends r {
        p() {
        }

        public void a(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f2));
            }
        }
    }

    static r a(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    static r b(String str) {
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
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c2 = 8;
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c2 = 9;
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c2 = 10;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 12;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 13;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = 15;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new i();
            case 1:
                return new j();
            case 2:
                return new n();
            case 3:
                return new o();
            case 4:
                return new p();
            case 5:
                return new g();
            case 6:
                return new k();
            case 7:
                return new l();
            case 8:
                return new a();
            case 9:
                return new e();
            case 10:
                return new f();
            case 11:
                return new h();
            case 12:
                return new c();
            case 13:
                return new d();
            case 14:
                return new a();
            case 15:
                return new a();
            default:
                return null;
        }
    }

    public float a(float f2) {
        return (float) this.f2039a.a((double) f2, 0);
    }

    public void a(int i2) {
        int i3 = this.f2042d;
        if (i3 != 0) {
            m.a(this.f2040b, this.f2041c, 0, i3 - 1);
            int i4 = 1;
            for (int i5 = 1; i5 < this.f2042d; i5++) {
                int[] iArr = this.f2040b;
                if (iArr[i5 - 1] != iArr[i5]) {
                    i4++;
                }
            }
            double[] dArr = new double[i4];
            int[] iArr2 = new int[2];
            iArr2[1] = 1;
            iArr2[0] = i4;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr2);
            int i6 = 0;
            for (int i7 = 0; i7 < this.f2042d; i7++) {
                if (i7 > 0) {
                    int[] iArr3 = this.f2040b;
                    if (iArr3[i7] == iArr3[i7 - 1]) {
                    }
                }
                double d2 = (double) this.f2040b[i7];
                Double.isNaN(d2);
                dArr[i6] = d2 * 0.01d;
                dArr2[i6][0] = (double) this.f2041c[i7];
                i6++;
            }
            this.f2039a = k.b.a(i2, dArr, dArr2);
        }
    }

    public void a(int i2, float f2) {
        int[] iArr = this.f2040b;
        if (iArr.length < this.f2042d + 1) {
            this.f2040b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f2041c;
            this.f2041c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f2040b;
        int i3 = this.f2042d;
        iArr2[i3] = i2;
        this.f2041c[i3] = f2;
        this.f2042d = i3 + 1;
    }

    public abstract void a(View view, float f2);

    public void a(String str) {
        this.f2043e = str;
    }

    public float b(float f2) {
        return (float) this.f2039a.b((double) f2, 0);
    }

    public String toString() {
        String str = this.f2043e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.f2042d; i2++) {
            str = str + "[" + this.f2040b[i2] + " , " + decimalFormat.format((double) this.f2041c[i2]) + "] ";
        }
        return str;
    }
}
