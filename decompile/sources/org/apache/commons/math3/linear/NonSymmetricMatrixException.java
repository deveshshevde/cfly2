package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NonSymmetricMatrixException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -7518495577824189882L;

    /* renamed from: a  reason: collision with root package name */
    private final int f32705a;

    /* renamed from: b  reason: collision with root package name */
    private final int f32706b;

    /* renamed from: c  reason: collision with root package name */
    private final double f32707c;

    public NonSymmetricMatrixException(int i2, int i3, double d2) {
        super(LocalizedFormats.NON_SYMMETRIC_MATRIX, Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2));
        this.f32705a = i2;
        this.f32706b = i3;
        this.f32707c = d2;
    }
}
