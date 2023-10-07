package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;

public class MultiDimensionMismatchException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -8415396756375798143L;

    /* renamed from: a  reason: collision with root package name */
    private final Integer[] f32531a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer[] f32532b;

    public MultiDimensionMismatchException(Localizable localizable, Integer[] numArr, Integer[] numArr2) {
        super(localizable, numArr, numArr2);
        this.f32531a = (Integer[]) numArr.clone();
        this.f32532b = (Integer[]) numArr2.clone();
    }
}
