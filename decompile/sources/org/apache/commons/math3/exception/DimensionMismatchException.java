package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class DimensionMismatchException extends MathIllegalNumberException {
    private static final long serialVersionUID = -8415396756375798143L;

    /* renamed from: a  reason: collision with root package name */
    private final int f32525a;

    public DimensionMismatchException(int i2, int i3) {
        this(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, i2, i3);
    }

    public DimensionMismatchException(Localizable localizable, int i2, int i3) {
        super(localizable, Integer.valueOf(i2), Integer.valueOf(i3));
        this.f32525a = i3;
    }
}
