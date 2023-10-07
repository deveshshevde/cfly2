package org.apache.commons.math3.linear;

import fg.i;
import java.lang.reflect.Array;
import nl.c;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public abstract class a extends g implements h {
    protected a() {
    }

    protected a(int i2, int i3) {
        if (i2 < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i2));
        } else if (i3 < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i3));
        }
    }

    public double a(i iVar) {
        int d2 = d();
        int e2 = e();
        iVar.a(d2, e2, 0, d2 - 1, 0, e2 - 1);
        for (int i2 = 0; i2 < d2; i2++) {
            for (int i3 = 0; i3 < e2; i3++) {
                iVar.a(i2, i3, b(i2, i3));
            }
        }
        return iVar.a();
    }

    public abstract h a(int i2, int i3);

    public h a(int i2, int i3, int i4, int i5) {
        f.a(this, i2, i3, i4, i5);
        h a2 = a((i3 - i2) + 1, (i5 - i4) + 1);
        for (int i6 = i2; i6 <= i3; i6++) {
            for (int i7 = i4; i7 <= i5; i7++) {
                a2.a(i6 - i2, i7 - i4, b(i6, i7));
            }
        }
        return a2;
    }

    public h a(h hVar) {
        f.a((b) this, (b) hVar);
        int d2 = d();
        int e2 = hVar.e();
        int e3 = e();
        h a2 = a(d2, e2);
        for (int i2 = 0; i2 < d2; i2++) {
            for (int i3 = 0; i3 < e2; i3++) {
                double d3 = i.f27244a;
                for (int i4 = 0; i4 < e3; i4++) {
                    d3 += b(i2, i4) * hVar.b(i4, i3);
                }
                a2.a(i2, i3, d3);
            }
        }
        return a2;
    }

    public j a(int i2) {
        return new ArrayRealVector(b(i2), false);
    }

    public j a(j jVar) {
        try {
            return new ArrayRealVector(a(((ArrayRealVector) jVar).b()), false);
        } catch (ClassCastException unused) {
            int d2 = d();
            int e2 = e();
            if (jVar.c() == e2) {
                double[] dArr = new double[d2];
                for (int i2 = 0; i2 < d2; i2++) {
                    double d3 = i.f27244a;
                    for (int i3 = 0; i3 < e2; i3++) {
                        d3 += b(i2, i3) * jVar.a(i3);
                    }
                    dArr[i2] = d3;
                }
                return new ArrayRealVector(dArr, false);
            }
            throw new DimensionMismatchException(jVar.c(), e2);
        }
    }

    public abstract void a(int i2, int i3, double d2);

    public void a(int i2, j jVar) {
        f.a((b) this, i2);
        int e2 = e();
        if (jVar.c() == e2) {
            for (int i3 = 0; i3 < e2; i3++) {
                a(i2, i3, jVar.a(i3));
            }
            return;
        }
        throw new MatrixDimensionMismatchException(1, jVar.c(), 1, e2);
    }

    public void a(int i2, double[] dArr) {
        f.a((b) this, i2);
        int e2 = e();
        if (dArr.length == e2) {
            for (int i3 = 0; i3 < e2; i3++) {
                a(i2, i3, dArr[i3]);
            }
            return;
        }
        throw new MatrixDimensionMismatchException(1, dArr.length, 1, e2);
    }

    public void a(double[][] dArr, int i2, int i3) throws NoDataException, DimensionMismatchException, NullArgumentException {
        c.a((Object) dArr);
        int length = dArr.length;
        if (length != 0) {
            int length2 = dArr[0].length;
            if (length2 != 0) {
                int i4 = 1;
                while (i4 < length) {
                    if (dArr[i4].length == length2) {
                        i4++;
                    } else {
                        throw new DimensionMismatchException(length2, dArr[i4].length);
                    }
                }
                f.a((b) this, i2);
                f.b(this, i3);
                f.a((b) this, (length + i2) - 1);
                f.b(this, (length2 + i3) - 1);
                for (int i5 = 0; i5 < length; i5++) {
                    for (int i6 = 0; i6 < length2; i6++) {
                        a(i2 + i5, i3 + i6, dArr[i5][i6]);
                    }
                }
                return;
            }
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    }

    public double[] a(double[] dArr) {
        int d2 = d();
        int e2 = e();
        if (dArr.length == e2) {
            double[] dArr2 = new double[d2];
            for (int i2 = 0; i2 < d2; i2++) {
                double d3 = i.f27244a;
                for (int i3 = 0; i3 < e2; i3++) {
                    d3 += b(i2, i3) * dArr[i3];
                }
                dArr2[i2] = d3;
            }
            return dArr2;
        }
        throw new DimensionMismatchException(dArr.length, e2);
    }

    public double[][] a() {
        int d2 = d();
        int[] iArr = new int[2];
        iArr[1] = e();
        iArr[0] = d2;
        double[][] dArr = (double[][]) Array.newInstance(double.class, iArr);
        for (int i2 = 0; i2 < dArr.length; i2++) {
            double[] dArr2 = dArr[i2];
            for (int i3 = 0; i3 < dArr2.length; i3++) {
                dArr2[i3] = b(i2, i3);
            }
        }
        return dArr;
    }

    public abstract double b(int i2, int i3);

    public double b(i iVar) {
        return a(iVar);
    }

    public h b() {
        final h a2 = a(e(), d());
        b((i) new d() {
            public void a(int i2, int i3, double d2) {
                a2.a(i3, i2, d2);
            }
        });
        return a2;
    }

    public void b(int i2, int i3, double d2) {
        f.a(this, i2, i3);
        a(i2, i3, b(i2, i3) * d2);
    }

    public double[] b(int i2) {
        f.a((b) this, i2);
        int e2 = e();
        double[] dArr = new double[e2];
        for (int i3 = 0; i3 < e2; i3++) {
            dArr[i3] = b(i2, i3);
        }
        return dArr;
    }

    public boolean c() {
        return e() == d();
    }

    public abstract int d();

    public abstract int e();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        int d2 = d();
        int e2 = e();
        if (hVar.e() != e2 || hVar.d() != d2) {
            return false;
        }
        for (int i2 = 0; i2 < d2; i2++) {
            for (int i3 = 0; i3 < e2; i3++) {
                if (b(i2, i3) != hVar.b(i2, i3)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        int d2 = d();
        int e2 = e();
        int i2 = ((217 + d2) * 31) + e2;
        for (int i3 = 0; i3 < d2; i3++) {
            int i4 = 0;
            while (i4 < e2) {
                int i5 = i4 + 1;
                i2 = (i2 * 31) + ((((i3 + 1) * 11) + (i5 * 17)) * c.a(b(i3, i4)));
                i4 = i5;
            }
        }
        return i2;
    }

    public String toString() {
        int d2 = d();
        int e2 = e();
        StringBuffer stringBuffer = new StringBuffer();
        String name = getClass().getName();
        stringBuffer.append(name.substring(name.lastIndexOf(46) + 1));
        stringBuffer.append("{");
        for (int i2 = 0; i2 < d2; i2++) {
            if (i2 > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("{");
            for (int i3 = 0; i3 < e2; i3++) {
                if (i3 > 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append(b(i2, i3));
            }
            stringBuffer.append("}");
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
