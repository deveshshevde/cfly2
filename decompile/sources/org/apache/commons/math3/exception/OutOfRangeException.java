package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;

public class OutOfRangeException extends MathIllegalNumberException {
    private static final long serialVersionUID = 111601815794403609L;

    /* renamed from: a  reason: collision with root package name */
    private final Number f32535a;

    /* renamed from: b  reason: collision with root package name */
    private final Number f32536b;

    public OutOfRangeException(Localizable localizable, Number number, Number number2, Number number3) {
        super(localizable, number, number2, number3);
        this.f32535a = number2;
        this.f32536b = number3;
    }
}
