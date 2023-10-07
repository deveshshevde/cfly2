package org.apache.commons.math3.linear;

import fg.i;
import java.io.Serializable;
import java.lang.reflect.Array;
import nl.b;
import nl.c;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class BlockRealMatrix extends a implements Serializable {
    private static final long serialVersionUID = 4991895511313664478L;

    /* renamed from: a  reason: collision with root package name */
    private final double[][] f32700a;

    /* renamed from: b  reason: collision with root package name */
    private final int f32701b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32702c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32703d;

    /* renamed from: e  reason: collision with root package name */
    private final int f32704e;

    public BlockRealMatrix(int i2, int i3) {
        super(i2, i3);
        this.f32701b = i2;
        this.f32702c = i3;
        this.f32703d = ((i2 + 52) - 1) / 52;
        this.f32704e = ((i3 + 52) - 1) / 52;
        this.f32700a = c(i2, i3);
    }

    public BlockRealMatrix(int i2, int i3, double[][] dArr, boolean z2) {
        super(i2, i3);
        this.f32701b = i2;
        this.f32702c = i3;
        int i4 = ((i2 + 52) - 1) / 52;
        this.f32703d = i4;
        int i5 = ((i3 + 52) - 1) / 52;
        this.f32704e = i5;
        if (z2) {
            this.f32700a = new double[(i4 * i5)][];
        } else {
            this.f32700a = dArr;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f32703d; i7++) {
            int c2 = c(i7);
            int i8 = 0;
            while (i8 < this.f32704e) {
                if (dArr[i6].length == d(i8) * c2) {
                    if (z2) {
                        this.f32700a[i6] = (double[]) dArr[i6].clone();
                    }
                    i8++;
                    i6++;
                } else {
                    throw new DimensionMismatchException(dArr[i6].length, c2 * d(i8));
                }
            }
        }
    }

    public BlockRealMatrix(double[][] dArr) {
        this(dArr.length, dArr[0].length, a(dArr), false);
    }

    private void a(double[] dArr, int i2, int i3, int i4, int i5, int i6, double[] dArr2, int i7, int i8, int i9) {
        int i10 = i6 - i5;
        int i11 = (i3 * i2) + i5;
        int i12 = (i8 * i7) + i9;
        while (i3 < i4) {
            System.arraycopy(dArr, i11, dArr2, i12, i10);
            i11 += i2;
            i12 += i7;
            i3++;
        }
    }

    public static double[][] a(double[][] dArr) {
        double[][] dArr2 = dArr;
        int length = dArr2.length;
        int length2 = dArr2[0].length;
        int i2 = ((length + 52) - 1) / 52;
        int i3 = ((length2 + 52) - 1) / 52;
        int i4 = 0;
        while (i4 < dArr2.length) {
            int length3 = dArr2[i4].length;
            if (length3 == length2) {
                i4++;
            } else {
                throw new DimensionMismatchException(length2, length3);
            }
        }
        double[][] dArr3 = new double[(i2 * i3)][];
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = i6 * 52;
            int a2 = b.a(i7 + 52, length);
            int i8 = a2 - i7;
            int i9 = 0;
            while (i9 < i3) {
                int i10 = i9 * 52;
                int a3 = b.a(i10 + 52, length2) - i10;
                double[] dArr4 = new double[(i8 * a3)];
                dArr3[i5] = dArr4;
                int i11 = length;
                int i12 = i7;
                int i13 = 0;
                while (true) {
                    int i14 = length2;
                    if (i12 >= a2) {
                        break;
                    }
                    System.arraycopy(dArr2[i12], i10, dArr4, i13, a3);
                    i13 += a3;
                    i12++;
                    length2 = i14;
                }
                i5++;
                i9++;
                length = i11;
            }
            int i15 = length;
            int i16 = length2;
        }
        return dArr3;
    }

    private int c(int i2) {
        if (i2 == this.f32703d - 1) {
            return this.f32701b - (i2 * 52);
        }
        return 52;
    }

    public static double[][] c(int i2, int i3) {
        int i4 = ((i2 + 52) - 1) / 52;
        int i5 = ((i3 + 52) - 1) / 52;
        double[][] dArr = new double[(i4 * i5)][];
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = i7 * 52;
            int a2 = b.a(i8 + 52, i2) - i8;
            for (int i9 = 0; i9 < i5; i9++) {
                int i10 = i9 * 52;
                dArr[i6] = new double[((b.a(i10 + 52, i3) - i10) * a2)];
                i6++;
            }
        }
        return dArr;
    }

    private int d(int i2) {
        if (i2 == this.f32704e - 1) {
            return this.f32702c - (i2 * 52);
        }
        return 52;
    }

    public double a(i iVar) {
        int i2 = this.f32701b;
        int i3 = this.f32702c;
        iVar.a(i2, i3, 0, i2 - 1, 0, i3 - 1);
        for (int i4 = 0; i4 < this.f32703d; i4++) {
            int i5 = i4 * 52;
            int a2 = b.a(i5 + 52, this.f32701b);
            for (int i6 = i5; i6 < a2; i6++) {
                for (int i7 = 0; i7 < this.f32704e; i7++) {
                    int d2 = d(i7);
                    int i8 = i7 * 52;
                    int a3 = b.a(i8 + 52, this.f32702c);
                    double[] dArr = this.f32700a[(this.f32704e * i4) + i7];
                    int i9 = (i6 - i5) * d2;
                    while (i8 < a3) {
                        iVar.a(i6, i8, dArr[i9]);
                        i9++;
                        i8++;
                    }
                }
            }
        }
        return iVar.a();
    }

    public BlockRealMatrix a(BlockRealMatrix blockRealMatrix) {
        int i2;
        BlockRealMatrix blockRealMatrix2 = this;
        BlockRealMatrix blockRealMatrix3 = blockRealMatrix;
        f.a((b) this, (b) blockRealMatrix);
        BlockRealMatrix blockRealMatrix4 = new BlockRealMatrix(blockRealMatrix2.f32701b, blockRealMatrix3.f32702c);
        int i3 = 0;
        int i4 = 0;
        while (i3 < blockRealMatrix4.f32703d) {
            int i5 = i3 * 52;
            int a2 = b.a(i5 + 52, blockRealMatrix2.f32701b);
            int i6 = 0;
            while (i6 < blockRealMatrix4.f32704e) {
                int d2 = blockRealMatrix4.d(i6);
                int i7 = d2 + d2;
                int i8 = i7 + d2;
                int i9 = i8 + d2;
                double[] dArr = blockRealMatrix4.f32700a[i4];
                int i10 = 0;
                while (i10 < blockRealMatrix2.f32704e) {
                    int d3 = blockRealMatrix2.d(i10);
                    BlockRealMatrix blockRealMatrix5 = blockRealMatrix4;
                    double[] dArr2 = blockRealMatrix2.f32700a[(blockRealMatrix2.f32704e * i3) + i10];
                    double[] dArr3 = blockRealMatrix3.f32700a[(blockRealMatrix3.f32704e * i10) + i6];
                    int i11 = i5;
                    int i12 = 0;
                    while (i11 < a2) {
                        int i13 = (i11 - i5) * d3;
                        int i14 = i13 + d3;
                        int i15 = i5;
                        int i16 = 0;
                        while (i16 < d2) {
                            double d4 = i.f27244a;
                            int i17 = i16;
                            int i18 = a2;
                            int i19 = i13;
                            while (true) {
                                i2 = d3;
                                if (i19 >= i14 - 3) {
                                    break;
                                }
                                d4 += (dArr2[i19] * dArr3[i17]) + (dArr2[i19 + 1] * dArr3[i17 + d2]) + (dArr2[i19 + 2] * dArr3[i17 + i7]) + (dArr2[i19 + 3] * dArr3[i17 + i8]);
                                i19 += 4;
                                i17 += i9;
                                d3 = i2;
                            }
                            while (i19 < i14) {
                                d4 += dArr2[i19] * dArr3[i17];
                                i17 += d2;
                                i19++;
                            }
                            dArr[i12] = dArr[i12] + d4;
                            i12++;
                            i16++;
                            a2 = i18;
                            d3 = i2;
                        }
                        int i20 = a2;
                        int i21 = d3;
                        i11++;
                        BlockRealMatrix blockRealMatrix6 = blockRealMatrix;
                        i5 = i15;
                    }
                    int i22 = i5;
                    int i23 = a2;
                    i10++;
                    blockRealMatrix2 = this;
                    blockRealMatrix3 = blockRealMatrix;
                    blockRealMatrix4 = blockRealMatrix5;
                }
                BlockRealMatrix blockRealMatrix7 = blockRealMatrix4;
                int i24 = i5;
                int i25 = a2;
                i4++;
                i6++;
                blockRealMatrix2 = this;
                blockRealMatrix3 = blockRealMatrix;
            }
            BlockRealMatrix blockRealMatrix8 = blockRealMatrix4;
            i3++;
            blockRealMatrix2 = this;
            blockRealMatrix3 = blockRealMatrix;
        }
        return blockRealMatrix4;
    }

    public j a(int i2) {
        f.a((b) this, i2);
        double[] dArr = new double[this.f32702c];
        int i3 = i2 / 52;
        int i4 = i2 - (i3 * 52);
        int i5 = 0;
        for (int i6 = 0; i6 < this.f32704e; i6++) {
            int d2 = d(i6);
            System.arraycopy(this.f32700a[(this.f32704e * i3) + i6], i4 * d2, dArr, i5, d2);
            i5 += d2;
        }
        return new ArrayRealVector(dArr, false);
    }

    public void a(int i2, int i3, double d2) {
        f.a(this, i2, i3);
        int i4 = i2 / 52;
        int i5 = i3 / 52;
        this.f32700a[(i4 * this.f32704e) + i5][((i2 - (i4 * 52)) * d(i5)) + (i3 - (i5 * 52))] = d2;
    }

    public void a(int i2, j jVar) {
        try {
            a(i2, ((ArrayRealVector) jVar).b());
        } catch (ClassCastException unused) {
            super.a(i2, jVar);
        }
    }

    public void a(int i2, double[] dArr) {
        f.a((b) this, i2);
        int e2 = e();
        if (dArr.length == e2) {
            int i3 = i2 / 52;
            int i4 = i2 - (i3 * 52);
            int i5 = 0;
            for (int i6 = 0; i6 < this.f32704e; i6++) {
                int d2 = d(i6);
                System.arraycopy(dArr, i5, this.f32700a[(this.f32704e * i3) + i6], i4 * d2, d2);
                i5 += d2;
            }
            return;
        }
        throw new MatrixDimensionMismatchException(1, dArr.length, 1, e2);
    }

    public void a(double[][] dArr, int i2, int i3) throws NoDataException, NullArgumentException {
        BlockRealMatrix blockRealMatrix = this;
        double[][] dArr2 = dArr;
        int i4 = i2;
        int i5 = i3;
        c.a((Object) dArr);
        int i6 = 0;
        int length = dArr2[0].length;
        if (length != 0) {
            int length2 = (dArr2.length + i4) - 1;
            int i7 = (i5 + length) - 1;
            f.a(blockRealMatrix, i4, length2, i5, i7);
            int length3 = dArr2.length;
            while (i6 < length3) {
                double[] dArr3 = dArr2[i6];
                if (dArr3.length == length) {
                    i6++;
                } else {
                    throw new DimensionMismatchException(length, dArr3.length);
                }
            }
            int i8 = i4 / 52;
            int i9 = (length2 + 52) / 52;
            int i10 = i5 / 52;
            int i11 = (i7 + 52) / 52;
            while (i8 < i9) {
                int c2 = blockRealMatrix.c(i8);
                int i12 = i8 * 52;
                int b2 = b.b(i4, i12);
                int a2 = b.a(length2 + 1, c2 + i12);
                int i13 = i10;
                while (i13 < i11) {
                    int d2 = blockRealMatrix.d(i13);
                    int i14 = i13 * 52;
                    int b3 = b.b(i5, i14);
                    int i15 = i9;
                    int i16 = length2;
                    int a3 = b.a(i7 + 1, i14 + d2) - b3;
                    int i17 = i7;
                    double[] dArr4 = blockRealMatrix.f32700a[(blockRealMatrix.f32704e * i8) + i13];
                    int i18 = b2;
                    while (i18 < a2) {
                        System.arraycopy(dArr2[i18 - i4], b3 - i5, dArr4, ((i18 - i12) * d2) + (b3 - i14), a3);
                        i18++;
                        dArr2 = dArr;
                        i4 = i2;
                    }
                    i13++;
                    blockRealMatrix = this;
                    dArr2 = dArr;
                    i4 = i2;
                    i9 = i15;
                    length2 = i16;
                    i7 = i17;
                }
                int i19 = i9;
                int i20 = length2;
                int i21 = i7;
                i8++;
                blockRealMatrix = this;
                dArr2 = dArr;
                i4 = i2;
            }
            return;
        }
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    }

    public double[] a(double[] dArr) {
        double[] dArr2 = dArr;
        if (dArr2.length == this.f32702c) {
            double[] dArr3 = new double[this.f32701b];
            for (int i2 = 0; i2 < this.f32703d; i2++) {
                int i3 = i2 * 52;
                int a2 = b.a(i3 + 52, this.f32701b);
                int i4 = 0;
                while (true) {
                    int i5 = this.f32704e;
                    if (i4 >= i5) {
                        break;
                    }
                    double[] dArr4 = this.f32700a[(i5 * i2) + i4];
                    int i6 = i4 * 52;
                    int a3 = b.a(i6 + 52, this.f32702c);
                    int i7 = 0;
                    for (int i8 = i3; i8 < a2; i8++) {
                        double d2 = i.f27244a;
                        int i9 = i6;
                        while (i9 < a3 - 3) {
                            d2 += (dArr4[i7] * dArr2[i9]) + (dArr4[i7 + 1] * dArr2[i9 + 1]) + (dArr4[i7 + 2] * dArr2[i9 + 2]) + (dArr4[i7 + 3] * dArr2[i9 + 3]);
                            i7 += 4;
                            i9 += 4;
                        }
                        while (i9 < a3) {
                            d2 += dArr4[i7] * dArr2[i9];
                            i9++;
                            i7++;
                        }
                        dArr3[i8] = dArr3[i8] + d2;
                    }
                    i4++;
                }
            }
            return dArr3;
        }
        throw new DimensionMismatchException(dArr2.length, this.f32702c);
    }

    public double[][] a() {
        int d2 = d();
        int[] iArr = new int[2];
        iArr[1] = e();
        iArr[0] = d2;
        double[][] dArr = (double[][]) Array.newInstance(double.class, iArr);
        int i2 = this.f32702c - ((this.f32704e - 1) * 52);
        for (int i3 = 0; i3 < this.f32703d; i3++) {
            int i4 = i3 * 52;
            int a2 = b.a(i4 + 52, this.f32701b);
            int i5 = 0;
            int i6 = 0;
            while (i4 < a2) {
                double[] dArr2 = dArr[i4];
                int i7 = this.f32704e * i3;
                int i8 = 0;
                int i9 = 0;
                while (i8 < this.f32704e - 1) {
                    System.arraycopy(this.f32700a[i7], i5, dArr2, i9, 52);
                    i9 += 52;
                    i8++;
                    i7++;
                }
                System.arraycopy(this.f32700a[i7], i6, dArr2, i9, i2);
                i5 += 52;
                i6 += i2;
                i4++;
            }
        }
        return dArr;
    }

    public double b(int i2, int i3) {
        f.a(this, i2, i3);
        int i4 = i2 / 52;
        int i5 = i3 / 52;
        return this.f32700a[(i4 * this.f32704e) + i5][((i2 - (i4 * 52)) * d(i5)) + (i3 - (i5 * 52))];
    }

    public double b(i iVar) {
        int i2 = this.f32701b;
        int i3 = this.f32702c;
        iVar.a(i2, i3, 0, i2 - 1, 0, i3 - 1);
        int i4 = 0;
        for (int i5 = 0; i5 < this.f32703d; i5++) {
            int i6 = i5 * 52;
            int a2 = b.a(i6 + 52, this.f32701b);
            for (int i7 = 0; i7 < this.f32704e; i7++) {
                int i8 = i7 * 52;
                int a3 = b.a(i8 + 52, this.f32702c);
                double[] dArr = this.f32700a[i4];
                int i9 = 0;
                for (int i10 = i6; i10 < a2; i10++) {
                    for (int i11 = i8; i11 < a3; i11++) {
                        iVar.a(i10, i11, dArr[i9]);
                        i9++;
                    }
                }
                i4++;
            }
        }
        return iVar.a();
    }

    /* renamed from: b */
    public BlockRealMatrix a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        f.a(this, i2, i3, i4, i5);
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix((i3 - i2) + 1, (i5 - i4) + 1);
        int i9 = i2 % 52;
        int i10 = i4 / 52;
        int i11 = i4 % 52;
        int i12 = i2 / 52;
        int i13 = 0;
        while (i13 < blockRealMatrix.f32703d) {
            int c2 = blockRealMatrix.c(i13);
            int i14 = i10;
            int i15 = 0;
            while (i15 < blockRealMatrix.f32704e) {
                int d2 = blockRealMatrix.d(i15);
                double[] dArr = blockRealMatrix.f32700a[(blockRealMatrix.f32704e * i13) + i15];
                int i16 = (this.f32704e * i12) + i14;
                int d3 = d(i14);
                int i17 = c2 + i9;
                int i18 = i17 - 52;
                int i19 = d2 + i11;
                int i20 = i19 - 52;
                if (i18 <= 0) {
                    i8 = i14;
                    i7 = i15;
                    i6 = i13;
                    if (i20 > 0) {
                        int d4 = d(i8 + 1);
                        int i21 = i9;
                        int i22 = i17;
                        double[] dArr2 = dArr;
                        int i23 = d2;
                        a(this.f32700a[i16], d3, i21, i22, i11, 52, dArr2, i23, 0, 0);
                        a(this.f32700a[i16 + 1], d4, i21, i22, 0, i20, dArr2, i23, 0, d2 - i20);
                    } else {
                        a(this.f32700a[i16], d3, i9, i17, i11, i19, dArr, d2, 0, 0);
                    }
                } else if (i20 > 0) {
                    int d5 = d(i14 + 1);
                    int i24 = i9;
                    double[] dArr3 = dArr;
                    i8 = i14;
                    int i25 = d2;
                    i7 = i15;
                    i6 = i13;
                    a(this.f32700a[i16], d3, i24, 52, i11, 52, dArr3, i25, 0, 0);
                    int i26 = d2 - i20;
                    a(this.f32700a[i16 + 1], d5, i24, 52, 0, i20, dArr3, i25, 0, i26);
                    int i27 = i18;
                    int i28 = c2 - i18;
                    a(this.f32700a[i16 + this.f32704e], d3, 0, i27, i11, 52, dArr3, i25, i28, 0);
                    a(this.f32700a[i16 + this.f32704e + 1], d5, 0, i27, 0, i20, dArr3, i25, i28, i26);
                } else {
                    i8 = i14;
                    i7 = i15;
                    i6 = i13;
                    int i29 = d3;
                    int i30 = i11;
                    int i31 = i19;
                    double[] dArr4 = dArr;
                    int i32 = d2;
                    a(this.f32700a[i16], i29, i9, 52, i30, i31, dArr4, i32, 0, 0);
                    a(this.f32700a[i16 + this.f32704e], i29, 0, i18, i30, i31, dArr4, i32, c2 - i18, 0);
                }
                i14 = i8 + 1;
                i15 = i7 + 1;
                i13 = i6;
            }
            i12++;
            i13++;
        }
        return blockRealMatrix;
    }

    /* renamed from: b */
    public BlockRealMatrix a(h hVar) {
        BlockRealMatrix blockRealMatrix = this;
        h hVar2 = hVar;
        try {
            return blockRealMatrix.a((BlockRealMatrix) hVar2);
        } catch (ClassCastException unused) {
            f.a((b) this, (b) hVar);
            BlockRealMatrix blockRealMatrix2 = new BlockRealMatrix(blockRealMatrix.f32701b, hVar.e());
            int i2 = 0;
            int i3 = 0;
            while (i2 < blockRealMatrix2.f32703d) {
                int i4 = i2 * 52;
                int a2 = b.a(i4 + 52, blockRealMatrix.f32701b);
                int i5 = 0;
                while (i5 < blockRealMatrix2.f32704e) {
                    int i6 = i5 * 52;
                    int a3 = b.a(i6 + 52, hVar.e());
                    double[] dArr = blockRealMatrix2.f32700a[i3];
                    int i7 = 0;
                    while (i7 < blockRealMatrix.f32704e) {
                        int d2 = blockRealMatrix.d(i7);
                        double[] dArr2 = blockRealMatrix.f32700a[(blockRealMatrix.f32704e * i2) + i7];
                        int i8 = i7 * 52;
                        int i9 = i4;
                        int i10 = 0;
                        while (i9 < a2) {
                            int i11 = (i9 - i4) * d2;
                            int i12 = i11 + d2;
                            int i13 = i4;
                            int i14 = i6;
                            while (i14 < a3) {
                                double d3 = i.f27244a;
                                int i15 = a2;
                                int i16 = i6;
                                int i17 = i8;
                                for (int i18 = i11; i18 < i12; i18++) {
                                    d3 += dArr2[i18] * hVar2.b(i17, i14);
                                    i17++;
                                }
                                dArr[i10] = dArr[i10] + d3;
                                i10++;
                                i14++;
                                a2 = i15;
                                i6 = i16;
                            }
                            int i19 = a2;
                            int i20 = i6;
                            i9++;
                            i4 = i13;
                        }
                        int i21 = i4;
                        int i22 = a2;
                        int i23 = i6;
                        i7++;
                        blockRealMatrix = this;
                    }
                    int i24 = i4;
                    int i25 = a2;
                    i3++;
                    i5++;
                    blockRealMatrix = this;
                }
                i2++;
                blockRealMatrix = this;
            }
            return blockRealMatrix2;
        }
    }

    public void b(int i2, int i3, double d2) {
        f.a(this, i2, i3);
        int i4 = i2 / 52;
        int i5 = i3 / 52;
        int d3 = ((i2 - (i4 * 52)) * d(i5)) + (i3 - (i5 * 52));
        double[] dArr = this.f32700a[(i4 * this.f32704e) + i5];
        dArr[d3] = dArr[d3] * d2;
    }

    public double[] b(int i2) {
        f.a((b) this, i2);
        double[] dArr = new double[this.f32702c];
        int i3 = i2 / 52;
        int i4 = i2 - (i3 * 52);
        int i5 = 0;
        for (int i6 = 0; i6 < this.f32704e; i6++) {
            int d2 = d(i6);
            System.arraycopy(this.f32700a[(this.f32704e * i3) + i6], i4 * d2, dArr, i5, d2);
            i5 += d2;
        }
        return dArr;
    }

    public int d() {
        return this.f32701b;
    }

    /* renamed from: d */
    public BlockRealMatrix a(int i2, int i3) {
        return new BlockRealMatrix(i2, i3);
    }

    public int e() {
        return this.f32702c;
    }

    /* renamed from: f */
    public BlockRealMatrix b() {
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(e(), d());
        int i2 = 0;
        for (int i3 = 0; i3 < this.f32704e; i3++) {
            for (int i4 = 0; i4 < this.f32703d; i4++) {
                double[] dArr = blockRealMatrix.f32700a[i2];
                double[] dArr2 = this.f32700a[(this.f32704e * i4) + i3];
                int i5 = i3 * 52;
                int a2 = b.a(i5 + 52, this.f32702c);
                int i6 = i4 * 52;
                int a3 = b.a(i6 + 52, this.f32701b);
                int i7 = 0;
                for (int i8 = i5; i8 < a2; i8++) {
                    int i9 = a2 - i5;
                    int i10 = i8 - i5;
                    for (int i11 = i6; i11 < a3; i11++) {
                        dArr[i7] = dArr2[i10];
                        i7++;
                        i10 += i9;
                    }
                }
                i2++;
            }
        }
        return blockRealMatrix;
    }
}
