package k;

import fg.i;
import java.util.Arrays;

class a extends b {

    /* renamed from: a  reason: collision with root package name */
    C0206a[] f29886a;

    /* renamed from: b  reason: collision with root package name */
    private final double[] f29887b;

    /* renamed from: k.a$a  reason: collision with other inner class name */
    private static class C0206a {

        /* renamed from: s  reason: collision with root package name */
        private static double[] f29888s = new double[91];

        /* renamed from: a  reason: collision with root package name */
        double[] f29889a;

        /* renamed from: b  reason: collision with root package name */
        double f29890b;

        /* renamed from: c  reason: collision with root package name */
        double f29891c;

        /* renamed from: d  reason: collision with root package name */
        double f29892d;

        /* renamed from: e  reason: collision with root package name */
        double f29893e;

        /* renamed from: f  reason: collision with root package name */
        double f29894f;

        /* renamed from: g  reason: collision with root package name */
        double f29895g;

        /* renamed from: h  reason: collision with root package name */
        double f29896h;

        /* renamed from: i  reason: collision with root package name */
        double f29897i;

        /* renamed from: j  reason: collision with root package name */
        double f29898j;

        /* renamed from: k  reason: collision with root package name */
        double f29899k;

        /* renamed from: l  reason: collision with root package name */
        double f29900l;

        /* renamed from: m  reason: collision with root package name */
        double f29901m;

        /* renamed from: n  reason: collision with root package name */
        double f29902n;

        /* renamed from: o  reason: collision with root package name */
        double f29903o;

        /* renamed from: p  reason: collision with root package name */
        double f29904p;

        /* renamed from: q  reason: collision with root package name */
        boolean f29905q;

        /* renamed from: r  reason: collision with root package name */
        boolean f29906r = false;

        C0206a(int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
            int i3 = i2;
            double d8 = d2;
            double d9 = d3;
            double d10 = d4;
            double d11 = d5;
            double d12 = d6;
            double d13 = d7;
            boolean z2 = false;
            int i4 = 1;
            this.f29905q = i3 == 1 ? true : z2;
            this.f29891c = d8;
            this.f29892d = d9;
            this.f29897i = 1.0d / (d9 - d8);
            if (3 == i3) {
                this.f29906r = true;
            }
            double d14 = d12 - d10;
            double d15 = d13 - d11;
            if (this.f29906r || Math.abs(d14) < 0.001d || Math.abs(d15) < 0.001d) {
                this.f29906r = true;
                this.f29893e = d10;
                this.f29894f = d12;
                this.f29895g = d11;
                this.f29896h = d7;
                double hypot = Math.hypot(d15, d14);
                this.f29890b = hypot;
                this.f29902n = hypot * this.f29897i;
                double d16 = this.f29892d;
                double d17 = this.f29891c;
                this.f29900l = d14 / (d16 - d17);
                this.f29901m = d15 / (d16 - d17);
                return;
            }
            this.f29889a = new double[101];
            boolean z3 = this.f29905q;
            double d18 = (double) (z3 ? -1 : 1);
            Double.isNaN(d18);
            this.f29898j = d14 * d18;
            double d19 = (double) (!z3 ? -1 : i4);
            Double.isNaN(d19);
            this.f29899k = d15 * d19;
            this.f29900l = z3 ? d12 : d10;
            this.f29901m = z3 ? d11 : d7;
            a(d4, d5, d6, d7);
            this.f29902n = this.f29890b * this.f29897i;
        }

        private void a(double d2, double d3, double d4, double d5) {
            double d6;
            double d7 = d4 - d2;
            double d8 = d3 - d5;
            int i2 = 0;
            double d9 = i.f27244a;
            double d10 = i.f27244a;
            double d11 = i.f27244a;
            while (true) {
                double[] dArr = f29888s;
                if (i2 >= dArr.length) {
                    break;
                }
                double d12 = (double) i2;
                Double.isNaN(d12);
                double d13 = d9;
                double length = (double) (dArr.length - 1);
                Double.isNaN(length);
                double radians = Math.toRadians((d12 * 90.0d) / length);
                double sin = Math.sin(radians) * d7;
                double cos = Math.cos(radians) * d8;
                if (i2 > 0) {
                    d6 = Math.hypot(sin - d10, cos - d11) + d13;
                    f29888s[i2] = d6;
                } else {
                    d6 = d13;
                }
                i2++;
                d11 = cos;
                double d14 = sin;
                d9 = d6;
                d10 = d14;
            }
            double d15 = d9;
            this.f29890b = d15;
            int i3 = 0;
            while (true) {
                double[] dArr2 = f29888s;
                if (i3 >= dArr2.length) {
                    break;
                }
                dArr2[i3] = dArr2[i3] / d15;
                i3++;
            }
            int i4 = 0;
            while (true) {
                double[] dArr3 = this.f29889a;
                if (i4 < dArr3.length) {
                    double d16 = (double) i4;
                    double length2 = (double) (dArr3.length - 1);
                    Double.isNaN(d16);
                    Double.isNaN(length2);
                    double d17 = d16 / length2;
                    int binarySearch = Arrays.binarySearch(f29888s, d17);
                    if (binarySearch >= 0) {
                        this.f29889a[i4] = (double) (binarySearch / (f29888s.length - 1));
                    } else if (binarySearch == -1) {
                        this.f29889a[i4] = 0.0d;
                    } else {
                        int i5 = -binarySearch;
                        int i6 = i5 - 2;
                        double d18 = (double) i6;
                        double[] dArr4 = f29888s;
                        Double.isNaN(d18);
                        double length3 = (double) (dArr4.length - 1);
                        Double.isNaN(length3);
                        this.f29889a[i4] = (d18 + ((d17 - dArr4[i6]) / (dArr4[i5 - 1] - dArr4[i6]))) / length3;
                    }
                    i4++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public double a() {
            return this.f29900l + (this.f29898j * this.f29903o);
        }

        /* access modifiers changed from: package-private */
        public void a(double d2) {
            double f2 = f((this.f29905q ? this.f29892d - d2 : d2 - this.f29891c) * this.f29897i) * 1.5707963267948966d;
            this.f29903o = Math.sin(f2);
            this.f29904p = Math.cos(f2);
        }

        /* access modifiers changed from: package-private */
        public double b() {
            return this.f29901m + (this.f29899k * this.f29904p);
        }

        public double b(double d2) {
            double d3 = (d2 - this.f29891c) * this.f29897i;
            double d4 = this.f29893e;
            return d4 + (d3 * (this.f29894f - d4));
        }

        /* access modifiers changed from: package-private */
        public double c() {
            double d2 = this.f29898j * this.f29904p;
            double hypot = this.f29902n / Math.hypot(d2, (-this.f29899k) * this.f29903o);
            if (this.f29905q) {
                d2 = -d2;
            }
            return d2 * hypot;
        }

        public double c(double d2) {
            double d3 = (d2 - this.f29891c) * this.f29897i;
            double d4 = this.f29895g;
            return d4 + (d3 * (this.f29896h - d4));
        }

        /* access modifiers changed from: package-private */
        public double d() {
            double d2 = this.f29898j * this.f29904p;
            double d3 = (-this.f29899k) * this.f29903o;
            double hypot = this.f29902n / Math.hypot(d2, d3);
            return this.f29905q ? (-d3) * hypot : d3 * hypot;
        }

        public double d(double d2) {
            return this.f29900l;
        }

        public double e(double d2) {
            return this.f29901m;
        }

        /* access modifiers changed from: package-private */
        public double f(double d2) {
            if (d2 <= i.f27244a) {
                return i.f27244a;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f29889a;
            double length = (double) (dArr.length - 1);
            Double.isNaN(length);
            double d3 = d2 * length;
            int i2 = (int) d3;
            double d4 = (double) i2;
            Double.isNaN(d4);
            return dArr[i2] + ((d3 - d4) * (dArr[i2 + 1] - dArr[i2]));
        }
    }

    public a(int[] iArr, double[] dArr, double[][] dArr2) {
        double[] dArr3 = dArr;
        this.f29887b = dArr3;
        this.f29886a = new C0206a[(dArr3.length - 1)];
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            C0206a[] aVarArr = this.f29886a;
            if (i2 < aVarArr.length) {
                int i5 = iArr[i2];
                if (i5 == 0) {
                    i4 = 3;
                } else if (i5 == 1) {
                    i3 = 1;
                    i4 = 1;
                } else if (i5 == 2) {
                    i3 = 2;
                    i4 = 2;
                } else if (i5 == 3) {
                    i3 = i3 == 1 ? 2 : 1;
                    i4 = i3;
                }
                int i6 = i2 + 1;
                aVarArr[i2] = new C0206a(i4, dArr3[i2], dArr3[i6], dArr2[i2][0], dArr2[i2][1], dArr2[i6][0], dArr2[i6][1]);
                i2 = i6;
            } else {
                return;
            }
        }
    }

    public double a(double d2, int i2) {
        int i3 = 0;
        if (d2 < this.f29886a[0].f29891c) {
            d2 = this.f29886a[0].f29891c;
        } else {
            C0206a[] aVarArr = this.f29886a;
            if (d2 > aVarArr[aVarArr.length - 1].f29892d) {
                C0206a[] aVarArr2 = this.f29886a;
                d2 = aVarArr2[aVarArr2.length - 1].f29892d;
            }
        }
        while (true) {
            C0206a[] aVarArr3 = this.f29886a;
            if (i3 >= aVarArr3.length) {
                return Double.NaN;
            }
            if (d2 > aVarArr3[i3].f29892d) {
                i3++;
            } else if (this.f29886a[i3].f29906r) {
                return i2 == 0 ? this.f29886a[i3].b(d2) : this.f29886a[i3].c(d2);
            } else {
                this.f29886a[i3].a(d2);
                C0206a[] aVarArr4 = this.f29886a;
                return i2 == 0 ? aVarArr4[i3].a() : aVarArr4[i3].b();
            }
        }
    }

    public void a(double d2, double[] dArr) {
        if (d2 < this.f29886a[0].f29891c) {
            d2 = this.f29886a[0].f29891c;
        }
        C0206a[] aVarArr = this.f29886a;
        if (d2 > aVarArr[aVarArr.length - 1].f29892d) {
            C0206a[] aVarArr2 = this.f29886a;
            d2 = aVarArr2[aVarArr2.length - 1].f29892d;
        }
        int i2 = 0;
        while (true) {
            C0206a[] aVarArr3 = this.f29886a;
            if (i2 >= aVarArr3.length) {
                return;
            }
            if (d2 > aVarArr3[i2].f29892d) {
                i2++;
            } else if (this.f29886a[i2].f29906r) {
                dArr[0] = this.f29886a[i2].b(d2);
                dArr[1] = this.f29886a[i2].c(d2);
                return;
            } else {
                this.f29886a[i2].a(d2);
                dArr[0] = this.f29886a[i2].a();
                dArr[1] = this.f29886a[i2].b();
                return;
            }
        }
    }

    public void a(double d2, float[] fArr) {
        if (d2 < this.f29886a[0].f29891c) {
            d2 = this.f29886a[0].f29891c;
        } else {
            C0206a[] aVarArr = this.f29886a;
            if (d2 > aVarArr[aVarArr.length - 1].f29892d) {
                C0206a[] aVarArr2 = this.f29886a;
                d2 = aVarArr2[aVarArr2.length - 1].f29892d;
            }
        }
        int i2 = 0;
        while (true) {
            C0206a[] aVarArr3 = this.f29886a;
            if (i2 >= aVarArr3.length) {
                return;
            }
            if (d2 > aVarArr3[i2].f29892d) {
                i2++;
            } else if (this.f29886a[i2].f29906r) {
                fArr[0] = (float) this.f29886a[i2].b(d2);
                fArr[1] = (float) this.f29886a[i2].c(d2);
                return;
            } else {
                this.f29886a[i2].a(d2);
                fArr[0] = (float) this.f29886a[i2].a();
                fArr[1] = (float) this.f29886a[i2].b();
                return;
            }
        }
    }

    public double[] a() {
        return this.f29887b;
    }

    public double b(double d2, int i2) {
        int i3 = 0;
        if (d2 < this.f29886a[0].f29891c) {
            d2 = this.f29886a[0].f29891c;
        }
        C0206a[] aVarArr = this.f29886a;
        if (d2 > aVarArr[aVarArr.length - 1].f29892d) {
            C0206a[] aVarArr2 = this.f29886a;
            d2 = aVarArr2[aVarArr2.length - 1].f29892d;
        }
        while (true) {
            C0206a[] aVarArr3 = this.f29886a;
            if (i3 >= aVarArr3.length) {
                return Double.NaN;
            }
            if (d2 > aVarArr3[i3].f29892d) {
                i3++;
            } else if (this.f29886a[i3].f29906r) {
                return i2 == 0 ? this.f29886a[i3].d(d2) : this.f29886a[i3].e(d2);
            } else {
                this.f29886a[i3].a(d2);
                C0206a[] aVarArr4 = this.f29886a;
                return i2 == 0 ? aVarArr4[i3].c() : aVarArr4[i3].d();
            }
        }
    }

    public void b(double d2, double[] dArr) {
        if (d2 < this.f29886a[0].f29891c) {
            d2 = this.f29886a[0].f29891c;
        } else {
            C0206a[] aVarArr = this.f29886a;
            if (d2 > aVarArr[aVarArr.length - 1].f29892d) {
                C0206a[] aVarArr2 = this.f29886a;
                d2 = aVarArr2[aVarArr2.length - 1].f29892d;
            }
        }
        int i2 = 0;
        while (true) {
            C0206a[] aVarArr3 = this.f29886a;
            if (i2 >= aVarArr3.length) {
                return;
            }
            if (d2 > aVarArr3[i2].f29892d) {
                i2++;
            } else if (this.f29886a[i2].f29906r) {
                dArr[0] = this.f29886a[i2].d(d2);
                dArr[1] = this.f29886a[i2].e(d2);
                return;
            } else {
                this.f29886a[i2].a(d2);
                dArr[0] = this.f29886a[i2].c();
                dArr[1] = this.f29886a[i2].d();
                return;
            }
        }
    }
}
