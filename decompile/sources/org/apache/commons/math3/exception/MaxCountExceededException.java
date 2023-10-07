package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;

public class MaxCountExceededException extends MathIllegalStateException {
    private static final long serialVersionUID = 4330003017885151975L;

    /* renamed from: a  reason: collision with root package name */
    private final Number f32530a;

    public MaxCountExceededException(Localizable localizable, Number number, Object... objArr) {
        a().a(localizable, number, objArr);
        this.f32530a = number;
    }
}
