package org.apache.commons.math3.linear;

import fg.i;
import java.io.Serializable;
import java.lang.reflect.Array;
import nl.c;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class Array2DRowRealMatrix extends a implements Serializable {
    private static final long serialVersionUID = -1067294169172445528L;

    /* renamed from: a  reason: collision with root package name */
    private double[][] f32697a;

    public Array2DRowRealMatrix() {
    }

    public Array2DRowRealMatrix(int i2, int i3) {
        super(i2, i3);
        int[] iArr = new int[2];
        iArr[1] = i3;
        iArr[0] = i2;
        this.f32697a = (double[][]) Array.newInstance(double.class, iArr);
    }

    public Array2DRowRealMatrix(double[][] dArr) throws DimensionMismatchException, NoDataException, NullArgumentException {
        a(dArr);
    }

    public Array2DRowRealMatrix(double[][] dArr, boolean z2) {
        if (z2) {
            a(dArr);
        } else if (dArr != null) {
            int length = dArr.length;
            if (length != 0) {
                int length2 = dArr[0].length;
                if (length2 != 0) {
                    int i2 = 1;
                    while (i2 < length) {
                        if (dArr[i2].length == length2) {
                            i2++;
                        } else {
                            throw new DimensionMismatchException(dArr[i2].length, length2);
                        }
                    }
                    this.f32697a = dArr;
                    return;
                }
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
            }
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
        } else {
            throw new NullArgumentException();
        }
    }

    private void a(double[][] dArr) throws DimensionMismatchException, NoDataException, NullArgumentException {
        a(dArr, 0, 0);
    }

    private double[][] f() {
        int d2 = d();
        int[] iArr = new int[2];
        iArr[1] = e();
        iArr[0] = d2;
        double[][] dArr = (double[][]) Array.newInstance(double.class, iArr);
        for (int i2 = 0; i2 < d2; i2++) {
            double[][] dArr2 = this.f32697a;
            System.arraycopy(dArr2[i2], 0, dArr[i2], 0, dArr2[i2].length);
        }
        return dArr;
    }

    public double a(i iVar) {
        int d2 = d();
        int e2 = e();
        iVar.a(d2, e2, 0, d2 - 1, 0, e2 - 1);
        for (int i2 = 0; i2 < d2; i2++) {
            double[] dArr = this.f32697a[i2];
            for (int i3 = 0; i3 < e2; i3++) {
                iVar.a(i2, i3, dArr[i3]);
            }
        }
        return iVar.a();
    }

    public h a(int i2, int i3) {
        return new Array2DRowRealMatrix(i2, i3);
    }

    public void a(int i2, int i3, double d2) {
        f.a(this, i2, i3);
        this.f32697a[i2][i3] = d2;
    }

    public void a(double[][] dArr, int i2, int i3) {
        if (this.f32697a != null) {
            super.a(dArr, i2, i3);
        } else if (i2 > 0) {
            throw new MathIllegalStateException(LocalizedFormats.FIRST_ROWS_NOT_INITIALIZED_YET, Integer.valueOf(i2));
        } else if (i3 <= 0) {
            c.a((Object) dArr);
            if (dArr.length != 0) {
                int length = dArr[0].length;
                if (length != 0) {
                    int length2 = dArr.length;
                    int[] iArr = new int[2];
                    iArr[1] = length;
                    iArr[0] = length2;
                    this.f32697a = (double[][]) Array.newInstance(double.class, iArr);
                    int i4 = 0;
                    while (true) {
                        double[][] dArr2 = this.f32697a;
                        if (i4 >= dArr2.length) {
                            return;
                        }
                        if (dArr[i4].length == length) {
                            System.arraycopy(dArr[i4], 0, dArr2[i4 + i2], i3, length);
                            i4++;
                        } else {
                            throw new DimensionMismatchException(dArr[i4].length, length);
                        }
                    }
                } else {
                    throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
                }
            } else {
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
            }
        } else {
            throw new MathIllegalStateException(LocalizedFormats.FIRST_COLUMNS_NOT_INITIALIZED_YET, Integer.valueOf(i3));
        }
    }

    public double[] a(double[] dArr) {
        int d2 = d();
        int e2 = e();
        if (dArr.length == e2) {
            double[] dArr2 = new double[d2];
            for (int i2 = 0; i2 < d2; i2++) {
                double[] dArr3 = this.f32697a[i2];
                double d3 = i.f27244a;
                for (int i3 = 0; i3 < e2; i3++) {
                    d3 += dArr3[i3] * dArr[i3];
                }
                dArr2[i2] = d3;
            }
            return dArr2;
        }
        throw new DimensionMismatchException(dArr.length, e2);
    }

    public double[][] a() {
        return f();
    }

    public double b(int i2, int i3) {
        f.a(this, i2, i3);
        return this.f32697a[i2][i3];
    }

    public void b(int i2, int i3, double d2) {
        f.a(this, i2, i3);
        double[] dArr = this.f32697a[i2];
        dArr[i3] = dArr[i3] * d2;
    }

    public int d() {
        double[][] dArr = this.f32697a;
        if (dArr == null) {
            return 0;
        }
        return dArr.length;
    }

    public int e() {
        double[][] dArr = this.f32697a;
        if (dArr == null || dArr[0] == null) {
            return 0;
        }
        return dArr[0].length;
    }
}
