package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.MultiDimensionMismatchException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class MatrixDimensionMismatchException extends MultiDimensionMismatchException {
    private static final long serialVersionUID = -8415396756375798143L;

    public MatrixDimensionMismatchException(int i2, int i3, int i4, int i5) {
        super(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Integer[]{Integer.valueOf(i2), Integer.valueOf(i3)}, new Integer[]{Integer.valueOf(i4), Integer.valueOf(i5)});
    }
}
