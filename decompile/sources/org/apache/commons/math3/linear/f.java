package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class f {
    public static h a(int i2) {
        h a2 = a(i2, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            a2.a(i3, i3, 1.0d);
        }
        return a2;
    }

    public static h a(int i2, int i3) {
        return i2 * i3 <= 4096 ? new Array2DRowRealMatrix(i2, i3) : new BlockRealMatrix(i2, i3);
    }

    public static h a(double[][] dArr) {
        if (dArr != null && dArr[0] != null) {
            return dArr.length * dArr[0].length <= 4096 ? new Array2DRowRealMatrix(dArr) : new BlockRealMatrix(dArr);
        }
        throw new NullArgumentException();
    }

    public static void a(b bVar, int i2) {
        if (i2 < 0 || i2 >= bVar.d()) {
            throw new OutOfRangeException(LocalizedFormats.ROW_INDEX, Integer.valueOf(i2), 0, Integer.valueOf(bVar.d() - 1));
        }
    }

    public static void a(b bVar, int i2, int i3) {
        a(bVar, i2);
        b(bVar, i3);
    }

    public static void a(b bVar, int i2, int i3, int i4, int i5) {
        a(bVar, i2);
        a(bVar, i3);
        if (i3 >= i2) {
            b(bVar, i4);
            b(bVar, i5);
            if (i5 < i4) {
                throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, Integer.valueOf(i5), Integer.valueOf(i4), false);
            }
            return;
        }
        throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(i3), Integer.valueOf(i2), false);
    }

    public static void a(b bVar, b bVar2) {
        if (bVar.e() != bVar2.d()) {
            throw new DimensionMismatchException(bVar.e(), bVar2.d());
        }
    }

    public static void b(b bVar, int i2) {
        if (i2 < 0 || i2 >= bVar.e()) {
            throw new OutOfRangeException(LocalizedFormats.COLUMN_INDEX, Integer.valueOf(i2), 0, Integer.valueOf(bVar.e() - 1));
        }
    }
}
