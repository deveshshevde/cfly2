package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    protected ConstraintAttribute f1846a;

    /* renamed from: b  reason: collision with root package name */
    public int f1847b = 0;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<o> f1848c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private k.b f1849d;

    /* renamed from: e  reason: collision with root package name */
    private c f1850e;

    /* renamed from: f  reason: collision with root package name */
    private String f1851f;

    /* renamed from: g  reason: collision with root package name */
    private int f1852g = 0;

    static class a extends g {
        a() {
        }

        public void a(View view, float f2) {
            view.setAlpha(a(f2));
        }
    }

    static class b extends g {

        /* renamed from: d  reason: collision with root package name */
        float[] f1854d = new float[1];

        b() {
        }

        public void a(View view, float f2) {
            this.f1854d[0] = a(f2);
            this.f1846a.a(view, this.f1854d);
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        k.f f1855a = new k.f();

        /* renamed from: b  reason: collision with root package name */
        float[] f1856b;

        /* renamed from: c  reason: collision with root package name */
        double[] f1857c;

        /* renamed from: d  reason: collision with root package name */
        float[] f1858d;

        /* renamed from: e  reason: collision with root package name */
        float[] f1859e;

        /* renamed from: f  reason: collision with root package name */
        float[] f1860f;

        /* renamed from: g  reason: collision with root package name */
        int f1861g;

        /* renamed from: h  reason: collision with root package name */
        k.b f1862h;

        /* renamed from: i  reason: collision with root package name */
        double[] f1863i;

        /* renamed from: j  reason: collision with root package name */
        double[] f1864j;

        /* renamed from: k  reason: collision with root package name */
        float f1865k;

        /* renamed from: l  reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f1866l = new HashMap<>();

        /* renamed from: m  reason: collision with root package name */
        private final int f1867m;

        c(int i2, int i3, int i4) {
            this.f1861g = i2;
            this.f1867m = i3;
            this.f1855a.a(i2);
            this.f1856b = new float[i4];
            this.f1857c = new double[i4];
            this.f1858d = new float[i4];
            this.f1859e = new float[i4];
            this.f1860f = new float[i4];
        }

        public double a(float f2) {
            k.b bVar = this.f1862h;
            if (bVar != null) {
                bVar.a((double) f2, this.f1863i);
            } else {
                double[] dArr = this.f1863i;
                dArr[0] = (double) this.f1859e[0];
                dArr[1] = (double) this.f1856b[0];
            }
            return this.f1863i[0] + (this.f1855a.b((double) f2) * this.f1863i[1]);
        }

        public void a(int i2, int i3, float f2, float f3, float f4) {
            double[] dArr = this.f1857c;
            double d2 = (double) i3;
            Double.isNaN(d2);
            dArr[i2] = d2 / 100.0d;
            this.f1858d[i2] = f2;
            this.f1859e[i2] = f3;
            this.f1856b[i2] = f4;
        }

        public double b(float f2) {
            k.b bVar = this.f1862h;
            if (bVar != null) {
                double d2 = (double) f2;
                bVar.b(d2, this.f1864j);
                this.f1862h.a(d2, this.f1863i);
            } else {
                double[] dArr = this.f1864j;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
            }
            double d3 = (double) f2;
            double b2 = this.f1855a.b(d3);
            double d4 = this.f1855a.d(d3);
            double[] dArr2 = this.f1864j;
            return dArr2[0] + (b2 * dArr2[1]) + (d4 * this.f1863i[1]);
        }

        public void c(float f2) {
            this.f1865k = f2;
            int length = this.f1857c.length;
            int[] iArr = new int[2];
            iArr[1] = 2;
            iArr[0] = length;
            double[][] dArr = (double[][]) Array.newInstance(double.class, iArr);
            float[] fArr = this.f1856b;
            this.f1863i = new double[(fArr.length + 1)];
            this.f1864j = new double[(fArr.length + 1)];
            if (this.f1857c[0] > fg.i.f27244a) {
                this.f1855a.a(fg.i.f27244a, this.f1858d[0]);
            }
            double[] dArr2 = this.f1857c;
            int length2 = dArr2.length - 1;
            if (dArr2[length2] < 1.0d) {
                this.f1855a.a(1.0d, this.f1858d[length2]);
            }
            for (int i2 = 0; i2 < dArr.length; i2++) {
                dArr[i2][0] = (double) this.f1859e[i2];
                int i3 = 0;
                while (true) {
                    float[] fArr2 = this.f1856b;
                    if (i3 >= fArr2.length) {
                        break;
                    }
                    dArr[i3][1] = (double) fArr2[i3];
                    i3++;
                }
                this.f1855a.a(this.f1857c[i2], this.f1858d[i2]);
            }
            this.f1855a.a();
            double[] dArr3 = this.f1857c;
            this.f1862h = dArr3.length > 1 ? k.b.a(0, dArr3, dArr) : null;
        }
    }

    static class d extends g {
        d() {
        }

        public void a(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f2));
            }
        }
    }

    static class e extends g {
        e() {
        }

        public void a(View view, float f2) {
        }

        public void a(View view, float f2, double d2, double d3) {
            view.setRotation(a(f2) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
        }
    }

    static class f extends g {

        /* renamed from: d  reason: collision with root package name */
        boolean f1868d = false;

        f() {
        }

        public void a(View view, float f2) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2));
            } else if (!this.f1868d) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f1868d = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(a(f2))});
                    } catch (IllegalAccessException | InvocationTargetException e2) {
                        Log.e("KeyCycleOscillator", "unable to setProgress", e2);
                    }
                }
            }
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.g$g  reason: collision with other inner class name */
    static class C0020g extends g {
        C0020g() {
        }

        public void a(View view, float f2) {
            view.setRotation(a(f2));
        }
    }

    static class h extends g {
        h() {
        }

        public void a(View view, float f2) {
            view.setRotationX(a(f2));
        }
    }

    static class i extends g {
        i() {
        }

        public void a(View view, float f2) {
            view.setRotationY(a(f2));
        }
    }

    static class j extends g {
        j() {
        }

        public void a(View view, float f2) {
            view.setScaleX(a(f2));
        }
    }

    static class k extends g {
        k() {
        }

        public void a(View view, float f2) {
            view.setScaleY(a(f2));
        }
    }

    static class l extends g {
        l() {
        }

        public void a(View view, float f2) {
            view.setTranslationX(a(f2));
        }
    }

    static class m extends g {
        m() {
        }

        public void a(View view, float f2) {
            view.setTranslationY(a(f2));
        }
    }

    static class n extends g {
        n() {
        }

        public void a(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f2));
            }
        }
    }

    static class o {

        /* renamed from: a  reason: collision with root package name */
        int f1869a;

        /* renamed from: b  reason: collision with root package name */
        float f1870b;

        /* renamed from: c  reason: collision with root package name */
        float f1871c;

        /* renamed from: d  reason: collision with root package name */
        float f1872d;

        public o(int i2, float f2, float f3, float f4) {
            this.f1869a = i2;
            this.f1870b = f4;
            this.f1871c = f3;
            this.f1872d = f2;
        }
    }

    static g b(String str) {
        if (str.startsWith("CUSTOM")) {
            return new b();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = 9;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 10;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 12;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = 13;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new h();
            case 1:
                return new i();
            case 2:
                return new l();
            case 3:
                return new m();
            case 4:
                return new n();
            case 5:
                return new f();
            case 6:
                return new j();
            case 7:
                return new k();
            case 8:
                return new a();
            case 9:
                return new C0020g();
            case 10:
                return new d();
            case 11:
                return new e();
            case 12:
                return new a();
            case 13:
                return new a();
            default:
                return null;
        }
    }

    public float a(float f2) {
        return (float) this.f1850e.a(f2);
    }

    public void a(int i2, int i3, int i4, float f2, float f3, float f4) {
        this.f1848c.add(new o(i2, f2, f3, f4));
        if (i4 != -1) {
            this.f1847b = i4;
        }
        this.f1852g = i3;
    }

    public void a(int i2, int i3, int i4, float f2, float f3, float f4, ConstraintAttribute constraintAttribute) {
        this.f1848c.add(new o(i2, f2, f3, f4));
        if (i4 != -1) {
            this.f1847b = i4;
        }
        this.f1852g = i3;
        this.f1846a = constraintAttribute;
    }

    public abstract void a(View view, float f2);

    public void a(String str) {
        this.f1851f = str;
    }

    public boolean a() {
        return this.f1847b == 1;
    }

    public float b(float f2) {
        return (float) this.f1850e.b(f2);
    }

    public void c(float f2) {
        int size = this.f1848c.size();
        if (size != 0) {
            Collections.sort(this.f1848c, new Comparator<o>() {
                /* renamed from: a */
                public int compare(o oVar, o oVar2) {
                    return Integer.compare(oVar.f1869a, oVar2.f1869a);
                }
            });
            double[] dArr = new double[size];
            int[] iArr = new int[2];
            iArr[1] = 2;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            this.f1850e = new c(this.f1852g, this.f1847b, size);
            Iterator<o> it2 = this.f1848c.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                o next = it2.next();
                double d2 = (double) next.f1872d;
                Double.isNaN(d2);
                dArr[i2] = d2 * 0.01d;
                dArr2[i2][0] = (double) next.f1870b;
                dArr2[i2][1] = (double) next.f1871c;
                this.f1850e.a(i2, next.f1869a, next.f1872d, next.f1871c, next.f1870b);
                i2++;
            }
            this.f1850e.c(f2);
            this.f1849d = k.b.a(0, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.f1851f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<o> it2 = this.f1848c.iterator();
        while (it2.hasNext()) {
            o next = it2.next();
            str = str + "[" + next.f1869a + " , " + decimalFormat.format((double) next.f1870b) + "] ";
        }
        return str;
    }
}
